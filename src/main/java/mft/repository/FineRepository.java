package mft.repository;

import mft.model.Fine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FineRepository extends JpaRepository<Fine, Long> {
}
