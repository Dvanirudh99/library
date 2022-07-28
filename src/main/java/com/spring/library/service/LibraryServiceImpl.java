package com.spring.library.service;


import com.spring.library.dao.LibraryRepository;
import com.spring.library.entity.Library;
import com.spring.library.exceptions.IdNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibraryServiceImpl implements LibraryService{
   @Autowired
    private LibraryRepository libraryRepository;
   @Override
    public List<Library> findAll() {
        return libraryRepository.findAll();
    }
    @Override
    public Library findById(int theId) {
        Optional<Library> result = libraryRepository.findById(theId);

        Library books = null;

        if (result.isPresent()) {
            books = result.get();
        }
        else {

            throw new IdNotFoundException("Did not find library id - " + theId);
        }

        return books;
    }

    @Override
    public void save(Library books) {
        libraryRepository.save(books);
    }

    @Override
    public void deleteById(int theId) {
       libraryRepository.deleteById(theId);
    }

}
