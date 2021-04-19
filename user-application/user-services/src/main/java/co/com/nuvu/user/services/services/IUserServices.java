package co.com.nuvu.user.services.services;

import java.util.List;

import co.com.nuvu.user.services.dto.UserDTO;

/**
 * Interface que expone los servicios para manejar un usuario
 *
 * @author Michael Vega
 *
 */

public interface IUserServices {

	/**
	 * Devuelve todas las instancias del tipo {@link UserDTO}
	 *
	 * @return todos los usuarios
	 */
	List<UserDTO> findAll();

	/**
	 * Recupera una entidad por su id.
	 *
	 * @param id
	 * @return la entidad con el ID proporcionado o <code>null</code> si no se
	 *         encuentra.
	 */
	UserDTO findByID(String id);

	/**
	 * Recupera un {@link UserDTO} por su correo y su contraseña
	 *
	 * @param id
	 * @return la entidad por los datos proporcionados o <code>null</code> si no se
	 *         encuentra.
	 */
	UserDTO login(String email, String password);

	/**
	 * Recupera un {@link UserDTO} por su correo
	 *
	 * @param id
	 * @return la entidad por los datos proporcionados o <code>null</code> si no se
	 *         encuentra.
	 */
	UserDTO findByUsername(String email);

	/**
	 * Guarda una entidad determinada
	 *
	 * @param creditCard
	 * @return la entidad guardada
	 */
	UserDTO insert(UserDTO user);

	/**
	 * Actualiza la entidad recibida
	 *
	 * @param creditCard
	 * @return la entidad con los nuevos datos
	 */
	UserDTO update(UserDTO user);

	/**
	 * Actualiza la contraseña del usuario recibido
	 *
	 * @param creditCard
	 * @return la entidad con los nuevos datos
	 */
	UserDTO updatePassword(UserDTO user, String newPassword);

	/**
	 * Elimina una entidad por su id
	 *
	 * @param id
	 */
	void delete(String id);

}
