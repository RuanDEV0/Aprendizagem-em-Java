package academy.devdojo.springbootessentials.util;

import academy.devdojo.springbootessentials.domain.Anime;

public class AnimeCreator {
    public static Anime animeToBeSaved() {
        return Anime.builder().name("Hajime no Ippo").build();
    }
    public static Anime createValidAnime(){
        return Anime.builder().name("Hajimo test valid").id(1L).build();
    }
    public static Anime createUpdateAnime(){
        return Anime.builder().name("Hajimo test update").id(1L).build();
    }
}
