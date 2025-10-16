import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;

public class StudentRecordApp extends Application {

    private TableView<Student> table;
    private TextField nameField, rollField, marksField;
    private ObservableList<Student> studentList;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Student Record Management");

        // Input fields
        Label nameLabel = new Label("Name:");
        nameField = new TextField();
        nameField.setPromptText("Enter name");

        Label rollLabel = new Label("Roll No:");
        rollField = new TextField();
        rollField.setPromptText("Enter roll no");

        Label marksLabel = new Label("Marks:");
        marksField = new TextField();
        marksField.setPromptText("Enter marks");

        Button addButton = new Button("Add");
        Button clearButton = new Button("Clear");

        // Table setup
        TableColumn<Student, String> nameCol = new TableColumn<>("Name");
        nameCol.setMinWidth(150);
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Student, String> rollCol = new TableColumn<>("Roll No");
        rollCol.setMinWidth(100);
        rollCol.setCellValueFactory(new PropertyValueFactory<>("rollNo"));

        TableColumn<Student, Double> marksCol = new TableColumn<>("Marks");
        marksCol.setMinWidth(100);
        marksCol.setCellValueFactory(new PropertyValueFactory<>("marks"));

        studentList = FXCollections.observableArrayList();
        table = new TableView<>();
        table.setItems(studentList);
        table.getColumns().addAll(nameCol, rollCol, marksCol);

        // Button actions
        addButton.setOnAction(e -> addStudent());
        clearButton.setOnAction(e -> clearFields());

        HBox inputLayout = new HBox(10);
        inputLayout.setPadding(new Insets(10));
        inputLayout.getChildren().addAll(nameLabel, nameField, rollLabel, rollField, marksLabel, marksField, addButton, clearButton);

        VBox mainLayout = new VBox(10);
        mainLayout.setPadding(new Insets(15));
        mainLayout.getChildren().addAll(inputLayout, table);

        Scene scene = new Scene(mainLayout, 700, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void addStudent() {
        try {
            String name = nameField.getText();
            String rollNo = rollField.getText();
            double marks = Double.parseDouble(marksField.getText());

            if (name.isEmpty() || rollNo.isEmpty()) {
                showAlert(Alert.AlertType.ERROR, "Error", "All fields must be filled!");
                return;
            }

            studentList.add(new Student(name, rollNo, marks));
            clearFields();
        } catch (NumberFormatException e) {
            showAlert(Alert.AlertType.ERROR, "Invalid Input", "Please enter valid marks!");
        }
    }

    private void clearFields() {
        nameField.clear();
        rollField.clear();
        marksField.clear();
    }

    private void showAlert(Alert.AlertType type, String title, String message) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static class Student {
        private String name;
        private String rollNo;
        private double marks;

        public Student(String name, String rollNo, double marks) {
            this.name = name;
            this.rollNo = rollNo;
            this.marks = marks;
        }

        public String getName() {
            return name;
        }

        public String getRollNo() {
            return rollNo;
        }

        public double getMarks() {
            return marks;
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
