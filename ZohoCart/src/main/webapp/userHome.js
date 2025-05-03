document.addEventListener("DOMContentLoaded", function(){
	fetch("DashboardServlet",{
		method:"GET",
		headers:{
			'Content-Type':'application/json'
		},
		credentials:"include"
	}).then(response => response.json())
	.then(data => {
		if(data.status=="success"){
			console.log(data);
			document.title=data.name + " - Dashboard";
			document.getElementById("userName").textContent=data.name;
			document.getElementById("profileName").textContent=data.name;
			document.getElementById("userRole").textContent=data.role;
			document.getElementById("profileIcon").textContent=(data.name).slice(0,2);
		}
		else{
			console.log(data.message);
		}
	})
});


document.getElementById("logout").addEventListener("click", function(){
	fetch("LogoutServlet",{
		method:"POST",
		headers:{
			'Content-Type':"application/json"
		},
		credentials:"include"
	}).then(response => response.json())
	.then(data => {
		if(data.status=="success"){
			console.log(data);
			window.location.href=data.redirect;
		}
		else{
			alert(data.message);
		}
	})
	.catch(error => console.error(error))
});



const profileButton = document.getElementById('profileButton');
const profileDropdown = document.getElementById('profileDropdown');
const tabs = document.querySelectorAll('.tab');
const tabContents = document.querySelectorAll('.tab-content');

function initAnimations() {
}

function initProfileDropdown() {
  if (profileButton && profileDropdown) {
    profileButton.addEventListener('click', function(e) {
      e.stopPropagation();
      profileDropdown.classList.toggle('active');
    });

    document.addEventListener('click', function(e) {
      if (!profileButton.contains(e.target) && !profileDropdown.contains(e.target)) {
        profileDropdown.classList.remove('active');
      }
    });
  }
}

function initTabs() {
  tabs.forEach(tab => {
    tab.addEventListener('click', () => {
      const tabId = tab.getAttribute('data-tab');
      
      tabs.forEach(t => t.classList.remove('active'));
      tabContents.forEach(content => content.classList.remove('active'));
      
      tab.classList.add('active');
      document.getElementById(tabId).classList.add('active');
    });
  });
}

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

function initAddToCart() {
  const addToCartButtons = document.querySelectorAll('.btn-add-cart');
  
  addToCartButtons.forEach(button => {
    button.addEventListener('click', function(e) {
      e.preventDefault();
      
      const productCard = this.closest('.product-card');
      const productName = productCard.querySelector('.product-name').textContent;
      
      const cartBadge = document.querySelector('.nav-button .badge');
      if (cartBadge) {
        const currentCount = parseInt(cartBadge.textContent);
        cartBadge.textContent = currentCount + 1;
      }
      
      alert(`Added ${productName} to your cart!`);
    });
  });
}

function init() {
  initAnimations();
  initProfileDropdown();
  initTabs();
  initProductAnimations();
  initAddToCart();
}

document.addEventListener('DOMContentLoaded', init);

const welcomeSection = document.querySelector('.welcome-card');
if (welcomeSection) {
  setTimeout(() => {
    welcomeSection.classList.add('fade-in');
  }, 300);
}

const offersSection = document.querySelector('.offers-card');
if (offersSection) {
  setTimeout(() => {
    offersSection.classList.add('fade-in');
  }, 500);
}

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