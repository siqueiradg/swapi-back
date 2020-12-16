package dev.swapi.utils;

import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class SwapiUtil {

    public String getUrlWithPagination(Optional<String> term, Optional<Integer> page) {
        String url = "";
        if (term.isPresent()) {
            url = url.concat("?search=").concat(term.get());
            if (page.isPresent()) {
                url = url.concat("&page=").concat(page.get().toString());
            }
        } else if (page.isPresent()) {
            url = url.concat("?page=").concat(page.get().toString());
        }
        return url;
    }
}
