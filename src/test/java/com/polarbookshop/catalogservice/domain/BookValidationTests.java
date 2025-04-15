package com.polarbookshop.catalogservice.domain;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeAll;
import jakarta.validation.Validator;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Set;

public class BookValidationTests {

    public static Validator validator;

    @BeforeAll //identifica blocco da eseguire prima di tutti i test
    static void setUp(){
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    void whenAllFieldsCorrectThenValidationSucceeds() {
        var book =
                new Book("1234567890", "Title", "Author", 9.90);
        Set<ConstraintViolation<Book>> violations =
                validator.validate(book);
        assertThat(violations).isEmpty();
    }
    @Test
    void whenIsbnDefineButIncorrectThenValidationFails(){
        var book =
                new Book("a234567890", "Title", "Author", 9.90);
        Set<ConstraintViolation<Book>> violations = validator.validate(book);
        assertThat(violations).hasSize(1);
        assertThat(violations.iterator().next().getMessage())
                .isEqualTo("The ISBN format must be valid.");
    }
}
