package co.com.nuvu.credit.card.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;

import co.com.nuvu.credit.card.model.CreditCard;

public interface ICreditCardRespository extends MongoRepository<CreditCard, String> {

}
