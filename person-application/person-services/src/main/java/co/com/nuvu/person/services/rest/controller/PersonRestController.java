package co.com.nuvu.person.services.rest.controller;

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

import co.com.nuvu.person.commons.dto.PersonDTO;
import co.com.nuvu.person.services.services.IPersonServices;

@RestController
@RequestMapping("/api/v1")
public class PersonRestController {

	@Autowired
	private IPersonServices services;

	@GetMapping
	public List<PersonDTO> findAll() {
		return services.findAll();
	}

	@GetMapping("/{id}")
	public PersonDTO findByID(@PathVariable("id") String id) {
		return services.findByID(id);
	}

	@GetMapping("/decrypt/{id}")
	public PersonDTO findPersonWithDecriptCreditCard(@PathVariable("id") String id) {
		return services.findPersonWithDecriptCreditCard(id);
	}

	@PostMapping
	public PersonDTO insert(@Valid @RequestBody PersonDTO person) {
		return services.insert(person);
	}

	@PutMapping
	public PersonDTO update(@Valid @RequestBody PersonDTO person) {
		return services.update(person);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") String id) {
		services.delete(id);
	}

}
