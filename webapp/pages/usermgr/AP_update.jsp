<%@ page import="com.wzc.login.domain.APmessage" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/app.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/subpage.css">
</head>
<body>
<%
	APmessage user = (APmessage)request.getAttribute("updateUser");
%>
<h1 class="callout">节点信息修改</h1>
<div>
	<form action="${pageContext.request.contextPath}/APmessageServlet?act=update" method="post" style="width:100%;text-align:center;">
		<input name="id" type="hidden" value='<%=user.getid() %>'>
        <table class="wzc-table">
			<tr>
                <th>名称</th>
                <td><input name="name" type="text" readonly value='<%=user.getname()==null?"":user.getname()%>'></td>
                <th>位置信息</th>
                <td><input name="address" type="text" value='<%=user.getAddress()==null?"":user.getAddress()%>'></td>
            </tr>
			<tr>
                <th>模型信息</th>
                <td><input name="model" type="text" value='<%=user.getModel()==null?"":user.getModel()%>'></td>
                <th>IP地址</th>
                <td><input name="ip" type="text" value='<%=user.getIp()==null?"":user.getIp()%>'></td>
            </tr>
			<tr>
                <th>组信息</th>
                <td><input name="groupmessage" type="text" value='<%=user.getGroupmessage()==null?"":user.getGroupmessage()%>'></td>
                <th>状态</th>
                <td><input name="state" type="text" value='<%=user.getState()==null?"":user.getState()%>'></td>
            </tr>
			
            <tr>
                <td colspan='2'><input name="sub" type="submit" value="修改" class="wzc-btn" style="width: 200px;"></td>
                <td colspan='2'><a href="${pageContext.request.contextPath}/APmessageServlet?act=select" class="wzc-btn" style="width: 200px;">返回</a></td>
            </tr>
		</table>
	</form>
</div>
<%
	Object resultMSG = request.getSession().getAttribute("resultMSG");
	if(resultMSG!=null){
%>
<script type="text/javascript">
    alert("<%=resultMSG.toString() %>")
</script>
<%
		request.getSession().removeAttribute("resultMSG");
	}
%>
</body>
</html>