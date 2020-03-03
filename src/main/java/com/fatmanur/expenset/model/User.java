package com.fatmanur.expenset.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Data
@Table(name="user")
public class User {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @Column(name = "name", nullable = true)
    @Size(min = 3, max = 35, message = "Name must be 3-35 characters long.")
    private String name;

    @Column(name = "surname")
     @NotNull(message = "Surname cannot be null.")
    @Size(min = 3, max = 35, message = "Surname must be 3-35 characters long.")
    private String surname;

    @Column(name = "email")
    @Email(message = "Enter a valid email address.")
    private String email;
}