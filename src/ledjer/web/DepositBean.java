package ledjer.web;

import ledjer.Deposit;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DepositBean
{
  public static SimpleDateFormat dateFormat = new SimpleDateFormat("MMM d, yyyy");
  private int amount;
  private String date = dateFormat.format(new Date());

  public void setAmount(int amount)
  {
    this.amount = amount;
  }

  public int getAmount()
  {
    return amount;
  }

  public void setDate(String date)
  {
    this.date = date;
  }

  public String getDate()
  {
    return date;
  }

  public Deposit toDeposit() throws ParseException
  {
    Date date = dateFormat.parse(this.date);
    return new Deposit(amount, date);
  }
}
