package com.sparta.hanghaemarket.controller;

import com.sparta.hanghaemarket.dto.ItemRequestDto;
import com.sparta.hanghaemarket.dto.ItemResponseDto;
import com.sparta.hanghaemarket.dto.StatusDto;
import com.sparta.hanghaemarket.service.ItemService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class ItemController {

    ItemService itemService;

    @Autowired
    ItemController(ItemService itemService){
        this.itemService = itemService;
    }
    @GetMapping("/post")
    public List<ItemResponseDto> getItems(){
        return itemService.getItems();
    }

    @PostMapping("/post")
    public ItemResponseDto createItem(@RequestBody ItemRequestDto itemRequestDto){
        return itemService.createItem(itemRequestDto);
    }

    @PutMapping("/post/{id}")
    public ItemResponseDto updateItem(@PathVariable Long id, @RequestBody ItemRequestDto itemRequestDto){
        return itemService.updateItem(id, itemRequestDto);
    }

    @DeleteMapping("/post/{id}")
    public StatusDto deleteItem(@PathVariable Long id){
        return itemService.deleteItem(id);
    }
}
