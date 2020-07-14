package com.izeye.mydictionary.service;

import com.izeye.mydictionary.domain.Word;
import com.izeye.mydictionary.repository.MeaningRepository;
import com.izeye.mydictionary.repository.WordRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Default {@link WordService}.
 *
 * @author Johnny Lim
 */
@Service
public class DefaultWordService implements WordService {

    private final WordRepository wordRepository;
    private final MeaningRepository meaningRepository;

    public DefaultWordService(WordRepository wordRepository, MeaningRepository meaningRepository) {
        this.wordRepository = wordRepository;
        this.meaningRepository = meaningRepository;
    }

    @Override
    public List<Word> getAll() {
        return this.wordRepository.findAll(Sort.by(Sort.Direction.DESC, "value"));
    }

    @Override
    public Word getByValue(String value) {
        return this.wordRepository.findByValue(value);
    }

    @Transactional
    @Override
    public void register(Word word) {
        this.meaningRepository.saveAll(word.getMeanings());
        this.wordRepository.save(word);
    }

}
