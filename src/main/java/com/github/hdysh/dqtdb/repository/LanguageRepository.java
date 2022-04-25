package com.github.hdysh.dqtdb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.github.hdysh.dqtdb.model.Lang;

@Repository
public interface LanguageRepository extends JpaRepository<Lang, Integer> {

	Lang findByNameAndLocale(String name, String locale);
}