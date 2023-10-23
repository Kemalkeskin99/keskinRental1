package kemalkeskin.keskinRental.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kemalkeskin.keskinRental.business.abstracts.CarService;
import kemalkeskin.keskinRental.business.requests.car.CreateCarRequest;
import kemalkeskin.keskinRental.business.requests.car.UpdateCarRequest;
import kemalkeskin.keskinRental.business.responses.car.GetAllCarResponse;
import kemalkeskin.keskinRental.business.responses.car.GetByIdCarResponse;
import kemalkeskin.keskinRental.business.rules.car.BusinessCarRules;
import kemalkeskin.keskinRental.core.utilities.mapper.ModelMapperService;
import kemalkeskin.keskinRental.dataAccess.abstracts.CarRepository;
import kemalkeskin.keskinRental.entities.concretes.Car;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CarManager implements CarService{
	
	@Autowired
	private CarRepository carRepository;
	@Autowired
	private ModelMapperService modelMapperService;
	@Autowired
	private BusinessCarRules businessCarRules;

	@Override
	public List<GetAllCarResponse> getAll() {
		List<Car>cars=this.carRepository.findAll();
		List<GetAllCarResponse>getAllCarResponses=cars.stream().map(car->modelMapperService.forResponse().map(car, GetAllCarResponse.class)).collect(Collectors.toList());
		return getAllCarResponses;
	}

	@Override
	public GetByIdCarResponse getById(int id) {
	
		Car car =this.carRepository.findById(id).get();
		GetByIdCarResponse getByIdCarResponse=this.modelMapperService.forResponse().map(car, GetByIdCarResponse.class);
		return getByIdCarResponse;
	}
	
	
	@Override
	public void add(CreateCarRequest createCarRequest) {
		this.businessCarRules.checkIfPlate(createCarRequest.getPlate());
		this.businessCarRules.checkModelYear(createCarRequest.getModelYear());
		this.businessCarRules.checkIfDailyPrice(createCarRequest.getDailyPrice());
		this.businessCarRules.checkIfState(createCarRequest.getState());
		Car car=this.modelMapperService.forRequest().map(createCarRequest, Car.class);
		this.carRepository.save(car);
		
	}



	@Override
	public void update(UpdateCarRequest updateCarRequest) {
		this.businessCarRules.checkIfPlate(updateCarRequest.getPlate());
		this.businessCarRules.checkModelYear(updateCarRequest.getModelYear());
		this.businessCarRules.checkIfDailyPrice(updateCarRequest.getDailyPrice());
		this.businessCarRules.checkIfState(updateCarRequest.getState());
		Car car=this.modelMapperService.forRequest().map(updateCarRequest, Car.class);
		this.carRepository.save(car);
	}

	@Override
	public void delete(int id) {
	this.carRepository.deleteById(id);
		
	}

	

}
