module programaparimpar {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens programaparimpar to javafx.fxml;
    exports programaparimpar;
}