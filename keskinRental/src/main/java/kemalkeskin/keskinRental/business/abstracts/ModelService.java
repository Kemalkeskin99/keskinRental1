package kemalkeskin.keskinRental.business.abstracts;

import java.util.List;

import kemalkeskin.keskinRental.business.requests.model.CreateModelRequest;
import kemalkeskin.keskinRental.business.requests.model.UpdateModelRequest;
import kemalkeskin.keskinRental.business.responses.model.GetAllModelResponse;
import kemalkeskin.keskinRental.business.responses.model.GetByIdModelResponse;

public interface ModelService {
	
	List<GetAllModelResponse>getAll();
	
	GetByIdModelResponse getById(int id);
	
	void add(CreateModelRequest createModelRequest);
	
	void update(UpdateModelRequest updateModelRequest);
	
	void delete(int id);
	
	List<GetAllModelResponse>findBrandId(int brandId);

}
