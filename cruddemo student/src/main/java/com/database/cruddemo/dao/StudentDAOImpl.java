package com.database.cruddemo.dao;

import com.database.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository //veri tabanı işlemleri için kullanılır

public class StudentDAOImpl implements StudentDAO{
    private EntityManager entityManager;

    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    @Transactional //Bu notasyon, bu metodun bir veritabanı işlemi (transaction) içinde yürütülmesi gerektiğini belirtir.
    @Override

    public void save(Student theStudent) {
        entityManager.persist(theStudent);
    }

    @Override
    public Student findByID(int id) {
        return entityManager.find(Student.class,id);
    }

    @Override
    public List<Student> findAll() {
        TypedQuery<Student> theQuery=entityManager.createQuery("FROM Student order by lastName  ",Student.class);

        return theQuery.getResultList();
    }

    @Override
    public List<Student> findByLastName(String lastName) {
        TypedQuery<Student>theQuery=entityManager.createQuery(
                "FROM Student WHERE lastName=:theData",Student.class);
        theQuery.setParameter("theData",lastName);
        return theQuery.getResultList();
    }

    @Override
    @Transactional // dv de guncelleme yapacagım ıcın ekledim
    public void update(Student theStudent) {
        entityManager.merge(theStudent);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        Student theStudent = entityManager.find(Student.class,id);
        entityManager.remove(theStudent);
    }

    @Override
    @Transactional
    public int deleteAll() {
        int numRowsDeleted = entityManager.createQuery("DELETE FROM Student").executeUpdate();
        return numRowsDeleted;
    }
}
//FROM Student order by lastName a dan z ye artan şekilde sıralnır
//FROM Student order by lastName desc azalan şekilde sıralar
//FROM Student order by lastName asc soy adına göre sıralar