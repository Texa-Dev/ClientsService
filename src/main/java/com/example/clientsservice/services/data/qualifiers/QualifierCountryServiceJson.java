package com.example.clientsservice.services.data.qualifiers;

import org.springframework.beans.factory.annotation.Qualifier;

import java.lang.annotation.*;

@Qualifier("countryServiceJson")
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface QualifierCountryServiceJson {
}
