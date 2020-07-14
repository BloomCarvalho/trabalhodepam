package com.example.pam1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

/** Importe de elementos visuais **/

import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.CheckBox;
import android.view.View;

// Aqui falamos para o java se preparar para o Intent
import android.content.Intent;

/**/


// Ignore desta linha para cima

public class MainActivity extends AppCompatActivity
{
    /* ⇓ Declaração de Variáveis Visuais ⇓*/
    EditText txtNomeDoLivro;

    CheckBox chkbLido;

    RadioButton rdbGostei;
    /* ⇑ ⇑*/


    public static final String APROVAÇÃO = "Aprovação" ;

    public static final String LEITURA = "Leitura" ;

    public static final String NOMEDOLIVRO = "NomeDoLivro" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        /* ⇓⇓ Inicialização de variáveis ⇓⇓ */
        txtNomeDoLivro = findViewById(R.id.txtnomedolivro);

        chkbLido = findViewById(R.id.chkblido);

        rdbGostei = findViewById(R.id.rdbgostei);
        /* ⇑⇑ */
    }

    // Tudo daqui para cima é executado quando o app abre

    /** Código de quando o usuário clica no botão enviar **/

    public void enviar(View v) // Ignore este 'View v'
    {
        //*essa variável está pegando o nome do livro e transformando em string**
        String textoDigitado = txtNomeDoLivro.getText().toString();

        //**começo da lógica**
        if (textoDigitado.isEmpty())
        { //esta variável passa a valer "nenhum" se a variável            textoDigitado estiver vazia**
            textoDigitado = "Nenhum";
        }

        // isChecked() vira true se a checkBox está checada.
        // isChecked() vira false se a checkBox não está checada.
        // estáCheckado = chkbLido.isChecked() equivale a se a chkblido está preenchida
        boolean estáCheckado = chkbLido.isChecked();


        String mensagemCheckBox;
        // Mensagem a ser exibida quanto à checkBox
        if (estáCheckado)
        {
            mensagemCheckBox = "Lido";
        }
        else
        {
            mensagemCheckBox = "Não Lido";
        }
        //**boolean radioButtonEstáChecada = rdbGostei.isChecked(); está tranformando o valor do cjecked de rdbGostei em booleano com t ou f
        boolean radioButtonEstáChecada = rdbGostei.isChecked();

        String mensagemRadioButton;

        if (radioButtonEstáChecada)
        {
            mensagemRadioButton = "Aprovado";
        }
        else
        {
            mensagemRadioButton  = "Não aprovado";
        }

        // Já temos os dados para serem enviados para a segunda activity.
        // Agora vamos criar um intent e um budle

        // Quando criamos um intent, devemos falar de onde ele vem, e para onde vai
        Intent sirIntent = new Intent(MainActivity.this, ExibicaoActivity.class);

        //Este código insere um rótulo entre "" na variável escolhida
        sirIntent.putExtra(NOMEDOLIVRO , textoDigitado);
        sirIntent.putExtra(LEITURA , mensagemCheckBox);
        sirIntent.putExtra(APROVAÇÃO , mensagemRadioButton);

        this.startActivity(sirIntent);
    }


    /**/
}