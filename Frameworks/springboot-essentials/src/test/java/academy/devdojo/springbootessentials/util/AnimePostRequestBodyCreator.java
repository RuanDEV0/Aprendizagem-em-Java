package academy.devdojo.springbootessentials.util;

import academy.devdojo.springbootessentials.requests.AnimePostRequestBody;

public class AnimePostRequestBodyCreator {
    public static AnimePostRequestBody createAnimePostRequestBoy(){
        return AnimePostRequestBody.builder()
                .name(AnimeCreator.animeToBeSaved().getName())
                .build();
    }
}
