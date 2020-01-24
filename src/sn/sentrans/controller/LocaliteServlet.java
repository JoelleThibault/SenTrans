package sn.sentrans.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/Localite", name = "localite")
public class LocaliteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //resp.getWriter().println("Ok page trouve")
        req.getRequestDispatcher("vues/localite/list.jsp").forward(req, resp);
    }
}
