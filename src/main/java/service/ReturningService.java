package service;

import java.util.List;

import model.Returning;

public interface ReturningService {

	void createReturning(Returning returning);

	List<Returning> getEmployeeAssetReturning(Integer employeeAssetId);
}
