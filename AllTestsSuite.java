package ro.roxana.JUnit;

import junit.framework.TestSuite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestAchizitie.class, TestActivitate.class,
		TestCaseInsert.class, TestClient.class, TestComanda.class,
		TestFisier.class, TestPlanificareCultura.class, TestUtilajCRUD.class, TestStoc.class })

public class AllTestsSuite {
	public static TestSuite testSuiteMethod(){
		TestSuite test = new TestSuite();
		
		test.addTestSuite(TestAchizitie.class);
		test.addTestSuite(TestActivitate.class);
		test.addTestSuite(TestCaseInsert.class);
		test.addTestSuite(TestClient.class);
		test.addTestSuite(TestComanda.class);
		test.addTestSuite(TestStoc.class);
		
		test.addTest(new TestFisier("testCitireDinFisier"));
		test.addTest(new TestPlanificareCultura("test"));
		test.addTest(new TestUtilajCRUD("testInserareUtilaj"));
		
		
		return test;
	}
}
