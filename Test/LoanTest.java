import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoanTest {
    Loan Loan1 = new Loan(4999, 1);
    Loan Loan2 = new Loan(4999, 3);
    Loan Loan7 = new Loan(4999, 4);
    Loan Loan3 = new Loan(4999, 5);
    Loan Loan4 = new Loan(5001, 1);
    Loan Loan5 = new Loan(5001, 3);
    Loan Loan8 = new Loan(5001, 4);
    Loan Loan6 = new Loan(5001, 5);

    @Test
    public void testLessThan500() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Loan(499, 1);
        });
    }

    @Test
    public void testOver5YearPeriod() {
        assertThrows(IllegalArgumentException.class, () -> {
            Loan Loan2 = new Loan(3000, 6);
        });
    }

    @Test
    public void testLess1YearPeriod() {
        assertThrows(IllegalArgumentException.class, () -> {
            Loan Loan2 = new Loan(3000, 0);
        });
    }
    @Test
    public void testAmount0() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Loan(0, 1);
        });
    }

    @Test
    public void testLess0YearPeriod() {
        assertThrows(IllegalArgumentException.class, () -> {
            Loan Loan2 = new Loan(3000, -5);
        });
    }


    @Test
    public void testStringEntered() {
        assertThrows(IllegalArgumentException.class, () -> {
            Loan Loan2 = new Loan(Double.parseDouble("aaaaaaaa"), 5);
        });
    }

    @Test
    public void testNullEntered() {
        assertThrows(IllegalArgumentException.class, () -> {
            Loan Loan2 = new Loan(Double.parseDouble(""), 5);
        });
    }

    @Test
    public void test1YearLessThan5000() {

        assertEquals(439.49, Loan1.getMonthlyPayment());
    }

    @Test
    public void test3YearLessThan5000() {

        assertEquals(161.30, Loan2.getMonthlyPayment());
    }

    @Test
    public void test4YearLessThan5000() {

        assertEquals(117.40, Loan7.getMonthlyPayment());
    }

    @Test
    public void test5YearLessThan5000() {

        assertEquals(96.64, Loan3.getMonthlyPayment());
    }


    @Test
    public void test1YearOver5000() {

        assertEquals(435.03, Loan4.getMonthlyPayment());
    }

    @Test
    public void test3YearOver5000() {

        assertEquals(156.71, Loan5.getMonthlyPayment());
    }
    @Test
    public void test4YearOver5000() {

        assertEquals(115.17, Loan8.getMonthlyPayment());
    }

    @Test
    public void test5YearOver5000() {

        assertEquals(94.38, Loan6.getMonthlyPayment());
    }

    @Test
    public void testTotalPayment1YearLessThan5000() {
        assertEquals(5273.88, Loan1.getTotalPayment());
    }

    @Test
    public void testTotalPayment3YearLessThan5000() {
        assertEquals(5806.80, Loan2.getTotalPayment());
    }
}