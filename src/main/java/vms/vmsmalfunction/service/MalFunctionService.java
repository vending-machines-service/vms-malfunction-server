package vms.vmsmalfunction.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import vms.vmsmalfunction.dto.SensorData;
import vms.vmsmalfunction.jpa.MFRecordCurrentJPA;
import vms.vmsmalfunction.repo.SensorMalFunctionRepository;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
@EnableBinding(Sink.class)
@Slf4j
public class MalFunctionService {

	@Autowired
	SensorMalFunctionRepository malFunctionRepo;

	ObjectMapper mapper = new ObjectMapper();

	@StreamListener(Sink.INPUT)
	public void getSensorData(String json) throws JsonParseException, JsonMappingException, IOException {
		SensorData sensor = mapper.readValue(json, SensorData.class);
		log.info("[RECEIVED]: MACHINE: {}; SENSOR: {}; VALUE: {}", sensor.getMachineId(), sensor.getSensorId(),
				sensor.getValue());

		String id = String.format("%d-%d", sensor.machineId, sensor.sensorId);

		if (!malFunctionRepo.existsById(id)) {
			saveInDataBase(sensor);
		}

	}

	private void saveInDataBase(SensorData sensor) {
		MFRecordCurrentJPA sensorDB = new MFRecordCurrentJPA(sensor.machineId, sensor.sensorId);
		malFunctionRepo.save(sensorDB);

	}

	public void saveJpa(MFRecordCurrentJPA jpa) {
		malFunctionRepo.save(jpa);
	}

}
