package com.devsuperior.dsmovie.mapper;

import com.devsuperior.dsmovie.dtos.MovieDTO;
import com.devsuperior.dsmovie.entities.Movie;
import lombok.experimental.UtilityClass;

@UtilityClass
public class MovieMapper {

    public static MovieDTO map(Movie entity) {
        return entity == null ? null :
                MovieDTO.builder()
                        .id(entity.getId())
                        .title(entity.getTitle())
                        .score(entity.getScore())
                        .count(entity.getCount())
                        .image(entity.getImage())
                        .build();
    }

    public static Movie map(MovieDTO dto) {
        if(dto == null)
            return null;

        var entity = new Movie();
        entity.setId(dto.getId());
        entity.setTitle(dto.getTitle());
        entity.setScore(dto.getScore());
        entity.setCount(dto.getCount());
        entity.setImage(dto.getImage());

        return entity;
    }
}
