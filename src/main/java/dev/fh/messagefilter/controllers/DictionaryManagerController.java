package dev.fh.messagefilter.controllers;

import dev.fh.messagefilter.model.entities.BlacklistedWord;
import dev.fh.messagefilter.repositories.DictionaryRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.ArrayList;
import java.util.List;

@Controller
public class DictionaryManagerController
{
    private final DictionaryRepository<BlacklistedWord> wordDictionaryRepository;

    public DictionaryManagerController(DictionaryRepository<BlacklistedWord> wordDictionaryRepository)
    {
        this.wordDictionaryRepository = wordDictionaryRepository;
    }

    @GetMapping("dictionary-manager")
    public String dictionaryManager(@ModelAttribute BlacklistedWord blacklistedWord, Model model)
    {
        List<BlacklistedWord> wordList = (ArrayList<BlacklistedWord>) wordDictionaryRepository.findAll();
        model.addAttribute("wordList", wordList);
        return "dictionary-manager";
    }
}
