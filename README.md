# effective-java

## chapter2. 객체의 생성과 파괴
객체를 생성해야 할 때와 만들지 말아야 할 때를 구분하는법, 올바른 객체 생성방법과 불필요한 생성을 피하는 방법, 제때 파괴됨을 보장하고 파괴 전에 수행해야 할 정리 작업을 관리하는 요령을 알아보았습니다.

### 아이템(1~5)
객체의 생성되기 시작하는 순간은 아마 프로그램의 시작과 같을 것입니다. <br>
습관적으로 생성하던 인스턴스 대신 좀더 효율적인 방안을 모색하고 객체의 생성에 대한 전반적인 부분을 살펴봅니다. <br>

[Item1. 생성자 대신 정적 팩터리 메서드를 고려하라](https://south-leopard-b1c.notion.site/Item1-bbbb413b4b03402abdec5d01e7daab57?pvs=4) <br>
[Item2. 생성자에 매개변수가 많다면 빌더를 고려하라](https://south-leopard-b1c.notion.site/Item2-850e4eecc80c416bb63b0c4cd6cc4b1c?pvs=4) <br>
[Item3. private 생성자나 열거 타입으로 싱글턴임을 보증하라](https://south-leopard-b1c.notion.site/Item3-private-5c0751ac2f324729999b133d3bfd971d?pvs=4) <br>
[Item4. 인스턴스화를 막으려거든 private 생성자를 사용하라](https://south-leopard-b1c.notion.site/Item4-private-391438c7ba2b4bff85240abbc77d076d?pvs=4) <br>
[Item5. 자원을 직접 명시하지 말고 의존 객체 주입을 사용하라](https://south-leopard-b1c.notion.site/Item5-5f620339dca241ce8460215d3bc379bd?pvs=4) <br>

### 아이템(6~9)
JVM이 객체를 자동으로 파괴해 주기에, 우리는 객체가 사라지는 순간에 대해서는 고민하지 않습니다. <br>
지나쳤을 수 있는 문제들에 대해 점검해 보는 시간을 가졌습니다. <br> 

[Item6. 불필요한 객체 생성을 피하라](https://south-leopard-b1c.notion.site/Item6-da5cea7ae7c14882a8de6fb5a9cc8e29?pvs=4) <br>
[Item7. 다 쓴 객체 참조를 해제하라](https://south-leopard-b1c.notion.site/Item7-41d6fa035ff14a9394edcd30e10fbb6a?pvs=4) <br>
[Item8. finalizer와 cleaner 사용을 피하라](https://south-leopard-b1c.notion.site/Item8-finalizer-cleaner-b05be4950ff84c6293b029c54405d1ec?pvs=4) <br>
[Item9. try-finally보다는 try-with-resources를 사용하라](https://south-leopard-b1c.notion.site/Item9-try-finally-try-with-resources-1a3bdb08914c4ae1bceac5064c7726f9?pvs=4) <br>

---
## chapter3. 모든 객체의 공통 메서드
Object는 객체를 만들 수 있는 구체 클래스지만 기본적으로는 상속해서 사용하도록 설계되었습니다. <br>
Object에서 final이 아닌 메소드(equals, hashCode, toString, clone, finalize)는 모두 재정의(overriding)를 염두해둔 설계로, 재정의 시 지겨야 하는 규약이 정의되어 있습니다. <br>
이번 장에서는 final이 아닌 Object 메서드들을 언제 어떻게 재정의해야 하는지를 다룹니다. <Br>
그중 finalize메서드는 아이템 8에서 다루었습니다. <Br>
또한, Comparable.compareTo의 경우 Object 메서드는 아니지만 성격이 비슷하여 이번 장에서 함께 다룹니다. <Br><Br>

### 아이템(10~14)
모든 객체가 공통적으로 가지고 있는 Method들 중, 주요 Override 대상이 되는 Method들을 재정의 할 때 주의해야 할 사항들에 대해 점검해보는 아이템입니다. <Br>
이를 통해 Override의 방향성을 다시 수립하는 계기가 되었습니다. <Br>

[Item10. equals는 일반 규약을 지켜 재정의하라](https://south-leopard-b1c.notion.site/Item10-equals-4ebec1e9bb854e3594a2eba1dc03d571?pvs=4) <br>
[Item11. equals를 재정의하려거든 hashCode도 재정의하라](https://south-leopard-b1c.notion.site/Item11-equals-hashCode-e349a8aa61984c29869d7e70af65b5c5?pvs=4) <br>
[Item12. toString을 항상 재정의하라](https://south-leopard-b1c.notion.site/Item12-toString-2e3ad4e6867649f494f7aaed4fcdb934?pvs=4) <br>
[Item13. clone 재정의는 주의해서 진행하라](https://south-leopard-b1c.notion.site/Item13-clone-0269e883538d4f879b7318b42e25685a?pvs=4) <br>
[Item14. Comparable을 구현할지 고려하라](https://south-leopard-b1c.notion.site/Item14-Comparable-4f2635898aa14c2f842760c35a78d909?pvs=4) <br>

---
## chapter4. 클래스와 인터페이스
추상화의 기본 단위인 클래스와 인터페이스는 자바 언어의 심장과도 같습니다. <br>
그래서 자바 언어에는 클래스와 인터페이스 설계에 사용하는 강력한 요소들이 많습니다. <Br>
이번장에서는 이런 요소를 적절히 활용하여 클래스와 인터페이스를 쓰기 편하고, 유연하게 만드는 방법을 알아보았습니다. <Br>

### 아이템(15~19)
접근제어자와 상속에 대해 다룹니다. <br>

[Item15. 클래스와 멤버의 접근 권한을 최소화하라](https://south-leopard-b1c.notion.site/Item15-479371d7dd274c48b3e25803213ce6fa?pvs=4) <br>
[Item16. public 클래스에서는 public 필드가 아닌 접근자 메서드를 사용하라](https://south-leopard-b1c.notion.site/Item16-public-public-b2d0806114f44c36aecdbb7e7043f23e?pvs=4) <br>
[Item17. 변경 가능성을 최소화하라](https://south-leopard-b1c.notion.site/Item17-808832dad307448a8cd4526a71479304?pvs=4) <br>
[Item18. 상속보다는 컴포지션을 사용하라](https://south-leopard-b1c.notion.site/Item18-45a183fb35e04fd0a800ab9024b4a108?pvs=4) <br>
