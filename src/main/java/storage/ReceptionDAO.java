package storage;

import java.util.List;

import model.Reception;

public interface ReceptionDAO {

	void createReception(Reception reception);
	
	void updateReception(Reception newReception);
	
	Reception getReceptionById(Long receptionId);
	
	List<Reception> getReceptionByEmployeeId(Long employeeId);

	Reception getReceptionByEmployeeIdAndAssetId(Long employeeId, Long employeeAssetId);
}
