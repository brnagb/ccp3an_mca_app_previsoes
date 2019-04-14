package br.usjt.previsoestempo.repository;

import br.usjt.previsoestempo.JPAUtil;
import br.usjt.previsoestempo.model.Semana;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

@Repository
public class SemanaRepository {

    public void insert(Semana semana){
        EntityManager manager = JPAUtil.getEntityManager();
        EntityTransaction transaction = manager.getTransaction();

        transaction.begin();

        manager.persist(semana);

        transaction.commit();
    }
}
