package dev.kirill.dogandowner.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder

@Entity
@Table(name = "dog")
public class Dog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Long id;

    @Column(name = "nickname")
    public String nickname;
    public String breed;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;

    public LocalDate registrationDate;
    public LocalDate dateOfBirth;

}
