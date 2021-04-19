package co.com.nuvu.user.services.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RolDTO implements Serializable {

	private static final long serialVersionUID = -329456581490269365L;
	private String id;
	private String name;

}
