<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--<%--%>
    <%--if (session.isNew()) {--%>
        <%--session.setAttribute("GameName", "Game1");--%>
    <%--}--%>
<%--%>--%>

<html>
<head>
    <style type="text/css">
    input[type=button] {
        border: none;
        color: black;
        padding: 40px 55px;
        text-align: center;
        text-decoration: none;
        display: inline-block;
        font-size: 16px;
    }

    </style>
</head>
<body>

<title>Tic-Tac-Toe</title>

    <table align="center" height="300" width="300" cellspacing="0">

        <div>
            <button type="submit" style="height: 70px; width:  150px; font-size: medium; background-color: deepskyblue" onclick="window.location.href = '/'">Back</button>
        </div>

        <tr>
            <th><input id="button1" type="button" value="" onclick="step1('1', 'button1')"></th>
            <th><input id="button2" type="button" value="" onclick="step1('2', 'button2')"></th>
            <th><input id="button3" type="button" value="" onclick="step1('3', 'button3')"></th>
        </tr>

        <tr>
            <th><input id="button4" type="button" value="" onclick="step1('4', 'button4')"></th>
            <th><input id="button5" type="button" value="" onclick="step1('5', 'button5')"></th>
            <th><input id="button6" type="button" value="" onclick="step1('6', 'button6')"></th>
        </tr>

        <tr>
            <th><input id="button7" type="button" value="" onclick="step1('7', 'button7')"></th>
            <th><input id="button8" type="button" value="" onclick="step1('8', 'button8')"></th>
            <th><input id="button9" type="button" value="" onclick="step1('9', 'button9')"></th>
        </tr>
    </table>
<h1 id="statusH1">Game status: ${status}</h1>
<form id="form1">

    <%--<center></center>--%>
<script async type="text/javascript">
    function writeStep(value)
    {
        var el = document.getElementById("form1");
        el.innerHTML += "\n<center>"+ value.step +") field : "+value.field +", value : "+ value.value +"</center>";
    }
</script>
</form>

<script language="JavaScript">

    var allStep = ${steps};

    for (var i = 0; i < allStep.length; i++) {
        var json = allStep[i];
        var button = document.getElementById("button" + json.field);
        if (json.step % 2 == 1) {
            button.value = 'X';
        } else {
            button.value = 'O';
        }
        json.value = button.value;
        button.disabled = true;
        writeStep(json);
    }

    if ('${status}' != 'In progress') {
        allDisabled();
    }

    function step1(intValue, id)
    {
        <%--console.log('Game id = ' + ${id});--%>
        var xhr = new XMLHttpRequest();
        var body = '{"field":' + encodeURIComponent(intValue)+', "gameId":' + ${id} + '}';
        xhr.open("POST", '/step', false);
        xhr.setRequestHeader('Content-Type', 'application/json');

        xhr.send(body);
        if (xhr.status == 200) {
            var response = xhr.responseText;
            var json = JSON.parse(response);
            var button = document.getElementById(id);
            button.value = json.value;
            button.disabled = true;
            writeStep(json);

            if (json.status != null) {
                checkResult(json.status);
            }

        } else {
            alert( xhr.status + ': ' + xhr.statusText);
        }
    }

    function allDisabled() {
        var array = document.getElementsByTagName("input");
        for (var i = 0; i < array.length; i++) {
            var but = array[i];
            if (but.disabled == false) {
                but.disabled = true;
            }
        }
    }

    function checkResult(status)
    {
        var xhr = new XMLHttpRequest();
        var body = '{"id":' + ${id} + ',"status":"'+status+'"}';
        xhr.open("PUT", '/game', false);
        xhr.setRequestHeader('Content-Type', 'application/json');
        xhr.send(body);
        var h1 = document.getElementById("statusH1");
        h1.innerHTML = "Game status: "+status;
        allDisabled();
        alert('Game is over! Result ' + status);
    }
</script>
</body>
</html>