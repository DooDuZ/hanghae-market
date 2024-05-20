package com.sparta.hanghaemarket.domain;

import com.sparta.hanghaemarket.dto.ItemRequestDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name="item")
@Getter
@NoArgsConstructor
public class Item {

    public Item(ItemRequestDto itemRequestDto){
        this.title = itemRequestDto.getTitle();
        this.content = itemRequestDto.getContent();
        this.price = itemRequestDto.getPrice();
        this.username = itemRequestDto.getUsername();
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(length = 500)
    private String content;

    @Column(nullable = false)
    private int price;

    @Column(nullable = false)
    private String username;


    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
