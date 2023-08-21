package edu.kh.emp.model.service;

import static edu.kh.emp.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

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

	/** 입력 받은 부서와 일치하는 모든 사원 정보 조회 서비스
	 * @return list
	 * @throws Exception 
	 */
	public List<Employee> selectDeptEmp(String departmentTitle) throws Exception {
		
		Connection conn = getConnection();
		
		List<Employee> list = dao.selectDeptEmp(conn, departmentTitle);
		
		close(conn);
		
		return list;
	}

	
	/** 입력 받은 급여 이상을 받는 모든 사원 정보 조회 서비스
	 * @return list
	 * @throws Exception 
	 */
	public List<Employee> selectSalaryEmp(int inputSalary) throws Exception {
		
		Connection conn = getConnection();

		List<Employee> list = dao.selectSalaryEmp(conn, inputSalary);

		close(conn);
		
		return list;
	}

	/** 부서별 급여 합 전체 조회 서비스
	 * @return
	 * @throws Exception
	 */
	public Map<String, Integer> selectDeptTotalSalary() throws Exception {
		
		Connection conn = getConnection();
		
		Map<String, Integer> map = dao.selectDeptTotalSalary(conn);
		
		close(conn);
		
		return map;
	}
	
	/** 주민등록번호가 일치하는 사원 정보 조회 서비스
	 * @param input
	 * @return
	 * @throws Exception 
	 */
	public Employee selectEmpNo(String empNo) throws Exception {
		Connection conn = getConnection();
		
		Employee emp = dao.selectEmpNo(conn, empNo);
		
		close(conn);
		
		return emp;
	}

	
	/** 직급별 급여 평균 조회 서비스
	 * @return
	 */
	public Map<String, Double> selectJobAvgSalary() throws Exception {
		Connection conn = getConnection();

		Map<String, Double> map = dao.selectJobAvgSalary(conn);

		close(conn);

		return map;
	}




	
	
	
}


























