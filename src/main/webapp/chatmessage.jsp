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

    <div class="chat-header">
        Chat with <%= receiver %> 💬
    </div>

    <div id="chatBox" class="chat-box"></div>

    <input type="hidden" id="sender" value="<%= sender %>">
    <input type="hidden" id="receiver" value="<%= receiver %>">

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
                "Content-Type": "application/x-www-form-urlencoded"
            },
            body: "sender=" + sender + "&receiver=" + receiver + "&message=" + msg
        })
            .then(res => res.text())
            .then(data => {

                let chatBox = document.getElementById("chatBox");

                chatBox.innerHTML += `
            <div class="message sent">
                <div>${msg}</div>
                <span class="time">now</span>
            </div>
        `;

                document.getElementById("msg").value = "";
                chatBox.scrollTop = chatBox.scrollHeight;
            });
    }


    // 🔥 LOAD MESSAGES
    function loadMessages() {
        let sender = document.getElementById("sender").value;
        let receiver = document.getElementById("receiver").value;

        fetch("getMessages?sender=" + sender + "&receiver=" + receiver)
            .then(res => res.json())
            .then(messages => {

                let chatBox = document.getElementById("chatBox");
                chatBox.innerHTML = "";

                messages.forEach(msg => {

                    if (msg.sender === sender) {
                        chatBox.innerHTML += `
                    <div class="message sent">
                        <div>${msg.content}</div>
                        <span class="time">${msg.time}</span>
                    </div>
                `;
                    } else {
                        chatBox.innerHTML += `
                    <div class="message received">
                        <div>${msg.content}</div>
                        <span class="time">${msg.time}</span>
                    </div>
                `;
                    }

                });

                chatBox.scrollTop = chatBox.scrollHeight;
            });
    }

    // auto refresh
    setInterval(loadMessages, 1000);

    // first load
    loadMessages();

</script>

</body>
</html>