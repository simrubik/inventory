package service;

import java.util.List;

import model.Reception;

public interface ReceptionService {

	void createReception(Reception reception);

	void updateReception(Reception newReception);

	Reception getReceptionById(String receptionId);

	List<Reception> getReceptionByEmployeeId(String employeeId);

	Reception getReceptionByEmployeeIdAndAssetId(String employeeId, String employeeAssetId);
}
