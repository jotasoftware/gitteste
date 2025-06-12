package Controllers;

import Models.*;
import utils.ValidadorCNPJ;
import dao.*;
import dto.*;

import java.util.ArrayList;

public class FarmaciaCtrl {
    
    private FarmaciaDAO dao;

    public FarmaciaCtrl() {

        this.dao = new FarmaciaDAO();

    }

    public int verificarFarmacia(String cnpjFarmacia) {

        return dao.verificarCnpj(cnpjFarmacia);
        
    }
    

    public boolean cadastrar(String nome, String cnpjFarmacia) {
        
        if (nome == null || nome.isEmpty() || 
            cnpjFarmacia == null || cnpjFarmacia.isEmpty() || 
            !ValidadorCNPJ.isValidCNPJ(cnpjFarmacia)) {
             return false;
        }
        
        System.out.println(ValidadorCNPJ.isValidCNPJ(cnpjFarmacia) + cnpjFarmacia);
        
        Farmacia farmacia = new Farmacia(nome, cnpjFarmacia);

        return dao.adicionar(farmacia);

    }


    public ArrayList<SetorListagemDTO> listarSetores() {

        return dao.listarSetoresCnpj(Sessao.getIdFarmaciaLogada());

    }
    
    public ArrayList<FuncionarioListagemDTO> listarFuncionarios() {

        return dao.listarFuncionariosCnpj(Sessao.getIdFarmaciaLogada());

    }

//    public ArrayList<Transportadora> listaTransportadoras() {
//
//        return dao.listarTransportadorasCnpj(Sessao.getIdFarmaciaLogada());
//
//    }

    public ArrayList<CompraListagemDTO> listarCompras() {

        return dao.listarComprasCnpj(Sessao.getIdFarmaciaLogada());

    }

    public ArrayList<VendaListagemDTO> listarVendas() {

        return dao.listarVendasCnpj(Sessao.getIdFarmaciaLogada());
        
    }

    public ArrayList<LucroMensalDTO> listarLucrosMensais() {

        return dao.listarLucrosMensaisCnpj(Sessao.getIdFarmaciaLogada());
        
    }
    
    public ArrayList<Produto> listarProdutos() {

        return dao.listarProdutosCnpj(Sessao.getIdFarmaciaLogada());
        
    }

    
}    




