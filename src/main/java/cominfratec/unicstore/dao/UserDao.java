package cominfratec.unicstore.dao;

import cominfratec.unicstore.models.User;

import java.util.List;

public interface UserDao {
    List<User> getUsers();

    void delete(Long id);

    void register(User user);

    boolean checkLogin(User user);
}
