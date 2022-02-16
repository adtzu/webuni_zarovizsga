package hu.webuni.spring.logistics.dto;

import java.util.List;

import hu.webuni.spring.logistics.model.Section;

public class TransportPlanDTO {
	
	
	private Long id;
	
	private List<Section> sections;
	
	private int income;

	
	
	public TransportPlanDTO(List<Section> sections, int income) {

		this.sections = sections;
		this.income = income;
	}


	public Long getId() {
		return id;
	}
	
	public List<Section> getSections() {
		return sections;
	}

	public int getIncome() {
		return income;
	}

	public void setSections(List<Section> sections) {
		this.sections = sections;
	}

	public void setIncome(int income) {
		this.income = income;
	}
	
}
