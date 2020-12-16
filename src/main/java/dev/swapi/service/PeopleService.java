package dev.swapi.service;

import dev.swapi.mapper.SearchTermMapper;
import dev.swapi.model.dto.people.PeopleResponseDTO;
import dev.swapi.model.dto.people.PeopleDTO;
import dev.swapi.model.dto.planet.PlanetDTO;
import dev.swapi.repository.SearchTermRepository;
import dev.swapi.utils.SwapiUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PeopleService {

    @Value("${api.url}")
    private String url;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private SearchTermMapper searchTermMapper;

    @Autowired
    private SearchTermRepository searchTermRepository;

    @Autowired
    private SwapiUtil swapiUtil;

    public PeopleResponseDTO searchPeople(Optional<String> term, Optional<Integer> page){
        final String endpoint = url.concat("people/").concat(swapiUtil.getUrlWithPagination(term, page));
        final ResponseEntity<PeopleResponseDTO> res = restTemplate.getForEntity(endpoint, PeopleResponseDTO.class);

        if (res.getBody() != null) {
            // search peoples in same planet
            res.getBody().getResults().forEach( people -> {
                people.setSamePlanet(getPeoplesInSamePlanet(people.getUrl(), people.getHomeworld()));
            });
            // exists search term
            term.ifPresent(s -> searchTermRepository.save(searchTermMapper.toSearchTerm(s)));
        }

        return res.getBody();
    }

    private List<PeopleDTO> getPeoplesInSamePlanet(String peopleUrl, String homeWorldUrl) {
        final String urlPlanet = homeWorldUrl.replace("http", "https");
        final List<PeopleDTO> peopleList = new ArrayList<>();
        final ResponseEntity<PlanetDTO> res = restTemplate.getForEntity(urlPlanet, PlanetDTO.class);
        if (res.getBody() != null) {
            res.getBody().getResidents().stream().limit(4).forEach(url -> {
                PeopleDTO people = getPeople(url.replace("http", "https"));
                if (people != null && !people.getUrl().equals(peopleUrl)) {
                    peopleList.add(people);
                }
            });
        }
        return peopleList;
    }

    private PeopleDTO getPeople(String urlPeople) {
        final ResponseEntity<PeopleDTO> res = restTemplate.getForEntity(urlPeople, PeopleDTO.class);
        return res.getBody();
    }

}
