package inatel.Model;

public class Carro {
    private String id;
    private String nome;
    private float valor;
    private String modelo;
    private int ano;
    private String marca;

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public float getValor() {
        return valor;
    }

    public String getModelo() {
        return modelo;
    }

    public int getAno() {
        return ano;
    }

    public String getMarca() {
        return marca;
    }

    public Carro(String id, String nome, float valor, String modelo, int ano, String marca) {
        this.id = id;
        this.nome = nome;
        this.valor = valor;
        this.modelo = modelo;
        this.ano = ano;
        this.marca = marca;
    }
}
