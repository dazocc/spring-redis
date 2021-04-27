package br.com.dazo.springredis.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/user")
public class UserController {

    UserRepository userRepository;

    @Autowired
    UserController(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @GetMapping
    public ResponseEntity<List<UserEntity>> listar(){
        List<UserEntity> listUser =
                StreamSupport.stream(userRepository.findAll().spliterator(), false)
                        .collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK).body(listUser);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserEntity> buscar(@PathVariable("id") Long id){
        Optional<UserEntity> optionalUser = userRepository.findById(id);
        UserEntity user = optionalUser.isPresent() ? optionalUser.get() : null;
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

    @PostMapping
    public ResponseEntity<UserEntity> salvar(@RequestBody UserEntity user) {
        userRepository.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @PutMapping
    public ResponseEntity<Void> atualizar(@RequestBody UserEntity user) {

        userRepository.save(user);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {

        userRepository.deleteById(id);

        return ResponseEntity.noContent().build();
    }

}
