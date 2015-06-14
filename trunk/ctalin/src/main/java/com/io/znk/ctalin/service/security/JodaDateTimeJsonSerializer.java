package com.io.znk.ctalin.service.security;

import java.io.IOException;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class JodaDateTimeJsonSerializer extends JsonSerializer<DateTime> {

    private static final String dateFormat = ("dd-MM-yyyy");

    @Override
    public void serialize(DateTime date, JsonGenerator gen, SerializerProvider provider)
            throws IOException, JsonProcessingException {

        String formattedDate = DateTimeFormat.forPattern(dateFormat).print(date);

        gen.writeString(formattedDate);
    }

}