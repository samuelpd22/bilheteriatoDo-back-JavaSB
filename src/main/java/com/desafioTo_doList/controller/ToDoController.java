package com.desafioTo_doList.controller;

import com.desafioTo_doList.dto.ToDoDTO;
import com.desafioTo_doList.entity.CidadeENUM;
import com.desafioTo_doList.entity.ToDoEntity;
import com.desafioTo_doList.repository.ToDoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/todo")
public class ToDoController {

    @Autowired
    private ToDoRepository toDoRepository;


    @PostMapping
    public ResponseEntity<ToDoEntity> criarToDo(@RequestBody ToDoDTO dto){
        ToDoEntity entity = new ToDoEntity();
        BeanUtils.copyProperties(dto, entity );
        return new ResponseEntity(toDoRepository.save(entity), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<ToDoEntity> listarTodos(){
        return new ResponseEntity(toDoRepository.findAll(),HttpStatus.OK);
    }

    @GetMapping("/cidade/{cidade}")
    public List<ToDoEntity> buscarLivrosPorGenero(@PathVariable CidadeENUM cidade) {
        return toDoRepository.findByCidade(cidade);
    }

    @GetMapping("/buscarPorNome")
    public ResponseEntity<List<ToDoEntity>> buscarEventoPorNome(@RequestParam("nome") String nome) {
        List<ToDoEntity> todoList = toDoRepository.findByNomeIgnoreCaseContaining(nome);

        if (todoList.isEmpty()) {
            return ResponseEntity.noContent().build(); // Retorna um código 204 se não houver clientes encontrados
        } else {
            return ResponseEntity.ok(todoList); // Retorna a lista de clientes encontrados com um código 200
        }
    }
}
