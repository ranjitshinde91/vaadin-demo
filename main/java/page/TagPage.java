package page;

import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.UI;
import presenter.impl.TagPresenter;
import service.TagService;
import service.impl.TagServiceImpl;
import view.TagView;
import view.impl.TagViewImpl;

import javax.servlet.annotation.WebServlet;

public class TagPage extends UI {

    @Override
    protected void init(VaadinRequest request) {
        Navigator navigator = new Navigator(this, this);

        TagView view = new TagViewImpl();
        view.init();
        TagService service = new TagServiceImpl();
        TagPresenter handler = new TagPresenter(view, service);
        view.setHandler(handler);
        view.getNewTagLayout().init();
        view.getTagListLayout().init();

        navigator.addView("tags", view);
        setNavigator(navigator);
        navigator.navigateTo("tags");

    }


    @WebServlet(urlPatterns = "/tag", name = "TagServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = TagPage.class, productionMode = false)
    public static class TagServlet extends VaadinServlet {
    }
}
