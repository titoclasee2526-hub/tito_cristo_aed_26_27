module es.iescanarias.tito.cristo {
 requires javafx.controls;
    requires javafx.fxml;
    requires jdk.incubator.vector;

    opens es.iescanarias.tito.cristo to javafx.fxml;
    opens es.iescanarias.tito.cristo.controller to javafx.fxml;
    exports es.iescanarias.tito.cristo;
}
