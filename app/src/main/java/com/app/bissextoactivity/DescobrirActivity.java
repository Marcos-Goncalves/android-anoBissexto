package com.app.bissextoactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class DescobrirActivity extends AppCompatActivity {
    private String nome;
    private int ano;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descobrir);

        nome = getIntent().getStringExtra("nome");
        ano = getIntent().getIntExtra("ano", 0);

        ((TextView)findViewById(R.id.idNome)).setText(nome);
        ((TextView)findViewById(R.id.idAno)).setText(String.valueOf(ano));

        bissexto();
    }

    public boolean bissexto(){
        if(ano % 100 == 0 && ano % 400 == 0 || ano % 100 != 0 && ano % 4 == 0){
            ((TextView)findViewById(R.id.idResultado)).setText(ano + " é bissexto!");
            return true;
        }else {
            ((TextView)findViewById(R.id.idResultado)).setText(ano + " não é bissexto!");
            return false;
        }
    }

    public void compartilhar(View view){
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_SUBJECT, ("Ano bissexto!"));
        if(bissexto() == true) {
            intent.putExtra(Intent.EXTRA_TEXT, (nome + ", o ano " + ano + " é um ano bissexto!"));
        } else {
            intent.putExtra(Intent.EXTRA_TEXT, (nome + ", o ano " + ano + " não é um ano bissexto!"));
        }
        intent.setType("text/plain");
        startActivity(Intent.createChooser(intent, "Compartilhando com ..."));
    }
}