package dev.swapi.controller;

import dev.swapi.model.dto.searchterms.SearchTermResponseDTO;
import dev.swapi.service.SearchTermService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class SearchTermControllerTest {

    @InjectMocks
    private SearchTermController searchTermController;

    @Mock
    private SearchTermService searchTermService;

    @Test
    void shouldReturnSearchTermResponseDTO() {
        final SearchTermResponseDTO mockSearch = mock(SearchTermResponseDTO.class);
        when(searchTermService.getSearchTerms()).thenReturn(mockSearch);
        SearchTermResponseDTO response = searchTermController.getSearchTerms();
        Assertions.assertNotNull(response);
    }
}
