package y.repository;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;
import y.domain.Emprunt;

/**
 * Spring Data SQL repository for the Emprunt entity.
 */
@SuppressWarnings("unused")
@Repository
public interface EmpruntRepository extends JpaRepository<Emprunt, Long> {}
