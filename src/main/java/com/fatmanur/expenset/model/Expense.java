package com.fatmanur.expenset.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;

@Entity
@NoArgsConstructor
@Data
@Table(name="expense")
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "description")
    private String description;

    @Column(name = "expensedate")
    private Instant expensedate;

    @Enumerated(EnumType.STRING)
    private Location location;

    @ManyToOne
    private Category category;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    private User user;
}