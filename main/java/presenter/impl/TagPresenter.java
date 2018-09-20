package presenter.impl;

import com.vaadin.ui.TextField;
import exception.ServiceException;
import model.Tag;
import presenter.TagViewHandler;
import service.TagService;
import view.NewTagLayout;
import view.TagListLayout;
import view.TagView;

import java.util.ArrayList;
import java.util.List;

public class TagPresenter implements TagViewHandler {
    private TagView tagView;
    private TagService tagService;

    public TagPresenter(TagView view, TagService service) {
        this.tagView = view;
        this.tagService = service;
    }
    @Override
    public void addTag() {
        System.out.println("add new Tag");
        NewTagLayout layout = tagView.getNewTagLayout();
        TextField txtTagName = layout.getTxtTagName();
        String value = txtTagName.getValue();
        try {
            Tag tag = new Tag(value);
            tagService.save(tag);
            layout.afterSuccessfulSave();
            showTagList();
        } catch (ServiceException e) {
            // TODO: log the exception
            // TODO: notify view about failure
        }
    }

    @Override
    public void showTagList() {
        try {
            TagListLayout layout = tagView.getTagListLayout();
            List<Tag> tags = tagService.findAll();
            layout.afterSuccessfulFetch(tags);
        } catch (Exception e) {
            // TODO: log the exception
            // TODO: notify view about failure
        }
    }
}
