/**
 * 
 */
package co.com.nuvu.credit.card.dto;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotBlank;

import co.com.nuvu.credit.card.helpers.CardType;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 
 * Clase que representa el DTO de una tarjeta de credito
 * 
 * @author Michael Vega
 *
 */
@Data
@AllArgsConstructor
public class CreditCardDTO implements Serializable {

	private static final long serialVersionUID = -3059103244806541499L;

	@NotBlank
	private String id;

	@NotBlank
	private String cvv;

	@NotBlank
	private String number;

	private CardType cardType;

	@NotBlank
	private Date expirationDate;

	@NotBlank
	private Date createdAt;

	@NotBlank
	private Date updatedAt;

}
