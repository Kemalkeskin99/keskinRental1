package kemalkeskin.keskinRental.webApi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import kemalkeskin.keskinRental.business.abstracts.BrandService;
import kemalkeskin.keskinRental.business.requests.brand.CreateBrandRequests;
import kemalkeskin.keskinRental.business.requests.brand.UpdateBrandRequest;
import kemalkeskin.keskinRental.business.responses.brand.GetAllBrandResponse;
import kemalkeskin.keskinRental.business.responses.brand.GetByIdBrandResponse;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/brands")
@AllArgsConstructor
public class BrandControllers {
	
	@Autowired
	private BrandService brandService;
	
	@GetMapping()
	public List<GetAllBrandResponse> getAll() {
		return brandService.getAll();
	}
	
	@GetMapping("/{id}")
	public GetByIdBrandResponse getById( @PathVariable int id) {
		return brandService.getById(id);
	}
	
	
	@PostMapping()
	@ResponseStatus(code = HttpStatus.CREATED)
	public void add(@RequestBody @Valid CreateBrandRequests createBrandRequests) {
		this.brandService.add(createBrandRequests);
	}
	
	@PutMapping()
	public void update(@RequestBody  UpdateBrandRequest updateBrandRequest) {
		this.brandService.update(updateBrandRequest);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		
		this.brandService.delete(id);
	}
}
