package dogster.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/** 
 * Represents a Guitar entity for the MusicShop application.
 * Stores information about a guitar product, including its name, image path, description, and price.
 * 
 * <p>
 * The image field should contain the relative path to the image in the frontend's public/img directory.
 * </p>
 * 
 * Example:
 * <pre>
 *     Guitar guitar = new Guitar(1L, "Fender Stratocaster", "img/stratocaster.jpg", "Classic electric guitar", 1200.00);
 * </pre>
 * 
 * @author YourName
 */

// Annotations ===========================================================================================================
@Entity                                                 // To create entity class 
@Data                                                   // To generate getters & setters
@NoArgsConstructor                                      // To generate constructor with no arguments
@AllArgsConstructor                                     // To generate constructor with all arguments
@ToString                                               // To generate toString method
//@JsonAutoDetect(fieldVisibility = Visibility.ANY)       // To visibility of all fields for JSON

// Class Definition ======================================================================================================
public class Guitar {    
    /** Unique identifier for the entity */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idGuitar;
    private String name;
    private String image; /** Relative path to the guitar's image located in the frontend's public/img directory */
    private String description;
    private double price;
    private int stock;
    
}

// Constructors imported by lombok =======================================================================================

// Getters & Setters & ToString imported==================================================================================