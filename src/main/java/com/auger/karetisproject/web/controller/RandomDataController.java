package com.auger.karetisproject.web.controller;

import com.auger.karetisproject.service.RandomDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class RandomDataController {

    private final RandomDataService randomDataService;

    @RequestMapping("/naiveInsert")
    public String naiveInsert()
    {
        return randomDataService.insertOneByOne(2000);
    }

    @RequestMapping("/batchInsert")
    public String batchInsert()
    {
        return randomDataService.batchInsert(2000);
    }
    @RequestMapping("/loadData")
    public String loadData()
    {
        return randomDataService.loadData(2000);
    }

}
