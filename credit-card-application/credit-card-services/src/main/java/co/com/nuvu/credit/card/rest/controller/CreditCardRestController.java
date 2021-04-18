package co.com.nuvu.credit.card.rest.controller;

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

import co.com.nuvu.credit.card.dto.CreditCardDTO;
import co.com.nuvu.credit.card.helpers.CardType;
import co.com.nuvu.credit.card.services.ICreditCardServices;

@RestController
@RequestMapping("/api/v1")
public class CreditCardRestController {

	@Autowired
	private ICreditCardServices service;

	@GetMapping
	public List<CreditCardDTO> findAll() {
		return service.findAll();
	}

	@GetMapping("/{id}")
	public CreditCardDTO finById(@PathVariable("id") String id) {
		return service.findById(id);
	}

	@GetMapping("/cardtype/{number}")
	public CardType detectCardType(@PathVariable("number") String number) {
		return service.detectCardType(number);
	}

	@PostMapping
	public CreditCardDTO insert(@Valid @RequestBody CreditCardDTO card) {
		return service.create(card);
	}

	@PutMapping
	public CreditCardDTO update(@Valid @RequestBody CreditCardDTO card) {
		return service.update(card);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") String id) {
		service.delete(id);
	}

}
