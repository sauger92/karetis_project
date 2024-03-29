package com.auger.karetisproject.service;

import com.auger.karetisproject.entity.RandomData;
import com.auger.karetisproject.repository.RandomDataRepository;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class RandomDataService {

    private static final Logger logger = LogManager.getLogger(RandomDataService.class);
    private final RandomDataRepository randomDataRepository;

    @Value("${spring.jpa.properties.hibernate.jdbc.batch_size}")
    private String batchSize;

    private static final String returnString = "Time spent to insert : ";


    //Insert data by Batch
    public String batchInsert(int numberOfDataToInsert) {
        long startTime = System.currentTimeMillis();
        List<RandomData> randomDataList = new ArrayList<>();
        for (int i = 0; i < numberOfDataToInsert; i++) {
            if (i % Integer.valueOf(batchSize) == 0) {
                randomDataRepository.saveAll(randomDataList);
                randomDataList = new ArrayList<>();
            }
            randomDataList.add(createRadomData());

        }
        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        return returnString + elapsedTime;

    }


    //Add all the random data to a csv file and then insert the file to the database
    @Transactional
    public String bulkInsert(int numberOfDataToInsert) {
        long startTime = System.currentTimeMillis();

        String fileName = "data.csv";

        try {
            FileWriter csvWriter = new FileWriter(fileName);
            File file = new File(fileName);

            csvWriter.append("id,random1, random2, random3\n");
            for (int i = 0; i < numberOfDataToInsert; i++) {
                RandomData data = createRadomData();
                csvWriter.append(String.valueOf(i)).append(",").append(String.valueOf(data.getRandom1())).append(",").append(String.valueOf(data.getRandom2())).append(",").append(String.valueOf(data.getRandom3())).append("\n");
            }
            csvWriter.flush();
            csvWriter.close();
            randomDataRepository.bulkLoadData(file.getAbsolutePath());

        } catch (IOException e) {
            logger.debug(e);
        } finally {
            long stopTime = System.currentTimeMillis();
            long elapsedTime = stopTime - startTime;
            return returnString + elapsedTime;
        }
    }

    private RandomData createRadomData() {
        Random rand = new Random();
        return new RandomData(new BigInteger(63, rand), new BigInteger(63, rand), new BigInteger(63, rand));
    }


}
