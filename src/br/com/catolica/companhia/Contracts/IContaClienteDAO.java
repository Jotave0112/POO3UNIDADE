package br.com.catolica.companhia.Contracts;

import br.com.catolica.companhia.DAO.ContaClienteDao;

import java.util.Map;

public interface IContaClienteDAO {

    Map<String,String> cadastroConta();
}
