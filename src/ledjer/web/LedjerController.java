package ledjer.web;

import ledjer.Ledger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.text.ParseException;
import java.util.Map;

@Controller
public class LedjerController
{
  private final Ledger ledger;

  @Autowired
  public LedjerController(Ledger ledger)
  {
    System.out.println("this = " + this);
    this.ledger = ledger;
  }

  @RequestMapping(value = "/", method = RequestMethod.GET)
  public String showLedger(Map<String, Object> model)
  {
    model.put("statement", ledger.statement().replace("\n", "<br/>"));
    model.put("deposit", new DepositBean());
    return "index";
  }

  @RequestMapping(value = "/deposit", method = RequestMethod.POST)
  public String deposit(DepositBean bean, BindingResult bindingResult) throws ParseException
  {
    if(!bindingResult.hasErrors())
    {
      ledger.deposit(bean.toDeposit());
      ledger.save();
    }
    return "redirect:/";
  }
}
