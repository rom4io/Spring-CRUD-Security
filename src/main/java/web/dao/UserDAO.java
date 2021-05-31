package web.dao;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import web.models.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public List<User> index(){
        return entityManager.createQuery("Select u from User u", User.class).getResultList();
    }

    @Transactional
    public User show(int id){
        return entityManager.find(User.class, id);
    }

    @Transactional
    public void save (User user){
        entityManager.persist(user);
    }

    @Transactional
    public void update(int id, User updateUser){
        entityManager.merge(updateUser);
    }

    @Transactional
    public void delete(int id){
        entityManager.remove(show(id));
    }

//    private static int PEOPLE_COUNT;
//    private List<User> users;
//
//    {
//        users = new ArrayList<>();
//
//        users.add(new User(++PEOPLE_COUNT, "Petr", "Petrov@jfd.ru", 25));
//        users.add(new User(++PEOPLE_COUNT, "Ivan", "Ivanov@jfd.ru", 33));
//        users.add(new User(++PEOPLE_COUNT, "Sidr", "Sidorov@jfd.ru", 22));
//        users.add(new User(++PEOPLE_COUNT, "Sergey", "Sergeev@jfd.ru", 47));
//    }
//
//    public List<User> index() {
//        return users;
//    }
//
//    public User show(int id) {
//        return users.stream().filter(user -> user.getId() == id).findAny().orElse(null);
//    }
//
//    public void save(User user){
//        user.setId(++PEOPLE_COUNT);
//        users.add(user);
//    }
//
//    public void update(int id, User updatedUser){
//        User userToBeUpdated = show(id);
//        userToBeUpdated.setName(updatedUser.getName());
//        userToBeUpdated.setMail(updatedUser.getMail());
//        userToBeUpdated.setAge(updatedUser.getAge());
//    }
//
//    public void delete(int id){
//        users.removeIf(p -> p.getId() == id);
//    }

}
