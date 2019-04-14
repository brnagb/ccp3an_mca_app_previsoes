package br.usjt.previsoestempo.repository;

import br.usjt.previsoestempo.JPAUtil;
import br.usjt.previsoestempo.model.Usuario;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

@Repository
public class UsuarioRepository{

    public void insert(Usuario usuario){
        EntityManager manager = JPAUtil.getEntityManager();
        EntityTransaction transaction = manager.getTransaction();

        transaction.begin();

        manager.persist(usuario);

        transaction.commit();
    }

    public List<Usuario> findOneByLoginAndSenha(Usuario usuario){
        return JPAUtil
                .getEntityManager()
                .createQuery("from Usuario where login = '" + usuario.getLogin() + "' and senha = '" + usuario.getSenha() + "'")
                .getResultList();
    }
}