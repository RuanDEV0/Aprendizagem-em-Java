package academy.devdojo.springbootessentials.repository;

import academy.devdojo.springbootessentials.domain.Anime;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
@DisplayName("Tests for Anime Repository")
class AnimeRepositoryTest {
    @Autowired
    private AnimeRepository animeRepository;
    @Test
    @DisplayName("save creates anime when successful")
    void save_PersistAnime_WhenSuccessful(){
        Anime animeToBySave = creatAnime();
        Anime savedAnime = this.animeRepository.save(animeToBySave);
        Assertions.assertThat(savedAnime).isNotNull();
        Assertions.assertThat(savedAnime.getId()).isNotNull();
        Assertions.assertThat(savedAnime.getName()).isEqualTo(savedAnime.getName());
    }

    private Anime creatAnime() {
        return Anime.builder().name("Hajime no Ippo").build();
    }
}