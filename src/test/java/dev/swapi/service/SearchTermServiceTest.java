package dev.swapi.service;

import dev.swapi.model.dto.searchterms.SearchTermResponseDTO;
import dev.swapi.repository.SearchTermRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;

import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class SearchTermServiceTest {

    @InjectMocks
    private SearchTermService searchTermService;

    @Mock
    private SearchTermRepository searchTermRepository;

    @Test
    void shouldReturnSearchTermResponseDTO() {
        SearchTermResponseDTO searchTerms = searchTermService.getSearchTerms();
        when(searchTermRepository.getTerms()).thenReturn(new ArrayList<>());
        Assertions.assertNotNull(searchTerms);
    }
}
