package br.com.fiap.nac.nac1_rm75244;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class ConfiguracoesActivity extends AppCompatActivity {

    LinearLayout llPrincipal;
    RadioGroup rdgOpcoes;
    RadioButton rdbVermelho;
    RadioButton rdbAzul;
    RadioButton rdbVerde;

    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracoes);

        llPrincipal = findViewById(R.id.llPrincipal);
        rdgOpcoes = findViewById(R.id.rdgOpcoes);
        rdbVermelho = findViewById(R.id.rdbVermelho);
        rdbAzul = findViewById(R.id.rdbAzul);
        rdbVerde = findViewById(R.id.rdbVerde);

        sp = getSharedPreferences("configuracoes", MODE_PRIVATE);

        int corSalva = sp.getInt("cor", Color.WHITE);

        llPrincipal.setBackgroundColor(corSalva);

        switch (corSalva){
            case Color.RED:
                rdbVermelho.setChecked(true);
                break;
            case Color.GREEN:
                rdbVerde.setChecked(true);
                break;
            case Color.BLUE:
                rdbAzul.setChecked(true);
                break;
            default:
                break;
        }

        rdgOpcoes.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.rdbVermelho:
                        llPrincipal.setBackgroundColor(Color.RED);
                        break;
                    case R.id.rdbVerde:
                        llPrincipal.setBackgroundColor(Color.GREEN);
                        break;
                    case R.id.rdbAzul:
                        llPrincipal.setBackgroundColor(Color.BLUE);
                        break;
                    default:
                        llPrincipal.setBackgroundColor(Color.WHITE);
                        break;
                }
            }
        });
    }

    public void salvarConfiguracoes(View view) {
        int selecionado = rdgOpcoes.getCheckedRadioButtonId();

        SharedPreferences.Editor editor = sp.edit();

        switch (selecionado) {
            case R.id.rdbVermelho:
                editor.putInt("cor", Color.RED);
                break;
            case R.id.rdbVerde:
                editor.putInt("cor", Color.GREEN);
                break;
            case R.id.rdbAzul:
                editor.putInt("cor", Color.BLUE);
                break;
            default:
                editor.putInt("cor", Color.WHITE);
                break;
        }

        editor.commit();
        Toast.makeText(this, R.string.configuracoes_alteradas_com_sucesso, Toast.LENGTH_SHORT).show();
    }
}
