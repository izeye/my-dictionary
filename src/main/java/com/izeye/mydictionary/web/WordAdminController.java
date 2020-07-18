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
package com.izeye.mydictionary.web;

import java.util.Arrays;

import com.izeye.mydictionary.domain.Meaning;
import com.izeye.mydictionary.domain.Word;
import com.izeye.mydictionary.domain.WordClass;
import com.izeye.mydictionary.service.WordService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * {@link Controller} for managing {@link Word words}.
 *
 * @author Johnny Lim
 */
@Controller
@RequestMapping("/admin")
public class WordAdminController {

	private final WordService wordService;

	public WordAdminController(WordService wordService) {
		this.wordService = wordService;
	}

	@GetMapping
	public String index() {
		return "admin/index";
	}

	@PostMapping
	public String registerWord(@RequestParam String word, @RequestParam WordClass wordClass,
			@RequestParam String meaning) {
		Word newWord = new Word();
		newWord.setValue(word);
		Meaning newMeaning = new Meaning();
		newMeaning.setWordClass(wordClass);
		newMeaning.setValue(meaning);
		newWord.setMeanings(Arrays.asList(newMeaning));
		this.wordService.register(newWord);
		return "redirect:/";
	}

}
