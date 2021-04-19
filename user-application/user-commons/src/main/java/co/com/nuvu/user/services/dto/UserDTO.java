package co.com.nuvu.user.services.dto;

import java.io.Serializable;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDTO implements Serializable {

	private static final long serialVersionUID = 5682401769032708707L;
	
	private String id;
	
	@NotEmpty
	private String name;
	
	@NotEmpty
	private String lastName;

	@Email
	private String email;
	
	@NotEmpty
	private String password;
	
	private boolean enabled;
	
	@Valid
	@NotEmpty
	private List<RolDTO> rols;

}
