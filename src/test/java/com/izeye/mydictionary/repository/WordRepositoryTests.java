/*
 * Copyright 2020 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.izeye.mydictionary.repository;

import java.util.Arrays;
import java.util.List;

import com.izeye.mydictionary.domain.Meaning;
import com.izeye.mydictionary.domain.Word;
import com.izeye.mydictionary.domain.WordClass;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for {@link WordRepository}.
 *
 * @author Johnny Lim
 */
@DataJpaTest
class WordRepositoryTests {

	@Autowired
	private WordRepository wordRepository;

	@Autowired
	private MeaningRepository meaningRepository;

	@Test
	void test() {
		String value = "Johnny";

		assertThat(this.wordRepository.findByValue(value)).isNull();

		Meaning meaning1 = new Meaning();
		meaning1.setWordClass(WordClass.NOUN);
		meaning1.setValue("My first name.");
		Meaning savedMeaning1 = this.meaningRepository.save(meaning1);
		assertThat(savedMeaning1.getId()).isNotNull();
		assertThat(savedMeaning1.getWordClass()).isEqualTo(WordClass.NOUN);
		assertThat(savedMeaning1.getValue()).isEqualTo("My first name.");

		Meaning meaning2 = new Meaning();
		meaning2.setWordClass(WordClass.NOUN);
		meaning2.setValue("Someone's first name.");
		Meaning savedMeaning2 = this.meaningRepository.save(meaning2);
		assertThat(savedMeaning2.getId()).isNotNull();
		assertThat(savedMeaning2.getWordClass()).isEqualTo(WordClass.NOUN);
		assertThat(savedMeaning2.getValue()).isEqualTo("Someone's first name.");

		Word word = new Word();
		word.setValue(value);
		word.setMeanings(Arrays.asList(meaning1, meaning2));
		this.wordRepository.save(word);

		Word found = this.wordRepository.findByValue(value);
		assertThat(found.getId()).isNotNull();
		assertThat(found.getValue()).isEqualTo(value);
		List<Meaning> meanings = found.getMeanings();
		assertThat(meanings).containsExactly(meaning1, meaning2);
	}

}
