package kemalkeskin.keskinRental.business.responses.car;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByIdCarResponse {

private int id;
	
	private String plate;

	private int modelYear;

	private double dailyPrice;

	private int state;

	private String modelName;
	
	private String brandName;
}
