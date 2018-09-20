package presenter.impl;

import exception.ServiceException;
import presenter.LoginViewHandler;
import service.UserService;
import view.LoginView;

public class LoginPresenter  implements LoginViewHandler {
    private LoginView view;
    private UserService service;

    public LoginPresenter(LoginView view, UserService service) {
        this.view = view;
        this.service = service;
    }

    @Override
    public void login() {
        String username = view.getTxtUsername().getValue();
        String password  = view.getTxtPassword().getValue();

        try {
            if(!(username.isEmpty() && password.isEmpty()) &&service.login(username, password)){
                view.afterSuccessfulLogin();
                return;
            }
            view.afterFailLogin();
        } catch (ServiceException e) {
            view.afterFailLogin();
        }
    }
}
