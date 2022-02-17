package hu.webuni.spring.logistics.mapper;

import org.mapstruct.Mapper;

import hu.webuni.spring.logistics.dto.TransportPlanDTO;
import hu.webuni.spring.logistics.model.TransportPlan;

@Mapper(componentModel = "spring")
public interface TransportPlanMapper {

	TransportPlan dtoToModel(TransportPlanDTO dto);
	TransportPlanDTO modelToDto(TransportPlan model);
	
}
