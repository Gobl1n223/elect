import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


import java.io.IOException;
import java.lang.annotation.Documented;
import java.net.MalformedURLException;
import java.net.URL;

public class Parser {
    private static Document getPage() throws IOException {
        String url = "https://poezdato.net/raspisanie-elektrichki/6535--samara--novokujbyshevskaya/";
        Document page =  Jsoup.parse(new URL(url), 3000);
        return page;
    }

    public static void main(String[] args) throws IOException {
        Document page = getPage();
        Element tableWth = page.select("table[class=train_schedule_table stacktable desktop]").first();
        Elements stations = tableWth.select("tr[class]");
        Elements time = stations.select("span[class=_time]");

        for (Element station : stations){
           String naz = station.select("a[href]").text();
           System.out.println(naz);
            String vrem = station.select("span[class=_time]").text();
            System.out.println(vrem );
            System.out.println("---------------");

        }


    }
}
