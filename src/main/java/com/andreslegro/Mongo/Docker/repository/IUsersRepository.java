package com.andreslegro.Mongo.Docker.repository;

import com.andreslegro.Mongo.Docker.Documents.Users;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IUsersRepository extends MongoRepository<Users,Integer> {
}
