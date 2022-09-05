package com.mongo.demo.repository;

import com.mongo.demo.model.Persona;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PersonaRespository extends MongoRepository<Persona, Long> {
}
