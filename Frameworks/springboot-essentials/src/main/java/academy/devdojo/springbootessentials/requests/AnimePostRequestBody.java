package academy.devdojo.springbootessentials.requests;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AnimePostRequestBody {
    private String name;
    public AnimePostRequestBody(){

    }
    @JsonCreator
    public AnimePostRequestBody(@JsonProperty("name") String name){
        this.name = name;
    }
}
