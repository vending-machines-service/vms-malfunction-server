package vms.vmsmalfunction.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import vms.vmsmalfunction.jpa.MFRecordCurrentJPA;

public interface SensorMalFunctionRepository extends JpaRepository<MFRecordCurrentJPA, String> {

}
