package mft.dto.fine;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record FineDto(
        Long id,
        Long borrowId,
        String bookTitle,
        BigDecimal amount,
        boolean paid,
        LocalDateTime createdAt
) {
}
