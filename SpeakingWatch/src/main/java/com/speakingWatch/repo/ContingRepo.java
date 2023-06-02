package com.speakingWatch.repo;

import com.speakingWatch.entities.Counting;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ContingRepo extends JpaRepository<Counting, String> {



}
