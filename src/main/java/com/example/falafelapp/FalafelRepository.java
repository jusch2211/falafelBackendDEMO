package com.example.falafelapp;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class FalafelRepository {
    private final List<Falafel> falafels = new ArrayList<>();

    public FalafelRepository() {
        // Demo-Daten
        falafels.add(new Falafel(1L, "Klassische Falafel"));
        falafels.add(new Falafel(2L, "Scharfe Falafel"));
    }

    public List<Falafel> findAll() {
        return new ArrayList<>(falafels);
    }

    public Optional<Falafel> findById(Long id) {
        return falafels.stream().filter(f -> f.getId().equals(id)).findFirst();
    }

    public Falafel save(Falafel falafel) {
        falafels.add(falafel);
        return falafel;
    }

    public boolean deleteById(Long id) {
        return falafels.removeIf(f -> f.getId().equals(id));
    }

    public Optional<Falafel> update(Long id, Falafel updated) {
        return findById(id).map(f -> {
            f.setName(updated.getName());
            return f;
        });
    }
}
