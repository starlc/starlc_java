Ԫע������þ��Ǹ���ע������ע�⡣Java5.0������4����׼��meta-annotation���ͣ����Ǳ������ṩ������ annotation������˵����Java5.0�����Ԫע�⣺
��������1.@Target,
��������2.@Retention,
��������3.@Documented,
��������4.@Inherited
������Щ���ͺ�������֧�ֵ�����java.lang.annotation���п����ҵ����������ǿ�һ��ÿ��Ԫע������ú���Ӧ�ֲ�����ʹ��˵����
@Target��

������@Target˵����Annotation�����εĶ���Χ��Annotation�ɱ����� packages��types���ࡢ�ӿڡ�ö�١�Annotation���ͣ������ͳ�Ա�����������췽������Ա������ö��ֵ�������������ͱ��ر�������ѭ��������catch����������Annotation���͵�������ʹ����target�ɸ������������ε�Ŀ�ꡣ

�������ã���������ע���ʹ�÷�Χ��������������ע���������ʲô�ط���

����ȡֵ(ElementType)����Դ��Java.lang.annotation.ElementType�е�ö������Ԫ�أ�

��������1.CONSTRUCTOR:��������������
��������2.FIELD:����������
��������3.LOCAL_VARIABLE:���������ֲ�����
��������4.METHOD:������������
��������5.PACKAGE:����������
��������6.PARAMETER:������������
��������7.TYPE:���������ࡢ�ӿ�(����ע������) ��enum����

@Retention��

����@Retention�����˸�Annotation��������ʱ�䳤�̣�ĳЩAnnotation��������Դ�����У���������������������һЩȴ��������class�ļ��У�������class�ļ��е�Annotation���ܻᱻ��������ԣ�����һЩ��class��װ��ʱ������ȡ����ע�Ⲣ��Ӱ��class��ִ�У���ΪAnnotation��class��ʹ�����Ǳ�����ģ���ʹ�����meta-Annotation���Զ� Annotation�ġ��������ڡ����ơ�

�������ã���ʾ��Ҫ��ʲô���𱣴��ע����Ϣ����������ע����������ڣ�������������ע����ʲô��Χ����Ч��

����ȡֵ��RetentionPoicy����Դ��java.lang.annotation.RetentionPolicy��ö������ֵ��

��������1.SOURCE:��Դ�ļ�����Ч����Դ�ļ�������
��������2.CLASS:��class�ļ�����Ч����class������
��������3.RUNTIME:������ʱ��Ч��������ʱ������

@Documented:

����@Documented���������������͵�annotationӦ�ñ���Ϊ����ע�ĳ����Ա�Ĺ���API����˿��Ա�����javadoc����Ĺ����ĵ�����Documented��һ�����ע�⣬û�г�Ա��


@Inherited��

����@Inherited Ԫע����һ�����ע�⣬@Inherited������ĳ������ע�������Ǳ��̳еġ����һ��ʹ����@Inherited���ε�annotation���ͱ�����һ��class�������annotation�������ڸ�class�����ࡣ

����ע�⣺@Inherited annotation�����Ǳ���ע����class���������̳С��ಢ��������ʵ�ֵĽӿڼ̳�annotation�������������������صķ����̳�annotation��

������@Inherited annotation���ͱ�ע��annotation��Retention��RetentionPolicy.RUNTIME������API��ǿ�����ּ̳��ԡ��������ʹ��java.lang.reflectȥ��ѯһ��@Inherited annotation���͵�annotationʱ����������齫չ�����������class���丸�ֱ࣬������ָ����annotation���ͱ����֣����ߵ�����̳нṹ�Ķ��㡣