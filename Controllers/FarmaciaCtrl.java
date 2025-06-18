package Controllers;

import Models.*;
import config.DatabaseConnection;
import utils.ValidadorCNPJ;
import dao.*;
import dto.*;
import java.sql.Connection;
import java.sql.SQLException;

import java.util.ArrayList;

public class FarmaciaCtrl {

    public FarmaciaCtrl() {

    }

    public int verificarFarmacia(String cnpjFarmacia) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            FarmaciaDAO dao = new FarmaciaDAO(conn);
            
            return dao.verificarCnpj(cnpjFarmacia);
        } catch (SQLException e) {
            System.err.println("Erro de banco de dados ao verificar farmácia: " + e.getMessage());
            return -1; 
        }
    }
    

    public boolean cadastrar(String nome, String cnpjFarmacia, String saldoInicial) {
        double saldoDouble = Double.parseDouble(saldoInicial.replace(",", ".")); 
        if (!ValidadorCNPJ.isValidCNPJ(cnpjFarmacia)) {
            return false;
        }

        Farmacia farmacia = new Farmacia(nome, cnpjFarmacia, saldoDouble);

        try (Connection conn = DatabaseConnection.getConnection()) {
            FarmaciaDAO dao = new FarmaciaDAO(conn);
            return dao.adicionar(farmacia);
        } catch (NumberFormatException e) {
            System.err.println("Erro ao converter valores numéricos: " + e.getMessage());
            return false;
        } catch (SQLException e) {
            System.err.println("Erro de banco de dados ao cadastrar farmácia: " + e.getMessage());
            return false;
        }
    }
    
    public double buscaSaldo() {
        try (Connection conn = DatabaseConnection.getConnection()) {
            FarmaciaDAO dao = new FarmaciaDAO(conn);
            return dao.buscaSaldo(Sessao.getIdFarmaciaLogada());
        } catch (SQLException e) {
            System.err.println("Erro de banco de dados ao buscar o saldo: " + e.getMessage());
            return 0; 
        }
    }

    public ArrayList<CompraListagemDTO> listarCompras() {
        try (Connection conn = DatabaseConnection.getConnection()) {
            FarmaciaDAO dao = new FarmaciaDAO(conn);
            return dao.listarComprasCnpj(Sessao.getIdFarmaciaLogada());
        } catch (SQLException e) {
            System.err.println("Erro de banco de dados ao listar compras: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    public ArrayList<VendaListagemDTO> listarVendas() {
        try (Connection conn = DatabaseConnection.getConnection()) {
            FarmaciaDAO dao = new FarmaciaDAO(conn);
            return dao.listarVendasCnpj(Sessao.getIdFarmaciaLogada());
        } catch (SQLException e) {
            System.err.println("Erro de banco de dados ao listar vendas: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    public ArrayList<LucroListagemDTO> listarLucrosMensais(boolean buscarFuturo) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            FarmaciaDAO dao = new FarmaciaDAO(conn);
            return dao.listarLucrosMensaisCnpj(Sessao.getIdFarmaciaLogada(), buscarFuturo);
        } catch (SQLException e) {
            System.err.println("Erro de banco de dados ao listar lucros: " + e.getMessage());
            return new ArrayList<>();
        }
    }
    
    public ArrayList<LucroListagemDTO> listarLucrosAnuais(boolean buscarFuturo) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            FarmaciaDAO dao = new FarmaciaDAO(conn);
            return dao.listarLucrosAnuaisCnpj(Sessao.getIdFarmaciaLogada(), buscarFuturo);
        } catch (SQLException e) {
            System.err.println("Erro de banco de dados ao listar lucros: " + e.getMessage());
            return new ArrayList<>();
        }
    }
    
}    




