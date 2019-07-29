<%@ page import="java.net.URLEncoder" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/7/26
  Time: 20:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<!-- 遍历Map集合 -->
<a href="${pageContext.request.contextPath}/download?filename=<%=URLEncoder.encode("图像.txt","UTF-8")%>">文件下载</a>
</body>
</html>
