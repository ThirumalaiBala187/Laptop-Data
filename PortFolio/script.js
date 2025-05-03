const cursor = document.querySelector(".cursor");
const cursorHover = document.querySelector(".cursorDot");
const links = document.querySelectorAll('a, button, .btn, .project, .skill-item');

const scrollContent = document.getElementById("scrollContent");
scrollContent.innerHTML += scrollContent.innerHTML;

let scrollAmount = 0;
let speed = 1;
let isPaused = false;

function autoScroll() {
    if (!isPaused) {
        scrollAmount += speed;
        scrollContent.style.transform = `translateX(-${scrollAmount}px)`;

        if (scrollAmount >= scrollContent.scrollWidth / 2) {
            scrollAmount = 0;
        }
    }
    requestAnimationFrame(autoScroll);
}

autoScroll();

scrollContent.addEventListener("mouseenter", () => {
    isPaused = true;
});

scrollContent.addEventListener("mouseleave", () => {
    isPaused = false;
});


document.addEventListener("mousemove", (e) => {
    cursor.style.transform = `translate(${e.clientX}px, ${e.clientY}px)`;
    cursorHover.style.transform = `translate(${e.clientX}px, ${e.clientY}px)`;
});

links.forEach(link => {
    link.addEventListener('mouseenter', () => {
        cursor.style.transform = 'translate(-50%, -50%) scale(1.5)';
        cursorHover.style.opacity = "1";
    });
    link.addEventListener('mouseleave', () => {
        cursor.style.transform = 'translate(-50%, -50%) scale(1)';
        cursorHover.style.opacity = "0";
    });
});


document.querySelectorAll('nav a').forEach(link => {
    link.addEventListener('click', () => {
        nav.classList.remove('active');
        menuToggle.classList.remove('active');
        menuToggle.innerHTML = '';
    });
});

var idx = 0;
const carousel = document.querySelector('.carousel');
const dots = document.querySelectorAll('.dot');
const prevBtn = document.getElementById('prev');
const nextBtn = document.getElementById('next');
const totalItems = document.querySelectorAll('.project1').length;

function updateCarousel() {
    carousel.style.transform = `translateX(-${idx * 100}%)`;

    dots.forEach((dot, index) => {
        dot.classList.toggle('active', index === idx);
    });

    prevBtn.style.visibility = idx === 0 ? 'hidden' : 'visible';
    nextBtn.style.visibility = idx === totalItems - 1 ? 'hidden' : 'visible';
}

updateCarousel();

prevBtn.addEventListener('click', function () {
    if (idx > 0) {
        idx--;
        updateCarousel();
    }
});

nextBtn.addEventListener('click', function () {
    if (idx < totalItems - 1) {
        idx++;
        updateCarousel();
    }
});

dots.forEach(dot => {
    dot.addEventListener('click', function () {
        idx = parseInt(this.getAttribute('data-index'));
        updateCarousel();
    });
});

document.addEventListener('DOMContentLoaded', () => {
    const filterButtons = document.querySelectorAll('.filterBtn');
    const projects = document.querySelectorAll('.project');

    filterButtons.forEach(button => {
        button.addEventListener('click', () => {
            filterButtons.forEach(btn => btn.classList.remove('active'));
            button.classList.add('active');

            const filter = button.getAttribute('data-filter');

            projects.forEach(project => {
                const categories = project.getAttribute('data-category').split(' ');
                
                if (filter === 'all' || categories.includes(filter)) {
                    project.classList.remove('hidden');
                } else {
                    project.classList.add('hidden');
                }
            });
        });
    });
});

document.addEventListener('DOMContentLoaded', () => {
    const menuBtn = document.querySelector('.menuBtn');
    const navLinks = document.querySelector('.nav-links');

    if (!menuBtn || !navLinks) {
        console.error('Menu button or nav links not found in the DOM');
        return;
    }

    menuBtn.addEventListener('click', () => {
        navLinks.classList.toggle('active');
        
        const isExpanded = navLinks.classList.contains('active');
        menuBtn.setAttribute('aria-expanded', isExpanded);
        menuBtn.textContent = isExpanded ? 'Close' : 'Menu';
    });

    document.addEventListener('click', (event) => {
        const isClickInsideNav = navLinks.contains(event.target) || menuBtn.contains(event.target);
        if (!isClickInsideNav && navLinks.classList.contains('active')) {
            navLinks.classList.remove('active');
            menuBtn.setAttribute('aria-expanded', 'false');
            menuBtn.textContent = 'Menu';
        }
    });

    navLinks.querySelectorAll('a').forEach(link => {
        link.addEventListener('click', () => {
            navLinks.classList.remove('active');
            menuBtn.setAttribute('aria-expanded', 'false');
            menuBtn.textContent = 'Menu';
        });
    });
});