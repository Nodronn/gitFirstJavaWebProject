package org.example.crud;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/updater")
public class UpdatePerson extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String tempId = request.getParameter("id");
        int id = Integer.parseInt(tempId);
        Person person = PersonDao.getOnePerson(id);
        request.setAttribute("person", person);
        getServletContext().getRequestDispatcher("/updater.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String tempId = request.getParameter("id");
        int id = Integer.parseInt(tempId);
        String userName=request.getParameter("userName");
        String userPass=request.getParameter("userPass");
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
            response.sendRedirect("view");
        }

    }

}
