package com.sparta.hanghaemarket.service;

import com.sparta.hanghaemarket.constant.DeleteStatus;
import com.sparta.hanghaemarket.domain.Item;
import com.sparta.hanghaemarket.domain.ItemRepository;
import com.sparta.hanghaemarket.dto.ItemRequestDto;
import com.sparta.hanghaemarket.dto.ItemResponseDto;
import com.sparta.hanghaemarket.dto.StatusDto;
import jakarta.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {

    ItemRepository itemRepository;

    @Autowired
    ItemService(ItemRepository itemRepository){
        this.itemRepository = itemRepository;
    }
    public List<ItemResponseDto> getItems() {

        List<Item> items = itemRepository.findAll();

        return itemRepository.findAll().stream().map(ItemResponseDto::new).toList();
    }

    @Transactional
    public ItemResponseDto createItem(ItemRequestDto itemRequestDto) {
        Item item = itemRepository.save(new Item(itemRequestDto));

        return new ItemResponseDto(item);
    }

    @Transactional
    public ItemResponseDto updateItem(Long id, ItemRequestDto itemRequestDto) {
        Item item = findItem(id);

        item.setTitle(itemRequestDto.getTitle());
        item.setContent(itemRequestDto.getContent());
        item.setPrice(itemRequestDto.getPrice());
        item.setUsername(itemRequestDto.getUsername());

        return new ItemResponseDto(item);
    }

    @Transactional
    public StatusDto deleteItem(Long id) {
        try{
            Item item = findItem(id);
            itemRepository.delete(item);
            return new StatusDto(DeleteStatus.삭제완료);
        }catch (IllegalArgumentException e){
            e.printStackTrace();
            return new StatusDto(DeleteStatus.삭제실패);
        }
    }

    private Item findItem(Long id){
        Optional<Item> item = itemRepository.findById(id);

        if (item.isPresent()){
            return item.get();
        }

        throw new IllegalArgumentException("존재하지 않는 게시물입니다.");
    }
}
