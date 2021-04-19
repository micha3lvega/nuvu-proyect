/**
 *
 */
package co.com.nuvu.person.services.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.nuvu.credit.card.dto.CreditCardDTO;
import co.com.nuvu.credit.card.helpers.CardType;
import co.com.nuvu.person.commons.dto.PersonDTO;
import co.com.nuvu.person.services.exception.PersonNotExistsExcepction;
import co.com.nuvu.person.services.model.Person;
import co.com.nuvu.person.services.repository.IPersonRepository;
import co.com.nuvu.person.services.rest.client.ICreditCardRestClient;
import co.com.nuvu.person.services.services.IPersonServices;

/**
 * Clase que define los metodos de la clase {@link IPersonServices}
 *
 * @author Michael Vega
 *
 */
@Service
public class PersonServices implements IPersonServices {

	@Autowired
	private ICreditCardRestClient cardServices;

	@Autowired
	private IPersonRepository repository;

	@Autowired
	private ModelMapper mapper;

	@Override
	public List<PersonDTO> findAll() {
		return repository.findAll().stream().map(person -> mapper.map(person, PersonDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public PersonDTO findByID(String id) {

		// Buscar la entidad de persona
		Person person = repository.findById(id).orElseThrow(PersonNotExistsExcepction::new);
		return mapper.map(person, PersonDTO.class);

	}

	@Override
	public PersonDTO findPersonWithDecriptCreditCard(String id) {

		// Buscar la persona
		Person person = repository.findById(id).orElseThrow(PersonNotExistsExcepction::new);

		// Desencriptar la tarjeta de credito
		String decryptNumber = cardServices.decrypt(mapper.map(person, PersonDTO.class));
		person.getCreditCard().setNumber(decryptNumber);

		// retornar la persona
		return mapper.map(person, PersonDTO.class);

	}

	@Override
	public PersonDTO insert(PersonDTO person) {

		// Validar el tipo de tarjeta de credito
		if (person.getCreditCard().getCardType() == null) {

			// Obtener el tipo de tarjeta de credito
			CardType cardType = cardServices.detectCardType(person.getCreditCard().getNumber());
			person.getCreditCard().setCardType(cardType);

		}

		// Encriptar la tarjeta de credito
		String encryptCreditCard = cardServices.encrypt(person);
		person.getCreditCard().setNumber(encryptCreditCard);

		// Guardar la tarjeta de credito
		CreditCardDTO creditCard = cardServices.insert(person.getCreditCard());
		person.setCreditCard(creditCard);

		// Guardar la persona
		Person newPerson = repository.insert(mapper.map(person, Person.class));

		// retornar la entidad
		return mapper.map(newPerson, PersonDTO.class);
	}

	@Override
	public PersonDTO update(PersonDTO person) {

		// Buscar la entidad
		Person oldPerson = repository.findById(person.getId()).orElseThrow(PersonNotExistsExcepction::new);

		// Validar si cambio algun dato de la tarjeta de credito
		if (!oldPerson.getCreditCard().equals(person.getCreditCard())) {

			// Validar si cambio el numero de la tarjeta de credito
			if ((oldPerson.getCreditCard() != null) && !oldPerson.getCreditCard().getNumber().equals(person.getCreditCard().getNumber())) {

				// Obtener el tipo de tarjeta de credito
				CardType cardType = cardServices.detectCardType(person.getCreditCard().getNumber());
				person.getCreditCard().setCardType(cardType);

				// Encriptar la tarjeta de credito
				String encryptCreditCard = cardServices.encrypt(person);
				person.getCreditCard().setNumber(encryptCreditCard);

			}

			// Guardar la tarjeta de credito
			CreditCardDTO creditCard = cardServices.update(person.getCreditCard());
			person.setCreditCard(creditCard);

		}

		// Actualizar la persona
		oldPerson = repository.save(mapper.map(person, Person.class));

		return mapper.map(oldPerson, PersonDTO.class);

	}

	@Override
	public void delete(String id) {

		// Buscar la entidad de persona
		Person person = repository.findById(id).orElseThrow(PersonNotExistsExcepction::new);

		// Eliminar tarjeta de credito
		cardServices.delete(person.getCreditCard().getId());

		// Eliminar la persona
		repository.delete(person);

	}

}
