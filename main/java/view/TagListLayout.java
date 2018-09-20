package view;

import model.Tag;

import java.util.List;

public interface TagListLayout extends TagLayout {
    void afterSuccessfulFetch(List<Tag> tags);
}
