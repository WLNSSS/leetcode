package javabase;

public class CustomException extends Exception{
	//�޲ι��췽��
		public CustomException(){
			
			super();
		}
		
		//�вεĹ��췽��
		public CustomException(String message){
			super(message);
			
		}
		
		// ��ָ������ϸ��Ϣ��ԭ����һ���µ��쳣
		public CustomException(String message, Throwable cause){
			
			super(message,cause);
		}
		
		//��ָ��ԭ����һ���µ��쳣
		 public CustomException(Throwable cause) {
			 
			 super(cause);
		 }
}
