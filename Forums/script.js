var filters=document.querySelectorAll(".filtersButtons");
var newThread=document.getElementById("newThread");

filters.forEach(filterButton =>{
    filterButton.addEventListener("click", function() {
        filters.forEach((btn) => btn.classList.remove("active"));
        filterButton.classList.add("active");
    })
});

document.addEventListener('DOMContentLoaded', () => {
    const newThreadBtn = document.getElementById('newThreadBtn');
    const closeFormBtn = document.getElementById('closeFormBtn');
    const newThreadForm = document.getElementById('newThreadForm');
    const cancelBtn = document.getElementById('cancelBtn');
    const postThreadBtn = document.getElementById('postThreadBtn');
    const threadTitle = document.getElementById('threadTitle');
    const threadContent = document.getElementById('threadContent');
    const tagInput = document.getElementById('tagInput');
    const addTagBtn = document.getElementById('addTagBtn');
    const tagsContainer = document.getElementById('tagsContainer');
    const postsContainer = document.getElementById('postsContainer');
  
    let tags = [];
  
    newThreadBtn.addEventListener('click', () => {
      newThreadForm.classList.remove('hidden');
    });
  
    closeFormBtn.addEventListener('click', () => {
      newThreadForm.classList.add('hidden');
    });
  
    cancelBtn.addEventListener('click', () => {
      newThreadForm.classList.add('hidden');
      resetForm();
    });
  
    postThreadBtn.addEventListener('click', () => {
      const title = threadTitle.value.trim();
      const content = threadContent.value.trim();
  
      if (title && content) {
        const newPost = createPost(title, content, tags);
        postsContainer.insertBefore(newPost, postsContainer.firstChild);
        resetForm();
        newThreadForm.classList.add('hidden');
      }
    });
  
    tagInput.addEventListener('keydown', (e) => {
      if (e.key === 'Enter') {
        e.preventDefault();
        addTag();
      }
    });
  
    addTagBtn.addEventListener('click', addTag);
  
    function addTag() {
      const tag = tagInput.value.trim();
      if (tag && !tags.includes(tag)) {
        tags.push(tag);
        renderTags();
        tagInput.value = '';
      }
    }
  
    function renderTags() {
      tagsContainer.innerHTML = '';
      tags.forEach(tag => {
        const tagElement = document.createElement('div');
        tagElement.className = 'tag';
        tagElement.textContent = tag;
        const removeBtn = document.createElement('button');
        removeBtn.textContent = '✕';
        removeBtn.addEventListener('click', () => removeTag(tag));
        tagElement.appendChild(removeBtn);
        tagsContainer.appendChild(tagElement);
      });
    }
  
    function removeTag(tagToRemove) {
      tags = tags.filter(tag => tag !== tagToRemove);
      renderTags();
    }
  
    function resetForm() {
      threadTitle.value = '';
      threadContent.value = '';
      tags = [];
      renderTags();
    }
  
    function createPost(title, content, tags) {
      const post = document.createElement('div');
      post.className = 'card';
      post.innerHTML = `
        <div class="card-content">
          <div class="flex items-start gap-3 mb-4">
            <div class="avatar"></div>
            <div class="flex-1">
              <div class="flex justify-between">
                <div>
                  <p></p>
                  <p>Just now</p>
                </div>
                <button class="btn-ghost text-sm text-teal-500">Help & Support</button>
              </div>
            </div>
          </div>
          <h2>${title}</h2>
          <p class="mb-4">${content}</p>
          ${tags.length ? `
            <div class="flex flex-wrap gap-2 mb-4">
              ${tags.map(tag => `<div class="tag">${tag}</div>`).join('')}
            </div>
          ` : ''}
          <div class="flex items-center gap-4 pt-2 border-t">
            <button class="btn-ghost text-muted-foreground">❤️ 0 Likes</button>
            <button class="btn-ghost text-muted-foreground">💬 0 Replies</button>
            <button class="btn-ghost text-muted-foreground">Share</button>
          </div>
        </div>
      `;
      return post;
    }
  });