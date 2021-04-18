package co.com.nuvu.credit.card.services;

import java.util.List;

import co.com.nuvu.credit.card.dto.CreditCardDTO;

/**
 * Interface que expone los servicios para manejar una tarjeta de credito
 * 
 * @author Michael Vega
 *
 */
public interface ICreditCardServices {

	/**
	 * Devuelve todas las instancias del tipo {@link CreditCardDTO}
	 * 
	 * @return todas las tarjetas de credito
	 */
	List<CreditCardDTO> findAll();

	/**
	 * Recupera una entidad por su id.
	 * 
	 * @param id
	 * @return la entidad con el ID proporcionado o <code>null</code> si no se
	 *         encuentra.
	 */
	CreditCardDTO findById(String id);

	/**
	 * Guarda una entidad determinada
	 * 
	 * @param creditCard
	 * @return la entidad guardada
	 */
	CreditCardDTO create(CreditCardDTO creditCard);

	/**
	 * Actualiza la entidad recibida
	 * 
	 * @param creditCard
	 * @return la entidad con los nuevos datos
	 */
	CreditCardDTO update(CreditCardDTO creditCard);

	/**
	 * Elimina una entidad por su id
	 * 
	 * @param id
	 */
	void delete(String id);

}
