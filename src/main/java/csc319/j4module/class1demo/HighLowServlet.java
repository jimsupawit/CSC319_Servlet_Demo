package csc319.j4module.class1demo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "HighLowServlet", value = "/HighLowServlet")
public class HighLowServlet extends HttpServlet {
    //Get only one param as number
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    protected void processRequest(HttpServletRequest request,HttpServletResponse response) {
        try (PrintWriter out = response.getWriter()){
            String guessNumber = request.getParameter("number");
            int n = Integer.parseInt(guessNumber);
            HiLow h1 = new HiLow();
            String message= "";
            if (n == h1.getDiceFace()){
                message = "Congratulation you win this game";
            }
            if (n != h1.getDiceFace()){
                message = "Sorry you loss :(";
            }
            out.println(message);

        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
