# Overview
template method pattern를 사용하는 경우 inheritance를 부적절하게 사용하는 경우가 발행할 가능성이 높다.

상속은 is-a 관계가 있을 때 타입 정보를 나타내기 위해서 사용해야지, 기능을 재사용하기 위해 상속을 사용하는 것은 대부분의 경우 유지보수시 복잡성을 유발한다.

이 예제는 슈퍼 클래스(template method)가 호출하는 서브 클래스의 메소드(primitive method)를 클래스로 추출하여 상속을 delegation으로 바꾸어 복잡성을 줄이는 예제이다.

# 절차

## 1. Extract
### 1.1 Add Covering Test

override하는 메소드를 포함한 서브 클래스(이 클래스를 A라고 하자)를 변경하기 전에 먼저 클래스 A를 cover할 수 있는 테스트 클래스 ATest를 추가한다.

### 1.2 Add Failing Test for Extract

extract할 메소드를 B라는 클래스로 추출할 것이라면 1.1에서 작성한 ATest를 복사하여 BTest를 추가한다.

이때 실수를 줄이기 위해 IDE의 hot fix 기능을 최대한 사용하고 타이핑은 최대한 자제한다.

### 1.3 Make it Pass

1.2에서 작성한 BTest가 성공하도록 수정한다.

A의 메소드 바디를 B에 복사함으로써 테스트를 성공시킨다.

### 1.4 Change Production Code for delegating

B에 복사한 A의 메소드 바디를 지우고, B로 위임한다.

이때 A의 메소드에서 B를 생성할 때 필요한 의존성을 주입할 수 있다.

## 2. Inject

### 2.1 Add Failing Test for Inject

A 클래스의 상위 클래스(이 클래스를 C라고 하자)에 B를 주입할 때이다.

먼저 C에 B가 주입되어 동작하는지를 확인할 수 있는 테스트 클래스 D를 추가한다.

### 2.2 Make it Pass

C가 B를 호출하도록 수정하여 테스트가 성공하도록 한다.

## 3. Kill

더 이상 사용되지 않는 클래스 A, A가 override하는 메소드를 제거한다.

# Result

## Refactoring 전

![Refactoring 전](https://raw.github.com/msbaek/breaking-inheritance-dependency/master/class-diagram-1.png "Refactoring 전")

## Refactoring 후

![Refactoring 후](https://raw.github.com/msbaek/breaking-inheritance-dependency/master/class-diagram-4.png "Refactoring 후")

# Reference
[Extract, Inject, Kill: Breaking hierarchies](http://craftedsw.blogspot.kr/2012/03/extract-inject-kill-breaking.html)

[github url](https://github.com/sandromancuso/breaking-hierarchies)
