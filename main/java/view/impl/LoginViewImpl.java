package view.impl;

import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.*;
import presenter.LoginViewHandler;
import view.LoginView;

public class LoginViewImpl extends VerticalLayout implements LoginView {
    private LoginViewHandler handler;
    private TextField txtUsername;
    private TextField txtPassword;
    private Button btnLogin;
    private Label statusLabel;
    @Override
    public void setHandler(LoginViewHandler handler) {
        this.handler = handler;
    }
    @Override
    public void init() {
        txtUsername = new TextField("Username:");
        addComponent(txtUsername);
        txtPassword = new TextField("Password:");
        addComponent(txtPassword);
        btnLogin = new Button("Login");
        addComponent(btnLogin);
        btnLogin.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                handler.login();
            }
        });
        statusLabel = new Label();
        addComponent(statusLabel);
    }
    @Override
    public TextField getTxtUsername() {
        return txtUsername;
    }
    @Override
    public TextField getTxtPassword() {
        return txtPassword;
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
    }
    @Override
    public Button getBtnLogin() {
        return btnLogin;
    }

    @Override
    public void afterSuccessfulLogin() {
        statusLabel.setValue("Success");
    }

    @Override
    public void afterFailLogin() {
        statusLabel.setValue("Failure");
    }
}
