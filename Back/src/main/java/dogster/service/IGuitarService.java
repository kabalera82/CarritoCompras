package dogster.service;

import java.util.List;

import dogster.model.Guitar;

/**
 * Service interface for Guitar entity.
 * Defines the contract for business logic operations related to Guitar.
 */
public interface IGuitarService {
    
    /**
     * Retrieves a list of all Guitar objects
     * @return a list of Guitar entities
     */
    public List<Guitar> listAllGuitars();

    /**
     * Searches for a Guitar by  its ID.
     * @param idGuitar the ID of the Guitar
     * @return the Guitar entity if found, otherwise null 
     */
    public Guitar searchGuitarById(Long idGuitar);

    /**
     * Saves or updates a Guitar entity.
     * @param guitar the Guitar entity to be saved or updated
     * @return the saved or updated Guitar entity
     */
    public Guitar saveGuitar(Guitar guitar);
    
    /**
     * Deletes a Guitar entity.
     * @param guitar the Guitar entity to be deleted
     */
    public void deleteGuitar(Guitar guitar);

}
