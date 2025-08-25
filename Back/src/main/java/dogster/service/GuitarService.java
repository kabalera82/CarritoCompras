package dogster.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dogster.model.Guitar;
import dogster.repositories.GuitarRepositories;

/**
 * Service implementation for Guitar entity.
 * Handles business logic and delegates data access to the Guitar Reepository.
 */

@Service
public class GuitarService implements IGuitarService {

    @Autowired
    private GuitarRepositories guitarRepositories;


    // Method to implement all Guitar Objects ====================================================================
    /**
     * Retrieves a list of all Guitar objects.
     * @return a list of Guitar entities
     */
    @Override
    public List<Guitar> listAllGuitars(){
        return guitarRepositories.findAll();
    }

    // Method to search Guitar by Id =============================================================================
    /**
     * Searches for Guitar by its ID.
     * @param idGuitar the ID of the Guitar
     * @return the Guitar entity if found, otherwise null
     */
    @Override
    public Guitar searchGuitarById(Long idGuitar){
        Guitar guitar = guitarRepositories.findById(idGuitar).orElse(null);
        return guitar;
    }

    // Method to save or update Guitar ==========================================================================
    /**
     * Saver or updates a Guitar entity.
     * @param guitar the Guitar entity to be saved or updated
     * @return the saved or updated Guitar entity
     */
    @Override
    public Guitar saveGuitar (Guitar guitar){
        return guitarRepositories.save(guitar);
    }

    // Method to delete Guitar ===================================================================================
    /**
     * Deletes a Guitar entity.
     * @param guitar the Guitar entity to be deleted
     */
    @Override
    public void deleteGuitar(Guitar guitar){
    guitarRepositories.delete(guitar);
    }    

}
