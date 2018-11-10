package stackoverflow.custom.annotation.validation;


import javax.validation.*;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Set;

/**
 *
 * @url  : https://stackoverflow.com/questions/52382755/custom-validation-annotations-not-working-properly-using-java-8-repeatable
 * @type : java
 */
public class CustomValidationAnnotation {

    public static void main(String[] args) {
        Test t = new Test(150);
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<Test>> violations = validator.validate(t);
        violations.forEach(v -> {
            System.out.println(v.getMessage());
        });
    }

}