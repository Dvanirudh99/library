package com.spring.library.exceptions;

import com.spring.library.dao.LibraryRepository;
import com.spring.library.entity.Library;
import com.spring.library.service.LibraryServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.ui.Model;

import static java.util.Optional.empty;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
class IdNotFoundExceptionTest {
    private LibraryServiceImpl service;

    @Mock
    private LibraryRepository repository;

    @Mock
    private Model model;
    @Test
    void findByIdFailedTest(){
        Library library = new Library(1,"The secret seven","enid","children's book", "23 jan 1948");

        when(repository.findById(5)).thenReturn(empty());

        Exception exception = assertThrows(NullPointerException.class, () -> {
            service.findById(5);
        });

        String expectedMessage = "Did not find library id - 1";
        String actualMessage = exception.getMessage();


    }


}
