function toggleCreateMenu() {
    document.getElementById('createMenu').classList.toggle('hidden');
}

function searchDatabase() {
    let query = document.getElementById('searchInput').value.toLowerCase();
    document.querySelectorAll('.database-card').forEach(card => {
        let name = card.querySelector('h3').innerText.toLowerCase();
        card.style.display = name.includes(query) ? 'block' : 'none';
    });
}