package br.com.fiap.a02_exercicio;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sp = getSharedPreferences("configuracoes", MODE_PRIVATE);

        boolean exibir = sp.getBoolean("checkado", true);
        int tempo = sp.getInt("tempo", 10000);

        if (exibir) {
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    abrirDashboard();
                }
            }, tempo);
        } else {
            abrirDashboard();
        }
    }

    public void abrirConfiguracoes(View view) {
        Intent it = new Intent(this, ConfiguracoesActivity.class);
        startActivity(it);
    }

    private void abrirDashboard(){
        Intent it = new Intent(MainActivity.this, DashboardActivity.class);
        startActivity(it);
    }
}
