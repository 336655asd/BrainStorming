<%-- 
    Document   : message
    Created on : 2018-4-23, 20:45:28
    Author     : C
--%>

<%@page import="java.net.URLDecoder"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src='<%=request.getContextPath()%>/dwr/engine.js'></script>
        <script src='<%=request.getContextPath()%>/dwr/interface/message_center.js'></script>
        <script src='<%=request.getContextPath()%>/dwr/interface/dwr_interface.js'></script>
        <script type='text/javascript' src='<%=request.getContextPath()%>/dwr/util.js'></script>
        <title>your message</title>
        <link type="text/css" rel="stylesheet" href="css/welcomePage.css" />
        <script type="text/javascript" src="js/message.js"></script>
        <!--弹出层 开始 -->
	<link type="text/css" rel="stylesheet" href="css/zdialog.css" />
	<script type="text/javascript" src="js/jquery-1.11.2.min.js"></script>
	<script type="text/javascript" src="js/zdialog.js"></script>
	<!--弹出层 结束 -->
	<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    </head>
        <%
        String username="null";
        String score="null";
    %>
    <%
        Cookie cookie = null;
        Cookie[] cookies = null;
             // 获取当前域名下的cookies，是一个数组
        cookies = request.getCookies();
        if(cookies!=null)
        {
            for(int i=0;i<cookies.length;i++)
            {
                cookie = cookies[i];
                if(("name").equals(cookie.getName()))
                {
                    username=URLDecoder.decode(cookie.getValue(),"UTF-8");
                }
                if(("score").equals(cookie.getName()))
                {
                    score=URLDecoder.decode(cookie.getValue(),"UTF-8");
                }
            }
        }
    %>
    <body onload="AutoLoad()" onresize="changeWindowAuto()">
        <div id="loginDiv">
        <h1>your message</h1>
        <div id="textA">
            
        </div>
        <button id="btn1" onclick="btn1_click()">新建
        </button>
        </div>
    </body>
</html>
