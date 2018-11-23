package com.starlc.jvm.basic;

/**
 * ��JVM���õĽǶȷ���Java������ڴ�ռ��ʹ�ã�
 * ��JVM����������ʱ�򣬻�������·�����ҵ�����main���������ŷ��HelloJVM;
 * �ҵ�HelloJVM���ֱ�Ӷ�ȡ���ļ��еĶ��������ݲ��ҰѸ������Ϣ�ŵ������յ�Method�ڴ������У�
 * Ȼ��ᶨΪ��HelloJVM�е�main�������ֽ����в���ʼִ��main�����е�ָ�
 * Student student = new Student("dt_spark");
 * ��ʱ�ᴴ��Studentʵ��������ʹ��student��Ӧ�øö��󣨻���˵�Ըö���������������Ļ���£�
 * ��һ����JVM��ֱ�ӵ�Method������ȥ����Student�����Ϣ����ʱ����û��Student�࣬��ͨ��
 * 		����������ظ�Student���ļ���
 * �ڶ�������JVM��Method������ز��ҵ���Student��֮�����Heap������ΪStudentʵ����������ڴ�
 * 		������Student��ʵ�������г���ָ�򷽷������е�Student���Ӧ�ã��ڴ��ַ����
 * ��������JVMʵ�������ڵ�ǰ�߳���ΪStack�е�referenc����ʵ�ʵ�Ӧ�ù�ϵ����ʱ�ḳֵ��student
 * 
 * ��JVM�з����ĵ���һ���������̵߳���Ϊ��Ҳ����˵�������ñ���ᷢչ�ڵ����̵߳ķ�������ջ��
 * 	�̵߳ķ�������ջ��Method Stack Frames����ÿһ�������ĵ��þ��Ƿ�������ջ�е�һ��Frame����
 * Frame�����˷����Ĳ������ֲ���������ʱ���ݵȣ�
 * 							student.sayHello();	
 * 
 * 
 * @author hp
 *
 */
public class HelloJVM {
	/**
	 * ��JVM���е�ʱ���ͨ������ķ�ʽ��Method�����ҵ���������ڷ���main
	 * @param args
	 */
	public static void main(String[] args) {//main��������Method����������
		/**
		 * student�Ƿ������߳��е�Stack�����еģ�
		 * Student����ʵ���Ƿ��������̹߳����Heap�����еģ�
		 */
		Student student = new Student("dt_spark");
		
		/**
		 * ���Ȼ�ͨ��studentָ��(���)��Student���󣬵��ҵ��ö����
		 * ��ͨ�������ڲ�ָ�򷽷������е�ָ�������þ���ķ���ȥִ������
		 */
		student.sayHello();		
	}

}

class Student{
	//name������Ϊ��Ա�Ƿ���Stack����ģ�����nameָ���String�����Ƿ���Heap�У�
	private String name; 
	
	public Student(String name){
		this.name = name;
	}
	
	public void sayHello(){	//sayHello��������Ƿ��ڷ��������еģ�
		System.out.println("Hello, this is " + this.name);
	}
}


