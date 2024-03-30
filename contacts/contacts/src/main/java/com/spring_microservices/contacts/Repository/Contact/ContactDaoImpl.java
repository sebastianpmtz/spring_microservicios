package com.spring_microservices.contacts.Repository.Contact;

import com.spring_microservices.contacts.Model.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Repository
public class ContactDaoImpl implements ContactDao {
    @Autowired
    ContactJpaSpring contacts;
    @Override
    public void create(Contact contact) {
        contacts.save(contact);
    }

    @Override
    public List<Contact> getAll() {

        return contacts.findAll();
    }

    @Override
    public Contact getById(int id) {

        Optional<Contact> contactFoundOptional = Optional.ofNullable(contacts.findById(id));

        if(contactFoundOptional.isPresent()){

            return contactFoundOptional.get();

        } else {

            throw new NoSuchElementException("The contact with ID " + id + "was not found");

        }
    }

    @Override
    public Contact getByEmail(String email) {

        Optional<Contact> contactFoundOptional = Optional.ofNullable(contacts.findByEmail(email));

        if(contactFoundOptional.isPresent()){

            return contactFoundOptional.get();

        } else {

            throw new NoSuchElementException("The contact with Email " + email + "was not found");

        }
    }

    @Override
    public List<Contact> updateById(Contact contact) {

        Optional<Contact> contactFoundOptional = Optional.ofNullable(contacts.findById(contact.getId()));

        if(contactFoundOptional.isPresent()){
            Contact contactFound = contactFoundOptional.get();

            contactFound.setName(contact.getName());
            contactFound.setEmail(contact.getEmail());
            contactFound.setAge(contact.getAge());

            contacts.save(contactFound);
        } else {

            throw new NoSuchElementException("The contact with ID " + contact.getId() + "was not found");

        }
        return contacts.findAll();
    }

    @Override
    public List<Contact> deleteById(int id) {
        Optional<Contact> contactFoundOptional = Optional.ofNullable(contacts.findById(id));

        if(contactFoundOptional.isPresent()){

            contacts.deleteById(id);

        } else {

            throw new NoSuchElementException("The contact with ID " + id + "was not found");

        }
        return contacts.findAll();
    }

    @Override
    public List<Contact> deleteByEmail(String email) {

        Optional<Contact> contactFoundOptional = Optional.ofNullable(contacts.findByEmail(email));

        if(contactFoundOptional.isPresent()){

            contacts.deleteByEmail(email);

        } else {

            throw new NoSuchElementException("The contact with Email " + email + "was not found");

        }
        return contacts.findAll();
    }
}
