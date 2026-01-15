module programaparimpar {
    requires transitive javafx.controls;
    requires transitive javafx.fxml;
    requires transitive javafx.graphics;

    requires org.kordamp.bootstrapfx.core;

    opens programaparimpar to javafx.fxml;
    exports programaparimpar;
}