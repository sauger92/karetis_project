package com.auger.karetisproject.web.controller;

import com.auger.karetisproject.service.RandomDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class RandomDataController {

    private final RandomDataService randomDataService;
    private final static int NUMBER_OF_DATA_TO_INSERT = 2000000;

    @RequestMapping("/batchInsert")
    public String batchInsert()
    {
        return randomDataService.batchInsert(NUMBER_OF_DATA_TO_INSERT);
    }

    @RequestMapping("/bulkInsert")
    public String bulkInsert() {
        return randomDataService.bulkInsert(NUMBER_OF_DATA_TO_INSERT);
    }

}
