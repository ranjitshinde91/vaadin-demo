package page;


import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import presenter.impl.LoginPresenter;
import service.impl.UserServiceImpl;
import view.LoginView;
import view.impl.LoginViewImpl;

import javax.servlet.annotation.WebServlet;

@Theme("valo")
@SuppressWarnings("serial")
public class LoginPage extends UI {

    @WebServlet(value = "/*", asyncSupported = true)
    @VaadinServletConfiguration(productionMode = false, ui = LoginPage.class)
    public static class Servlet extends VaadinServlet {
    }

    @Override
    protected void init(VaadinRequest request) {
        Navigator navigator = new Navigator(this, this);
        LoginView loginView = new LoginViewImpl();
        LoginPresenter loginPresenter = new LoginPresenter(loginView, new UserServiceImpl());
        loginView.setHandler(loginPresenter);
        loginView.init();
        navigator.addView("", loginView);
        setNavigator(navigator);
        navigator.navigateTo("");

    }



}
