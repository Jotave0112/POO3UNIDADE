package br.com.catolica.companhia.Contracts;

import br.com.catolica.companhia.DAO.ContaClienteDao;
import br.com.catolica.companhia.Enum.EnumAviaoModelos;
import br.com.catolica.companhia.Model.Cliente;

import java.util.ArrayList;

public interface IClienteController {


    boolean loginCliente(ContaClienteDao dao);
    void verificarTickets(ContaClienteDao daozin);
    void verificarModelos(Cliente cliente);


}
