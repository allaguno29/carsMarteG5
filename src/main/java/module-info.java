module ec.edu.espol.vendedorcarrosg5 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens ec.edu.espol.vendedorcarrosg5 to javafx.fxml;
    opens ec.edu.espol.controller to javafx.fxml;
    exports ec.edu.espol.vendedorcarrosg5;
    exports ec.edu.espol.controller;
}
