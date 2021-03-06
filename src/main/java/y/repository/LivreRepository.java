package y.repository;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;
import y.domain.Livre;

/**
 * Spring Data SQL repository for the Livre entity.
 */
@SuppressWarnings("unused")
@Repository
public interface LivreRepository extends JpaRepository<Livre, Long> {}
