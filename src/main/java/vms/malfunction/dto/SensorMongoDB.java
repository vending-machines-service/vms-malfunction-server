package vms.malfunction.dto;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;




@Getter @Setter @NoArgsConstructor @ToString @EqualsAndHashCode
@Document(collection = "current_MF_records")
public class SensorMongoDB {
	
	@Id
	String id;
	public LocalDate currentDate;
	public int machineId;
	public int sensorId;
	public int value;
	
	public SensorMongoDB(LocalDate current, int machineId, int sensorId, int value) {
		super();
		this.id = String.format("%d-%d", machineId, sensorId);
		this.currentDate = current;
		this.machineId = machineId;
		this.sensorId = sensorId;
		this.value = value;
	}

	

}
