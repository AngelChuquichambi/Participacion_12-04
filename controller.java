package com.emergentes.controlador;

import com.emergentes.modelo.gestortareas;
import com.emergentes.modelo.tarea;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "controller", urlPatterns = {"/controller"})
public class controller extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        tarea t = new tarea();
        int id, pos;
        String opcion = request.getParameter("op");
        String op = (opcion != null) ? opcion : "view";

        if (op.equals("nuevo")) {
            HttpSession ses = request.getSession();
            gestortareas ag = (gestortareas) ses.getAttribute("agenda");
            t.setId(ag.obtieneId());
            request.setAttribute("op", op);
            request.setAttribute("mitarea", t);
            request.getRequestDispatcher("editar.jsp").forward(request, response);

        }

        if (op.equals("modificar")) {
            id = Integer.parseInt(request.getParameter("id"));
            HttpSession ses = request.getSession();
            gestortareas ag = (gestortareas) ses.getAttribute("agenda");
            pos = ag.ubicarTarea(id);
            t = ag.getLista().get(pos);

            request.setAttribute("op", op);
            request.setAttribute("mitarea", t);
            request.getRequestDispatcher("editar.jsp").forward(request, response);
        }

        if (op.equals("eliminar")) {
            id = Integer.parseInt(request.getParameter("id"));
            HttpSession ses = request.getSession();
            gestortareas ag = (gestortareas) ses.getAttribute("agenda");
            pos = ag.ubicarTarea(id);
            ag.eliminarTarea(pos);
            ses.setAttribute("agenda", ag);
            response.sendRedirect("index.jsp");
        }

        if (op.equals("view")) {
            response.sendRedirect("index.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        tarea t = new tarea();
        int pos;
        String op = request.getParameter("op");

        if (op.equals("grabar")) {

            t.setId(Integer.parseInt(request.getParameter("id")));
            t.setTarea(request.getParameter("tarea"));
            t.setPrioridad(request.getParameter("prioridad"));

            HttpSession ses = request.getSession();
            gestortareas ag = (gestortareas) ses.getAttribute("agenda");

            String opg = request.getParameter("opg");
            if (opg.equals("nuevo")) {
                ag.insertarTarea(t);
            } else {
                pos = ag.ubicarTarea(t.getId());
                ag.modificarTarea(pos, t);
            }
            ses.setAttribute("agenda", ag);
            response.sendRedirect("index.jsp");
        }

    }

}
