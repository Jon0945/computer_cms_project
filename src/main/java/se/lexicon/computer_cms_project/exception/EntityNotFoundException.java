package se.lexicon.computer_cms_project.exception;

public class EntityNotFoundException extends RuntimeException {
    public EntityNotFoundException() { super(); }
    public EntityNotFoundException(String message) { super(message); }

}
