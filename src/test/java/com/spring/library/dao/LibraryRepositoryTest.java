package com.spring.library.dao;

import com.spring.library.entity.Library;
import com.spring.library.service.LibraryServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.ui.Model;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(SpringRunner.class)
class LibraryRepositoryTest {
    @Autowired
    private LibraryServiceImpl service;

    @MockBean
    private LibraryRepository repository;

    @Mock
    private Model model;


    @Test
    void findAllByOrderByBookTitleAsc() {

        when(repository.findAllByOrderByBookTitleAsc()).thenReturn(Stream
                .of(
                        new Library(1,"The secret seven","enid","children's book", "23 jan 1948"),
                        new Library(2,"The secret seven ","enid","children's book", "23 jan 1948"))
                        .collect(Collectors.toList()));
        Assertions.assertEquals(2,repository.findAllByOrderByBookTitleAsc().size());
    }


}
