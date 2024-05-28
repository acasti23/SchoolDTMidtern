import java.sql.*;
import javafx.collections.*;

public class Enrollment implements Comparable<Enrollment> {
	int SID, CID, EID;
	String year, semester;
	char grade;

	Enrollment(int EID, int CID, int SID, String year, String semester, char grade) {
		this.SID = SID;
		this.CID = CID;
		this.EID = EID;
		this.year = year;
		this.semester = semester;
		this.grade = grade;
	}

	@Override
	public int compareTo(Enrollment Enroll) {
		return 0;
	}

	void setCID(int CID) {
		this.CID = CID;
	}

	void setSID(int SID) {
		this.SID = SID;
	}

	void setEID(int EID) {
		this.EID = EID;
	}

	void setYear(String year) {
		this.year = year;
	}

	void setSemester(String semester) {
		this.semester = semester;
	}

	void setGrade(char grade) {
		this.grade = grade;
	}
	

	public int getEID() {
		return EID;
	}

	public int getCID() {
		return CID;
	}

	public int getSID() {
		return SID;
	}

	public String getYears() {
		return year;
	}

	public String getSemester() {
		return semester;
	}

	public char getGrade() {
		return grade;
	}

	public String toString() {
		return EID + "," + CID + "," + SID + "," + year + "," + semester + "," + grade;
	}
}
class EnrollmentFileManager {
	
	String filename;
	MyGenericList<Enrollment> enrollments = new MyGenericList<Enrollment>();// arrayList<Enrollment>
	Connection connect;
	EnrollmentFileManager(String url, String userName,String password) {
		try {
			connect = DriverManager.getConnection(url,userName,password);
			System.out.println("Database Connected: Enrollment Table");
            String SQL_command = "SELECT * From sys.enrollment";
            PreparedStatement statement = connect.prepareStatement(SQL_command);
            ResultSet result = statement.executeQuery();
			while (result.next()) {
				int EID = result.getInt(1);
                int CID = result.getInt(2);
				int SID = result.getInt(3);
               	String Year = result.getString(4);
				String Semester = result.getString(5);						
				char Grade = result.getString(6).charAt(0);
				// Create course object using variables
					Enrollment enrollment = new Enrollment(EID, CID, SID, Year, Semester, Grade);
					enrollments.add(enrollment);// Add course Object to array list
			}
		} catch (SQLException ioe) {
			System.out.println("Error" + ioe.getMessage());
		}catch(Exception ee){
			System.out.println("Error" + ee.getMessage());
		}
	}
	Enrollment GetEnrollment(int eid, int cid, int sid, String Year, String Semester) throws EmptyFieldException{
			for (int i = 0; i < enrollments.count; i++) {
				Enrollment current = enrollments.get(i);
				int Eid = current.EID;
				if (Eid == eid) {
					return current;
				}
			}
		return null;
	}
	Enrollment GetEnrollment(int eid) throws EmptyFieldException{
		if (eid == 0) {
			throw new EmptyFieldException("Not a Valid ID");
		} else {
			for (int i = 0; i < enrollments.count; i++) {
				Enrollment current = enrollments.get(i);
				int Eid = current.EID;
				if (Eid == eid) {
					return current;
				}
			}
		}
		return null;
	}

	boolean addEnrollment(int EID, int CID, int SID, String year, String semester, char Grade)
			throws EmptyFieldException{
		if (year.equals("") || semester == null || Grade == ' ') {
			throw new EmptyFieldException("One or More Fields Are Empty");
		} else {
			if (GetEnrollment(EID, CID, SID, year, semester) == null) {
				try{
					String SQL_command = "INSERT INTO sys.enrollment VALUES ('" + EID + "','" + CID + "','" + SID + "','" + year + "','" + semester+ "','" + Grade +"');"; 
                   	System.out.println(EID);
					System.out.println(SQL_command);
                   	PreparedStatement statement = connect.prepareStatement(SQL_command);
                	statement.executeUpdate(SQL_command);
					Enrollment enroll = new Enrollment(EID, CID, SID, year, semester, Grade);
					enrollments.add(enroll);
					System.out.println("Enrollment Has Been Added");
					return true;
				}catch(Exception ee){
					System.out.println(ee.getMessage());
				}					
			} else {
				System.out.println("Enrollment already Exist");
				return false;
			}
		}return false;

	}
	boolean updateEnrollment(int EID, int CID, int SID, String Year, String Semester, char Grade) throws EmptyFieldException {
		if (Year.equals("") || Semester == null || Grade == ' ') {
			throw new EmptyFieldException("One or More Fields Are Empty");
		} else {
				if (GetEnrollment(EID, CID, SID, Semester, Year) != null) {
					Enrollment enroll = GetEnrollment(EID, CID, SID, Year, Semester);
					int cid = enroll.CID;
					int sid = enroll.SID;
					String year = enroll.year;
					String semester = enroll.semester;
					char grade = enroll.grade;
					
					String SQL = "UPDATE sys.enrollment SET ";
                	String Changes = "";
					if(cid != CID){
						Changes += "CID = " + CID +", ";
						enroll.setCID(CID);
					}
					if(sid != SID){
						Changes += "CID = " + SID +", ";
						enroll.setSID(SID);
					}
					if(!year.equals(Year)){
						Changes += "years = " + Year+", ";
						enroll.setYear(Year);
					}
					if(!semester.equals(Semester)){
						Changes += "semester = " + Semester +", ";
						enroll.setSemester(Semester);
					}			
					if(grade != Grade){
						Changes += "grade = " + Grade +", ";
						enroll.setGrade(Grade);
					}				
					try{
						SQL += Changes.substring(0,Changes.length()-2);
						SQL += " WHERE EID = " + EID;
						PreparedStatement statement2 = connect.prepareStatement(SQL);
						statement2.executeUpdate(SQL);
						enrollments.add(EID, enroll);
						enrollments.delete(EID);
					}catch(Exception EE){
						System.out.println(EE.getMessage());
					}
					System.out.println("Enrollment Has Been Updated");
					return true;
				} else {
					System.out.println("Enrollment Does Not Exist");
					return false;
				}
		}

	}


	ObservableList<Object> FindStudentsEnrolled(int CourseID, String Semester, String Year) throws EmptyFieldException {
		ObservableList<Object> EnrollmentByCourse = FXCollections.observableArrayList();;
		if (CourseID==0 || Semester == null || Year.equals("")) {
			throw new EmptyFieldException("Error One or More Fields are Empty");
		} else {
			for (int j = 0; j < enrollments.count; j++) {
				Enrollment currentEnrollment = enrollments.get(j);
				if ((Year.equals(currentEnrollment.year))&& (Semester.equals(currentEnrollment.semester))) {
							EnrollmentByCourse.add(currentEnrollment);
							
				}
			}
		}
		return EnrollmentByCourse;
	}
}