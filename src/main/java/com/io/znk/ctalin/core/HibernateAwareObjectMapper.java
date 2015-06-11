package com.io.znk.ctalin.core;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.hibernate4.Hibernate4Module;

public class HibernateAwareObjectMapper extends ObjectMapper {

	private static final long serialVersionUID = 8408937958645588462L;

	public HibernateAwareObjectMapper() {
        registerModule(new Hibernate4Module());
    }
}