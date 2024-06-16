package com.clash.guide.controllers;

import com.clash.guide.domain.Troop;
import com.clash.guide.services.TroopService;
import com.clash.guide.services.impl.TroopServiceImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TroopController {

    private final TroopService troopService;

    @Value("${KEY}")
    private String KEY;

    private TroopController(final TroopServiceImpl troopService) {
        this.troopService = troopService;
    }

    /**
     * Function to add a Troop.
     * @param key   This field is required for security purpose.
     * @param troop The actual Troop to be added.
     * @return returns a String response.
     */
    @PostMapping("/add-troop")
    ResponseEntity<String> addTroop(
            @RequestParam(required = false) String key,
            @RequestBody Troop troop
    ) {
        if (key != null && key.equals(KEY)) {
            troopService.addTroop(troop);
            return new ResponseEntity<>(
                    "Troop added successfully!",
                    HttpStatus.CREATED
            );
        } else if (key != null) {
            return new ResponseEntity<>(
                    "Invalid key!",
                    HttpStatus.UNAUTHORIZED
            );
        } else {
            return new ResponseEntity<>(
                    "This operation requires a key, ex: /add-troop?key=KEY",
                    HttpStatus.UNAUTHORIZED
            );
        }
    }

    /**
     * Function to get all Troops.
     * @return returns a String response.
     */
    @GetMapping("/get-all-troops")
    ResponseEntity<Page<Troop>> getAllTroops(Pageable pageable) {
        return new ResponseEntity<>(
                troopService.getAllTroops(pageable),
                HttpStatus.OK
        );
    }

    /**
     * Function to update a Troop.
     * @param key   This field is required for security purpose.
     * @param troop The actual Troop to be added.
     * @return returns a String response.
     */
    @PatchMapping("/update-troop")
    ResponseEntity<String> updateTroop(
            @RequestParam(required = false) String key,
            @RequestBody Troop troop
    ) {
        if (key != null && key.equals(KEY)) {
            troopService.updateTroop(troop);
            return new ResponseEntity<>(
                    "Troop updated Successfully!",
                    HttpStatus.OK
            );
        } else if (key != null) {
            return new ResponseEntity<>(
                    "Invalid key!",
                    HttpStatus.UNAUTHORIZED
            );
        } else {
            return new ResponseEntity<>(
                    "This operation requires a key, ex: /update-troop?key=KEY",
                    HttpStatus.UNAUTHORIZED
            );
        }
    }

    /**
     * Function to delete a Troop.
     * @param key This field is required for security purpose.
     * @param _id The id of the Troop to be deleted.
     * @return returns a String response.
     */
    @DeleteMapping("/delete-troop")
    ResponseEntity<String> deleteTroop(
            @RequestParam(required = false) String key,
            @RequestParam String _id
    ) {
        if (key != null && key.equals(KEY)) {
            if (troopService.isExits(_id)) {
                troopService.deleteTroop(_id);
                return new ResponseEntity<>(
                        "Troop removed successfully!",
                        HttpStatus.OK
                );
            } else {
                return new ResponseEntity<>(
                        "Pokemon not found!",
                        HttpStatus.NOT_FOUND
                );
            }
        } else if (key != null) {
            return new ResponseEntity<>(
                    "Invalid key!",
                    HttpStatus.UNAUTHORIZED
            );
        } else {
            return new ResponseEntity<>(
                    "This operation requires a key, ex: /delete-troop?key=KEY",
                    HttpStatus.UNAUTHORIZED
            );
        }
    }

    /**
     * Function to delete all Troops.
     * @param key This field is required for security purpose.
     * @return returns a String response.
     */
    @DeleteMapping("/delete-all-troops")
    ResponseEntity<String> deleteAllTroops(
            @RequestParam(required = false) String key
    ) {
        if (key != null && key.equals(KEY)) {
            troopService.deleteAllTroop();
            return new ResponseEntity<>(
                    "All troops removed successfully!",
                    HttpStatus.OK
            );
        } else if (key != null) {
            return new ResponseEntity<>(
                    "Invalid key!",
                    HttpStatus.UNAUTHORIZED
            );
        } else {
            return new ResponseEntity<>(
                    "This operation requires a key, ex: /delete-all-troops?key=KEY",
                    HttpStatus.UNAUTHORIZED
            );
        }
    }
}
