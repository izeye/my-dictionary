package com.izeye.mydictionary.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Meaning.
 *
 * @author Johnny Lim
 */
@Data
@Entity
public class Meaning {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private WordClass wordClass;

    @Column(unique = true)
    private String value;

}
