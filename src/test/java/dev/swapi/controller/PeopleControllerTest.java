package dev.swapi.controller;

import dev.swapi.model.dto.people.PeopleResponseDTO;
import dev.swapi.service.PeopleService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class PeopleControllerTest {

    @InjectMocks
    private PeopleController peopleController;

    @Mock
    private PeopleService peopleService;

    @Test
    void shouldReturnPeopleResponseDTO() {
        final Optional<String> term = Optional.of("Luke");
        final Optional<Integer> page = null;
        final PeopleResponseDTO mockPeople = mock(PeopleResponseDTO.class);
        when(peopleService.searchPeople(term, page)).thenReturn(mockPeople);
        final PeopleResponseDTO response = peopleController.searchPeople(term, page);
        Assertions.assertNotNull(response);
    }

    @Test
    void shouldReturnPeopleResponseDTOWithParamsNull() {
        final Optional<String> term = null;
        final Optional<Integer> page = null;
        final PeopleResponseDTO mockPeople = mock(PeopleResponseDTO.class);
        when(peopleService.searchPeople(term, page)).thenReturn(mockPeople);
        final PeopleResponseDTO response = peopleController.searchPeople(term, page);
        Assertions.assertNotNull(response);
    }
}
