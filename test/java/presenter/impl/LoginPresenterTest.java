package presenter.impl;

import com.vaadin.ui.TextField;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import service.UserService;
import view.LoginView;


import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

public class LoginPresenterTest {

    private LoginView view;
    private UserService service;
    private LoginPresenter presenter;

    @Before

    public void setUp() throws Exception {
        view = mock(LoginView.class);
        service = mock(UserService.class);
        presenter = new LoginPresenter(view, service);
    }


    @Test
    public void isLoginWorking() throws Exception {
        TextField usernameTextField = new TextField();
        usernameTextField.setValue("a");
        TextField passwordTextField = new TextField();
        passwordTextField.setValue("1");

        when(view.getTxtUsername()).thenReturn(usernameTextField);
        when(view.getTxtPassword()).thenReturn(passwordTextField);
        when(service.login(anyString(), anyString())).thenReturn(true);

        presenter.login();
        Mockito.verify(service, times(1)).login(anyString(), anyString());
        Mockito.verify(view, times(1)).afterSuccessfulLogin();
    }

    @Test
    public void isLoginAttemptIgnoredForEmptyInputs() throws Exception {
        when(view.getTxtUsername()).thenReturn(new TextField(""));
        when(view.getTxtPassword()).thenReturn(new TextField(""));
        presenter.login();
        Mockito.verify(service, times(0)).login(anyString(), anyString());
        Mockito.verify(view, times(1)).afterFailLogin();
    }


}