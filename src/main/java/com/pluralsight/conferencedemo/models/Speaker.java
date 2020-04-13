package com.pluralsight.conferencedemo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;

@Entity(name = "speakers")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
@Getter
@Setter
public class Speaker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long speaker_id;
    private String first_name;
    private String last_name;
    private String tittle;
    private String company;
    private String speaker_bio;
    @Lob
    @Type(type = "org.hibernate.type.BinaryType")
    private byte[] speaker_photo;

    @ManyToMany(mappedBy = "speakers")
    @JsonIgnore
    private List<Session>sessions;

    public Speaker(){

    }
    public byte[] getSpeaker_photo(){
        return speaker_photo;
    }

    private List<Session> getSessions(){
        return sessions;
    }
}