/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author Medeiros
 */
public class UsuarioVO {
        private long id;
        private String nome, endereco, cidade, estado , email, doencas, idade, alergias;
        private int telefone, peso, cpf;
        private String sexo;
        private double altura;
        ArrayList<String> doenca = new ArrayList<>();

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
        ArrayList<String> alergia = new ArrayList<>();
    
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDoencas() {
        return doencas;
    }

    public void setDoencas(String doencas) {
        this.doencas = doencas;
    }

    public String getAlergias() {
        return alergias;
    }

    public void setAlergias(String alergias) {
        this.alergias = alergias;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }


    public double getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    @Override
    public String toString() {
        return "Dados cadastrados" + 
                "\n Nome: " + nome + 
                "\n Idade: " + idade +
                "\n Sexo: " + sexo + 
                "\n Peso: " + peso + 
                "\n Altura: " + altura +                 
                "\n Endereço: " + endereco + 
                "\n Cidade: " + cidade +
                "\n Estado: " + estado +
                "\n Email: " + email + 
                "\n Doenças: " + doencas +
                "\n Alergias: " + alergias + 
                "\n Telefone: " + telefone +
                "\n CPF: " + cpf +  '}';

    }
        
}
