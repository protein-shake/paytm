package parseData;
import java.io.*;
import java.util.*;

public class Parser
{
	static int gensiz, moviesiz, usersiz = 0;
	static List<List<Integer>> moviegenrematrix;
	static List<String> gen, moviename, imdb;
	static List<Integer> movieyear;
	static void parseGenre(String FN) throws IOException
	{
		BufferedReader br = new BufferedReader(new FileReader(FN));
		StringTokenizer st = new StringTokenizer("|");
		String s;
		gen = new ArrayList<>();
		while((s = br.readLine()) != null)
		{
			if(s.length() == 0)
				break;
			st = new StringTokenizer(s, "|");
			gen.add(st.nextToken());
		}
		gensiz = gen.size();
		br.close();
	}
	
	static void parseMovie(String FN) throws IOException
	{
		BufferedReader br = new BufferedReader(new FileReader(FN));
		String s;
		int numline = 0, namelength;
		moviename = new ArrayList<>();
		movieyear = new ArrayList<>();
		imdb = new ArrayList<>();
		moviegenrematrix = new ArrayList<List<Integer>>();
		while((s = br.readLine()) != null)
		{
			if(s.length() == 0)
				break;
			String str[] = s.split("[|]");
			namelength = str[1].length();
			try
			{
				movieyear.add(Integer.parseInt(str[1].substring(namelength-5, namelength-1)));
			}
			catch(Exception e)
			{
				movieyear.add(0);
			}
			moviename.add(str[1]);
			imdb.add(str[3]);
			//System.out.println(str[4]);
			moviegenrematrix.add(new ArrayList<Integer>());
			for(int i = 0; i < gensiz; i++)
				moviegenrematrix.get(numline).add(Integer.parseInt(str[5+i]));
			numline++;
		}
		moviesiz = moviename.size();
		br.close();
	}
	static void parseUser(String FN) throws IOException
	{
		BufferedReader br = new BufferedReader(new FileReader(FN));
		String s;
		while((s = br.readLine()) != null)
		{
			if(s.length() == 0)
					break;
			usersiz++;
		}
		br.close();
	}
	static int[][] movieratingmatrix = new int[moviesiz][usersiz];
	
	static void parseRatings(String FN) throws IOException
	{
		int x, y;
		BufferedReader br = new BufferedReader(new FileReader(FN));
		String s;
		while((s = br.readLine()) != null)
		{
			if(s.length() == 0)
				break;
			String st[] = s.split("[\t]");

			y = Integer.parseInt(st[0])-1;
			x = Integer.parseInt(st[1])-1;
			movieratingmatrix[x][y] = Integer.parseInt(st[2]);
			System.out.print(movieratingmatrix[x][y]);
		}
		br.close();
	}
}
