module online.speedwagon.catfishing {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.almasb.fxgl.all;

    opens online.speedwagon.catfishing to javafx.fxml;
    exports online.speedwagon.catfishing;
}