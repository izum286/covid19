package com.izum286.covid.repos;

import com.izum286.covid.model.ShortResponse;
import org.apache.kafka.common.protocol.types.Field;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MainRepository extends MongoRepository<ShortResponse, String> {
}
