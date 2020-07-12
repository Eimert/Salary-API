package nl.eimertvink.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.function.Function;
import java.util.stream.Collectors;

public abstract class AbstractController {

    protected <DTO, ENT> Page<DTO> convertToDtoPage(Page<ENT> entitiesPage, Function<ENT, DTO> convert, Pageable pageable) {
        return new PageImpl<>(entitiesPage.getContent()
            .stream()
            .map(convert)
            .collect(Collectors.toList()), pageable, entitiesPage.getTotalElements());
    }

}
