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

import java.util.List;

import com.izeye.mydictionary.domain.Word;
import com.izeye.mydictionary.service.WordService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * {@link Controller} for {@link Word}.
 *
 * @author Johnny Lim
 */
@Controller
public class WordController {

	private final WordService wordService;

	public WordController(WordService wordService) {
		this.wordService = wordService;
	}

	@GetMapping
	public String index(Model model) {
		List<Word> words = this.wordService.getAll();
		model.addAttribute("words", words);
		return "index";
	}

}
