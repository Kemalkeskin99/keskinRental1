package kemalkeskin.keskinRental.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kemalkeskin.keskinRental.entities.concretes.Model;

public interface ModelRepository extends JpaRepository<Model, Integer>{

	boolean existsByName(String name);
	
	List<Model>findByBrandId(int brandId);
}
