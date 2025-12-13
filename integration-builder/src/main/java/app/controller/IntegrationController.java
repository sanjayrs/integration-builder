package app.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.entity.TempUser;
import app.repository.TempUserRepository;
import app.service.IntegrationService;


@RestController
@RequestMapping("/integrations")
public class IntegrationController {

	private final IntegrationService integrationService;
	private final TempUserRepository tempUserRepo;

	public IntegrationController(IntegrationService integrationService, TempUserRepository tempUserRepo) {
		this.integrationService = integrationService;
		this.tempUserRepo = tempUserRepo;
	}

	@GetMapping("/{name}/fetch-users")
	public ResponseEntity<String> fetchUsers(@PathVariable String name) {
		try {
			integrationService.fetchUsers(name);
			return ResponseEntity.ok("Users fetched and stored in temp_user table");
		} catch (Exception e) {
			return ResponseEntity.status(500).body("Failed: " + e.getMessage());
		}
	}

	@GetMapping("/temp-users")
	public ResponseEntity<List<TempUser>> getTempUsers() {
		return ResponseEntity.ok(tempUserRepo.findAll());
	}

}
