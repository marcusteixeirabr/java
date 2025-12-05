package programaparimpar;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    private Label lblResultado;
    public TextField txtValor;
    public Button btnClick;

    @FXML
    protected void clicaBotao() {
        int v = Integer.parseInt(txtValor.getText());
        if (v % 2 == 0) {
            lblResultado.setText("PAR");
        } else {
            lblResultado.setText("ÍMPAR");
        }
    }
}
