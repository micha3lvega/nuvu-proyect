package co.com.nuvu.credit.card.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import co.com.nuvu.credit.card.helpers.CardType;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Document
@AllArgsConstructor
public class CreditCard implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	private String cvv;
	private String number;
	private CardType cardType;
	private Date expirationDate;

}
