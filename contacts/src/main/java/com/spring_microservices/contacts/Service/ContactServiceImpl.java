package com.spring_microservices.contacts.Service;

import com.spring_microservices.contacts.Model.Contact;
import com.spring_microservices.contacts.Repository.Contact.ContactDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ContactServiceImpl implements ContactService {
    @Autowired
    ContactDao dao;
    @Override
    public boolean create(Contact contact) {
        var contacts = dao.getAll();
        dao.create(contact);
        var newContacts = dao.getAll();
        if(contacts.size() != newContacts.size()) return true;
        return false;
    }

    @Override
    public List<Contact> getAll() {

        return dao.getAll();
    }

    @Override
    public Contact getById(int id) {

        return dao.getById(id);
    }

    @Override
    public List<Contact> updateById(Contact contact) {

        if(dao.getById(contact.getId()) != null) {
            dao.updateById(contact);
        }
        return dao.getAll();
    }

    @Override
    public boolean deleteById(int id) {
        if(dao.getById(id) != null) {

            dao.deleteById(id);
            return true;
        }
        return false;
    }
}
