package com.cnkaptan.popularmovies.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by cnkaptan on 02/04/16.
 */
public class TrailerResponse implements Parcelable {


    /**
     * id : 209112
     * results : [{"id":"56f6110e92514155fb001bf6","iso_639_1":"en","iso_3166_1":"US","key":"JadOB-0z_zw","name":"Stay Down","site":"YouTube","size":1080,"type":"Clip"},{"id":"56c4ccbfc3a3680d52000610","iso_639_1":"en","iso_3166_1":"US","key":"nIGtF3J5kn8","name":"Trailer","site":"YouTube","size":1080,"type":"Trailer"}]
     */

    private int id;
    private List<Video> results;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Video> getResults() {
        return results;
    }

    public void setResults(List<Video> results) {
        this.results = results;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeTypedList(results);
    }

    public TrailerResponse() {
    }

    protected TrailerResponse(Parcel in) {
        this.id = in.readInt();
        this.results = in.createTypedArrayList(Video.CREATOR);
    }

    public static final Parcelable.Creator<TrailerResponse> CREATOR = new Parcelable.Creator<TrailerResponse>() {
        @Override
        public TrailerResponse createFromParcel(Parcel source) {
            return new TrailerResponse(source);
        }

        @Override
        public TrailerResponse[] newArray(int size) {
            return new TrailerResponse[size];
        }
    };

    @Override
    public String toString() {
        return "TrailerResponse{" +
                "id=" + id +
                ", results=" + results +
                '}';
    }
}
