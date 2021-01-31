package com.search.searchenginebe.repository;

import com.search.searchenginebe.dao.Item;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {
    @Query("SELECT i FROM Item i WHERE i.itemName LIKE %:itemName%")
    List<Item> findAllByItemNameLike(@Param("itemName") String itemName, Sort sort);
    @Query("SELECT i FROM Item i WHERE i.itemName LIKE %:itemName%")
    List<Item> findAllByItemNameLike(@Param("itemName") String itemName, Pageable pageable);
}
