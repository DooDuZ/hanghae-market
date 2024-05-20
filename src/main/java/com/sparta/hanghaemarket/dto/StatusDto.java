package com.sparta.hanghaemarket.dto;

import com.sparta.hanghaemarket.constant.DeleteStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StatusDto {
    DeleteStatus msg;
}
