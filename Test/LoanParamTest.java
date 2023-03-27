import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

public class LoanParamTest {
    private double answer;

    private double amount;
    private int period;

    @ParameterizedTest
    @CsvFileSource(resources = "ParamTestFileMonthlyPositive.csv", numLinesToSkip = 1)
    void testcheckMontlyRateAll(double amount, int period, double answer) {
        Loan loan = new Loan(amount, period);
        assertEquals(answer, loan.getMonthlyPayment());
    }

    @ParameterizedTest
    @CsvFileSource(resources = "ParamTestFileTotalPositive.csv", numLinesToSkip = 1)
    void testCheckTotalPaymentAll(double amount, int period, double answer) {
        Loan loan = new Loan(amount, period);
        assertEquals(answer, loan.getTotalPayment());
    }
    @ParameterizedTest
    @CsvFileSource(resources = "ParamTestFileMonthlyNegative.csv", numLinesToSkip = 1)
    public void TestMonthlyFails( String Period, String Amount) {
        assertThrows(IllegalArgumentException.class, () -> {Loan loan = new Loan( Double.parseDouble(Amount), Integer.parseInt(Period));
        });
    }
    @ParameterizedTest
    @CsvFileSource(resources = "ParamTestFileTotalNegative.csv", numLinesToSkip = 1)
    public void TestTotalFails( String Period, String Amount) {
        assertThrows(IllegalArgumentException.class, () -> {Loan loan = new Loan( Double.parseDouble(Amount), Integer.parseInt(Period));
        });
    }
    @ParameterizedTest
    @CsvFileSource(resources = "ParamTestGetRate.csv", numLinesToSkip = 1)
    public void TestGetRate (double amount, int period, double answer){
        Loan loan = new Loan(amount, period);
        assertEquals(answer,loan.getRate());

    }
    @ParameterizedTest
    @CsvFileSource(resources = "ParamTestGetPeriod.csv", numLinesToSkip = 1)
    public void TestGetPeriod (double amount, int period, double answer){
        Loan loan = new Loan(amount, period);
        assertEquals(answer,loan.getPeriod());

    }

    @ParameterizedTest
    @CsvFileSource(resources = "ParamTestGetAmount.csv", numLinesToSkip = 1)
    public void TestGetAmount (double amount, int period, double answer){
        Loan loan = new Loan(amount, period);
        assertEquals(answer,loan.getAmount());

    }

}
