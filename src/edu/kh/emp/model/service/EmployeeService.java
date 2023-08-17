package edu.kh.emp.model.service;

import static edu.kh.emp.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;
import static edu.kh.emp.common.JDBCTemplate.*;
import edu.kh.emp.model.dao.EmployeeDAO;
import edu.kh.emp.model.vo.Employee;

public class EmployeeService {
	
	private EmployeeDAO dao = new EmployeeDAO();
	
	/** 전체 사원 정보 조회 서비스
	 * 
	 */
	public List<Employee> selectAll() throws Exception {
		
		Connection conn = getConnection();
		
		List<Employee> list = dao.selectAll(conn);
		
		close(conn);
		
		return list;
		
	}

	/** 새로운 사원 추가 서비스
	 * @param emp1
	 * @return result
	 * @throws Exception
	 */
	public int insertEmployee(Employee emp1) throws Exception{
		
		Connection conn = getConnection();
		
		int result = dao.insert(conn,emp1);
		
		if(result > 0) commit(conn);
		else			rollback(conn);
		
		close(conn);
		
		return result;
		
		
	}

	/** 사번이 일치하는 사원 정보 조회 서비스
	 * @return result
	 * @throws Exception 
	 * 
	 */

	public Employee selectEmpId(int empId) throws Exception {
		Connection conn = getConnection();
		
		Employee emp = dao.selectEmpid(conn, empId);
		
		close(conn);
		
		return emp;
	}

	/** 사번이 일치하는 사원 정보 수정 서비스
	 * @param emp
	 * @return
	 * @throws Exception 
	 */
	public int updateEmployee(Employee emp) throws Exception {
		
		Connection conn = getConnection();
		
		int result = dao.updateEmployee(conn, emp);
		
		if(result>0) commit(conn);
		else		rollback(conn);
		
		close(conn);
		
		return result;
	}


	/** 사번이 일치하는 사원 정보 삭제 서비스
	 * @param empId
	 * @return
	 * @throws Exception
	 */
	public int deleteEmployee(int empId) throws Exception {
		
		Connection conn = getConnection();
		
		int result = dao.deleteEmployee(conn, empId);
		
		if(result>0) commit(conn);
		else		rollback(conn);
		
		close(conn);
		
		return result;
	}
	
	
	
}


























