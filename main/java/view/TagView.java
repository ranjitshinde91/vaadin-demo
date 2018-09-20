package view;

import com.vaadin.navigator.View;

public interface TagView extends View, TagLayout {

    NewTagLayout getNewTagLayout();
    TagListLayout getTagListLayout();
}
