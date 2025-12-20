package com.swapi.exam.repository;

import com.swapi.exam.model.Elf;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ElfRepository extends JpaRepository<Elf, Long> {
}
