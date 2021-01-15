package parseData;
import java.io.*;
import java.util.*;

public class FileInput
{
	public static void main(String[] args) throws IOException
	{
		System.out.print("Enter the User data");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String Userfile = br.readLine();
		if(Userfile.length() == 0)
			Userfile = "/home/raghavseth/eclipse-workspace/Movie Recommender/src/parseData/user.data";
		
		System.out.print("Enter the Genre data");
		String Genrefile = br.readLine();
		if(Genrefile.length() == 0)
			Genrefile = "/home/raghavseth/eclipse-workspace/Movie Recommender/src/parseData/genre.data";
		
		System.out.print("Enter the Movie data");
		String Moviefile = br.readLine();
		if(Moviefile.length() == 0)
			Moviefile = "/home/raghavseth/eclipse-workspace/Movie Recommender/src/parseData/movie.data";
		
		System.out.print("Enter the Rating data");
		String Ratingfile = br.readLine();
		if(Ratingfile.length() == 0)
			Ratingfile = "/home/raghavseth/eclipse-workspace/Movie Recommender/src/parseData/ratings.data";
		
		br.close();
		Parser.parseGenre(Genrefile);
		Parser.parseMovie(Moviefile);
		Parser.parseUser(Userfile);
		Parser.parseRatings(Ratingfile);
	}

}
