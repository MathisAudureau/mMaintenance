package fr.mathis.api.utils.annotation;

public @interface PluginAnnotation {

    String Name() default "";

    String Version() default "1.0.0";

    String Main() default "";

    String Licence() default "";

}
