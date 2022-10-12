package ru.javamentor.preproject.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import ru.javamentor.preproject.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {

   @PersistenceContext
   private EntityManager em;

   private static Logger logger = LoggerFactory.getLogger(UserRepositoryImpl.class);


   @Override
   public User show(int id) {
      return em.find(User.class, id);
   }

   @Override
   public void add(User user) {
      em.persist(user);
      em.flush();
      logger.info("Inserting new user");
   }

   @Override
   public void update(int id, User updatedUser) {
      User userToBeUpdated = show(id);
      userToBeUpdated.setName(updatedUser.getName());
      userToBeUpdated.setSurName(updatedUser.getSurName());
      userToBeUpdated.setEmail(updatedUser.getEmail());
      logger.info("Updating user with id = " + id);
   }

   @Override
   public void remove(int id) {
      User user = show(id);
      if (null == user) {
         throw new NullPointerException("User not found");
      }
      em.remove(user);
      em.flush();
      logger.info("Deleting user with id = " + id);
   }

   @Override
   @SuppressWarnings("unchecked")
   public List<User> getUsers() {
      Query query = em.createQuery("SELECT u FROM User u");
      return query.getResultList();
   }
}
