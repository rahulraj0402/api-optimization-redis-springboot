package com.rahul.optimisedApi.services;

import com.rahul.optimisedApi.entity.Notes;
import com.rahul.optimisedApi.repository.NotesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class NotesService {

    @Autowired
    private NotesRepo notesRepo;

    // save
    @CachePut(value = "notes",key = "#notes.id") // using # we can access the notesID of notes that we are crating
    public Notes create(Notes notes){
        notes.setId(UUID.randomUUID().toString());
        return notesRepo.save(notes);
    }

    // get
    public List<Notes> getAll(){
        System.out.println("getting all function");
        return notesRepo.findAll();
    }

//     get by ID

    @Cacheable(value = "notes",key = "#noteId")
    public Notes getById(String noteId){
        System.out.println("Fetching note with ID: " + noteId);
        return notesRepo.findById(noteId).orElseThrow(() ->
                new RuntimeException("note with id : " + noteId + " is not found "));
    }


    // update
    public Notes updateNote(String noteId , Notes notes){
        Notes notes1 = notesRepo.findById(noteId).orElseThrow(() ->
                new RuntimeException("note with id : " + noteId + " is not found "));

        notes1.setTitle(notes.getTitle());
        notes1.setContent(notes.getContent());
        notes1.setLive(notes.isLive());

        return notesRepo.save(notes1);
    }

    // delete
    @CacheEvict(value = "notes",key = "#noteId")
    public void delete(String noteId){
        Notes notes1 = notesRepo.findById(noteId).orElseThrow(() ->
                new RuntimeException("note with id : " + noteId + " is not found "));

        notesRepo.delete(notes1);
    }


}
