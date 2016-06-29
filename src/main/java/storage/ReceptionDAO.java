package storage;

import java.util.List;

import model.Reception;

public interface ReceptionDAO {

	void createReception(Reception reception);

	List<Reception> getEmployeeAssetReceptions(Long employeeAssetId);
}
