package com.izeye.mydictionary.service;

import com.izeye.mydictionary.domain.Word;

import java.util.List;

/**
 * Service for {@link Word}.
 *
 * @author Johnny Lim
 */
public interface WordService {

    List<Word> getAll();

    Word getByValue(String value);

    void register(Word word);

}
