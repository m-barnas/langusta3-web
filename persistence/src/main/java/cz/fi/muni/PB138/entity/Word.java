package cz.fi.muni.PB138.entity;

import cz.fi.muni.PB138.enums.GrammaticalCase;
import cz.fi.muni.PB138.enums.GrammaticalGender;
import cz.fi.muni.PB138.enums.Number;
import cz.fi.muni.PB138.enums.WordClass;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by Martin on 26.5.2017.
 *
 * @author Martin Barnas 433523
 */
@Entity
@Table(name = "word")
public class Word {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String infinitive;

    private String pattern;

    @NotNull
    private String declinedValue;


    private WordClass wordClass;

    private GrammaticalGender grammaticalGender;

    private Number number;

    private GrammaticalCase grammaticaCase;
}
