package vms.malfunction.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import vms.malfunction.jpa.MFRecordCurrentJPA;
import vms.malfunction.service.MalFunctionService;

@SpringBootApplication
class TestSaveAppl {
	MalFunctionService service;
	ConfigurableApplicationContext ctx;
	
	MFRecordCurrentJPA rec = new MFRecordCurrentJPA(1, 1);
	
	
	@BeforeEach
	public void setUp() {
		ctx = SpringApplication.run(TestSaveAppl.class);
		service = ctx.getBean(MalFunctionService.class);
	}

	@Test
	public void test() {
		service.saveJpa(rec);
	}

}
