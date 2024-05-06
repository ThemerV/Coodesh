package com.example;

/**
 * Create an implementation of a Rest API .
 * Expose an API. Feel free to explore possibilities/functionalities/capabilities following Rest standard.
 * We suggest that your implementation have at least a CRUD scenario.
 *
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@RestController
public class TASK5 {

    private final Map<Long, String> data = new HashMap<>();
    private long idCounter = 0;

    //Gets all items
    @GetMapping("/items")
    public Map<Long, String> getAllItems() {
        return data;
    }

    //Store new item
    @PostMapping("/items")
    public String addItem(@RequestBody String item) {
        long id = idCounter++;
        data.put(id, item);
        return "Item added with ID: " + id;
    }

    //Get a specific item using the ID
    @GetMapping("/items/{id}")
    public String getItem(@PathVariable Long id) {
        return data.getOrDefault(id, "Item not found");
    }

    //Update an item using the ID
    @PutMapping("/items/{id}")
    public String updateItem(@PathVariable Long id, @RequestBody String item) {
        if (data.containsKey(id)) {
            data.put(id, item);
            return "Item updated successfully";
        } else {
            return "Item not found";
        }
    }

    //Delete an item using the ID
    @DeleteMapping("/items/{id}")
    public String deleteItem(@PathVariable Long id) {
        if (data.containsKey(id)) {
            data.remove(id);
            return "Item deleted successfully";
        } else {
            return "Item not found";
        }
    }

    //Initiates spring application on 8080
    public static void main(String[] args) {
        SpringApplication.run(TASK5.class, args);
    }
}
