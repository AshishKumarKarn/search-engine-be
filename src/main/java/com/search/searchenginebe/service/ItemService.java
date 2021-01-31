package com.search.searchenginebe.service;

import com.search.searchenginebe.dao.Item;
import com.search.searchenginebe.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public List<Item> getPartialSearchedItemsByItemName(String itemName, int startPage, int size){
        System.out.println("itemName"+itemName+" startPage"+startPage+" size"+size);
        return itemRepository.findAllByItemNameLike(itemName, PageRequest.of(startPage,size, Sort.by("itemName")));
    }
    public List<Item> getCompleteSearchItemsByItemName(String itemName){
        return itemRepository.findAllByItemNameLike(itemName, Sort.by("itemName"));
    }

    public ItemRepository getItemRepository(){
        return itemRepository;
    }


}
