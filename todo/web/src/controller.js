/* 
    Created on : 8/10/2023
    Author     : juand
*/

const app = angular.module('todoApp', []);
app.controller('TodoController', ['$http', controller]);
  
function controller($http) {
  let todoList = this;
  todoList.tasks = [];

  comprobe = function() {
    $http({
      method: 'GET',
      url:'tasks/list.jsp'
    }).then((res) => {
      if (res.data.status) {
        todoList.tasks = Object.values(res.data.tasks);
      } else {
        todoList.tasks = [];
      }
    }).catch(() => {
      alert('ups...');
    });
  };

  comprobe();

  todoList.addTask = function() {
    if (todoList.taskText.legth < 2) return;
    $http({
      method: 'POST',
      url: 'tasks/add.jsp',
      params: {
        title: todoList.taskText,
        description: todoList.descriptionText ?? ''
      }
    }).then((res) => {
      if (res.data.status) {
        comprobe();
        todoList.taskText = '';
      }
    });
  };

  todoList.markTask = function(id) {
    $http({
      method: 'POST',
      url: 'tasks/update.jsp',
      params: {
        id: id
      }
    }).then((res) => {
      if (res.data.status) {
        comprobe();
      }
    });
  };

  todoList.deleteTask = function(id) {
    $http({
      method: 'POST',
      url: 'tasks/delete.jsp',
      params: {
        id: id
      }
    }).then((res) => {
      if (res.data.status) {
        comprobe();
      }
    });
  };

};