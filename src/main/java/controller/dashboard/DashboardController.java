package controller.dashboard;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class DashboardController {

    Stage stage = new Stage();
    Stage stage1 = new Stage();

    public void btnCustoemerManagementOnAction(ActionEvent actionEvent) {
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/View/customer.fxml"))));
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void btnOrderManagementOnAction(ActionEvent actionEvent) {
    }

    public void btnItemManagementOnAction(ActionEvent actionEvent) {
        try {
            stage1.setScene(new Scene(FXMLLoader.load(getClass().getResource("/View/item.fxml"))));
            stage1.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void btnOrderDetailsManagementOnAction(ActionEvent actionEvent) {
    }
}

