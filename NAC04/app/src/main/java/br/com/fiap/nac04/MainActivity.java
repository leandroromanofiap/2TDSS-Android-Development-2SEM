package br.com.fiap.nac04;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView lstClientes;
    List<Cliente> clientes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lstClientes = findViewById(R.id.lstClientes);

        clientes = new Banco(this).getAll();

        ClienteAdapter adapter = new ClienteAdapter(this, clientes);

        lstClientes.setAdapter(adapter);
    }
}
