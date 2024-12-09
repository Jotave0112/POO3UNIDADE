package br.com.catolica.companhia.View;

import br.com.catolica.companhia.Controller.AdminController;
import br.com.catolica.companhia.Controller.ClienteController;
import br.com.catolica.companhia.DAO.AdminDao;
import br.com.catolica.companhia.DAO.ClienteDAO;
import br.com.catolica.companhia.DAO.ContaClienteDao;
import br.com.catolica.companhia.Enum.EnumClasseVoo;
import br.com.catolica.companhia.Enum.EnumTipoUsuario;
import br.com.catolica.companhia.Model.Cliente;
import br.com.catolica.companhia.Model.Funcionario;

import java.util.Scanner;

public class ClienteView {

    private ClienteController cco;
    private Cliente c;
    private Funcionario f;
    private AdminDao ad;
    private AdminController adc;

    public ClienteView() {
        this.cco = new ClienteController();
        this.f = new Funcionario(EnumTipoUsuario.FUNCIONARIO,"", "");
        this.ad = new AdminDao(EnumTipoUsuario.FUNCIONARIO,"","");
        this.adc = new AdminController();
    }


    public String clientName() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite uma User: ");
        String user = scanner.nextLine();

        return user;
    }

    public String clientSenha() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite uma senha: ");
        String senha = scanner.nextLine();

        return senha;
    }

    public String adminUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite uma User: ");
        String user = scanner.nextLine();

        return user;
    }

    public String adminSenha() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite uma senha: ");
        String senha = scanner.nextLine();

        return senha;
    }

    public void classeVoo() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1-Normal");
        System.out.println("2-Executiva");
        System.out.println("Primeira-Classe");
        System.out.print("Escolha o tipo de classe para o voo: ");
        String classe = scanner.nextLine();
    }

    public void telaPrincipal() {
        boolean aux = true;
        while (aux) {
            System.out.println("-----------------------------------------");
            System.out.println("Bem Vindo a Jotta´s Airlaines!");
            System.out.println("Se eh novo faça o cadastro ou");
            System.out.println("Faça o Login e Aproveite nossas Viagens!");
            System.out.println("-----------------------------------------");
            System.out.println("[1]- Cadastro");
            System.out.println("[2]- Login");
            System.out.println("[0]- Sair");
            System.out.println("-----------------------------------------");
            Scanner entrada = new Scanner(System.in);
            System.out.println("Escolha a Opcao: ");
            String escolha = entrada.nextLine();
            switch (escolha) {
                case "1":
                    ClienteDAO cc = new ClienteDAO(clientName(), clientSenha());
                    ClienteDAO.bcContaClient.add(cc.cadastroContaCliente());
                    System.out.println(ContaClienteDao.bcContaClient);
                    break;
                case "2":
                    ContaClienteDao ccLogin = new ContaClienteDao(clientName(), clientSenha());
                    if (cco.loginCliente(ccLogin)) {
                        telaCliente(ccLogin);
                    } else {
                        break;
                    }
                case "0":
                    aux = false;
                    break;
                case "j0t4v3":
                    telaCadastroELoginAdm();
                    break;
                default:
                    System.out.println("Opcao Errada!");
                    break;
            }
        }
    }

    public void telaCliente(ContaClienteDao dao) {
        boolean aux = true;
        Scanner entrada = new Scanner(System.in);
        while (aux) {
            System.out.println("-----------------------------------------");
            System.out.println("Bem Vindo a Jotta´s Airlaines!");
            System.out.println("Aproveite nossas Viagens!");
            System.out.println("-----------------------------------------");
            System.out.println("[1]- Comprar Tickets");
            System.out.println("[0]- Sair");
            System.out.println("-----------------------------------------");
            System.out.println("Escolha a Opcao: ");
            String escolha = entrada.nextLine();
            switch (escolha) {
                case "1":
                    cco.verificarTickets(dao);
                    break;
                case "0":
                    telaPrincipal();
                    break;
                default:
                    break;
            }

        }
    }

    public void telaAdmin() {
        boolean aux = true;
        Scanner entrada = new Scanner(System.in);
        while (aux) {
            System.out.println("-----------------------------------------");
            System.out.println("Bem Vindo Senhor Admin");
            System.out.println("Um Bom trabalho!");
            System.out.println("-----------------------------------------");
            System.out.println("[1]- Ativar Manuntecao");
            System.out.println("[2]- Ativar Voo");
            System.out.println("[3]- Operar Trafego");
            System.out.println("[4]- Procurar Admin por User");
            System.out.println("[5]- Procurar Admin por Senha");
            System.out.println("[0]- Sair");
            System.out.println("-----------------------------------------");
            System.out.println("Escolha a Opcao: ");
            String escolha = entrada.nextLine();
            switch (escolha) {
                case "1":
                    f.ativarManutencao();
                    break;
                case "2":
                    f.autorizarVoo();
                    break;
                case "3":
                    f.operarTrafego();
                    break;
                case "4":
                    f.acharUserAdmin();
                    break;
                case "5":
                    f.acharSenhaAdmin();
                    break;
                case "0":
                    aux = false;
                    break;
                default:
                    break;
            }
        }
    }

    public void telaCadastroELoginAdm() {
        boolean aux = true;
        while (aux) {
            System.out.println("------------------------------------------");
            System.out.println("------------------------------------------");
            System.out.println("--------------SETOR ADMIN-----------------");
            System.out.println("------------------------------------------");
            System.out.println("[1]- Cadastro Admin");
            System.out.println("[2]- Login Admin");
            System.out.println("-----------------------------------------");
            Scanner entrada = new Scanner(System.in);
            System.out.println("Escolha a Opcao: ");
            String escolha = entrada.nextLine();
            switch (escolha) {
                case "1":
                    AdminDao adDao = new AdminDao(EnumTipoUsuario.FUNCIONARIO,adminSenha(),adminUser());
                    AdminDao.bcContaAdm.add(adDao.cadastroAdmin());
                    System.out.println(AdminDao.bcContaAdm);
                    break;
                case "2":
                    AdminDao adLogin = new AdminDao(EnumTipoUsuario.FUNCIONARIO,adminSenha(),adminUser());
                    if (adc.loginAdmin(adLogin)) {
                        telaAdmin();
                    } else {
                        break;
                    }
                default:
                    System.out.println("saindo...");
                    aux = false;
                    break;
            }
        }
    }
}