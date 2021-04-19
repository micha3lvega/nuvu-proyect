package co.com.nuvu.auth.server.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import co.com.nuvu.auth.server.rest.client.IUserRestClient;
import co.com.nuvu.user.services.dto.UserDTO;

@Service
public class UserServices implements UserDetailsService {

	@Autowired
	private IUserRestClient client;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		UserDTO user = client.findByUsername(username);

		if (user == null) {
			throw new UsernameNotFoundException("Usuario o contraseña incorrectas");
		}

		List<GrantedAuthority> authorities = user.getRols().stream().map(rol -> new SimpleGrantedAuthority(rol.getName())).collect(Collectors.toList());

		return new User(user.getEmail(), user.getPassword(), user.isEnabled(), true, true, true, authorities);
	}

}
