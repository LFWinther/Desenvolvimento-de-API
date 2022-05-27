package org.serratec.backend.projeto05.clienteService;

import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.serratec.backend.projeto05.DTO.CartaoDTO;
import org.serratec.backend.projeto05.exception.CartaoExcpetion;
import org.serratec.backend.projeto05.exception.EmailExecption;
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
	
	
	private final String emailRemetente = "renan.ribeiro15@hotmail.com";
	
	
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
	
	public void emailTeste(CartaoDTO cartaoDTO) throws EmailExecption, MessagingException, CartaoExcpetion {

        this.emailSender = javaMailSender();
        MimeMessage message = emailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        
        try {
            helper.setFrom(userName);
            helper.setTo(emailRemetente);

            helper.setSubject("Novo Cartão");

            StringBuilder sBuilder = new StringBuilder();
            sBuilder.append("<html>\r\n"
                            + "<body>\r\n"
                            +"<h1>Cartão criado com sucesso</h1>"
                            +"<div>\r\nSegue os dados do cartão:\r\n"
                            +"<div>\r\n nome: " + cartaoDTO.getNomeTitular()+" \r\n"
                            +"<div>\r\n numero: " + cartaoDTO.getNumero() +" \r\n"
                            +"Att: Equipe do banco Devendo a todos!!</div>"
                            +"</body>"
                            +"</html>");
            helper.setText(sBuilder.toString(), true);
            emailSender.send(message);
        } catch (Exception e) {
        	throw new EmailExecption("Houve erro ao enviar o email " + e.getMessage());
        }
	}
	
}
