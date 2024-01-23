package fr.eni.base;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@WebServlet("/login")
public class Login extends HttpServlet {

    private HttpSession session;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        session = req.getSession(false);
        System.out.println("Session: " + session);
        if (session == null) {
            req.getRequestDispatcher("/WEB-INF/base/login.jsp").forward(req, resp);
        }
        req.getRequestDispatcher("/WEB-INF/base/dashboard.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        boolean valid = Objects.equals(req.getParameter("valid"), "on");
        if (valid) {
            session = req.getSession();
            req.getRequestDispatcher("/WEB-INF/base/dashboard.jsp").forward(req, resp);
        }
        req.setAttribute("error", "Login failed");
        req.getRequestDispatcher("/WEB-INF/base/login.jsp").forward(req, resp);
    }
}
