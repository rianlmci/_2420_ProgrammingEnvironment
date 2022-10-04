package ceStable;

import java.util.Comparator;

public class Song implements Comparable<Song>{

	private int year;
	private int position;
	private String artist;
	private String song;

	public static final Comparator<Song> BY_YEAR = new ComparatorbyYear();
	public Song(int year, int position, String artist, String song) {
		this.year = year;
		this.position = position;
		this.artist = artist;
		this.song = song;
	}

	public int getYear() {
		return year;
	}

	public int getPosition() {
		return position;
	}

	public String getArtist() {
		return artist;
	}

	public String getSong() {
		return song;
	}

	@Override
	public String toString() {
		return String.format("%d (%3d) %s by %s", year, position, song, artist);
	}


	@Override
	public int compareTo(Song other) {
		return this.song.compareTo(other.song);
	}

	private static class ComparatorbyYear implements Comparator<Song> {

		@Override
		public int compare(Song oneSong, Song anotherSong) {
			return Integer.compare(oneSong.year,anotherSong.year);
		}
	}
}
