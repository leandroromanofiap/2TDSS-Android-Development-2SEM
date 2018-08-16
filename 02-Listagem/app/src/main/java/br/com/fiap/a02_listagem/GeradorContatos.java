package br.com.fiap.a02_listagem;

import java.util.ArrayList;
import java.util.List;

public class GeradorContatos {

    public static List<Contato> gerarContatos() {
        List<Contato> contatos = new ArrayList<>();

        Contato contato1 = new Contato("João", "(11) 1111-1111", "Desempregado", R.drawable.p1);
        Contato contato2 = new Contato("Camila", "(11) 2222-2222", "Brava com o João", R.drawable.p2);

        contatos.add(contato1);
        contatos.add(contato2);

        return contatos;
    }

}
