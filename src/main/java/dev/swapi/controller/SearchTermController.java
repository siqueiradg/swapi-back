package dev.swapi.controller;

import dev.swapi.model.dto.searchterms.SearchTermResponseDTO;
import dev.swapi.service.SearchTermService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("search-terms")
public class SearchTermController {

    @Autowired
    private SearchTermService searchTermService;

    @GetMapping("/")
    @ApiOperation(value = "Get all search terms", nickname = "getSearchTerms", notes = "Get all search terms")
    public @ResponseBody
    SearchTermResponseDTO getSearchTerms() {
        return searchTermService.getSearchTerms();
    }
}
