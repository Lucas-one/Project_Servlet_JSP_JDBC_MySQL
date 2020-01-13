package Annotation;
//import java.lang.annotation.*;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//������ �� �ִ� Ÿ�� ����
//���⼭�� method���𿡸� ������ �� �ֵ��� ����
@Target({ElementType.METHOD})
//Annotation�� ���� ��å
@Retention(RetentionPolicy.RUNTIME)

public @interface PrintAnnotation {
	//Basic element
	//�⺻ element�ڿ��� �ݵ�� ()�־���Ѵ�.
	//�żҵ��� ���� �����ʱ�
	String value() default "-";
	int number() default 5;
	
}
