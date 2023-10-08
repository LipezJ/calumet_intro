<%-- 
    Document   : todo
    Created on : 8/10/2023
    Author     : juand
--%>

<%@page import="Controller.Tasks"%>
<%@page import="Model.Task"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="com.google.gson.JsonObject"%>
<%@page import="java.util.HashMap"%>
<%@page contentType="application/json;charset=iso-8859-1" language="java" pageEncoding="iso-8859-1" session="true"%>

<%
  HashMap<String, Task> tasks = Tasks.getTaskMap();
  Gson gson = new Gson();
  
  Tasks.updateTasks();
  
  response.setContentType("application/json;charset=iso-8859-1");

  if (tasks != null && !tasks.isEmpty()) {
    JsonObject json = gson.toJsonTree(tasks).getAsJsonObject();
    out.print(String.format("{\"tasks\":%s,\"status\":true}", json));
  } else {
    out.print("{\"status\": false}");
  }
%>
