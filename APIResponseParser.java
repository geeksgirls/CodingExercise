
import java.lang.*;
public class APIResponseParser {
    
     /**
	 * Parses the input text and returns a Book instance containing
	 * the parsed data. 
	 * @param response text to be parsed
	 * @return Book instance containing parsed data
	 */
     public static Book parse(String response) {
        Book book = new Book();
		String endRule = "</title";
		String startRule = "<title>";		
		String title = parse(response, startRule, endRule); 
	    book.setTitle(title);
		
	    startRule = "<author>" +
				"<id type=\"integer\">10264</id>" + 
				"<name>";
	    endRule = "</name";
	    String author = parse(response, startRule, endRule);
	    book.setAuthor(author);
	    
	    startRule = "<original_publication_year type=\"integer\">";
	    endRule = "</ori";
	    String pubYear = parse(response, startRule, endRule);
	    book.setPublicationYear(Integer.parseInt(pubYear));
	    
	    startRule = "<average_rating>";
	    endRule = "</ave";
	    String averageRating = parse(response, startRule, endRule);
	    book.setAverageRating(Double.parseDouble(averageRating));

	    startRule = "<ratings_count type=\"integer\">";
	    endRule = "</rat";
	    String ratingsCount = parse(response, startRule, endRule);
	    book.setRatingsCount(Integer.parseInt(ratingsCount));
	    

	    startRule = "<image_url>";
	    endRule = "</imag";
	    String imageUrl = parse(response, startRule, endRule);
	    book.setImageUrl(imageUrl);
	    	
		// Your code
		return book;
     }
     
     // write overloaded parse method with the 3 parameters response, startRule, endRule
     
     private static String parse(String response,String startRule, String endRule){
    	 
    	 int startRuleInd =response.lastIndexOf(startRule);
    	 
    	 int endRuleInd = response.indexOf(endRule);
    	 String output = response.substring(startRuleInd + startRule.length(),endRuleInd );
    	 
    	 
    	 System.out.println(output.replaceAll(",",""));
    	 
    	 return output.replaceAll(",","");
     }
     
    /* private static String parse(String response,String startRuleAut, String endRuleAut){
    	 
    	 int startRuleInd =response.lastIndexOf(startRuleAut);
    	 
    	 int endRuleInd = response.indexOf(endRuleAut);
    	 String author = response.substring(startRuleInd + 9 , endRuleInd );
    	 System.out.println(author);
    	 
    	 return author;
     }
     */
     public static void main(String[] args) {
		String response = "<work>" + 
	                            "<id type=\"integer\">2361393</id>" +
	                            "<books_count type=\"integer\">813</books_count>" +
	                            "<ratings_count type=\"integer\">1,16,315</ratings_count>" + 
	                            "<text_reviews_count type=\"integer\">3439</text_reviews_count>" +
	                            "<original_publication_year type=\"integer\">1854</original_publication_year>" +
								"<original_publication_month type=\"integer\" nil=\"true\"/>" +
								"<original_publication_day type=\"integer\" nil=\"true\"/>" +
								"<average_rating>3.79</average_rating>" +
								"<best_book type=\"Book\">" +
									"<id type=\"integer\">16902</id>" +
									"<title>Walden</title>" + 
									"<author>" +
										"<id type=\"integer\">10264</id>" + 
										"<name>Henry David Thoreau</name>" + 
									"</author>" +
									"<image_url>" + 
										"http://images.gr-assets.com/books/1465675526m/16902.jpg" +
									"</image_url>" +
									"<small_image_url>" + 
										"http://images.gr-assets.com/books/1465675526s/16902.jpg" +
									"</small_image_url>" +
								"</best_book>" +
							"</work>";
		
		APIResponseParser.parse(response);
	}
}