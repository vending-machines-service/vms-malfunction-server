package vms.vmsmalfunction;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import vms.vmsmalfunction.jpa.MFRecordCurrentJPA;
import vms.vmsmalfunction.service.MalFunctionService;

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
