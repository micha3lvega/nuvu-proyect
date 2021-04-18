package co.com.nuvu.credit.card.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import co.com.nuvu.credit.card.helpers.CardType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Clase que representa la entidad de una tarjeta de credito
 * 
 * @author Michael Vega
 *
 */
@Data
@Document
@AllArgsConstructor
@NoArgsConstructor
public class CreditCard implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	private String cvv;
	private String number;
	private CardType cardType;
	private String expirationDate;

	@CreatedDate
	private Date createdAt;

	@LastModifiedDate
	private Date updatedAt;

}
