package service;

import java.util.List;

import model.Returning;

public interface ReturningService {

	void createReturning(Returning returning);
	
	void updateReturning(Returning returning);
	
	List<Returning> getReturningByEmployeeId(String employeeId);

	Returning getReturningByEmployeeIdAndAssetId(String employeeId, String employeeAssetId);
}
