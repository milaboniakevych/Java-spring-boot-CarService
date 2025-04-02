package org.example.javaspringboothw.controller;

import lombok.RequiredArgsConstructor;
import org.example.javaspringboothw.properties.Fuels;
import org.example.javaspringboothw.properties.ReferenceDataProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/test")
public class ReferenceDataController {
    private final ReferenceDataProperties referenceDataProperties;

    @GetMapping("/engine-types")
    public ResponseEntity<List<String>> getEngineTypes() {
        return ResponseEntity.ok(referenceDataProperties.getEngineTypes());
    }

    @GetMapping("/fuel-types")
    public ResponseEntity<List<Fuels>> getFuels() {
        return ResponseEntity.ok(referenceDataProperties.getFuels());
    }

    @GetMapping("/fuel-types/{name}")
    public ResponseEntity<Fuels> getFuelTypeByName(@PathVariable String name) {
        Optional<Fuels> currentFuel = Optional.ofNullable(referenceDataProperties)
                .map(ReferenceDataProperties::getFuels)
                .stream()
                .flatMap(Collection::stream)
                .filter( fuel -> Objects.equals(fuel.getName(), name))
                .findFirst();
        return ResponseEntity.of(currentFuel);
    }
}
