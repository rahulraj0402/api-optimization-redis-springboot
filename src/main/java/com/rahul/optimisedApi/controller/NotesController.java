package com.rahul.optimisedApi.controller;

import com.rahul.optimisedApi.entity.Notes;
import com.rahul.optimisedApi.services.NotesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/notes")
public class NotesController {

    @Autowired
    private NotesService notesService;

    // create
    @PostMapping
    public ResponseEntity<Notes> create(@RequestBody Notes notes){
        return ResponseEntity.status(HttpStatus.CREATED).body(notesService.create(notes));
    }

    // get notes
    @GetMapping
    public ResponseEntity<List<Notes>> getAll(){
        return ResponseEntity.ok(notesService.getAll());
    }

    @GetMapping("/{notesId}")
    public ResponseEntity<Notes> getSingle(@PathVariable String notesId){
        return ResponseEntity.ok(notesService.getById(notesId));
    }

}
