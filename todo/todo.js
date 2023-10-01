angular.module('todoApp', [])
  .controller('TodoController', function() {
    var todoList = this;
    todoList.tasks = [];

    comprobe = function() {
      if (JSON.parse(localStorage.getItem('tasks')) === null) {
        localStorage.setItem('tasks', JSON.stringify([]));
        todoList.tasks = JSON.parse(localStorage.getItem('tasks'));
      } else {
        todoList.tasks = JSON.parse(localStorage.getItem('tasks'));
      }
    }

    comprobe();

    todoList.addTask = function() {
      comprobe();
      if (todoList.taskText.legth < 2) return;
      todoList.tasks.push({ 
        name: todoList.taskText,
        description: todoList.descriptionText,
        done: false,
        id: crypto.randomUUID() });
      todoList.taskText = '';
      localStorage.setItem('tasks', JSON.stringify(todoList.tasks));
    }

    todoList.markTask = function(id) {
      comprobe();
      todoList.tasks.forEach((task) => {
        if (task.id == id)
          task.done = !task.done;
      });
      localStorage.setItem('tasks', JSON.stringify(todoList.tasks));
    }

    todoList.deleteTask = function(id) {
      comprobe();
      todoList.tasks.forEach((task, index) => {
        if (task.id == id)
          todoList.tasks.splice(index, 1);
      });
      localStorage.setItem('tasks', JSON.stringify(todoList.tasks));
    }

  });