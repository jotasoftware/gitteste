package Models;

import java.util.HashSet;
import java.util.Set;

public class Transportadora {

    private Integer id;
    private String nome;
    private Set<Estado> estadosAtendidos; 

    public Transportadora() {
        this.estadosAtendidos = new HashSet<>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Estado> getEstadosAtendidos() {
        return estadosAtendidos;
    }

    public void setEstadosAtendidos(Set<Estado> estadosAtendidos) {
        this.estadosAtendidos = estadosAtendidos;
    }

}
