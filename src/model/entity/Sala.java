package model.entity;

public class Sala {

    private String id;
    private int numero;
    private int capacidade;
    private double disponivel;

    public Sala(String id, int numero, int capacidade, double disponivel) {
        this.id = id;
        this.numero = numero;
        this.capacidade = capacidade;
        this.disponivel = disponivel;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public double getDisponivel() {
        return disponivel;
    }

    public void setDisponivel(double disponivel) {
        this.disponivel = disponivel;
    }

}
