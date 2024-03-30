package com.spring_microservices.contacts.Repository.Contact;

import com.spring_microservices.contacts.Model.Contact;

import java.util.List;

public interface ContactDao {
    void create(Contact contact);
    List<Contact> getAll();
    Contact getById(int id);
    Contact getByEmail(String email);
    List<Contact> updateById(Contact contact);
    List<Contact> deleteById(int id);
    List<Contact> deleteByEmail(String email);


}
