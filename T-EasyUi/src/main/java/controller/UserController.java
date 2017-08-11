package controller;

public class UserController {


/**
 * ��֤�ֻ������Ƿ��ͳɹ�
 * 
 * @throws Exception
 */
@Action(value = "UserAction_sms")
public void sms() throws Exception {
	String result = "0";
	/** �ֻ����� */
	String jbPhone = WebContextUtil.getRequest().getParameter("jbPhone");
	/** ������֤�� */
	String code = WebContextUtil.getRequest().getParameter("code");
	/** ������֤�����session(session��Ĭ��ʧЧʱ��30����) */
	WebContextUtil.getSession().setAttribute("code", code);
	/** ��γ�ʼ��ʧ�ܷ��� */
	if(!initClient()) {
		return;
	}
	/** �����ֻ��ŷ��Ͷ��ŵķ����Ĳ���׼�� */
	// �ֻ�����
	String mobilephone = jbPhone;
	// ��������+������ɵ�6λ������֤��
	String content = "�����й�֤���ٱ�����ί�У����������ʹ������š�����ע����֤��Ϊ:" + code;
	// �����û���ID
	Integer operId = Integer.parseInt(Env.getInstance().getProperty("operId"));
	// ��ʱ���͵ĵķ���ʱ��(ȱʡΪ�գ������ʱ���ͣ����)
	String tosend_time = "";
	// Ӧ��ϵͳ�Ķ���ID���û���ѯ�ö��ŵ�״̬����(ȱʡΪ0���������ѯ���ŵ�״̬����)
	int sms_id = 0;
	// ����������(0������Ҫ���������ˣ�1����Ҫ���������ˣ�ȱʡΪ0)
	short backlist_filter = 0;
	// ��ֹ�����(0������Ҫ��ֹ����ˣ�1����Ҫ��ֹ����ˣ�ȱʡΪ0)
	short fbdword_filter = 0;
	// ���ȼ�(ֵԽ�����ȼ�Խ�ߣ�0����ͨ��1,�����ȣ�2����ߣ�ȱʡΪ0)
	short priority = 0;
	// ������Чʱ��(��ʽΪ��YYYY-MM-DD HH:mm:ssĿǰΪ��)
	String valid_time = "";
	/** ���Ͷ���֮ǰ��ͳ��һ���Ѿ����͵Ķ������� */
	int messageCount = countService.findAllRecord(mobilephone);
	System.out.println("�ѷ���������Ϊ��" +messageCount);
	if(messageCount < 5){
		/** �����ֻ��ŷ��Ͷ��� */
		if (!sendMessage(mobilephone, content, operId, tosend_time, sms_id,
				backlist_filter, fbdword_filter, priority, valid_time)) {
			result = "0";// ʧ��
		} else {
			result = "1";// �ɹ�
			/** ����һ�����ţ���¼һ�����ż�¼��Ϊ�˷���֮���ͳ�ƶ��ŷ��ʹ��� */
			count.setPhone(mobilephone);// �ֻ�����
			count.setCaptcha(code);// ������֤��
			count.setSendTime(CommonUtil.getNowDate());// ���ŷ���ʱ��
			if(count != null){
				countService.saveEntity(count);
				System.out.println("����ɹ�!");
			}
		}
	}else{
		System.out.println("���ֻ�������췢����֤�����");
		result = "2";//һ���ֻ�������෢��3��������֤��
	}
	HttpServletResponse response = WebContextUtil.getResponse();
	response.setContentType("application/json;charset=UTF-8");
	response.setHeader("Cache-Control", "no-cache");
	PrintWriter out = response.getWriter();
	out.write(result.toString());
}

/**
 * WebService�ͻ��˳�ʼ��
 * 
 */
public static boolean initClient() {
	/**
	 * �жϿͻ����Ƿ��Ѿ���ʼ��
	 */
	if (!SmsWebClient.enable()) {
		int ret = 0;
		try {
			ret = SmsWebClient.init(url, userName, passWord);
			if (ret == -1 || !SmsWebClient.enable()) {
				System.out.println("����ƽ̨�ӿڳ�ʼ��ʧ�ܣ�");
				return false;
			}
			System.out.println("����ƽ̨�ӿڳ�ʼ���ɹ���"+ret+"----------");
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("����ƽ̨�ӿڳ�ʼ���������쳣��");
		}
	}
	return true;
}

/**
 * �����ֻ����뷢��
 * 
 * @param mobilephone
 *            �ֻ���
 * @param content
 *            ��������
 * @param operId
 *            �����û���ID
 * @param tosend_time
 *            ��ʱ���͵ķ���ʱ��
 * @param sms_id
 *            Ӧ��ϵͳ�Ķ���ID
 * @param backlist_filter
 *            ����������
 * @param fbdword_filter
 *            ��ֹ�����
 * @param priority
 *            ���ȼ�
 * @param valid_time
 *            ������Чʱ��
 */
public static boolean sendMessage(java.lang.String mobilephone,
		java.lang.String content, int operId, java.lang.String tosend_time,
		int sms_id, short backlist_filter, short fbdword_filter,
		short priority, java.lang.String valid_time) {
	// �����ֻ����뷢��
	try {
		SmsReturnObj retObj = SmsWebClient.webSendMessage(mobilephone,
				content, operId, tosend_time, sms_id, backlist_filter,
				fbdword_filter, priority, valid_time);
		if (retObj.getReturnCode() != 1) {
			System.out.println("���ŷ���ʧ�ܣ�ԭ��Ϊ��" + retObj.getReturnMsg());
			return false;
		} else {
			System.out.println("���ŷ��ͳɹ������ؽ��Ϊ��" + retObj.getReturnMsg());
			return true;
		}
	} catch (Exception ex) {
		ex.printStackTrace();
		System.out.println("���ŷ��͹��̷����쳣!");
	}
	return true;
}
}