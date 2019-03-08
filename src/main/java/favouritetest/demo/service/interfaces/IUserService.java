package favouritetest.demo.service.interfaces;

import favouritetest.demo.entity.User;

import java.util.List;

public interface IUserService {

    User addUser(User user);
    List<User> getAllUsers();
    User getUser(Long id);
    void deleteUser(long id);

}
