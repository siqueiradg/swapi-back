package dev.swapi.model.dto.people;

import java.util.List;

public class PeopleResponseDTO {

    private Integer count;
    private String next;
    private String previous;
    private List<PeopleDTO> results;

    public PeopleResponseDTO() {
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getNext() {
        return next;
    }

    public String getPrevious() {
        return previous;
    }

    public List<PeopleDTO> getResults() {
        return results;
    }

    public void setResults(List<PeopleDTO> results) {
        this.results = results;
    }

    public void setNext(String next) {
        if (next != null) {
            this.next = next.split("page=")[1];
        }
    }

    public void setPrevious(String previous) {
        if (previous != null) {
            this.previous = previous.split("page=")[1];
        }
    }
}
