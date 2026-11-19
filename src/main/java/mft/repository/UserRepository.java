package mft.repository;

import jakarta.persistence.LockModeType;
import mft.model.User;
import mft.model.enums.BorrowStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByName(String name);

    List<User> findByName(String name);

    List<User> findByFamily(String family);

    List<User> findByFamilyAndName(String family, String name);

    Optional<User> findByEmail(String email);

    boolean existsByEmail(String email);

    @Query("select u from User u where u.id = :id")
    Optional<User> findByIdForUpdate(@Param("id") Long id);
}
