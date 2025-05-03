document.addEventListener('DOMContentLoaded', function () {
    let chatToggle = document.getElementById('chatToggle');
    let chatContainer = document.getElementById('chatContainer');
    let chatBody = document.getElementById('chatBody');
    let messageInput = document.getElementById('messageInput');
    let sendButton = document.getElementById('sendButton');
    let closeChat = document.getElementById('closeChat');
    let maximize = document.getElementById('maximizeChat');
    let notificationBadge = document.getElementById('notificationBadge');
    let botAvatar = document.getElementById('botAvatar');
    let cssFile = document.getElementById('cssFile');

    setTimeout(() => {
        notificationBadge.classList.add('active');
        chatToggle.classList.add('pulse');
    }, 1000);

    setTimeout(() => {
        addBotMessage("👋 Hi there! I'm your assistant. How can I help you today?");
    }, 1000);

    chatToggle.addEventListener('click', function () {
        chatToggle.classList.add('rotate');
        botAvatar.classList.add('rotate');
        chatToggle.classList.toggle('active');
        chatContainer.classList.toggle('active');

        if (chatContainer.classList.contains('active')) {
            notificationBadge.classList.remove('active');
            chatToggle.classList.remove('pulse');
            messageInput.focus();
        }
        setTimeout(() => {
            chatToggle.classList.remove('rotate');
            botAvatar.classList.remove('rotate');
        }, 500);
    });

    closeChat.addEventListener('click', function () {
        if (cssFile.href.includes("maximize.css")) {
            cssFile.href = "popup.css";
            maximize.className = "fa-solid fa-expand";
            chatToggle.style.display = 'flex';
            notificationBadge.style.visibility = 'visible';
            document.getElementsByClassName('chatIcon')[0].style.visibility = 'visible';
            document.getElementsByClassName('closeIcon')[0].style.visibility = 'visible';
        }
        chatToggle.classList.add('rotate');
        botAvatar.classList.add('rotate');
        chatContainer.classList.remove('active');
        chatToggle.classList.remove('active');
        setTimeout(() => {
            chatToggle.classList.remove('rotate');
            botAvatar.classList.remove('rotate');
        }, 500);
    });

    maximize.addEventListener('click', function () {
        if (cssFile.href.includes('popup.css')) {
            cssFile.href = 'maximize.css';
            maximize.className = "fa-solid fa-down-left-and-up-right-to-center";
            chatToggle.style.display = 'none';
            notificationBadge.style.visibility = 'hidden';
            document.getElementsByClassName('chatIcon')[0].style.visibility = 'hidden';
            document.getElementsByClassName('closeIcon')[0].style.visibility = 'hidden';
        }
        else {
            cssFile.href = 'popup.css';
            maximize.className = "fa-solid fa-expand";
            chatToggle.style.display = 'flex';
            notificationBadge.style.visibility = 'visible';
            document.getElementsByClassName('chatIcon')[0].style.visibility = 'visible';
            document.getElementsByClassName('closeIcon')[0].style.visibility = 'visible';
        }
    })

    function sendMessage() {
        let message = messageInput.value.trim();
        if (message) {
            addUserMessage(message);
            messageInput.value = '';
            showTypingIndicator();
            setTimeout(() => {
                botAvatar.classList.add('rotate');
                setTimeout(() => {
                    botAvatar.classList.remove('rotate');
                }, 500);
                generateText(message).then(response => {
                    hideTypingIndicator();
                    addBotMessage(response);
                });
            }, 1500);
        }
    }

    sendButton.addEventListener('click', sendMessage);
    messageInput.addEventListener('keypress', function (e) {
        if (e.key === 'Enter') {
            sendMessage();
        }
    });

    function addUserMessage(message) {
        let messageContainer = document.createElement('div');
        messageContainer.classList.add('userMessageContainer');
        let userImage = document.createElement('img');
        userImage.src = 'user.jpg';
        userImage.classList.add('profileImg');
        messageContainer.appendChild(userImage);
        let messageElement = document.createElement('div');
        messageElement.className = 'message userMessage';
        messageElement.textContent = message;
        messageContainer.appendChild(messageElement);
        chatBody.appendChild(messageContainer);
        scrollToBottom();
    }

    function addBotMessage(message) {
        let messageContainer = document.createElement('div');
        messageContainer.classList.add('botMessageContainer');
        let botImage = document.createElement('img');
        botImage.src = 'bot.jpg';
        botImage.classList.add('profileImg');
        messageContainer.appendChild(botImage);
        let messageElement = document.createElement('div');
        messageElement.className = 'message botMessage';
        messageElement.textContent = message;
        messageContainer.appendChild(messageElement);
        chatBody.appendChild(messageContainer);
        messageContainer.innerHTML += '<i class="fa-solid fa-volume-high" style="margin-left:15px;font-size:18px" id="readAloud"></i>';
        if(!message.includes("👋")){
            generateSpeech(message);
        }
        scrollToBottom();
    }

    document.addEventListener('click', function (event) {
        if (event.target.classList.contains("fa-volume-high")) {
            let text = event.target.parentElement.children[1].innerText;
            console.log("Text to read:", text);
            event.target.style.pointerEvents="None";
            generateSpeech(text);
        }
    });

    function showTypingIndicator() {
        let typingIndicator = document.createElement('div');
        typingIndicator.className = 'typingIndicator';
        typingIndicator.id = 'typingIndicator';

        for (let i = 0; i < 3; i++) {
            let dot = document.createElement('div');
            dot.className = 'typingDot';
            typingIndicator.appendChild(dot);
        }

        chatBody.appendChild(typingIndicator);
        scrollToBottom();
    }

    function hideTypingIndicator() {
        let typingIndicator = document.getElementById('typingIndicator');
        if (typingIndicator) {
            typingIndicator.remove();
        }
    }

    function scrollToBottom() {
        chatBody.scrollTop = chatBody.scrollHeight;
    }

    setTimeout(() => {
        if (!chatContainer.classList.contains('active')) {
            notificationBadge.textContent = "1";
            notificationBadge.classList.add('active');
            chatToggle.classList.add('pulse');

            let hasNewMessageListener = function () {
                if (chatContainer.classList.contains('active')) {
                    setTimeout(() => {
                        botAvatar.classList.add('rotate');
                        setTimeout(() => {
                            botAvatar.classList.remove('rotate');
                        }, 500);
                    }, 1000);
                    chatToggle.removeEventListener('click', hasNewMessageListener);
                }
            };

            chatToggle.addEventListener('click', hasNewMessageListener);
        }
    }, 10000);


    var mediaRecorder;
    var audioChunks = [];
    const startBtn = document.getElementById('startRecording');
    const transcriptDiv = document.getElementById('messageInput');

    startBtn.addEventListener('click', async () => {
        if (startBtn.dataset.recording === "true") {
            stopRecording();
        } else {
            startRecording();
        }
    });

    async function startRecording() {
        startBtn.className = "fa-solid fa-circle-stop";
        startBtn.dataset.recording = "true";
        try {
            const stream = await navigator.mediaDevices.getUserMedia({ audio: true });
            mediaRecorder = new MediaRecorder(stream);

            mediaRecorder.ondataavailable = (event) => {
                audioChunks.push(event.data);
            };

            mediaRecorder.onstop = handleRecordingStop;

            audioChunks = [];
            mediaRecorder.start();
        } catch (error) {
            console.error('Error accessing microphone:', error);
        }
    }

    function stopRecording() {
        if (mediaRecorder && mediaRecorder.state !== "inactive") {
            mediaRecorder.stop();
            mediaRecorder.stream.getTracks().forEach(track => track.stop());
        }
        startBtn.className = "fa-solid fa-microphone";
        startBtn.dataset.recording = "false";
    }

    async function handleRecordingStop() {
        const audioBlob = new Blob(audioChunks, { type: 'audio/webm' });
        try {
            const transcript = await transcribeAudio(audioBlob);
            transcriptDiv.value = transcript;
            sendMessage();
        } catch (error) {
            console.error('Transcription error:', error);
            transcriptDiv.textContent = 'Error transcribing audio';
        }
    }

    async function transcribeAudio(audioBlob) {
        const DEEPGRAM_API_KEY = '13871c1934a004a2b8d91f8ef1735d6bb7437f7f';

        const response = await fetch('https://api.deepgram.com/v1/listen', {
            method: 'POST',
            headers: {
                'Authorization': `Token ${DEEPGRAM_API_KEY}`,
                'Content-Type': 'audio/webm'
            },
            body: audioBlob
        });

        if (!response.ok) {
            throw new Error(`Deepgram API error: ${response.status}`);
        }

        const data = await response.json();
        return data.results.channels[0].alternatives[0].transcript;
    }

    async function generateSpeech(text) {
        console.log(text);
        const requestBody = {
            text: text,
        };

        const headers = {
            "Authorization": "Token 91d45ad7ea54348740101f79753ee84d4557def5",
            "Content-Type": "application/json",
        };

        try {
            const response = await fetch("https://api.deepgram.com/v1/speak?model=aura-asteria-en&encoding=mp3", {
                method: "POST",
                headers: headers,
                body: JSON.stringify(requestBody),
            });
            if (!response.ok) {
                throw new Error(`HTTP error! Status: ${response.status}`);
            }
            const audioBlob = await response.blob();

            const audioUrl = URL.createObjectURL(audioBlob);

            const audio = new Audio(audioUrl);
            const audioContext = new (window.AudioContext || window.webkitAudioContext)();
            const source = audioContext.createBufferSource();
            const gainNode = audioContext.createGain();
            const pitchNode = audioContext.createBiquadFilter();

            pitchNode.type = "highpass";
            pitchNode.frequency.value = 1000;
            
            const arrayBuffer = await audioBlob.arrayBuffer();
            const audioBuffer = await audioContext.decodeAudioData(arrayBuffer);

            source.buffer = audioBuffer;
            source.playbackRate.value = 1.0;
            gainNode.gain.value=1.5
            
            source.connect(pitchNode);
            pitchNode.connect(gainNode);
            gainNode.connect(audioContext.destination);

            source.start();
            // audio.play();

        } catch (error) {
            console.error("Error generating speech:", error);
        }
    }

});

let model = "distilgpt2"

const API_URL = "https://4e5a-34-83-163-33.ngrok-free.app";

async function setModel(model_name) {
    try {
        const response = await fetch(`${API_URL}/select-model`, {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify({ model: model_name })
        });
        const data = await response.json();
        if (data.status === "success") {
            console.log(`Model switched to: ${data.model}`);
        } else {
            console.error("Model switch failed:", data.message);
        }
    } catch (error) {
        console.error("Error setting model:", error);
    }
}

async function generateText(prompt) {

    if (!prompt) {
        responseDiv.textContent = "Please enter a prompt!";
        return;
    }

    try {

        await setModel(model);
        await new Promise(resolve => setTimeout(resolve, 1000))
        const response = await fetch(`${API_URL}/generate`, {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify({ prompt: prompt })
        });
        const data = await response.json();
        console.log("API response : ", data)
        if (data.response) {
            return data.response;
        } else {
            return `Error: ${data.message}`;
        }
    } catch (error) {
        return `Fetch error: ${error.message}`;
    }
}

const dropdownIcon = document.getElementById("dropdown-icon");
const dropdownMenu = document.getElementById("dropdown-menu");

dropdownIcon.addEventListener("click", () => {
    dropdownMenu.style.display = dropdownMenu.style.display === "block" ? "none" : "block";
});

dropdownMenu.addEventListener("click", (event) => {
    console.log(model)
    if (event.target.tagName === "DIV") {
        document.querySelector(".selected-option").classList.remove("selected-option");
        event.target.classList.add("selected-option");
        if(event.target.innerText=="Vidai-1.0"){
            model="distilgpt2";
        }
        else if(event.target.innerText=="Vidai-2.0"){
            model="tinyllama";
        }
        else{
            model="mistral";
        }
        dropdownMenu.style.display = "none";
        console.log(model)
    }
});

document.addEventListener("click", (event) => {
    if (!dropdownIcon.contains(event.target) && !dropdownMenu.contains(event.target)) {
        dropdownMenu.style.display = "none";
    }
});