package service;

import java.util.List;

import model.Reception;

public interface ReceptionService {

	void createReception(Reception reception);

	List<Reception> getEmployeeAssetReceptions(Long employeeAssetId);
}
