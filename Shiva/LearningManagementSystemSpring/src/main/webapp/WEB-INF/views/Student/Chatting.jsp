<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<style>
@charset "ISO-8859-1";
body {
    display: flex;
    flex-direction: column;
    height: 100vh;
    margin: 0;
}

header {
    width: 100%;
}

.sidebar {
    height: calc(100vh - 56px);
    position: fixed;
    top: 56px;
    left: 0;
    overflow-y: auto;
}

.contact-list {
    max-height: calc(100vh - 136px);
    overflow-y: auto;
}

.chat-area {
    height: calc(100vh - 136px);
    display: flex;
    flex-direction: column;
}

.chat-box {
    flex: 1;
    overflow-y: auto;
}

.card-footer {
    display: flex;
    align-items: center;
}

</style>
<script>
/**
 * 
 */
document.addEventListener('DOMContentLoaded', function () {
    const contacts = ['Alice', 'Bob', 'Charlie', 'Dave'];
    const contactList = document.getElementById('contact-list');
    const chatBox = document.getElementById('chat-box');
    const chatContactName = document.getElementById('chat-contact-name');
    const chatInput = document.getElementById('chat-input');
    const sendButton = document.getElementById('send-button');

    let currentChatContact = null;
    let messages = {};

    function loadContacts() {
        contacts.forEach(contact => {
            const li = document.createElement('li');
            li.className = 'list-group-item';
            li.textContent = contact;
            li.addEventListener('click', () => selectContact(contact));
            contactList.appendChild(li);
        });
    }

    function selectContact(contact) {
        currentChatContact = contact;
        chatContactName.textContent = contact;
        chatBox.innerHTML = '';
        if (messages[contact]) {
            messages[contact].forEach(msg => {
                const div = document.createElement('div');
                div.textContent = msg;
                chatBox.appendChild(div);
            });
        }
    }

    sendButton.addEventListener('click', () => {
        if (!currentChatContact) return;

        const message = chatInput.value;
        if (!message) return;

        if (!messages[currentChatContact]) {
            messages[currentChatContact] = [];
        }

        messages[currentChatContact].push(message);
        const div = document.createElement('div');
        div.textContent = message;
        chatBox.appendChild(div);
        chatInput.value = '';
    });

    loadContacts();
});

</script>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dashboard</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="asserts/css/Student/Chatting.css">
    <script src="asserts/css/Student/Chatting.js"></script>
</head>

<body>
    <!-- Horizontal Nav Bar -->
    <header class="text-white" style="padding:1%;background-color: #0092CA;">
        <img src="asserts/images/site-logo.png" height="50px" width="70px">
        <div class="d-flex float-right pt-2">
            <img src="asserts/images/person.svg" alt="Profile Image" class="rounded-circle pr-1 pt-2" height="30px" width="30px">
            <h6 class="ml-3 pt-2"><%=session.getAttribute("username")%></h6>
            <div class="dropdown-menu" aria-labelledby="dropdownMenuLink">
                            <a class="dropdown-item" href="SLogOut">Log Out</a>
                        </div>
        </div>
    </header>

    <div class="container-fluid ">
        <div class="row ">
            <!-- Vertical Nav Bar -->
            <div class="bg-dark text-light vh-100 vertical-nav">
                <div class="nav flex-column p-1">
                <a href="DashBoard" class="nav-item nav-link text-light pb-2 pt-5">Dashboard</a>
            <a href="courses" class="nav-item nav-link text-light pb-2 pt-4">Course Management</a>  
            <a href="Profile" class="nav-item nav-link text-light pb-2 pt-4">Profile</a>
             <a href="Results" class="nav-item nav-link text-light pb-2 pt-4">Results</a>
            <a href="Chatting" class="nav-item nav-link text-light pb-2 pt-4">Messages</a>
                </div>
            </div>

            <!-- Main Content Area -->
            <main role="main" class="col-md-10 ml-sm-auto col-lg-10 px-4 pt-3">
                <div class="row">
                    <div class="col-4">
                        <h2>Contact List</h2>
                        <ul class="list-group contact-list" id="contact-list" style="cursor: pointer;">
                        </ul>
                    </div>
                    <div class="col-8">
                        <div class="card chat-area">
                            <div class="card-header">
                                <h5 id="chat-contact-name">Select a contact to chat</h5>
                            </div>
                            <div class="card-body chat-box " style="margin-top:30%" id="chat-box">
                            </div>
                            <div class="p4"></div>
                            <div class="card-footer ">
                                <div class="input-group">
                                    <input type="text" id="chat-input" class="form-control" placeholder="Type a message">
                                    <div class="input-group-append">
                                        <button class="btn btn-primary" id="send-button">Send</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </main>
        </div>
    </div>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <script src="scripts.js"></script>
</body>

</html>
    