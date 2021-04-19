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

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		PersonDTO other = (PersonDTO) obj;
		if (createdAt == null) {
			if (other.createdAt != null) {
				return false;
			}
		} else if (!createdAt.equals(other.createdAt)) {
			return false;
		}
		if (creditCard == null) {
			if (other.creditCard != null) {
				return false;
			}
		} else if (!creditCard.equals(other.creditCard)) {
			return false;
		}
		if (document == null) {
			if (other.document != null) {
				return false;
			}
		} else if (!document.equals(other.document)) {
			return false;
		}
		if (email == null) {
			if (other.email != null) {
				return false;
			}
		} else if (!email.equals(other.email)) {
			return false;
		}
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		if (lastName == null) {
			if (other.lastName != null) {
				return false;
			}
		} else if (!lastName.equals(other.lastName)) {
			return false;
		}
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		if (phone == null) {
			if (other.phone != null) {
				return false;
			}
		} else if (!phone.equals(other.phone)) {
			return false;
		}
		if (updatedAt == null) {
			if (other.updatedAt != null) {
				return false;
			}
		} else if (!updatedAt.equals(other.updatedAt)) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (prime * result) + ((createdAt == null) ? 0 : createdAt.hashCode());
		result = (prime * result) + ((creditCard == null) ? 0 : creditCard.hashCode());
		result = (prime * result) + ((document == null) ? 0 : document.hashCode());
		result = (prime * result) + ((email == null) ? 0 : email.hashCode());
		result = (prime * result) + ((id == null) ? 0 : id.hashCode());
		result = (prime * result) + ((lastName == null) ? 0 : lastName.hashCode());
		result = (prime * result) + ((name == null) ? 0 : name.hashCode());
		result = (prime * result) + ((phone == null) ? 0 : phone.hashCode());
		result = (prime * result) + ((updatedAt == null) ? 0 : updatedAt.hashCode());
		return result;
	}

}
