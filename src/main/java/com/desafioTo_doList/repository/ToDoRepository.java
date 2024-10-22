package com.desafioTo_doList.repository;

import com.desafioTo_doList.entity.CidadeENUM;
import com.desafioTo_doList.entity.ToDoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ToDoRepository extends JpaRepository<ToDoEntity, Long> {

    List<ToDoEntity> findByCidade(CidadeENUM cidade);
    List<ToDoEntity> findByNomeIgnoreCaseContaining(String nome);
}
