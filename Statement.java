import java.util.Enumeration;

public abstract class Statement {
  public abstract String getHeader(Customer aCustomer);

  public abstract String getFigures(Rental aRental);

  public abstract String getFooter(Customer aCustomer);

  public String value(Customer aCustomer) {
      Enumeration rentals = aCustomer.getRentals();
      String result = getHeader(aCustomer);
      while (rentals.hasMoreElements()) {
         Rental aRental = (Rental) rentals.nextElement();
         //show figures for this rental
         result += getFigures(aRental);
      }
      //add footer lines
      result += getFooter(aCustomer);
      return result;
   }
}