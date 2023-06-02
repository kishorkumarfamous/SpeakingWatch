package com.speakingWatch.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "conting")
public class Counting {
    @Id
    private  String id;
    private  String value;

}
