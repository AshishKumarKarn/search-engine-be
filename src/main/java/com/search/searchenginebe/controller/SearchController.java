package com.search.searchenginebe.controller;

import com.search.searchenginebe.dao.Item;
import com.search.searchenginebe.dao.ItemContainer;
import com.search.searchenginebe.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/searchEngine/")
public class SearchController {
    @Autowired
    private ItemService itemService;

    @GetMapping(value = "partialSearch/{searchText}/{startPage}")
    public ResponseEntity<ItemContainer> getSearchResult(@PathVariable String searchText, @PathVariable int startPage) {

        int size = 10;
        List<Item> itemList = itemService.getPartialSearchedItemsByItemName(searchText, startPage, size);
        ItemContainer itemContainer = new ItemContainer();
        itemContainer.setItemList(itemList);
        itemContainer.setEndPageNumber(startPage);
        return ResponseEntity.ok().body(itemContainer);
    }

    @GetMapping(value = "completeSearch/{searchText}/{startPage}")
    public ResponseEntity<ItemContainer> getAllSearchResult(@PathVariable String searchText, @PathVariable int startPage) {
        int size = 25;
        List<Item> itemList = itemService.getPartialSearchedItemsByItemName(searchText, startPage, size);
        itemList.forEach(a -> System.out.println(a));
        ItemContainer itemContainer = new ItemContainer();
        itemContainer.setItemList(itemList);
        itemContainer.setEndPageNumber(startPage);
        return ResponseEntity.ok().body(itemContainer);
    }
}
