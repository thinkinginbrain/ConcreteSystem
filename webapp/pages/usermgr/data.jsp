<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" import="java.sql.*"%>
<%@ page import="com.wzc.login.domain.APmessage" %>
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
    <h1 class="callout">节点管理</h1>
    <h3><a href="${pageContext.request.contextPath}/pages/usermgr/APinsert.jsp" class="wzc-btn">添加节点</a></h3>
    <div class="" style="text-align:center;">
        <table class="wzc-table">
            <tr>
                <th>ID</th>
                <th>名称</th>
                <th>位置信息</th>
                <th>模型信息</th>
                <th>IP地址</th>
                <th>组信息</th>
                <th>状态</th>
                <!-- <th></th> -->
                <th>详情</th>
            </tr>
            <%
                List<APmessage> uList = (List<APmessage>)request.getAttribute("userList");
                if(uList==null){
                    request.getRequestDispatcher(request.getContextPath()+"/APmessageServlet?act=select").forward(request, response);
                }else{
                    for(APmessage user:uList){
            %>
            <tr>
                <td><%=user.getid()%></td>
                <td><%=user.getname()==null?"":user.getname()%></td>
                <td><%=user.getAddress()==null?"":user.getAddress()%></td>
                <td><%=user.getModel()==null?"":user.getModel()%></td>
                <td><%=user.getIp()==null?"":user.getIp()%></td>
                <td><%=user.getGroupmessage()==null?"":user.getGroupmessage()%></td>
                <td><%=user.getState()==null?"":user.getState()%></td>

                <td><a href="${pageContext.request.contextPath}/APmessageServlet?act=toUpdatePage&userid=<%=user.getid()%>" style="margin:0 10px;">
                    <i class="fa fa-edit fa-fw"></i> 修改</a>
                    <a href="${pageContext.request.contextPath}/APmessageServlet?act=delete&userid=<%=user.getid()%>">
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
