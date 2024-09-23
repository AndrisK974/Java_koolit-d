module com.example.kodutoo6_andris_koiv {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.kodutoo6_andris_koiv to javafx.fxml;
    exports com.example.kodutoo6_andris_koiv;
}