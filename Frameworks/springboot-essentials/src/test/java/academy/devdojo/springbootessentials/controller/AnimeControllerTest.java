package academy.devdojo.springbootessentials.controller;

import academy.devdojo.springbootessentials.domain.Anime;
import academy.devdojo.springbootessentials.requests.AnimePostRequestBody;
import academy.devdojo.springbootessentials.requests.AnimePutRequestBody;
import academy.devdojo.springbootessentials.service.AnimeService;
import academy.devdojo.springbootessentials.util.AnimeCreator;
import academy.devdojo.springbootessentials.util.AnimePostRequestBodyCreator;
import academy.devdojo.springbootessentials.util.AnimePutRequestBodyCreator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
class AnimeControllerTest {
    @InjectMocks
    private AnimeController animeController;
    @Mock
    private AnimeService animeServiceMock;

    @BeforeEach
    void setUp() {
        PageImpl<Anime> animePage = new PageImpl<>(List.of(AnimeCreator.createValidAnime()));
        BDDMockito.when(animeServiceMock.listAll(ArgumentMatchers.any()))
                .thenReturn(animePage);
        BDDMockito.when(animeServiceMock.listAllNoPageable())
                .thenReturn(List.of(AnimeCreator.createValidAnime()));
        BDDMockito.when(animeServiceMock.findByIdOrThrowBadRequestException(ArgumentMatchers.anyLong()))
                .thenReturn(AnimeCreator.createValidAnime());
        BDDMockito.when(animeServiceMock.findByName(ArgumentMatchers.anyString()))
                .thenReturn(List.of(AnimeCreator.createValidAnime()));
        BDDMockito.when(animeServiceMock.save(ArgumentMatchers.any(AnimePostRequestBody.class)))
                .thenReturn(AnimeCreator.createValidAnime());
        BDDMockito.doNothing().when(animeServiceMock).replace(ArgumentMatchers.any(AnimePutRequestBody.class));
        BDDMockito.doNothing().when(animeServiceMock).delete(ArgumentMatchers.anyLong());
        BDDMockito.doNothing().when(animeServiceMock).deleteAll();
    }

    @Test
    @DisplayName("return list of anime inside page object when successul")
    void list_ReturnsListOfAnimeInsidePageObject_WhenSuccessul() {
        String expectedName = AnimeCreator.createValidAnime().getName();
        Page<Anime> animePage = animeController.list(null).getBody();

        Assertions.assertThat(animePage).isNotNull();

        Assertions.assertThat(animePage.toList()).isNotEmpty().hasSize(1);

        Assertions.assertThat(animePage.toList().get(0).getName()).isEqualTo(expectedName);
    }

    @Test
    @DisplayName("return list of anime  when successul")
    void list_ReturnsListOfAnime_WhenSuccessul() {
        String expectedName = AnimeCreator.createValidAnime().getName();
        List<Anime> animes = animeController.listAll().getBody();

        Assertions.assertThat(animes).isNotNull().isNotEmpty().hasSize(1);

        Assertions.assertThat(animes.get(0).getName()).isEqualTo(expectedName);
    }

    @Test
    @DisplayName("findById return anime when successul")
    void findById_ReturnsAnime_WhenSuccessul() {
        Long expectedId = AnimeCreator.createValidAnime().getId();
        Anime anime = animeController.findById(8L).getBody();

        Assertions.assertThat(anime).isNotNull();

        Assertions.assertThat(anime.getId()).isEqualTo(expectedId);
    }

    @Test
    @DisplayName("findByName returns list of anime  when successul")
    void findByName_ReturnsListOfAnime_WhenSuccessul() {
        Anime anime = AnimeCreator.createValidAnime();
        List<Anime> animes = animeController.findByName("Ruan").getBody();

        Assertions.assertThat(animes).isNotNull().isNotEmpty().hasSize(1);

        Assertions.assertThat(animes.get(0)).isEqualTo(anime);

        Assertions.assertThat(animes.get(0).getName()).isEqualTo(anime.getName());
        Assertions.assertThat(animes.get(0).getId()).isEqualTo(anime.getId());
    }

    @Test
    @DisplayName("findByName returns empty list when anime not found")
    void findByName_ReturnsEmptyList_WhenAnimeNotFound() {
        BDDMockito.when(animeServiceMock.findByName(ArgumentMatchers.anyString()))
                .thenReturn(Collections.emptyList());

        List<Anime> list = animeController.findByName("Ruan").getBody();

        Assertions.assertThat(list).hasSize(0).isEmpty();
    }

    @Test
    @DisplayName("save returns animes when successul")
    void save_ReturnsAnimes_WhenSuccessul() {

        Anime bodyAnime = animeController.save(AnimePostRequestBodyCreator.createAnimePostRequestBoy()).getBody();

        Assertions.assertThat(bodyAnime).isNotNull().isEqualTo(AnimeCreator.createValidAnime());
    }

    @Test
    @DisplayName("replace updates animes when successul")
    void replace_UpdateAnime_WhenSuccessul() {
        Assertions.assertThatCode(() -> animeController.replace(AnimePutRequestBodyCreator.creatorAnimePutRequestBody()))
                .doesNotThrowAnyException();

        ResponseEntity<Void> replace = animeController.replace(AnimePutRequestBodyCreator.creatorAnimePutRequestBody());
        Assertions.assertThat(replace).isNotNull();
        Assertions.assertThat(replace.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);
    }

    @Test
    @DisplayName("delete removes animes when successul")
    void delete_RemovesAnime_WhenSuccessul() {
        Assertions.assertThatCode(() -> animeController.delete(10L))
                .doesNotThrowAnyException();

        ResponseEntity<Void> replace = animeController.delete(10L);
        Assertions.assertThat(replace).isNotNull();
        Assertions.assertThat(replace.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);
    }

    @Test
    @DisplayName("delete removes all animes when successul")
    void delete_RemovesAllAnime_WhenSuccessul() {
        Assertions.assertThatCode(() -> animeController.deleteAll())
                .doesNotThrowAnyException();

        ResponseEntity<Void> replace = animeController.deleteAll();
        Assertions.assertThat(replace).isNotNull();
        Assertions.assertThat(replace.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);
    }
}