package WebOperation;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;

public class Extracter {

    public String get(String link) {
        String str = new String();
        try {
            final String url = link;

            Document doc = Jsoup.connect(url).parser(Parser.xmlParser()).get();

            // Elements of any tag, but with 'types' are stored here
            Elements withTypes = new Elements();

            // Select all elements
            for (Element element : doc.select("*")) {
                // Split the tag by ':'
                final String s[] = element.tagName().split(":");

                /*
                 * If there's a namespace (otherwise s.length == 1) use the 2nd
                 * part and check if the element has 'types'
                 */
                if (s.length > 1 && s[1].equals("definitions") == true) {
                    // Add this element to the found elements list
                    withTypes.add(element);
                    str += element + " ";
                }
            }
        } catch (java.net.SocketTimeoutException | java.net.UnknownHostException | org.jsoup.HttpStatusException | java.lang.NullPointerException ex) {
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return str;
    }
}
