package co.com.nuvu.auth.server.rest.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import co.com.nuvu.user.services.dto.UserDTO;

@FeignClient("user-services")
public interface IUserRestClient {

	@GetMapping("/api/v1/username/{email}")
	UserDTO findByUsername(@PathVariable("email") String email);

}
