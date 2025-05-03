// DOM Elements
const profileButton = document.getElementById('profileButton');
const profileDropdown = document.getElementById('profileDropdown');
const tabs = document.querySelectorAll('.tab');
const tabContents = document.querySelectorAll('.tab-content');

// Initialize animations for background elements
function initAnimations() {
  // Background circles animation is handled by CSS
}

// Toggle profile dropdown
function initProfileDropdown() {
  if (profileButton && profileDropdown) {
    profileButton.addEventListener('click', function(e) {
      e.stopPropagation();
      profileDropdown.classList.toggle('active');
    });

    // Close dropdown when clicking outside
    document.addEventListener('click', function(e) {
      if (!profileButton.contains(e.target) && !profileDropdown.contains(e.target)) {
        profileDropdown.classList.remove('active');
      }
    });
  }
}

// Tab switching functionality
function initTabs() {
  tabs.forEach(tab => {
    tab.addEventListener('click', () => {
      const tabId = tab.getAttribute('data-tab');
      
      // Reset all tabs and contents
      tabs.forEach(t => t.classList.remove('active'));
      tabContents.forEach(content => content.classList.remove('active'));
      
      // Activate selected tab and content
      tab.classList.add('active');
      document.getElementById(tabId).classList.add('active');
    });
  });
}

// Product card animations
function initProductAnimations() {
  const productCards = document.querySelectorAll('.product-card');
  
  productCards.forEach(card => {
    card.addEventListener('mouseenter', () => {
      card.style.transform = 'translateY(-5px)';
    });
    
    card.addEventListener('mouseleave', () => {
      card.style.transform = 'translateY(0)';
    });
  });
}

// Add to cart functionality
function initAddToCart() {
  const addToCartButtons = document.querySelectorAll('.btn-add-cart');
  
  addToCartButtons.forEach(button => {
    button.addEventListener('click', function(e) {
      e.preventDefault();
      
      // Get product info
      const productCard = this.closest('.product-card');
      const productName = productCard.querySelector('.product-name').textContent;
      
      // Update cart count badge
      const cartBadge = document.querySelector('.nav-button .badge');
      if (cartBadge) {
        const currentCount = parseInt(cartBadge.textContent);
        cartBadge.textContent = currentCount + 1;
      }
      
      // Show confirmation message
      alert(`Added ${productName} to your cart!`);
    });
  });
}

// Mobile menu functionality
function initMobileMenu() {
  // Mobile tab switching handled by the tab functionality
}

// Initialize all features
function init() {
  initAnimations();
  initProfileDropdown();
  initTabs();
  initProductAnimations();
  initAddToCart();
  initMobileMenu();
}

// Run initialization
document.addEventListener('DOMContentLoaded', init);

// Add smooth scrolling for anchor links
document.querySelectorAll('a[href^="#"]').forEach(anchor => {
  anchor.addEventListener('click', function(e) {
    e.preventDefault();
    
    const targetId = this.getAttribute('href');
    if (targetId === '#') return;
    
    const targetElement = document.querySelector(targetId);
    if (targetElement) {
      window.scrollTo({
        top: targetElement.offsetTop - 80,
        behavior: 'smooth'
      });
    }
  });
});

// Add animation to welcome section
const welcomeSection = document.querySelector('.welcome-card');
if (welcomeSection) {
  setTimeout(() => {
    welcomeSection.classList.add('fade-in');
  }, 300);
}

// Add animation to special offers section
const offersSection = document.querySelector('.offers-card');
if (offersSection) {
  setTimeout(() => {
    offersSection.classList.add('fade-in');
  }, 500);
}

// Category hover effect
const categoryCards = document.querySelectorAll('.category-card');
categoryCards.forEach(card => {
  card.addEventListener('mouseenter', () => {
    card.style.transform = 'scale(1.05)';
    card.style.borderColor = '#7cc8fb';
  });
  
  card.addEventListener('mouseleave', () => {
    card.style.transform = '';
    card.style.borderColor = '';
  });
});

// Handle search input
const searchInput = document.querySelector('.search-bar input');
if (searchInput) {
  searchInput.addEventListener('keypress', function(e) {
    if (e.key === 'Enter') {
      e.preventDefault();
      alert(`Searching for: ${this.value}`);
      this.value = '';
    }
  });
}