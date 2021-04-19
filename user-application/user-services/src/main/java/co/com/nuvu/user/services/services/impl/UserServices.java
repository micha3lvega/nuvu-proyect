package co.com.nuvu.user.services.services.impl;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import co.com.nuvu.user.services.dto.UserDTO;
import co.com.nuvu.user.services.exception.UserBusinessException;
import co.com.nuvu.user.services.exception.UserLoginException;
import co.com.nuvu.user.services.exception.UserNotExistsExcepction;
import co.com.nuvu.user.services.model.User;
import co.com.nuvu.user.services.repository.IUserRepository;
import co.com.nuvu.user.services.services.IUserServices;

@Service
public class UserServices implements IUserServices {

	@Autowired
	private IUserRepository repository;

	@Autowired
	private BCryptPasswordEncoder encoder;

	@Autowired
	private ModelMapper mapper;

	@Override
	public List<UserDTO> findAll() {
		return repository.findAll().stream().map(user -> mapper.map(user, UserDTO.class)).collect(Collectors.toList());
	}

	@Override
	public UserDTO findByID(String id) {

		// Buscar usuario
		User user = repository.findById(id).orElseThrow(UserNotExistsExcepction::new);

		// Retornar la entidad
		return mapper.map(user, UserDTO.class);
	}

	@Override
	public UserDTO login(String email, String password) {

		// Buscar el usuario
		User user = repository.findByEmail(email);

		if (user == null) {
			throw new UserLoginException("Usuario o contraseña incorrectos");
		}

		if (!user.getEnabled()) {
			throw new UserLoginException("usuario inactivo");
		}

		if ((password == null) || password.isEmpty()) {
			throw new UserLoginException("Usuario o contraseña incorrectos");
		}

		String encodedPassword = encoder.encode(user.getPassword());

		if (!encoder.matches(password, encodedPassword)) {
			throw new UserLoginException("Usuario o contraseña incorrectos");
		}

		return mapper.map(user, UserDTO.class);

	}

	@Override
	public UserDTO findByUsername(String email) {

		// Buscar el usuario
		User user = repository.findByEmail(email);

		// Validar si se encontro el usuario
		if (user == null) {
			throw new UserLoginException("Usuario o contraseña incorrectos");
		}

		// Retornar la entidad
		return mapper.map(user, UserDTO.class);
	}

	@Override
	public UserDTO insert(UserDTO user) {

		// Buscar que no se repita el email
		User userEmail = repository.findByEmail(user.getEmail());

		if (Objects.nonNull(userEmail)) {
			throw new UserBusinessException("El email ya existe en la base de datos");
		}

		// codificar contraseña
		String encodedPassword = encoder.encode(user.getPassword());
		user.setPassword(encodedPassword);

		// Guardar usuario
		User saveUser = repository.insert(mapper.map(user, User.class));

		// Retornar entidad
		return mapper.map(saveUser, UserDTO.class);

	}

	@Override
	public UserDTO update(UserDTO user) {

		// Guardar usuario
		User saveUser = repository.save(mapper.map(user, User.class));

		// Retornar entidad
		return mapper.map(saveUser, UserDTO.class);

	}

	@Override
	public UserDTO updatePassword(UserDTO user, String newPassword) {

		// codificar contraseña
		String encodedPassword = encoder.encode(newPassword);
		user.setPassword(encodedPassword);

		// Guardar usuario
		User saveUser = repository.save(mapper.map(user, User.class));

		// Retornar entidad
		return mapper.map(saveUser, UserDTO.class);

	}

	@Override
	public void delete(String id) {

		// Buscar la entidad
		User user = repository.findById(id).orElseThrow(UserNotExistsExcepction::new);

		repository.delete(user);

	}

}
