
<%
    if (session.isNew()) {
        session.setAttribute("GameName", "Game1");
    }
%>

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

<script language="JavaScript">
    function step1(intValue, id)
    {
        var xhr = new XMLHttpRequest();
        var body = '{"field":' + encodeURIComponent(intValue)+'}';
        xhr.open("POST", '/step', false);
        xhr.setRequestHeader('Content-Type', 'application/json');

        xhr.send(body);
        if (xhr.status == 200) {
            var response = xhr.responseText;
            var button = document.getElementById(id);
            button.value = response;
            button.disabled = true;
        } else {
            alert( xhr.status + ': ' + xhr.statusText );
        }
    }
</script>
</body>
</html>