package br.com.catolica.companhia.Model;

import br.com.catolica.companhia.Contracts.IAviao;
import br.com.catolica.companhia.Controller.ClienteController;
import br.com.catolica.companhia.Enum.EnumAviaoModelos;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;




public class AviaoComercial extends Aviao implements IAviao {

    public AviaoComercial(EnumAviaoModelos modelos, String fabricante, int qntPassageiros, String anoFabricacao, String dataManutencao, String paisRegistro, int manutencao) {
        super(modelos, fabricante, qntPassageiros, anoFabricacao, dataManutencao, paisRegistro, manutencao);
    }


    @Override
    public void escolherModelo() {
        boolean aux = true;
        while (aux) {
            Scanner x = new Scanner(System.in);
            System.out.println("-------------------------");
            System.out.println("[1]- BOEING_737");
            System.out.println("[2]- AIRBUS_A320");
            System.out.println("-------------------------");
            System.out.println("Escolha o Modelo do Aviao:");
            String opcao = x.nextLine();
            switch (opcao) {
                case "1":
                     AviaoComercial boeing737 = new AviaoComercial(EnumAviaoModelos.BOEING_737, "Boeing", 180, "2018", "0000", "Estados Unidos", Funcionario.getMudarManutencao());
                    if(boeing737.getManutencao() != 1){
                        Aviao.getModelsGroup().add(boeing737.getModelos());
                        aux = false;
                        break;
                    } else {
                        System.out.println("Esse aviao estah em manutencao! tente com outro modelo!");
                        break;
                    }
                case "2":
                    AviaoComercial airbusA320 = new AviaoComercial(EnumAviaoModelos.AIRBUS_A320, "Airbus", 190, "2019", "0000", "França", Funcionario.getMudarManutencao());
                    if(getManutencao() != 2){
                        getModelsGroup().add(airbusA320.getModelos());
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
            System.out.println("[1]- BOEING_737");
            System.out.println("[2]- AIRBUS_A320");
            System.out.println("-------------------------");
            System.out.println("Escolha o Modelo do Aviao para realizar a manuntencao:");
            String opcao = x.nextLine();
            switch (opcao) {
                case "1":
                    Funcionario.setMudarManutencao(1);
                    AviaoComercial boeing737 = new AviaoComercial(EnumAviaoModelos.BOEING_737, "Boeing", 180, "2018",manun, "Estados Unidos", Funcionario.getMudarManutencao());
                    System.out.printf("Passagem Registrada! --- %s \n",boeing737);
                    aux = false;
                    break;
                case "2":
                    Funcionario.setMudarManutencao(2);
                    AviaoComercial airbusA320 = new AviaoComercial(EnumAviaoModelos.AIRBUS_A320, "Airbus", 190, "2019", manun, "França", Funcionario.getMudarManutencao());
                    System.out.printf("Passagem Registrada! --- %s \n",airbusA320);
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
            if (modelo.equals(EnumAviaoModelos.BOEING_737) || modelo.equals(EnumAviaoModelos.AIRBUS_A320)) {
                Funcionario.voo.put(autorizado, modelo);
                it.remove();
            }
        }
        System.out.println(Funcionario.voo);
    }
}
