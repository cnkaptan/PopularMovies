package com.cnkaptan.popularmovies.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by cnkaptan on 30/03/16.
 */
public class MovieResponse implements Parcelable {

    /**
     * page : 1
     * results : [{"poster_path":"/6bCplVkhowCjTHXWv49UjRPn0eK.jpg","adult":false,"overview":"Fearing the actions of a god-like Super Hero left unchecked, Gotham City\u2019s own formidable, forceful vigilante takes on Metropolis\u2019s most revered, modern-day savior, while the world wrestles with what sort of hero it really needs. And with Batman and Superman at war with one another, a new threat quickly arises, putting mankind in greater danger than it\u2019s ever known before.","release_date":"2016-03-23","genre_ids":[28,12,14,878],"id":209112,"original_title":"Batman v Superman: Dawn of Justice","original_language":"en","title":"Batman v Superman: Dawn of Justice","backdrop_path":"/cejHDyHEJSjtpsPgGzm1GNsZLMF.jpg","popularity":82.001159,"vote_count":778,"video":false,"vote_average":5.9},{"poster_path":"/vZpB8ezB1IqpxI9rx553TuGwDzJ.jpg","adult":false,"overview":"Thirty years after defeating the Galactic Empire, Han Solo and his allies face a new threat from the evil Kylo Ren and his army of Stormtroopers.","release_date":"2015-12-15","genre_ids":[28,12,878,14],"id":140607,"original_title":"Star Wars: The Force Awakens","original_language":"en","title":"Star Wars: The Force Awakens","backdrop_path":"/c2Ax8Rox5g6CneChwy1gmu4UbSb.jpg","popularity":37.200084,"vote_count":3516,"video":false,"vote_average":7.7},{"poster_path":"/inVq3FRqcYIRl2la8iZikYYxFNR.jpg","adult":false,"overview":"Based upon Marvel Comics\u2019 most unconventional anti-hero, DEADPOOL tells the origin story of former Special Forces operative turned mercenary Wade Wilson, who after being subjected to a rogue experiment that leaves him with accelerated healing powers, adopts the alter ego Deadpool. Armed with his new abilities and a dark, twisted sense of humor, Deadpool hunts down the man who nearly destroyed his life.","release_date":"2016-02-09","genre_ids":[28,12,35],"id":293660,"original_title":"Deadpool","original_language":"en","title":"Deadpool","backdrop_path":"/n1y094tVDFATSzkTnFxoGZ1qNsG.jpg","popularity":31.952657,"vote_count":2441,"video":false,"vote_average":7.19},{"poster_path":"/w93GAiq860UjmgR6tU9h2T24vaV.jpg","adult":false,"overview":"With the nation of Panem in a full scale war, Katniss confronts President Snow in the final showdown. Teamed with a group of her closest friends \u2013 including Gale, Finnick, and Peeta \u2013 Katniss goes off on a mission with the unit from District 13 as they risk their lives to stage an assassination attempt on President Snow who has become increasingly obsessed with destroying her. The mortal traps, enemies, and moral choices that await Katniss will challenge her more than any arena she faced in The Hunger Games.","release_date":"2015-11-18","genre_ids":[28,12,18],"id":131634,"original_title":"The Hunger Games: Mockingjay - Part 2","original_language":"en","title":"The Hunger Games: Mockingjay - Part 2","backdrop_path":"/qjn3fzCAHGfl0CzeUlFbjrsmu4c.jpg","popularity":25.518616,"vote_count":1395,"video":false,"vote_average":6.76},{"poster_path":"/jjBgi2r5cRt36xF6iNUEhzscEcb.jpg","adult":false,"overview":"Twenty-two years after the events of Jurassic Park, Isla Nublar now features a fully functioning dinosaur theme park, Jurassic World, as originally envisioned by John Hammond.","release_date":"2015-06-09","genre_ids":[28,12,878,53],"id":135397,"original_title":"Jurassic World","original_language":"en","title":"Jurassic World","backdrop_path":"/dkMD5qlogeRMiEixC4YNPUvax2T.jpg","popularity":22.279165,"vote_count":4187,"video":false,"vote_average":6.66},{"poster_path":"/kqjL17yufvn9OVLyXYpvtyrFfak.jpg","adult":false,"overview":"An apocalyptic story set in the furthest reaches of our planet, in a stark desert landscape where humanity is broken, and most everyone is crazed fighting for the necessities of life. Within this world exist two rebels on the run who just might be able to restore order. There's Max, a man of action and a man of few words, who seeks peace of mind following the loss of his wife and child in the aftermath of the chaos. And Furiosa, a woman of action and a woman who believes her path to survival may be achieved if she can make it across the desert back to her childhood homeland.","release_date":"2015-05-13","genre_ids":[878,53,28,12],"id":76341,"original_title":"Mad Max: Fury Road","original_language":"en","title":"Mad Max: Fury Road","backdrop_path":"/tbhdm8UJAb4ViCTsulYFL3lxMCd.jpg","popularity":21.865617,"vote_count":4239,"video":false,"vote_average":7.4},{"poster_path":"/oXUWEc5i3wYyFnL1Ycu8ppxxPvs.jpg","adult":false,"overview":"In the 1820s, a frontiersman, Hugh Glass, sets out on a path of vengeance against those who left him for dead after a bear mauling.","release_date":"2015-12-25","genre_ids":[37,18,12,53],"id":281957,"original_title":"The Revenant","original_language":"en","title":"The Revenant","backdrop_path":"/uS1SkjVviraGfFNgkDwe7ohTm8B.jpg","popularity":19.912051,"vote_count":2163,"video":false,"vote_average":7.22},{"poster_path":"/t5tGykRvvlLBULIPsAJEzGg1ylm.jpg","adult":false,"overview":"A father is without the means to pay for his daughter's medical treatment. As a last resort, he partners with a greedy co-worker to rob a casino. When things go awry they're forced to hijack a city bus.","release_date":"2015-11-13","genre_ids":[28,53],"id":336004,"original_title":"Heist","original_language":"en","title":"Heist","backdrop_path":"/cBlnfR0n1GA2vPoUQNcbL9pb3VW.jpg","popularity":19.90532,"vote_count":139,"video":false,"vote_average":5.42},{"poster_path":"/cWERd8rgbw7bCMZlwP207HUXxym.jpg","adult":false,"overview":"Katniss Everdeen reluctantly becomes the symbol of a mass rebellion against the autocratic Capitol.","release_date":"2014-11-19","genre_ids":[878,12,53],"id":131631,"original_title":"The Hunger Games: Mockingjay - Part 1","original_language":"en","title":"The Hunger Games: Mockingjay - Part 1","backdrop_path":"/83nHcz2KcnEpPXY50Ky2VldewJJ.jpg","popularity":19.528598,"vote_count":2710,"video":false,"vote_average":6.81},{"poster_path":"/5JU9ytZJyR3zmClGmVm9q4Geqbd.jpg","adult":false,"overview":"The year is 2029. John Connor, leader of the resistance continues the war against the machines. At the Los Angeles offensive, John's fears of the unknown future begin to emerge when TECOM spies reveal a new plot by SkyNet that will attack him from both fronts; past and future, and will ultimately change warfare forever.","release_date":"2015-06-23","genre_ids":[878,28,53,12],"id":87101,"original_title":"Terminator Genisys","original_language":"en","title":"Terminator Genisys","backdrop_path":"/bIlYH4l2AyYvEysmS2AOfjO7Dn8.jpg","popularity":18.099534,"vote_count":1925,"video":false,"vote_average":6.03},{"poster_path":"/hE24GYddaxB9MVZl1CaiI86M3kp.jpg","adult":false,"overview":"A cryptic message from Bond\u2019s past sends him on a trail to uncover a sinister organization. While M battles political forces to keep the secret service alive, Bond peels back the layers of deceit to reveal the terrible truth behind SPECTRE.","release_date":"2015-10-26","genre_ids":[28,12,80],"id":206647,"original_title":"Spectre","original_language":"en","title":"Spectre","backdrop_path":"/wVTYlkKPKrljJfugXN7UlLNjtuJ.jpg","popularity":17.928554,"vote_count":2400,"video":false,"vote_average":6.24},{"poster_path":"/5N20rQURev5CNDcMjHVUZhpoCNC.jpg","adult":false,"overview":"Following the events of Age of Ultron, the collective governments of the world pass an act designed to regulate all superhuman activity. This polarizes opinion amongst the Avengers, causing two factions to side with Iron Man or Captain America, which causes an epic battle between former allies.","release_date":"2016-04-27","genre_ids":[28,878,53],"id":271110,"original_title":"Captain America: Civil War","original_language":"en","title":"Captain America: Civil War","backdrop_path":"/imSjsW6QRkH7fvhnqhQgjnbBBtd.jpg","popularity":17.667602,"vote_count":4,"video":false,"vote_average":3.13},{"poster_path":"/nBNZadXqJSdt05SHLqgT0HuC5Gm.jpg","adult":false,"overview":"Interstellar chronicles the adventures of a group of explorers who make use of a newly discovered wormhole to surpass the limitations on human space travel and conquer the vast distances involved in an interstellar voyage.","release_date":"2014-11-05","genre_ids":[12,18,878],"id":157336,"original_title":"Interstellar","original_language":"en","title":"Interstellar","backdrop_path":"/xu9zaAevzQ5nnrsXN6JcahLnG4i.jpg","popularity":16.350454,"vote_count":4662,"video":false,"vote_average":8.21},{"poster_path":"/MZFPacfKzgisnPoJIPEFZUXBBT.jpg","adult":false,"overview":"Continuing his \"legendary adventures of awesomeness\", Po must face two hugely epic, but different threats: one supernatural and the other a little closer to his home.","release_date":"2016-01-23","genre_ids":[28,12,16,35,10751],"id":140300,"original_title":"Kung Fu Panda 3","original_language":"en","title":"Kung Fu Panda 3","backdrop_path":"/eHWmEUP4fa7h1Fe7TXfTL7ncDl8.jpg","popularity":16.020798,"vote_count":384,"video":false,"vote_average":6.27},{"poster_path":"/aBBQSC8ZECGn6Wh92gKDOakSC8p.jpg","adult":false,"overview":"Beatrice Prior must confront her inner demons and continue her fight against a powerful alliance which threatens to tear her society apart.","release_date":"2015-03-18","genre_ids":[12,878,53],"id":262500,"original_title":"Insurgent","original_language":"en","title":"Insurgent","backdrop_path":"/L5QRL1O3fGs2hH1LbtYyVl8Tce.jpg","popularity":15.691466,"vote_count":1767,"video":false,"vote_average":6.56},{"poster_path":"/5aGhaIHYuQbqlHWvWYqMCnj40y2.jpg","adult":false,"overview":"During a manned mission to Mars, Astronaut Mark Watney is presumed dead after a fierce storm and left behind by his crew. But Watney has survived and finds himself stranded and alone on the hostile planet. With only meager supplies, he must draw upon his ingenuity, wit and spirit to subsist and find a way to signal to Earth that he is alive.","release_date":"2015-09-30","genre_ids":[18,12,878],"id":286217,"original_title":"The Martian","original_language":"en","title":"The Martian","backdrop_path":"/sy3e2e4JwdAtd2oZGA2uUilZe8j.jpg","popularity":15.620902,"vote_count":3113,"video":false,"vote_average":7.58},{"poster_path":"/t90Y3G8UGQp0f0DrP60wRu9gfrH.jpg","adult":false,"overview":"When Tony Stark tries to jumpstart a dormant peacekeeping program, things go awry and Earth\u2019s Mightiest Heroes are put to the ultimate test as the fate of the planet hangs in the balance. As the villainous Ultron emerges, it is up to The Avengers to stop him from enacting his terrible plans, and soon uneasy alliances and unexpected action pave the way for an epic and unique global adventure.","release_date":"2015-04-22","genre_ids":[28,12,878],"id":99861,"original_title":"Avengers: Age of Ultron","original_language":"en","title":"Avengers: Age of Ultron","backdrop_path":"/570qhjGZmGPrBGnfx70jcwIuBr4.jpg","popularity":15.294016,"vote_count":3383,"video":false,"vote_average":7.46},{"poster_path":"/i9LuBG9cx9BW7fFepeCVrvJ8XRP.jpg","adult":false,"overview":"Beatrice Prior and Tobias Eaton venture into the world outside of the fence and are taken into protective custody by a mysterious agency known as the Bureau of Genetic Welfare.","release_date":"2016-03-09","genre_ids":[12,878],"id":262504,"original_title":"The Divergent Series: Allegiant","original_language":"en","title":"The Divergent Series: Allegiant","backdrop_path":"/jaoDlr7XGGtHs1VpN9macrbXheO.jpg","popularity":14.91427,"vote_count":239,"video":false,"vote_average":6.17},{"poster_path":"/5TQ6YDmymBpnF005OyoB7ohZps9.jpg","adult":false,"overview":"After the cataclysmic events in New York with The Avengers, Steve Rogers, aka Captain America is living quietly in Washington, D.C. and trying to adjust to the modern world. But when a S.H.I.E.L.D. colleague comes under attack, Steve becomes embroiled in a web of intrigue that threatens to put the world at risk. Joining forces with the Black Widow, Captain America struggles to expose the ever-widening conspiracy while fighting off professional assassins sent to silence him at every turn. When the full scope of the villainous plot is revealed, Captain America and the Black Widow enlist the help of a new ally, the Falcon. However, they soon find themselves up against an unexpected and formidable enemy\u2014the Winter Soldier.","release_date":"2014-03-20","genre_ids":[28,12,878],"id":100402,"original_title":"Captain America: The Winter Soldier","original_language":"en","title":"Captain America: The Winter Soldier","backdrop_path":"/4qfXT9BtxeFuamR4F49m2mpKQI1.jpg","popularity":13.990099,"vote_count":3049,"video":false,"vote_average":7.66},{"poster_path":"/fqe8JxDNO8B8QfOGTdjh6sPCdSC.jpg","adult":false,"overview":"Bounty hunters seek shelter from a raging blizzard and get caught up in a plot of betrayal and deception.","release_date":"2015-12-25","genre_ids":[80,18,9648,53,37],"id":273248,"original_title":"The Hateful Eight","original_language":"en","title":"The Hateful Eight","backdrop_path":"/sSvgNBeBNzAuKl8U8sP50ETJPgx.jpg","popularity":13.777865,"vote_count":1331,"video":false,"vote_average":7.32}]
     * total_results : 19692
     * total_pages : 985
     */

    private int page;
    private int total_results;
    private int total_pages;
    private List<Movie> results;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotal_results() {
        return total_results;
    }

    public void setTotal_results(int total_results) {
        this.total_results = total_results;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(int total_pages) {
        this.total_pages = total_pages;
    }

    public List<Movie> getResults() {
        return results;
    }

    public void setResults(List<Movie> results) {
        this.results = results;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.page);
        dest.writeInt(this.total_results);
        dest.writeInt(this.total_pages);
        dest.writeTypedList(results);
    }

    public MovieResponse() {
    }

    protected MovieResponse(Parcel in) {
        this.page = in.readInt();
        this.total_results = in.readInt();
        this.total_pages = in.readInt();
        this.results = in.createTypedArrayList(Movie.CREATOR);
    }

    public static final Parcelable.Creator<MovieResponse> CREATOR = new Parcelable.Creator<MovieResponse>() {
        @Override
        public MovieResponse createFromParcel(Parcel source) {
            return new MovieResponse(source);
        }

        @Override
        public MovieResponse[] newArray(int size) {
            return new MovieResponse[size];
        }
    };
}
