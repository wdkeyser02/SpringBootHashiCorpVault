package willydekeyser.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import willydekeyser.model.Authorities;
import willydekeyser.service.AuthoritiesService;

@RestController
public class AuthoritiesController {

	private final AuthoritiesService authoritiesService;
	
	public AuthoritiesController(AuthoritiesService authoritiesService) {
		this.authoritiesService = authoritiesService;
	}

	@GetMapping("/")
	public List<Authorities> findAll() {
		return authoritiesService.findAll();
	}
}
