package com.alphamar.pm.utils;

import com.alphamar.pm.model.Person;
import org.apache.commons.lang3.StringUtils;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.util.Objects;

public class PersonFormatter {
    private static final Logger logger = LoggerFactory.getLogger(PersonFormatter.class);

    /**
     * Formats and prints the details of a Person object.
     * If the person is null, it does nothing.
     *
     * @param person the Person object to format and print
     */
    public static String format(Person person) {
        if(Objects.isNull(person)) {
            logger.error("Formatting failed: Person object is null");
            return StringUtils.EMPTY;
        }

        Reader reader = new InputStreamReader(
                Objects.requireNonNull(PersonFormatter.class.getClassLoader().getResourceAsStream("templates/output.vm"))
        );

        VelocityContext context = new VelocityContext();
        context.put("person", person);
        StringWriter writer = new StringWriter();
        Velocity.evaluate(context, writer, "PersonFormatter", reader);
        return writer.toString();
    }
}
