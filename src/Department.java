import java.sql.*;

public class Department implements Comparable<Department> {
	int ID;
	String Department;

	Department(int ID, String Department) {
		this.ID = ID;
		this.Department = Department;
	}

	@Override
	public int compareTo(Department dept) {
		return 0;
	}

	void setID(int ID) {
		this.ID = ID;
	}

	void setDepartment(String Department) {
		this.Department = Department;
	}

	public String toString() {
		return ID + "," + Department;
	}
}
class DepartmentFileManager {
	Connection connect;
	MyGenericList<Department> departments = new MyGenericList<Department>();

	// Constructure
	DepartmentFileManager(String url, String userName,String password) {
		try {
			connect = DriverManager.getConnection(url,userName,password);
			System.out.println("Database Connected: Department Table");
            String SQL_command = "SELECT * From sys.department";
            PreparedStatement statement = connect.prepareStatement(SQL_command);
            ResultSet result = statement.executeQuery();
			while(result.next()) {
				int ID = result.getInt(1);
				String department =result.getString(2);
				Department depart = new Department(ID, department);
				departments.add(depart);// Add course Object to array list
				            
			}
		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		}
		catch(Exception EE){
			System.out.println(EE.getMessage());
		}
	}
	Department GetDepartment(int ID) throws EmptyFieldException{
		for (int i = 0; i < departments.count; i++) {
			Department current = departments.get(i);
			int id = current.ID;
			if (ID == id) {
				return current;
			}
		}
		return null;
	}
	Department GetDepartment(String DepartmentName) throws EmptyFieldException{
		for (int i = 0; i < departments.count; i++) {
			Department current = departments.get(i);
			String name = current.Department;
			if (name.equals(DepartmentName)) {
				return current;
			}
		}
		return null;
	}
	boolean addDepartment(int ID, String department) throws EmptyFieldException {
		// If Enrollment does not exsist then add it to the arraylist and return true
		if (department == null) {
			throw new EmptyFieldException("Department is empty");
		} else {
			if (GetDepartment(ID) == null) {
				try{
					String SQL_command = "INSERT INTO sys.department VALUES ('" + ID + "','" + department +"');"; 
                    System.out.println(SQL_command);
                    PreparedStatement statement = connect.prepareStatement(SQL_command);
                    statement.executeUpdate(SQL_command);
					Department depart = new Department(ID, department);
					departments.add(depart);

					System.out.println("Department Has Been Added");
					return true;
				}catch(Exception ee){
					System.out.println(ee.getMessage());
				}	
			}
			System.out.println("Department Already Exists");
			return false;
		}
	}
	boolean AddDepartment(int ID, String department) throws EmptyFieldException{
		if (department == null) {
			throw new EmptyFieldException("Department Field is Empty");
		} else {
			// If Enrollment does not exsist then add it to the arraylist and return true
			if (GetDepartment(ID) == null && !(GetDepartment(ID).Department.equals(department))) {
				try{
					String SQL_command = "INSERT INTO sys.depatment VALUES ('" + ID + "','" + department +"');"; 
                    System.out.println(SQL_command);
                    PreparedStatement statement = connect.prepareStatement(SQL_command);
                    statement.executeUpdate(SQL_command);
					Department depart = new Department(ID, department);
					departments.add(depart);
					System.out.println("Department Has Been Added");
					return true;
				}catch(Exception ee){
					System.out.println(ee.getMessage());
				}
			} else {
				System.out.println("Department already Exist");
				return false;
			}
		}
		return false;
	}
	boolean updateDepartment(int ID, String Department) throws EmptyFieldException {
		if (Department == null) {
			throw new EmptyFieldException("Department Fields Are Empty");
		} else {
			if (GetDepartment(ID) != null) {
				Department depart = GetDepartment(ID);
				String department = depart.Department;

				String SQL = "UPDATE sys.department SET ";
                String Changes = "";
				if (!Department.equals(department)){
					Changes += "departmentName = '" + Department +"'";
					depart.Department = Department;
				}

				try{	
					
					SQL += Changes +" WHERE departmentID = " + ID ;
					System.out.println(SQL);
					PreparedStatement statement2 = connect.prepareStatement(SQL);
					statement2.executeUpdate(SQL);			
					departments.add(ID, depart);
					departments.delete(ID);
					
					System.out.println("Department Has Been Updated");
					return true;
				}catch(Exception EE){
                    System.out.println(EE.getMessage());
                }
				
			} else {
				System.out.println("Department Does Not Exist");
				return false;
			}
		}
		return false;
	}
}