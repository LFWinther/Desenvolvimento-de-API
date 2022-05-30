package org.serratec.api.borracharia.service;

import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.hibernate.service.spi.ServiceException;
import org.serratec.api.borracharia.DTO.ServicoTDO;
import org.serratec.api.borracharia.exception.EmailException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

	@Component
	public class EmailService {
		
		@Value("${spring.mail.username}")
		private String userName;
		
		@Value("${spring.mail.host}")
		private String host;
		
		@Value("${spring.mail.password}")
		private String senha;

		@Autowired
		private JavaMailSender emailSender;
		
		
		private String emailRemetente = "renan.ribeiro15@hotmail.com";
		
		
		public JavaMailSender javaMailSender() {
		
		JavaMailSenderImpl enviarEmail = new JavaMailSenderImpl();
		Properties prop = new Properties();
		
		enviarEmail.setHost(host);
		enviarEmail.setPort(465);
		enviarEmail.setUsername(userName);
		enviarEmail.setPassword(senha);
		enviarEmail.setProtocol("smtp");
		enviarEmail.setDefaultEncoding("UTF-8");
		prop.put("mail.smtp.auth", true);
		prop.put("mail.smtp.ssl.enable", true);
		enviarEmail.setJavaMailProperties(prop);

		return enviarEmail;
		}
		
		public void sendMessage(String to, String subject, String text) {

			SimpleMailMessage message = new SimpleMailMessage();
			message.setFrom(userName);
			message.setTo(to);
			message.setSubject(subject);
			message.setText(text);
			emailSender.send(message);
		}
		
		public void emailTeste(ServicoTDO serviceDTO) throws EmailException, MessagingException, ServiceException {

	        this.emailSender = javaMailSender();
	        MimeMessage message = emailSender.createMimeMessage();
	        MimeMessageHelper helper = new MimeMessageHelper(message, true);
	        emailRemetente = serviceDTO.getCarro().getCliente().getEmail();
	        
	        try {
	            helper.setFrom(userName);
	            helper.setTo(emailRemetente);

	            helper.setSubject("Novo Cartão");

	            StringBuilder sBuilder = new StringBuilder();
	            sBuilder.append("<html>\r\n"
	                            + "<body>\r\n"
	                            +"<h1>Borracharia</h1>"
	                            +"\r\n<h3> Saudações " + serviceDTO.getCarro().getCliente().getNome() + ".</h3>" 
	                            +"<div>Relatório dos serviços prestados"
	                            +"\r\n ______________________________________________________________________"
	                            +"\r\nCARRO " 
	                            +"\r\n > Modelo: " + serviceDTO.getCarro().getModelo() 
	                            +"\r\n > Marca: " + serviceDTO.getCarro().getMarca()
	                            +"\r\n ______________________________________________________________________"
	                            +"\r\nSERVIÇO"
	                            +"\r\n > Descrição: " + serviceDTO.getServPrest()
	                            +"\r\n > Data: " + serviceDTO.getData()
	                            +"\r\n > Total: " + serviceDTO.getValor()
	                            +"Att: Equipe do banco Devendo a todos!!</div>"
	                            +"</body>"
	                            +"</html>");
	            helper.setText(sBuilder.toString(), true);
	            emailSender.send(message);
	        } catch (Exception e) {
	        	throw new EmailException("Houve erro ao enviar o email " + e.getMessage());
	        }
		}
}
