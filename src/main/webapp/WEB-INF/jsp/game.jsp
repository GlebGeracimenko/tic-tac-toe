<style>
    form {
        /*display: inline-block;*/
        text-align: center;
        align-content: center;
        align-items: center;
    }
</style>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tic Tac Toe</title>
</head>
<body>
<form>
    <h1 align="center">Welcome to tic-tac-toe</h1>

    Game Name: <input align="center" type="text" id="name">

    <input align="center" type="submit" value="Start" onclick="start()"/>
    OR
    <input align="center" type="submit" value="Load" onclick="load()"/>
    <script language="JavaScript">
        function load() {
            var xhr = new XMLHttpRequest();
            xhr.open("GET", '/game', false);
            xhr.setRequestHeader('Content-Type', 'application/json');
            xhr.send();
            var response = xhr.responseText;
        }
    </script>
</form>
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
            window.location.href = '/ticTacToe?gameId=' + gameId;
        }
    }

</script>
</body>
</html>
