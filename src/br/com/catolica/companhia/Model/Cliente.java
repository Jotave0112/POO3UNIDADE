package br.com.catolica.companhia.Model;

import br.com.catolica.companhia.Contracts.ICliente;
import br.com.catolica.companhia.Enum.EnumClasseVoo;
import br.com.catolica.companhia.Enum.EnumLocais;
import br.com.catolica.companhia.Enum.EnumTipoUsuario;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

public class Cliente extends Pessoa implements ICliente {

    private String id;
    private EnumTipoUsuario tipoUsuario;
    private int tickets;
    private EnumLocais desembarque;
    private EnumClasseVoo classeVoo;

    public static ArrayList<Object> allClientBancoDados = new ArrayList<>();

    public Cliente(EnumTipoUsuario tipoUsuario,
                   EnumClasseVoo classeVoo,
                   EnumLocais desembarque,
                   int tickets,
                   String cpf,
                   String nome) {
        super(cpf, nome);
        this.id = UUID.randomUUID().toString();
        this.tipoUsuario = tipoUsuario;
        this.classeVoo = classeVoo;
        this.desembarque = desembarque;
        this.tickets = tickets;
    }


    @Override
    public EnumLocais comprarTickets() {
        boolean aux = true;
        while(aux) {
            Scanner entrada = new Scanner(System.in);
            System.out.println("Escolha o local para onde deseja ir:");
            System.out.println("[1]- Rio de Janeiro");
            System.out.println("[2]- São Paulo");
            System.out.println("[3]- João Pessoa");
            System.out.println("[4]- Salvador");
            System.out.println("[5]- Recife");
            System.out.println("[6]- Fortaleza");
            System.out.print("Digite o número correspondente ao local: ");


            String escolha = entrada.nextLine();

            switch (escolha) {
                case "1":
                    return EnumLocais.RIO_DE_JANEIRO;
                case "2":
                    return EnumLocais.SAO_PAULO;
                case "3":
                    return EnumLocais.JOAO_PESSOA;
                case "4":
                    return EnumLocais.SALVADOR;
                case "5":
                    return EnumLocais.RECIFE;
                case "6":
                    return EnumLocais.FORTALEZA;
                default:
                    System.out.println("Essa Opcao Nao Existe!");
                    break;
            }
        }
            return null;
    }

    @Override
    public EnumClasseVoo selecionarClasseVoo() {
        boolean aux = true;
        while(aux) {
            Scanner entrada = new Scanner(System.in);
            System.out.println("Em que Tipo de Acento voce dejesa:");
            System.out.println("[1]- Economico/Normal");
            System.out.println("[2]- Executivo");
            System.out.println("[3]- Primeira Classe");

            String opcao = entrada.nextLine();

            switch (opcao) {
                case "1":
                    return EnumClasseVoo.NORMAL;
                case "2":
                    return EnumClasseVoo.EXECUTIVA;
                case "3":
                    return EnumClasseVoo.PRIMEIRA_CLASSE;
                default:
                    System.out.println("Opcao Inexistente");
                    break;

            }
        }
        return null;
    }

    @Override
    public String digitarCPF() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Digite seu Cpf: ");
        String name = entrada.nextLine();
        return name;
    }

    @Override
    public String digitarNome() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Digite seu nome: ");
        String cpf = entrada.nextLine();
        return cpf;
    }

    @Override
    public int qntTickets() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Quantos Ticketes voce dejesa?:");
        int qnt = entrada.nextByte();
        return qnt;

    }

    public String getId(){
        return this.id;
    }

    public EnumLocais getDesembarque() {
        return desembarque;
    }

    public EnumClasseVoo getClasseVoo() {
        return classeVoo;
    }

    @Override
    public String toString() {
        return "Informaçoes{" +
                "id='" + id + '\'' +
                ", tipoUsuario=" + tipoUsuario +
                ", tickets=" + tickets +
                ", desembarque=" + desembarque +
                ", classeVoo=" + classeVoo +
                '}';
    }
}
