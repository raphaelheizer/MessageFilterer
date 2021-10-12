package dev.fh.messagefilter.model.entities;

import dev.fh.messagefilter.model.interfaces.Word;

import javax.persistence.*;

@Entity
@Table(name = "BLACKLISTED_WORDS", schema = "DICTIONARY")
public class BlacklistedWord extends Word
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)

    @Override
    public Long getId() {return id;}

    @Override
    public void setId(Long id) {this.id = id;}

    @Override
    public String getPrefix()
    {
        return prefix;
    }

    @Override
    public void setPrefix(String prefix)
    {
        this.prefix = prefix;
    }

    @Override
    public String getRegexpWord()
    {
        return regexpWord;
    }

    @Override
    public void setRegexpWord(String blacklistedWord)
    {
        this.regexpWord = blacklistedWord;
    }

    @Override
    public String getAcronym()
    {
        return acronym;
    }

    @Override
    public void setAcronym(String acronym)
    {
        this.acronym = acronym;
    }
}
