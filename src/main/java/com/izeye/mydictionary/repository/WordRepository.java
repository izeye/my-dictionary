package com.izeye.mydictionary.repository;

import com.izeye.mydictionary.domain.Word;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * {@link JpaRepository} for {@link Word}.
 *
 * @author Johnny Lim
 */
public interface WordRepository extends JpaRepository<Word, Long> {

    Word findByValue(String value);

}
