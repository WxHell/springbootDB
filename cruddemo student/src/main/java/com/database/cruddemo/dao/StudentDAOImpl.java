package com.database.cruddemo.dao;

import com.database.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository //veri tabanı işlemleri için kullanılır

public class StudentDAOImpl implements StudentDAO{
    private EntityManager entityManager;

    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    @Transactional
    @Override

    public void save(Student theStudent) {
        entityManager.persist(theStudent);
    }
}
