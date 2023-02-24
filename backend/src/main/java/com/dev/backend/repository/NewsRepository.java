package com.dev.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.backend.domain.News;

public interface NewsRepository extends JpaRepository<News, Long> { }

