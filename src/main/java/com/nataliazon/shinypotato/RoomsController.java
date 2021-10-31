package com.nataliazon.shinypotato;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@CrossOrigin(origins = {"http://localhost:4200", "https://shiny-potato-app.herokuapp.com/"})
public class RoomsController {
    private final List<String> availableRooms;
    private final List<String> takenRooms;

    public RoomsController() {
        this.availableRooms = new ArrayList<>();
        this.availableRooms.add("Mango");
        this.availableRooms.add("Banana");
        this.availableRooms.add("Kumquat");
        this.availableRooms.add("Apple");
        this.availableRooms.add("Tangerine");
        this.takenRooms = new ArrayList<>();
    }

    @PostMapping("/reserveRoom")
    void reserveRoom(@RequestBody String roomName) {
        System.out.println("Requesting " + roomName);
        if (!this.availableRooms.contains(roomName)){
            throw new RuntimeException("No such room yo");
        };
        this.availableRooms.remove(roomName);
        this.takenRooms.add(roomName);
    }

    @GetMapping("/allAvailableRooms")
    public List<String> getAllAvailableRooms() {
        System.out.println("Getting available rooms");
        return this.availableRooms;
    }

    @GetMapping("/allTakenRooms")
    public List<String> getAllTakenRooms() {
        System.out.println("Getting taken rooms");
        return this.takenRooms;
    }

}