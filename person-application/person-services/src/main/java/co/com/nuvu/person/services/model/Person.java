package co.com.nuvu.person.services.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import co.com.nuvu.credit.card.dto.CreditCardDTO;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Document
@AllArgsConstructor
public class Person implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	private String name;
	private String lastName;

	private String document;
	private String email;
	private String phone;

	private CreditCardDTO creditCard;

	@CreatedDate
	private Date createdAt;
	
	@LastModifiedDate
	private Date updatedAt;

}
