package com.izeye.mydictionary.service;

import com.izeye.mydictionary.domain.Meaning;
import com.izeye.mydictionary.domain.Word;
import com.izeye.mydictionary.domain.WordClass;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for {@link WordService}.
 *
 * @author Johnny Lim
 */
@SpringBootTest
@Transactional
class WordServiceTests {

    @Autowired
    private WordService wordService;

    @Test
    void test() {
        String value = "Johnny";
        assertThat(this.wordService.getByValue(value)).isNull();

        Meaning meaning1 = new Meaning();
        meaning1.setWordClass(WordClass.NOUN);
        meaning1.setValue("My first name.");

        Meaning meaning2 = new Meaning();
        meaning2.setWordClass(WordClass.NOUN);
        meaning2.setValue("Someone's first name.");

        Word word = new Word();
        word.setValue(value);
        word.setMeanings(Arrays.asList(meaning1, meaning2));

        this.wordService.register(word);

        assertThat(this.wordService.getByValue(value)).isNotNull();
    }

}
