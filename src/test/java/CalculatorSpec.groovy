import spock.lang.Specification
import spock.lang.Subject

class CalculatorSpec extends Specification{

    def Calculator calculator;

    def "setup"() {
        calculator = new Calculator();
    }

    def "should add with given input"() {
        expect:
        result == calculator.add(input)

        where:
        result || input
        0      || ""
        1      || "1"
        3      || "1,2"
        6      || "1,2,3"
        7      || "1,2\n4"
    }

    def "should throw exception when number is negative"() {
        when:
        calculator.add("-1")

        then:
        thrown Calculator.NegativeNumberException
    }

    def "should include number of negatives in thrown exception"(){
        when:
        calculator.add("-1,-2")

        then:
        Calculator.NegativeNumberException ex = thrown()
        ex.message == "Negatives: -1 -2"
    }


}
