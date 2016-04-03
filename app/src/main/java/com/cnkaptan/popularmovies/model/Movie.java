package com.cnkaptan.popularmovies.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Arrays;

public class Movie implements Parcelable {
    private String overview;
    private String original_language;
    private String original_title;
    private boolean video;
    private String title;
    private int[] genre_ids;
    private String poster_path;
    private String backdrop_path;
    private String release_date;
    private double popularity;
    private double vote_average;
    private int id;
    private boolean adult;
    private int vote_count;

    public String getOverview() {
        return this.overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getOriginal_language() {
        return this.original_language;
    }

    public void setOriginal_language(String original_language) {
        this.original_language = original_language;
    }

    public String getOriginal_title() {
        return this.original_title;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }

    public boolean getVideo() {
        return this.video;
    }

    public void setVideo(boolean video) {
        this.video = video;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int[] getGenre_ids() {
        return this.genre_ids;
    }

    public void setGenre_ids(int[] genre_ids) {
        this.genre_ids = genre_ids;
    }

    public String getPoster_path() {
        return this.poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public String getBackdrop_path() {
        return this.backdrop_path;
    }

    public void setBackdrop_path(String backdrop_path) {
        this.backdrop_path = backdrop_path;
    }

    public String getRelease_date() {
        return this.release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public double getPopularity() {
        return this.popularity;
    }

    public void setPopularity(double popularity) {
        this.popularity = popularity;
    }

    public double getVote_average() {
        return this.vote_average;
    }

    public void setVote_average(double vote_average) {
        this.vote_average = vote_average;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean getAdult() {
        return this.adult;
    }

    public void setAdult(boolean adult) {
        this.adult = adult;
    }

    public int getVote_count() {
        return this.vote_count;
    }

    public void setVote_count(int vote_count) {
        this.vote_count = vote_count;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.overview);
        dest.writeString(this.original_language);
        dest.writeString(this.original_title);
        dest.writeByte(video ? (byte) 1 : (byte) 0);
        dest.writeString(this.title);
        dest.writeIntArray(this.genre_ids);
        dest.writeString(this.poster_path);
        dest.writeString(this.backdrop_path);
        dest.writeString(this.release_date);
        dest.writeDouble(this.popularity);
        dest.writeDouble(this.vote_average);
        dest.writeInt(this.id);
        dest.writeByte(adult ? (byte) 1 : (byte) 0);
        dest.writeInt(this.vote_count);
    }

    public Movie() {
    }

    protected Movie(Parcel in) {
        this.overview = in.readString();
        this.original_language = in.readString();
        this.original_title = in.readString();
        this.video = in.readByte() != 0;
        this.title = in.readString();
        this.genre_ids = in.createIntArray();
        this.poster_path = in.readString();
        this.backdrop_path = in.readString();
        this.release_date = in.readString();
        this.popularity = in.readDouble();
        this.vote_average = in.readDouble();
        this.id = in.readInt();
        this.adult = in.readByte() != 0;
        this.vote_count = in.readInt();
    }

    public static final Parcelable.Creator<Movie> CREATOR = new Parcelable.Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel source) {
            return new Movie(source);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };

    @Override
    public String toString() {
        return "Movie{" +
                "overview='" + overview + '\'' +
                ", original_language='" + original_language + '\'' +
                ", original_title='" + original_title + '\'' +
                ", video=" + video +
                ", title='" + title + '\'' +
                ", genre_ids=" + Arrays.toString(genre_ids) +
                ", poster_path='" + poster_path + '\'' +
                ", backdrop_path='" + backdrop_path + '\'' +
                ", release_date='" + release_date + '\'' +
                ", popularity=" + popularity +
                ", vote_average=" + vote_average +
                ", id=" + id +
                ", adult=" + adult +
                ", vote_count=" + vote_count +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Movie movie = (Movie) o;

        if (video != movie.video) return false;
        if (Double.compare(movie.popularity, popularity) != 0) return false;
        if (Double.compare(movie.vote_average, vote_average) != 0) return false;
        if (id != movie.id) return false;
        if (adult != movie.adult) return false;
        if (vote_count != movie.vote_count) return false;
        if (overview != null ? !overview.equals(movie.overview) : movie.overview != null)
            return false;
        if (original_language != null ? !original_language.equals(movie.original_language) : movie.original_language != null)
            return false;
        if (original_title != null ? !original_title.equals(movie.original_title) : movie.original_title != null)
            return false;
        if (title != null ? !title.equals(movie.title) : movie.title != null) return false;
        if (!Arrays.equals(genre_ids, movie.genre_ids)) return false;
        if (poster_path != null ? !poster_path.equals(movie.poster_path) : movie.poster_path != null)
            return false;
        if (backdrop_path != null ? !backdrop_path.equals(movie.backdrop_path) : movie.backdrop_path != null)
            return false;
        return !(release_date != null ? !release_date.equals(movie.release_date) : movie.release_date != null);

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = overview != null ? overview.hashCode() : 0;
        result = 31 * result + (original_language != null ? original_language.hashCode() : 0);
        result = 31 * result + (original_title != null ? original_title.hashCode() : 0);
        result = 31 * result + (video ? 1 : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (genre_ids != null ? Arrays.hashCode(genre_ids) : 0);
        result = 31 * result + (poster_path != null ? poster_path.hashCode() : 0);
        result = 31 * result + (backdrop_path != null ? backdrop_path.hashCode() : 0);
        result = 31 * result + (release_date != null ? release_date.hashCode() : 0);
        temp = Double.doubleToLongBits(popularity);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(vote_average);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + id;
        result = 31 * result + (adult ? 1 : 0);
        result = 31 * result + vote_count;
        return result;
    }
}
