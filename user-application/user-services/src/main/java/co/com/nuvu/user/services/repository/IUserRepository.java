package co.com.nuvu.user.services.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import co.com.nuvu.user.services.model.User;

public interface IUserRepository extends MongoRepository<User, String> {

}
