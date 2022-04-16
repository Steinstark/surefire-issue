# @Nested Tests executes when excluded
Test classes with the Junit 5 `@Nested` annotation is executed
even when explicitly excluded with the `<exclude>` tag.

## How to  reproduce
Surefire configuration:
```xml
<plugin>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-surefire-plugin</artifactId>
    <version>3.0.0-M6</version>
    <configuration>
        <excludes>
            <exclude>**/IssueTest$NestedTests</exclude>
        </excludes>
    </configuration>
</plugin>
```
Run 
```shell
mvn test
```
and notice how the test inside the nested test class 
```java
@Nested
class NestedTests {
    
    @Test
    void shouldNotRun() {
        Assertions.assertFalse(true);
    }
}
```
still is executed.

## Expected behaviour
The tests inside an excluded `@Nested` test class isn't executed.

## Actual behaviour
The tests inside an excluded `@Nested` test class is executed.