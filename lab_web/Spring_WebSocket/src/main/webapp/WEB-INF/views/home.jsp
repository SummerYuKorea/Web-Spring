<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=utf-8" %>
<html>
<head>
	<title>Home</title>
	
	<!-- jQuery CDN 포함: 라이브러리 포함  -->
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
	
	<style>
		#text{
			background-color: yellow;
		}
	</style>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P><hr/>

<input id="text" />
<button id="btn">버튼~</button>

<script>
$(document).ready(function(){
	var exampleSocket = new WebSocket("ws://www.naver.com");
	$('#btn').click(function(){
		console.log("onclick맞나?");
	
	exampleSocket.onopen = function (event) {
		  exampleSocket.send("Here's some text that the server is urgently awaiting!"); 
		};
	});
		
		
		
		// Send text to all users through the server
		function sendText() {
		  // Construct a msg object containing the data the server needs to process the message from the chat client.
		  var msg = {
		    type: "message",
		    text: document.getElementById("text").value,
		    id:   clientID,
		    date: Date.now()
		  };

		  // Send the msg object as a JSON-formatted string.
		  exampleSocket.send(JSON.stringify(msg));
		  
		  // Blank the text input element, ready to receive the next line of text from the user.
		  document.getElementById("text").value = "";
		}//func sendText
		
		exampleSocket.onmessage = function (event) {
			  console.log(event.data);
			}
});
</script>
</body>
</html>
