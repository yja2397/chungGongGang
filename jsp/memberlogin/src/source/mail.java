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

//출처: http://fruitdev.tistory.com/15 [과일가게 개발자]
public class mail {
    public static void main(String[] args) {
        String htmltext = ""
                + "<html>"+"<h1>충남대학교 공지 갱신사이트!</h1>"+"<p>회원님 반갑습니다.</p>"+"<p>회원님께서 작성하신 키워드가 포함된 공지사항이 갱신되었습니다.</p>"+"<p><a href=\"++여기에 링크 걸기!\">공지사항 확인하기!</a></p>\r\n" +
                        "<p>----------------------------------------------</p>"+"<a href=\"++여기에 링크 걸기!\" style=\"font-size:10px\">충공갱 바로가기</a>"+"<p>메일 수신을 원하지 않으시면 <a href=\"\" style=\"font-weight=bold\">여기</a></p>";

        // 항목

        Properties p = System.getProperties();
        p.put("mail.smtp.starttls.enable", "true"); // gmail은 무조건 true 고정
        p.put("mail.smtp.host", "smtp.gmail.com"); // smtp 서버 주소
        p.put("mail.smtp.auth", "true"); // gmail은 무조건 true 고정
        p.put("mail.smtp.port", "587"); // gmail 포트

        Authenticator auth = new MyAuthentication();

        Session session = Session.getDefaultInstance(p, auth);

        MimeMessage msg = new MimeMessage(session);
        try {
            // 편지보낸시간
            msg.setSentDate(new Date());
            InternetAddress from = new InternetAddress();

            from = new InternetAddress("test<test@gmail.com>");
            // 이메일 발신자
            msg.setFrom(from);
            // 이메일 수신자
            InternetAddress to = new InternetAddress("yja2397@gmail.com");
            msg.setRecipient(Message.RecipientType.TO, to);
            // 이메일 제목
            msg.setSubject("<<충남대학교 공지 갱신사이트 키워드 알림 발송>>", "UTF-8");
            // 이메일 내용
            msg.setText("내용", "UTF-8");
            msg.setContent(htmltext, "text/html; charset=utf-8");
            // 이메일 헤더
            msg.setHeader("content-Type", "text/html");

            // 메일보내기
            javax.mail.Transport.send(msg);
            System.out.println("보내졌어요!");

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

        String id = "dbwjddus1997@gmail.com"; // 구글 ID
        String pw = "gh06090730"; // 구글 비밀번호

        // ID와 비밀번호를 입력한다.
        pa = new PasswordAuthentication(id, pw);

    }

    // 시스템에서 사용하는 인증정보
    public PasswordAuthentication getPasswordAuthentication() {
        return pa;
    }
}