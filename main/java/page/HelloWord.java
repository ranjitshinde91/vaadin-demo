package page;


import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.data.Container;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.server.WrappedHttpSession;
import com.vaadin.server.WrappedSession;
import com.vaadin.ui.*;
import model.User;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import presenter.impl.LoginPresenter;
import service.UserService;
import service.impl.UserServiceImpl;
import view.LoginView;
import view.impl.LoginViewImpl;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpSession;

@Theme("valo")
@SuppressWarnings("serial")
public class HelloWord extends UI {

    private ApplicationContext context;

    @WebServlet(value = "/hello", asyncSupported = true)
    @VaadinServletConfiguration(productionMode = false, ui = HelloWord.class)
    public static class Servlet extends VaadinServlet {
    }

    @Override
    protected void init(VaadinRequest request) {
        UserService service = getUserService(request);
        User user = service.getUser();
        String name = user.getUsername();
        Label lblUserName = new Label("Hi " + name + " !");
        VerticalLayout layout = new VerticalLayout();
        layout.setMargin(true);
        setContent(layout);
        layout.addComponent(lblUserName);
    }

    private UserService getUserService(VaadinRequest request) {
        WrappedSession session = request.getWrappedSession();
        HttpSession httpSession = ((WrappedHttpSession) session).getHttpSession();
        ServletContext servletContext =  httpSession.getServletContext();
        context = WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext);
        return (UserService) context.getBean("userService");
    }
}

