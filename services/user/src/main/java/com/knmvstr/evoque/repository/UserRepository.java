package com.knmvstr.evoque.repository;

import com.knmvstr.evoque.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, Long> {
}
