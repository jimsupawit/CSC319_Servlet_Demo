package csc319.j4module.class1demo.video;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "VideoServlet", value = "/VideoServlet")
public class VideoServlet extends HttpServlet {
    private List<Video> videos = new ArrayList<Video>();

    @Override
    //Get videos information
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/plain");
        PrintWriter sendToClient = response.getWriter();
        //loop through the list and print out to client
        for (Video v: this.videos) {
            sendToClient.write(v.getName()+": "+v.getUrl()+"\n"+v.getDuration()+" minute");
        }
    }

    @Override
    //Add a new videos information
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/plain");

        String name = request.getParameter("name");
        String url = request.getParameter("url");
        String durationString = request.getParameter("duration");
        int duration = 0;
        duration = Integer.parseInt(durationString);
        if(name == null || url == null || durationString == null
                || name.trim().length() < 1 || url.trim().length() < 1
                || durationString.trim().length() < 1 || duration <= 0){
            response.sendError(400,"Missing ['name','url','duration']");
        }else {
            Video v = new Video(name, url, duration);
            videos.add(v);
            response.getWriter().write("Video added :)");
        }
    }
}
