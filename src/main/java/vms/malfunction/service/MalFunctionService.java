package vms.malfunction.service;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import vms.malfunction.dto.SensorData;
import vms.malfunction.jpa.MFRecordCurrentJPA;
import vms.malfunction.repo.SensorMalFunctionRepository;


@Service
//@EnableBinding(Sink.class)
public class MalFunctionService {
	
	@Autowired
	SensorMalFunctionRepository malFunctionRepo;
	
	ObjectMapper mapper = new ObjectMapper();
	
//	@StreamListener(Sink.INPUT)
	public void getSensorData(String json) throws JsonParseException, JsonMappingException, IOException {
			SensorData sensor = mapper.readValue(json, SensorData.class);
			String id = String.format("%d-%d", sensor.machineId, sensor.sensorId);
			
			if(!malFunctionRepo.existsById(id)) {
				saveInDataBase(sensor);
			}
				
	}
	

	private void saveInDataBase(SensorData sensor) {
		MFRecordCurrentJPA sensorDB = new MFRecordCurrentJPA(sensor.machineId, 
				sensor.sensorId);
		malFunctionRepo.save(sensorDB);
		
	}
	
	public void saveJpa(MFRecordCurrentJPA jpa) {
		malFunctionRepo.save(jpa);
	}
		

}
