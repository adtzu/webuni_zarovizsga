package hu.webuni.spring.logistics.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hu.webuni.spring.logistics.dto.AddressDTO;
import hu.webuni.spring.logistics.mapper.AddressMapper;
import hu.webuni.spring.logistics.service.AddressService;

@RestController
@RequestMapping("/api/addresses")
public class AddressRestController {
	
	@Autowired
	AddressService addressService;
	
	@Autowired
	AddressMapper addressMapper;
	
	
	@GetMapping
	public List<AddressDTO> listAll() {
		
		return addressMapper.listModelToDto(addressService.getAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<AddressDTO> getOneById(@PathVariable Long id) {
		
		AddressDTO found = addressMapper.modelToDto(addressService.getOneById(id));
		
		if(found != null)
		{
			return ResponseEntity.ok(found);
		}
		else
		{
			return ResponseEntity.notFound().build();
		}
		
	}

	@PostMapping
	public ResponseEntity<AddressDTO> addNew(@RequestBody @Valid AddressDTO address) {
		
		try 
		{
			AddressDTO saved = addressMapper.modelToDto(addressService.addNew(addressMapper.dtoToModel(address)));
			return ResponseEntity.ok(saved);
		}
		catch(Exception exc)
		{
			return ResponseEntity.badRequest().build();
		}
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteAddress(@PathVariable Long id) {
		
		try
		{
			addressService.deleteAddressById(id);
		}
		catch(Exception exc)
		{
			System.out.println(exc.getMessage());
		}

		//Finally
		return ResponseEntity.ok(null);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<AddressDTO> overwriteExisting(@RequestBody AddressDTO newAddress, @PathVariable Long id) {
		
		if(newAddress.getId() != null && newAddress.getId() != id)
		{
			return ResponseEntity.badRequest().build();
		}
		else if(!addressService.isPresent(id))
		{
			return ResponseEntity.notFound().build();
		}
		
		try 
		{
			newAddress.setId(id);
			AddressDTO saved = addressMapper.modelToDto(addressService.addNew(addressMapper.dtoToModel(newAddress)));
			return ResponseEntity.ok(saved);
		}
		catch(Exception exc)
		{
			return ResponseEntity.badRequest().build();
		}
		
	}
	
	
	
}
