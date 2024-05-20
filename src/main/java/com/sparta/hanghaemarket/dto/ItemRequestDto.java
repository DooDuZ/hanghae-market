package com.sparta.hanghaemarket.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
public class ItemRequestDto {

    private Long id;
    private String title;
    private String content;
    private int price;
    private String username;

    public ItemRequestDto(String title, String content, int price, String username){
        this.title = title;
        this.content = content;
        this.price = price;
        this.username = username;
    }
}
