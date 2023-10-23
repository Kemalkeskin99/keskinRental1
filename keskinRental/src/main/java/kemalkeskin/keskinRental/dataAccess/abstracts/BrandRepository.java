package kemalkeskin.keskinRental.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kemalkeskin.keskinRental.entities.concretes.Brand;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Integer>{

	boolean existsByName(String name);
	//boolean existsById(int id);
}
