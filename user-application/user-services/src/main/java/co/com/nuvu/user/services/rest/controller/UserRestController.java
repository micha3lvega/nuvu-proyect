package co.com.nuvu.user.services.rest.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.nuvu.user.services.dto.UserDTO;
import co.com.nuvu.user.services.services.IUserServices;

@RestController
@RequestMapping("/api/v1")
public class UserRestController {

	@Autowired
	private IUserServices service;

	@GetMapping
	public List<UserDTO> findAll() {
		return service.findAll();
	}

	@GetMapping("/{id}")
	public UserDTO findByID(@PathVariable("id") String id) {
		return service.findByID(id);
	}

	@GetMapping("/login/{email}/{password}")
	public UserDTO login(@PathVariable("email") String email, @PathVariable("password") String password) {
		return service.login(email, password);
	}

	@GetMapping("/username/{email}")
	public UserDTO findByUsername(@PathVariable("email") String email) {
		return service.findByUsername(email);
	}

	@PostMapping
	public UserDTO insert(@Valid @RequestBody UserDTO user) {
		return service.insert(user);
	}

	@PutMapping
	public UserDTO update(@Valid @RequestBody UserDTO user) {
		return service.update(user);
	}

	@PutMapping("/password/{password}")
	public UserDTO updatePassword(@Valid @RequestBody UserDTO user, @PathVariable("password") String password) {
		return service.updatePassword(user, password);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") String id) {
		service.delete(id);
	}

}
