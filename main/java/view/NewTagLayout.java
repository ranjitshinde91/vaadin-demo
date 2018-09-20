package view;

import com.vaadin.ui.TextField;

public interface NewTagLayout extends TagLayout {
    TextField getTxtTagName();
    void afterSuccessfulSave();
}
