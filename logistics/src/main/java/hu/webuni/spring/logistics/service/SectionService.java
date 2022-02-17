package hu.webuni.spring.logistics.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.webuni.spring.logistics.model.Section;
import hu.webuni.spring.logistics.repository.SectionRepository;

@Service
public class SectionService {

	@Autowired
	SectionRepository sectionRepository;
	
	public Section addNew(Section section) {
		
		return sectionRepository.save(section);
	}
}
