package skwarel.services;

import skwarel.models.users.User;

import java.util.HashMap;

/**
 * Created by mickael on 09/06/16.
 */
public interface UserServiceInterface {
    void addUser(User u);
    void removeAll();
    void removeOne(long id);
    HashMap getListUsers();
    User getOneUser(long id);
    void updateUser(long id, String newInfo);
}
