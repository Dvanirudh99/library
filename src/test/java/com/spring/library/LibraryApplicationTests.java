package com.spring.library;


import com.spring.library.dao.LibraryRepository;

import com.spring.library.entity.Library;
import com.spring.library.exceptions.IdNotFoundException;
import com.spring.library.service.LibraryServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Optional.empty;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
@RunWith(SpringRunner.class)
class LibraryApplicationTests {

    @Autowired
    private LibraryServiceImpl service;

    @MockBean
    private LibraryRepository repository;

    @Mock
    private Model model;

    @Test
    void listLibrary() {
        when(repository.findAll()).thenReturn(
                Stream.of(
                        new Library(1,"The secret seven","enid","children's book", "23 jan 1948"),
                        new Library(2,"The secret seven ","enid","children's book", "23 jan 1948")
                ).collect(Collectors.toList()));

        assertEquals(2, service.findAll().size());

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
    void saveBooks() {
        Library li = new Library(1,"The secret seven","enid","children's book", "23 jan 1948");
        service.save(li);
        verify(repository).save(li);
//        Assertions.assertEquals("saveBooks",repository);
    }

    @Test
    void deleteBooks() {
        int id = 1;
        service.deleteById(id);
        verify(repository, times(1)).deleteById(id);


    }
    @Test
    void getLibraryTest(){
        Library lib = new Library(1,"The secret seven","enid","children's book", "23 jan 1948");

        List<Library> List=new ArrayList<>(Arrays.asList(lib));
        when(repository.findAll()).thenReturn(List);
        assertEquals(1,service.findAll().size());
        List<Library> result=service.findAll();
        assertThat(result);
        assertThat(result.get(0).getBookTitle()).isEqualTo(lib.getBookTitle());
    }




    @Test
    void contextLoads() {
        Assertions.assertTrue(true);
    }

}
