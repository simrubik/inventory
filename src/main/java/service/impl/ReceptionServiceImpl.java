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

	public List<Reception> getEmployeeAssetReceptions(Long employeeAssetId) {
		return null;
	}

}
