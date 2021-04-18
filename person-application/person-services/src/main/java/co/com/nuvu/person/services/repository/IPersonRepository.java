package co.com.nuvu.person.services.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import co.com.nuvu.person.services.model.Person;

public interface IPersonRepository extends MongoRepository<Person, String> {

}
