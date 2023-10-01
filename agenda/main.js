//function to submit form

if (localStorage.getItem('agenda_calumet') === null) {
  console.log('No hay datos');
  localStorage.setItem('agenda_calumet', JSON.stringify([]));
} else {
  render();
}

function submitForm(e){
  e.preventDefault();
  add(e.target);
  render();
  console.log(e.target);
}

function clear(form) {
  form.name.value = '';
  form.lastname.value = '';
  form.document.value = '';
  form.document_type.value = '';
  form.phone.value = '';
  form.email.value = '';
  form.address.value = '';
  form.name.focus();
}

function add(form) {
  const newContact = {
    name: form.name.value,
    lastName: form.lastname.value,
    document: form.document.value,
    document_type: form.document_type.value,
    phone: form.phone.value,
    email: form.email.value,
    address: form.address.value,
    fav: form.favourite.checked ? '✅' : '❌',
  };
  const oldAgenda = JSON.parse(localStorage.getItem('agenda_calumet'));
  if (oldAgenda.find(contact => contact.document === newContact.document) ||
      oldAgenda.find(contact => contact.phone === newContact.phone) ||
      oldAgenda.find(contact => contact.email === newContact.email)) {
    alert('El contacto ya existe');
    return;
  }
  localStorage.setItem('agenda_calumet', JSON.stringify([...oldAgenda, newContact]));
  clear(form);
}

function deleteContact(index) {
  const oldAgenda = JSON.parse(localStorage.getItem('agenda_calumet'))
  oldAgenda.splice(index, 1);
  localStorage.setItem('agenda_calumet', JSON.stringify(oldAgenda));
  render();
}

function render() {
  const table = document.querySelector('table tbody');
  table.innerHTML = '';
  JSON.parse(localStorage.getItem('agenda_calumet')).forEach((contact, index) => {
    const row = table.insertRow();
    row.innerHTML = `
      <td>${contact.name}</td>
      <td>${contact.lastName}</td>
      <td>${contact.document}</td>
      <td>${contact.document_type}</td>
      <td>${contact.phone}</td>
      <td>${contact.email}</td>
      <td>${contact.address}</td>
      <td>${contact.fav}</td>
      <td class="row w-1 ml-2 gap-2 justify-content-center dropdown">
        <button
          class="btn btn-primary dropdown-toggle"
          type="button"
          id="dropdownMenuButton"
          data-mdb-toggle="dropdown"
          aria-expanded="false"
        >
        </button>
        <div class="row dropdown-menu p-2 g-1 mt-4" aria-labelledby="dropdownMenuButton">
          <button class="row-1 btn btn-primary" onclick="moveUp(${index})">⬆️</button>
          <button class="row-1 btn btn-primary" onclick="moveDown(${index})">⬇️</button>
          <button class="row-1 btn btn-danger" onclick="deleteContact(${index})">🗑️</button>
        </div>
      </td>
    `;
  });
}

function moveUp(index) {
  const oldAgenda = JSON.parse(localStorage.getItem('agenda_calumet'));
  if (index === 0) return;
  const aux = oldAgenda[index];
  oldAgenda[index] = oldAgenda[index - 1];
  oldAgenda[index - 1] = aux;
  localStorage.setItem('agenda_calumet', JSON.stringify(oldAgenda));
  render();
}

function moveDown(index) {
  const oldAgenda = JSON.parse(localStorage.getItem('agenda_calumet'));
  if (index === oldAgenda.length - 1) return;
  const aux = oldAgenda[index];
  oldAgenda[index] = oldAgenda[index + 1];
  oldAgenda[index + 1] = aux;
  localStorage.setItem('agenda_calumet', JSON.stringify(oldAgenda));
  render();
}

function orderByName() {
  const oldAgenda = JSON.parse(localStorage.getItem('agenda_calumet'));
  oldAgenda.sort((a, b) => {
    if (a.name > b.name) return 1;
    if (a.name < b.name) return -1;
  });
  localStorage.setItem('agenda_calumet', JSON.stringify(oldAgenda));
  render();
}

function orderByLastName() {
  const oldAgenda = JSON.parse(localStorage.getItem('agenda_calumet'));
  oldAgenda.sort((a, b) => {
    if (a.lastName > b.lastName) return 1;
    if (a.lastName < b.lastName) return -1;
  });
  localStorage.setItem('agenda_calumet', JSON.stringify(oldAgenda));
  render();
}

function orderByFav() {
  const oldAgenda = JSON.parse(localStorage.getItem('agenda_calumet'));
  oldAgenda.sort((a, b) => {
    if (a.fav > b.fav) return 1;
    if (a.fav < b.fav) return -1;
  });
  localStorage.setItem('agenda_calumet', JSON.stringify(oldAgenda));
  render();
}

document.querySelector('form').addEventListener('submit', submitForm);
document.querySelector('#fav-h').addEventListener('click', orderByFav);
document.querySelector('#name-h').addEventListener('click', orderByName);
document.querySelector('#lastname-h').addEventListener('click', orderByLastName);