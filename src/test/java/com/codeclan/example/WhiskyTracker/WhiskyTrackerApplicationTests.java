package com.codeclan.example.WhiskyTracker;

import com.codeclan.example.WhiskyTracker.components.DataLoader;
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
	public void canGetWhiskyByYear1995(){
		List<Whisky> result = whiskyRepository.getWhiskyByYear(1995);
	}

	@Test
	public void canGetWhiskyByRegionSpeyside(){
		List<Whisky> result = whiskyRepository.getWhiskyByRegion("Speyside");
	}

	@Test
	public void canGetWHiskyByRegionHighland(){
		List<Whisky> result = whiskyRepository.getWhiskyByRegion("Highland");
	}

	@Test
	public void canGetWhiskyFromDistilleryWithAge(){
		List<Whisky> result = whiskyRepository.getWhiskyFromDistilleryWithAge("Glendronach", 15);
	}

	@Test
	public void canGetDistilleryByRegionHighland(){
		List<Distillery> result = distilleryRepository.getDistilleryByRegion("Highland");
	}

	@Test
	public void canGetDistilleryByWhiskyAge12(){
		List<Distillery> result = distilleryRepository.getDistilleryByWhiskyAge(12);
	}



}
