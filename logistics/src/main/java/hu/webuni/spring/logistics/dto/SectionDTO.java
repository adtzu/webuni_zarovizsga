package hu.webuni.spring.logistics.dto;

import hu.webuni.spring.logistics.model.Milestone;
import hu.webuni.spring.logistics.model.TransportPlan;

public class SectionDTO {
	
	
	private Long id;
	
	private TransportPlan transportPlan;

	private Milestone fromMilestone;

	private Milestone toMilestone;
	
	private int number;
	
	
	public SectionDTO(Milestone fromMilestone, Milestone toMilestone, int number) {
		
		this.fromMilestone = fromMilestone;
		this.toMilestone = toMilestone;
		this.number = number;
	}

	public void setFromMilestone(Milestone fromMilestone) {
		this.fromMilestone = fromMilestone;
	}

	public void setToMilestone(Milestone toMilestone) {
		this.toMilestone = toMilestone;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public Long getId() {
		return id;
	}

	public Milestone getFromMilestone() {
		return fromMilestone;
	}

	public Milestone getToMilestone() {
		return toMilestone;
	}

	public int getNumber() {
		return number;
	}

	public TransportPlan getTransportPlan() {
		return transportPlan;
	}

	public void setTransportPlan(TransportPlan transportPlan) {
		this.transportPlan = transportPlan;
	}	

}
