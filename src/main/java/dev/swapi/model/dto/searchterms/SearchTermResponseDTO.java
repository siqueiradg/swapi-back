package dev.swapi.model.dto.searchterms;

import java.util.List;

public class SearchTermResponseDTO {

    List<SearchTermDTO> results;

    public SearchTermResponseDTO() {
    }

    public SearchTermResponseDTO(List<SearchTermDTO> results) {
        this.results = results;
    }

    public List<SearchTermDTO> getResults() {
        return results;
    }

    public void setResults(List<SearchTermDTO> results) {
        this.results = results;
    }
}
