package com.polarbookshop.catalogservice.domain;

//Validazione dei dati


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;

public record Book (
        //L'elemento annotato deve
        //corrispondere all'espressione
        //regolare specificata (formato
        //ISBN standard).
        @NotBlank(message = "The book ISBN must be defined.")
        @Pattern(
                regexp = "^([0-9]{10}|[0-9]{13})$",
                message = "The ISBN format must be valid."
        )
        String isbn,
        //L'elemento annotato non deve
        //essere nullo e deve contenere
        //almeno un carattere diverso da
        //uno spazio
        @NotBlank(
                message = "The book title must be defined."
        )
        String title,
        @NotBlank(message = "The book author must be defined.")
        String author,
        //l'elemento non deve
        //essere nullo e deve essere
        //maggiore di zero.
        @NotNull(message = "The book price must be defined.")
        @Positive(
                message = "The book price must be greater than zero."
        )
        Double price
){}