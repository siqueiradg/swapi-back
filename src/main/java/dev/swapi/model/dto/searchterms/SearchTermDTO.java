package dev.swapi.model.dto.searchterms;

import java.io.Serializable;

public class SearchTermDTO implements Serializable {

    private Long count;
    private String term;

    public SearchTermDTO() {
    }

    public SearchTermDTO(Long count, String term) {
        this.count = count;
        this.term = term;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }
}
