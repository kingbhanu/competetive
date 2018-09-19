package stackoverflow.custom.annotation.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CustomValidatorImpl.class)
@Repeatable(RepeatableCustomValidator.class)
public @interface CustomValidator {
    String message() default "error : value should be in the range";
    int min() default 1;
    int max() default Integer.MAX_VALUE;
    String format() default "dd.MM.yyyy";
    String[] values() default {};
    boolean optional() default false;
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
