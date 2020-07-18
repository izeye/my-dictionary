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

import java.util.List;

import com.izeye.mydictionary.domain.Word;
import com.izeye.mydictionary.repository.MeaningRepository;
import com.izeye.mydictionary.repository.WordRepository;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
		return this.wordRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
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
