package cl.duoc.dej.erp;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author Santiago Neira <sant.neira@profesor.duoc.cl>
 */
@WebServlet(name="UploadServlet", urlPatterns={"/UploadServlet"})
public class UploadServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet NewServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet NewServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
            
            ServletContext servletContext = getServletConfig().getServletContext();
            File repository = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
            
            diskFileItemFactory.setRepository(repository);
            
            ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
            
            List<FileItem> fileItems = servletFileUpload.parseRequest(request);
            for(FileItem fi: fileItems) {
                if(fi.isFormField()) {
                    // procesa el campo
                } else {
                    // procesa el archivo
                    String fieldName = fi.getFieldName();
                    String fileName = fi.getName();
                    String contentType = fi.getContentType();
                    long fileSize = fi.getSize();
                    boolean isInMemory = fi.isInMemory();
                    
                    String str = String.format("\n\nfieldName: %s\nfileName:%s\nContentType:%s\nFileSize:%s\nisInMemory:%s\n", fieldName, fileName, contentType, fileSize, isInMemory);
                    Logger.getLogger(UploadServlet.class.getName()).log(Level.INFO, str);
                    
                    // escribe el archivo                    
                    fi.write(new File("/home/zero/"+fileName));
                    // windows
                    //File file = new File("c:\\newfile.txt");
                    //String path = "C:" + File.separator + "hello" + File.separator + "hi.txt";
                }
            }
            
        } catch (FileUploadException ex) {
            Logger.getLogger(UploadServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(UploadServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
    

}
