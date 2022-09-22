package com.app.bissextoactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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
    }

    public void bissexto(){
        if(ano % 100 == 0 && ano % 400 == 0 || ano % 100 != 0 && ano % 4 == 0){
            ((TextView)findViewById(R.id.idResultado)).setText(ano + " é bissexto!");
        }else {
            ((TextView)findViewById(R.id.idResultado)).setText(ano + " não é bissexto!");
        }
    }
}