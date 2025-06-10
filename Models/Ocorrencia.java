package Models;

public class Ocorrencia {
    private int idOcorrencia;
    private String textoOcorrencia;
    private String cpfOcorrencia;

    public Ocorrencia() {
        this.idOcorrencia = 0;
        this.textoOcorrencia = "";
        this.cpfOcorrencia = "";
    }

    public int getIdOcorrencia() {
        return idOcorrencia;
    }

    public void setIdOcorrencia(int idOcorrencia) {
        this.idOcorrencia = idOcorrencia;
    }

    public String getTextoOcorrencia() {
        return textoOcorrencia;
    }

    public void setTextoOcorrencia(String textoOcorrencia) {
        this.textoOcorrencia = textoOcorrencia;
    }
    
    public String getCpfOcorrencia() {
        return cpfOcorrencia;
    }

    public void setCpfocorrencia(String cpfOcorrencia) {
        this.cpfOcorrencia = cpfOcorrencia;
    }
}
