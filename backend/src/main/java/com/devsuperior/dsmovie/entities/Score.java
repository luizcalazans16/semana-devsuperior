package com.devsuperior.dsmovie.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tb_score")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Score {

    @EmbeddedId
    private ScorePK id = new ScorePK();

    private Double value;

    public void setMovie(Movie movie) {
        id.setMovie(movie);
    }

    public void setUser(User user) {
        id.setUser(user);
    }
}
