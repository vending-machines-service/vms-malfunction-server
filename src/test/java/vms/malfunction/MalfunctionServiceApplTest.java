package vms.malfunction;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import vms.malfunction.jpa.MFRecordCurrentJPA;
import vms.malfunction.service.MalFunctionService;

@SpringBootApplication
public class MalfunctionServiceApplTest {
	
	MalFunctionService service;
	ConfigurableApplicationContext ctx;
	
	MFRecordCurrentJPA rec = new MFRecordCurrentJPA(1, 1);
	
	
	@BeforeEach
	public void setUp() {
		ctx = SpringApplication.run(MalfunctionServiceApplTest.class);
		service = ctx.getBean(MalFunctionService.class);
	}

	@Test
	public void test() {
		service.saveJpa(rec);
	}

}
