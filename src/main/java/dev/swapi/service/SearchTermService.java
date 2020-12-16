package dev.swapi.service;

import dev.swapi.model.dto.searchterms.SearchTermDTO;
import dev.swapi.model.dto.searchterms.SearchTermResponseDTO;
import dev.swapi.repository.SearchTermRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchTermService {

    @Autowired
    private SearchTermRepository searchTermRepository;

    public SearchTermResponseDTO getSearchTerms() {
        List<SearchTermDTO> terms = searchTermRepository.getTerms();
        return new SearchTermResponseDTO(terms);
    }
}
