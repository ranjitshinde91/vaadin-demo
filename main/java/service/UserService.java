package service;

import exception.ServiceException;
import model.User;


public interface UserService {
    boolean login(String username, String password) throws ServiceException;
    public User getUser();
}
