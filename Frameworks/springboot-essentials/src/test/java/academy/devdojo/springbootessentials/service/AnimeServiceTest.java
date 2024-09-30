package academy.devdojo.springbootessentials.service;

import academy.devdojo.springbootessentials.domain.Anime;
import academy.devdojo.springbootessentials.exception.BadRequestException;
import academy.devdojo.springbootessentials.repository.AnimeRepository;
import academy.devdojo.springbootessentials.util.AnimeCreator;
import academy.devdojo.springbootessentials.util.AnimePostRequestBodyCreator;
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
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@ExtendWith(SpringExtension.class)
class AnimeServiceTest {
    @InjectMocks
    private AnimeService animeService;
    @Mock
    private AnimeRepository animeRepositoryMock;

    @BeforeEach
    void setUp() {
        PageImpl<Anime> animePage = new PageImpl<>(List.of(AnimeCreator.createValidAnime()));
        BDDMockito.when(animeRepositoryMock.findAll(ArgumentMatchers.any(PageRequest.class)))
                .thenReturn(animePage);
        BDDMockito.when(animeRepositoryMock.findAll())
                .thenReturn(List.of(AnimeCreator.createValidAnime()));
        BDDMockito.when(animeRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.of(AnimeCreator.createValidAnime()));
        BDDMockito.when(animeRepositoryMock.findByName(ArgumentMatchers.anyString()))
                .thenReturn(List.of(AnimeCreator.createValidAnime()));
        BDDMockito.when(animeRepositoryMock.save(ArgumentMatchers.any(Anime.class)))
                .thenReturn(AnimeCreator.createValidAnime());
        BDDMockito.doNothing().when(animeRepositoryMock).delete(ArgumentMatchers.any(Anime.class));
        BDDMockito.doNothing().when(animeRepositoryMock).deleteAll();
    }

    @Test
    @DisplayName("findAll list of anime inside page object when successul")
    void findAll_ReturnsListOfAnimeInsidePageObject_WhenSuccessul() {
        String expectedName = AnimeCreator.createValidAnime().getName();
        Page<Anime> animePage = animeService.listAll(PageRequest.of(1,5));

        Assertions.assertThat(animePage).isNotNull();

        Assertions.assertThat(animePage.toList()).isNotEmpty().hasSize(1);

        Assertions.assertThat(animePage.toList().get(0).getName()).isEqualTo(expectedName);
    }

    @Test
    @DisplayName("listAllNoPageable list of anime  when successul")
    void listAllNoPageable_ReturnsListOfAnime_WhenSuccessul() {
        String expectedName = AnimeCreator.createValidAnime().getName();
        List<Anime> animes = animeService.listAllNoPageable();

        Assertions.assertThat(animes).isNotNull().isNotEmpty().hasSize(1);

        Assertions.assertThat(animes.get(0).getName()).isEqualTo(expectedName);
    }

    @Test
    @DisplayName("findByIdOrThrowBadRequestException return anime when successul")
    void findByIdOrThrowBadRequestException_ReturnsAnime_WhenSuccessul() {
        Long expectedId = AnimeCreator.createValidAnime().getId();
        Anime anime = animeService.findByIdOrThrowBadRequestException(8L);

        Assertions.assertThat(anime).isNotNull();

        Assertions.assertThat(anime.getId()).isEqualTo(expectedId);
    }

    @Test
    @DisplayName("findByName returns list of anime  when successul")
    void findByName_ReturnsListOfAnime_WhenSuccessul() {
        Anime anime = AnimeCreator.createValidAnime();
        List<Anime> animes = animeService.findByName("Ruan");

        Assertions.assertThat(animes).isNotNull().isNotEmpty().hasSize(1);

        Assertions.assertThat(animes.get(0)).isEqualTo(anime);

        Assertions.assertThat(animes.get(0).getName()).isEqualTo(anime.getName());
        Assertions.assertThat(animes.get(0).getId()).isEqualTo(anime.getId());
    }

    @Test
    @DisplayName("findByName returns empty list when anime not found")
    void findByName_ReturnsEmptyList_WhenAnimeNotFound() {
        BDDMockito.when(animeRepositoryMock.findByName(ArgumentMatchers.anyString()))
                .thenReturn(Collections.emptyList());

        List<Anime> list = animeService.findByName("Ruan");

        Assertions.assertThat(list).hasSize(0).isEmpty();
    }

    @Test
    @DisplayName("save returns animes when successul")
    void save_ReturnsAnimes_WhenSuccessul() {

        Anime bodyAnime = animeService.save(AnimePostRequestBodyCreator.createAnimePostRequestBoy());

        Assertions.assertThat(bodyAnime).isNotNull().isEqualTo(AnimeCreator.createValidAnime());
    }

    @Test
    @DisplayName("delete removes animes when successul")
    void delete_RemovesAnime_WhenSuccessul() {
        Assertions.assertThatCode(() -> animeService.delete(10L))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("delete removes all animes when successul")
    void delete_RemovesAllAnime_WhenSuccessul() {
        Assertions.assertThatCode(() -> animeService.deleteAll())
                .doesNotThrowAnyException();
    }
    @Test
    @DisplayName("findByIdOrThrowBadRequestException thrown BadRequestException when anime is not found")
    void findByIdOrThrowBadRequestException_ThrowBadRequestException_WhenAnimeIsNotFound() {
        BDDMockito.when(animeRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.empty());

        Assertions.assertThatExceptionOfType(BadRequestException.class)
                .isThrownBy(() -> this.animeService.findByIdOrThrowBadRequestException(1));
    }
}