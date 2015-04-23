package br.edu.unisep.gerenciadorzotelp.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by ESutil on 21/04/2015.
 */
public class TarefaVO implements Serializable {

    private String titulo;

    private Date prazo;

    private String descricao;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Date getPrazo() {
        return prazo;
    }

    public void setPrazo(Date prazo) {
        this.prazo = prazo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
