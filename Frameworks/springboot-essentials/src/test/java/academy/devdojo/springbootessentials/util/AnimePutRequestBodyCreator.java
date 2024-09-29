package academy.devdojo.springbootessentials.util;

import academy.devdojo.springbootessentials.requests.AnimePutRequestBody;

public class AnimePutRequestBodyCreator {

    public static AnimePutRequestBody creatorAnimePutRequestBody(){
        return AnimePutRequestBody.builder()
                .name(AnimeCreator.createUpdateAnime().getName())
                .id(AnimeCreator.createUpdateAnime().getId())
                .build();
    }
}
