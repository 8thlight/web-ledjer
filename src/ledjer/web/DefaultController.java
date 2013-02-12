package ledjer.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class DefaultController
{
  @RequestMapping({"/", "/index"})
  public String showDefault(Map<String, Object> model)
  {
    for(String s : model.keySet())
      System.out.println(s + " => " + model.get(s));
    return "index";
  }
}
