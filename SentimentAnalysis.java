import java.util.Arrays;
public class SentimentAnalysis {
	

	    // Tip: labeled continue can be used when iterating featureSet + convert review to lower-case
		public static int[] detectProsAndCons(String review, String[][] featureSet, String[] posOpinionWords,
				String[] negOpinionWords) {
			int[] featureOpinions = new int[featureSet.length]; // output
			//System.out.print(featureSet.length);
			String feature;
			
			Loop: for(int i=0; i<featureSet.length; i++) {
				for(int j=0; j<featureSet[i].length;j++){
					feature = featureSet[i][j];
					featureOpinions[i]=getOpinionOnFeature( review.toLowerCase(),  feature, posOpinionWords,  negOpinionWords);
					if(featureOpinions[i] !=0){
						continue Loop;
					}
				}
			}
	 
	        // your code ~ you will be invoking getOpinionOnFeature		
	 
			return featureOpinions;
		}

		// First invoke checkForWasPhrasePattern and 
		// if it cannot find an opinion only then invoke checkForOpinionFirstPattern
		private static int getOpinionOnFeature(String review, String feature, String[] posOpinionWords, String[] negOpinionWords) {
			
			//checkForWasPhrasePattern();// your code
			//checkForOpinionFirstPattern();
			
			int opiResult = checkForWasPhrasePattern(review,feature,posOpinionWords,negOpinionWords);
			if(opiResult != 0) {
				return opiResult;
			}
			else{
			
			int patResult = checkForOpinionFirstPattern(review,feature,posOpinionWords,negOpinionWords);
			
			return patResult;
			
			}
		}	

		// Tip: Look at String API doc. Methods like indexOf, length, substring(beginIndex), startsWith can come into play
		// Return 1 if positive opinion found, -1 for negative opinion, 0 for no opinion
		// You can first look for positive opinion. If not found, only then you can look for negative opinion
		private static int checkForWasPhrasePattern(String review, String feature, String[] posOpinionWords, String[] negOpinionWords) {
			int opinion = 0;
			boolean patCheck;
			for(int k =0;k<posOpinionWords.length;k++){
			String pattern = feature + " was " +posOpinionWords[k];
			patCheck = review.contains(pattern);
			if(patCheck == true){
				opinion = 1;
				break;
			}
			}

			// your code
			for(String l : negOpinionWords){
				String pattern = feature + " was " +l;
				patCheck = review.contains(pattern);
				if(patCheck == true){
					opinion = -1;
					break;
				}
				}
			return opinion; 	
		}
		
		// You can first look for positive opinion. If not found, only then you can look for negative opinion
		private static int checkForOpinionFirstPattern(String review, String feature, String[] posOpinionWords,String[] negOpinionWords) {
			// Extract sentences as feature might appear multiple times. 
			// split() takes a regular expression and "." is a special character 
			// for regular expression. So, escape it to make it work!!
			String[] sentences = review.split("\\.");
			
			int opinion = 0;
			Outer: for(int x=0; x<sentences.length; x++) {
				for(String y: posOpinionWords){
					String opinionFirst = y + " " +feature;
					
					if(sentences[x].contains(opinionFirst)){
						
						opinion = 1;
						break Outer;
					}
					else {
						for(String m : negOpinionWords){
							String opinionNeg = m+ " " +feature;
							if(sentences[x].contains(opinionNeg)){
								opinion = -1;
								break Outer;
							}
						}
					}
				}
				
				
			}
			
			/*for(int z=0; z<sentences.length;z++){
				for(String l: negOpinionWords){
					String opinionFirst = negOpinionWords + feature;
					if(sentences[z].toLowerCase().contains(opinionFirst)){
						opinion = -1;
						break;
					}
				}
			}*/
			
			// your code for processing each sentence. You can return if opinion is found in a sentence (no need to process subsequent ones)		

			return opinion;
		}

		public static void main(String[] args) {
			//String review = "Haven't been here in years! Fantastic service and the food was delicious! Definetly will be a frequent flyer! Francisco was very attentive";
			
			//String review = "Sorry OG, but you just lost some loyal customers. Horrible service, no smile or greeting just attitude. The breadsticks were stale and burnt, appetizer was cold and the food came out before the salad. ";
			String review = "Not only was their delicious food. but also they get more stars for their excellent service.";
			String[][] featureSet = { 
			        { "ambiance", "ambience", "atmosphere", "decor" },
					{ "dessert", "ice cream", "desert" }, 
					{ "food" }, 
					{ "soup" },
					{ "service", "management", "waiter", "waitress", "bartender", "staff", "server" } };
			String[] posOpinionWords = { "good", "fantastic", "friendly", "great", "excellent", "amazing", "awesome",
					"delicious" };
			String[] negOpinionWords = { "slow", "bad", "horrible", "awful", "unprofessional", "poor" };

			int[] featureOpinions = detectProsAndCons(review, featureSet, posOpinionWords, negOpinionWords);
			System.out.println("Opinions on Features: " + Arrays.toString(featureOpinions));
		}
	
}
