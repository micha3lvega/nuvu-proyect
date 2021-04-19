package co.com.nuvu.person.services.services;

import java.util.List;

import co.com.nuvu.credit.card.dto.CreditCardDTO;
import co.com.nuvu.person.commons.dto.PersonDTO;
import co.com.nuvu.person.services.exception.PersonNotExistsExcepction;
import co.com.nuvu.person.services.model.Person;

/**
 * Clase que expone los servicios para la entidad de {@link Person}
 *
 * @author Michael Vega
 *
 */
public interface IPersonServices {

	/**
	 * Elimina una entidad por su id
	 *
	 * @param id
	 */
	void delete(String id);

	/**
	 * Devuelve todas las instancias del tipo {@link PersonDTO}
	 *
	 * @return todas las personas
	 */
	List<PersonDTO> findAll();

	/**
	 * Recupera una entidad por su id.
	 *
	 * @param id
	 * @return la entidad con el ID proporcionado o lanza una excepcion de tipo
	 *         {@link PersonNotExistsExcepction}
	 */
	PersonDTO findByID(String id);

	/**
	 * Busca una persona por su id y obtiene el numero de la {@link CreditCardDTO}
	 * desencriptado
	 *
	 * @param id
	 * @return la entidad {@link PersonDTO} con la entidad {@link CreditCardDTO} y
	 *         su numero desecriptado
	 */
	PersonDTO findPersonWithDecriptCreditCard(String id);

	/**
	 * Guarda una entidad determinada
	 *
	 * @param creditCard
	 * @return la entidad guardada
	 */
	PersonDTO insert(PersonDTO person);

	/**
	 * Actualiza la entidad recibida
	 *
	 * @param creditCard
	 * @return la entidad con los nuevos datos
	 */
	PersonDTO update(PersonDTO person);

}
