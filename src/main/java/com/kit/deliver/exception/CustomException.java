package com.kit.deliver.exception;

import com.kit.deliver.config.PropertiesConfig;
import com.kit.deliver.exception.widget.EntityType;
import com.kit.deliver.exception.widget.ExceptionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;
import java.util.Optional;

/**
 * @ClassName CustomException
 * @Description custom exception
 * @Author jihainan
 * @Date 2021/11/4 5:02 下午
 * @Version 1.0
 */
@Component
public class CustomException {
    private static PropertiesConfig propertiesConfig;

    @Autowired
    public CustomException(PropertiesConfig propertiesConfig) {
        CustomException.propertiesConfig = propertiesConfig;
    }

    /**
     * @Author jihainan
     * @Description Returns new RuntimeException based on template and args
     * @Date 2:06 上午 2021/11/5
     * @param messageTemplate exception message template
     * @param args other arguments
     * @return java.lang.RuntimeException
     */
    public static RuntimeException throwException(String messageTemplate, String... args) {
        return new RuntimeException(format(messageTemplate, args));
    }

    /**
     * @Author jihainan
     * @Description Returns new RuntimeException based on template and args
     * @Date 2:06 上午 2021/11/5
     * @param exceptionType exception type enum
     * @param messageTemplate exception message template
     * @param args other arguments
     * @return java.lang.RuntimeException
     */
    private static RuntimeException throwException(ExceptionType exceptionType, String messageTemplate, String... args) {
        if (ExceptionType.ENTITY_NOT_FOUND.equals(exceptionType)) {
            return new EntityNotFoundException(format(messageTemplate, args));
        } else if (ExceptionType.DUPLICATE_ENTITY.equals(exceptionType)) {
            return new DuplicateEntityException(format(messageTemplate, args));
        }
        return new RuntimeException(format(messageTemplate, args));
    }

    /**
     * @Author jihainan
     * @Description Returns new RuntimeException based on EntityType, ExceptionType and args
     * @Date 2:41 上午 2021/11/5
     * @param entityType entity type enum
     * @param exceptionType exception type enum
     * @param args others
     * @return java.lang.RuntimeException
     */
    public static RuntimeException throwException(EntityType entityType, ExceptionType exceptionType, String... args) {
        String messageTemplate = getMessageTemplate(entityType, exceptionType);
        return throwException(exceptionType, messageTemplate, args);
    }

    /**
     * @Author jihainan
     * @Description Returns new RuntimeException based on EntityType, ExceptionType and args
     * @Date 2:44 上午 2021/11/5
     * @param entityType entity type enum
     * @param exceptionType exception type enum
     * @param id entity id
     * @param args others
     * @return java.lang.RuntimeException
     */
    public static RuntimeException throwExceptionWithId(EntityType entityType, ExceptionType exceptionType, String id, String... args) {
        String messageTemplate = getMessageTemplate(entityType, exceptionType).concat(".").concat(id);
        return throwException(exceptionType, messageTemplate, args);
    }

    /**
     * @Author jihainan
     * @Description Returns new RuntimeException based on EntityType, ExceptionType, messageTemplate and args
     * @Date 2:44 上午 2021/11/5
     * @param entityType entity type enum
     * @param exceptionType exception type enum
     * @param messageTemplate message template string
     * @param args others
     * @return java.lang.RuntimeException
     */
    public static RuntimeException throwExceptionWithTemplate(EntityType entityType, ExceptionType exceptionType, String messageTemplate, String... args) {
        return throwException(exceptionType, messageTemplate, args);
    }

    /**
     * @Author jihainan
     * @Description generate format string
     * @Date 2:17 上午 2021/11/5
     * @param template template string
     * @return java.lang.String
     */
    private static String format(String template, String... args) {
        Optional<String> templateContent = Optional.ofNullable(propertiesConfig.getConfigValue(template));
        return templateContent.map(s -> MessageFormat.format(s, (Object[]) args)).orElseGet(() -> String.format(template, (Object[]) args));
    }

    private static String getMessageTemplate(EntityType entityType, ExceptionType exceptionType) {
        return entityType.name().concat(".").concat(exceptionType.getValue()).toLowerCase();
    }

    // =====================separate line=============================

    /**
     * EntityNotFoundException class
     */
    public static class EntityNotFoundException extends RuntimeException {
        public EntityNotFoundException(String message) {
            super(message);
        }
    }

    /**
     * DuplicateEntityException class
     */
    public static class DuplicateEntityException extends RuntimeException {
        public DuplicateEntityException(String message) {
            super(message);
        }
    }
}
