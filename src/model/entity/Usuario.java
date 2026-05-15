package model.entity;

public class Usuario {
    private String id;
    private String nome;
    private long cpf;

    public Usuario(String id, String nome, long cpf) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getCpf() {
        return cpf;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }
}
