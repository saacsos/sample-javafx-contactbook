package fscishl.phonebook;

import fscishl.phonebook.model.Contact;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class Controller {
    @FXML private TableView<Contact> tableView;
    @FXML private TextField firstNameField;
    @FXML private TextField lastNameField;
    @FXML private TextField phoneField;
    @FXML private Label errorMsg;

    @FXML
    protected void addContact() {
        String firstName = firstNameField.getText().trim();
        String lastName = lastNameField.getText().trim();
        String phone = phoneField.getText().trim();
        if (firstName.isEmpty() || lastName.isEmpty()
                || phone.isEmpty()) {
            errorMsg.setVisible(true);
            errorMsg.setText("Field cannot null");
        } else {
            ObservableList<Contact> data = tableView.getItems();
            data.add(new Contact(firstName, lastName, phone));
            clearForm();
        }

    }

    private void clearForm() {
        firstNameField.setText("");
        lastNameField.setText("");
        phoneField.setText("");
        errorMsg.setText("");
        errorMsg.setVisible(false);
    }
}
