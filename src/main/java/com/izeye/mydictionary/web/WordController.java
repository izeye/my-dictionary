package com.izeye.mydictionary.web;

import com.izeye.mydictionary.domain.Word;
import com.izeye.mydictionary.service.WordService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

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
