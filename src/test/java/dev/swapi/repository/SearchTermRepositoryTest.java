package dev.swapi.repository;

import dev.swapi.model.SearchTerm;
import dev.swapi.model.dto.searchterms.SearchTermDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class SearchTermRepositoryTest {

    @Autowired
    private SearchTermRepository repository;

    @Test
    public void should_find_all_search_terms() {
        List<SearchTerm> all = repository.findAll();
        assertThat(all).isNotNull();
        assertThat(all).hasSize(2);
    }

    @Test
    public void should_count_all_search_terms() {
        List<SearchTermDTO> terms = repository.getTerms();
        assertThat(terms).isNotNull();
        assertThat(terms).hasSize(1);
        assertThat(terms.get(0).getCount()).isEqualTo(2);
    }

}
