package in.co.rays.test;

import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;

import in.co.rays.been.StudentBean;
import in.co.rays.been.UserBean;
import in.co.rays.model.StudentManagementModel;
import in.co.rays.model.UserModel;

public class TestStudentManagement {

	public static void main(String[] args) throws Exception {
		// testAdd();
		testSearch();
	}

	private static void testSearch() throws Exception {
		StudentManagementModel model = new StudentManagementModel();

		List list = model.search(3, 5);

		Iterator it = list.iterator();

		StudentBean bean = null;
		while (it.hasNext()) {
			bean = (StudentBean) it.next();
			System.out.print(bean.getRollNo());
            System.out.print("\t" + bean.getFirstName());
            System.out.print("\t" + bean.getLastName());
            System.out.println("\t" + bean.getRollNo());
		}

	}

	public static void testAdd() throws Exception {
		StudentBean bean = new StudentBean();

		bean.setRollNo("Rays101");
		bean.setFirstName("Shivam");
		bean.setLastName("Patel");
		bean.setSession("A");

		StudentManagementModel model = new StudentManagementModel();
		model.add(bean);

	}

}
