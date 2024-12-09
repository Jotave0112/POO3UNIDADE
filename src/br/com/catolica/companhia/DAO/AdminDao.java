package br.com.catolica.companhia.DAO;


import br.com.catolica.companhia.Contracts.IAdminDAO;
import br.com.catolica.companhia.Enum.EnumTipoUsuario;
import br.com.catolica.companhia.Model.Funcionario;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AdminDao extends Funcionario implements IAdminDAO {

    public static ArrayList<Map<String,String>> bcContaAdm = new ArrayList<>();

    public AdminDao(EnumTipoUsuario tipo,String senhaAdm, String userAdm) {
        super(tipo, senhaAdm, userAdm);

    }

    @Override
    public Map<String, String> cadastroAdmin() {
        Map<String, String> dados = new HashMap<>();

        for (Map<String, String> map : bcContaAdm) {
            if (map.containsKey(getSenhaAdm())) {
                System.out.println("A senha Ja existe!");
            }
        }

        dados.put(getSenhaAdm(), getUserAdm());
        return dados;
    }


}
