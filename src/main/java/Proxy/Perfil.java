package Proxy;

import java.util.Arrays;
import java.util.List;

public class Perfil implements IPerfil {
    private String nome;
    private String statusRelacionamento;
    private String descricao;
    private Integer idade;
    private Integer fotos;

    public Perfil(Integer idade) {
        this.idade = idade;
        Perfil perfil = BD.getPerfil(idade);
        this.nome = perfil.nome;
        this.statusRelacionamento = perfil.statusRelacionamento;
        this.descricao = perfil.descricao;
        this.fotos = perfil.fotos;
    }

    public Perfil(String nome, String statusRelacionamento, String descricao, Integer idade, int fotos) {
        this.nome = nome;
        this.statusRelacionamento = statusRelacionamento;
        this.descricao = descricao;
        this.idade = idade;
        this.fotos = fotos;
    }

    public int getFotos() {
        return fotos;
    }

    public void setFotos(int fotos) {
        this.fotos = fotos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getStatusRelacionamento() {
        return statusRelacionamento;
    }

    public void setStatusRelacionamento(String statusRelacionamento) {
        this.statusRelacionamento = statusRelacionamento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    @Override
    public List<String> obterDadosPessoais() {
        return Arrays.asList(this.nome, this.descricao, this.statusRelacionamento);
    }

    @Override
    public List<Integer> obterFotos(Usuario usuario) {
        return Arrays.asList(this.fotos);
    }
}
