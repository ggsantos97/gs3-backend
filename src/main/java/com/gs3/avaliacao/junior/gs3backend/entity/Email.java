package com.gs3.avaliacao.junior.gs3backend.entity;

import javax.persistence.*;

//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
@Entity
@Table
public class Email {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Column
    private String endereco;
}
