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

    @Test
    @DisplayName("save updates anime when successful")
    void save_UpdatePersistAnime_WhenSuccessful() {
        Anime animeToBySave = creatAnime();
        Anime savedAnime = this.animeRepository.save(animeToBySave);
        savedAnime.setName("Overlord");
        Anime animeUpdate = this.animeRepository.save(savedAnime);
        log.info(animeUpdate);
        Assertions.assertThat(animeUpdate).isNotNull();
        Assertions.assertThat(animeUpdate.getId()).isEqualTo(savedAnime.getId());
        Assertions.assertThat(animeUpdate.getName()).isEqualTo(savedAnime.getName());
    }

    @Test
    @DisplayName("delete removes anime when successful")
    void delete_RemoveAnime_WhenSuccessful() {
        Anime animeToBySave = creatAnime();
        Anime savedAnime = this.animeRepository.save(animeToBySave);
        this.animeRepository.delete(savedAnime);
        Optional<Anime> byId = this.animeRepository.findById(savedAnime.getId());
        log.info(byId);
        Assertions.assertThat(byId).isEmpty();
    }

    @Test
    @DisplayName("find by name return list of anime when successful")
    void findByName_ReturnListOfAnime_WhenSuccessful() {
        Anime animeToBySave = creatAnime();
        Anime savedAnime = this.animeRepository.save(animeToBySave);

        List<Anime> byName = this.animeRepository.findByName(savedAnime.getName());
        log.info(byName);
        Assertions.assertThat(byName).isNotEmpty();
        Assertions.assertThat(byName).contains(savedAnime);
    }

    @Test
    @DisplayName("find by name return empty list  when  no anime is found")
    void findByName_ReturnEmptyList_WhenAnimeNotFound() {
        List<Anime> emptyList = this.animeRepository.findByName("xuxa");
        log.info(emptyList);
        Assertions.assertThat(emptyList).isEmpty();
    }
    
    private Anime creatAnime() {
        return Anime.builder().name("Hajime no Ippo").build();
    }
}
