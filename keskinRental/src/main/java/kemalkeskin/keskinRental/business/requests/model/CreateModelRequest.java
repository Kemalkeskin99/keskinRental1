package kemalkeskin.keskinRental.business.requests.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateModelRequest {

	@JsonIgnore
	private int id;
	
	private String name;
	private int brandId;
}
