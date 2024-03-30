package com.spring_microservices.contacts.Repository.Contact;

import com.spring_microservices.contacts.Model.Contact;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface ContactJpaSpring extends JpaRepository<Contact, Integer> {

    Contact findByEmail(String email);
    Contact findById(int id);
    @Transactional
    @Modifying
    @Query("Delete from Contact c Where c.email = ?1")
    void deleteByEmail(String email);

    @Transactional
    @Modifying
    @Query("Delete from Contact c Where c.id = ?1")
    void deleteById(int id);
}
