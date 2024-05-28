import java.sql.*;

class JDBCTests {
    public String url = "jdbc:mysql://localhost:3306/?user=root";
    public  String username = "root";
    public String password = "Password";
    Connection connect;
    JDBCTests(){
        try{
            this.connect = DriverManager.getConnection(url, username, password);
            System.out.println("Database Connected");
        }catch(Exception EE){
            System.out.println(EE.getMessage());
        }
    }
    void View(int id){
       try{
            String SQL_command = "SELECT * From schooldtb.student WHERE StudentID = " + id;
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
				
                System.out.println("ID: "+ StudenID +"\nLast Name: " + lastName +"\nFirst Name: "+ firstName + "\nAddress: " + address);
                System.out.println("City: "+ city +"\nState: "+ state + "\nzip: "+ zip);
            }
            connect.close();
        }catch(Exception EE){
            System.out.println(EE.getMessage());
        }
    }
    void Add(int StudentID, String LastName, String FirstName, String Address, String city , String state,String zip){
        try {
            String SQL_command = "INSERT INTO schooldtb.student VALUES ('" + StudentID + "','" + LastName + "','" + FirstName + "','" + Address + "','" + city + "','"+ state +"', '"+ zip +"');"; 
            System.out.print(SQL_command);
            PreparedStatement statement = connect.prepareStatement(SQL_command);
            statement.executeUpdate(SQL_command);
        }
        catch(Exception EE){
            System.out.println(EE.getMessage());
        }
    }
    void Update(int StudentID, String LastName, String FirstName, String Address, String City , String State, String Zip){
        try {
            String SQL_command = "SELECT * From schooldtb.student WHERE StudentID = " + StudentID;
            PreparedStatement statement = connect.prepareStatement(SQL_command);
            ResultSet result = statement.executeQuery();
            int StudenID;
            String lastName = "",firstName = "", address = "", city = "", state = "", zip= "";
            while(result.next()){
                StudenID = result.getInt(1);
                lastName = result.getString(2);
				firstName = result.getString(3);
                address = result.getString(4);
				city = result.getString(5);
                state= result.getString(6);
				zip = result.getString(7);
				
                System.out.println("ID: "+ StudenID +"\nLast Name: " + lastName +"\nFirst Name: "+ firstName + "\nAddress: " + address);
                System.out.println("City: "+ city +"\nState: "+ state + "\nzip: "+ zip);
            }

            String SQL = "UPDATE schooldtb.student SET ";
            String Changes = "";
            if (!lastName.equals(LastName)){
                Changes += "LastName = '"+ LastName + "', " ;
            }
            if (!firstName.equals(FirstName)){
                Changes += "FirstName = '" + FirstName + "', ";
            }
            if (!address.equals(Address)){
                Changes += "Address = '" + Address + "', ";
            }
            if (!city.equals(City)){
                Changes +="City = '" + City + "', ";
            }
            if (!state.equals(State)){
                Changes += "State = '" + State + "', ";
            }
            if(!zip.equals(Zip)){
                Changes += "Zip = '" + Zip + "', ";
            }
            SQL += Changes.substring(0,Changes.length()-2);
            SQL += " WHERE StudentID = " + StudentID;
            System.out.print(SQL);
            PreparedStatement statement2 = connect.prepareStatement(SQL);
            statement2.executeUpdate(SQL);
        }
        catch(Exception EE){
            System.out.println(EE.getMessage());
        }
    }
    void CloseConnect(){
       try{
            connect.close();
       }
       catch(Exception EE){
        System.out.println(EE.getMessage());
       }
    }
}
