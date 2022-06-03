package org.serratec.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;


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
	
}
