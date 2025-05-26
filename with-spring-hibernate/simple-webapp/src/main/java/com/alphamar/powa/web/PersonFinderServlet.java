package com.alphamar.powa.web;

import com.alphamar.pm.services.PersonProviderImp;
import com.alphamar.simplemodel.Person;
import com.alphamar.pm.services.PersonProvider;
import com.alphamar.pm.utils.PersonFormatter;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.util.Optional;

public class PersonFinderServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/plain");
        try {
            String name = request.getParameter("name");
            if (StringUtils.isBlank(name)) {
                response.getWriter().write("For search person, please use: /simple?name=your_name");
                return;
            }
            PersonProvider personProvider = PersonProviderImp.newInstance();
            Optional<Person> personOptional = personProvider.findByName(name);
            if (personOptional.isPresent()) {
                Person person = personOptional.get();
                response.getWriter().write(PersonFormatter.format(person));
            } else {
                response.getWriter().write("Person not found with name: " + name);
            }
        } catch (Exception e) {
            response.getWriter().write("Error: " + e.getMessage());
        }
    }
}
