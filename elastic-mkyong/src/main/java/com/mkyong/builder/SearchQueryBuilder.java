package com.mkyong.builder;

import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Component;

import com.mkyong.model.Book;

import java.util.List;
/*
 * Elasticsearch DSL Builder
 */
@Component
public class SearchQueryBuilder {

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;


    public List<Book> getAll(String text) {

        QueryBuilder query = QueryBuilders.boolQuery()
                .should(
                        QueryBuilders.queryStringQuery(text)
                                .lenient(true)// ignore data type
                                .field("title")
                                .field("author")
                ).should(QueryBuilders.queryStringQuery("*" + text + "*")
                        .lenient(true) // ignore data type
                        .field("title")
                        .field("author"));

        NativeSearchQuery build = new NativeSearchQueryBuilder()
                .withQuery(query)
                .build();

        List<Book> books = elasticsearchTemplate.queryForList(build, Book.class);

        return books;
    }
}

