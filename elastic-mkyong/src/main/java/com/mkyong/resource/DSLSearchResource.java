package com.mkyong.resource;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mkyong.builder.SearchQueryBuilder;
import com.mkyong.model.Book;

import java.util.List;

/*
 * Rest endpoint to search for indices by DSL 
 */
@RestController
@RequestMapping("/rest/manual/search")
public class DSLSearchResource {

    @Autowired
    private SearchQueryBuilder searchQueryBuilder;

    @GetMapping(value = "/{text}")
    public List<Book> getAll(@PathVariable final String text) {
        return searchQueryBuilder.getAll(text);
    }
}
