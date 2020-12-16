package dev.swapi.mapper;

import dev.swapi.model.SearchTerm;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SearchTermMapper {

    SearchTerm toSearchTerm(String term);

}
