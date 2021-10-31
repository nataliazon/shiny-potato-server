package com.nataliazon.shinypotato;

import org.springframework.web.bind.annotation.*;

import java.util.List;

// From https://www.baeldung.com/spring-boot-angular-web
//Of course, the implementation detail worth noting here is the use
// of the @CrossOrigin annotation. As the name implies, the annotation
// enables Cross-Origin Resource Sharing (CORS) on the server.
//This step isn't always necessary, but since we're deploying
// our Angular frontend to http://localhost:4200,
// and our Boot backend to http://localhost:8080,
// the browser would otherwise deny requests from one to the other.

@RestController
@CrossOrigin(origins = {"http://localhost:4200", "https://shiny-potato-app.herokuapp.com/"})
public class PlayerController {
    private final PlayerRepository playerRepository;

    public PlayerController(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    // fetches all the Player entities from the database
    @GetMapping("/players")
    public List<Player> getPlayers() {
        return (List<Player>) playerRepository.findAll();
    }

    // persists a new entity in the database
    @PostMapping("/players")
    void addUser(@RequestBody Player player) {
        playerRepository.save(player);
    }
}