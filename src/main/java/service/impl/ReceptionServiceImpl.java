package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import model.Reception;
import service.ReceptionService;
import storage.ReceptionDAO;

@Service
@Transactional
public class ReceptionServiceImpl implements ReceptionService {

	@Autowired
	private ReceptionDAO receptionDAO;

	public void createReception(Reception reception) {
		receptionDAO.createReception(reception);
	}

	@Override
	public void updateReception(Reception reception) {
		receptionDAO.updateReception(reception);
	}

	@Override
	public Reception getReceptionById(String receptionId) {
		return receptionDAO.getReceptionById(Long.parseLong(receptionId));
	}

	@Override
	public List<Reception> getReceptionByEmployeeId(String employeeId) {
		return receptionDAO.getReceptionByEmployeeId(Long.parseLong(employeeId));
	}

	@Override
	public Reception getReceptionByEmployeeIdAndAssetId(String employeeId, String employeeAssetId) {
		return receptionDAO.getReceptionByEmployeeIdAndAssetId(Long.parseLong(employeeId), Long.parseLong(employeeAssetId));
	}

}
