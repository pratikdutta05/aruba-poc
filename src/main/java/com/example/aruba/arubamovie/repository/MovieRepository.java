package com.example.aruba.arubamovie.repository;

import com.example.aruba.arubamovie.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface MovieRepository extends JpaRepository<Movie, String> {
    List<Movie> findByTypeAndCountry(String type, String country);

    @Query("SELECT m from Movie m where m.title=:title OR m.id=:id")
    Optional<Movie> findByIdOrTitle(String title, String id);
}