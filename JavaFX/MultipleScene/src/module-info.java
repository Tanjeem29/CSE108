module myjfx {
    requires javafx.fxml;
    requires javafx.controls;
    requires javafx.graphics;
    //requires kotlin.stdlib;
    opens sample to javafx.graphics, javafx.fxml;
}