package ledjer.web;

import ledjer.Ledger;
import org.junit.Before;
import org.junit.Test;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static junit.framework.Assert.assertEquals;

public class LedjerControllerTest
{
  private LedjerController controller;
  private Ledger ledjer;

  @Before
  public void setUp() throws Exception
  {
    ledjer = new Ledger();
    ledjer.save();
    controller = new LedjerController(ledjer);
  }

  @Test
  public void showsLedjer() throws Exception
  {
    Map<String, Object> model = new HashMap<String, Object>();
    SimpleDateFormat dateFormat = new SimpleDateFormat("MMM d, yyyy");
    
    String result = controller.showLedger(model);

    assertEquals("index", result);

    String statement = (String)model.get("statement");
    assertEquals(true, statement.indexOf("Total:") != -1);

    DepositBean bean = (DepositBean)model.get("deposit");
    assertEquals(0, bean.getAmount());
    assertEquals(dateFormat.format(new Date()), bean.getDate());
  }

  @Test
  public void successfulDeposit() throws Exception
  {
    DepositBean bean = new DepositBean();
    bean.setAmount(123);
    BindingResult bind = new BeanPropertyBindingResult(bean, "deposit");

    String result = controller.deposit(bean, bind);

    assertEquals("redirect:/", result);
    ledjer = Ledger.load();
    assertEquals(123, ledjer.getBalance());
  }

  @Test
  public void doestDepositWhenErrorsOccur() throws Exception
  {
    DepositBean bean = new DepositBean();
    bean.setAmount(123);
    BindingResult bind = new BeanPropertyBindingResult(bean, "deposit");
    bind.addError(new ObjectError("deposit", "blah"));

    String result = controller.deposit(bean, bind);

    assertEquals("redirect:/", result);
    ledjer = Ledger.load();
    assertEquals(0, ledjer.getBalance());
  }


}
