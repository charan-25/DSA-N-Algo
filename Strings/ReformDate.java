package Strings;
/*Given a date string in the form Day Month Year, where:

Day is in the set {"1st", "2nd", "3rd", "4th", ..., "30th", "31st"}.
Month is in the set {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"}.
Year is in the range [1900, 2100].
Convert the date string to the format YYYY-MM-DD, where:

YYYY denotes the 4 digit year.
MM denotes the 2 digit month.
DD denotes the 2 digit day.


Example 1:

Input: date = "20th Oct 2052"
Output: "2052-10-20"
Example 2:

Input: date = "6th Jun 1933"
Output: "1933-06-06"
Example 3:

Input: date = "26th May 1960"
Output: "1960-05-26"


Constraints:

The given dates are guaranteed to be valid, so no error handling is necessary.*/
public class ReformDate {
    public static void main(String[] args) {
        System.out.println(reformatDate("20th Oct 2052"));
    }

    public static String reformatDate(String date) {
        String[] str = date.split(" ");
        StringBuffer sb = new StringBuffer();
        sb.append(str[2]+"-");

        switch(str[1]){
            case "Jan":
                sb.append("01");
                break;
            case "Feb":
                sb.append("02");
                break;
            case "Mar":
                sb.append("03");
                break;
            case "Apr":
                sb.append("04");
                break;
            case "May":
                sb.append("05");
                break;
            case "Jun":
                sb.append("06");
                break;
            case "Jul":
                sb.append("07");
                break;
            case "Aug":
                sb.append("08");
                break;
            case "Sep":
                sb.append("09");
                break;
            case "Oct":
                sb.append("10");
                break;
            case "Nov":
                sb.append("11");
                break;
            case "Dec":
                sb.append("12");
                break;
        }

        if(str[0].length() == 4)
            sb.append("-"+str[0].substring(0,2));
        else
            sb.append("-0"+str[0].substring(0,1));

        return sb.toString();
    }
}
