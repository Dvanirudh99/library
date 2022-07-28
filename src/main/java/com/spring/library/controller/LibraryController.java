package com.spring.library.controller;




import com.spring.library.entity.Library;
import com.spring.library.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/gui")
public class LibraryController {
    static final String LIBRARY="library";
    static final String LIBRARYFORM="library-form";

   @Autowired
    private LibraryService libraryService;


    @GetMapping("/list")
    public String listLibrary(Model theModel) {

        List<Library> books = libraryService.findAll();

        theModel.addAttribute(LIBRARY, books);

        return LIBRARY;

    }
    @GetMapping("/add")
    public String addBooks(Model theModel) {

        Library books = new Library();

        theModel.addAttribute(LIBRARY, books);

        return LIBRARYFORM;
    }

    @GetMapping("/update")
    public String updateBooks(@RequestParam("libraryId") int theId,
                                    Model theModel) {


        Library books = libraryService.findById(theId);


        theModel.addAttribute(LIBRARY, books);


        return LIBRARYFORM;
    }


    @PostMapping("/save")
    public String saveBooks(@ModelAttribute(LIBRARY) Library books) {

        // save the library
        libraryService.save(books);


        return LIBRARYFORM;
    }


    @GetMapping("/delete")
    public String deleteBooks(@RequestParam("libraryId") int theId) {

        libraryService.deleteById(theId);


        return "redirect:/gui/list";

    }
}
