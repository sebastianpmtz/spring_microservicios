package com.spring_microservices.contacts.Controller;

import com.spring_microservices.contacts.Model.Contact;
import com.spring_microservices.contacts.Service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class ContactController {

    @Autowired
    ContactService service;

    @PostMapping(value = "Contact/create", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String create(@RequestBody Contact contact) {
        var response = service.create(contact);
        if(response) return "Contact crated successfully!";
        return "Contact can't be created :(";
    }

    @GetMapping(value = "Contact/getAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Contact> getAll() {
        return service.getAll();
    }

    @GetMapping(value = "Contact/getById", produces = MediaType.APPLICATION_JSON_VALUE)
    public Contact getById(@RequestParam int id){
        return service.getById(id);
    }

    @PutMapping(value = "Contact/updateById", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Contact> updateById(@RequestBody Contact contact){

        var newContacts = service.updateById(contact);

        return newContacts;
    }

    @DeleteMapping(value = "Contact/deleteById", produces = MediaType.APPLICATION_JSON_VALUE)
    public String deleteById(@RequestParam int id) {
        var response = service.deleteById(id);

        if(response) return "Contact deleted successfully!";
        return "Contact wasn't deleted :(";
    }

}
