package co.com.nuvu.person.services.services;

import java.util.List;

import co.com.nuvu.person.commons.dto.PersonDTO;

public interface IPersonServices {

	void delete(String id);

	List<PersonDTO> findAll();

	PersonDTO findByID(String id);

	PersonDTO insert(PersonDTO person);

	PersonDTO update(PersonDTO person);

}
