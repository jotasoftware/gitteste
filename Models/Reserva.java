package Models;

import java.time.LocalDate;

public class Reserva {
    private String localReserva;
    private LocalDate dataReserva;
    private String cpfReserva;
    private int id;
    
    public Reserva(){
	localReserva = "";
        dataReserva = LocalDate.now();
        id = 0;
        cpfReserva = "";
    }

    public String getLocalReserva() {
        return localReserva;
    }

    public void setLocalReserva(String localReserva) {
        this.localReserva = localReserva;
    }

    public LocalDate getDataReserva() {
        return dataReserva;
    }

    public void setDataReserva(LocalDate dataReserva) {
        this.dataReserva = dataReserva;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getCpfReserva() {
        return cpfReserva;
    }

    public void setCpfReserva(String cpfReserva) {
        this.cpfReserva = cpfReserva;
    }
    
}
