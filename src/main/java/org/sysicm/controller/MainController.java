package org.sysicm.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.sysicm.model.Pessoa;

import java.text.DecimalFormat;

public class MainController {
    @FXML
    public TextField txtNome;
    @FXML
    public TextField txtAltura;
    @FXML
    public TextField txtPeso;
    @FXML
    public Label lbIMC;

    Pessoa pessoa = new Pessoa();

    @FXML
    protected void onCalcularIMCClick() {
        DecimalFormat df = new DecimalFormat();
        this.pessoa.setNome( this.txtNome.getText() );
        this.pessoa.setAltura( Float.parseFloat (this.txtAltura.getText()) );
        this.pessoa.setPeso( Float.parseFloat (this.txtPeso.getText()) );

        df.applyPattern("#0.00");
        this.lbIMC.setText( df.format( this.pessoa.calcularIMC()) );


    }
}