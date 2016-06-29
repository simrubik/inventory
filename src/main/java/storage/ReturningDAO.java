package storage;

import java.util.List;

import model.Returning;

public interface ReturningDAO {

	void createReturning(Returning returning);

	List<Returning> getEmployeeAssetReturning(Integer employeeAssetId);
}
