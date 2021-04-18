package co.com.nuvu.credit.card.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import co.com.nuvu.credit.card.model.CreditCard;

public interface ICreditCardRespository extends MongoRepository<CreditCard, String> {

}
