package br.com.fiap.a01_persistencia;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class DashboardActivity extends AppCompatActivity {

    EditText edtInfo;

    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        edtInfo = findViewById(R.id.edtInfo);

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

    public void lerArquivo(View view) {
        try {
            FileInputStream fis = openFileInput("bd.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(fis));
            String txt = br.readLine();
            edtInfo.setText(txt);
        } catch (java.io.IOException e) {
            Toast.makeText(this, R.string.msg_erro_recuperar_arquivo, Toast.LENGTH_SHORT).show();
        }
    }

    public void salvarArquivo(View view) {
        try {
            FileOutputStream fos = openFileOutput("bd.txt", MODE_PRIVATE);
            String txt = edtInfo.getText().toString();
            fos.write(txt.getBytes());
            fos.close();
        } catch (java.io.IOException e) {
            Toast.makeText(this, R.string.msg_erro_gravar_arquivo, Toast.LENGTH_SHORT).show();
        }
    }
}
