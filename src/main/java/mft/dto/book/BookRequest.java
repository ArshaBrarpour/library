package mft.dto.book;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record BookRequest(
        @NotBlank(message = "عنوان کتاب الزامی است")
        @Size(max = 255) String title,

        @NotBlank(message = "نام نویسنده الزامی است")
        @Size(max = 255) String author,

        @NotBlank(message = "دسته‌بندی الزامی است")
        @Size(max = 100) String category,

        @NotBlank(message = "شابک الزامی است")
        @Size(max = 20) String isbn,

        @Min(value = 1, message = "تعداد نسخه‌ها باید حداقل ۱ باشد")
        int totalCopies
) {
}
