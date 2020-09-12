package Annotation;
//import java.lang.annotation.*;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//적용할 수 있는 타겟 설정
//여기서는 method선언에만 적용할 수 있도록 설정
@Target({ElementType.METHOD})
//Annotation의 유지 정책
@Retention(RetentionPolicy.RUNTIME)

public @interface PrintAnnotation {
	//Basic element
	//기본 element뒤에는 반드시 ()있어야한다.
	//매소드라고 생각 하지않기
	String value() default "-";
	int number() default 5;
	
}
