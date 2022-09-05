package com.mongo.demo.service;

import com.mongo.demo.model.Persona;
import com.mongo.demo.repository.PersonaRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaServiceImp extends GenericServiceImpl<Persona,Long> implements PersonaService{
    @Autowired
    PersonaRespository personaRep;


    @Override
    public CrudRepository<Persona, Long> getDao() {
        return personaRep;
    }


}
