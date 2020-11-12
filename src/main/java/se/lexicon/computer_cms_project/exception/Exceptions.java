package se.lexicon.computer_cms_project.exception;

import java.util.function.Supplier;

public class Exceptions {
    public static Supplier<EntityNotFoundException> entityNotFoundException(String message) {
        return() -> new EntityNotFoundException(message);
    }
}
