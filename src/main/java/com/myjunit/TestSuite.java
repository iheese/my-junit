package com.myjunit;

import com.myjunit.result.TestResult;

import java.util.ArrayList;
import java.util.List;

public class TestSuite implements Test{
    private List<TestCase> testCases = new ArrayList<>();

    @Override
    public void run(TestResult testResult) {
        for (TestCase testCase : this.testCases) {
            testCase.run(testResult);
        }
    }

    public void addTestCase(TestCase testCase) {
        this.testCases.add(testCase);
    }
}
