/**
 * 
 */
package co.com.nuvu.person.commons.dto;

import java.io.Serializable;
import java.util.Date;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import co.com.nuvu.credit.card.dto.CreditCardDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Clase que representa el DTO de una persona
 * 
 * @author Michael Vega
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonDTO implements Serializable {

	private static final long serialVersionUID = -9196218864518118436L;

	private String id;

	@NotBlank
	private String name;

	@NotBlank
	private String lastName;

	@NotBlank
	private String document;

	@Email
	private String email;

	@NotBlank
	private String phone;

	@Valid
	@NotNull
	private CreditCardDTO creditCard;

	private Date createdAt;

	private Date updatedAt;

}
