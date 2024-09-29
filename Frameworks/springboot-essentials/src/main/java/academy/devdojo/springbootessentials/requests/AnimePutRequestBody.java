package academy.devdojo.springbootessentials.requests;

import lombok.Builder;
import lombok.Data;
import org.springframework.boot.autoconfigure.batch.BatchDataSource;

@Data
@Builder
public class AnimePutRequestBody {
    private Long id;
    private String name;

}
