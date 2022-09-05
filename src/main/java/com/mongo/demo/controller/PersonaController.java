package com.mongo.demo.controller;

import com.mongo.demo.model.Persona;
import com.mongo.demo.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/personas")
public class PersonaController {

    @Autowired
    PersonaService personaS;

    @GetMapping("/listar")
    public ResponseEntity<List<Persona>> listar() {
        return new ResponseEntity<>(personaS.findByAll(), HttpStatus.OK);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Persona> BuscarPersona(@PathVariable Long id) {
        personaS.findById(id);
        return new ResponseEntity<>(personaS.findById(id), HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<Persona> create(@RequestBody Persona id) {

        return new ResponseEntity<>(personaS.save(id), HttpStatus.OK);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Persona> delete(@PathVariable Long id) {
        personaS.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Persona> actualizar(@PathVariable Long id, @RequestBody Persona per) {
        Persona pt = personaS.findById(id);
        if (pt == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
                pt.setNombre(per.getNombre());
                pt.setApellido(per.getApellido());
                pt.setCedula(per.getCedula());
                pt.setCorreo(per.getCorreo());
                return new ResponseEntity<>(personaS.save(per), HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        }
    }
}
