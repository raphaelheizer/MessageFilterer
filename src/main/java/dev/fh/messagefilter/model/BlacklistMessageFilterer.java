package dev.fh.messagefilter.model;

import dev.fh.messagefilter.model.entities.BlacklistedWord;
import dev.fh.messagefilter.repositories.DictionaryRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class BlacklistMessageFilterer
{
    private final DictionaryRepository<BlacklistedWord> dictionaryRepository;

    public BlacklistMessageFilterer(DictionaryRepository<BlacklistedWord> dictionaryRepository)
    {
        this.dictionaryRepository = dictionaryRepository;
    }

    public String filterMessage(String message)
    {
        final String splitChar = " ";
        final String sanitizerChars = "[.,;_-]";
        List<String> splitMessage = Arrays.asList(message.split(splitChar));

        List<String> newMessage = splitMessage.stream().map(word ->
                  {
                      String prefix = word.substring(0, 1);
                      List<BlacklistedWord> matches = dictionaryRepository.findAllByPrefix(prefix);

                      for (BlacklistedWord match : matches)
                      {
                          String sanitizedWord = word.replaceAll(sanitizerChars, "");
                          if (sanitizedWord.matches(match.getRegexpWord()))
                              return censorWord(word);
                      }
                      return word;
                  })
                  .collect(Collectors.toList());
        return String.join(splitChar, newMessage);
    }

    private String censorWord(String word)
    {
        StringBuilder stringBuilder = new StringBuilder();
        String[] wordChart = {"#", "!", "@", "?"};
        Random r = new Random();

        for (char ignored : word.toCharArray())
            stringBuilder.append(wordChart[r.nextInt(wordChart.length)]);

        return stringBuilder.toString();
    }
}
