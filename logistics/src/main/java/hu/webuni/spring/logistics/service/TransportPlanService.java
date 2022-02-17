package hu.webuni.spring.logistics.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.webuni.spring.logistics.model.TransportPlan;
import hu.webuni.spring.logistics.repository.TransportPlanRepository;

@Service
public class TransportPlanService {

	@Autowired
	TransportPlanRepository transportPlanRepository;
	
	@Transactional
	public TransportPlan addNew(TransportPlan plan) {
		
		return transportPlanRepository.save(plan);
	}
	
}
