package app.service;

import com.fasterxml.jackson.databind.JsonNode;

import app.client.GenericApiClient;
import app.entity.FieldMapping;
import app.entity.IntegrationConfig;
import app.entity.TempUser;
import app.repository.FieldMappingRepository;
import app.repository.IntegrationConfigRepository;
import app.repository.TempUserRepository;

import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class IntegrationService {

    private final IntegrationConfigRepository configRepo;
    private final FieldMappingRepository mappingRepo;
    private final GenericApiClient apiClient;
    private final TempUserRepository tempUserRepo;

    public IntegrationService(
            IntegrationConfigRepository configRepo,
            FieldMappingRepository mappingRepo,
            GenericApiClient apiClient,
            TempUserRepository tempUserRepo
    ) {
        this.configRepo = configRepo;
        this.mappingRepo = mappingRepo;
        this.apiClient = apiClient;
        this.tempUserRepo = tempUserRepo;
    }

    @Transactional
    public void fetchUsers(String integrationName) throws Exception {

        tempUserRepo.deleteAll();

        IntegrationConfig config = configRepo.findByNameIgnoreCase(integrationName)
                .orElseThrow(() ->
                        new IllegalArgumentException("Integration not found: " + integrationName)
                );

        List<FieldMapping> mappings = mappingRepo.findByIntegrationId(config.getId());

        String fullUrl = config.getBaseUrl() + config.getUserEndpoint();

        Map<String, String> headers = new HashMap<>();
        if ("BEARER_TOKEN".equalsIgnoreCase(config.getAuthType())) {
            headers.put("Authorization", "Bearer " + config.getAuthToken());
            headers.put("Accept", "application/json");
        }

        String nextPageToken = null;
        int safetyCounter = 0;

        do {
            Map<String, Object> params = new HashMap<>();
            if (nextPageToken != null) {
                params.put(config.getPaginationParam(), nextPageToken);
            }

            JsonNode resp = apiClient.callApi(
                    fullUrl,
                    HttpMethod.GET,
                    headers,
                    params
            );

            JsonNode dataNode =
                    resp.has("collection") ? resp.get("collection") :
                    resp.has("resource")   ? resp.get("resource")   :
                    resp;

            if (dataNode.isArray()) {
                for (JsonNode item : dataNode) {
                    saveUser(item, mappings);
                }
            } else if (dataNode.isObject()) {
                saveUser(dataNode, mappings);
            }

            if (resp.has("pagination") && resp.get("pagination").has("next_page")) {
                JsonNode next = resp.get("pagination").get("next_page");
                nextPageToken = next.isNull() ? null : next.asText();
            } else {
                nextPageToken = null;
            }

            safetyCounter++;
            if (safetyCounter > 50) {
                throw new RuntimeException("Pagination safety limit reached");
            }

        } while (nextPageToken != null);
    }

    private void saveUser(JsonNode item, List<FieldMapping> mappings) {

        TempUser user = new TempUser();

        for (FieldMapping m : mappings) {
            JsonNode valueNode = item.at(jsonPointerFor(m.getExternalField()));
            if (!valueNode.isMissingNode()) {
                String value = valueNode.isNull() ? null : valueNode.asText();

                if ("email".equalsIgnoreCase(m.getInternalField())) {
                    user.setEmail(value);
                }
                if ("name".equalsIgnoreCase(m.getInternalField())) {
                    user.setName(value);
                }
            }
        }

        user.setRawJson(item.toString());
        tempUserRepo.save(user);
    }

    // -------- JSON POINTER HELPER --------
    private String jsonPointerFor(String externalField) {
        if (externalField == null) return "";
        String[] parts = externalField.split("\\.");
        StringBuilder sb = new StringBuilder();
        for (String p : parts) {
            sb.append('/').append(p);
        }
        return sb.toString();
    }
}