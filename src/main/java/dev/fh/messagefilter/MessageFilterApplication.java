package dev.fh.messagefilter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class MessageFilterApplication
{

    public static void main(String[] args)
    {
        SpringApplication.run(MessageFilterApplication.class, args);
    }

}
