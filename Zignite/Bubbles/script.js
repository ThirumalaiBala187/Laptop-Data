function createBubble() {
    const bubble = document.createElement('div');
    bubble.className = 'bubble';
    
    const size = Math.random() * 100 + 50;
    bubble.style.width = `${size}px`;
    bubble.style.height = `${size}px`;
    
    const startPos = Math.random() * 100;
    bubble.style.left = `${startPos}%`;
    
    const moveX = Math.random() * 100 - 50;
    bubble.style.setProperty('--move-x', `${moveX}px`);
    
    const duration = Math.random() * 150 + 15;
    bubble.style.animationDuration = `${duration}s`;

    bubble.addEventListener('animationend', () => {
        bubble.remove();
    });
    
    return bubble;
}

function initBubbles() {
    const container = document.getElementById('bubble-container');
    
    for (let i = 0; i < 20; i++) {
        const bubble = createBubble();
        bubble.style.top = `${Math.random() * 100}%`;
        container.appendChild(bubble);
    }
    
    setInterval(() => {
        const bubble = createBubble();
        container.appendChild(bubble);
    }, 500);
}

window.addEventListener('load', initBubbles);