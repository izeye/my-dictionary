package com.izeye.mydictionary.repository;

import com.izeye.mydictionary.domain.Meaning;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * {@link JpaRepository} for {@link Meaning}.
 *
 * @author Johnny Lim
 */
public interface MeaningRepository extends JpaRepository<Meaning, Long> {
}
