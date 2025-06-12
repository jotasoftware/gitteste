package dto;

import java.util.Set;

public class TransportadoraDTO {

    private Integer id;
    private String nome;
    private Set<String> estadosAtendidos; 

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

    public Set<String> getEstadosAtendidos() {
        return estadosAtendidos;
    }

    public void setEstadosAtendidos(Set<String> estadosAtendidos) {
        this.estadosAtendidos = estadosAtendidos;
    }
}
