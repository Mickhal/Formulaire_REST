package skwarel.services;

import org.springframework.stereotype.Service;
import skwarel.models.users.User;

import java.util.HashMap;

/**
 * Created by mickael on 09/06/16.
 */
@Service("userService")

public class UserServiceImpl implements UserServiceInterface {

    private HashMap bdUsers=  new HashMap<>();

    @Override
    public void addUser(User u) {bdUsers.put(u.getId(),u);
    }

    @Override
    public void removeAll() {
        bdUsers.clear();
    }

    @Override
    public void removeOne(long id) {
        bdUsers.remove(id);
    }

    @Override
    public HashMap getListUsers() {
        return bdUsers;
    }

    @Override

    public User getOneUser(long id) {return (User) bdUsers.get(id);}

    @Override
    public void updateUser(long id, String newInfo) {
        User userUpdated = (User) bdUsers.get(id);
        userUpdated.setEmail(newInfo);
        bdUsers.put(userUpdated.getId(),userUpdated);
    }

}
