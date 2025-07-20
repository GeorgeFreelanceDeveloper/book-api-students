const apiUrl = '/books';

window.onload = () => {
    loadBooks();

    document.getElementById('bookForm').addEventListener('submit', handleFormSubmit);
    document.getElementById('searchButton').addEventListener('click', searchBookById);
    document.getElementById('cancelEditButton').addEventListener('click', resetForm);
};

function loadBooks() {
    fetch(apiUrl)
        .then(res => res.json())
        .then(data => {
            const tbody = document.getElementById('bookTableBody');
            tbody.innerHTML = '';
            data.forEach(book => {
                const row = document.createElement('tr');
                row.innerHTML = `
          <td>${book.id}</td>
          <td>${book.isbn}</td>
          <td>${book.title}</td>
          <td>${book.author}</td>
          <td>${book.publisher}</td>
          <td>${book.type}</td>
          <td>
            <button onclick="editBook(${book.id})">Upravit</button>
            <button onclick="deleteBook(${book.id})">Smazat</button>
          </td>
        `;
                tbody.appendChild(row);
            });
        });
}

function handleFormSubmit(event) {
    event.preventDefault();

    const id = document.getElementById('bookId').value;
    const isbn = document.getElementById('isbn').value;
    const title = document.getElementById('title').value;
    const author = document.getElementById('author').value;
    const publisher = document.getElementById('publisher').value;
    const type = document.getElementById('type').value;

    const bookData = { isbn, title, author, publisher, type };

    if (id) {
        fetch(`${apiUrl}/${id}`, {
            method: 'PUT',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(bookData)
        }).then(() => {
            resetForm();
            loadBooks();
        });
    } else {
        fetch(apiUrl, {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(bookData)
        }).then(() => {
            resetForm();
            loadBooks();
        });
    }
}

function editBook(id) {
    fetch(`${apiUrl}/${id}`)
        .then(res => {
            if (!res.ok) throw new Error('Kniha nenalezena');
            return res.json();
        })
        .then(book => {
            document.getElementById('bookId').value = book.id;
            document.getElementById('isbn').value = book.isbn;
            document.getElementById('title').value = book.title;
            document.getElementById('author').value = book.author;
            document.getElementById('publisher').value = book.publisher;
            document.getElementById('type').value = book.type;

            document.getElementById('submitButton').textContent = 'Upravit knihu';
            document.getElementById('cancelEditButton').classList.remove('hidden');
        })
        .catch(() => alert('Kniha s tímto ID neexistuje'));
}

function resetForm() {
    document.getElementById('bookForm').reset();
    document.getElementById('bookId').value = '';
    document.getElementById('submitButton').textContent = 'Přidat knihu';
    document.getElementById('cancelEditButton').classList.add('hidden');
}

function deleteBook(id) {
    if (!confirm('Opravdu chcete tuto knihu smazat?')) return;

    fetch(`${apiUrl}/${id}`, { method: 'DELETE' })
        .then(() => loadBooks());
}

function searchBookById() {
    const id = document.getElementById('searchId').value;
    if (!id) {
        alert('Zadejte ID knihy');
        return;
    }

    fetch(`${apiUrl}/${id}`)
        .then(res => {
            if (!res.ok) throw new Error('Kniha nenalezena');
            return res.json();
        })
        .then(book => {
            alert(`Kniha ID: ${book.id}\nISBN: ${book.isbn}\nNázev: ${book.title}\nAutor: ${book.author}\nVydavatel: ${book.publisher}\nTyp: ${book.type}`);
        })
        .catch(() => alert('Kniha s tímto ID neexistuje'));
}
