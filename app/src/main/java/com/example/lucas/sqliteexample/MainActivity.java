package com.example.lucas.sqliteexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    EditText editCodigo, editNome, editTelefone, editEmail;
    Button btnLimpar, btnSalvar, btnExcluir;
    ListView listViewClientes;


    Banco db = new Banco(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editCodigo = (EditText)findViewById(R.id.editCodigo);
        editNome = (EditText)findViewById(R.id.editNome);
        editTelefone = (EditText)findViewById(R.id.editPhone);
        editEmail = (EditText)findViewById(R.id.editEmail);

        btnLimpar = (Button)findViewById(R.id.btnLimpar);
        btnExcluir = (Button)findViewById(R.id.btnExcluir);
        btnSalvar= (Button)findViewById(R.id.btnSalvar);

        listViewClientes = (ListView)findViewById(R.id.listViewClientes);

        db.addCliente(new Cliente());
    }

    public void salvarCliente(View view){
    Toast.makeText(MainActivity.this,"Cliente Salvo com sucesso", Toast.LENGTH_LONG).show();

    }




}


