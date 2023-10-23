package kemalkeskin.keskinRental.business.rules.model;

import org.springframework.stereotype.Service;

import kemalkeskin.keskinRental.core.utilities.exceptions.BusinessExceptions;
import kemalkeskin.keskinRental.dataAccess.abstracts.ModelRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BusinessModelRules {

	private ModelRepository modelRepository;
	
	public void checkIfModelName(String name) {
		
		if(this.modelRepository.existsByName(name)) {
			throw new BusinessExceptions("this model name avaliable");
		}
	}
	
	
	public void checkIfModelId(int id) {
		
		if(!this.modelRepository.existsById(id)) {
			throw new BusinessExceptions("this don't avaliable id");
		}
	}
	
	
	
}
