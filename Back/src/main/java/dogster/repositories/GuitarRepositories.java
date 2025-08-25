package dogster.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import dogster.model.Guitar;

/**
 * Repository interface for {@link Guitar} entity.
 * <p>
 * Extendes {@link Jpa Repository} to provide CRUD operateions and query methos for the Guitar table.
 * </p>
 * 
 * @autor dogster
 * @see org.springframework.data.jpa.repository.JpaReopository
 * @param <Guitar> the entity type
 * @param <Long> the tyoe of the entity's identifyer.
 */

public interface GuitarRepositories extends JpaRepository<Guitar, Long> {}
