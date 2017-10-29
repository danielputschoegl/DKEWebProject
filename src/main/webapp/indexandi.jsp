<html>
<body>
<%@ page import="dke.pr.g3.gui.*" %>
<% IndexBeanAndi bean = new IndexBeanAndi(); %>
<%= bean.init() %>
<br>
<br>
<%= bean.getContext() %>
<br>
<br>
<%= bean.delContext() %>
<br>
<br>
<%= bean.getContext() %>
<br>
<br>
<%= bean.getParameter() %>
<br>
<br>
<%= bean.delParameter() %>
<br>
<br>
<%= bean.getParameter() %>
<br>
<br>
<%= bean.addContext() %>
<br>
<br>
<%= bean.newBC() %>
<br>
<br>
<%= bean.detUnusedParameterValues() %>
<br>
<br>
<%= bean.getContextHierarchy() %>
<br>
<br>
</body>
</html>
