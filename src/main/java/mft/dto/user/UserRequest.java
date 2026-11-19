package mft.dto.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UserRequest(
        @NotBlank(message = "وارد کردن اسم الزامی است")
        @Size(max = 255)
        String name,

        @Email
        String email,

        @NotBlank(message = "وارد کردن پسورد الزامی است")
        @Size(max = 255)
        String password

) {
}
