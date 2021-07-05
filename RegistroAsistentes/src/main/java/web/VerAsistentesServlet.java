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

@WebServlet(name = "verAsistentesServlet", urlPatterns = {"/verAsistentes"})
public class VerAsistentesServlet extends HttpServlet {

   @Inject
   AsistenteService asistenteService;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     
        List<Asistente> asistentes = asistenteService.listaAsistentes(); 
        int cantidadAsistentes = asistentes.size();
        request.setAttribute("asistente", asistentes);
        request.setAttribute("cantidad-asistentes",cantidadAsistentes);
        request.getRequestDispatcher("/WEB-INF/vistas/verAsistentes.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Asistente> asistentes = asistenteService.listaAsistentes(); 
        List<Asistente> asistentesFiltrados= new ArrayList<>();
        String filtro = request.getParameter("estado-select");
        
        if (filtro.equals("Sin filtro")) {
            doGet(request, response);
        }
        else {
        
            for(Asistente a : asistentes){
                if (a.getEstado().trim().equals(filtro)) {
                    asistentesFiltrados.add(a);
                }
            }
            request.setAttribute("asistente", asistentesFiltrados);
            request.getRequestDispatcher("/WEB-INF/vistas/verAsistentes.jsp").forward(request, response);
        }
    }
}
