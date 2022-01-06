<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" import="java.sql.*"%>
<%@ page import="com.wzc.login.domain.Logintime" %>
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
                <th>登录时间</th>
                <th>登出时间</th>

            </tr>
            <%
                List<Logintime> uList = (List<Logintime>)request.getAttribute("logList");
                if(uList==null){
                    request.getRequestDispatcher(request.getContextPath()+"/LogServlet?act=select").forward(request, response);
                }else{
                    for(Logintime user:uList){
            %>
            <tr>
                <td><%=user.getUserid()%></td>
                <td><%=user.getUsername()==null?"":user.getUsername()%></td>
                <td><%=user.getLoginTime()==null?"":user.getLoginTime()%></td>
                <td><%=user.getLogoutTime()==null?"":user.getLogoutTime()%></td>
             <%--    <td><a href="${pageContext.request.contextPath}/UserServlet?act=toUpdatePage&userid=<%=user.getUserid()%>" style="margin:0 10px;">
                    <i class="fa fa-edit fa-fw"></i> 修改</a>
                    <a href="${pageContext.request.contextPath}/UserServlet?act=delete&userid=<%=user.getUserid()%>">
                        <i class="fa fa-trash fa-fw"></i> 删除</a>
                </td> --%>
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
