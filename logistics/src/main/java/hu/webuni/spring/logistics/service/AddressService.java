package hu.webuni.spring.logistics.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hu.webuni.spring.logistics.model.Address;
import hu.webuni.spring.logistics.repository.AddressRepository;

@Service
public class AddressService {
	
	@Autowired
	AddressRepository addressRepository;
	
	@Transactional
	public List<Address> getAll() {
		
		return addressRepository.findAll();		
	}
	
	@Transactional
	public Address getOneById(Long id) {
		
		return addressRepository.listById(id);
	}
	
	@Transactional
	public void deleteAddressById(Long id) {
		
		addressRepository.deleteById(id);
	}
	
	@Transactional
	public Address addNew(Address address) {
		
		return addressRepository.save(address);
	}
	
	@Transactional
	public Boolean isPresent(Long id) {
		
		return addressRepository.existsById(id); 
	}
	
}
