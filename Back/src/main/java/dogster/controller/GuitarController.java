package dogster.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dogster.exception.NotFoundException;
import dogster.model.Guitar;
import dogster.service.IGuitarService;

/**
 * Rest controller for managing Guitar entities.
 * Provides endpoints for CRUD operations on guitars.
 * 
 * Base path: http://localhost:8080/MusicShop/
 * Allows cross-origin requests from React frontend at (http://localhost:3000) y Vite en (http://localhost:5173).
 */
@RestController                                 // http://localhost:8080/MusicShop/ (application path)
@RequestMapping("MusicShop")                    // http://localhost:8080/MusicShop/
//@CrossOrigin(value = "http://localhost:3000") --  UNUSED ---  //React port Blocked to Allow both ports
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:5173"}) // To allow all ports

public class GuitarController {

    // Logger === Must be from package org.slf4j to import this class. =================================================
    /** Logger for this class */
    private static final Logger logger
            = // Create de variable logger and assign the class name to the logger this is done to identify the source of the log messages.
            LoggerFactory.getLogger(GuitarController.class);

    /** Service for Guitar business logic */
    @Autowired
    private IGuitarService guitarService;

    // Receive GET request at /guitars  ====== http://localhost:8080/rrhh-app/guitars ==================================
    /**
     * Retrieves a list of all Guitar entities.
     * Get /guitars
     * @return list of Guitar objects
     */
    @GetMapping("/guitars")
    public List<Guitar> listAllGuitars() {
        var guitars = guitarService.listAllGuitars();
        System.out.println("Number of Guitars: " + guitars.size());
        guitars.forEach(System.out::println);
        return guitars;
    }

    //Insertion by Post Method ===================================================================================
    /**
     * Saves a new guitar entity.
     * Post /guitars
     * @param guitar the Guitar object to save
     * @return the saved Guitar object
     */
    @PostMapping("/guitars")
    public Guitar saveGuitar(@RequestBody Guitar guitar) {
        logger.info("Guitar to add: " + guitar);
        return guitarService.saveGuitar(guitar);
    }

    // Search a guitar by Get Method ===================================================================================
    /**
     * Retrieves a guitar by its Id.
     * Get /guitars/{idGuitar}
     * @param idGuitar th Id of the guitar to retrieve
     * @return ResponseEntity containing the Guitar Object if found it else returns NotFoundException.
     */
    @GetMapping("/guitars/{idGuitar}")
    public ResponseEntity<Guitar> searchGuitarById(@PathVariable Long idGuitar) {
        Guitar guitar = guitarService.searchGuitarById(idGuitar);
        if (guitar == null) {
            throw new NotFoundException("Guitar not found with id: " + idGuitar);
        }
        return ResponseEntity.ok(guitar);
    }

    // Update a guitar by Put Method ===================================================================================
    /**
     * Updates an existing Guitar entity.
     * PUT /guitars/{idGuitar}
     * @param idGuitar the Id of the guitar to update
     * @param guitarDetails the Guitar object containing updated details 
     * @return ResponseEntity containing the updated Guitar object if found it else returns NotFoundException.
     */
    @PutMapping("/guitars/{idGuitar}")
    public ResponseEntity<Guitar> updatedGuitar(@PathVariable Long idGuitar, @RequestBody Guitar guitarDetails) {
        Guitar guitar = guitarService.searchGuitarById(idGuitar);
        if (guitar == null) {
            throw new NotFoundException("Guitar not found with id: " + idGuitar);
        }
        guitar.setName(guitarDetails.getName());
        guitar.setImage(guitarDetails.getImage());
        guitar.setPrice(guitarDetails.getPrice());
        guitarService.saveGuitar(guitar);
        return ResponseEntity.ok(guitarDetails);
    }

    // Delete a guitar by Delete Method ===================================================================================
    /**
     * Deletes a guitar by its Id.
     * DELETE /guitars/{idGuitar}
     * @param idGuitar the Id of the guitar to delete
     * @return ResponseEntity containing a map with a boolean indicating if the deletion was successful.
     */
    @DeleteMapping("/guitars/{idGuitar}")
    public ResponseEntity<Map<String, Boolean>> deleteGuitar(@PathVariable Long idGuitar) {
        Guitar guitar = guitarService.searchGuitarById(idGuitar);
        if (guitar == null) {
            throw new NotFoundException("Guitar not found with id: " + idGuitar);
        }
        guitarService.deleteGuitar(guitar);
        //Json {"eliminado": "true"}
        Map<String, Boolean> respuesta = new HashMap<>();
        respuesta.put("eliminado", Boolean.TRUE);
        return ResponseEntity.ok(respuesta);
    }
}
