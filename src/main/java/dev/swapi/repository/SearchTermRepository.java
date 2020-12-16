package dev.swapi.repository;

import dev.swapi.model.SearchTerm;
import dev.swapi.model.dto.searchterms.SearchTermDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SearchTermRepository extends JpaRepository<SearchTerm, Long> {

    @Query("SELECT new dev.swapi.model.dto.searchterms.SearchTermDTO(count(s.term) as count, s.term) FROM SearchTerm s WHERE s.term is not null group by s.term order by count(s.term) DESC")
    List<SearchTermDTO> getTerms();
}
