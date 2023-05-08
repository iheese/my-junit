package com.myjunit;

import com.myjunit.assertion.AssertionFailedError;
import com.myjunit.result.TestResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public abstract class TestCase  implements Test{

    private static final Logger logger = LoggerFactory.getLogger(TestCase.class);

    protected String testCaseName;

    public TestCase(String testCaseName){
        this.testCaseName = testCaseName;
    }

    public TestResult run() {
        TestResult testResult = createTestResult();
        run(testResult);

        return testResult;
    }

    /**
     * 커맨트 패턴용
     * 각각의 테스트 케이스를 command로 보고 실행은 run 메소드가 담당하도록 한다.
     *
     *  템플릿 메소드 패턴
     *  앞/뒤 혹은 특별한 시점에 공통적으로 코드를 수행하는 패턴
     *  before() -> runTestCase() -> after() :  before, after는 강제 구현 대상이 아닌 선택이므로 추상 메소드로 만들지 않았다.
     */
    public void run(TestResult testResult) {
        testResult.startTest();
        before();
        try {
            runTestCase();
        } catch (InvocationTargetException ite) {
            if(isAssertionFailed(ite)) {
                testResult.addFailure(this);
            } else {
                testResult.addError(this, ite);
            }
        } catch (Exception e) {
            testResult.addError(this, e);
        } finally {
            after();
        }
    }

    protected void before() {}


    public void runTestCase() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
            logger.info("{} execute", testCaseName); // 테스트 케이스들 구별을 위해 적용
            Method method = this.getClass().getMethod(testCaseName, null);
            method.invoke(this, null);
    }

    protected void after() {}

    private TestResult createTestResult() {
        return new TestResult();
    }

    private boolean isAssertionFailed(InvocationTargetException ite) {
        return ite.getTargetException() instanceof AssertionFailedError;
    }

    public String getTestCaseName() {
        return this.testCaseName;
    }
}
