package source;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

//��ó: http://fruitdev.tistory.com/15 [���ϰ��� ������]
public class mail {
	public static void main(String[] args) {
		String htmltext = ""
				+ "<html>"+"<h1>�泲���б� ���� ���Ż���Ʈ!</h1>"+"<p>ȸ���� �ݰ����ϴ�.</p>"+"<p>ȸ���Բ��� �ۼ��Ͻ� Ű���尡 ���Ե� ���������� ���ŵǾ����ϴ�.</p>"+"<p><a href=\"++���⿡ ��ũ �ɱ�!\">�������� Ȯ���ϱ�!</a></p>\r\n" + 
						"<p>----------------------------------------------</p>"+"<a href=\"++���⿡ ��ũ �ɱ�!\" style=\"font-size:10px\">����� �ٷΰ���</a>"+"<p>���� ������ ������ �����ø� <a href=\"\" style=\"font-weight=bold\">����</a></p>";

		// �׸�

		Properties p = System.getProperties();
		p.put("mail.smtp.starttls.enable", "true"); // gmail�� ������ true ����
		p.put("mail.smtp.host", "smtp.gmail.com"); // smtp ���� �ּ�
		p.put("mail.smtp.auth", "true"); // gmail�� ������ true ����
		p.put("mail.smtp.port", "587"); // gmail ��Ʈ

		Authenticator auth = new MyAuthentication();

		Session session = Session.getDefaultInstance(p, auth);

		MimeMessage msg = new MimeMessage(session);
		try {
			// ���������ð�
			msg.setSentDate(new Date());
			InternetAddress from = new InternetAddress();

			from = new InternetAddress("test<test@gmail.com>");
			// �̸��� �߽���
			msg.setFrom(from);
			// �̸��� ������
			InternetAddress to = new InternetAddress("wnqusdml11@naver.com");
			msg.setRecipient(Message.RecipientType.TO, to);
			// �̸��� ����
			msg.setSubject("<<�泲���б� ���� ���Ż���Ʈ Ű���� �˸� �߼�>>", "UTF-8");
			// �̸��� ����
			msg.setText("����", "UTF-8");
			msg.setContent(htmltext, "text/html; charset=utf-8");
			// �̸��� ���
			msg.setHeader("content-Type", "text/html");

			// ���Ϻ�����
			javax.mail.Transport.send(msg);
			System.out.println("���������!");

		} catch (AddressException addr_e) {
			addr_e.printStackTrace();
		} catch (MessagingException msg_e) {
			msg_e.printStackTrace();
		}

	}

}

class MyAuthentication extends Authenticator {

	PasswordAuthentication pa;

	public MyAuthentication() {

		String id = "dbwjddus1997@gmail.com"; // ���� ID
		String pw = "gh06090730"; // ���� ��й�ȣ

		// ID�� ��й�ȣ�� �Է��Ѵ�.
		pa = new PasswordAuthentication(id, pw);

	}

	// �ý��ۿ��� ����ϴ� ��������
	public PasswordAuthentication getPasswordAuthentication() {
		return pa;
	}
}
