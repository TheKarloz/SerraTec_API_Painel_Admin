package org.serratec.exception;

import java.time.LocalDateTime;
import java.util.List;

public class ErroResposta {

    private Integer Status;
    private String titulo;
    private LocalDateTime dataHora;
    private List<String> errors;
      
    public ErroResposta(Integer status, String titulo, LocalDateTime dataHora, List<String> errors) {
        Status = status;
        this.titulo = titulo;
        this.dataHora = dataHora;
        this.errors = errors;
    }
    
    public Integer getStatus() {
        return Status;
    }
    public void setStatus(Integer status) {
        Status = status;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public LocalDateTime getDataHora() {
        return dataHora;
    }
    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }
    public List<String> getErrors() {
        return errors;
    }
    public void setErrors(List<String> errors) {
        this.errors = errors;
    }  
}
