package view.impl;

import org.junit.Before;
import org.junit.Test;
import presenter.LoginViewHandler;
import view.LoginView;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class LoginViewImplTest {

    private LoginView view;
    private LoginViewHandler handler;

    @Before
    public void setUp() {
        view = new LoginViewImpl();
        handler = mock(LoginViewHandler.class);
        view.setHandler(handler);
        view.init();
    }

    @Test
    public void isLoginWorkingWhenLoginButtonIsClicked() {
        view.getBtnLogin().click();
        verify(handler, times(1)).login();
    }
}