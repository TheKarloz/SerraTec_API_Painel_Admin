package org.serratec.config;


import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;


@Configuration
public class MailConfig {
	
	@Autowired
	private JavaMailSender javaMailSender;
		

	public void enviarEmail(String para, String assunto, String nome, String texto) {
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

		simpleMailMessage.setFrom("grupo2.serratec.api@gmail.com");
		simpleMailMessage.setTo(para);
		simpleMailMessage.setSubject(assunto);
		simpleMailMessage.setText("Olá, " + nome + " Obrigado por se cadastrar em nossa loja!\n\n\n"
		+ texto +
		"\n\nAtenciosamente\nLoja de Calçados");
		javaMailSender.send(simpleMailMessage);
	}

	public void enviarEmailHTML(String para, String assunto,String texto) throws MessagingException{
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, "utf-8");
		
		
		mimeMessageHelper.setTo(para);
		mimeMessageHelper.setSubject(assunto);
		mimeMessageHelper.setText(texto, true);
		
		mimeMessageHelper.setFrom("grupo2.serratec.api@gmail.com");
		
		javaMailSender.send(mimeMessage);
	}
}
