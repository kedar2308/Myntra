package com.myntra.myntraUserMicroservice.Dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class StatusDto {
    boolean status;
    String description;
}

