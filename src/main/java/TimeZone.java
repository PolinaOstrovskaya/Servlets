import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.Date;
import static java.util.TimeZone.getTimeZone;

//@WebServlet("/time/*")
public class TimeZone extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
                 String pathInfo = req.getPathInfo();
                String city = pathInfo.substring(1); // Удаляем первый символ, который является "/"

                String time = "";
                switch(city) {
                    case "minsk":
                        time = getTimeInMinsk();
                        break;
                    case "washington":
                        time = getTimeInWashington();
                        break;
                    case "beijing":
                        time = getTimeInBeijing();
                        break;
                    default:
                        time = "Город не найден";
                }

                resp.setContentType("text/html");
                PrintWriter out = resp.getWriter();
                out.println("Текущее время в " + city + ": " + time );
            }

    private String getTimeInMinsk() {
        ZoneId zoneId =ZoneId.of("Europe/Minsk");
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        Date currentTime = new Date();
        dateFormat.setTimeZone(getTimeZone(zoneId));
        return dateFormat.format(currentTime);
    }

private String getTimeInWashington() {
    ZoneId zoneId =ZoneId.of("America/New_York");
    SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    Date currentTime = new Date();
    dateFormat.setTimeZone(getTimeZone(zoneId));
    return dateFormat.format(currentTime);}

private String getTimeInBeijing() {
    ZoneId zoneId =ZoneId.of("Asia/Shanghai");
    SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    Date currentTime = new Date();
    dateFormat.setTimeZone(getTimeZone(zoneId));
    return dateFormat.format(currentTime);}
}


