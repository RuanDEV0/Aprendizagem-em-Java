package academy.devdojo.springbootessentials.mapper;

import academy.devdojo.springbootessentials.domain.Anime;
import academy.devdojo.springbootessentials.requests.AnimePostRequestBody;
import academy.devdojo.springbootessentials.requests.AnimePutRequestBody;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public abstract class AnimeMapper {
    public static final AnimeMapper INSTANCE = Mappers.getMapper(AnimeMapper.class);

    public Anime toAnime(AnimePostRequestBody animePostRequestBody) {
        if (animePostRequestBody == null) {
            return null;
        } else {
            return Anime.builder().name(animePostRequestBody.getName()).build();
        }
    }

    public Anime toAnime(AnimePutRequestBody animePutRequestBody) {
        if (animePutRequestBody == null) {
            return null;
        } else {
            return Anime.builder().name(animePutRequestBody.getName()).id(animePutRequestBody.getId()).build();
        }
    }
}
