<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/app.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/subpage.css">
</head>
<body>
<h1 class="callout">新增模型信息</h1>
<div class="">
	<form action="${pageContext.request.contextPath}/ModelServlet?act=insert" method="post" style="width:100%;text-align:center;">
        <table class="wzc-table">
            <tr>
                <th>模型名</th>
                <td><input name="name" type="text" ></td>
              
            </tr>
            <tr>
                <th>模型信息</th>
                <td colspan="3">
                    <textarea name="message"  rows="3" ></textarea>
                </td>
            </tr>
            <tr>
                <td colspan='2'><input name="sub" type="submit" value="添加" class="wzc-btn" style="width: 200px;"></td>
                <td colspan='2'><a href="${pageContext.request.contextPath}/ModelServlet?act=select" class="wzc-btn" style="width: 200px;">返回</a></td>
            </tr>
        </table>
	</form>
</div>

<%
	Object resultMSG = request.getSession().getAttribute("resultMSG");
	if(resultMSG!=null){
%><script type="text/javascript">alert("<%=resultMSG.toString() %>")</script><%
		request.getSession().removeAttribute("resultMSG");
	}
%>
</body>
</html>