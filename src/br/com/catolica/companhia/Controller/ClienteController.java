package br.com.catolica.companhia.Controller;

import br.com.catolica.companhia.Contracts.IClienteController;
import br.com.catolica.companhia.DAO.ContaClienteDao;
import br.com.catolica.companhia.Enum.EnumAviaoModelos;
import br.com.catolica.companhia.Enum.EnumClasseVoo;
import br.com.catolica.companhia.Enum.EnumLocais;
import br.com.catolica.companhia.Enum.EnumTipoUsuario;
import br.com.catolica.companhia.Model.*;
import br.com.catolica.companhia.View.ClienteView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ClienteController implements IClienteController {

    Cliente c;
    Aviao aviao;
    AviaoComercial ac;
    AviaoRegional ar;
    AviaoLuxuoso al;


    public ClienteController(){
        this.c = new Cliente(EnumTipoUsuario.CLIENTE, EnumClasseVoo.NORMAL, EnumLocais.JOAO_PESSOA,0,"","");
        this.ac = new AviaoComercial(EnumAviaoModelos.NENHUM,"",0,"0000","0000","",90);
        this.ar = new AviaoRegional(EnumAviaoModelos.NENHUM,"",0,"0000","0000","",90);
        this.al = new AviaoLuxuoso(EnumAviaoModelos.NENHUM,"",0,"0000","0000","",90);
    }

    @Override
    public boolean loginCliente(ContaClienteDao dao) {
        String user = dao.getUser();
        String senha = dao.getSenha();
        for(Map<String,String> m: ContaClienteDao.bcContaClient){
            if(m.containsKey(senha) && m.get(senha).equals(user)){
                System.out.println("Login realizado com sucesso!");
                return true;
            }
        }
        System.out.println("Login Invalido!");
        return false;
    }

    @Override
    public void verificarTickets(ContaClienteDao daozin) {
        String user = daozin.getUser();
        String senha = daozin.getSenha();
        for(Map<String,String> conta: ContaClienteDao.bcContaClient){
            if(conta.containsKey(senha) && conta.get(senha).equals(user)){
                List<Object> dados = new ArrayList<>();

                EnumClasseVoo classeVoo = c.selecionarClasseVoo();
                EnumLocais comprarTickets = c.comprarTickets();
                int tickts = c.qntTickets();
                String cpf = c.digitarCPF();
                String name = c.digitarNome();

                Cliente cliente = new Cliente(EnumTipoUsuario.CLIENTE,
                       classeVoo,
                        comprarTickets,
                        tickts,
                        cpf,
                        name);

                verificarModelos(cliente);
                dados.add(cliente);
                dados.add(conta);
                System.out.println(Aviao.getModelsGroup());
                Cliente.allClientBancoDados.add(dados);
                System.out.println("Passagem feita!");
                System.out.println(Cliente.allClientBancoDados);
            }
        }
    }

    @Override
    public void verificarModelos(Cliente cliente) {
        boolean aux = true;
        Scanner scanner = new Scanner(System.in);

        while (aux) {
            System.out.println("-------------------------");
            System.out.println("[1]- Aviao Comercial");
            System.out.println("[2]- Aviao Regional");
            System.out.println("[3]- Aviao Luxuoso");
            System.out.println("-------------------------");
            System.out.println("Escolha o tipo de Aviao:");

            String opcao = scanner.nextLine();

            switch (opcao) {
                case "1":
                    ac.escolherModelo();
                    aux = false;
                    break;

                case "2":
                    EnumLocais ticketLocal = cliente.getDesembarque();
                    if (ticketLocal == EnumLocais.SAO_PAULO ||
                            ticketLocal == EnumLocais.RIO_DE_JANEIRO ||
                            ticketLocal == EnumLocais.SALVADOR) {
                        System.out.println("Esse tipo de aviao serve apenas para lugares específicos! Tente novamente.");
                    } else {
                        ar.escolherModelo();
                        aux = false;
                    }
                    break;

                case "3":
                    EnumClasseVoo classeVoo = cliente.getClasseVoo();
                    if (classeVoo == EnumClasseVoo.PRIMEIRA_CLASSE) {
                        al.escolherModelo();
                        aux = false;
                    } else {
                        System.out.println("O tipo de assento não é compatível com esse tipo de avião! Tente novamente.");
                    }
                    break;

                default:
                    System.out.println("Opção inválida! Por favor, tente novamente.");
                    break;
            }
        }
    }





}
