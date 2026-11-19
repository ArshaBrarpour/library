package mft.repository;

import mft.model.Reservation;
import mft.model.enums.ReservationStatus;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    List<Reservation> findByBookIdAndStatusOrderByCreatedAtAscIdAsc(Long bookId, ReservationStatus status);

    boolean existsByUserIdAndBookIdAndStatus(Long userId, Long bookId, ReservationStatus status);

    boolean existsByBookIdAndStatus(Long bookId, ReservationStatus status);

    List<Reservation> findByUserIdOrderByCreatedAtDesc(Long userId);

    long countByBookIdAndStatusAndCreatedAtBefore(Long bookId, ReservationStatus status, LocalDateTime createdAt);

    @Query("select r.book.id from Reservation r where r.id = :id")
    Optional<Long> findBookIdById(@Param("id") Long id);
}
