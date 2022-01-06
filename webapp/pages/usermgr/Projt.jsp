<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" import="java.sql.*"%>
<%@ page import="com.wzc.login.domain.Project" %>
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
    <h1 class="callout">项目管理</h1>
    <h3><a href="${pageContext.request.contextPath}/pages/usermgr/project_insert_true.jsp" class="wzc-btn">添加项目</a></h3>
    <div class="" style="text-align:center;">
        <table class="wzc-table">
            <tr>
                <th>ID</th>
                <th>昵称</th>
                <th>用户名</th>
                <th>模型</th>
                <th>操作</th>
            </tr>
            <%
                List<Project> uList = (List<Project>)request.getAttribute("userList");
                if(uList==null){
                    request.getRequestDispatcher(request.getContextPath()+"ProjectServlet?act=select").forward(request, response);
                }else{
                    for(Project user:uList){
            %>
            <tr>
                <td><%=user.getid()%></td>
                <td><%=user.getUser()==null?"":user.getUser()%></td>
                <td><%=user.getName()==null?"":user.getName()%></td>
                <td><%=user.getModel()==null?"":user.getModel()%></td>
                <td><a href="${pageContext.request.contextPath}/ProjectServlet?act=toUpdatePage&id=<%=user.getid()%>" style="margin:0 10px;">
                    <i class="fa fa-edit fa-fw"></i> 修改</a>
                    <a href="${pageContext.request.contextPath}/ProjectServlet?act=delete&userid=<%=user.getid()%>">
                        <i class="fa fa-trash fa-fw"></i> 删除</a>
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
