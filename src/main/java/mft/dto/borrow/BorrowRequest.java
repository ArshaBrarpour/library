package mft.dto.borrow;

import mft.model.enums.BorrowStatus;

import java.time.LocalDateTime;

public record BorrowRequest(
        Long bookId,
        Long userId,
        String bookTitle,
        LocalDateTime loanDate,
        LocalDateTime dueDate,
        LocalDateTime returnDate,
        BorrowStatus status,
        boolean overdue
) {
}
