package org.sysicm.controller;

import javafx.beans.Observable;
import javafx.beans.property.Property;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import org.sysicm.model.Pessoa;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.ResourceBundle;

public class MainController implements Initializable{
    @FXML
    public TextField txtNome;
    @FXML
    public TextField txtAltura;
    @FXML
    public TextField txtPeso;
    @FXML
    public Label lbIMC;
    @FXML
    public Label lbClassificacao;
    // VARIAVEIS TABELA
    @FXML
    TableView<Pessoa> tbPessoas;
    @FXML
    TableColumn<Pessoa, Integer> colId;
    @FXML
    TableColumn<Pessoa, String> colNome;
    @FXML
    TableColumn<Pessoa, Float> colPeso;
    @FXML
    TableColumn<Pessoa, Float> colAltura;
    @FXML
    TableColumn<Pessoa, Float> colIMC;

    private int proximoID = 0;

    Pessoa pessoa;
    List<Pessoa> listaPessoas;
    ObservableList<Pessoa> observableListPessoa;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        this.pessoa = new Pessoa();
        this.listaPessoas = new ArrayList<>();
        vinculoComTabela();
    }
    public void vinculoComTabela(){
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colAltura.setCellValueFactory(new PropertyValueFactory<>("altura"));
        colPeso.setCellValueFactory(new PropertyValueFactory<>("peso"));
        colIMC.setCellValueFactory(new PropertyValueFactory<>("imc"));
    }
    public void lerFormulario(){
        this.pessoa.setNome( this.txtNome.getText() );
        this.pessoa.setAltura( Float.parseFloat (this.txtAltura.getText()) );
        this.pessoa.setPeso( Float.parseFloat (this.txtPeso.getText()) );
    }
    public void atualizarTableView(){
        this.listaPessoas.forEach(obj -> System.out.printf(obj.getNome() + ", " + obj.getPeso() + ", " + obj.getAltura() + "\n"));
        this.observableListPessoa = FXCollections.observableList(this.listaPessoas);
        this.tbPessoas.setItems(this.observableListPessoa);
    }
    public void exibirClassificacaoIMC(){
        DecimalFormat df = new DecimalFormat();

        df.applyPattern("#0.00");
        this.lbIMC.setText( df.format( this.pessoa.calcularIMC()) );
        this.lbClassificacao.setText( this.pessoa.classificacaoIMC() );
    }

    @FXML
    protected void onCalcularIMCClick() {
        lerFormulario();
        this.pessoa.classificacaoIMC();
        exibirClassificacaoIMC();
        System.out.println(this.pessoa.toString());
    }
    @FXML
    protected void onSalvarIMCClick(){
        lerFormulario();
        int novoID = ++ proximoID;
        this.pessoa.setId(novoID);
        this.listaPessoas.add(pessoa);
        atualizarTableView();
    }
    @FXML
    protected void onCarregarDadosIMCClick(){
        this.pessoa = new Pessoa();
        txtNome.setText(" ");
        txtAltura.setText(" ");
        txtPeso.setText(" ");
    }
}