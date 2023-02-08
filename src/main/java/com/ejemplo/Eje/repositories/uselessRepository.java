package com.ejemplo.Eje.repositories;

import com.ejemplo.Eje.models.useless;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface uselessRepository extends MongoRepository<useless, String> {

}