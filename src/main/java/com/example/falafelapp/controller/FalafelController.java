package com.example.falafelapp;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/falafel")
@CrossOrigin(origins = "*") // erlaubt Flutter Web Zugriff
public class FalafelController {

    private final FalafelRepository repository;

    public FalafelController(FalafelRepository repository) {
        this.repository = repository;
    }

    // GET /falafel
    @GetMapping
    public List<Falafel> getAll() {
        return repository.findAll();
    }

    // POST /falafel
    @PostMapping
    public Falafel create(@RequestBody Falafel falafel) {
        return repository.save(falafel);
    }

    // PUT /falafel/{id}
    @PutMapping("/{id}")
    public ResponseEntity<Falafel> update(
            @PathVariable Long id,
            @RequestBody Falafel falafel
    ) {
        return repository.update(id, falafel)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // DELETE /falafel/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        boolean removed = repository.deleteById(id);
        if (removed) return ResponseEntity.ok().build();
        return ResponseEntity.notFound().build();
    }
}
