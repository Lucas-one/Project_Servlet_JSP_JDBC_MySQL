package Annotation;
import java.lang.reflect.InvocationTargetException;
//reflect�� �������� �����Ҷ� Ŭ������ ��Ÿ������ �����ϴ� ��
import java.lang.reflect.Method;

public class PrintAnnotationExample {

	public static void main(String[] args) {
		//�Ϲ� �迭����� �򰥸��� ����
		//annotation�� ������ �о Method�迭�� �޴´�.
		//�ֳ��ϸ� Method[] Ÿ���� �ٸ� ��Ű������ ���� Ŭ�����̴�.
		Method[] declaredMethods = Service.class.getDeclaredMethods();

		for(Method method : declaredMethods) {
			//System.out.println(method.getName());
			if(method.isAnnotationPresent(PrintAnnotation.class)) {
			
				PrintAnnotation printAnnotation = 
						method.getAnnotation(PrintAnnotation.class);
				//�޼ҵ� �̸� ���
				System.out.println("[" + method.getName() + "]");
				
				//���м� ���
				for(int i = 0; i<printAnnotation.number(); i++) {
					System.out.print(printAnnotation.value());
				}
				System.out.println();
				
				//�޼ҵ� ȣ��
				try {
					//Service ��ü�� ���� method1,2,3()�� ȣ���Ѵٰ� ����
					method.invoke(new Service());
				}catch (Exception e) {
				}
				System.out.println();
				
			}
			
		}
	}

}
