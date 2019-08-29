package jsmart.assertj.tests;

import org.assertj.core.data.Percentage;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Test(groups = {"assertJ_Tests"})
public class AssertJTests {

    @Test
    public void booleanTests() {
        assertThat(true).isTrue();
        assertThat(true).isEqualTo(true);

        assertThat(false).isFalse();
        assertThat(false).isEqualTo(false);
    }

    @Test
    public void integerTests() {
        assertThat(1).isEqualTo(1);
        assertThat(2).isGreaterThan(1);
        assertThat(1).isLessThan(2);
        assertThat(2).isGreaterThanOrEqualTo(2);
        assertThat(2).isGreaterThanOrEqualTo(1);
        assertThat(1).isLessThanOrEqualTo(2);
        assertThat(1).isLessThanOrEqualTo(1);
        assertThat(2).isBetween(1, 3);
        assertThat(9).isCloseTo(10, Percentage.withPercentage(20.0));
        assertThat(9).isNotCloseTo(1, Percentage.withPercentage(1.0));
    }

    @Test
    public void stringTests() {
        assertThat("test123").isEqualTo("test123");
        assertThat("test123").contains("123");
        assertThat("123").containsOnlyDigits();
        assertThat("   ").containsOnlyWhitespaces();
        assertThat("  Test White Space  ").containsWhitespaces();
    }

}
