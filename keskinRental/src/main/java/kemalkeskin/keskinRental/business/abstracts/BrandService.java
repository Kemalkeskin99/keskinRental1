package kemalkeskin.keskinRental.business.abstracts;

import java.util.List;

import kemalkeskin.keskinRental.business.requests.brand.CreateBrandRequests;
import kemalkeskin.keskinRental.business.requests.brand.UpdateBrandRequest;
import kemalkeskin.keskinRental.business.responses.brand.GetAllBrandResponse;
import kemalkeskin.keskinRental.business.responses.brand.GetByIdBrandResponse;

public interface BrandService {

	List<GetAllBrandResponse> getAll();

	GetByIdBrandResponse getById(int id);

	void add(CreateBrandRequests createBrandRequests);
	
	void update(UpdateBrandRequest updateBrandRequest);
	
	void delete(int id);
}
