package com.myjunit.result;

import com.myjunit.TestCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class TestResult {

    private static final Logger logger = LoggerFactory.getLogger(TestResult.class);
    private int runTestCount;
    private List<TestFailure> failures;
    private List<TestError> errors;
    public TestResult() {
        this.runTestCount = 0;
        this.failures = new ArrayList<>();
        this.errors = new ArrayList<>();
    }

    /**
     * 하나의 TestResult 인스턴스에 테스트 전체 결과를 담으려면 여러 테스트 케이스가 사용되는데
     * 이때 쓰레드 동기화 문제가 발생하여 synchronized로 간단하게 해결
     * synchronized(메서드, 객체 변수에 사용) : 공유되는 자원에 접근한 스레드를 제외하고 나머지 스레드는 데이터에 접근할 수 없게 막는다(block, unblock 처리) > 성능 저하 이슈
     */
    public synchronized void startTest() {
        this.runTestCount++;
    }

    public synchronized void addFailure(TestCase testCase) {
        this.failures.add(new TestFailure(testCase));
    }

    public synchronized void addError(TestCase testCase, Exception e) {
        this.errors.add(new TestError(testCase, e));
    }

    public void printCount() {
        logger.info("Total test count : {}", runTestCount);
        logger.info("Total Test Success Count: {}", runTestCount - failures.size() - errors.size());
        logger.info("Total Test Failure Count: {}", failures.size());
        logger.info("Total Test Error Count: {}", errors.size());
    }
}
