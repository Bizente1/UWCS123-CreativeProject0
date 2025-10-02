import java.util.*;

public class Book implements Media, Comparable<Book>{
    
    private String title;
    private List<String> authors;
    private Scanner content;
    private ArrayList<Integer> rating = new ArrayList<Integer>();

    public Book(String title, List<String> authors, Scanner content){
        this.title = title;
        this.authors = authors;
        this.content = content;
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
    public double getAverageRating() {
        int avgRating = 0;
        for (Integer rating : rating) {
            avgRating += rating;
        }

        avgRating = (avgRating/this.rating.size());
        return avgRating;
    }

    @Override
    public List<String> getContent() {
        ArrayList<String> textList = new ArrayList<String>();
        while(this.content.hasNext()){
            String[] breakDown = this.content.next().trim().split(" ");
            for(int i = 0; i < breakDown.length; i++){
                textList.add(breakDown[i]);
            }
        }
        return textList;
    }

    @Override
    public String toString(){
        String toReturn = this.getTitle() + " by " + this.getArtists().toString();

        if(this.rating.size() > 0){
            toReturn += (": " + this.getAverageRating() + " (" + this.getNumRatings() + " ratings)"); 
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
        String author1 = this.authors.get(0);
        String author2 = o.authors.get(0);
        
        int alphabeticalOrder = (((int) author2.charAt(0)) - (int) author1.charAt(0));

        int minLength = Math.min(author2.length(), author1.length());

        for(int i = 1; (i < minLength) || (alphabeticalOrder == 0); i++){
            alphabeticalOrder = (((int) author2.charAt(i)) - (int) author1.charAt(i));
        }

        

        return alphabeticalOrder; 
    }
    
}