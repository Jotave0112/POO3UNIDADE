package br.com.catolica.companhia.Model;

import br.com.catolica.companhia.Enum.EnumAviaoModelos;

import java.util.ArrayList;

public abstract class Aviao {

    private EnumAviaoModelos modelos;
    private String fabricante;
    private int qntPassageiros;
    private String anoFabricacao;
    private String dataManutencao;
    private String paisRegistro;
    private int manutencao;

    public static ArrayList<Object> modelsGroup = new ArrayList<>();

    public Aviao(EnumAviaoModelos modelos, String fabricante, int qntPassageiros, String anoFabricacao, String dataManutencao, String paisRegistro, int manutencao) {
        this.modelos = modelos;
        this.fabricante = fabricante;
        this.qntPassageiros = qntPassageiros;
        this.anoFabricacao = anoFabricacao;
        this.dataManutencao = dataManutencao;
        this.paisRegistro = paisRegistro;
        this.manutencao = manutencao;
    }

    public String getFabricante() {
        return fabricante;
    }


    public int getQntPassageiros() {
        return qntPassageiros;
    }

    public String getAnoFabricacao() {
        return anoFabricacao;
    }

    public String getDataManutencao() {
        return dataManutencao;
    }

    public String getPaisRegistro() {
        return paisRegistro;
    }

    public static ArrayList<Object> getModelsGroup() {
        return modelsGroup;
    }

    public int getManutencao() {
        return manutencao;
    }

    public EnumAviaoModelos getModelos() {
        return modelos;
    }

    @Override
    public String toString() {
        return "Aviao{" +
                "fabricante='" + fabricante + '\'' +
                ", qntPassageiros=" + qntPassageiros +
                ", anoFabricacao='" + anoFabricacao + '\'' +
                ", dataManutencao='" + dataManutencao + '\'' +
                ", paisRegistro='" + paisRegistro + '\'' +
                '}';
    }
}
