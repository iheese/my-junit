
# JUnit 만들어보기 
### JUnit 만들면서 디자인 패턴 알아보기

- 커맨드 패턴 :  실행될 기능을 캡슐화함으로써 주어진 여러 기능을 실행할 수 있는 재사용성이 높은 클래스를 설계하는 패턴
> - 추상클래스 `TestCase` 의 다른 객체들에서 `run()` 메소드처럼 사용된다.

<br>

- 템플릿 메소드 패턴 : 특정 작업을 처리하는 일부분을 서브 클래스로 캡슐화하여 전체적인 구조는 바꾸지 않고 특정 단계에서 수행하는 내용을 바꾸는 패턴
> - 추상클래스 `TestCase` 의 `run()` 메소드에서 `before()` , `after()`를 서브 메소드로 빼내고 `run()` 에서 사용된 것을 말한다.

<br>

- 컴포지트 패턴 : 그룹과 개별이 같은 인터페이스로 관리되게 하는 패턴
> - Component : 테스트와 상호작용하는데 사용할 인터페이스, 여기서는 Test 인터페이스
> - Composite : Component 인터페이스를 구현하고 Leaf의 컬렉션을 관리, 여기서는 TestSuite
> - Leaf : Component 인터페이스를 따르는 자식, 여기서는 TestCase
> > - 따로놀던 TestCase가 TestSuite 안에서 관리되고 실행되고 있다. 

<br>

참고 및 자료 : 
- [기억보다 기록을_ 향로](https://jojoldu.tistory.com/231#recentComments)
- [디자인 패턴](https://refactoring.guru/ko/design-patterns/what-is-pattern)
