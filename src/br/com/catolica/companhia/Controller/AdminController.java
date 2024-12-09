package br.com.catolica.companhia.Controller;

import br.com.catolica.companhia.Contracts.IAdminController;
import br.com.catolica.companhia.DAO.AdminDao;
import br.com.catolica.companhia.DAO.ContaClienteDao;

import java.util.Map;
import java.util.Scanner;

public class AdminController implements IAdminController {


    @Override
    public boolean loginAdmin(AdminDao dao) {
        String user = dao.getUserAdm();
        String senha = dao.getSenhaAdm();
        for (Map<String, String> m : AdminDao.bcContaAdm) {
            if (m.containsKey(senha) && m.get(senha).equals(user)) {
                System.out.println("Login realizado com sucesso!");
                return true;
            }
        }
        System.out.println("Login Invalido!");
        return false;
    }

    @Override
    public void procurarPorUser() {
        Scanner x = new Scanner(System.in);
        System.out.println("Digite o User que Deseja Procurar:");
        String user = x.nextLine();
        for (Map<String, String> us : AdminDao.bcContaAdm) {
            if (us.values().contains(user)) {
                System.out.printf("Conta Admin Encontrada: %s", us);
            }
        }
    }

    @Override
    public void procurarPorSenha() {
        Scanner x = new Scanner(System.in);
        System.out.println("Digite a Senha que Deseja Procurar:");
        String senha = x.nextLine();
        for (Map<String, String> us : AdminDao.bcContaAdm) {
            if (us.containsKey(senha)) {
                System.out.printf("Conta Admin Encontrada: %s", us);
            }
        }

    }
}
