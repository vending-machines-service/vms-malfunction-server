package vms.malfunction.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import vms.malfunction.dto.SensorMongoDB;


@Repository
public interface SensorMalFunctionRepository extends MongoRepository<SensorMongoDB, String>{

}
