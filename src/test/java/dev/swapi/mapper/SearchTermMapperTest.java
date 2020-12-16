package dev.swapi.mapper;

import dev.swapi.model.SearchTerm;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {SearchTermMapperImpl.class})
public class SearchTermMapperTest {

    @Autowired
    private SearchTermMapper searchTermMapper;

    @Test
    void shouldReturnSearchTerm() {
        final SearchTerm response = searchTermMapper.toSearchTerm("Douglas");
        Assertions.assertNotNull(response);
        Assertions.assertEquals(response.getTerm(), "Douglas");
    }
}
