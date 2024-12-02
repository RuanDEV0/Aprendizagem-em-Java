package academy.devdojo.springbootessentials.requests;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AnimePostRequestBody {
    @NotNull(message = "the anime name cannot be empty")
    private String name;
    public AnimePostRequestBody(){

    }
    @JsonCreator
    public AnimePostRequestBody(@JsonProperty("name") String name){
        this.name = name;
    }
}
