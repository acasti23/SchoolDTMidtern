//Andrea Castillo
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.geometry.Pos;
import javafx.event.*;
import javafx.collections.*;

import java.io.*;
import java.util.Scanner;


public class Main extends Application  {
   
  // static Connection connect = new JDBCTests().connect;
   static StudentFileManager s ;
   static CourseFileManager c  ;
   static EnrollmentFileManager e;
   static DepartmentFileManager d ;
   static InstructorFileManager i ;

   public static void main(String[] args) {
      try{
         File file = new File("src/app.config");
         Scanner FileScanner = new Scanner(file);
         FileScanner.nextLine();
         String url =  FileScanner.nextLine();
         String username =  FileScanner.nextLine();
         String password =  FileScanner.nextLine();
         s = new StudentFileManager(url,username,password);
         c = new CourseFileManager(url,username,password);
         e = new EnrollmentFileManager(url,username,password);
         d = new DepartmentFileManager(url,username,password);
         i = new InstructorFileManager(url,username,password);
         FileScanner.close();
      }catch(Exception EE){
         System.out.print(EE.getMessage());
      }
      // Launch the application.
      launch(args);
   }

   @Override
   public void start(Stage primaryStage) {
      Label StartTitle = new Label("Start Student Registration");
      Button StartBtn = new Button("Start");
      // Create Menues

      StartBtn.setOnAction(
            new EventHandler<ActionEvent>() {
               @Override
               public void handle(ActionEvent event) {
                  CreateAddStudentScene(primaryStage);
               }
            });
      VBox StartVBox = new VBox(StartTitle, StartBtn);
      StartVBox.setAlignment(Pos.CENTER);
      Scene StartScene = new Scene(StartVBox, 400, 270);
      primaryStage.setScene(StartScene);
      // Set the stage title.
      primaryStage.setTitle(" ");

      // Show the window.
      primaryStage.show();
   }

   static MenuBar createMenueBar(Stage primaryStage) {
      Menu StudMenu = new Menu("Student");
      MenuItem AddStudMenuItem = new MenuItem("Add Student");
      MenuItem EditStudMenuItem = new MenuItem("Edit Student");
      MenuItem ViewStudMenuItem = new MenuItem("View Student");
      StudMenu.getItems().add(AddStudMenuItem);
      StudMenu.getItems().add(EditStudMenuItem);
      StudMenu.getItems().add(ViewStudMenuItem);

      Menu CourseMenu = new Menu("Course");
      MenuItem AddCourMenuItem = new MenuItem("Add Course");
      MenuItem EditCourMenuItem = new MenuItem("Edit Course");
      MenuItem ViewCourMenuItem = new MenuItem("View Course");
      CourseMenu.getItems().add(AddCourMenuItem);
      CourseMenu.getItems().add(EditCourMenuItem);
      CourseMenu.getItems().add(ViewCourMenuItem);

      Menu InstructMenu = new Menu("Instructor");
      MenuItem AddIntructMenuItem = new MenuItem("Add Instructor");
      MenuItem EditInstructMenuItem = new MenuItem("Edit Instructor");
      MenuItem ViewInstructMenuItem = new MenuItem("View Instructor");
      InstructMenu.getItems().add(AddIntructMenuItem);
      InstructMenu.getItems().add(EditInstructMenuItem);
      InstructMenu.getItems().add(ViewInstructMenuItem);

      Menu DepartMenu = new Menu("Department");
      MenuItem AddDepartMenuItem = new MenuItem("Add Department");
      MenuItem EditDepartMenuItem = new MenuItem("Edit Deparment");
      MenuItem ViewDepartMenuItem = new MenuItem("View Deparment");
      DepartMenu.getItems().add(AddDepartMenuItem);
      DepartMenu.getItems().add(EditDepartMenuItem);
      DepartMenu.getItems().add(ViewDepartMenuItem);

      Menu EnrollMenu = new Menu("Enrollment");
      MenuItem AddEnrollMenuItem = new MenuItem("Add Enrollment");
      MenuItem EditEnrollMenuItem = new MenuItem("Edit Enrollment");
      MenuItem ViewEnrollMenuItem = new MenuItem("View Enrollment");
      EnrollMenu.getItems().add(AddEnrollMenuItem);
      EnrollMenu.getItems().add(EditEnrollMenuItem);
      EnrollMenu.getItems().add(ViewEnrollMenuItem);

      Menu ReportMenu = new Menu("Report");
      MenuItem PrintReportMenuItem = new MenuItem("Print Report");
      ReportMenu.getItems().add(PrintReportMenuItem);
      MenuBar x = new MenuBar(StudMenu, CourseMenu, InstructMenu, DepartMenu, EnrollMenu, ReportMenu);

      AddStudMenuItem.setOnAction(
            new EventHandler<ActionEvent>() {
               @Override
               public void handle(ActionEvent e) {
                  CreateAddStudentScene(primaryStage);
               }
            });
      EditStudMenuItem.setOnAction(
            new EventHandler<ActionEvent>() {
               @Override
               public void handle(ActionEvent e) {
                  CreateEditStudentScene(primaryStage);
               }
            });
      ViewStudMenuItem.setOnAction(
            new EventHandler<ActionEvent>() {
               @Override
               public void handle(ActionEvent e) {
                  CreateViewStudentScene(primaryStage);
               }
            });

      AddCourMenuItem.setOnAction(
            new EventHandler<ActionEvent>() {
               @Override
               public void handle(ActionEvent e) {
                  CreateAddCourseScene(primaryStage);
               }
            });
      EditCourMenuItem.setOnAction(
            new EventHandler<ActionEvent>() {
               @Override
               public void handle(ActionEvent e) {
                  CreateEditCourseScene(primaryStage);
               }
            });
      ViewCourMenuItem.setOnAction(
            new EventHandler<ActionEvent>() {
               @Override
               public void handle(ActionEvent e) {
                  CreateViewCoursScene(primaryStage);
               }
            });

      AddDepartMenuItem.setOnAction(
            new EventHandler<ActionEvent>() {
               @Override
               public void handle(ActionEvent e) {
                  CreateAddDepartmentScene(primaryStage);
               }
            });
      EditDepartMenuItem.setOnAction(
            new EventHandler<ActionEvent>() {
               @Override
               public void handle(ActionEvent e) {
                  CreateEditDepartmentScene(primaryStage);
               }
            });
      ViewDepartMenuItem.setOnAction(
            new EventHandler<ActionEvent>() {
               @Override
               public void handle(ActionEvent e) {
                  CreateViewDepartmentScene(primaryStage);
               }
            });

      AddIntructMenuItem.setOnAction(
            new EventHandler<ActionEvent>() {
               @Override
               public void handle(ActionEvent e) {
                  CreateAddInstructorScene(primaryStage);
               }
            });
      EditInstructMenuItem.setOnAction(
            new EventHandler<ActionEvent>() {
               @Override
               public void handle(ActionEvent e) {
                  CreateEditInstructorScene(primaryStage);
               }
            });
      ViewInstructMenuItem.setOnAction(
            new EventHandler<ActionEvent>() {
               @Override
               public void handle(ActionEvent e) {
                  CreateViewInstructorScene(primaryStage);
               }
            });

      AddEnrollMenuItem.setOnAction(
            new EventHandler<ActionEvent>() {
               @Override
               public void handle(ActionEvent e) {
                  CreateAddEnrollmentScene(primaryStage);
               }
            });

      EditEnrollMenuItem.setOnAction(
            new EventHandler<ActionEvent>() {
               @Override
               public void handle(ActionEvent e) {
                  CreateEditEnrollmentcene(primaryStage);
               }
            });
      ViewEnrollMenuItem.setOnAction(
            new EventHandler<ActionEvent>() {
               @Override
               public void handle(ActionEvent e) {
                  CreateViewEnrollmentScene(primaryStage);
               }
            });
      PrintReportMenuItem.setOnAction(
            new EventHandler<ActionEvent>() {
               @Override
               public void handle(ActionEvent e) {
                  CreateReportScene(primaryStage);
               }
            });
      return x;
   }

   static void CreateAddStudentScene(Stage primaryStage) {
      MenuBar x = createMenueBar(primaryStage);

      // Build Add Student Scene
      Label addStudTitle = new Label("Add Student: ");// Tittle
      HBox addStudBox = new HBox(addStudTitle);
      addStudBox.setAlignment(Pos.CENTER);
      // Student First Name Box
      Label firstName = new Label("Student First Name: ");
      TextField firstNameField = new TextField();
      // Student Last Name Box
      Label LastName = new Label("Student Last Name: ");
      TextField LastNameField = new TextField();
      // Student Address Box
      Label StudAddress = new Label("Address: ");
      TextField StudAddressField = new TextField();
      // Student City Box
      Label StudCity = new Label("City: ");
       TextField StudCityField = new TextField();
      // //Student State Box
      Label State = new Label("State: ");
      //    
       TextField StateCB = new TextField();
      StateCB.setEditable(false);
      StudCityField.setEditable(false);    
            // Student Zip Box
      Label StudZip = new Label("Zip Code: ");
      TextField StudZipField = new TextField();
      Button addStud = new Button("Add Student");
      Button findZip = new Button("Find Zip");
      HBox buttonBox = new HBox(addStud);
      buttonBox.setAlignment(Pos.CENTER);
      StudCityField.setEditable(false);
    StateCB.setEditable(false);
    addStud.setDisable(true);
   
      HBox StudZipBox = new HBox(StudZipField,findZip);
      VBox vbox1 = new VBox(10, firstName, LastName, StudAddress, StudZip,  StudCity, State);
      vbox1.setAlignment(Pos.CENTER_RIGHT);
      VBox vbox2 = new VBox(firstNameField, LastNameField, StudAddressField, StudZipBox,
             StudCityField, StateCB);
      HBox hbox = new HBox(vbox1, vbox2);
      hbox.setAlignment(Pos.CENTER);
      VBox fullBox = new VBox(x, addStudBox, hbox, buttonBox);
      // Event Handler for Add Student Button
      

      findZip.setOnAction(
            new EventHandler<ActionEvent>() {
               @Override
               public void handle(ActionEvent event) {
                   try{
                    final String Zip = StudZipField.getText();
                    zipCodeClient zp = new zipCodeClient(Zip);
                    final String studentCity = zp.GetCity();
                    final String studentState = zp.GetState();
                    StudCityField.setText(studentCity);
                    StateCB.setText(studentState);
                    addStud.setDisable(false);
                   }
                   catch(Exception exc){
                     final String Zip = StudZipField.getText();
                     Alert alert = new Alert(Alert.AlertType.ERROR, "Zip Code "+ Zip +" not found", ButtonType.OK);
                     StudZipField.clear();
                     alert.showAndWait();
                   }
               }
            });
      addStud.setOnAction(
            new EventHandler<ActionEvent>() {
               @Override
               public void handle(ActionEvent event) {
                  // Get Text from Fields
                  final int studentID = s.student.count + 1;
                  final String studentFirstName = firstNameField.getText();
                  final String studentLastName = LastNameField.getText();
                  final String studentAddress = StudAddressField.getText();
                  String studentCity =  StudCityField.getText() ;
                  String studentState = StateCB.getText();
                  final String studentZip = StudZipField.getText();

                  // Catch IOException
                  try {
                     if (!s.AddStudent(studentID, studentFirstName, studentLastName, studentAddress, studentCity,
                           studentState, studentZip)) {
                        Alert alert = new Alert(Alert.AlertType.ERROR, "Student Already Exists ", ButtonType.OK);

                        alert.showAndWait();
                     } else {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION,
                              "Student ID: " + studentID + "\nStudent Name: " + studentFirstName + " " + studentLastName
                                    + "\nAddress: " + studentAddress + "\n\t   " + studentCity + ", " + studentState
                                    + " " + studentZip,
                              ButtonType.OK);
                        alert.setHeaderText("Student Added");
                        firstNameField.clear();
                        LastNameField.clear();
                        StudAddressField.clear();
                        StudZipField.clear();
                        StateCB.clear();
                        StudCityField.clear();
                        

                        alert.showAndWait();
                     }
                  } catch (EmptyFieldException EFE) {
                     Alert alert = new Alert(Alert.AlertType.ERROR, EFE.getMessage(), ButtonType.OK);
                     alert.showAndWait();
                  } catch (Exception exc) {
                     Alert alert = new Alert(Alert.AlertType.ERROR, exc.getMessage(), ButtonType.OK);
                     alert.showAndWait();
                  }
               }
            });
      Scene AddStudentScene = new Scene(fullBox, 400, 270);
      primaryStage.setScene(AddStudentScene);
   }

   static void CreateEditStudentScene(Stage primaryStage) {
      MenuBar x = createMenueBar(primaryStage);

      // Add Student Scen
      Label addStudTitle = new Label("Edit Student: ");
      HBox titleBox = new HBox(addStudTitle);
      titleBox.setAlignment(Pos.CENTER);

      Label StudID = new Label("              Student ID: ");
      TextField StudIDField = new TextField();
      HBox StudIDBox = new HBox(StudID, StudIDField);
      StudIDBox.setAlignment(Pos.CENTER);

      Label firstName = new Label("Student First Name: ");
      TextField firstNameField = new TextField();

      Label LastName = new Label("Student Last Name: ");
      TextField LastNameField = new TextField();

      Label StudAddress = new Label("Address: ");
      TextField StudAddressField = new TextField();

      Label StudCity = new Label("City: ");
      TextField StudCityField = new TextField();

      Label State = new Label("State: ");

      ObservableList<String> states = FXCollections.observableArrayList("AK", "AL", "AR", "AZ", "CA",
            "CO", "CT", "DC", "DE", "FL",
            "GA", "HI", "IA", "ID", "IL",
            "IN", "KS", "KY", "LA", "LA",
            "MA", "MD", "ME", "MI", "MN",
            "MO", "MS", "MT", "NC", "ND",
            "NE", "NH", "NJ", "NM", "NV",
            "NY", "OH", "OK", "OR", "PA",
            "RI", "SC", "SD", "TN", "TX",
            "UT", "VA", "VT", "WA", "WI",
            "WV", "WY");

      ComboBox<String> StateCB = new ComboBox<>(states);
      Label StudZip = new Label("Zip Code: ");
      TextField StudZipField = new TextField();

      Button FindStud = new Button("Find Student");
      Button EditStud = new Button("Edit Student");
      Button FindAnotherStud = new Button("Find Another Student");
      Button findZip = new Button("Find Zip");
      HBox EditBTNBox = new HBox(10, FindStud, FindAnotherStud, EditStud);
      HBox ZipBoz = new HBox(StudZipField,findZip);

      VBox vbox1 = new VBox(10, firstName, LastName, StudAddress, StudCity, State, StudZip);
      vbox1.setAlignment(Pos.CENTER_RIGHT);
      VBox vbox2 = new VBox(firstNameField, LastNameField, StudAddressField, ZipBoz,StudCityField, StateCB );
      HBox hbox = new HBox(vbox1, vbox2);
      hbox.setAlignment(Pos.CENTER);
      VBox fullBox = new VBox(x, titleBox, StudIDBox, hbox, EditBTNBox);
      EditBTNBox.setAlignment(Pos.CENTER);

      vbox1.setVisible(false);
      vbox2.setVisible(false);
      FindAnotherStud.setDisable(true);

      EditStud.setDisable(true);
      findZip.setOnAction(
        new EventHandler<ActionEvent>() {
           @Override
           public void handle(ActionEvent event) {
               try{
                final String Zip = StudZipField.getText();
                zipCodeClient zp = new zipCodeClient(Zip);
                final String studentCity = zp.GetCity();
                final String studentState = zp.GetState();
                StudCityField.setText(studentCity);
                StateCB.setValue(studentState);
               }
               catch(Exception exc){
                  final String Zip = StudZipField.getText();
                  Alert alert = new Alert(Alert.AlertType.ERROR, "Zip "+ Zip + "not found", ButtonType.OK);
                  StudCityField.clear();
                  StateCB.setValue(null);
                  alert.showAndWait();
               }
           }
        });
  
      FindStud.setOnAction(
            new EventHandler<ActionEvent>() {
               @Override
               public void handle(ActionEvent e) {
                  try {
                     final int studentID = Integer.parseInt(StudIDField.getText());
                     Student v = s.GetStudent(studentID);
                     if (v != null) {
                        StudIDField.setEditable(false);
                        EditStud.setDisable(false);
                        vbox1.setVisible(true);
                        vbox2.setVisible(true);

                        firstNameField.setText(v.FirstName);
                        LastNameField.setText(v.LastName);
                        StudAddressField.setText(v.Address);
                        StudCityField.setText(v.City);
                        StateCB.setValue(v.State);
                        StudZipField.setText(v.Zip);
                        FindStud.setDisable(true);
                        FindAnotherStud.setDisable(false);
                     } else {
                        Alert alert = new Alert(Alert.AlertType.ERROR, "Student Not Found", ButtonType.OK);
                        alert.showAndWait();
                     }
                  } catch (EmptyFieldException EFE) {
                     Alert alert = new Alert(Alert.AlertType.ERROR, EFE.getMessage(), ButtonType.OK);
                     alert.showAndWait();
                  } catch (NumberFormatException NFE) {
                     Alert alert = new Alert(Alert.AlertType.ERROR, "ID Field was Left Blank", ButtonType.OK);
                     alert.showAndWait();
                  }
                  catch (Exception exc) {
                     Alert alert = new Alert(Alert.AlertType.ERROR, exc.getMessage(), ButtonType.OK);
                     alert.showAndWait();
                  }
               }
            });
      FindAnotherStud.setOnAction(
            new EventHandler<ActionEvent>() {
               public void handle(ActionEvent e) {
                  StudIDField.clear();
                  firstNameField.clear();
                  LastNameField.clear();
                  StudAddressField.clear();
                  StudCityField.clear();
                  StateCB.setValue(null);
                  StudZipField.clear();
                  FindAnotherStud.setDisable(true);
                  FindStud.setDisable(false);
                  EditStud.setDisable(true);
                  StudIDField.setEditable(true);
               }
            });
      EditStud.setOnAction(
            new EventHandler<ActionEvent>() {
               @Override
               public void handle(ActionEvent e) {
                  final int studentID = Integer.parseInt(StudIDField.getText());
                  final String studentFirstName = firstNameField.getText();
                  final String studentLastName = LastNameField.getText();
                  final String studentAddress = StudAddressField.getText();
                  final String studentCity = StudCityField.getText();
                  String studentState = "";
                  studentState += StateCB.getValue();
                  final String studentZip = StudZipField.getText();
                  try {
                     s.updateStudent(studentID, studentFirstName, studentLastName, studentAddress, studentCity,
                           studentState, studentZip);
                     Alert alert = new Alert(Alert.AlertType.INFORMATION,
                           "Student ID: " + studentID + "\nStudent Name: " + studentFirstName + " " + studentLastName
                                 + "\nAddress: " + studentAddress + "\n\t  " + studentCity + ", " + studentState + " "
                                 + studentZip,
                           ButtonType.OK);
                     alert.setTitle("Student Was Updated");
                     StudIDField.clear();
                     firstNameField.clear();
                     LastNameField.clear();
                     StudAddressField.clear();
                     StudCityField.clear();
                     StateCB.setValue(null);
                     StudZipField.clear();

                     FindStud.setDisable(false);
                     FindAnotherStud.setDisable(true);
                     EditStud.setDisable(true);
                     StudIDField.setEditable(true);
                     alert.showAndWait();
                  } catch (EmptyFieldException EFE) {
                     Alert alert = new Alert(Alert.AlertType.ERROR, EFE.getMessage(), ButtonType.OK);
                     alert.showAndWait();
                  } catch (Exception exc) {
                     Alert alert = new Alert(Alert.AlertType.ERROR, exc.getMessage(), ButtonType.OK);
                     alert.showAndWait();
                  }
               }
            });
      // Create a Scene with the HBox as its root node.
      Scene AddStudentScene = new Scene(fullBox, 400, 270);
      // Add the Scene to the Stage.
      primaryStage.setScene(AddStudentScene);
   }

   static void CreateViewStudentScene(Stage primaryStage) {
      MenuBar x = createMenueBar(primaryStage);
      // Add Student Scen
      Label addStudTitle = new Label("View Student: ");
      Label StudID = new Label("Student ID: ");
      TextField StudIDField = new TextField();
      HBox StudIDBox = new HBox(StudID, StudIDField);
      // StudIDBox.setAlignment(Pos.CENTER);

      Label firstName = new Label();
      Label LastName = new Label();
      Label StudAddress = new Label();
      Label StudCity = new Label();
      Label State = new Label();
      Label StudZip = new Label();

      VBox labelbox = new VBox(firstName, LastName, StudAddress, StudCity, State, StudZip);
      labelbox.setAlignment(Pos.CENTER);
      labelbox.setVisible(false);

      Button FindStud = new Button("Find Student");

      FindStud.setOnAction(
            new EventHandler<ActionEvent>() {
               @Override
               public void handle(ActionEvent e) {
                  try {
                     final int studentID = Integer.parseInt(StudIDField.getText());
                     Student v = s.GetStudent(studentID);
                     if (v != null) {
                        firstName.setText("Student First Name: " + v.FirstName);
                        LastName.setText("Student Last Name: " + v.LastName);
                        StudAddress.setText("Address: " + v.Address);
                        StudCity.setText("City: " + v.City);
                        State.setText("State: " + v.State);
                        StudZip.setText("Zip Code: " + v.Zip);

                        labelbox.setVisible(true);
                        FindStud.setText("Find Another Student");
                     } else {
                        Alert alert = new Alert(Alert.AlertType.ERROR, "Student Not Found", ButtonType.OK);
                        alert.showAndWait();
                     }
                  } catch (EmptyFieldException EFE) {
                     Alert alert = new Alert(Alert.AlertType.ERROR, EFE.getMessage(), ButtonType.OK);
                     alert.showAndWait();
                  } catch (NumberFormatException NFE) {
                     Alert alert = new Alert(Alert.AlertType.ERROR, "ID Field was Left Blank", ButtonType.OK);
                     alert.showAndWait();
                  } catch (Exception exc) {
                     Alert alert = new Alert(Alert.AlertType.ERROR, exc.getMessage(), ButtonType.OK);
                     alert.showAndWait();
                  }
               }
            });

      StudIDBox.setAlignment(Pos.CENTER);
      VBox e = new VBox(x, addStudTitle, StudIDBox, FindStud);
      e.setAlignment(Pos.CENTER);

      VBox AddStudentVBox = new VBox(10, e, labelbox);

      Scene AddStudentScene = new Scene(AddStudentVBox, 400, 270);
      primaryStage.setScene(AddStudentScene);
      primaryStage.show();
   }

   static void CreateAddCourseScene(Stage primaryStage) {
      MenuBar x = createMenueBar(primaryStage);

      Label addCourseTitle = new Label("Add Course: ");// Title
      HBox addCourseBox = new HBox(addCourseTitle);
      addCourseBox.setAlignment(Pos.CENTER_RIGHT);

      Label CourseName = new Label("Course Name: ");
      TextField CourseNameField = new TextField();

      Label CourDescrip = new Label("Course Description: ");
      TextField CourDescripField = new TextField();

      Label CourseDept = new Label("Course Department: ");
      ObservableList<String> DeparmentField = FXCollections.observableArrayList();
      for (int o = 0; o < d.departments.count; o++) {
         DeparmentField.add( d.departments.get(o).Department);
      }
      ComboBox<String> CourseDeptCB = new ComboBox<>(DeparmentField);
      
      Label CourInst = new Label("Course Instructor: ");
      ComboBox<String> CourseInstCB = new ComboBox<>();
      Button addCours = new Button("Add Course");
      addCours.setAlignment(Pos.CENTER);

      VBox vbox1 = new VBox(10, CourseName, CourDescrip, CourseDept, CourInst);
      vbox1.setAlignment(Pos.CENTER_RIGHT);
      VBox vbox2 = new VBox(CourseNameField, CourDescripField, CourseDeptCB, CourseInstCB);
      HBox hbox = new HBox(vbox1, vbox2);
      hbox.setAlignment(Pos.CENTER);
      VBox fullBox = new VBox(x, addCourseTitle, hbox, addCours);

      addCours.setOnAction(
            new EventHandler<ActionEvent>() {
               @Override
               public void handle(ActionEvent event) {
                  final int courseID = c.courses.count + 1;
                  final String courseName = CourseNameField.getText();
                  final String courseDescrip = CourDescripField.getText();
                  final String CourseDept = CourseDeptCB.getValue();
                  final String CourseInst = CourseInstCB.getValue();
                  try {
                     Department selectedDept = d.GetDepartment(CourseDept);
                     final int DepartmentID = selectedDept.ID;
                     int InstructorID = i.GetInstructor(CourseInst).ID;
                      
                     if (!c.AddCourse(courseID, courseName, courseDescrip, DepartmentID, InstructorID)) {
                        Alert alert = new Alert(Alert.AlertType.ERROR, "Course Already Exists ", ButtonType.OK);
                        alert.showAndWait();
                     } else {
                        System.out.print(courseID);
                        Alert alert = new Alert(Alert.AlertType.NONE,
                               "Course ID: " + courseID + "\nCourse Name: " + courseName + "\nCourse Description: "
                                     + courseDescrip + "\nDepartment:" + CourseDept + "\nInstructor: " + CourseInst,
                               ButtonType.OK);
                        alert.setHeaderText("Course Was Added");
                        alert.showAndWait();
                        CourseNameField.clear();
                        CourDescripField.clear();
                       
                        CourseDeptCB.setValue(null);
                        CourseInstCB.setValue(null);
                     }
                  } catch (EmptyFieldException EFE) {
                     Alert alert = new Alert(Alert.AlertType.ERROR, EFE.getMessage(), ButtonType.OK);
                     alert.showAndWait();
                  } catch (Exception exc) {
                     Alert alert = new Alert(Alert.AlertType.ERROR, exc.getMessage(), ButtonType.OK);
                     alert.showAndWait();
                  }
               }
            });
      CourseDeptCB.setOnAction(
            new EventHandler<ActionEvent>() {
               @Override
               public void handle(ActionEvent event) {
                  try {
                     CourseInstCB.setValue(null);
                     String CourseDept = CourseDeptCB.getValue();
                     ObservableList<String> InstList= FXCollections.observableArrayList();
                     if (d.GetDepartment(CourseDept)!= null){
                        int DeptID = d.GetDepartment(CourseDept).ID;
                        InstList = i.GetInstructorByDeparment(DeptID);
                     }
                     CourseInstCB.setItems(InstList);

                  } catch (Exception exc) {
                     Alert alert = new Alert(Alert.AlertType.ERROR, exc.getMessage(), ButtonType.OK);
                     alert.showAndWait();
                  }
               }
            });
      // Create a Scene with the HBox as its root node.
      Scene AddCourseScene = new Scene(fullBox, 400, 270);
      primaryStage.setScene(AddCourseScene);
   }

   static void CreateEditCourseScene(Stage primaryStage) {
      MenuBar x = createMenueBar(primaryStage);

      // Add Student Scen
      Label EditCourTitle = new Label("Edit Course: ");

      Label CourID = new Label("              Course ID: ");
      TextField CourIDField = new TextField();
      HBox CourIDBox = new HBox(CourID, CourIDField);
      CourIDBox.setAlignment(Pos.CENTER);

      Label CourName = new Label("Course Name: ");
      TextField CourNameField = new TextField();

      Label CourDesc = new Label("Course Description: ");
      TextField CourDescField = new TextField();

      Button FindCour = new Button("Find Course");
      Button EditCour = new Button("Edit Course");

      Label CourseDept = new Label("Course Department: ");
      ObservableList<String> DeparmentField = FXCollections.observableArrayList();
       for (int o = 0; o < d.departments.count; o++) {
          DeparmentField.add(d.departments.get(o).Department);
      }
      ComboBox<String> CourseDeptCB = new ComboBox<>(DeparmentField);

      Label CourInst = new Label("Course Instructor: ");
      ComboBox<String> CourseInstCB = new ComboBox<>();
      Button FindAnotherCourse = new Button("Find Another Course");

      HBox EditBTNBox = new HBox(10, FindCour, FindAnotherCourse, EditCour);

      VBox vbox1 = new VBox(10, CourName, CourDesc, CourseDept, CourInst);
      vbox1.setAlignment(Pos.CENTER_RIGHT);
      VBox vbox2 = new VBox(CourNameField, CourDescField, CourseDeptCB, CourseInstCB);
      HBox hbox = new HBox(vbox1, vbox2);
      hbox.setAlignment(Pos.CENTER);
      VBox fullBox = new VBox(x, EditCourTitle, CourIDBox, hbox, EditBTNBox);
      EditBTNBox.setAlignment(Pos.CENTER);

      vbox1.setVisible(false);
      vbox2.setVisible(false);

      EditCour.setDisable(true);

      FindCour.setOnAction(
            new EventHandler<ActionEvent>() {
               @Override
               public void handle(ActionEvent e) {
                  try {
                     final int CourID = Integer.parseInt(CourIDField.getText());
                     Course v = c.GetCourse(CourID);
                     if (v != null) {
                        CourIDField.setEditable(false);
                        EditCour.setDisable(false);
                        vbox1.setVisible(true);
                        vbox2.setVisible(true);

                        CourNameField.setText(v.name);
                        CourDescField.setText(v.description);
                        CourseDeptCB.setValue(d.GetDepartment(v.dept).Department);
                        CourseInstCB.setValue(i.GetInstructor(v.instructor).Name);
                     } else {
                        Alert alert = new Alert(Alert.AlertType.ERROR, "Course Not Found", ButtonType.OK);
                        alert.showAndWait();
                     }
                  } catch (EmptyFieldException EFE) {
                     Alert alert = new Alert(Alert.AlertType.ERROR, EFE.getMessage(), ButtonType.OK);
                     alert.showAndWait();
                  } catch (NumberFormatException NFE) {
                     Alert alert = new Alert(Alert.AlertType.ERROR, "ID Field was Left Blank", ButtonType.OK);
                     alert.showAndWait();
                  } catch (Exception exc) {
                     Alert alert = new Alert(Alert.AlertType.ERROR, exc.getMessage(), ButtonType.OK);
                     alert.showAndWait();
                  }
               }
            });
      FindAnotherCourse.setOnAction(
         new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
               CourNameField.clear();
               CourDescField.clear();
               CourIDField.setEditable(true);  
               CourseDeptCB.setValue(null);
               CourseInstCB.setValue(null);
               FindAnotherCourse.setDisable(true);
               FindCour.setDisable(false);
               EditCour.setDisable(true);
               CourIDField.setEditable(true);
            }
         }
      );
      EditCour.setOnAction(
            new EventHandler<ActionEvent>() {
               @Override
               public void handle(ActionEvent e) {
                  final int CourID = Integer.parseInt(CourIDField.getText());
                  final String CoursName = CourNameField.getText();
                  final String CourseDescrip = CourDescField.getText();
                  final String CourseDept = CourseDeptCB.getValue();
                  final String CourseInstructor = CourseInstCB.getValue();
                  try {
                     int DeptID = d.GetDepartment(CourseDept).ID;
                     int InstID = i.GetInstructor(CourseInstructor).ID;
                     c.updateCourse(CourID, CoursName, CourseDescrip, DeptID, InstID);
                     Alert alert = new Alert(Alert.AlertType.NONE,
                           "Course ID: " + CourID + "\nCourse Name: " + CoursName + "\nCourse Description: "
                                 + CourseDescrip + "\nCourse Department:" + CourseDept + "\nCourse Instructor:"
                                 + CourseInstructor,
                           ButtonType.OK);
                     alert.setHeaderText("Course Was Updated");
                     alert.showAndWait();
                     CourNameField.clear();
                     CourDescField.clear();
                     CourIDField.setEditable(true);
                       
                        CourseDeptCB.setValue(null);
                        CourseInstCB.setValue(null);
                  } catch (EmptyFieldException EFE) {
                     Alert alert = new Alert(Alert.AlertType.ERROR, EFE.getMessage(), ButtonType.OK);
                     alert.showAndWait();
                  } catch (NumberFormatException NFE) {
                     Alert alert = new Alert(Alert.AlertType.ERROR, "ID Field was Left Blank", ButtonType.OK);
                     alert.showAndWait();
                  } catch (Exception exc) {
                     Alert alert = new Alert(Alert.AlertType.ERROR, exc.getMessage(), ButtonType.OK);
                     alert.showAndWait();
                  }
               }
            });
       CourseDeptCB.setOnAction(
             new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                   try {
                     CourseInstCB.setValue(null);
                     String CourseDept = CourseDeptCB.getValue();
                     ObservableList<String> InstList= FXCollections.observableArrayList();
                     if (d.GetDepartment(CourseDept)!= null){
                        int DeptID = d.GetDepartment(CourseDept).ID;
                        InstList = i.GetInstructorByDeparment(DeptID);
                     }
                     CourseInstCB.setItems(InstList);
                   } catch (Exception exc) {
                      Alert alert = new Alert(Alert.AlertType.ERROR, "Error in CB selection" + exc.getMessage(), ButtonType.OK);
                      alert.showAndWait();
                   }
                }
             });
      Scene AddStudentScene = new Scene(fullBox, 400, 270);
      // Add the Scene to the Stage.
      primaryStage.setScene(AddStudentScene);
   }

   static void CreateViewCoursScene(Stage primaryStage) {
      MenuBar x = createMenueBar(primaryStage);
      Label addCourseTitle = new Label("View Course: ");
      Label CourseIDLb = new Label("Course ID: ");
      TextField CourseIDField = new TextField();
      HBox CourseIDBox = new HBox(CourseIDLb, CourseIDField);

      Label CourseID = new Label();
      Label CourseName = new Label();
      Label CourseDescr = new Label();
      Label CourseDept = new Label();
      Label CouseInst = new Label();
      VBox labelbox = new VBox(CourseID, CourseName, CourseDescr, CourseDept, CouseInst);
      labelbox.setVisible(false);

      Button FindCourse = new Button("Find Course");
      FindCourse.setOnAction(
            new EventHandler<ActionEvent>() {
               @Override
               public void handle(ActionEvent event) {
                  try {
                     final int CourseIDS = Integer.parseInt(CourseIDField.getText());
                     Course v = c.GetCourse(CourseIDS);
                     if (v != null) {
                        CourseID.setText("Course ID " + v.courseID);
                        CourseName.setText("Course Name: " + v.name);
                        CourseDescr.setText("Course Description: " + v.description);
                        CourseDept.setText("Course Department: " + d.GetDepartment(v.dept).Department);
                        CouseInst.setText("Course Instructor: " + i.GetInstructor(v.instructor).Name);

                        labelbox.setVisible(true);
                        FindCourse.setText("Find Another Course");
                     } else {
                        Alert alert = new Alert(Alert.AlertType.ERROR, "Course Not Found", ButtonType.OK);
                        alert.showAndWait();
                     }
                  } catch (EmptyFieldException EFE) {
                     Alert alert = new Alert(Alert.AlertType.ERROR, EFE.getMessage(), ButtonType.OK);
                     alert.showAndWait();
                  } catch (NumberFormatException NFE) {
                     Alert alert = new Alert(Alert.AlertType.ERROR, "ID Field was Left Blank", ButtonType.OK);
                     alert.showAndWait();
                  } catch (Exception exc) {
                     Alert alert = new Alert(Alert.AlertType.ERROR, exc.getMessage(), ButtonType.OK);
                     alert.showAndWait();
                  }
               }
            });
      CourseIDBox.setAlignment(Pos.CENTER);
      VBox g = new VBox(10, x, addCourseTitle, CourseIDBox, FindCourse);
      g.setAlignment(Pos.CENTER);

      labelbox.setAlignment(Pos.CENTER);
      VBox ViewCourseVBox = new VBox(10, g, labelbox);

      Scene ViewCourseScene = new Scene(ViewCourseVBox, 400, 270);
      primaryStage.setScene(ViewCourseScene);
      primaryStage.show();
   }

   static void CreateAddDepartmentScene(Stage primaryStage) {
      MenuBar x = createMenueBar(primaryStage);

      Label addDepartTitle = new Label("Add Department: ");// Title
      HBox addDepartBox = new HBox(addDepartTitle);
      addDepartBox.setAlignment(Pos.CENTER_RIGHT);

      Label DepartmentName = new Label("Deparment Name: ");
      TextField DeparmentNameField = new TextField();

      Button addDepart = new Button("Add Deparment");
      addDepart.setAlignment(Pos.CENTER_RIGHT);

      VBox vbox1 = new VBox(10, DepartmentName);
      vbox1.setAlignment(Pos.CENTER_RIGHT);
      VBox vbox2 = new VBox(DeparmentNameField);
      HBox hbox = new HBox(vbox1, vbox2);
      hbox.setAlignment(Pos.CENTER);
      VBox fullBox = new VBox(x, addDepartTitle, hbox, addDepart);

      addDepart.setOnAction(
            new EventHandler<ActionEvent>() {
               @Override
               public void handle(ActionEvent event) {
                  final int DepartID = d.departments.count + 1;
                  final String DepartmentName = DeparmentNameField.getText();
                  try {
                     if (!d.addDepartment(DepartID, DepartmentName)) {
                        Alert alert = new Alert(Alert.AlertType.ERROR, "Deparment Already Exists ", ButtonType.OK);
                        alert.showAndWait();
                     } else {
                        Alert alert = new Alert(Alert.AlertType.NONE,
                              "Department ID: " + DepartID + "\nDepartment Name: " + DepartmentName, ButtonType.OK);
                        alert.setHeaderText("Deparment Was Added");
                        alert.showAndWait();
                        DeparmentNameField.clear();
                     }
                  } catch (EmptyFieldException EFE) {
                     Alert alert = new Alert(Alert.AlertType.ERROR, EFE.getMessage(), ButtonType.OK);
                     alert.showAndWait();
                  } catch (Exception exc) {
                     Alert alert = new Alert(Alert.AlertType.ERROR, exc.getMessage(), ButtonType.OK);
                     alert.showAndWait();
                  }
               }
            });
      // Create a Scene with the HBox as its root node.
      Scene AddDepartScene = new Scene(fullBox, 400, 270);
      primaryStage.setScene(AddDepartScene);
   }

   static void CreateEditDepartmentScene(Stage primaryStage) {
      MenuBar x = createMenueBar(primaryStage);

      // Add Student Scen
      Label EditDepartTitle = new Label("Edit Department: ");

      Label DepartID = new Label("              Department ID: ");
      TextField DepartIDField = new TextField();
      HBox DepartIDBox = new HBox(DepartID, DepartIDField);
      DepartIDBox.setAlignment(Pos.CENTER);

      Label DepartName = new Label("Depart Name: ");
      TextField DepartNameField = new TextField();

      Button FindDepart = new Button("Find Depart");
      Button EditDepart = new Button("Edit Depart");
      Button FindAnotherDept = new Button("Find Another Department");
      HBox EditBTNBox = new HBox(10, FindDepart, FindAnotherDept, EditDepart);
      

      VBox vbox1 = new VBox(10, DepartName);
      vbox1.setAlignment(Pos.CENTER_RIGHT);
      VBox vbox2 = new VBox(DepartNameField);
      HBox hbox = new HBox(vbox1, vbox2);
      hbox.setAlignment(Pos.CENTER);
      VBox fullBox = new VBox(x, EditDepartTitle, DepartIDBox, hbox, EditBTNBox);
      EditBTNBox.setAlignment(Pos.CENTER);

      vbox1.setVisible(false);
      vbox2.setVisible(false);

      EditDepart.setDisable(true);

      FindDepart.setOnAction(
            new EventHandler<ActionEvent>() {
               @Override
               public void handle(ActionEvent e) {
                  try {
                     final int DepartID = Integer.parseInt(DepartIDField.getText());
                     Department v = d.GetDepartment(DepartID);
                     if (v != null) {
                        DepartIDField.setEditable(false);
                        EditDepart.setDisable(false);
                        vbox1.setVisible(true);
                        vbox2.setVisible(true);

                        DepartNameField.setText(v.Department);
                     } else {
                        Alert alert = new Alert(Alert.AlertType.ERROR, "Department Not Found", ButtonType.OK);
                        alert.showAndWait();
                     }
                  } catch (EmptyFieldException EFE) {
                     Alert alert = new Alert(Alert.AlertType.ERROR, EFE.getMessage(), ButtonType.OK);
                     alert.showAndWait();
                  } catch (NumberFormatException NFE) {
                     Alert alert = new Alert(Alert.AlertType.ERROR, "ID Field was Left Blank", ButtonType.OK);
                     alert.showAndWait();
                  } catch (Exception exc) {
                     Alert alert = new Alert(Alert.AlertType.ERROR, exc.getMessage(), ButtonType.OK);
                     alert.showAndWait();
                  }
               }
            });
            FindAnotherDept.setOnAction(
               new EventHandler<ActionEvent>() {
                  public void handle(ActionEvent e) {
                     DepartNameField.clear();
                     DepartIDField.clear();
                     DepartIDField.setEditable(true);
                     FindDepart.setDisable(false);
                     EditDepart.setDisable(true);
                  
                  }
               }
            );
      EditDepart.setOnAction(
            new EventHandler<ActionEvent>() {
               @Override
               public void handle(ActionEvent e) {
                  try {
                     final int DepartID = Integer.parseInt(DepartIDField.getText());
                     final String DepartName = DepartNameField.getText();
                     d.updateDepartment(DepartID, DepartName);
                     DepartNameField.clear();
                     DepartIDField.clear();
                     DepartIDField.setEditable(true);
                     FindDepart.setDisable(false);
                     EditDepart.setDisable(true);
                     Alert alert = new Alert(Alert.AlertType.NONE,
                           "Department ID: " + DepartID + "\nDepartment Name: " + DepartName, ButtonType.OK);
                     alert.setHeaderText("Department Was Updated");
                     alert.showAndWait();
                  } catch (EmptyFieldException EFE) {
                     Alert alert = new Alert(Alert.AlertType.ERROR, EFE.getMessage(), ButtonType.OK);
                     alert.showAndWait();
                  } catch (NumberFormatException NFE) {
                     Alert alert = new Alert(Alert.AlertType.ERROR, "ID Field was Left Blank", ButtonType.OK);
                     alert.showAndWait();
                  } catch (Exception exc) {
                     Alert alert = new Alert(Alert.AlertType.ERROR, exc.getMessage(), ButtonType.OK);
                     alert.showAndWait();
                  }
               }
            });
      Scene editDepartScene = new Scene(fullBox, 400, 270);
      // Add the Scene to the Stage.
      primaryStage.setScene(editDepartScene);
   }

   static void CreateViewDepartmentScene(Stage primaryStage) {
      MenuBar x = createMenueBar(primaryStage);
      Label addDepartTitle = new Label("View Dep: ");
      Label DepartIDLb = new Label("Depart ID: ");
      TextField DepartIDField = new TextField();
      HBox DepartIDBox = new HBox(DepartIDLb, DepartIDField);

      Label DepartID = new Label();
      Label DepartName = new Label();

      VBox labelbox = new VBox(DepartID, DepartName);
      labelbox.setVisible(false);

      Button FindDepart = new Button("Find Department");
      FindDepart.setOnAction(
            new EventHandler<ActionEvent>() {
               @Override
               public void handle(ActionEvent event) {
                  try {
                     final int ID = Integer.parseInt(DepartIDField.getText());
                     Department v = d.GetDepartment(ID);
                     if (v != null) {
                        DepartID.setText("Department ID " + v.ID);
                        DepartName.setText("Department Name: " + v.Department);

                        labelbox.setVisible(true);
                        FindDepart.setText("Find Another Department");
                     } else {
                        Alert alert = new Alert(Alert.AlertType.ERROR, "Course Not Found", ButtonType.OK);
                        alert.showAndWait();
                     }
                  } catch (EmptyFieldException EFE) {
                     Alert alert = new Alert(Alert.AlertType.ERROR, EFE.getMessage(), ButtonType.OK);
                     alert.showAndWait();
                  } catch (NumberFormatException NFE) {
                     Alert alert = new Alert(Alert.AlertType.ERROR, "ID Field was Left Blank", ButtonType.OK);
                     alert.showAndWait();
                  } catch (Exception exc) {
                     Alert alert = new Alert(Alert.AlertType.ERROR, exc.getMessage(), ButtonType.OK);
                     alert.showAndWait();
                  }
               }
            });
      DepartIDBox.setAlignment(Pos.CENTER);
      VBox g = new VBox(10, x, addDepartTitle, DepartIDBox, FindDepart);
      g.setAlignment(Pos.CENTER);

      labelbox.setAlignment(Pos.CENTER);
      VBox ViewDepartmentVBox = new VBox(10, g, labelbox);

      Scene ViewDepartmentScene = new Scene(ViewDepartmentVBox, 400, 270);
      primaryStage.setScene(ViewDepartmentScene);
      primaryStage.show();
   }

   static void CreateEditInstructorScene(Stage primaryStage) {
      MenuBar x = createMenueBar(primaryStage);

      Label editInstructTitle = new Label("Edit Instruct: ");// Title
      HBox editInstructBox = new HBox(editInstructTitle);
      editInstructBox.setAlignment(Pos.CENTER_RIGHT);
      Label InstructID = new Label("              Instructor ID: ");
      TextField InstructIDField = new TextField();
      HBox InstructIDBox = new HBox(InstructID, InstructIDField);
      InstructIDBox.setAlignment(Pos.CENTER);

      Label InstructName = new Label("Instruct Name: ");
      TextField InstructNameField = new TextField();
      Label DepartmentLB = new Label("Deparment: ");
      ObservableList<String> DeparmentField = FXCollections.observableArrayList();
      for (int o = 0; o < d.departments.count; o++) {
         DeparmentField.add(d.departments.get(o).Department);
      }
      ComboBox<String> DeptCB = new ComboBox<>(DeparmentField);
      Button FindInstructor = new Button("Find Instructor");
      Button editInstruct = new Button("Edit Instruct");
      Button FindAnotherInstructor = new Button("Find Another Instructor");
      editInstruct.setAlignment(Pos.CENTER_RIGHT);

      VBox vbox1 = new VBox(10, InstructName, DepartmentLB);
      vbox1.setAlignment(Pos.CENTER_RIGHT);
      VBox vbox2 = new VBox(InstructNameField,FindAnotherInstructor,DeptCB);
      HBox hbox = new HBox(vbox1, vbox2);
      hbox.setAlignment(Pos.CENTER);
      HBox BtnBox = new HBox(editInstruct, FindInstructor);
      VBox fullBox = new VBox(x, editInstructTitle, InstructIDBox, hbox, BtnBox);
      vbox1.setVisible(false);
      vbox2.setVisible(false);

      FindInstructor.setOnAction(
            new EventHandler<ActionEvent>() {
               @Override
               public void handle(ActionEvent e) {
                  try {
                     final int ID = Integer.parseInt(InstructIDField.getText());
                     Instructor v = i.GetInstructor(ID);
                     if (v != null) {
                        InstructIDField.setEditable(false);
                        editInstruct.setDisable(false);
                        vbox1.setVisible(true);
                        vbox2.setVisible(true);
                        InstructNameField.setText(v.Name);
                        DeptCB.setValue(d.GetDepartment(v.DeptID).Department);
                     } else {
                        Alert alert = new Alert(Alert.AlertType.ERROR, "Instructor Not Found", ButtonType.OK);
                        alert.showAndWait();
                     }
                  } catch (EmptyFieldException EFE) {
                     Alert alert = new Alert(Alert.AlertType.ERROR, EFE.getMessage(), ButtonType.OK);
                     alert.showAndWait();
                  } catch (NumberFormatException NFE) {
                     Alert alert = new Alert(Alert.AlertType.ERROR, "ID Field was Left Blank", ButtonType.OK);
                     alert.showAndWait();
                  } catch (Exception exc) {
                     Alert alert = new Alert(Alert.AlertType.ERROR, exc.getMessage(), ButtonType.OK);
                     alert.showAndWait();
                  }
               }
            });
      FindAnotherInstructor.setOnAction(
         new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
               InstructIDField.clear();
               InstructNameField.clear();
               DeptCB.setValue(null);
               InstructIDField.setEditable(true);
               FindInstructor.setDisable(false);
               editInstruct.setDisable(true);
            
            }
         }
      );
      editInstruct.setOnAction(
            new EventHandler<ActionEvent>() {
               @Override
               public void handle(ActionEvent e) {
                  try {
                     
                     final int ID = Integer.parseInt(InstructIDField.getText());
                     final String Name = InstructNameField.getText();
                     final String Department = DeptCB.getValue();
                     final int DeparmentID = d.GetDepartment(Department).ID;
                     i.updateInstructor(ID, Name, DeparmentID);
                     Alert alert = new Alert(Alert.AlertType.NONE,
                           " ID: " + ID + "\n Name: " + Name + "\nDepartment: " + d.GetDepartment(DeparmentID), ButtonType.OK);
                     alert.setHeaderText("Instructor Was Updated");
                     InstructIDField.clear();
                     InstructNameField.clear();
                     DeptCB.setValue(null);
   
                     alert.showAndWait();
                  } catch (EmptyFieldException EFE) {
                     Alert alert = new Alert(Alert.AlertType.ERROR, EFE.getMessage(), ButtonType.OK);
                     alert.showAndWait();
                  } catch (NumberFormatException NFE) {
                     Alert alert = new Alert(Alert.AlertType.ERROR, "ID Field was Left Blank in edit inst", ButtonType.OK);
                     alert.showAndWait();
                  } catch (Exception exc) {
                     Alert alert = new Alert(Alert.AlertType.ERROR, exc.getMessage(), ButtonType.OK);
                     alert.showAndWait();
                  }
               }
            });
      // Create a Scene with the HBox as its root node.
      Scene editDepartScene = new Scene(fullBox, 400, 270);
      primaryStage.setScene(editDepartScene);
   }

   static void CreateAddInstructorScene(Stage primaryStage) {
      MenuBar x = createMenueBar(primaryStage);

      Label addInstructTitle = new Label("Add Instruct: ");// Title
      HBox addInstructBox = new HBox(addInstructTitle);
      addInstructBox.setAlignment(Pos.CENTER_RIGHT);

      Label InstructName = new Label("Instruct Name: ");
      TextField InstructNameField = new TextField();
      Label DepartmentLB = new Label("Deparment: ");
      ObservableList<String> DeparmentField = FXCollections.observableArrayList();
      for (int o = 0; o < d.departments.count; o++) {
         DeparmentField.add(d.departments.get(o).Department);
      }
      ComboBox<String> DeptCB = new ComboBox<>(DeparmentField);

      Button addInstruct = new Button("Add Instruct");
      addInstruct.setAlignment(Pos.CENTER);

      VBox vbox1 = new VBox(10, InstructName, DepartmentLB);
      vbox1.setAlignment(Pos.CENTER_RIGHT);
      VBox vbox2 = new VBox(InstructNameField, DeptCB);
      HBox hbox = new HBox(vbox1, vbox2);
      hbox.setAlignment(Pos.CENTER);
      VBox fullBox = new VBox(x, addInstructTitle, hbox, addInstruct);

      addInstruct.setOnAction(
            new EventHandler<ActionEvent>() {
               @Override
               public void handle(ActionEvent event) {
                  final int InstructID = i.instructors.count + 1;
                  final String InstructName = InstructNameField.getText();
                  final String Deparment = DeptCB.getValue();
                  
                  try {
                     final int deptID = d.GetDepartment(Deparment).ID;
                     if (!i.AddInstructor(InstructID, InstructName, deptID)) {
                        Alert alert = new Alert(Alert.AlertType.ERROR, "Deparment Already Exists ", ButtonType.OK);
                        alert.showAndWait();
                     } else {
                        Alert alert = new Alert(Alert.AlertType.NONE, "Department ID: " + InstructID
                              + "\nDepartment Name: " + InstructName + "\nDeparment: " + d.GetDepartment(Deparment), ButtonType.OK);
                        alert.setHeaderText("Deparment Was Added");
                        InstructNameField.clear();
                        DeptCB.setValue(null);
                        alert.showAndWait();
                     }
                  } catch (EmptyFieldException EFE) {
                     Alert alert = new Alert(Alert.AlertType.ERROR, EFE.getMessage(), ButtonType.OK);
                     alert.showAndWait();
                  } catch (Exception exc) {
                     Alert alert = new Alert(Alert.AlertType.ERROR, exc.getMessage(), ButtonType.OK);
                     alert.showAndWait();
                  }
               }
            });
      // Create a Scene with the HBox as its root node.
      Scene AddDepartScene = new Scene(fullBox, 400, 270);
      primaryStage.setScene(AddDepartScene);
   }

   static void CreateViewInstructorScene(Stage primaryStage) {
      MenuBar x = createMenueBar(primaryStage);
      Label addDepartTitle = new Label("View Instructor: ");
      Label DepartIDLb = new Label("Instructor ID: ");
      TextField DepartIDField = new TextField();
      HBox DepartIDBox = new HBox(DepartIDLb, DepartIDField);

      Label DepartID = new Label();
      Label DepartName = new Label();
      Label Depar = new Label();

      VBox labelbox = new VBox(DepartID, DepartName, Depar);
      labelbox.setVisible(false);

      Button FindDepart = new Button("Find Instructor");
      FindDepart.setOnAction(
            new EventHandler<ActionEvent>() {
               @Override
               public void handle(ActionEvent event) {
                  try {
                     final int ID = Integer.parseInt(DepartIDField.getText());
                     Instructor v = i.GetInstructor(ID);
                     if (v != null) {
                        DepartID.setText("Instructor ID " + v.ID);
                        DepartName.setText("Instructor Name: " + v.Name);
                        Depar.setText("Deparment: " + d.GetDepartment(v.DeptID).Department);

                        labelbox.setVisible(true);
                        FindDepart.setText("Find Another Instructor");
                     } else {
                        Alert alert = new Alert(Alert.AlertType.ERROR, "Instructor Not Found", ButtonType.OK);
                        alert.showAndWait();
                     }
                  } catch (EmptyFieldException EFE) {
                     Alert alert = new Alert(Alert.AlertType.ERROR, EFE.getMessage(), ButtonType.OK);
                     alert.showAndWait();
                  } catch (NumberFormatException NFE) {
                     Alert alert = new Alert(Alert.AlertType.ERROR, "ID Field was Left Blank", ButtonType.OK);
                     alert.showAndWait();
                  } catch (Exception exc) {
                     Alert alert = new Alert(Alert.AlertType.ERROR, exc.getMessage(), ButtonType.OK);
                     alert.showAndWait();
                  }
               }
            });
      DepartIDBox.setAlignment(Pos.CENTER);
      VBox g = new VBox(10, x, addDepartTitle, DepartIDBox, FindDepart);
      g.setAlignment(Pos.CENTER);

      labelbox.setAlignment(Pos.CENTER);
      VBox ViewDepartmentVBox = new VBox(10, g, labelbox);

      Scene ViewDepartmentScene = new Scene(ViewDepartmentVBox, 400, 270);
      primaryStage.setScene(ViewDepartmentScene);
      primaryStage.show();
   }

   static void CreateAddEnrollmentScene(Stage primaryStage) {
      MenuBar x = createMenueBar(primaryStage);

      // Build Add Student Scene
      Label addEnrollTitle = new Label("Add Enrollment: ");
      addEnrollTitle.setAlignment(Pos.CENTER_RIGHT);

      // Student First Name Box
      Label CourseID = new Label("Course ID: ");
      TextField CourseIDField = new TextField();
      Button FindCourseBTN = new Button("Find Course");
      Label CourseNamelb = new Label("Course Name");
      TextField CourseName = new TextField();
      CourseName.setEditable(false);
      HBox CourseBox = new HBox(CourseIDField,FindCourseBTN);

      // Student Last Name Box
      Label StudID = new Label("Student ID: ");
      TextField StudIDField = new TextField();
      Button FindStudent = new Button("Find Student");
      Label StudentNameLB = new Label("Student Name");
      TextField StudentNameTF = new TextField();
      StudentNameTF.setEditable(false);
      HBox StudentBox = new HBox(StudIDField,FindStudent);

      // Student Address Box
      Label Year = new Label("Year: ");
      TextField YearField = new TextField();
      // Studen City Box
      Label Semester = new Label("Semester: ");
      ComboBox<String> SemesterCB = new ComboBox<>();
      SemesterCB.getItems().addAll("Spring", "Summer", "Fall", "Winter");
      // Student State Box
      Label Grades = new Label("Grade: ");
      ComboBox<Character> GradesCB = new ComboBox<>();
      GradesCB.getItems().addAll('A', 'B', 'C', 'D', 'F', 'P', 'N', 'W');
      // Student Zip Box

      Button addEnrollBTN = new Button("Add Enrollment");

      VBox vbox1 = new VBox(10, CourseID,CourseNamelb, StudID,StudentNameLB, Year, Semester, Grades);
      vbox1.setAlignment(Pos.CENTER_RIGHT);
      VBox vbox2 = new VBox(CourseBox,CourseName, StudentBox, StudentNameTF, YearField, SemesterCB, GradesCB);
      HBox hbox = new HBox(vbox1, vbox2);
      hbox.setAlignment(Pos.CENTER);
      VBox fullBox = new VBox(x, addEnrollTitle, hbox, addEnrollBTN);
      // Event Handler for Add Student Button
      addEnrollBTN.setOnAction(
            new EventHandler<ActionEvent>() {
               @Override
               public void handle(ActionEvent event) {
                  // Get Text from Fields

                  try {
                     final int EnrollmentID = e.enrollments.count + 1;
                     final int CourseID = Integer.parseInt(CourseIDField.getText());
                     final int StudentID = Integer.parseInt(StudIDField.getText());
                     final String Year = YearField.getText();
                     final String Semester = SemesterCB.getValue();
                     char Grade =  GradesCB.getValue();
                     if (GradesCB.getValue() == null) {
                        Alert alert = new Alert(Alert.AlertType.ERROR, "Select a Grade ", ButtonType.OK);
                        alert.showAndWait();
                     } else
                        Grade = GradesCB.getValue();
                        Boolean add = e.addEnrollment(EnrollmentID, CourseID, StudentID, Year, Semester, Grade);
                        if (!add) {
                           Alert alert = new Alert(Alert.AlertType.ERROR, "Enrollment Already Exists ", ButtonType.OK);
                           alert.showAndWait();
                        } else {
                           Alert alert = new Alert(Alert.AlertType.NONE,
                                 "Enrollment ID: " + EnrollmentID + "\nCourse ID: " + CourseID+" "+c.GetCourse(CourseID).name +  "\nStudent ID: "
                                       + StudentID+ " "+s.GetStudent(StudentID).FirstName + " " + s.GetStudent(StudentID).LastName +"\nSemester: " + Semester + " " + Year + "\nGrade: " + Grade,
                                 ButtonType.OK);
                                 
                           alert.setHeaderText("Enrollment Was Added");
                           alert.showAndWait();
                        }
                  } catch (EmptyFieldException EFE) {
                     Alert alert = new Alert(Alert.AlertType.ERROR, EFE.getMessage(), ButtonType.OK);
                     alert.showAndWait();
                  } catch (NumberFormatException NFE) {
                     Alert alert = new Alert(Alert.AlertType.ERROR, "One or more ID Field was Left Blank",
                           ButtonType.OK);
                     alert.showAndWait();
                  } catch (Exception exc) {
                     Alert alert = new Alert(Alert.AlertType.ERROR, exc.getMessage(), ButtonType.OK);
                     alert.showAndWait();
                  }

               }
            });
      FindCourseBTN.setOnAction(
         new EventHandler<ActionEvent>() {
            @Override
               public void handle(ActionEvent event) {
                  try{
                     final int CourseId = Integer.parseInt(CourseIDField.getText());
                     Course found = c.GetCourse(CourseId);
                     if (found != null ){
                        CourseName.setText(found.name);
                     }
                     else{
                        Alert alert = new Alert(Alert.AlertType.ERROR,"Course not Found",ButtonType.OK);
                     alert.showAndWait();
                     CourseIDField.clear();
                     }
                  }
                  catch(EmptyFieldException EFE){
                     Alert alert = new Alert(Alert.AlertType.ERROR, "One or more ID Field was Left Blank",
                     ButtonType.OK);
                     alert.showAndWait();
                  }
                  catch(Exception EE){
                     Alert alert = new Alert(Alert.AlertType.ERROR, EE.getMessage(),
                     ButtonType.OK);
                     alert.showAndWait();
                  }

               }
         }
      );
      FindStudent.setOnAction(
         new EventHandler<ActionEvent>() {
            @Override
               public void handle(ActionEvent event) {
                  try{
                     final int Studentid = Integer.parseInt(StudIDField.getText()); 
                     
                     Student found = s.GetStudent(Studentid);
                     if(found != null){
                        System.out.println(Studentid + "." +found.FirstName + " "+found.LastName);
                        StudentNameTF.setText(found.FirstName + " "  + found.LastName);
                     }
                     else{
                        Alert alert = new Alert(Alert.AlertType.ERROR, "Student not Found", ButtonType.OK);
                        alert.showAndWait();
                        StudIDField.clear();
                     }
                  }
                  catch(Exception EE){
                     Alert alert = new Alert(Alert.AlertType.ERROR, EE.getMessage(),
                     ButtonType.OK);
                     alert.showAndWait();
                  }

                  
               }
         }
      );
            // Create a Scene with the HBox as its root node.
      Scene AddEnrollScene = new Scene(fullBox, 400, 270);
      primaryStage.setScene(AddEnrollScene);
   }

   static void CreateEditEnrollmentcene(Stage primaryStage) {
      MenuBar x = createMenueBar(primaryStage);
      Label EditEnrollTitle = new Label("Edit Enrollment: ");
      HBox titleBox = new HBox(EditEnrollTitle);

      Label ErollID = new Label("Enrollment ID: ");
      TextField EnrollIDField = new TextField();
      HBox ErollIDBox = new HBox(ErollID, EnrollIDField);
      ErollIDBox.setAlignment(Pos. CENTER);

      Label CourseID = new Label("Course ID: ");
      TextField CourseIDField = new TextField();
      Button FindCourseBTN = new Button("Find Course");
      Label CourseNamelb = new Label("Course Name");
      TextField CourseName = new TextField();
      CourseName.setEditable(false);
      HBox CourseBox = new HBox(CourseIDField,FindCourseBTN);

      // Student Last Name Box
      Label StudID = new Label("Student ID: ");
      TextField StudIDField = new TextField();
      Button FindStudent = new Button("Find Student");
      Label StudentNameLB = new Label("Student Name");
      TextField StudentNameTF = new TextField();
      StudentNameTF.setEditable(false);
      HBox StudentBox = new HBox(StudIDField,FindStudent);

      Label Year = new Label("Year: ");
      TextField YearField = new TextField();

      Label Semester = new Label("Semester: ");
      ComboBox<String> SemesterCB = new ComboBox<>();
      SemesterCB.getItems().addAll("Spring", "Summer", "Fall", "Winter");

      Label Grades = new Label("Grade: ");
      ComboBox<Character> GradesCB = new ComboBox<>();
      GradesCB.getItems().addAll('A', 'B', 'C', 'D', 'F', 'P', 'N', 'W');
      Button FindEnrollBTN = new Button("Find Enrollment");
      Button EditEnrollBTN = new Button("Edit Enrollment");
      Button FindAnotherEnrollment = new Button("Find Another Enrollment");
      HBox EditBTNBox = new HBox(10, FindEnrollBTN,FindAnotherEnrollment, EditEnrollBTN);

      VBox vbox1 = new VBox(10, CourseID, CourseNamelb, StudID,StudentNameLB, Year, Semester, Grades);
      vbox1.setAlignment(Pos.CENTER_RIGHT);
      VBox vbox2 = new VBox(CourseBox,CourseName, StudentBox, StudentNameTF, YearField, SemesterCB, GradesCB);
      HBox hbox = new HBox(vbox1, vbox2);
      hbox.setAlignment(Pos.CENTER);
      VBox fullBox = new VBox(x, titleBox, ErollIDBox, hbox, EditBTNBox);
      EditBTNBox.setAlignment(Pos.CENTER);

      vbox1.setVisible(false);
      vbox2.setVisible(false);

      EditEnrollBTN.setDisable(true);

      FindEnrollBTN.setOnAction(
            new EventHandler<ActionEvent>() {
               @Override
               public void handle(ActionEvent event) {
                  try {
                     final int EnrollmentID = Integer.parseInt(EnrollIDField.getText());
                     Enrollment v = e.GetEnrollment(EnrollmentID);
                     if (v != null) {
                        EnrollIDField.setEditable(false);
                        EditEnrollBTN.setDisable(true);
                        vbox1.setVisible(true);
                        vbox2.setVisible(true);

                        CourseIDField.setText(String.valueOf(v.CID));
                        CourseName.setText(c.GetCourse(v.CID).name);
                        StudIDField.setText(String.valueOf(v.SID));
                        StudentNameTF.setText(s.GetStudent(v.SID).FirstName + " "+s.GetStudent(v.SID).LastName);
                        YearField.setText(v.year);
                        SemesterCB.setValue(v.semester);
                        GradesCB.setValue(v.grade);
                        EditEnrollBTN.setDisable(false);
                     } else {
                        Alert alert = new Alert(Alert.AlertType.ERROR, "Enrollment Not Found", ButtonType.OK);
                        alert.showAndWait();
                     }
                  } catch (EmptyFieldException EFE) {
                     Alert alert = new Alert(Alert.AlertType.ERROR, EFE.getMessage(), ButtonType.OK);
                     alert.showAndWait();
                  } catch (NumberFormatException NFE) {
                     Alert alert = new Alert(Alert.AlertType.ERROR, "ID Field was Left Blank", ButtonType.OK);
                     alert.showAndWait();
                  } catch (Exception exc) {
                     Alert alert = new Alert(Alert.AlertType.ERROR, exc.getMessage(), ButtonType.OK);
                     alert.showAndWait();
                  }
               }
            });
            FindAnotherEnrollment.setOnAction(
               new EventHandler<ActionEvent>() {
                  public void handle(ActionEvent e) {
                     CourseIDField.clear();
                     StudIDField.clear();
                     YearField.clear();
                     SemesterCB.setValue(null);
                     GradesCB.setValue(null);
                     EnrollIDField.clear();
                     EnrollIDField.setEditable(true);
                     EditEnrollBTN.setDisable(true);
                  }
               }
            );
      EditEnrollBTN.setOnAction(
            new EventHandler<ActionEvent>() {
               @Override
               public void handle(ActionEvent event) {
                  try {
                     final int EnrollmenID = Integer.parseInt(EnrollIDField.getText());
                     final int CourseID = Integer.parseInt(CourseIDField.getText());
                     final int StudentID = Integer.parseInt(StudIDField.getText());
                     final String Year = YearField.getText();
                     final String Semester = SemesterCB.getValue();
                     final char Grade = GradesCB.getValue();

                     if (e.updateEnrollment(EnrollmenID, CourseID, StudentID, Year, Semester, Grade)) {
                        Alert alert = new Alert(Alert.AlertType.NONE,
                              "Enrollment ID: " + EnrollmenID + "\nCourse ID: " + CourseID + "\nStudent ID: "
                                    + StudentID + "\nSemester: " + Semester + " " + Year + "\nGrade: " + Grade,
                              ButtonType.OK);
                        alert.setHeaderText("Enrollment Was Updated");
                        alert.showAndWait();
                        CourseIDField.clear();
                        StudIDField.clear();
                        YearField.clear();
                        SemesterCB.setValue(null);
                        GradesCB.setValue(null);
                        EnrollIDField.clear();
                        EnrollIDField.setEditable(true);
                        EditEnrollBTN.setDisable(true);

                     } else {
                        Alert alert = new Alert(Alert.AlertType.ERROR, "Enrollment Was Not Updated", ButtonType.OK);
                        alert.showAndWait();
                     }
                  } catch (EmptyFieldException EFE) {
                     Alert alert = new Alert(Alert.AlertType.ERROR, EFE.getMessage(), ButtonType.OK);
                     alert.showAndWait();
                  } catch (NumberFormatException NFE) {
                     Alert alert = new Alert(Alert.AlertType.ERROR, "ID Field was Left Blank", ButtonType.OK);
                     alert.showAndWait();
                  } catch (Exception exc) {
                     Alert alert = new Alert(Alert.AlertType.ERROR, exc.getMessage(), ButtonType.OK);
                     alert.showAndWait();
                  }
               }
            });
            FindCourseBTN.setOnAction(
         new EventHandler<ActionEvent>() {
            @Override
               public void handle(ActionEvent event) {
                  try{
                     final int CourseId = Integer.parseInt(CourseIDField.getText());
                     Course found = c.GetCourse(CourseId);
                     if (found !=null ){
                        CourseName.setText(found.name);
                     }
                     else{
                        Alert alert = new Alert(Alert.AlertType.ERROR, "Course not found",ButtonType.OK);
                        alert.showAndWait();
                        CourseIDField.clear();
                     }
                  }
                  catch(EmptyFieldException EFE){
                     Alert alert = new Alert(Alert.AlertType.ERROR, "One or more ID Field was Left Blank",
                     ButtonType.OK);
                     alert.showAndWait();
                  }
                  catch(Exception EE){
                     Alert alert = new Alert(Alert.AlertType.ERROR, EE.getMessage(),
                     ButtonType.OK);
                     alert.showAndWait();
                  }

               }
         }
      );
      FindStudent.setOnAction(
         new EventHandler<ActionEvent>() {
            @Override
               public void handle(ActionEvent event) {
                  try{
                     final int Studentid = Integer.parseInt(StudIDField.getText()); 
                     
                     Student found = s.GetStudent(Studentid);
                     if (found != null){
                        System.out.println(Studentid + "." +found.FirstName + " "+found.LastName);
                        StudentNameTF.setText(found.FirstName + " "  + found.LastName);
                     }else{
                        Alert alert = new Alert(Alert.AlertType.ERROR, "Student not found",ButtonType.OK);
                        alert.showAndWait();
                        StudIDField.clear();
                     }
                  }
                  catch(Exception EE){
                     Alert alert = new Alert(Alert.AlertType.ERROR, EE.getMessage(),
                     ButtonType.OK);
                     alert.showAndWait();
                  }

                  
               }
         }
      );
      Scene EditEnrollmentScene = new Scene(fullBox, 400, 270);

      primaryStage.setScene(EditEnrollmentScene);
   }

   static void CreateViewEnrollmentScene(Stage primaryStage) {
      MenuBar x = createMenueBar(primaryStage);

      Label ViewEnrollmenrTitle = new Label("View Enrollment: ");
      Label EnrollmentID = new Label("Enrollment ID: ");
      TextField EnrollIDField = new TextField();
      HBox EnrollIDBox = new HBox(EnrollmentID, EnrollIDField);

      Label EnrollIDlb = new Label();
      Label CourseID = new Label();
      Label StudentID = new Label();
      Label Year = new Label();
      Label Semester = new Label();
      Label Grade = new Label();

      VBox f = new VBox(EnrollIDlb, CourseID, StudentID, Year, Semester, Grade);
      f.setAlignment(Pos.CENTER);
      f.setVisible(false);

      Button FindEnroll = new Button("Find Enrollment");
      FindEnroll.setOnAction(
            new EventHandler<ActionEvent>() {
               @Override
               public void handle(ActionEvent event) {
                  try {
                     final int EnrollmentID = Integer.parseInt(EnrollIDField.getText());
                     Enrollment v = e.GetEnrollment(EnrollmentID);
                     if (v != null) {
                        EnrollIDlb.setText("Enrollment ID: " + EnrollmentID);
                        CourseID.setText("Course: " + v.CID + " " + c.GetCourse(v.CID).name);
                        StudentID.setText("Student: " + v.SID + " " + s.GetStudent(v.SID).FirstName + " "+ s.GetStudent(v.SID).LastName );
                        Year.setText("Year: " + v.year);
                        Semester.setText("Semester: " + v.semester);
                        Grade.setText("Grade: " + v.grade);

                        f.setVisible(true);
                        FindEnroll.setText("Find Another Enrollment");
                     } else {
                        Alert alert = new Alert(Alert.AlertType.ERROR, "Enrollment was not Found", ButtonType.OK);
                        alert.showAndWait();
                     }
                  } catch (EmptyFieldException EFE) {
                     Alert alert = new Alert(Alert.AlertType.ERROR, EFE.getMessage(), ButtonType.OK);
                     alert.showAndWait();
                  } catch (Exception exc) {
                     Alert alert = new Alert(Alert.AlertType.ERROR, exc.getMessage(), ButtonType.OK);
                     alert.showAndWait();
                  }
               }
            });

      EnrollIDBox.setAlignment(Pos.CENTER);
      VBox e = new VBox(x, ViewEnrollmenrTitle, EnrollIDBox, FindEnroll);
      e.setAlignment(Pos.CENTER);

      VBox AddStudentVBox = new VBox(10, e, f);
      f.setAlignment(Pos.CENTER);
      // Create a Scene with the HBox as its root node.
      Scene viewEnrollScene = new Scene(AddStudentVBox, 400, 270);
      // Set the scene's alignment to center
      // Add the Scene to the Stage.
      primaryStage.setScene(viewEnrollScene);

      // Show the window.
      primaryStage.show();
   }

   static void CreateReportScene(Stage primaryStage) {
      MenuBar x = createMenueBar(primaryStage);
      // Add Student Scen
      Label ReportTitle = new Label("Report ");
      Label CourseName = new Label("Course Name: ");
      TextField CourseNameField = new TextField();
      Label Semester = new Label("Semester: ");
      ComboBox<String> SemesterCB = new ComboBox<>();
      SemesterCB.getItems().addAll("Spring", "Summer", "Fall", "Winter");
      Label Year = new Label("Year: ");
      TextField YearField = new TextField();
      Label FieldNames = new Label("StudentID   Student Name   Semester   Year   Grade");
      VBox LabelBox = new VBox(10, CourseName, Semester, Year);
      VBox FieldBox = new VBox(CourseNameField, SemesterCB, YearField);

      HBox InputBox = new HBox(LabelBox, FieldBox);
      InputBox.setAlignment(Pos.CENTER);
     //ObservableList<Enrollment> EnrollmentsReport = FXCollections.observableArrayList();
      //TextArea ReportArea = new TextArea();
      TableView<Object> tableView = new TableView<>();
      //TableColumn<Enrollment,Integer> EID = new TableColumn<>("EID");
      TableColumn<Object,Integer> CID = new TableColumn<>("Course ID");
      TableColumn<Object,Integer> SID = new TableColumn<>("Student ID");
      //TableColumn<Object, String> name = new TableColumn<>("Student Name");
      //   name.setCellValueFactory(param -> {
      //       if (param.getValue() instanceof Student) {
      //           return "Name ";
      //       }
      //   });
      //TableColumn<Object,String> FirstName = new TableColumn<>("First Name");
      TableColumn<Object,Character> Grade =new TableColumn<>("Grade");
      //tableView.getColumns().add(EID);
      tableView.getColumns().add(CID);
      tableView.getColumns().add(SID);
      //tableView.getColumns().add(name);
      tableView.getColumns().add(Grade);
      CID.setCellValueFactory(new PropertyValueFactory<>("CID"));
      SID.setCellValueFactory(new PropertyValueFactory<>("SID"));
      //FirstName.setCellValueFactory(new PropertyValueFactory<>("FirstName"));
      Grade.setCellValueFactory(new PropertyValueFactory<>("Grade"));
      //tableView.setItems(EnrollmentsReport);


    
      Button GenerateReport = new Button("Generate Report");

      GenerateReport.setOnAction(
            new EventHandler<ActionEvent>() {
               @Override
               public void handle(ActionEvent event) {
                  try {
                     final String CourseName = CourseNameField.getText();
                     final String Semester = SemesterCB.getValue();
                     final String Year = YearField.getText();
                     int CourseID = c.GetCourse(CourseName).courseID;
                     ObservableList<Object> EnrollmentsReport = e.FindStudentsEnrolled(CourseID,  Semester, Year);

                     if (EnrollmentsReport.size() == 0) {
                        Alert alert = new Alert(Alert.AlertType.ERROR, "No Student was enrolled", ButtonType.OK);
                        alert.showAndWait();
                     } else {
                        tableView.setItems(EnrollmentsReport);
                        
                     }
                  } catch (EmptyFieldException EFE) {
                     Alert alert = new Alert(Alert.AlertType.ERROR, EFE.getMessage(), ButtonType.OK);
                     alert.showAndWait();
                  } catch (Exception exc) {
                     Alert alert = new Alert(Alert.AlertType.ERROR, exc.getMessage(), ButtonType.OK);
                     alert.showAndWait();
                  }
               }
            });

      VBox ReportVBox = new VBox(x, ReportTitle, InputBox, GenerateReport, FieldNames, tableView);
      Scene viewEnrollScene = new Scene(ReportVBox, 400, 300);
      primaryStage.setScene(viewEnrollScene);
      primaryStage.show();

   }
}