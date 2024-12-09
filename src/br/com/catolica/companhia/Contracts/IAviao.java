package br.com.catolica.companhia.Contracts;

import br.com.catolica.companhia.Enum.EnumAviaoModelos;
import br.com.catolica.companhia.Model.Cliente;

import java.util.ArrayList;

public interface IAviao {

    void escolherModelo();
    void realizarManutencao();
    void autorizarVoo();
}
