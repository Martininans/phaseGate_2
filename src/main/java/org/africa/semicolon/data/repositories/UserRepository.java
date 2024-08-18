package org.africa.semicolon.data.repositories;

import org.africa.semicolon.data.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findUserByUsername(String username);
    Optional<User> findFirstUserByUsername(String username);
}
