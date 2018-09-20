package service;

import exception.ServiceException;
import model.Tag;

import java.util.List;

public interface TagService {
    List<Tag> findAll() throws ServiceException;
    void save(Tag tag) throws ServiceException;
}
