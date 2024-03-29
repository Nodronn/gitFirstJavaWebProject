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
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

@WebServlet("/edit")
public class EditPerson extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String tempId = request.getParameter("id");
        int id = Integer.parseInt(tempId);
        Person person = PersonDao.getOnePerson(id);
        request.setAttribute("person", person);
        getServletContext().getRequestDispatcher("/edit.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String tempId = request.getParameter("id");
        int id = Integer.parseInt(tempId);
        String userName=request.getParameter("userName");
        String userPass= EncryptDecryptPassword.encrypt(request.getParameter("userPass"));
        String userEmail=request.getParameter("userEmail");
        String userCountry=request.getParameter("userCountry");

        Person person = new Person();
        person.setId(id);
        person.setUserName(userName);
        person.setUserPass(userPass);
        person.setUserEmail(userEmail);
        person.setUserCountry(userCountry);

        int status = PersonDao.updateUserInfo(person);
        if (status > 0){
            HttpSession httpSession = request.getSession();
            httpSession.setAttribute("userName", person.getUserName());
            httpSession.setAttribute("userEmail", person.getUserEmail());
            httpSession.setAttribute("userCountry", person.getUserCountry());
            httpSession.setAttribute("userId", person.getId());
            System.out.println(person.getId());
            System.out.println(person.getUserName());
            System.out.println(person.getUserEmail());
            System.out.println(person.getUserCountry());
            response.sendRedirect("authed_person.jsp");
        }

    }

}
