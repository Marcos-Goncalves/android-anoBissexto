package com.app.bissextoactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void descobrir(View view){
        Intent intent = new Intent(getApplicationContext(), DescobrirActivity.class);
        intent.putExtra("nome", ((EditText)findViewById(R.id.idNome)).getText().toString());
        intent.putExtra("ano", Integer.parseInt(((EditText)findViewById(R.id.idAno)).getText().toString()));
        startActivity(intent);
    }
}