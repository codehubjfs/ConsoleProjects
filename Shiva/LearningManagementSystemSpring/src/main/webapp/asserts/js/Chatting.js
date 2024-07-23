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
