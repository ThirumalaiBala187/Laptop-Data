function handleCredentialResponse(response) {
    console.log("ID Token: " + response.credential);
    fetch('/auth/google', {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify({ token: response.credential })
    })
    .then(res => res.json())
    .then(data => console.log("User signed in:", data));
  }
  
  window.google.accounts.id.initialize({
    client_id: 'YOUR_GOOGLE_CLIENT_ID',
    callback: handleCredentialResponse
  });
  window.google.accounts.id.prompt(); // Optional: Auto-prompts the login