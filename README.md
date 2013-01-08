# Overview
template method pattern를 사용하는 경우 inheritance를 부적절하게 사용하는 경우가 발행할 가능성이 높다.

상속은 is-a 관계가 있을 때 타입 정보를 나타내기 위해서 사용해야지, 기능을 재사용하기 위해 상속을 사용하는 것은 대부분의 경우 유지보수시 복잡성을 유발한다.

이 예제는 슈퍼 클래스(template method)가 호출하는 서브 클래스의 메소드(primitive method)를 클래스로 추출하여 상속을 delegation으로 바꾸어 복잡성을 줄이는 예제이다.

# Result

## Refactoring 전

![Refactoring 전](https://raw.github.com/msbaek/breaking-inheritance-dependency/master/class-diagram-1.png "Refactoring 전")

## Refactoring 후

![Refactoring 후](https://raw.github.com/msbaek/breaking-inheritance-dependency/master/class-diagram-4.png "Refactoring 후")

# Reference
[Extract, Inject, Kill: Breaking hierarchies](http://craftedsw.blogspot.kr/2012/03/extract-inject-kill-breaking.html)

[github url](https://github.com/sandromancuso/breaking-hierarchies)

