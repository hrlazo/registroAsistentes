package web;

import Model.Asistente;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import servicio.AsistenteService;

@WebServlet(name = "RegistrarAsistenteServlet", urlPatterns = {"/RegistrarAsistentes"})
public class RegistrarAsistenteServlet extends HttpServlet {
    
    @Inject 
    AsistenteService asistenteService;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher("/WEB-INF/vistas/registrarAsistente.jsp").forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
   
        List<Asistente> asistentes = asistenteService.listaAsistentes();
        List<String> errores = new ArrayList<>();
        String rut = request.getParameter("rut-txt");
        
        
        for(Asistente a : asistentes){
                if (a.getRut().equals(rut)) {
                    errores.add("El rut ya existe");
                    request.setAttribute("errores", errores);
                    doGet(request, response);
                }
            }
       
        if (rut.isEmpty()) {
            errores.add("Ingrese un rut");            
        }
        //Asumi que no nos pedia verificar si el rut era valido sino que simplemente 
        //debia comprobar que era una cadena numerica con las condiciones que se nos entrego
        if (rut.matches("/[0123456789]{8,8}-{0123456789}{1,1}")) {
            errores.add("Ingrese un rut valido"); 
        }
        
        String nombre = request.getParameter("nombre-txt");
        if (nombre.isEmpty()) {
            errores.add("Ingrese un nombre");
        }
        String apellido = request.getParameter("apellido-txt");
        if (apellido.isEmpty()) {
            errores.add("Ingrese un apellido");
        }
     
        String edadTxt = request.getParameter("edad-txt");
        int edad=0;
        try {
            edad= Integer.parseInt(edadTxt);
            if (edad<18) {
                errores.add("No tiene edad suficiente");
            }
        } catch (Exception e) {
            errores.add("La edad debe ser un numero");
        }
        String empresa= request.getParameter("empresa-txt");
        if (empresa.isEmpty()) {
            errores.add("Ingrese una empresa");
        }
        //Consieramos los espacion pasa el largo de la cadena
        else if(empresa.length()<6){
            errores.add("Ingrese un nombre de empesa de al menos 6 caracteres");
        }        
        String estado= request.getParameter("estado-select");
        String region= request.getParameter("region-select");
        
        
        
        if (errores.isEmpty()) {
          Asistente asistente = new Asistente();
          asistente.setRut(rut);
          asistente.setNombre(nombre);
          asistente.setApellido(apellido);
          asistente.setEdad(edad);
          asistente.setEmpresa(empresa);
          asistente.setEstado(estado);
          asistente.setRegion(region);
          asistenteService.registrarAsistente(asistente);
          request.getRequestDispatcher("verAsistentes").forward(request, response);
          
        }   
        else{
          request.setAttribute("errores", errores);
        }
        
        doGet(request, response);
    }
}
