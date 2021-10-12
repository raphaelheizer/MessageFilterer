DROP TABLE IF EXISTS DICTIONARY.BLACKLISTED_WORDS

CREATE TABLE DICTIONARY.BLACKLISTED_WORDS (
                              id INT AUTO_INCREMENT  PRIMARY KEY,
                              prefix VARCHAR(250) NOT NULL,
                              regexp_word VARCHAR(250) NOT NULL,
);