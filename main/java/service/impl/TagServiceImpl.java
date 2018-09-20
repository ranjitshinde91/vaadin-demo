package service.impl;

import exception.ServiceException;
import model.Tag;
import service.TagService;

import java.util.ArrayList;
import java.util.List;

public class TagServiceImpl implements TagService {
    ArrayList<Tag> tags = new ArrayList<Tag>();

    public TagServiceImpl() {
        Tag java = new Tag("Java");
        Tag groovy = new Tag("Groovy");
        Tag scala = new Tag("Scala");
        tags.add(java);
        tags.add(groovy);
        tags.add(scala);
    }

    @Override
    public List<Tag> findAll() {
        return tags;
    }

    @Override
    public void save(Tag tag) {
        tags.add(tag);
    }
}
