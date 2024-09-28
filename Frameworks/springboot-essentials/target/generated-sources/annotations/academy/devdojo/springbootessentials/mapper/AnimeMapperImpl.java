package academy.devdojo.springbootessentials.mapper;

import academy.devdojo.springbootessentials.domain.Anime;
import academy.devdojo.springbootessentials.requests.AnimePostRequestBody;
import academy.devdojo.springbootessentials.requests.AnimePutRequestBody;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-26T16:05:13-0400",
    comments = "version: 1.6.0, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
public class AnimeMapperImpl extends AnimeMapper {

    @Override
    public Anime toAnime(AnimePostRequestBody animePostRequestBody) {
        if ( animePostRequestBody == null ) {
            return null;
        }

        Anime anime = new Anime();

        return anime;
    }

    @Override
    public Anime toAnime(AnimePutRequestBody animePutRequestBody) {
        if ( animePutRequestBody == null ) {
            return null;
        }

        Anime anime = new Anime();

        return anime;
    }
}
