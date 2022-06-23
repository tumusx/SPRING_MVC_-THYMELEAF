package br.ifg.model.entities;


import java.util.Objects;

public class Convidado {
    private long idConvidado;
    private String nomeConvidado;
    private String tipoConvidado;
    private int qntdAcompanhantes;

    public Convidado(int idConvidado, String nomeConvidado, String tipoConvidado, int qntdAcompanhantes) {
        this.idConvidado = idConvidado;
        this.nomeConvidado = nomeConvidado;
        this.tipoConvidado = tipoConvidado;
        this.qntdAcompanhantes = qntdAcompanhantes;
    }

    public void setIdConvidado(long idConvidado) {
        this.idConvidado = idConvidado;
    }

    public Convidado() {
        super();
    }

    public long getIdConvidado() {
        return idConvidado;
    }

    public String getNomeConvidado() {
        return nomeConvidado;
    }

    public void setNomeConvidado(String nomeConvidado) {
        this.nomeConvidado = nomeConvidado;
    }

    public String getTipoConvidado() {
        return tipoConvidado;
    }

    public void setTipoConvidado(String tipoConvidado) {
        this.tipoConvidado = tipoConvidado;
    }

    public int getQntdAcompanhantes() {
        return qntdAcompanhantes;
    }

    public void setQntdAcompanhantes(int qntdAcompanhantes) {
        this.qntdAcompanhantes = qntdAcompanhantes;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Convidado convidado)) return false;
        return getIdConvidado() == convidado.getIdConvidado() && getNomeConvidado().equals(convidado.getNomeConvidado()) && Objects.equals(getTipoConvidado(), convidado.getTipoConvidado());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdConvidado(), getNomeConvidado(), getTipoConvidado(), getQntdAcompanhantes());
    }
}
