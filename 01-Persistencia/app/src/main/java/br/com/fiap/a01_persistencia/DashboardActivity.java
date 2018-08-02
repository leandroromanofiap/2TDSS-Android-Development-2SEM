package br.com.fiap.a01_persistencia;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class DashboardActivity extends AppCompatActivity {

    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        sp = getSharedPreferences("login", MODE_PRIVATE);
    }

    public void logout(View view) {
        SharedPreferences.Editor edit = sp.edit();
        edit.remove("usuario");
        edit.remove("senha");
        edit.remove("conectado");
        edit.commit();
        finish();
    }
}
