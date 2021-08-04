import java.util.Enumeration;

public class HtmlStatement extends Statement {
  public String value(Customer aCustomer) {
      Enumeration rentals = aCustomer.getRentals();
      
      String result = getHeader(aCustomer);

      while (rentals.hasMoreElements()) {
         Rental aRental = (Rental) rentals.nextElement();
         //show figures for each rental
         result += getFigures(aRental);
      }
      //add footer lines
      result += getFooter(aCustomer);
      return result;
   }

  private String getHeader(Customer aCustomer){
    return "<H1>Rentals for <EM>" + aCustomer.getName() +
      "</EM></H1><P>\n";
  }

  private String getFigures(Rental aRental){
    return aRental.getMovie().getTitle()+ ": " +
         String.valueOf(aRental.getCharge()) + "<BR>\n";
  }

  private String getFooter(Customer aCustomer){
    return "<P>You owe <EM>" +
      String.valueOf(aCustomer.getTotalCharge()) + "</EM><P>\n" + "On this rental you earned <EM>" + 
      String.valueOf(aCustomer.getTotalFrequentRenterPoints()) +
      "</EM> frequent renter points<P>";
  }
}