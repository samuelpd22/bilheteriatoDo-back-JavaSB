package com.desafioTo_doList.dto;

import com.desafioTo_doList.entity.CidadeENUM;

public record ToDoDTO(String nome, String image, String dataEhora, Boolean realizado, String local, CidadeENUM cidade) {
}
