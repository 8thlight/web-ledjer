package ledjer.web;

import ledjer.Deposit;
import ledjer.Ledger;
import ledjer.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;
import java.util.Map;

@Controller
public class LedjerController
{
  private final Ledger ledger;

  @Autowired
  public LedjerController(Ledger ledger)
  {
    this.ledger = ledger;
  }

  @RequestMapping(value = "/", method = RequestMethod.GET)
  public String showDefault(Map<String, Object> model)
  {
    System.out.println("model.size() = " + model.size());
    for(String s : model.keySet())
      System.out.println(s + " => " + model.get(s));
    model.put("ledger", ledger);
    model.put("deposit", new Deposit(0, new Date()));
    model.put("payment", new Payment(0, new Date(), ""));
    return "index";
  }

  @RequestMapping(value = "/deposit", method = RequestMethod.POST)
  public String deposit(Deposit deposit, BindingResult bindingResult)
  {
    System.out.println("DEPOSIT!!!!!");
    System.out.println("deposit = " + deposit);
    System.out.println("deposit.getNumber() = " + deposit.getNumber());
    System.out.println("deposit.getAmount() = " + deposit.getAmount());
    return "redirect:/";
  }
}
