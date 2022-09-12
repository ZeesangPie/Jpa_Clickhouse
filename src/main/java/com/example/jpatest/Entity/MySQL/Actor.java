package com.example.jpatest.Entity.MySQL;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Actor {
    @Id
    @GeneratedValue
    Long id;

    String actorGraph;
    String actorname_chinese;
    String actorname_english;
    String intro;
}
