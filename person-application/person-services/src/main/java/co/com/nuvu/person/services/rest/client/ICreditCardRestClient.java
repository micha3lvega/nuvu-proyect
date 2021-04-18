package co.com.nuvu.person.services.rest.client;

import java.util.List;

import javax.validation.Valid;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import co.com.nuvu.credit.card.dto.CreditCardDTO;
import co.com.nuvu.credit.card.helpers.CardType;
import co.com.nuvu.person.commons.dto.PersonDTO;

@FeignClient(name = "credit-card-services")
public interface ICreditCardRestClient {

	@GetMapping("/api/v1")
	List<CreditCardDTO> findAll();

	@GetMapping("/api/v1/{id}")
	CreditCardDTO finById(@PathVariable("id") String id);

	@GetMapping("/api/v1/cardtype/{number}")
	CardType detectCardType(@PathVariable("number") String number);

	@PostMapping("/api/v1/encrypt")
	String encrypt(@Valid @RequestBody PersonDTO person);

	@PostMapping("/api/v1/decrypt")
	String decrypt(@Valid @RequestBody PersonDTO person);

	@PostMapping("/api/v1")
	CreditCardDTO insert(@Valid @RequestBody CreditCardDTO card);

	@PutMapping("/api/v1")
	CreditCardDTO update(@Valid @RequestBody CreditCardDTO card);

	@DeleteMapping("/api/v1/{id}")
	void delete(@PathVariable("id") String id);
}