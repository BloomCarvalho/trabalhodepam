package com.example.pam1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

/* Peparatórios */

import android.widget.TextView;
import android.content.Intent;

/**/

public class ExibicaoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exibicao);

        /** Variaveis Visuais desta activity**/

        TextView txtNome     = findViewById(R.id.txtvwnome);
        TextView txtLido     = findViewById(R.id.txtvwlido);
        TextView txtAprovado = findViewById(R.id.txtvwaprovado);

        /**/

        //getIntent() pega a intent enviada da activity anterior para esta
        Intent mensageiro = getIntent();

        //getExtras(); pega os dados do mensageiro e insere no bundle (pacote)
        Bundle dados = mensageiro.getExtras();

        //dados.getString retorna a informação com o rótulo co locado entre parênteses
        txtNome.setText(dados.getString(MainActivity.NOMEDOLIVRO));
        //MainActivity. ultiliza as constantes criadas anteriormente no MainActivity
        txtLido.setText(dados.getString(MainActivity.LEITURA));

        txtAprovado.setText(dados.getString(MainActivity.APROVAÇÃO));
    }
}