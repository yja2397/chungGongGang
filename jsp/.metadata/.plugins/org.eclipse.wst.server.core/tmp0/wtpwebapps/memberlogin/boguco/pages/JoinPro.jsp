<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
 
<%request.setCharacterEncoding("UTF-8");
//�ѱ� ���� ������ ���� �ڵ�.
%>


<html>
<head>
 <link href="../layout/styles/layout.css" rel="stylesheet" type="text/css" media="all">
<meta charset="EUC-KR">
<title>������ ���ϵ帳�ϴ�!</title>
</head>
<body>
 <% 
        // getParameter()�� �̿��� �Ѱ��� �Ķ���� ���� ���� �� �ִ�.
        // �Ķ���� ���� ������ name= �� �����ص� ���� ������ ���� ���ڷ� �����ؾ� �ȴ�.
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String birthday = request.getParameter("birthday");
        String subject = request.getParameter("subject");
    %>
    
       <div id="wrap">
        <br><br>
        <b><font size="5" color="gray">ȸ������ ������ Ȯ���ϼ���.</font></b>
        <br><br>
        <font color="blue"><%=name %></font>�� ������ ���ϵ帳�ϴ�.
        <br><br>
        
        <table>
            <tr>
                <td id="title">���̵�</td>
                <td><%=id %></td>
            </tr>
                        
            <tr>
                <td id="title">��й�ȣ</td>
                <td><%=password %></td>
            </tr>
                    
            <tr>
                <td id="title">�̸�</td>
                <td><%=name %></td>
            </tr>

                    
            <tr>
                <td id="title">����</td>
                <td><%=birthday %></td>
            </tr>
                    
            <tr>
                <td id="title">�̸���</td>
                <td><%=email %></td>
            </tr>
                    
            <tr>
                <td id="title">�޴���ȭ</td>
                <td><%=phone %></td>
            </tr>
            <tr>
                <td id="title">��̻���</td>
                <td>
               
                <%=subject %>
                  
                </td>
            </tr>
        </table>
        
        <br>
        <input type="button" value="Ȯ��">
    </div>


��ó: http://all-record.tistory.com/109?category=733042 [������ ��� ���]
    
    
    

	
	
</body>
</html>