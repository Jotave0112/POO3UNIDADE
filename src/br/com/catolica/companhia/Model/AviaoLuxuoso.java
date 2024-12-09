package br.com.catolica.companhia.Model;

import br.com.catolica.companhia.Contracts.IAviao;
import br.com.catolica.companhia.Enum.EnumAviaoModelos;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class AviaoLuxuoso extends Aviao implements IAviao {


    public AviaoLuxuoso(EnumAviaoModelos modelos, String fabricante, int qntPassageiros, String anoFabricacao, String dataManutencao, String paisRegistro, int manutencao) {
        super(modelos, fabricante, qntPassageiros, anoFabricacao, dataManutencao, paisRegistro, manutencao);
    }

    @Override
    public void escolherModelo() {
        boolean aux = true;
        while (aux) {
            Scanner x = new Scanner(System.in);
            System.out.println("-------------------------");
            System.out.println("[1]- GULFSTREAM_G700");
            System.out.println("[2]- BOMBARDIER_GLOBAL_7500");
            System.out.println("-------------------------");
            System.out.println("Escolha o Modelo do Aviao:");
            String opcao = x.nextLine();
            switch (opcao) {
                case "1":
                    AviaoLuxuoso atr72 = new AviaoLuxuoso(EnumAviaoModelos.ATR_72, "ATR", 70, "2020", "0000", "Brasil", Funcionario.getMudarManutencao());
                    if(getManutencao() != 3){
                        getModelsGroup().add(atr72.getModelos());
                        aux = false;
                        break;
                    } else {
                        System.out.println("Esse aviao estah em manutencao! tente com outro modelo!");
                        break;
                    }
                case "2":
                    AviaoLuxuoso embraerE175 = new AviaoLuxuoso(EnumAviaoModelos.EMBRAER_E175, "Embraer", 88, "2021", "0000", "Brasil", Funcionario.getMudarManutencao());
                    if(getManutencao() != 4){
                        getModelsGroup().add(embraerE175.getModelos());
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
            System.out.println("[3]- GULFSTREAM_G700");
            System.out.println("[4]- BOMBARDIER_GLOBAL_7500");
            System.out.println("-------------------------");
            System.out.println("Escolha o Modelo do Aviao para realizar a manuntencao::");
            String opcao = x.nextLine();
            switch (opcao) {
                case "1":
                    Funcionario.setMudarManutencao(3);
                    AviaoLuxuoso atr72 = new AviaoLuxuoso(EnumAviaoModelos.ATR_72, "ATR", 70, "2020", manun, "Brasil", Funcionario.getMudarManutencao());
                    System.out.printf("Passagem Registrada! --- %s \n",atr72);
                    aux = false;
                    break;
                case "2":
                    Funcionario.setMudarManutencao(4);
                    AviaoLuxuoso embraerE175 = new AviaoLuxuoso(EnumAviaoModelos.EMBRAER_E175, "Embraer", 88, "2021", manun, "Brasil", Funcionario.getMudarManutencao());
                    System.out.printf("Passagem Registrada! --- %s \n",embraerE175);
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
            if (modelo.equals(EnumAviaoModelos.ATR_72) || modelo.equals(EnumAviaoModelos.EMBRAER_E175)) {
                Funcionario.voo.put(autorizado, modelo);
                it.remove();
            }
        }
        System.out.println(Funcionario.voo);
    }
}

