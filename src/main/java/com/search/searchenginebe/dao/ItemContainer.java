package com.search.searchenginebe.dao;

import lombok.Data;

import java.util.List;

@Data
public class ItemContainer {
    List<Item> itemList;
    int endPageNumber;
}
