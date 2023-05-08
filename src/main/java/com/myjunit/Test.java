package com.myjunit;

import com.myjunit.result.TestResult;

/**
 * Composite 패턴 : 객체들의 관게를 트리 구조로 구성하여 부분-전체 계층을 표현하는 패턴, 사용자가 단일 객체, 복합 객체 모두를 동일하게 다루도록 한다.
 *
 * Component : 테스트와 상호작용하는데 사용할 인터페이스, 여기서는 Test 인터페이스
 * Composite : Component 인터페이스를 구현하고 Leaf의 걸렉션을 관리, 여기서는 TestSuite
 * Leaf :  Component 인터페이스를 따르는 자식, 여기서는 TestCase
 *
 */
public interface Test {
    void run(TestResult testResult);
}
