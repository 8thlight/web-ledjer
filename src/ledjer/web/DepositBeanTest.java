package ledjer.web;

import ledjer.Deposit;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class DepositBeanTest
{
  private DepositBean deposit;

  @Before
  public void setUp() throws Exception
  {
    deposit = new DepositBean();
  }

  @Test
  public void amount() throws Exception
  {
    deposit.setAmount(123);
    assertEquals(123, deposit.getAmount());
  }

  @Test
  public void date() throws Exception
  {
    deposit.setDate("Jan 3, 2011");
    assertEquals("Jan 3, 2011", deposit.getDate());
  }

  @Test
  public void createDeposit() throws Exception
  {
    deposit.setAmount(345);
    deposit.setDate("Jan 5, 2012");
    Deposit result = deposit.toDeposit();
    assertEquals(345, result.getAmount());
    assertEquals(DepositBean.dateFormat.parse("Jan 5, 2012"), result.getDate());
  }
}
