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

	public List<Returning> getEmployeeAssetReturning(Integer employeeAssetId) {
		// TODO Auto-generated method stub
		return null;
	}

}
