package dev.swapi.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

@ExtendWith(SpringExtension.class)
public class SwapiUtilTest {

    @InjectMocks
    private SwapiUtil swapiUtil;

    @Test
    void shouldReturnUrlWithEmptyParams() {
        String urlWithPagination = swapiUtil.getUrlWithPagination(Optional.empty(), Optional.empty());
        Assertions.assertNotNull(urlWithPagination);
    }

    @Test
    void shouldReturnUrlWithParams() {
        String urlWithPagination = swapiUtil.getUrlWithPagination(Optional.of("t"), Optional.of(1));
        Assertions.assertNotNull(urlWithPagination);
    }

    @Test
    void shouldReturnUrlWithPage() {
        String urlWithPagination = swapiUtil.getUrlWithPagination(Optional.empty(), Optional.of(1));
        Assertions.assertNotNull(urlWithPagination);
    }
}
