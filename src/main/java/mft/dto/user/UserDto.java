package mft.dto.user;

public record UserDto(
        Long id,
        String name,
        String family,
        String email,
        String password
) {
}
