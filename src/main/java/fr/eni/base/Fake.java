package fr.eni.base;

import com.mysql.cj.conf.ConnectionUrlParser;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.*;
import java.util.regex.Pattern;

import static java.nio.charset.StandardCharsets.UTF_8;

@WebServlet("/fake")
public class Fake extends HttpServlet {

    /* Check wether a token is present in the cookies */
    private Cookie findToken(Cookie[] cookies) {
        String TOKEN_REGEX = "[a-f0-9]{8}-[a-f0-9]{4}-4[a-f0-9]{3}-[89aAbB][a-f0-9]{3}-[a-f0-9]{12}";
        Pattern pattern = Pattern.compile(TOKEN_REGEX);

        List<String> matchingCookiesName = Arrays.stream(cookies)
                .map(Cookie::getName)
                .filter(cookieName -> pattern.matcher(cookieName).find())
                .toList();

        if (matchingCookiesName.isEmpty()) {
            return null;
        }

        String cookieName = matchingCookiesName.get(0);
        List<Cookie> matchingCookies = Arrays.stream(cookies)
                .filter(cookie -> Objects.equals(cookie.getName(), cookieName))
                .toList();

        return matchingCookies.get(0);
    }

    /* Generate a token from an email and a password */
    private String encodeToken(String email, String password) {
        Base64.Encoder encoder = Base64.getEncoder();
        String formattedString = email + ":" + password;
        byte[] data = formattedString.getBytes(UTF_8);
        return encoder.encodeToString(data);
    }

    /* Get the email and the password of a token */
    private Map<String, String> decodeToken(String token) {
        Base64.Decoder decoder = Base64.getDecoder();
        byte[] bytes = decoder.decode(token);
        String decodedString = new String(bytes, UTF_8);
        String[] splittedString = decodedString.split(":");
        return Map.of("email", splittedString[0], "password", splittedString[1]);
    }

    /* Create a cookie for the token */
    private Cookie generateTokenCookie(String token) {
        int ONE_MONTH = 2_630_000;
        UUID uuid = UUID.randomUUID();
        Cookie cookie = new Cookie(uuid.toString(), token);
        cookie.setMaxAge(ONE_MONTH);
        return cookie;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();

        if (cookies == null) {
            req.getRequestDispatcher("/WEB-INF/base/fake-login.jsp").forward(req, resp);
            return;
        }

        Cookie tokenCookie = findToken(cookies);

        if (tokenCookie == null) {
            req.getRequestDispatcher("/WEB-INF/base/fake-login.jsp").forward(req, resp);
            return;
        }

        req.setAttribute("token", tokenCookie.getValue());
        Map<String, String> userInfos = decodeToken(tokenCookie.getValue());
        /*
        for (Map.Entry<String, String> credential : userInfos.entrySet()) {
            req.setAttribute(credential.getKey(), credential.getValue());
        }
        */
        userInfos.forEach(req::setAttribute);
        req.getRequestDispatcher("/WEB-INF/base/user-info.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        boolean remember = Objects.equals(req.getParameter("remember"), "on");
        String email = req.getParameter("email");
        String password  = req.getParameter("password");
        String token = null;

        if (remember) {
            token = encodeToken(email, password);
            Cookie tokenCookie = generateTokenCookie(token);
            resp.addCookie(tokenCookie);
        }

        req.setAttribute("email", email);
        req.setAttribute("password", password);
        req.setAttribute("token", token);
        req.getRequestDispatcher("/WEB-INF/base/user-info.jsp").forward(req, resp);
    }
}
