<style>
    form {
        /*display: inline-block;*/
        text-align: center;
        align-content: center;
        align-items: center;

    }

    ul {
        list-style-type: decimal;
        list-style-position: inside;
        align-content: flex-start;
        align-items: flex-start;
        text-align: left;
        float: right;
    }
    li {
        padding-right: 50px;
    }
</style>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tic Tac Toe</title>
</head>
<body>
<h1 align="center">Welcome to tic-tac-toe</h1>
<form>

    Game Name: <input align="center" type="text" id="name">

    <input type="submit" value="Start" onclick="return start()"/>
</form>
<ul>
    <script language="JavaScript">
        var xhr = new XMLHttpRequest();
        xhr.open("GET", '/game', false);
        xhr.setRequestHeader('Content-Type', 'application/json');
        xhr.send();
        var response = xhr.responseText;
        var json = JSON.parse(response);
        var array = json.response;

        document.open();
        for (var i = 0; i < array.length; i++) {
            var game = array[i];
            document.writeln("<li>Game: "+ game.name + ", status: "+ game.status +"</li>");
        }
        document.close();
    </script>
</ul>
<script language="JavaScript">

    function start() {
        var xhr = new XMLHttpRequest();
        var name = document.getElementById('name').value;
        xhr.open("POST", '/game', false);
        xhr.setRequestHeader('Content-Type', 'application/json');
        var data = JSON.stringify({"name": name});

        xhr.send(data);
        console.log(xhr.status);
        if (xhr.status == 200) {
            var response = xhr.responseText;
            var json = JSON.parse(response);
            var gameId = json.id;
            alert("before redirect..");
            window.location.href = '/ticTacToe?gameId=' + gameId;
            return false;
        }
    }

</script>
</body>
</html>
