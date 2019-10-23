package com.codeclan.example.WhiskyTracker;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository.DistilleryRepository;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository.WhiskyRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WhiskyTrackerApplicationTests {

	@Autowired
	WhiskyRepository whiskyRepository;

	@Autowired
	DistilleryRepository distilleryRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void canFindByYear(){
		List<Whisky> foundWhiskies = whiskyRepository.findByYear(1991);
		assertEquals("The Rosebank 12 - Flora and Fona", foundWhiskies.get(0).getName());
	}

	@Test
	public void canFindDistilleryByRegion(){
		List<Distillery> foundDistilleries = distilleryRepository.findByRegion("Highland");
		assertEquals("Glendronach", foundDistilleries.get(0).getName());
	}

	@Test
	public void canFindByAgeAndDistillery(){
		List<Whisky> foundWhiskies = whiskyRepository.findByAgeAndDistilleryId(12, 2L);
		assertEquals("The Rosebank 12 - Flora and Fona", foundWhiskies.get(0).getName());
	}



}
