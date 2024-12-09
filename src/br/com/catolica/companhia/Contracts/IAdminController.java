package br.com.catolica.companhia.Contracts;

import br.com.catolica.companhia.DAO.AdminDao;
import br.com.catolica.companhia.DAO.ContaClienteDao;

public interface IAdminController {

    boolean loginAdmin(AdminDao dao);
    void procurarPorUser();
    void procurarPorSenha();

}
