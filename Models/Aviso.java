package Models;

public class Aviso {
    private int idAviso;
    private String textoAviso;

    public Aviso() {
        this.idAviso = 0;
        this.textoAviso = "";
    }

    public int getIdAviso() {
        return idAviso;
    }

    public void setIdAviso(int idAviso) {
        this.idAviso = idAviso;
    }

    public String getTextoAviso() {
        return textoAviso;
    }

    public void setTextoAviso(String textoAviso) {
        this.textoAviso = textoAviso;
    }

}
