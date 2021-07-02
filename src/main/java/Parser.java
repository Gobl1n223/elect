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
        Element tableWthes = page.select("div[class=int_content]").first();
        Elements stations = tableWth.select("tr[class]");
        String raspisanie = tableWthes.select("h1[class=electr_schedule]").text();
        System.out.println("Расписание маршрута: " +raspisanie);
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

        for(Element ass : stations){
            String station = ass.select("tr[class]").text();
            System.out.println(station);
            System.out.println("---------------------------------");
        }

        Element utoc = page.select("div[class=warning]").first();
        String utocnen = utoc.select("p").text();
System.out.println("Внимание: " + utocnen);

    }
}
