import javafx.collections.*;
import java.sql.*;


public class Instructor implements Comparable<Instructor> {
	int ID, DeptID;
	String Name;

	Instructor(int ID, String Name, int DeptID) {
		this.DeptID = DeptID;
		this.Name = Name;
		this.ID = ID;
	}

	@Override
	public int compareTo(Instructor instructor) {
		return 0;
	}

	void setID(int ID) {
		this.ID = ID;
	}

	void setName(String Name) {
		this.Name = Name;
	}

	void setDepartment(int Department) {
		this.DeptID = Department;
	}

	public String toString() {
		return ID + "," + Name + "," + DeptID;
	}
}
class InstructorFileManager {
	String filename;
	MyGenericList<Instructor> instructors = new MyGenericList<Instructor>();// arrayList<Enrollment>
	Connection connect;
	InstructorFileManager(String url, String userName,String password) {
		try {
			connect = DriverManager.getConnection(url,userName,password);
			System.out.println("Database Connected: Instructor Table");
            String SQL_command = "SELECT * From sys.instructor";
            PreparedStatement statement = connect.prepareStatement(SQL_command);
            ResultSet result = statement.executeQuery();
			while (result.next()) {
				int ID = result.getInt(1);
                String name = result.getString(2);
				int department = result.getInt(3);
               	Instructor Inst = new Instructor(ID, name, department);
				instructors.add(Inst);

			}
		} catch (SQLException e) {
			System.out.println("Error" + e.getMessage());
		}
		catch(Exception ee) {
			System.out.println("Error" + ee.getMessage());
		}
	}

	boolean AddInstructor(int ID, String Name, int department) throws EmptyFieldException {
		// If Enrollment does not exsist then add it to the arraylist and return true
		if (department==0||Name.equals("")) {
			throw new EmptyFieldException("One or more fields are empty");
		} else {
			if (GetInstructor(ID) == null) {
				try {
				String SQL_command = "INSERT INTO sys.instructor VALUES ('" + ID + "','" + Name + "','" + department +"');"; 
                System.out.println(SQL_command);
                PreparedStatement statement = connect.prepareStatement(SQL_command);
                statement.executeUpdate(SQL_command);

				Instructor inst = new Instructor(ID, Name, department);
				instructors.add(inst);

				System.out.println("Instructor Has Been Added");
				return true;
			} catch (SQLException e) {
				System.out.println("Error" + e.getMessage());
			}
			catch(Exception ee) {
				System.out.println("Error" + ee.getMessage());
			}
		}
			System.out.println("Instructor Already Exists");
			return false;
		}
	}

	Instructor GetInstructor(int ID) throws EmptyFieldException{
		for (int i = 0; i < instructors.count; i++) {
			Instructor current = instructors.get(i);
			int id = current.ID;
			if (ID == id) {
				return current;
			}
		}
		return null;
	}
	Instructor GetInstructor(String Name) throws EmptyFieldException{
		for (int i = 0; i < instructors.count; i++) {
			Instructor current = instructors.get(i);
			String name = current.Name;
			if (Name.equals(name)) {
				return current;
			}
		}
		return null;
	}

	boolean updateInstructor(int ID, String Name, int Department) throws EmptyFieldException {
		if (Department == 0 || Name.equals("")) {
			throw new EmptyFieldException("one or More Field are Empty");
		} else {
			if (GetInstructor(ID) != null) {
				Instructor inst = GetInstructor(ID);
				String name = inst.Name;
				int department = inst.DeptID;
				String Changes = "";
				String SQL = "UPDATE sys.instructor SET ";
				if(!Name.equals(name)){
					Changes += "instructoName = " + Name + ", ";
					inst.Name = Name;
				}
				if(Department !=department){
					Changes += "departmentID = " + Department +", ";
					inst.DeptID = Department;
				}
				SQL += Changes.substring(0,Changes.length()-2);
				SQL += " WHERE instructorID = " + ID;
				System.out.println(SQL);
				try{
					PreparedStatement statement2 = connect.prepareStatement(SQL);
					statement2.executeUpdate(SQL);
					instructors.delete(ID);
					instructors.add(ID, inst);
					
				}catch(SQLException SQLE){
					System.out.println(SQLE.getMessage());
				}catch(Exception e){
					System.out.println(e.getMessage());
				}

				System.out.println("Enrollment Has Been Updated");
				return true;
			} else {
				System.out.println("Enrollment Does Not Exist");
				return false;
			}
		}

	}

	ObservableList<String> GetInstructorByDeparment(int DeparmentID) throws EmptyFieldException {
		ObservableList<String> InstuctorByDeparment = FXCollections.observableArrayList();
		System.out.println(DeparmentID);
		if (DeparmentID== 0 ) {
			throw new EmptyFieldException("One or more fields are empty");
		} else {
			for (int i = 0; i < instructors.count; i++) {
				Instructor current = instructors.get(i);
				int DepartmentName  = current.DeptID;
				if (DepartmentName==DeparmentID) {
					InstuctorByDeparment.add(current.Name);
				}
			}
		}
		return InstuctorByDeparment;

	}
}