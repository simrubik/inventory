package storage;

import java.util.List;

import model.Returning;

public interface ReturningDAO {

	void createReturning(Returning returning);
	
	void updateReturning(Returning returning);
	
	List<Returning> getReturningByEmployeeId(Long employeeId);

	Returning getReturningByEmployeeIdAndAssetId(Long employeeId, Long employeeAssetId);
}
