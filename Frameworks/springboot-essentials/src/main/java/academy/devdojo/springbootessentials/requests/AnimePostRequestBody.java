package academy.devdojo.springbootessentials.requests;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class AnimePostRequestBody {
    @NotEmpty(message = "the anime name cannot be empty")
    private String name;
}
