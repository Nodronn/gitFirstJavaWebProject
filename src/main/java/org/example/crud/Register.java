package org.example.crud;

import java.io.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/reg")
public class Register extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter printWriter = response.getWriter();
		
		String userName=request.getParameter("userName");
        String userPass= EncryptDecryptPassword.encrypt(request.getParameter("userPass"));
        String userEmail=request.getParameter("userEmail");
		String userCountry=request.getParameter("userCountry");
		String userPermission=request.getParameter("userPermission");

		Person person = new Person();
		person.setUserName(userName);
		person.setUserPass(userPass);
		person.setUserEmail(userEmail);
		person.setUserCountry(userCountry);
		person.setUserPermission(userPermission);

		int status = PersonDao.save(person);
		if (status >0){
			printWriter.print("<h1>User successfully saved</h1>");
			response.sendRedirect("registration.html");
			//request.getRequestDispatcher("index.html").include(request,response);
		}
		else {
			printWriter.print("Something went wrong");
		}

		
		printWriter.close();
	}

}
