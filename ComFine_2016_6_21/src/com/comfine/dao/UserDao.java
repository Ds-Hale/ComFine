package com.comfine.dao;

import java.util.List;
import javax.sql.DataSource;
import com.comfine.javabean.User;

public interface UserDao {
	
	/**
	 * �÷���������ʼ�����ݿ����ӳ�
	 */
	public void setDataSource(DataSource ds);
	/**
	 * �÷��������������ݿ�һ����¼
	 */
	public void create(User user);
	/**
	 * �÷�����������������ȡΨһ��һ����¼
	 */
	public User getUser(int id);
	/**
	 * �÷���������ȡ���е�User����
	 */
	public List<User> listUsers();
	/**
	 * �÷���������ȡ�û��Զ����sql���
	 */
	public List<User> excuteSql(String sql);
	/**
	 * �÷�������ɾ��һ����¼
	 */
	public void delete(int id);
	/**
	 * �÷���������������
	 */
	public void updatePwd(int id,String pwd);
	/**
	 * �÷�����������ͷ��
	 */
	public void updateFace(int id,String face);
	
}
