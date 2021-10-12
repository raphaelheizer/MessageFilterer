package dev.fh.messagefilter.model.interfaces;

public abstract class Word
{
    protected Long id;
    protected String prefix;
    protected String regexpWord;
    protected String acronym;

    protected abstract Long getId();

    protected abstract void setId(Long id);

    protected abstract String getPrefix();

    protected abstract void setPrefix(String prefix);

    protected abstract String getRegexpWord();

    protected abstract void setRegexpWord(String regexpWord);

    protected abstract String getAcronym();

    protected abstract void setAcronym(String acronym);
}
