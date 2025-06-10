package Models;

import java.time.LocalDate;

public class Sindico extends Condomino {
    private LocalDate mandatoInicio;
    private LocalDate mandatoFim;

    public Sindico() {
        this.mandatoInicio = LocalDate.now();
        this.mandatoFim = LocalDate.now();
    }

    public LocalDate getMandatoInicio() {
        return mandatoInicio;
    }

    public void setMandatoInicio(LocalDate mandatoInicio) {
        this.mandatoInicio = mandatoInicio;
    }

    public LocalDate getMandatoFim() {
        return mandatoFim;
    }

    public void setMandatoFim(LocalDate mandatoFim) {
        this.mandatoFim = mandatoFim;
    }
    
}
