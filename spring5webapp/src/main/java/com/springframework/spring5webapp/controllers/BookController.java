package com.springframework.spring5webapp.controllers;

import com.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {

  private final BookRepository bookRepository;

  //Inject at instance of the repo to the controller
  public BookController(BookRepository bookRepository) {
    this.bookRepository = bookRepository;
  }

  //This is what gets returned to the view
  @RequestMapping("/books")
  public String getBooks(Model model){

    //Adds and return a list of all books
    model.addAttribute("books", bookRepository.findAll());
    //Look for the list template
    return "books/list";
  }
}
