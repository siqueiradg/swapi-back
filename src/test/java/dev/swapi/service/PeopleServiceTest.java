package dev.swapi.service;

import dev.swapi.mapper.SearchTermMapper;
import dev.swapi.model.dto.people.PeopleDTO;
import dev.swapi.model.dto.people.PeopleResponseDTO;
import dev.swapi.model.dto.planet.PlanetDTO;
import dev.swapi.repository.SearchTermRepository;
import dev.swapi.utils.SwapiUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class PeopleServiceTest {

    @InjectMocks
    private PeopleService peopleService = new PeopleService("/");

    @Mock
    private RestTemplate restTemplate;

    @Mock
    private SearchTermMapper searchTermMapper;

    @Mock
    private SearchTermRepository searchTermRepository;

    @Mock
    private SwapiUtil swapiUtil;

    @Test
    void shouldReturnPeopleResponseDTO() {
        final Optional<String> term = Optional.of("Luke");
        final Optional<Integer> page = null;
        final ResponseEntity<PeopleResponseDTO> mockRes = mock(ResponseEntity.class);
        final PeopleResponseDTO mockPeopleResponse = mock(PeopleResponseDTO.class);
        when(swapiUtil.getUrlWithPagination(term, page)).thenReturn("url");
        when(restTemplate.getForEntity("/people/url", PeopleResponseDTO.class)).thenReturn(mockRes);
        when(mockRes.getBody()).thenReturn(mockPeopleResponse);
        final PeopleResponseDTO peopleResponseDTO = peopleService.searchPeople(term, page);
        Assertions.assertNotNull(peopleResponseDTO);
    }

    @Test
    void shouldReturnPeoplesSamePlanet() {
        final Optional<String> term = Optional.of("Luke");
        final Optional<Integer> page = null;
        final ResponseEntity<PeopleResponseDTO> mockRes = mock(ResponseEntity.class);
        final PeopleResponseDTO mockPeopleResponse = mock(PeopleResponseDTO.class);
        when(swapiUtil.getUrlWithPagination(term, page)).thenReturn("url");
        when(restTemplate.getForEntity("/people/url", PeopleResponseDTO.class)).thenReturn(mockRes);
        when(mockRes.getBody()).thenReturn(mockPeopleResponse);
        final List<PeopleDTO> peopleList = Arrays.asList(createPeople("home", "url"));
        when(mockPeopleResponse.getResults()).thenReturn(peopleList);
        final ResponseEntity<PlanetDTO> mockResPlanet = mock(ResponseEntity.class);
        final PlanetDTO mockPlanet = mock(PlanetDTO.class);
        when(restTemplate.getForEntity("home", PlanetDTO.class)).thenReturn(mockResPlanet);
        when(mockResPlanet.getBody()).thenReturn(mockPlanet);
        final List<String> peoplePlanet = Arrays.asList("url2");
        when(mockResPlanet.getBody().getResidents()).thenReturn(peoplePlanet);

        //get people
        final ResponseEntity<PeopleDTO> mockPeopleRes = mock(ResponseEntity.class);
        when(restTemplate.getForEntity("url2", PeopleDTO.class)).thenReturn(mockPeopleRes);
        when(mockPeopleRes.getBody()).thenReturn(createPeople("home2", "url2"));
        final PeopleResponseDTO peopleResponseDTO = peopleService.searchPeople(term, page);
        Assertions.assertNotNull(peopleResponseDTO);
    }

    private PeopleDTO createPeople(String home, String url) {
        PeopleDTO peopleDTO = new PeopleDTO();
        peopleDTO.setHomeworld(home);
        peopleDTO.setUrl(url);
        return peopleDTO;
    }
}
