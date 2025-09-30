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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getContent'");
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
        
        int alphabeticalOrder = (((int) o.authors.get(0).toCharArray()[0]) - (int) this.authors.get(0).toCharArray()[0]);

        int minLength = Math.min(o.authors.get(0).length(), this.authors.get(0).length());

        for(int i = 1; (i < minLength) || alphabeticalOrder == 0; i++){
            alphabeticalOrder = (((int) o.authors.get(0).toCharArray()[i]) - (int) this.authors.get(0).toCharArray()[i]);
        }

        

        return alphabeticalOrder; 
    }
    
}