package service.impl;

import exception.ServiceException;
import model.User;
import service.UserService;

public class UserServiceImpl implements UserService {

    @Override
    public boolean login(String username, String password) throws ServiceException {
        if(username.equals("a") && password.equals("1")){
            return  true;
        }
        return false;
    }

    @Override
    public User getUser() {
        User user = new User();
        user.setUsername("Adela");
        return user;
    }


}
