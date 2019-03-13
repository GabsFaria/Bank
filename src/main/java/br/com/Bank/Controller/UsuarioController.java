package br.com.Bank.Controller;

import br.com.Bank.Model.UsuarioEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class UsuarioController {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("usuario");
    EntityManager em = emf.createEntityManager();

    public void inserir(UsuarioEntity usuarioEntity){
        try {
            em.getTransaction().begin();
            em.persist(usuarioEntity);
            em.getTransaction().commit();
            emf.close();
            System.out.println("Usuario cadastrado com sucesso!");
        }   catch (Exception e){
            System.out.println("Não foi possível cadastrar o usuário.");
        }

    }

    public void deletar(UsuarioEntity usuarioEntity){
        try {
            em.getTransaction().begin();
            usuarioEntity = em.find(UsuarioEntity.class, usuarioEntity.getId());
            em.remove(usuarioEntity);
            em.getTransaction().commit();
            emf.close();
            System.out.println("Usuário deletado com sucesso!");
        }   catch (Exception e){
            System.out.println("Não foi possível deletar o usuário.");
        }
    }

    public List<UsuarioEntity> listar(){
        try{
            em.getTransaction().begin();
            Query consulta = em.createQuery("select c from UsuarioEntity c");
            List<UsuarioEntity> lista = consulta.getResultList();
            em.getTransaction().commit();
            emf.close();
            return lista;
        }   catch(Exception e){
            System.out.println("Acesso negado");
            return null;
        }
    }

    public void atualizar(UsuarioEntity usuarioEntity){
        try {
            em.getTransaction().begin();
            em.merge(usuarioEntity);
            em.getTransaction().commit();
            emf.close();
            System.out.println("informações atualizadas com sucesso");
        }   catch (Exception e){
            System.out.println("Não foi possível atualizar os dados do sistema");
        }
    }
}
