package org.serratec.exception;

import java.util.List;

public class ErroResposta {

    private Integer status;
    private String titulo;
    private String dataHora;
    private List<String> errors;
      
    public ErroResposta(Integer status, String titulo, String dataHora) {
        this.status = status;
        this.titulo = titulo;
        this.dataHora = dataHora;
    }

    public ErroResposta(Integer status, String titulo, String dataHora, List<String> errors) {
		this.status = status;
        this.titulo = titulo;
        this.dataHora = dataHora;
        this.errors = errors;
	}

    public ErroResposta(){
        
    }

    public Integer getStatus() {
        return status;
    }
    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getDataHora() {
        return dataHora;
    }
    public void setDataHora(String dataHora) {
        this.dataHora = dataHora;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }
}
