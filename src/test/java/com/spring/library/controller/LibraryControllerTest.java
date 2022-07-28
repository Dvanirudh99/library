package com.spring.library.controller;

import com.spring.library.dao.LibraryRepository;
import com.spring.library.entity.Library;
import com.spring.library.service.LibraryService;
import com.spring.library.service.LibraryServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.ui.Model;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@WebMvcTest(LibraryController.class)
class LibraryControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private LibraryServiceImpl service;
    @MockBean
    private LibraryRepository repository;
    @MockBean
    private Model model;



    @Test
    @WithMockUser(username = "Anirudh",password = "whatpassword")
    void listLibrary() throws Exception {

        //when(service.findAll()).thenReturn(repository.findAll());
        List<Library> libList =
                Stream.of(
                        new Library(1,"The secret seven","enid","children's book", "23 jan 1948"),
                        new Library(2,"The secret seven ","enid","children's book", "23 jan 1948")
                ).collect(Collectors.toList());

        when(service.findAll()).thenReturn(libList);
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/gui/list")).andExpect(status().isOk()).andReturn();
        verify(service, times(1)).findAll();
    }


    @Test
    void addBooks() {
    Library library=new Library(1,"The secret seven","enid","children's book", "23 jan 1948");
//        String response=library.Add(model);
//        Assertions.assertEquals("LIBRARYFORM",response);

        service.save(library);
        verify(service).save(library);

    }


    @Test
    void updateBooks() {
        Library library2=new Library(1,"The secret seven","enid","children's book", "23 jan 1948");
        service.save(library2);
        verify(service).save(library2);
    }


    @Test
    void saveBooks() {
        Library li = new Library(1,"The secret seven","enid","children's book", "23 jan 1948");
        service.save(li);
        verify(service).save(li);
//        Assertions.assertEquals("saveBooks",repository);
    }

    @Test
    void deleteBooks() {
        int id = 1;
        service.deleteById(id);
        verify(service, times(1)).deleteById(1);
    }
    @Test
    void contextLoads() {
        Assertions.assertTrue(true);
    }

}