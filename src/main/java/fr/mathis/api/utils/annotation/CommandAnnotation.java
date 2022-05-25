package fr.mathis.api.utils.annotation;

public @interface CommandAnnotation {

    String Command() default "/";
    String[] Aliases() default {};

}
