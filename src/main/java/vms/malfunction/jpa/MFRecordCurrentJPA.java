package vms.malfunction.jpa;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;




@Getter @Setter @NoArgsConstructor @ToString @EqualsAndHashCode
@Entity
@Table(name = "current_mulfunction")
public class MFRecordCurrentJPA {
	
	@Id
	String id;
	@Column(name="date_open")
	LocalDate currentDate;
	@Column(name="machine_id")
	int machineId;
	@Column(name="sensor_id")
	int sensorId;
	@Column(name="user_id")
	int userId;
	


	public MFRecordCurrentJPA(int machineId, int sensorId) {
		super();
		this.id = String.format("%d-%d", machineId, sensorId);
		this.currentDate = LocalDate.now();
		this.machineId = machineId;
		this.sensorId = sensorId;
		this.userId = 0;
	}

	

}
