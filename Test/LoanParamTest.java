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


}