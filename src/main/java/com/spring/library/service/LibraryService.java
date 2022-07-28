package com.spring.library.service;

import com.spring.library.entity.Library;
import java.util.List;

public interface LibraryService {
    public List<Library> findAll();
    public Library findById(int theId);
    void save(Library books);
    public void deleteById(int theId);


}
