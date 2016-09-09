package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import model.Returning;
import service.ReturningService;
import storage.ReturningDAO;

@Service
@Transactional
public class ReturningServiceImpl implements ReturningService {

	@Autowired
	private ReturningDAO returningDAO;

	public void createReturning(Returning returning) {
		returningDAO.createReturning(returning);
	}

	public void updateReturning(Returning returning) {
		returningDAO.updateReturning(returning);	
	}

	public List<Returning> getReturningByEmployeeId(String employeeId) {
		return returningDAO.getReturningByEmployeeId(Long.parseLong(employeeId));
	}

	@Override
	public Returning getReturningByEmployeeIdAndAssetId(String employeeId, String employeeAssetId) {
		return returningDAO.getReturningByEmployeeIdAndAssetId(Long.parseLong(employeeId), Long.parseLong(employeeAssetId));
	}

}
