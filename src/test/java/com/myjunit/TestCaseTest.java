package com.myjunit;

import com.myjunit.assertion.Assert;
import com.myjunit.result.TestResult;

public class TestCaseTest extends TestCase {

    public TestCaseTest(String testCaseName) {
        super(testCaseName);
    }

    private static long base;

    @Override
    protected void before() {
        base = 10;
    }

    /**
     * 더하기 테스트
     */
    public void runTestSum() {
        long sum = 10 + base;
        Assert.assertTrue(sum == 20);
    }

    /**
     * 마이너스 테스트
     */
    public void runTestMinus() {
        long minus = 100 - base;
        Assert.assertTrue(minus == 90);
    }

    /*
     * 각각의 테스트가 독립적으로 실행되게 만들기 위해 new로 인스턴스를 생성하여 실행
     * */
    public static void main(String[] args) {
        TestSuite testSuite = new TestSuite();
        testSuite.addTestCase(new TestCaseTest("runTestSum"));
        testSuite.addTestCase(new TestCaseTest("runTestMinus"));

        TestResult testResult = new TestResult();
        testSuite.run(testResult);

        testResult.printCount();
    }
}
