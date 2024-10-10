package academy.devdojo.springbootessentials.Integration;

import academy.devdojo.springbootessentials.domain.Anime;
import academy.devdojo.springbootessentials.repository.AnimeRepository;
import academy.devdojo.springbootessentials.util.AnimeCreator;
import academy.devdojo.springbootessentials.util.AnimePostRequestBodyCreator;
import academy.devdojo.springbootessentials.util.AnimePutRequestBodyCreator;
import academy.devdojo.springbootessentials.wrapper.PageableResponse;
import lombok.extern.log4j.Log4j2;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Log4j2
public class AnimeControllerIT {
    @Autowired
    private TestRestTemplate testRestTemplate;
    @LocalServerPort
    private int port;
    @Autowired
    private AnimeRepository animeRepository;

    @Test
    @DisplayName("return list of anime inside page object when successul")
    void list_ReturnsListOfAnimeInsidePageObject_WhenSuccessul() {
        this.animeRepository.deleteAll();
        Anime savedAnime = this.animeRepository.save(AnimeCreator.createValidAnime());

        String expectedName = savedAnime.getName();

        PageableResponse<Anime> animePage = testRestTemplate.exchange("/animes", HttpMethod.GET
                , null, new ParameterizedTypeReference<PageableResponse<Anime>>() {
                }).getBody();

        Assertions.assertThat(animePage).isNotNull();

        Assertions.assertThat(animePage.toList()).isNotEmpty().hasSize(1);
        log.info(animePage.toList());
        Assertions.assertThat(animePage.toList().get(0).getName()).isEqualTo(expectedName);
    }


    @Test
    @DisplayName("return list of anime  when successul")
    void list_ReturnsListOfAnime_WhenSuccessul() {
        this.animeRepository.deleteAll();
        Anime savedAnime = this.animeRepository.save(AnimeCreator.createValidAnime());

        String expectedName = savedAnime.getName();

        List<Anime> animes = testRestTemplate.exchange("/animes/all", HttpMethod.GET
                , null, new ParameterizedTypeReference<List<Anime>>() {
                }).getBody();
        Assertions.assertThat(animes).isNotNull().isNotEmpty().hasSize(1);

        log.info(animes);
        Assertions.assertThat(animes.get(0).getName()).isEqualTo(expectedName);
    }

    @Test
    @DisplayName("findById return anime when successul")
    void findById_ReturnsAnime_WhenSuccessul() {
        Anime savedAnime = this.animeRepository.save(AnimeCreator.createValidAnime());
        Long expectedId = savedAnime.getId();
        Anime anime = testRestTemplate.getForObject("/animes/{id}", Anime.class, expectedId);

        Assertions.assertThat(anime).isNotNull();

        Assertions.assertThat(anime.getId()).isEqualTo(expectedId);
    }

    @Test
    @DisplayName("findByName returns list of anime  when successul")
    void findByName_ReturnsListOfAnime_WhenSuccessul() {
        Anime savedAnime = this.animeRepository.save(AnimeCreator.createValidAnime());

        String expectedName = savedAnime.getName();

        String url = String.format("/animes/find?name=%s", expectedName);

        List<Anime> animes = testRestTemplate.exchange(url, HttpMethod.GET
                , null, new ParameterizedTypeReference<List<Anime>>() {
                }).getBody();

        Assertions.assertThat(animes).isNotNull().isNotEmpty();

        Assertions.assertThat(animes.get(0).getName()).isEqualTo(expectedName);
    }

    @Test
    @DisplayName("findByName returns empty list when anime not found")
    void findByName_ReturnsEmptyList_WhenAnimeNotFound() {
        String url = String.format("/animes/find?name=%s", "RuanOliveira");
        List<Anime> animes = testRestTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<Anime>>() {
        }).getBody();

        Assertions.assertThat(animes).hasSize(0).isEmpty();
    }
//*
//    @Test
//    @DisplayName("save returns animes when successul")
//    void save_ReturnsAnimes_WhenSuccessul() {
//
//        Anime bodyAnime = animeController.save(AnimePostRequestBodyCreator.createAnimePostRequestBoy()).getBody();
//
//        Assertions.assertThat(bodyAnime).isNotNull().isEqualTo(AnimeCreator.createValidAnime());
//    }
//
//    @Test
//    @DisplayName("replace updates animes when successul")
//    void replace_UpdateAnime_WhenSuccessul() {
//        Assertions.assertThatCode(() -> animeController.replace(AnimePutRequestBodyCreator.creatorAnimePutRequestBody()))
//                .doesNotThrowAnyException();
//
//        ResponseEntity<Void> replace = animeController.replace(AnimePutRequestBodyCreator.creatorAnimePutRequestBody());
//        Assertions.assertThat(replace).isNotNull();
//        Assertions.assertThat(replace.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);
//    }
//
//    @Test
//    @DisplayName("delete removes animes when successul")
//    void delete_RemovesAnime_WhenSuccessul() {
//        Assertions.assertThatCode(() -> animeController.delete(10L))
//                .doesNotThrowAnyException();
//
//        ResponseEntity<Void> replace = animeController.delete(10L);
//        Assertions.assertThat(replace).isNotNull();
//        Assertions.assertThat(replace.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);
//    }
//
//    @Test
//    @DisplayName("delete removes all animes when successul")
//    void delete_RemovesAllAnime_WhenSuccessul() {
//        Assertions.assertThatCode(() -> animeController.deleteAll())
//                .doesNotThrowAnyException();
//
//        ResponseEntity<Void> replace = animeController.deleteAll();
//        Assertions.assertThat(replace).isNotNull();
//        Assertions.assertThat(replace.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);
//    }
}
