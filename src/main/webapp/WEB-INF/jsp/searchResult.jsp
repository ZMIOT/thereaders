<%@ page import="java.io.File" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/7/25
  Time: 18:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <!-- STYLESHEET CSS FILES -->
    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>

    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link type="text/css" rel="stylesheet" href="../css/bookTable.css">
    <title>Title</title>
</head>
<body>
    <table class="table table-condensed">
         <thead>
            <caption>${searchField}的搜索结果></caption>
            <tybody></tybody>
            <tr>
                <th>书名</th>
                <th>作者</th>
                <th>类型</th>
                <th></th>
            </tr>
            <% String path = request.getServletContext().getRealPath("/WEB-INF/upload/");
                File file = new File(path);
                File[] fs = file.listFiles();

                for(File f:fs){
                    if(!f.isDirectory()){
                       String filename = f.getName();	//取出文件的名字(非绝对路径名)
                    %>
            <tr>
                <td>book1</td>
                <td>斯基</td>
                <td>mobi</td>
                <td>

            <a href="download?filename=<%=filename%>">下载</a></td></tr><br>
            <%}
            }%>
         </thead>
         <tbody>
         </tbody>
    </table>
</body>
</html>
