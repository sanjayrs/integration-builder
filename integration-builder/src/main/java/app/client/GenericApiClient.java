package app.client;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Map;

@Component
public class GenericApiClient {

    private final RestTemplate restTemplate = new RestTemplate();

    public JsonNode callApi(
            String url,
            HttpMethod method,
            Map<String, String> headers,
            Map<String, Object> params
    ) throws Exception {

        HttpHeaders httpHeaders = new HttpHeaders();
        if (headers != null) {
            headers.forEach(httpHeaders::set);
        }

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url);
        if (params != null) {
            params.forEach((k, v) -> builder.queryParam(k, v));
        }

        HttpEntity<Void> entity = new HttpEntity<>(httpHeaders);

        ResponseEntity<String> response = restTemplate.exchange(
                builder.toUriString(),
                method,
                entity,
                String.class
        );

        ObjectMapper mapper = new ObjectMapper();
        return mapper.readTree(response.getBody());
    }
}
