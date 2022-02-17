package hu.webuni.spring.logistics.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hu.webuni.spring.logistics.dto.TransportPlanDTO;
import hu.webuni.spring.logistics.mapper.TransportPlanMapper;
import hu.webuni.spring.logistics.service.TransportPlanService;

@RestController
@RequestMapping("/api/transportPlans")
public class TransportPlanController {
	
	@Autowired
	TransportPlanService transportPlanService;
	
	@Autowired
	TransportPlanMapper transportPlanMapper;
	
	
	@PostMapping
	public ResponseEntity<TransportPlanDTO> addNew(@RequestBody @Valid TransportPlanDTO plan) {
		
		try
		{
			TransportPlanDTO saved = transportPlanMapper.modelToDto(transportPlanService.addNew(transportPlanMapper.dtoToModel(plan)));
			return ResponseEntity.ok(saved);
		}
		catch(Exception exc)
		{
			System.out.println(exc.getMessage());
			return ResponseEntity.badRequest().build();
		}
	}

}
