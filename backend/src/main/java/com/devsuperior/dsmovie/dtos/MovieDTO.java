package com.devsuperior.dsmovie.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieDTO {

    private Long id;

    private String title;

    private Double score;

    private Integer count;

    private String image;
}
