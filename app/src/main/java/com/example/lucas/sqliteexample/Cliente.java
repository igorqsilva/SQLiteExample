package com.example.lucas.sqliteexample;

/**
 * Created by Lucas on 17-May-17.
 */

public class Cliente
{
    int codigo;
    String nome;
    String telefone;
    String email;


    public Cliente (){
    //Construtor Vazio


    }

    public Cliente (int _codigo, String _nome, String _telefone, String _email){
        //Criar

        this.codigo = _codigo;
        this.nome = _nome;
        this.telefone = _telefone;
        this.email = _email;

    }


    public Cliente (String _nome, String _telefone, String _email){
        //Atualizar

        this.nome = _nome;
        this.telefone = _telefone;

        this.email = _email;

    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }






}
