package academy.devdojo.springbootessentials.client;

import academy.devdojo.springbootessentials.domain.Anime;
import lombok.extern.log4j.Log4j2;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Log4j2
public class SpringClient {
    public static void main(String[] args) {
        /*
        Aprimorar atráves de métodos
         */
        //RestTemplate to GET
        ResponseEntity<Anime> entity = new RestTemplate().getForEntity("http://localhost:8080/animes/57", Anime.class);
        log.info(entity);

        Anime object = new RestTemplate().getForObject("http://localhost:8080/animes/57", Anime.class);
        log.info(object);
        Anime[] animes = new RestTemplate().getForObject("http://localhost:8080/animes/all", Anime[].class);
        log.info(Arrays.toString(animes));
        ResponseEntity<List<Anime>> exchange = new RestTemplate().exchange("http://localhost:8080/animes/all"
                , HttpMethod.GET, null, new ParameterizedTypeReference<>() {
        });
        log.info(exchange.getBody());

        //RestTemplate to POST
        Anime anime = Anime.builder().name("Haippo").build();
        Anime animeOne = Anime.builder().name("Dark").build();
        Anime animesaved = new RestTemplate().postForObject("http://localhost:8080/animes", anime, Anime.class);
        log.info("saved anime {}", animesaved);
        ResponseEntity<Anime> animeOneSaved = new RestTemplate()
                .exchange("http://localhost:8080/animes", HttpMethod.POST
                        , new HttpEntity<>(animeOne, createJsonHeader()), Anime.class);
        log.info("saved anime {}", animeOne);

        //RestTemplate to Put
        Anime animeToBeUpdate = animeOneSaved.getBody();
        animeToBeUpdate.setName("DarkDelete");
        ResponseEntity<Void> exchangeUpdate = new RestTemplate()
                .exchange("http://localhost:8080/animes", HttpMethod.PUT
                        , new HttpEntity<>(animeToBeUpdate, createJsonHeader()), Void.class);
        log.info(exchangeUpdate);

        //RestTemplate to delete
        ResponseEntity<Void> exchangeDelete = new RestTemplate()
                .exchange("http://localhost:8080/animes{id}", HttpMethod.DELETE,
                        null, Void.class, 12);
        log.info(exchangeDelete);
    }
    private static HttpHeaders createJsonHeader(){
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        return httpHeaders;
    }
}