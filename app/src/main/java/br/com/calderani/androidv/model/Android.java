package br.com.calderani.androidv.model;

/**
 * Created by logonrm on 21/06/2017.
 */

public class Android {
    private String versao;
    public String getVersao() { return versao;}
    public void setVersao(String versao) { this.versao = versao; }

    private String nome;
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    private String api;
    public String getApi() { return api; }
    public void setApi(String api) { this.api = api; }

    private String urlImagem;
    public String getUrlImagem() { return urlImagem; }
    public void setUrlImagem(String urlImagem) { this.urlImagem = urlImagem; }
}
