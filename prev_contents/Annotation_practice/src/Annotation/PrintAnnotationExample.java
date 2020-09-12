package Annotation;
import java.lang.reflect.InvocationTargetException;
//reflect는 동적으로 실행할때 클래스의 메타정보를 조사하는 것
import java.lang.reflect.Method;

public class PrintAnnotationExample {

	public static void main(String[] args) {
		//일반 배열선언과 헷갈리지 말자
		//annotation의 정보를 읽어서 Method배열로 받는다.
		//왜냐하면 Method[] 타입은 다른 패키지에서 만든 클래스이다.
		Method[] declaredMethods = Service.class.getDeclaredMethods();

		for(Method method : declaredMethods) {
			//System.out.println(method.getName());
			if(method.isAnnotationPresent(PrintAnnotation.class)) {
			
				PrintAnnotation printAnnotation = 
						method.getAnnotation(PrintAnnotation.class);
				//메소드 이름 출력
				System.out.println("[" + method.getName() + "]");
				
				//구분선 출력
				for(int i = 0; i<printAnnotation.number(); i++) {
					System.out.print(printAnnotation.value());
				}
				System.out.println();
				
				//메소드 호출
				try {
					//Service 객체를 만들어서 method1,2,3()을 호출한다고 생각
					method.invoke(new Service());
				}catch (Exception e) {
				}
				System.out.println();
				
			}
			
		}
	}

}
