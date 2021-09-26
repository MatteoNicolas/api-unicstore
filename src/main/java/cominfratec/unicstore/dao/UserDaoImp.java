package cominfratec.unicstore.dao;

import cominfratec.unicstore.models.User;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import cominfratec.unicstore.models.User;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class UserDaoImp implements UserDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getUsers() {
        String query = "FROM user";
        return  entityManager.createQuery(query).getResultList();
    }

    @Override
    public void delete(Long id) {
        User user = entityManager.find(User.class, id);

        entityManager.remove(user);
    }

    @Override
    public void register(User user) {
        entityManager.merge(user);
    }

    public boolean checkLogin(User user){
        String query = "FROM user WHERE cpf = :cpf";
          List<User> list = entityManager.createQuery(query)
                .setParameter("cpf", user.getCpf())
                .getResultList();

          if(list.isEmpty()){
              return false;
          }
          String passwordHashed = list.get(0).getPassword();

          Argon2 argon2 = Argon2Factory.create((Argon2Factory.Argon2Types.ARGON2id));
          return argon2.verify(passwordHashed, user.getPassword());

          /**if(list.isEmpty()) {
              return false;
          } else {
              return true;
          }**/

    }
}
