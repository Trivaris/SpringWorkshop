package com.torben.webshop;

import org.springframework.test.context.TestPropertySource;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@TestPropertySource(
        properties = {
                "logging.level.org.hibernate.SQL=TRACE",
                "logging.level.org.hibernate.orm.jdbc.bind=TRACE",
                "logging.level.root=OFF" })
public @interface ShowGeneratedSql {
}
