package co.edu.uco.publiuco.api.response.dto;

import co.edu.uco.publiuco.crosscutting.utils.UtilObject;
import static co.edu.uco.publiuco.crosscutting.utils.UtilText.EMPTY;

import co.edu.uco.publiuco.crosscutting.utils.UtilText;
import co.edu.uco.publiuco.api.response.enumeration.MessageLevel;

public class Message {
    private String text;
    private String title;
    private MessageLevel level;

    private Message(String text, String title, MessageLevel level) {
        setText(text);
        ;
        setTitle(title);
        ;
        setLevel(level);
        ;
    }

    public static Message createMessage(String text, String title, MessageLevel level) {
        return new Message(text, title, level);
    }

    public static Message createMessage(String text, MessageLevel level) {
        return new Message(text, text, level);
    }

    public static Message createErrorMessage(String text, String title) {
        return new Message(text, title, MessageLevel.ERROR);
    }

    public static Message createWarningMessage(String text, String title) {
        return new Message(text, title, MessageLevel.WARNING);
    }

    public static Message createInfoMessage(String text, String title) {
        return new Message(text, title, MessageLevel.INFORMATION);
    }

    public static Message createSuccessMessage(String text, String title) {
        return new Message(text, title, MessageLevel.SUCCESS);
    }
    public static Message createFatalMessage(String text, String title) {
        return new Message(text, title, MessageLevel.FATAL);
    }

    public final String getText() {
        return text;
    }

    public final String getTitle() {
        return title;
    }

    public final MessageLevel getLevel() {
        return level;
    }

    private final void setText(final String text) {
        if (UtilText.isNull(text)|| EMPTY.intern() == text.intern().trim()) {
            this.text = EMPTY;
        } else {
            this.text = text.trim();
        }
    }

    private final void setTitle(final String title) {
        if (UtilText.isNull(text) || EMPTY.intern() == title.intern().trim()) {
            this.title = EMPTY;
        } else {
            this.title = title.trim();
        }
    }

    private final void setLevel(final MessageLevel level) {
        if (UtilObject.getUtilObject().isNull(level)) {
            this.level = MessageLevel.FATAL;
        } else {
            this.level = level;
        }
    }
}
