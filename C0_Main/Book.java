
import java.util.*;

public class Book implements Media, Comparable<Book>{
    
    private String title;
    private List<String> authors;
    private List<Integer> rating;
    private List<String> textList;

    public Book(String title, List<String> authors, Scanner content){
        this.title = title;
        this.authors = authors;

        rating = new ArrayList<Integer>();
        textList = new ArrayList<String>();
        
        while(content.hasNext()){
            String[] breakDown = content.next().trim().split(" ");
            for(int i = 0; i < breakDown.length; i++){
                textList.add(breakDown[i]);
            }
        }
        
    }

    @Override
    public String getTitle() {
        return this.title;
    }

    @Override
    public List<String> getArtists() {
        return this.authors;
    }

    @Override
    public void addRating(int score) {
        this.rating.add(score);
    }

    @Override
    public int getNumRatings() {
        return this.rating.size();
    }

    @Override
    public double getAverageRating(){
        if(rating.size() == 0){
            return 0;
        }

        double avgRating = 0;
        for (Integer rates : rating) {
            avgRating += rates.intValue();
        }
       
        return (avgRating/this.rating.size());

    }

    @Override
    public List<String> getContent() {
        return textList;
    }

    @Override
    public String toString(){
        String toReturn = this.getTitle() + " by " + this.getArtists().toString();

        if(this.rating.size() > 0){
            toReturn += (": " + Math.round(getAverageRating()*100.0)/100.0 +
                " (" + this.getNumRatings() + " ratings)"); 
        }

        return toReturn;

    }

    @Override
    public int compareTo(Book o) {
        /*
        if((this.rating.size() > 0) && (o.rating.size() > 0)){
            return  (int) (this.getAverageRating() - o.getAverageRating());
        }
         */
        String title1 = getTitle();
        String title2 = o.getTitle();
        
        int alphabeticalOrder = (((int) title2.charAt(0)) - (int) title1.charAt(0));

        int minLength = Math.min(title2.length(), title1.length());

        for(int i = 0; (i < minLength) && (alphabeticalOrder == 0); i++){
            alphabeticalOrder = (((int) title2.charAt(i)) - (int) title1.charAt(i));
        }

        

        return alphabeticalOrder; 
    }
    
}