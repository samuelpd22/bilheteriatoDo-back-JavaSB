package com.desafioTo_doList.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table ( name = "tb_toDoList")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ToDoEntity {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private Long id;

    private String image;

    private String nome;

    private String dataEhora;

    private Boolean realizado;

    private String local;

    @Enumerated(EnumType.STRING)
    private CidadeENUM cidade;


}
