package br.usjt.previsoestempo.repository;

import br.usjt.previsoestempo.JPAUtil;
import br.usjt.previsoestempo.model.Previsao;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

@Repository
public class PrevisaoRepository{

    public void insert(Previsao previsao){
        EntityManager manager = JPAUtil.getEntityManager();
        EntityTransaction transaction = manager.getTransaction();

        transaction.begin();

        manager.persist(previsao);

        transaction.commit();
    }

    public List<Previsao> findAll(){
        return JPAUtil.getEntityManager().createQuery("from Previsao").getResultList();
    }
}
