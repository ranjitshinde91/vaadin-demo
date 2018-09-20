package view.impl;

import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;
import presenter.TagViewHandler;
import view.NewTagLayout;

public class NewTagLayoutImpl extends HorizontalLayout implements NewTagLayout {

    private TextField txtTagName;
    private TagViewHandler handler;
    private Button btnConfirm;

    @Override
    public void setHandler(TagViewHandler handler) {
        this.handler = handler;
    }

    @Override
    public void init() {
        setCaption("New tag");
        setSpacing(true);
        setMargin(true);
        txtTagName = new TextField("Tag name:");
        addComponent(txtTagName);

        btnConfirm = new Button("Confirm");
        addComponent(btnConfirm);

        btnConfirm.addClickListener(e->{
            handler.addTag();
        });
    }

    public Button getBtnConfirm() {
        return btnConfirm;
    }

    public TextField getTxtTagName() {
        return txtTagName;
    }

    @Override
    public void afterSuccessfulSave() {
        txtTagName.setValue("");
        txtTagName.focus();
    }
}
