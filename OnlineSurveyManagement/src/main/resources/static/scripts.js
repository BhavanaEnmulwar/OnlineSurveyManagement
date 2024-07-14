// Utility function to handle authenticated fetch requests
function authenticatedFetch(url, options = {}) {
    const token = localStorage.getItem('token');
    if (token) {
        options.headers = {
            ...options.headers,
            'Authorization': `Bearer ${token}`
        };
    }
    return fetch(url, options);
}

// Register user
document.getElementById('registerForm').addEventListener('submit', function(event) {
    event.preventDefault();

    const username = document.getElementById('username').value;
    const password = document.getElementById('password').value;

    fetch('/api/auth/register', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ username, password })
    })
    .then(response => response.json())
    .then(data => {
        alert('Registration successful');
    })
    .catch(error => {
        console.error('Error:', error);
    });
});

// Login user
document.getElementById('loginForm').addEventListener('submit', function(event) {
    event.preventDefault();

    const username = document.getElementById('username').value;
    const password = document.getElementById('password').value;

    fetch('/api/auth/login', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ username, password })
    })
    .then(response => response.json())
    .then(data => {
        localStorage.setItem('token', data.token);
        alert('Login successful');
    })
    .catch(error => {
        console.error('Error:', error);
    });
});

// Submit survey
document.getElementById('surveyForm').addEventListener('submit', function(event) {
    event.preventDefault();

    const title = document.getElementById('title').value;
    const questions = [
        document.getElementById('question1').value,
        document.getElementById('question2').value
    ];

    authenticatedFetch('/api/surveys', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ title, questions })
    })
    .then(response => response.json())
    .then(data => {
        alert('Survey submitted successfully');
    })
    .catch(error => {
        console.error('Error:', error);
    });
});

