package mft.dto.book;

public record BookDto(
        Long id,
        String title,
        String author,
        String category,
        String isbn,
        int totalCopies,
        int availableCopies,
        boolean available
        ) {
}
