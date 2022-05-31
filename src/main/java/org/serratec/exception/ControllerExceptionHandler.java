package org.serratec.exception;

import javax.validation.constraints.Email;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler{

    @ExceptionHandler(EmailException.class)
    public ResponseEntity<Object> handleEmailException(EmailException ex){
        EmailException emailException = new EmailException(ex.getMessage());
        return ResponseEntity.unprocessableEntity().body(emailException);
    }

    public ResponseEntity<Object> handleCpfException(CpfException ex){
        CpfException cpfException = new CpfException(ex.getMessage());
        return ResponseEntity.unprocessableEntity().body(cpfException);
    }


    
    
    
}
    
