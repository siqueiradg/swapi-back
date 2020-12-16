package dev.swapi.controller;

import dev.swapi.model.dto.people.PeopleResponseDTO;
import dev.swapi.service.PeopleService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("peoples")
public class PeopleController {

    @Autowired
    private PeopleService peopleService;

    @GetMapping("/")
    @ApiOperation(value = "Search all peoples or search by term", nickname = "searchPeople", notes = "Search all peoples")
    public @ResponseBody
    PeopleResponseDTO searchPeople(
            @ApiParam(value = "Search term") @RequestParam(required = false) Optional<String> term,
            @ApiParam(value = "Number of page") @RequestParam(required = false) Optional<Integer> page) {
        return peopleService.searchPeople(term, page);
    }
}
