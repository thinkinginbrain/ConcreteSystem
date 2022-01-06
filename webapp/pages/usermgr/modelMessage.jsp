<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" import="java.sql.*"%>
<%@ page import="com.wzc.login.domain.Model" %>
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
    <h1 class="callout">模型管理</h1>
    <h3><a href="${pageContext.request.contextPath}/pages/usermgr/insert_model.jsp" class="wzc-btn">添加模型</a></h3>
    <div class="" style="text-align:center;">
        <table class="wzc-table">
            <tr>
                <th>ID</th>
                <th>模型名称</th>
                <th>模型信息</th>
  <!--               <th>密码</th>
                <th>性别</th>
                <th>手机号</th>
                <th>邮箱</th>
                <th>地址</th> -->
                <th>操作</th>
            </tr>
            <%
                List<Model> uList = (List<Model>)request.getAttribute("modelList");
                if(uList==null){
                    request.getRequestDispatcher(request.getContextPath()+"/ModelServlet?act=select").forward(request, response);
                }else{
                    for(Model model:uList){
            %>
             <tr>
                <td><%=model.getModelid()%></td>
                <td><%=model.getName()==null?"":model.getName()%></td>
                <td><%=model.getMessage()==null?"":model.getMessage()%></td>
                <td><a href="${pageContext.request.contextPath}/ModelServlet?act=toUpdatePage&userid=<%=model.getModelid()%>" style="margin:0 10px;">
                    <i class="fa fa-edit fa-fw"></i> 修改</a>
                    <a href="${pageContext.request.contextPath}/ModelServlet?act=delete&userid=<%=model.getModelid()%>">
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
