package br.com.catolica.companhia.Model;

import br.com.catolica.companhia.Contracts.IFuncionario;
import br.com.catolica.companhia.Controller.AdminController;
import br.com.catolica.companhia.Enum.EnumAviaoModelos;
import br.com.catolica.companhia.Enum.EnumClasseVoo;
import br.com.catolica.companhia.Enum.EnumLocais;
import br.com.catolica.companhia.Enum.EnumTipoUsuario;

import java.util.*;

public class Funcionario implements IFuncionario {

    AdminController adc;

    private static int mudarManutencao = 0;
    private String senhaAdm;
    private String userAdm;
    private EnumTipoUsuario tipo;

    public static Map<String,Object> voo = new HashMap<>();

    AviaoComercial ac;
    AviaoRegional ar;
    AviaoLuxuoso al;

    public Funcionario(EnumTipoUsuario tipo,String senhaAdm, String userAdm){
        this.senhaAdm = senhaAdm;
        this.userAdm = userAdm;
        this.tipo = tipo;
        this.ac = new AviaoComercial(EnumAviaoModelos.NENHUM,"",0,"0000","0000","",90);
        this.ar = new AviaoRegional(EnumAviaoModelos.NENHUM,"",0,"0000","0000","",90);
        this.al = new AviaoLuxuoso(EnumAviaoModelos.NENHUM,"",0,"0000","0000","",90);
    }

    @Override
    public void ativarManutencao() {

        boolean aux = true;
        Scanner scanner = new Scanner(System.in);
        while (aux) {
            System.out.println("-------------------------");
            System.out.println("[1]- Aviao Comercial");
            System.out.println("[2]- Aviao Regional");
            System.out.println("[3]- Aviao Luxuoso");
            System.out.println("-------------------------");
            System.out.println("Escolha o tipo de Aviao Para Realizar a Manutencao:");
            String opcao = scanner.nextLine();
            switch (opcao){
                case "1":
                   ac.realizarManutencao();
                   aux = false;
                   break;
                case "2":
                    ar.realizarManutencao();
                    aux = false;
                    break;
                case "3":
                    al.realizarManutencao();
                    aux = false;
                    break;
                default:
                    System.out.println("Opcao errada!");
                    break;
            }
        }
    }



    @Override
    public void autorizarVoo() {
        boolean aux = true;
        Scanner scanner = new Scanner(System.in);
        while (aux) {
            System.out.println("-------------------------");
            System.out.println("[1]- Voo(s) Comercial");
            System.out.println("[2]- Voo(s) Regional");
            System.out.println("[3]- Voo(s) Luxuoso");
            System.out.println("-------------------------");
            System.out.println("Escolha o tipo de Aviao Para enviar a mensagem de Voo:");
            String opcao = scanner.nextLine();
            switch (opcao) {
                case "1":
                    ac.autorizarVoo();
                    aux = false;
                    break;
                case "2":
                    ar.autorizarVoo();
                    aux = false;
                    break;
                case "3":
                    al.autorizarVoo();
                    aux = false;
                    break;
                default:
                    System.out.println("Opcao Errada!");
                    break;
            }
        }
    }

    @Override
    public void operarTrafego() {
        int contador = 0;
        Random random = new Random();
        for(int x = 0; x < voo.size(); x++){
            System.out.printf("[%d] - %s\n",x,voo);
        }
        Scanner perg = new Scanner(System.in);
        System.out.println("Escolha um dos Voos para saber a condicao atual do Voo: ");
        int posicao = perg.nextInt();
        int randomNum = random.nextInt(3);
        for(Object modelos : voo.values()){
            if(posicao == contador){
                switch (randomNum){
                    case 0:
                        System.out.printf("--Voo Estavel--| %s\n",modelos);
                        break;
                    case 1:
                        System.out.printf("--Voo com Turbulencia--| %s\n",modelos);
                        break;
                    case 2:
                        System.out.printf("--Voo apresentando desvio de rota-- | %s",modelos);
                        break;
                }
            break;
            } else {
                contador++;
            }
        }
    }

    @Override
    public void acharUserAdmin() {
        try{
            adc.procurarPorUser();
        }
        catch (Exception e){
            System.err.println("Erro ao Achar User");
        }
    }

    @Override
    public void acharSenhaAdmin() {
        try{
            adc.procurarPorSenha();
        }
        catch (Exception e){
            System.err.println("Erro ao Achar Senha");
        }

    }


    public static int getMudarManutencao() {
        return mudarManutencao;
    }

    public static void setMudarManutencao(int mudarManutencao) {
        Funcionario.mudarManutencao = mudarManutencao;
    }

    public String getSenhaAdm() {
        return senhaAdm;
    }

    public String getUserAdm() {
        return userAdm;
    }
}
