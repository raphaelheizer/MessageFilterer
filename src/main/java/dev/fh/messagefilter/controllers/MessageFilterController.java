package dev.fh.messagefilter.controllers;

import dev.fh.messagefilter.model.BlacklistMessageFilterer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageFilterController
{
    private final BlacklistMessageFilterer blacklistMessageFilterer;

    public MessageFilterController(BlacklistMessageFilterer blacklistMessageFilterer)
    {
        this.blacklistMessageFilterer = blacklistMessageFilterer;
    }

    @GetMapping("/check")
    public String checkString(@RequestParam("message") String message)
    {
        return blacklistMessageFilterer.filterMessage(message);
    }
}
