
package Models;

import java.time.LocalDate;

public class Visitante extends Pessoa{
    private LocalDate data;
    private int apto;

    public Visitante() {
        this.data = LocalDate.now();
        this.apto = 0;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }
    
    public int getApto() {
        return apto;
    }

    public void setApto(int apto) {
        this.apto = apto;
    }
    
}
