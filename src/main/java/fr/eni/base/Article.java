package fr.eni.base;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;

@WebServlet("/article")
@MultipartConfig
public class Article extends HttpServlet {

    public static final String IMAGES_FOLDER = "/img";
    public String uploadPath;

    @Override
    public void init() throws ServletException {
        uploadPath = getServletContext().getRealPath( IMAGES_FOLDER );
        File uploadDir = new File( uploadPath );
        if ( ! uploadDir.exists() ) uploadDir.mkdir();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/base/article.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Part part = req.getPart("image");
        String description = req.getParameter("description");

        if (part.getSize() == 0) {
            req.setAttribute("description", description);
            req.setAttribute("error", "You need to upload an image");
            req.getRequestDispatcher("/WEB-INF/base/article.jsp").forward(req, resp);
        }

        String fileName = part.getSubmittedFileName();
        String fullPath = uploadPath + File.separator + fileName;
        part.write(fullPath);

        req.setAttribute("imageName", fileName);
        req.getRequestDispatcher("/WEB-INF/base/article.jsp").forward(req, resp);
    }
}
