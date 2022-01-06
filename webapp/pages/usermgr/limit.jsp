<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" import="java.sql.*"%>
<%@ page import="com.wzc.login.domain.Limit" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title></title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/app.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/font-awesome-4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/subpage.css">
</head>
<body>
    <div class="" style="text-align:center;">
        <table class="wzc-table">
            <tr>
                <th>ID</th>
                <th>用户名</th>
                <th>权限</th>
                <th>操作</th>
            </tr>
            <%
                List<Limit> uList = (List<Limit>)request.getAttribute("userList");
                if(uList==null){
                    request.getRequestDispatcher(request.getContextPath()+"/LimitServlet?act=select").forward(request, response);
                }else{
                    for(Limit user:uList){
            %>
            <tr>
                <td><%=user.getId()%></td>
                <td><%=user.getName()==null?"":user.getName()%></td>
                <td><%=user.getLimit()==null?"":user.getLimit()%></td>
                <td><a href="${pageContext.request.contextPath}/LimitServlet?act=toUpdatePage&userid=<%=user.getId()%>" style="margin:0 10px;">
                    <i class="fa fa-edit fa-fw"></i> 设置权限（默认权限：simple(一般用户),root：管理员）</a>
                   
                </td>
            </tr>
            <%}} %>
        </table>
        <%
            Object resultMSG = request.getSession().getAttribute("resultMSG");
            if(resultMSG!=null){
        %><script type="text/javascript">alert("<%=resultMSG.toString() %>")</script><%
                request.getSession().removeAttribute("resultMSG");
            }
        %>
    </div>
</body>
</html>
