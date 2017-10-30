<%-- 
    Document   : index
    Created on : Oct 30, 2017, 2:46:24 AM
    Author     : Santiago Neira <sant.neira@profesor.duoc.cl>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Subida de Archivos</title>
    </head>
    <body>
        <h1>Subida de Archivos</h1>
        <form method="post" action="UploadServlet" enctype="multipart/form-data">
            Selecciona un documento para guardar:
            <input type="file" name="archivo" /><br />
            <button type="submit">Guardar</button>
        </form>
    </body>
</html>
