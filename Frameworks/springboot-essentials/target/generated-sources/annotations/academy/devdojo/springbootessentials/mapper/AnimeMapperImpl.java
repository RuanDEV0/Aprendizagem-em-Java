package academy.devdojo.springbootessentials.mapper;

import academy.devdojo.springbootessentials.domain.Anime;
import academy.devdojo.springbootessentials.requests.AnimePostRequestBody;
import academy.devdojo.springbootessentials.requests.AnimePutRequestBody;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-12T17:32:42-0400",
    comments = "version: 1.6.0, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
public class AnimeMapperImpl extends AnimeMapper {

    @Override
    public Anime toAnime(AnimePostRequestBody animePostRequestBody) {
        if ( animePostRequestBody == null ) {
            return null;
        }

        Anime.AnimeBuilder anime = Anime.builder();

        anime.name( animePostRequestBody.getName() );

        return anime.build();
    }

    @Override
    public Anime toAnime(AnimePutRequestBody animePutRequestBody) {
        if ( animePutRequestBody == null ) {
            return null;
        }

        Anime.AnimeBuilder anime = Anime.builder();

        anime.id( animePutRequestBody.getId() );
        anime.name( animePutRequestBody.getName() );

        return anime.build();
    }
}
