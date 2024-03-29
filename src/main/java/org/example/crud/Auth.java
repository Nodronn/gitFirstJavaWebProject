package org.example.crud;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

@WebServlet("/auth")
public class Auth extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter printWriter = response.getWriter();

        String userEmail = request.getParameter("userEmail");
        String userPass = EncryptDecryptPassword.encrypt(request.getParameter("userPass"));

        Person person = new Person();
        person.setUserPass(userPass);
        person.setUserEmail(userEmail);

        if (PersonDao.checkPersonIfExists(person) != null) {
            Person returnedPerson = PersonDao.checkPersonIfExists(person);
            HttpSession httpSession = request.getSession();
            httpSession.setAttribute("userName", returnedPerson.getUserName());
            httpSession.setAttribute("userEmail", returnedPerson.getUserEmail());
            httpSession.setAttribute("userCountry", returnedPerson.getUserCountry());
            httpSession.setAttribute("userId", returnedPerson.getId());
            httpSession.setAttribute("userPermission", returnedPerson.getUserPermission());
            System.out.println(returnedPerson.getId());
            System.out.println(returnedPerson.getUserPermission());
            System.out.println(returnedPerson.getUserName());
            System.out.println(returnedPerson.getUserEmail());
            System.out.println(returnedPerson.getUserCountry());
            response.sendRedirect("authed_person.jsp");
        }
        else{
            printWriter.print("<h1>User auth error</h1>");
            request.getRequestDispatcher("authorization.html").include(request,response);
        }

        printWriter.close();
    }
}
