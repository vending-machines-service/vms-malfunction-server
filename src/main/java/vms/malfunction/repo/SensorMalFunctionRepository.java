package vms.malfunction.repo;


import org.springframework.data.jpa.repository.JpaRepository;


import vms.malfunction.jpa.MFRecordCurrentJPA;

public interface SensorMalFunctionRepository extends JpaRepository<MFRecordCurrentJPA, String>{

}
