package br.com.catolica.companhia.Contracts;

import br.com.catolica.companhia.Enum.EnumClasseVoo;
import br.com.catolica.companhia.Enum.EnumLocais;

import java.util.ArrayList;
import java.util.Map;

public interface ICliente {

    EnumLocais comprarTickets();
    EnumClasseVoo selecionarClasseVoo();
    String digitarCPF();
    String digitarNome();
    int qntTickets();
}
