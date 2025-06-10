package Models;

public class Funcionario extends Pessoa{
    private String cargoFuncionario;
    private String turnoFuncionario;

    public Funcionario() {
        this.cargoFuncionario = "";
        this.turnoFuncionario = "";
    }

    public String getCargoFuncionario() {
        return cargoFuncionario;
    }

    public void setCargoFuncionario(String cargoFuncionario) {
        this.cargoFuncionario = cargoFuncionario;
    }

    public String getTurnoFuncionario() {
        return turnoFuncionario;
    }

    public void setTurnoFuncionario(String turnoFuncionario) {
        this.turnoFuncionario = turnoFuncionario;
    }
    
}
