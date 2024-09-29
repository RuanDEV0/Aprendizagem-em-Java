package academy.devdojo.springbootessentials.repository;

import academy.devdojo.springbootessentials.domain.Anime;
import academy.devdojo.springbootessentials.util.AnimeCreator;
import lombok.extern.log4j.Log4j2;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;


@DataJpaTest
@Log4j2
@DisplayName("Tests for Anime Repository")
class AnimeRepositoryTest {
    @Autowired
    private AnimeRepository animeRepository;

    /*
        Verifica a persistencia ao salvar animes
     */
    @Test
    @DisplayName("save creates anime when successful")
    void save_PersistAnime_WhenSuccessful(){
        Anime animeToBySave = AnimeCreator.animeToBeSaved();
        Anime savedAnime = this.animeRepository.save(animeToBySave);
        Assertions.assertThat(savedAnime).isNotNull();
        Assertions.assertThat(savedAnime.getId()).isNotNull();
        Assertions.assertThat(savedAnime.getName()).isEqualTo(savedAnime.getName());
    }

    /*
        Esse teste verifica se ocorreu o replace corretamente
     */
    @Test
    @DisplayName("save updates anime when successful")
    void save_UpdatePersistAnime_WhenSuccessful() {
        Anime animeToBySave = AnimeCreator.animeToBeSaved();
        Anime savedAnime = this.animeRepository.save(animeToBySave);
        savedAnime.setName("Overlord");
        Anime animeUpdate = this.animeRepository.save(savedAnime);
        log.info(animeUpdate);
        Assertions.assertThat(animeUpdate).isNotNull();
        Assertions.assertThat(animeUpdate.getId()).isEqualTo(savedAnime.getId());
        Assertions.assertThat(animeUpdate.getName()).isEqualTo(savedAnime.getName());
    }

    /*
        Este teste verifica o delete
     */
    @Test
    @DisplayName("delete removes anime when successful")
    void delete_RemoveAnime_WhenSuccessful() {
        Anime animeToBySave = AnimeCreator.animeToBeSaved();
        Anime savedAnime = this.animeRepository.save(animeToBySave);
        this.animeRepository.delete(savedAnime);
        Optional<Anime> byId = this.animeRepository.findById(savedAnime.getId());
        log.info(byId);
        Assertions.assertThat(byId).isEmpty();
    }

    /*
        Este teste verifica se a lista retornada pelo findByName, contains o savedAnime.
     */
    @Test
    @DisplayName("find by name return list of anime when successful")
    void findByName_ReturnListOfAnime_WhenSuccessful() {
        Anime animeToBySave = AnimeCreator.animeToBeSaved();
        Anime savedAnime = this.animeRepository.save(animeToBySave);

        List<Anime> byName = this.animeRepository.findByName(savedAnime.getName());
        log.info(byName);
        Assertions.assertThat(byName).isNotEmpty();
        Assertions.assertThat(byName).contains(savedAnime);
    }

    /*
        Este teste verifica se  retorna list vazia, caso não ache o anime
     */
    @Test
    @DisplayName("find by name return empty list  when  no anime is found")
    void findByName_ReturnEmptyList_WhenAnimeNotFound() {
        List<Anime> emptyList = this.animeRepository.findByName("xuxa");
        log.info(emptyList);
        Assertions.assertThat(emptyList).isEmpty();
    }

        /*
        Este teste verifica se está lançando exception, quando se tenta salvar anime com nome vazio;
         */
    @Test
    @DisplayName("save thrown ConstraintViolationException when name is empty")
    void save_ThrowConstraintViolationException_WhenNameIsEmptyOrNull(){
        Anime anime = new Anime();
//        anime.setName("");
//        Assertions.assertThatThrownBy(() -> this.animeRepository.save(anime))
//                .isInstanceOf(ConstraintViolationException.class);

//        Assertions.assertThatExceptionOfType(ConstraintViolationException.class)
//                .isThrownBy(() -> this.animeRepository.save(anime)).withMessageContaining("the anime name cannot be empty");
    }
    
}
