package br.com.catolica.companhia.Model;

import br.com.catolica.companhia.Contracts.IAviao;
import br.com.catolica.companhia.Enum.EnumAviaoModelos;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

public class AviaoRegional extends Aviao implements IAviao {


    public AviaoRegional(EnumAviaoModelos modelos, String fabricante, int qntPassageiros, String anoFabricacao, String dataManutencao, String paisRegistro, int manutencao) {
        super(modelos, fabricante, qntPassageiros, anoFabricacao, dataManutencao, paisRegistro, manutencao);

    }

    @Override
    public void escolherModelo() {
        boolean aux = true;
        while (aux) {
            Scanner x = new Scanner(System.in);
            System.out.println("-------------------------");
            System.out.println("[1]- ATR_72");
            System.out.println("[2]- EMBRAER_E175");
            System.out.println("-------------------------");
            System.out.println("Escolha o Modelo do Aviao:");
            String opcao = x.nextLine();
            switch (opcao) {
                case "1":
                    AviaoRegional gulfstreamG700 = new AviaoRegional(EnumAviaoModelos.GULFSTREAM_G700, "Gulfstream Aerospace", 19, "2022", "0000", "Reino Unido",Funcionario.getMudarManutencao());
                    if(getManutencao() != 5){
                        getModelsGroup().add(gulfstreamG700.getModelos());
                        aux = false;
                        break;
                    } else {
                        System.out.println("Esse aviao estah em manutencao! tente com outro modelo!");
                        break;
                    }
                case "2":
                    AviaoRegional bombardierGlobal7500 = new AviaoRegional(EnumAviaoModelos.BOMBARDIER_GLOBAL_7500, "Bombardier", 17, "2023", "0000", "Canadá", Funcionario.getMudarManutencao());
                    if(getManutencao() != 6){
                        getModelsGroup().add(bombardierGlobal7500.getModelos());
                        aux = false;
                        break;
                    } else {
                        System.out.println("Esse aviao estah em manutencao! tente com outro modelo!");
                        break;
                    }
                default:
                    System.out.println("Opçao errada!");
                    break;
            }
        }
    }

    @Override
    public void realizarManutencao() {
        boolean aux = true;
        while (aux) {
            Scanner x = new Scanner(System.in);
            System.out.println("Digite uma data para a Manutencao:");
            String manun = x.nextLine();
            System.out.println("-------------------------");
            System.out.println("[5]- ATR_72");
            System.out.println("[6]- EMBRAER_E175");
            System.out.println("-------------------------");
            System.out.println("Escolha o Modelo do Aviao para realizar a manuntencao::");
            String opcao = x.nextLine();
            switch (opcao) {
                case "1":
                    Funcionario.setMudarManutencao(5);
                    AviaoRegional gulfstreamG700 = new AviaoRegional(EnumAviaoModelos.GULFSTREAM_G700, "Gulfstream Aerospace", 19, "2022", manun, "Reino Unido",Funcionario.getMudarManutencao());
                    System.out.printf("Passagem Registrada! --- %s \n",gulfstreamG700);
                    aux = false;
                    break;
                case "2":
                    Funcionario.setMudarManutencao(6);
                    AviaoRegional bombardierGlobal7500 = new AviaoRegional(EnumAviaoModelos.BOMBARDIER_GLOBAL_7500, "Bombardier", 17, "2023", manun, "Canadá", Funcionario.getMudarManutencao());
                    System.out.printf("Passagem Registrada! --- %s \n", bombardierGlobal7500);
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
        String autorizado = "Voo Autorizado!";
        Iterator<Object> it = Aviao.getModelsGroup().iterator();
        while (it.hasNext()) {
            Object modelo = it.next();
            if (modelo.equals(EnumAviaoModelos.GULFSTREAM_G700) || modelo.equals(EnumAviaoModelos.BOMBARDIER_GLOBAL_7500)) {
                Funcionario.voo.put(autorizado, modelo);
                it.remove();
            }
        }
        System.out.println(Funcionario.voo);
    }
}
