package co.com.nuvu.user.services.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Document
@AllArgsConstructor
public class Rol implements Serializable {

	private static final long serialVersionUID = 3566793399693959930L;

	@Id
	private String id;
	private String name;

}
