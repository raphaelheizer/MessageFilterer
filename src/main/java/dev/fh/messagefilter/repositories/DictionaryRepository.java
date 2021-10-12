package dev.fh.messagefilter.repositories;

import dev.fh.messagefilter.model.entities.BlacklistedWord;
import dev.fh.messagefilter.model.interfaces.Word;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DictionaryRepository<T extends Word> extends CrudRepository<BlacklistedWord, Long>
{
    @Cacheable("blacklistedWords")
    List<T> findAllByPrefix(String prefix);
}
