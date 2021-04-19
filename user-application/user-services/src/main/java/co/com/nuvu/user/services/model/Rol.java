package co.com.nuvu.user.services.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Document
@NoArgsConstructor
public class Rol implements Serializable {

	private static final long serialVersionUID = 3566793399693959930L;

	@Id
	private String id;
	private String name;

}
