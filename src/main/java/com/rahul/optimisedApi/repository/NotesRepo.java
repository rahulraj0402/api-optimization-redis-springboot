package com.rahul.optimisedApi.repository;

import com.rahul.optimisedApi.entity.Notes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotesRepo extends JpaRepository< Notes , String> {


}
