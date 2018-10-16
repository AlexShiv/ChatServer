package main;

import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import webSockets.WebSocketChatServlet;

public class StartServer {

    public static void main(String[] args) {
        ServletContextHandler servlets = new ServletContextHandler(ServletContextHandler.SESSIONS); // ?
        servlets.addServlet(new ServletHolder(new WebSocketChatServlet()));
    }
}
