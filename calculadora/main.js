const input = document.querySelector('.k-input');

const regLast = /[-\+\*\/]$/g;
const regFilter = /(^[\+\*\/]|[-\+\*\/]$)/g;
const regComprobe = /[-\+\*\/]([\d*].)*/g;
const regNumber = /[\d*]/g;

const history = [];

function keyboard(e) {
  const target = e.target.innerHTML.trim();
  if (target === 'C') {
    input.value = '';
    return;
  } else if (target === '=') {
    const match = input.value.replace(regFilter, '');
    if (!match.match(regComprobe)) {
      alert('Invalid input');
      if (match.match(regNumber) || match === '') {
        input.value = match
        return
      }
      input.value = '';
      return;
    }
    input.value = add(input.value);
    return;
  } else if (target === 'DEL') {
	if (input.value.length > 0 )
		input.value = input.value.slice(0, -1)
	return
  }
  if (input.value.match(regLast) && target.match(regLast)) {
    console.log('match')
    input.value = input.value.replace(regLast, target);
    return;
  }
  input.value += target;
}

function add(operation) {
  const result  = eval(operation);
  if (history.length > 3) history.shift();
  history.push({
    operation,
    result
  });
  renderHistory();
  return result
}

function renderHistory() {
  const historyContainer = document.querySelector('.k-history-last');
  historyContainer.innerHTML = '';
  history.forEach((item) => {
    const div = document.createElement('div');
    div.innerHTML = `<div class="history-item">${item.operation} = ${item.result}</div>`;
    historyContainer.appendChild(div);
  });
  document.querySelectorAll('.history-item').forEach((item) => {
    item.addEventListener('click', copyFromHistory)
  });
}

function copyFromHistory(e) {
  input.value = e.target.innerHTML.split('=')[0].trim();
}

document.querySelectorAll('.button').forEach((button) => {
  button.addEventListener('click', keyboard)
});