package com.github.riannegreiros.springcloud.springcloud.controllers;


import com.github.riannegreiros.springcloud.springcloud.dto.SearchResults;
import com.github.riannegreiros.springcloud.springcloud.services.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/search")
public class SearchController {

    @Autowired
    private SearchService searchService;

    @GetMapping
    public SearchResults search(@RequestParam String query) {
        SearchResults searchResults = new SearchResults();
        searchResults.setSongs(searchService.searchSongs(query));
        searchResults.setAlbums(searchService.searchAlbums(query));
        searchResults.setArtists(searchService.searchArtists(query));

        return searchResults;
    }
}
