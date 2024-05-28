import java.sql.*;

public class Student implements Comparable<Student> {
	int ID;
	String FirstName, LastName, Address, City, State, Zip;
	

	// Constructor
	Student(int ID, String FirstName, String LastName, String Address, String City, String State, String Zip) {
		this.ID = ID;
		this.FirstName = FirstName;
		this.LastName = LastName;
		this.Address = Address;
		this.City = City;
		this.State = State;
		this.Zip = Zip;
	}

	@Override
	public int compareTo(Student Stud) {
		return 0;
	}

	void setID(int SID) {
		ID = SID;
	}

	void setFirstName(String firstName) {
		FirstName = firstName;
	}

	void setLastName(String lastName) {
		LastName = lastName;
	}

	void setAddress(String address) {
		Address = address;
	}

	void setCity(String city) {
		City = city;
	}

	void setState(String state) {
		State = state;
	}

	void setZip(String zip) {
		Zip = zip;
	}

	public String toString() {
		return ID + "," + FirstName + "," + LastName + "," + Address + "," + City + "," + State + "," + Zip;
	}

}
class StudentFileManager {
    Connection connect;
    MyGenericList<Student> student = new MyGenericList<Student>();// arrayList<Student>
    StudentFileManager(String url, String username, String password){
         try{
			connect =DriverManager.getConnection(url, username, password);
            System.out.println("Database Connected: Student Table");
            String SQL_command = "SELECT * From sys.student";
            PreparedStatement statement = connect.prepareStatement(SQL_command);
            ResultSet result = statement.executeQuery();
            while(result.next()){
                int StudenID = result.getInt(1);
                String lastName = result.getString(2);
				String firstName = result.getString(3);
                String address = result.getString(4);
				String city = result.getString(5);
                String state= result.getString(6);
				String zip = result.getString(7);
                Student stud = new Student(StudenID, firstName, lastName, address, city, state, zip);
                student.add(stud);
            }
        } catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
        }catch(Exception EE){
            System.out.println(EE.getMessage());
        }
    }
    Student GetStudent(int id) throws EmptyFieldException {
		if (id == 0) {
			throw new EmptyFieldException("Not a Valid ID");
		} else {
			for (int i = 0; i < student.count; i++) {
				Student current = student.get(i);
				
				int ID = current.ID;
				if (ID == id)
					return current;
			}
			return null;
		}
	}
    boolean AddStudent(int ID, String FirstName, String LastName, String Address, String City, String State, String Zip)
			throws EmptyFieldException {
		if (GetStudent(ID) == null) {
			if (FirstName.equals("") || LastName.equals("") || Address.equals("") || City.equals("") || State == null
					|| Zip.equals("")) {
				throw new EmptyFieldException("One or More Fields Are Empty");
			} else {
				// If Student ID does not exist then it will add Student to arraylist
				
				// Change to add to database
				try {
					Student stud = new Student(ID, FirstName, LastName, Address, City, State, Zip);
					student.add(stud);
					String SQL_command = "INSERT INTO sys.student VALUES ('" + ID + "','" + LastName + "','" + FirstName + "','" + Address + "','" + City + "','"+ State +"', '"+ Zip +"');"; 
                    System.out.println(SQL_command);
                    PreparedStatement statement = connect.prepareStatement(SQL_command);
                    statement.executeUpdate(SQL_command);
					
                    
                }
                catch(Exception EE){
                    System.out.println(EE.getMessage());
                }
				// Comfirmation that student was Added and returnd true
				System.out.println("Student has been added");
				return true;
			}
		}
		// If student Exist print an error message and return False
		else {
			System.out.println("Student Already Exists");
			return false;
		}
	}
    boolean updateStudent(int ID, String FirstName, String LastName, String Address, String City, String State,
			String Zip) throws  EmptyFieldException {
		if (FirstName.equals("") || LastName.equals("") || Address.equals("") || City.equals("") || State == null
				|| Zip.equals("")) {
			throw new EmptyFieldException("One or More Fields Are Empty");
		} else {
			if (GetStudent(ID) != null) {
				Student stud = GetStudent(ID);
                String lastName = stud.LastName ,firstName = stud.FirstName, address = stud.Address, city = stud.City, state = stud.State, zip= stud.Zip;

                String SQL = "UPDATE sys.student SET ";
                String Changes = "";
                if (!lastName.equals(LastName)){
                    Changes += "LastName = '"+ LastName + "', " ;
                    stud.setLastName(LastName);
                }
                if (!firstName.equals(FirstName)){
                    stud.setFirstName(FirstName);
                    Changes += "FirstName = '" + FirstName + "', ";
                }
                if (!address.equals(Address)){
                    stud.setAddress(Address);
                    Changes += "Address = '" + Address + "', ";
                }
                if (!city.equals(City)){
                    stud.setCity(city);
                    Changes +="City = '" + City + "', ";
                }
                if (!state.equals(State)){
                    stud.setState(State);
                    Changes += "State = '" + State + "', ";
                }
                if(!zip.equals(Zip)){
                    stud.setZip(Zip);
                    Changes += "Zip = '" + Zip + "', ";
                }
                student.delete(ID-1);
				student.add(ID, stud);// Replace student object in arraylist
                try{
					SQL += Changes.substring(0,Changes.length()-2);
					SQL += " WHERE StudentID = " + ID;
					System.out.println(SQL);
					PreparedStatement statement2 = connect.prepareStatement(SQL);
					statement2.executeUpdate(SQL);
                }catch(Exception EE){
                    System.out.println(EE.getMessage());
                }
                return true;
            }
        }			
		return false;
	}
}