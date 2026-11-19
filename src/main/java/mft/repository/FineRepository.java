package mft.repository;

import jakarta.persistence.LockModeType;
import mft.model.Fine;
import mft.model.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface FineRepository extends JpaRepository<Fine, Long> {

    @Query("select sum(f.amount) from Fine f where f.user.id = :userId and f.paid = false")
    BigDecimal sumUnpaidAmount(@Param("userId") Long userId);

    default BigDecimal unpaidTotal(Long userId) {
        BigDecimal sum = sumUnpaidAmount(userId);
        return sum == null ? BigDecimal.ZERO : sum;
    }

    @EntityGraph(attributePaths = {"loan", "loan.book"})
    List<Fine> findByUserIdOrderByCreatedAtDesc(Long userId);


    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("select f from Fine f where f.id = :id")
    Optional<Fine> findByIdForUpdate(@Param("id") Long id);

}
