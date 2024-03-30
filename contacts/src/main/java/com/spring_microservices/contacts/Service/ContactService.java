package com.spring_microservices.contacts.Service;

import com.spring_microservices.contacts.Model.Contact;

import java.util.List;

public interface ContactService {
    boolean create(Contact contact);
    List<Contact> getAll();
    Contact getById(int id);
    List<Contact> updateById(Contact contact);
    boolean deleteById(int id);
}