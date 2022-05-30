package org.serratec.api.EcommercApi.service;

import java.util.Optional;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.serratec.api.EcommercApi.DTO.PedidoDTO;
import org.serratec.api.EcommercApi.exception.EmailException;
import org.serratec.api.EcommercApi.exception.PedidoException;
import org.serratec.api.EcommercApi.model.Pedido;
import org.serratec.api.EcommercApi.repository.ClienteRepository;
import org.serratec.api.EcommercApi.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

public class EmailService {

	@Value("${spring.mail.username}")
	private String userName;
	
	@Value("${spring.mail.host}")
	private String host;
	
	@Value("${spring.mail.password}")
	private String senha;

	@Autowired
	private JavaMailSender emailSender;
	
	@Autowired
	ClienteRepository clienteRepository;
	
	@Autowired
	PedidoRepository pedidoRepository;
	
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
	
	public void emailTeste(PedidoDTO pedidoDTO) throws EmailException, MessagingException, PedidoException {

        this.emailSender = javaMailSender();
        MimeMessage message = emailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        
		Optional<Pedido> pedidoOptional = pedidoRepository.findById(pedidoDTO.getIdCliente());
		Pedido pedido = new Pedido();
		if(pedidoOptional.isPresent()) {
			pedido = pedidoOptional.get();
		}

        try {
            helper.setFrom(userName);
            helper.setTo(emailRemetente);

            helper.setSubject("Novo Cartão");

            StringBuilder sBuilder = new StringBuilder();
            sBuilder.append("<html>\r\n"
                            + "<body>\r\n"
                            +"<h1>NOME DA LOJA</h1>"
                            +"<h2>Compra finalizada com sucesso</h2>"
                            +"<div>\r\nSegue as informações da compra:\r\n"
                            +"\r\n PRODUTOS: \n" + pedido.getCliente().getListaProduto()
                            +"<div>\r\nValor todal: " + pedido.getValorTotal()
                            +"Att: Equipe do EcommercAPI!!</div>"
                            +"</body>"
                            +"</html>");
            helper.setText(sBuilder.toString(), true);
            emailSender.send(message);
        } catch (Exception e) {
        	throw new EmailException ("Houve erro ao enviar o email " + e.getMessage());
        }
	}
}
