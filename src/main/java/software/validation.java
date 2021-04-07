package software;



public class validation {
	public static boolean isValidISBN(String isbn)
    {
        int n = isbn.length();
        if (n != 10)
            return false;

        int sum = 0;
        for (int i = 0; i < 9; i++)
        {
 int digit = Character.getNumericValue(isbn.charAt(i) );
            if (0 > digit || 9 < digit)
                return false;
            sum += (digit * (10 - i));
        }

        // last digit.
        char last = isbn.charAt(9);
        int lastValue;
        if (last != 'X'){
            lastValue=Character.getNumericValue(last);
            if(lastValue<0 || lastValue>9) return false;
            else sum+=lastValue;
        }
        else if(last == 'X'){
            sum+=10;
        }

    return (sum % 11 == 0);
    }
}
