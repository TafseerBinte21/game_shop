package com.tafa.GameShop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import com.tafa.GameShop.models.Game;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {

	Game findByname(String name);

	Optional<Game> findById(Long id);

	// Custom query
	@Query(value = "select * from game_list s where s.name like :keyword%", nativeQuery = true)
	List<Game> findByKeyword(@Param("keyword") String keyword);
}
