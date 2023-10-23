package kemalkeskin.keskinRental.business.rules.brand;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kemalkeskin.keskinRental.core.utilities.exceptions.BusinessExceptions;
import kemalkeskin.keskinRental.dataAccess.abstracts.BrandRepository;
import kemalkeskin.keskinRental.entities.concretes.Brand;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class BusinessBrandRules {

	@Autowired
	private BrandRepository brandRepository;
	
	public void checkIfbrandName(String name) {
		if(this.brandRepository.existsByName(name)) {
			throw new BusinessExceptions("this name avaliable");
		}
		
	}
	
	public void checkIfbrandId(int id) {
		if(!this.brandRepository.existsById(id)) {
			throw new BusinessExceptions("this dosn't id avaliable");
		}
		
	}
	
	public void deleteId(int id) {
		Optional<Brand> brand=this.brandRepository.findById(id);
		if(brand.isPresent()) {
			throw new BusinessExceptions("don't avaliable");
		}
	}
	
	public void updateCheckIfbrandId(int id) {
		if(!this.brandRepository.existsById(id)) {
			throw new BusinessExceptions("this dosn't id avaliable");
		}
		
	}
}
