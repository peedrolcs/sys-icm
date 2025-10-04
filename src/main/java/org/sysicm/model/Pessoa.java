package org.sysicm.model;

public class Pessoa {
    private String nome;
    private float altura;
    private float peso;

//==============================================================

    public Pessoa() {
    }

    public Pessoa(String nome, float altura, float peso) {
        this.nome = nome;
        this.altura = altura;
        this.peso = peso;
    }
//==============================================================
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }
//==============================================================
    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", altura=" + altura +
                ", peso=" + peso +
                '}';
    }
//==============================================================
    public float calcularIMC(){
        return this.peso / (altura * altura);
    }
}
