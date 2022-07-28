package com.spring.library.service;


import com.spring.library.dao.LibraryRepository;
import com.spring.library.entity.Library;
import com.spring.library.exceptions.IdNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.ui.Model;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Optional.empty;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
 class LibraryServiceImplTest {

    @InjectMocks
    private LibraryServiceImpl service;

    @Mock
    private LibraryRepository repository;

    @Mock
    private Model model;

    @Test
    void findAll() {
        when(repository.findAll()).thenReturn(
                Stream.of(
                        new Library(1,"The secret seven","enid","children's book", "23 jan 1948"),
                        new Library(2,"The secret seven ","enid","children's book", "23 jan 1948")
                ).collect(Collectors.toList()));

        Assertions.assertEquals("enid", repository.findAll().get(1).getAuthor());
    }

    @Test
    void findById() {
        int id = 1;
        when(repository.findById(id)).thenReturn(
                Optional.of(new Library(1,"The secret seven","enid","children's book", "23 jan 1948")
                ));
        Assertions.assertEquals("The secret seven", service.findById(id).getBookTitle());
    }
    @Test
    void findByIdFailedTest(){
        Library library = new Library(1,"The secret seven","enid","children's book", "23 jan 1948");

        when(repository.findById(1)).thenReturn(empty());

        Exception exception = assertThrows(IdNotFoundException.class, () -> {
            service.findById(1);
        });

        String expectedMessage = "Did not find library id - 1";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }


    @Test
    void save() {
        Library li = new Library(1,"The secret seven","enid","children's book", "23 jan 1948");
        service.save(li);
        verify(repository).save(li);
    }


    @Test
    void delete() {
        int id = 1;
        service.deleteById(id);
        verify(repository, times(1)).deleteById(id);
    }

    @org.junit.Test
     void name() {
        Library lib=new Library();
        lib.setId(1);
        Assertions.assertEquals(1,lib.getId());

    }
}
