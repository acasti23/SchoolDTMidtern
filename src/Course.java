import java.sql.*;
public class Course implements Comparable<Course> {
	int courseID, dept,instructor;
	String name, description ;

	Course(int courseID, String name, String description, int dept, int instructor) {
		this.courseID = courseID;
		this.name = name;
		this.description = description;
		this.dept = dept;
		this.instructor = instructor;
	}

	@Override
	public int compareTo(Course cour) {
		return 0;
	}

	void setID(int courseID) {
		this.courseID = courseID;
	}

	void setName(String name) {
		this.name = name;
	}

	void setDescription(String description) {
		this.description = description;
	}

	public String toString() {
		return courseID + "," + name + "," + description + "," + dept + "," + instructor;
	}
}
class CourseFileManager {
	MyGenericList<Course> courses = new MyGenericList<Course>(); // arrayList<Courset>
	Connection connect;

	// Constructor
	CourseFileManager(String url, String userName,String password) {
		try {
			connect = DriverManager.getConnection(url,userName,password);
			System.out.println("Database Connected: Course Table");
            String SQL_command = "SELECT * From sys.course";
            PreparedStatement statement = connect.prepareStatement(SQL_command);
            ResultSet result = statement.executeQuery();
			while(result.next()) {
				int CourseID = result.getInt(1);
                String CourseName = result.getString(2);
				String CourseDescription = result.getString(3);
               	int DepartID = Integer.parseInt(result.getString(4));
				int InstructID = Integer.parseInt(result.getString(5));
                Course cour = new Course(CourseID, CourseName, CourseDescription, DepartID, InstructID);
                courses.add(cour);
			}
		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		}
		catch(Exception EE){
			System.out.println(EE.getMessage());
		}
	}

	Course GetCourse(int cid) throws EmptyFieldException {
		if (cid == 0) {
			throw new EmptyFieldException("Invalid Course ID");
		} else {
			for (int i = 0; i < courses.count; i++) {
				Course current = courses.get(i);
				int ID = current.courseID;
				if (ID == cid)
					return current;
			}
		}
		return null;

	}

	Course GetCourse(String name) throws EmptyFieldException{
		// try{
		if (name.equals("") ) {
			throw new EmptyFieldException("Invalid Course Name");
		} else {
			for (int i = 0; i < courses.count; i++) {
				Course current = courses.get(i);
				String Name = current.name;
				if (name.equals(Name))
					return current;
			}
		}
		return null;

	}
	boolean AddCourse(int CID, String courseName, String courseDescrip, int dept, int instructor)
			throws EmptyFieldException {
		if (GetCourse(CID) == null) {
			if (courseName.equals("") || courseDescrip.equals("") || dept == 0 || instructor == 0) {
				throw new EmptyFieldException("Course ID Field is Blank");
			} else {
				try{
					String SQL_command = "INSERT INTO sys.course VALUES ('" + CID + "','" + courseName + "','" + courseDescrip + "','" + dept + "','" + instructor +"');"; 
                    System.out.println(SQL_command);
                    PreparedStatement statement = connect.prepareStatement(SQL_command);
                    statement.executeUpdate(SQL_command);
					Course cour = new Course(CID, courseName, courseDescrip, dept, instructor);
					courses.add(cour);
					System.out.println("Course has been added");// Confirmation Statement
					return true;
				}catch(Exception ee){
					System.out.println(ee.getMessage());
				}
			}
		}
		// If the course already exist then display an error message and return false
		System.out.println("Course Already Exists");
		return false;
	}

	boolean updateCourse(int cid, String courName, String courseDescription, int dept, int instructor)
			throws EmptyFieldException {
		if (courName.equals("") || courseDescription.equals("") || dept == 0 || instructor == 0) {
			throw new EmptyFieldException("One or more fields are blank");
		}else{
			if (GetCourse(cid) != null) {
				Course cour = GetCourse(cid);
				String CourseName = cour.name;
				String CourseDescr = cour.description;
				int CourseDept = cour.dept;
				int Instructor = cour.instructor;

				String SQL = "UPDATE sys.course SET ";
                String Changes = "";
				if(!courName.equals(CourseName)){
					Changes += "courseName = " + courName +", ";
					cour.setName(courName);
				}
				if(!courseDescription.equals(CourseDescr)){
					Changes += "CourseDescrip = '" + courseDescription+ "', ";
					cour.setDescription(courseDescription);
				}
				if(dept!=CourseDept){
					Changes += "DepartmentID = '" + dept + "', ";
					cour.dept = dept;
				}
				if(instructor!=Instructor){
					Changes += "instructorID = '" + instructor + "', ";
					cour.instructor = instructor;
				}				
				
				try{
					SQL += Changes.substring(0,Changes.length()-2);
					SQL += " WHERE courseID = " + cid;
					System.out.println(SQL);
					PreparedStatement statement2 = connect.prepareStatement(SQL);
					statement2.executeUpdate(SQL);
					courses.add(cid, cour);// replace cour
					courses.delete(cid);
                }catch(Exception EE){
                    System.out.println(EE.getMessage());
                }
				System.out.println("Course Has Been Updated");
				return true;
			}
			System.out.println("Course Does Not Exist");
			return false;
		}
	}
}