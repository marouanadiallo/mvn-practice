package com.alphamar.powa.web;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class SimpleServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/plain");
        try {
            response.getWriter().println("Hello, World from POWA !");
        } catch (IOException ignored) {

        }
    }
}
