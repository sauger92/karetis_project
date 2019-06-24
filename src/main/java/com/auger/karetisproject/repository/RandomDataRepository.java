package com.auger.karetisproject.repository;

import com.auger.karetisproject.entity.RandomData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface RandomDataRepository extends JpaRepository<RandomData, Long> {
    @Modifying
    @Transactional
    @Query(value="LOAD DATA LOCAL INFILE :filePath INTO TABLE random_data FIELDS TERMINATED BY ',' IGNORE 1 LINES", nativeQuery = true)
    void bulkLoadData(@Param("filePath") String filePath);
}
