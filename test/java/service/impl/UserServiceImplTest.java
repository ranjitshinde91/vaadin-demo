package service.impl;

import exception.ServiceException;
import org.junit.Before;
import org.junit.Test;
import service.UserService;

import static org.junit.Assert.*;

public class UserServiceImplTest {
    private UserService userService;


    @Before
    public  void seUp(){
        userService = new UserServiceImpl();
    }

    @Test
    public void loginSuccessForValidCredentials(){
        try {
            assertTrue(userService.login("a", "1"));
        }
        catch(ServiceException e){
            fail();
        }
    }

    @Test
    public void loginFailForInvalidCredentials(){
        try {
            assertFalse(userService.login("invalid", "credentials"));
        }
        catch(ServiceException e){
            fail();
        }
    }

}