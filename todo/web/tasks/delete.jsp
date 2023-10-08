<%-- 
    Document   : get
    Created on : 8/10/2023
    Author     : juand
--%>

<%@page import="Controller.Tasks"%>
<%@page contentType="application/json;charset=iso-8859-1" language="java" pageEncoding="iso-8859-1" session="true"%>

<%
  String id = request.getParameter("id");
  
  Tasks.updateTasks();
  boolean done = Tasks.deleteTask(id);
  
  response.setContentType("application/json;charset=iso-8859-1");
  out.print(String.format("{\"status\": %s}", done));
%>

