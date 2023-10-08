<%-- 
    Document   : add
    Created on : 8/10/2023
    Author     : juand
--%>

<%@page import="Controller.Tasks"%>
<%@page contentType="application/json;charset=iso-8859-1" language="java" pageEncoding="iso-8859-1" session="true"%>

<%
  String title = request.getParameter("title");
  String description = request.getParameter("description");
  boolean done = Tasks.addTask(title, description);
  response.setContentType("application/json;charset=iso-8859-1");
  out.print(String.format("{\"status\": %s, \"title\": \"%s\", \"description\": \"%s\"}", done, title, description));
%>

