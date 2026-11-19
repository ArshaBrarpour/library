package mft.dto.fine;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record FineRequest(
        Long borrowId,
        String bookTitle,
        BigDecimal amount,
        boolean paid,
        LocalDateTime createdAt
) {
}
