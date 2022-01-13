package com.devsuperior.dsmovie.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ScoreDTO {

    private Long movieId;

    private String email;

    private Double score;
}
