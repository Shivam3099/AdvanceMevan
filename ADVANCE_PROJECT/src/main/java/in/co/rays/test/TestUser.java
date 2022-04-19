package in.co.rays.test;

import java.text.ParseException;

import java.text.SimpleDateFormat;

import in.co.rays.been.UserBean;
import in.co.rays.model.UserModel;

public class TestUser {
	public static void main(String[] args) throws Exception {

		// testAdd();
		// testAuth();
		testForgetPwd();
	}

	private static void testForgetPwd() throws Exception {

		UserBean bean = new UserBean();
		bean.setLogin("Sagar12@gmail.com");

		UserModel model = new UserModel();
		UserBean bean1 = model.forgetPassword(bean);

		if (bean1 != null) {
			System.out.println("Valid Login...." + bean1.getPassword());
		} else {
			System.out.println("Invalid Login");
		}

	}

	private static void testAdd() throws Exception {
		UserBean bean = new UserBean();
		SimpleDateFormat sdf = new SimpleDateFormat("MM-DD-yyy");

		bean.setName("Sagar");
		bean.setLogin("Sagar12@gmail.com");
		bean.setPassword("123");
		bean.setConfirmPassword("123");
		bean.setDob(sdf.parse("05-17-1997"));
		bean.setMobileNo("978481");

		UserModel model = new UserModel();
		model.add(bean);

	}

	private static void testAuth() throws Exception {
		UserBean bean = new UserBean();
		bean.setLogin("shiv12@gmail.com");
		bean.setPassword("123");

		UserModel model = new UserModel();
		UserBean bean1 = model.authenticate(bean);

		if (bean1 != null) {
			System.out.println("User Valid");
			System.out.println(bean1.getName());
		} else {
			System.out.println("user Invalid");
		}

	}

}
