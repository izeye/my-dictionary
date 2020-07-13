package com.izeye.mydictionary.web;

import com.izeye.mydictionary.domain.Meaning;
import com.izeye.mydictionary.domain.Word;
import com.izeye.mydictionary.domain.WordClass;
import com.izeye.mydictionary.service.WordService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;

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
    public String registerWord(
            @RequestParam String word, @RequestParam WordClass wordClass, @RequestParam String meaning) {
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
