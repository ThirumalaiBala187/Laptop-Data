function createBubbles() {
    const count = 15;
    for (let i = 0; i < count; i++) {
        const bubble = document.createElement('div');
        bubble.className = 'bubble';

        const size = Math.random() * 100 + 40;
        bubble.style.width = `${size}px`;
        bubble.style.height = `${size}px`;

        bubble.style.left = `${Math.random() * 100}vw`;
        bubble.style.top = `${Math.random() * 100}vh`;

        bubble.style.animationDelay = `${Math.random() * 5}s`;
        bubble.style.animationDuration = `${5 + Math.random() * 10}s`;

        document.body.appendChild(bubble);
    }
}

window.onload = () => {
    createBubbles();
};

const chatMessages = document.getElementById('chatMessages');
const userInput = document.getElementById('userInput');

async function generateResponse(prompt) {
    try {
        const response = await fetch('http://localhost:5000/generate', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({ text: prompt }),
        });
        const data = await response.json();

        if (response.ok) {
            return data['Generated Output'];
        }
    } catch (error) {
       return error.message;
    }
}



function addMessage(message, isUser) {
    const messageElement = document.createElement('div');
    messageElement.classList.add('message');
    messageElement.classList.add(isUser ? 'userMessage' : 'botMessage');
    const profileImage = document.createElement('img');
    profileImage.classList.add('profileImage');
    profileImage.src = isUser ? 'user.jpg' : 'bot.jpg';
    const messageContent = document.createElement('div');
    messageContent.classList.add('messageContent');
    messageContent.textContent = message;
    messageElement.appendChild(profileImage);
    messageElement.appendChild(messageContent);
    chatMessages.appendChild(messageElement);
    chatMessages.scrollTop = chatMessages.scrollHeight;
}

async function handleUserInput() {
    const userMessage = userInput.value.trim();
    if (userMessage) {
        addMessage(userMessage, true);
        userInput.value = '';
        userInput.disabled = true;
        try {
            const botMessage = await generateResponse(userMessage);
            addMessage(botMessage, false);
        }
        catch (error) {
            console.error('Error:', error);
            addMessage('Sorry, I encountered an error. Please try again.', false);
        }
        finally {
            userInput.focus();
        }
    }
}
document.addEventListener("DOMContentLoaded", function () {
    const sections = document.querySelectorAll(".learning-section");
    let currentIndex = 0;

    function updateSections() {
        document.getElementById("allSections").style.transform = `translateY(-${currentIndex * 87}vh)`;
        document.getElementById("progressBar").style.width=currentIndex*20 + "%";
    }
    

    document.querySelectorAll(".continue").forEach((button) => {
        button.addEventListener("click", function () {
            if (currentIndex < sections.length - 1) {
                currentIndex++;
                updateSections();
            }
        });
    });

    document.querySelectorAll(".prev-btn").forEach((button) => {
        button.addEventListener("click", function () {
            if (currentIndex > 0) {
                currentIndex--;
                updateSections();
            }
        });
    });
	let finish=(localStorage.getItem("finishedPy")==null)?0:localStorage.getItem("finishedPy");
		// completion=document.getElementById("completion");
		//                completion.innerHTML=finish+"%";
    // updateSections();
});

 
document.addEventListener('DOMContentLoaded', function() {
    const chatButton = document.getElementById('chatButton');
    const chatContainer = document.getElementById('chatContainer');
    const closeButton = document.getElementById('closeButton');
    const sendButton = document.getElementById('sendButton');
    const messageInput = document.getElementById('messageInput');
    const chatBody = document.getElementById('chatBody');
    
    // Toggle chat container visibility
    chatButton.addEventListener('click', function() {
        chatContainer.classList.add('active');
    });
    
    closeButton.addEventListener('click', function() {
        chatContainer.classList.remove('active');
    });
    
    // Handle sending messages
    function sendMessage() {
        const message = messageInput.value.trim();
        if (message) {
            // Add user message
            addMessage(message, 'user');
            messageInput.value = '';
            
            // Show typing indicator
            showTypingIndicator();
            
            // Simulate bot response after delay
            setTimeout(function() {
                removeTypingIndicator();
                let responses = [
                    "Thanks for your message! How can I assist you further?",
                    "I understand. Is there anything specific you'd like to know?",
                    "That's interesting. Let me help you with that.",
                    "I'm here to help. Could you provide more details?"
                ];
                let randomResponse = responses[Math.floor(Math.random() * responses.length)];
                addMessage(randomResponse, 'bot');
            }, 1500);
        }
    }
    
    sendButton.addEventListener('click', sendMessage);
    
    messageInput.addEventListener('keypress', function(e) {
        if (e.key === 'Enter') {
            sendMessage();
        }
    });
    
    // Add message to chat
    function addMessage(text, sender) {
        const messageElement = document.createElement('div');
        messageElement.classList.add('message');
        messageElement.classList.add(sender + '-message');
        messageElement.textContent = text;
        chatBody.appendChild(messageElement);
        
        // Scroll to the bottom
        chatBody.scrollTop = chatBody.scrollHeight;
    }
    
    // Show typing indicator
    function showTypingIndicator() {
        const typingIndicator = document.createElement('div');
        typingIndicator.classList.add('typing-indicator');
        typingIndicator.id = 'typingIndicator';
        
        for (let i = 0; i < 3; i++) {
            const dot = document.createElement('div');
            dot.classList.add('typing-dot');
            typingIndicator.appendChild(dot);
        }
        
        chatBody.appendChild(typingIndicator);
        chatBody.scrollTop = chatBody.scrollHeight;
    }
    
    // Remove typing indicator
    function removeTypingIndicator() {
        const typingIndicator = document.getElementById('typingIndicator');
        if (typingIndicator) {
            typingIndicator.remove();
        }
    }
    
    // Handle quick action buttons
    document.querySelectorAll('.quick-action-button').forEach(button => {
        button.addEventListener('click', function() {
            addMessage(this.textContent, 'user');
            
            showTypingIndicator();
            
            setTimeout(function() {
                removeTypingIndicator();
                let response = "I'd be happy to help you with " + button.textContent.toLowerCase() + ". What specific information are you looking for?";
                addMessage(response, 'bot');
            }, 1500);
        });
    });
});