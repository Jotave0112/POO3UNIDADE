package br.com.catolica.companhia.DAO;

import br.com.catolica.companhia.Contracts.IContaClienteDAO;
import br.com.catolica.companhia.Model.Cliente;
import br.com.catolica.companhia.Model.Conta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ContaClienteDao extends Conta implements IContaClienteDAO {

    public static ArrayList<Map<String,String>> bcContaClient = new ArrayList<>();

    public ContaClienteDao(String user,
                           String senha
    ) {
        super(user, senha);
    }


    @Override
    public Map<String, String> cadastroConta() {
        Map<String, String> dados = new HashMap<>();

        for (Map<String, String> map : bcContaClient) {
            if (map.containsKey(getSenha())) {
                System.out.println("A senha Ja existe!");
            }
        }

        dados.put(getSenha(), getUser());
        return dados;
    }
}



