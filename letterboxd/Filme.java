package letterboxd;

public class Filme {
    private String title;
    private String director;
    private int year;
    private int duration;

    public Filme(String title, String director, int year, int duration){
        this.title = title;
        this.director = director;
        this.year = year;
        this.duration = duration;
    }

    public String getTitle() {return title;}
    public String getDirector() {return director;}
    public int getYear() {return year;}
    public int getDuration() {return duration;}

    public String toFileFormat() {
        return title + " ("+year+") - Directed by " + director;
    }

    public static Filme fromFileFormat(String linha) {
        String[] partes = linha.split(";");
        return new Filme(partes[0], partes[1], Integer.parseInt(partes[2]));
    }


}
