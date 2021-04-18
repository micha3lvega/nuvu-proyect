package co.com.nuvu.person.services.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import co.com.nuvu.person.commons.dto.PersonDTO;

public interface IPersonRepository extends MongoRepository<PersonDTO, String> {

}
