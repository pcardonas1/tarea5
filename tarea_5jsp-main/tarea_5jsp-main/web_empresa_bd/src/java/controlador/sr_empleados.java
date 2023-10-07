package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.empleado;

/**
 *
 * @author pablo
 */
public class sr_empleados extends HttpServlet; {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    empleado Empleado;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet sr_empleados</title>");            
            out.println("</head>");
            out.println("<body>");
            
            if ("agregar".equals(request.getParameter("btn_agregar"))){
            Empleado = new empleado(request.getParameter("txt_codigo"),Integer.valueOf(request.getParameter("drop_puesto")),Integer.valueOf(request.getParameter("txt_id")),request.getParameter("txt_nombres"),request.getParameter("txt_apellidos"),request.getParameter("txt_direccion"),request.getParameter("txt_telefono"),request.getParameter("txt_fn"));
            if (Empleado.agregar() > 0) {
                response.sendRedirect("index.jsp");
            /*out.println("<h1> Ingreso Exitoso </h1>");
            out.println("<a href ='index.jsp'> Regresar </a>");*/
            }else{
               out.println("<h1> Error.... </h1>"); 
               out.println("<a href ='index.jsp'> Regresar </a>");
             
             }
            }
            if ("modificar".equals(request.getParameter("btn_modificar"))){
            Empleado = new empleado(request.getParameter("txt_codigo"),Integer.valueOf(request.getParameter("drop_puesto")),Integer.valueOf(request.getParameter("txt_id")),request.getParameter("txt_nombres"),request.getParameter("txt_apellidos"),request.getParameter("txt_direccion"),request.getParameter("txt_telefono"),request.getParameter("txt_fn"));
            if (Empleado.modificar() > 0) {
                response.sendRedirect("index.jsp");
            /*out.println("<h1> Ingreso Exitoso </h1>");
            out.println("<a href ='index.jsp'> Regresar </a>");*/
            }else{
               out.println("<h1> No se modifico.... </h1>"); 
               out.println("<a href ='index.jsp'> Regresar </a>");
             
             }
            }
            if ("eliminar".equals(request.getParameter("btn_eliminar"))){
            Empleado = new empleado(request.getParameter("txt_codigo"),Integer.valueOf(request.getParameter("drop_puesto")),Integer.valueOf(request.getParameter("txt_id")),request.getParameter("txt_nombres"),request.getParameter("txt_apellidos"),request.getParameter("txt_direccion"),request.getParameter("txt_telefono"),request.getParameter("txt_fn"));
            if (Empleado.eliminar() > 0) {
                response.sendRedirect("index.jsp");
            /*out.println("<h1> No se elimino</h1>");
            out.println("<a href ='index.jsp'> Regresar </a>");*/
            }else{
               out.println("<h1> Error.... </h1>"); 
               out.println("<a href ='index.jsp'> Regresar </a>");
             
             }
            }

            
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}