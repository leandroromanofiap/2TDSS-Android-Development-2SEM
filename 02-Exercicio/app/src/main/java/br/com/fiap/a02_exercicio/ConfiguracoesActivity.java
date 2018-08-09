package br.com.fiap.a02_exercicio;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Toast;

public class ConfiguracoesActivity extends AppCompatActivity {

    CheckBox chkExibirSplash;
    SeekBar skbTempo;
    Spinner spnCorDeFundo;

    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracoes);

        chkExibirSplash = findViewById(R.id.chkSplash);
        skbTempo = findViewById(R.id.skbTempo);
        spnCorDeFundo = findViewById(R.id.spnCorDeFundo);

        sp = getSharedPreferences("configuracoes", MODE_PRIVATE);

        boolean checado = sp.getBoolean("checkado", true);
        chkExibirSplash.setChecked(checado);

        int tempo = sp.getInt("tempo", 10000);
        skbTempo.setProgress(tempo);
    }

    public void salvarConfiguracoes(View view) {
        SharedPreferences.Editor editor = sp.edit();

        boolean checado = chkExibirSplash.isChecked();
        int tempo = skbTempo.getProgress();

        editor.putBoolean("checkado", checado);
        editor.putInt("tempo", tempo);

        editor.commit();

        Toast.makeText(this, R.string.config_success, Toast.LENGTH_SHORT).show();

        finish();
    }
}
