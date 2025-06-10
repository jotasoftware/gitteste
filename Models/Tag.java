package Models;

public class Tag {
    private int idTag;
    private String cpfDono;

    public Tag() {
        this.idTag = 0;
        this.cpfDono = "";
    }

    public int getIdTag() {
        return idTag;
    }

    public void setIdTag(int idTag) {
        this.idTag = idTag;
    }
    
    public String getCpfDono() {
        return cpfDono;
    }

    public void setCpfDono(String cpfDono) {
        this.cpfDono = cpfDono;
    }
    
}
