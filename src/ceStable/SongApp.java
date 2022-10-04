package ceStable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Insertion;
import edu.princeton.cs.algs4.Selection;

/**
 * Demonstrates the difference between sorting algorithms that are stable
 * and others that are not.
 * 
 * @author mposch
 *
 */
public class SongApp {
	
	public static void main(String[] args) {
		List<Song> songs = getSongs("src/ceStable/data/songs.csv");
		Song songArray[] = songs.toArray(new Song[0]);
		System.out.println("==== SORTED WITH ARRAYS SORT ====");
		Arrays.sort(songArray);

		//Selection is NOT stable! the alphabetical order of the songs is NOT preserved (Only numeric)
		//Selection.sort(songArray,Song.BY_YEAR);

		//Insertion sort is stable, so it holds on to both sorts. (Alpha-numeric)
		//remember that merge is also stable.
		Insertion.sort(songArray,Song.BY_YEAR);

		for (Song oneSong: songArray) {
			System.out.println(oneSong);
		}

	}
	
	/**
	 * Reads in data from a csv file that stores year,position,artist,song
	 * in the given order in the first four columns.
	 * 
	 * @param csvFile
	 * @return
	 */
	private static List<Song> getSongs(String csvFile) {
        In in = new In(csvFile);
        List<Song> songList = new ArrayList<>();

		if(in.hasNextLine())
			in.readLine(); // skip header line
		
        while (in.hasNextLine()) {
            String line = in.readLine();
            String[] tokens = line.split(",");
            int year = getInt(tokens[0]);
			int position = getInt(tokens[1]);
			String songName = tokens[2];
			String artist = tokens[3];
			Song song = new Song(year,position,songName,artist);
			songList.add(song);
        }
        
        return songList;
	}

	/**
	 * Removes the double quotes at the beginning and end of the 
	 * token and parses it to an integer. 
	 * 
	 * @param tokens token to be converted to an int value.
	 * @return integer corresponding to the token.
	 */
	private static int getInt(String tokens) {
		return Integer.parseInt(tokens.substring(1,(tokens.length()-1)));
	}

}
