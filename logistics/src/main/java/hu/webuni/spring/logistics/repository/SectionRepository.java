package hu.webuni.spring.logistics.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import hu.webuni.spring.logistics.model.Section;

public interface SectionRepository extends JpaRepository<Section, Long>, JpaSpecificationExecutor<Section> {

}
