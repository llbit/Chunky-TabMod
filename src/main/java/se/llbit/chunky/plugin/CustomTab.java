package se.llbit.chunky.plugin;

import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.layout.VBox;
import se.llbit.chunky.renderer.scene.Scene;
import se.llbit.chunky.ui.render.RenderControlsTab;

public class CustomTab implements RenderControlsTab {
  @Override public void update(Scene scene) {
  }

  @Override public Tab getTab() {
    Tab tab = new Tab("Plugin Tab");
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
    tab.setContent(vBox);
    return tab;
  }
}
