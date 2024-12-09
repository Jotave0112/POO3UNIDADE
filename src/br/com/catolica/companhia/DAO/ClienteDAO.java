package br.com.catolica.companhia.DAO;

import br.com.catolica.companhia.Contracts.IContaClienteDAO;
import br.com.catolica.companhia.Model.Cliente;
import br.com.catolica.companhia.Model.Conta;


import java.util.Map;

public class ClienteDAO extends ContaClienteDao {


    public ClienteDAO(String user, String senha) {
        super(user, senha);
    }

    public Map<String, String> cadastroContaCliente() {
        return cadastroConta();
    }

}
