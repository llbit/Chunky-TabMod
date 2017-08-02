package se.llbit.chunky.plugin;

import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class CustomMainTab extends javafx.scene.control.Tab {
  public CustomMainTab() {
    VBox vBox = new VBox();
    vBox.setPadding(new Insets(10));
    vBox.setSpacing(10);
    Button button = new Button("Click me");
    button.setOnAction(event -> {
      Alert alert = new Alert(Alert.AlertType.INFORMATION);
      alert.setTitle("Hello from CustomTab");
      alert.setContentText("Blah blah blah.");
      alert.show();
    });
    vBox.getChildren().add(new Label("This tab was created by a plugin."));
    vBox.getChildren().add(button);
    setText("Custom Tab");
    setContent(vBox);
  }
}
