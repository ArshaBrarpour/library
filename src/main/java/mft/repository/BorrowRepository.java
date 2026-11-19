package mft.repository;

import jakarta.persistence.LockModeType;
import mft.model.Borrow;
import mft.model.enums.BorrowStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface BorrowRepository extends JpaRepository<Borrow, Long> {

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("select b from Borrow b where b.id = :id")
    Optional<Borrow> findByIdForUpdate(@Param("id") Long id);


    long countByUserIdAndStatus(Long userId, BorrowStatus status);

    boolean existsByUserIdAndBookIdAndStatus(Long userId, Long bookId, BorrowStatus status);

    boolean existsByUserIdAndStatusAndDueDateBefore(Long userId, BorrowStatus status, LocalDateTime now);

    boolean existsByBookIdAndStatus(Long bookId, BorrowStatus status);

    long countByBookIdAndStatus(Long bookId, BorrowStatus status);

    List<Borrow> findByUserIdAndStatusOrderByDueDateAsc(Long userId, BorrowStatus status);

    Page<Borrow> findByUserIdAndStatus(Long userId, BorrowStatus status, Pageable pageable);

    List<Borrow> findByUserIdAndStatusAndDueDateBefore(Long userId, BorrowStatus status, LocalDateTime now);
}
