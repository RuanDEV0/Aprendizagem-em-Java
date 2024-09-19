package academy.devdojo.springbootessentials.requests;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AnimePostRequestBody {
    @NotEmpty(message = "the anime name cannot be empty")
    @NotNull(message = "the anime name, cannot be null")
    private String name;
}
