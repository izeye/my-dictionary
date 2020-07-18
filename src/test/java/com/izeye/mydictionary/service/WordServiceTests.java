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
package com.izeye.mydictionary.service;

import java.util.Arrays;

import com.izeye.mydictionary.domain.Meaning;
import com.izeye.mydictionary.domain.Word;
import com.izeye.mydictionary.domain.WordClass;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

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
