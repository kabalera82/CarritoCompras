package dogster;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main entry point for the Spring Boot application.
 * <p>
 * This class bootstraps and launches the Spring Boot application using
 * {@link SpringApplication#run(Class, String...)}.
 */
@SpringBootApplication
public class Application {

    /**
     * Starts the Spring Boot application.
     *
     * @param args command-line arguments passed to the application
     */
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
