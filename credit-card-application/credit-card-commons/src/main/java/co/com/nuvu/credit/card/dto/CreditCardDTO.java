/**
 * 
 */
package co.com.nuvu.credit.card.dto;

import java.io.Serializable;
import java.util.Date;

import javax.validation.Valid;
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
	private String cvv;

	@NotBlank
	@Size(min = 3, max = 3)
	private String number;

	@Valid
	@NotNull
	private CardType cardType;

	@NotNull
	private Date expirationDate;

	@NotNull
	private Date createdAt;

	@NotNull
	private Date updatedAt;

}
