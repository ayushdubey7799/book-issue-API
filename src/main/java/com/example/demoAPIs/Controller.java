package com.example.demoAPIs;

import com.example.demoAPIs.Dto.BookDto;
import com.example.demoAPIs.Dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    UserService userService;

    @PostMapping("/add-user")
    public ResponseEntity<String> addUser(@RequestBody() UserDto user){
        userService.addUser(user);
        return new ResponseEntity<>("New user added Successfully", HttpStatus.CREATED);
    }

    @PostMapping("/issue-book")
    public ResponseEntity<String> issueBook(@RequestBody() BookDto book){
        userService.issueBookToUser(book);
        return new ResponseEntity<>("Book Issued Successfully", HttpStatus.CREATED);

    }

    @GetMapping("/get-books/{userId}")
    public ResponseEntity<List<BookDto>> getBooksByUserId(@PathVariable String userId){
        List<BookDto> bookDtoList = userService.getBooksByUserId(userId);
        return new ResponseEntity<>(bookDtoList,HttpStatus.OK);
    }

}
