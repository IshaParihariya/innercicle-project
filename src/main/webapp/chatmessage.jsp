<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    String receiver = (String) request.getAttribute("receiver");
    String sender = (String) request.getAttribute("sender");
%>

<!DOCTYPE html>
<html>
<head>
    <title>InnerCircle Chat</title>
    <link rel="stylesheet" href="css/chatmessage.css">
</head>

<body>

<div class="chat-container">

    <!-- Header -->
    <div class="chat-header">
        Chat with <%= receiver %> 💬
    </div>

    <!-- Chat Messages -->
    <div id="chatBox" class="chat-box">
        <!-- messages will come here later -->
    </div>

    <!-- Hidden fields -->
    <!--Because JavaScript cannot directly access JSP variables
        So we store them in HTML → JS can read them-->
    <input type="hidden" id="sender" value="<%= sender %>">
    <input type="hidden" id="receiver" value="<%= receiver %>">

    <!-- Input -->
    <div class="chat-input">
        <input type="text" id="msg" placeholder="Type a message..." />
        <button onclick="sendMessage()">Send</button>
    </div>

</div>

<script>
    function sendMessage() {
        let msg = document.getElementById("msg").value;
        let sender = document.getElementById("sender").value;
        let receiver = document.getElementById("receiver").value;

        fetch("chatmessage", {
            method: "POST",
            headers: {
                <!--sending data like a form-->
                "Content-Type": "application/x-www-form-urlencoded"
            },
            <!--sender=Isha&receiver=Rahul&message=Hello-->
            body: "sender=" + sender + "&receiver=" + receiver + "&message=" + msg
        })
            .then(res => res.text())
            .then(data => {
                console.log(data);
                document.getElementById("msg").value = "";
            });
    }
</script>

</body>
</html>