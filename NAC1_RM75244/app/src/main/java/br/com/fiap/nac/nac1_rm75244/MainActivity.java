package br.com.fiap.nac.nac1_rm75244;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edtLogin;
    EditText edtSenha;
    CheckBox chkSalvar;

    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtLogin = findViewById(R.id.edtLogin);
        edtSenha = findViewById(R.id.edtSenha);
        chkSalvar = findViewById(R.id.chkSalvar);

        sp = getSharedPreferences("login", MODE_PRIVATE);

        if (sp.getBoolean("autenticado", false)) {
            edtLogin.setText(sp.getString("usuario", ""));
            edtSenha.setText(sp.getString("senha", ""));
            chkSalvar.setChecked(true);
        }

    }

    public void realizarLogin(View view) {
        String usuario = edtLogin.getText().toString();
        String senha = edtSenha.getText().toString();

        SharedPreferences.Editor editor = sp.edit();

        if (usuario.equalsIgnoreCase("FIAP") && senha.equals("123456")) {
            if (chkSalvar.isChecked()){
                editor.putString("usuario", usuario);
                editor.putString("senha", senha);
                editor.putBoolean("autenticado", true);
            } else {
                editor.putString("usuario", "");
                editor.putString("senha", "");
                editor.putBoolean("autenticado", false);
            }

            editor.commit();
            abrirConfiguracoes();
        } else {
            Toast.makeText(this, R.string.usuario_ou_senha_invalidos, Toast.LENGTH_SHORT).show();
        }
    }

    private void abrirConfiguracoes() {
        Intent it = new Intent(this, ConfiguracoesActivity.class);
        startActivity(it);
    }
}
