package com.rahul.optimisedApi.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "stream_note")
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class Notes implements Serializable {

    @Id
    private String id;
    private String title;
    private String content;
    private Date addedDate;
    private boolean live = false;

}
