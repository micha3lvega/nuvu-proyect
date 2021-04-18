/**
 *
 */
package co.com.nuvu.credit.card.dto;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import co.com.nuvu.credit.card.helpers.CardType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * Clase que representa el DTO de una tarjeta de credito
 *
 * @author Michael Vega
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreditCardDTO implements Serializable {

	private static final long serialVersionUID = -3059103244806541499L;

	private String id;

	@NotBlank
	@Size(min = 3, max = 3)
	private String cvv;

	@NotBlank
	private String number;

	private CardType cardType;

	@NotNull
	private String expirationDate;

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
		CreditCardDTO other = (CreditCardDTO) obj;
		if (cardType != other.cardType) {
			return false;
		}
		if (createdAt == null) {
			if (other.createdAt != null) {
				return false;
			}
		} else if (!createdAt.equals(other.createdAt)) {
			return false;
		}
		if (cvv == null) {
			if (other.cvv != null) {
				return false;
			}
		} else if (!cvv.equals(other.cvv)) {
			return false;
		}
		if (expirationDate == null) {
			if (other.expirationDate != null) {
				return false;
			}
		} else if (!expirationDate.equals(other.expirationDate)) {
			return false;
		}
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		if (number == null) {
			if (other.number != null) {
				return false;
			}
		} else if (!number.equals(other.number)) {
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
		result = (prime * result) + ((cardType == null) ? 0 : cardType.hashCode());
		result = (prime * result) + ((createdAt == null) ? 0 : createdAt.hashCode());
		result = (prime * result) + ((cvv == null) ? 0 : cvv.hashCode());
		result = (prime * result) + ((expirationDate == null) ? 0 : expirationDate.hashCode());
		result = (prime * result) + ((id == null) ? 0 : id.hashCode());
		result = (prime * result) + ((number == null) ? 0 : number.hashCode());
		result = (prime * result) + ((updatedAt == null) ? 0 : updatedAt.hashCode());
		return result;
	}

}
