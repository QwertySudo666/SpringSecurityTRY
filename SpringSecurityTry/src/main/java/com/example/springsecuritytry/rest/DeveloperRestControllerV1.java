package com.example.springsecuritytry.rest;

import com.example.springsecuritytry.model.Developer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/api/v1/developers")
public class DeveloperRestControllerV1 {
    private final List<Developer> DEVELOPERS = Stream.of(
            new Developer(1L, "Satan", "Godovich"),
            new Developer(2L, "Jesus", "Godovich"),
            new Developer(3L, "Shaitan", "Shaitanovich")
    ).collect(Collectors.toList());

    @GetMapping
    public List<Developer> getAll() {
        return DEVELOPERS;
    }

    @GetMapping("/{id}")
    public Developer getById(@PathVariable Long id) {
        return DEVELOPERS.stream().filter(dev -> dev.getId().equals(id)).findFirst().orElse(null);
    }
}
