package com.speakingWatch.controller;

import com.speakingWatch.services.WatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/watchController")
public class WatchController {


    @Autowired
    private WatchService watchService;
    @GetMapping("/getWatchTime/{time}")
    public String  getWatchTime(@PathVariable("time") String time) {
        return watchService.getWatchTime(time);
    }

}
