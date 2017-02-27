<%--
  Created by IntelliJ IDEA.
  User: ggerasim
  Date: 2/27/17
  Time: 4:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tic Tac Toe</title>
</head>
<body>

<%--<form action="/game" method="POST" id="form1">--%>
    Game Name: <input type="text" id="name" align="middle">

    <input type="submit" value="Start" align="middle" onclick="start()"/>
<%--</form>--%>
<script language="JavaScript">

    function start() {
        var xhr = new XMLHttpRequest();
        var name = document.getElementById('name').value;
        xhr.open("POST", '/game', false);
        xhr.setRequestHeader('Content-Type', 'application/json');
        var data = JSON.stringify({"name":name});

        xhr.send(data);
        console.log(xhr.status);
    }

</script>
</body>
</html>
