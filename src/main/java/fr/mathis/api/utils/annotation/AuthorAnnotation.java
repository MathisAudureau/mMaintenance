package fr.mathis.api.utils.annotation;

public @interface AuthorAnnotation {

    String[] Name() default {};

    String[] Github() default {"https://github.com/"};

}
