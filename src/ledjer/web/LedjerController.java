package ledjer.web;

import ledjer.Ledger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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

  @RequestMapping({"/", "/index"})
  public String showDefault(Map<String, Object> model)
  {
    for(String s : model.keySet())
      System.out.println(s + " => " + model.get(s));
    model.put("ledger", ledger);
    return "index";
  }
}
