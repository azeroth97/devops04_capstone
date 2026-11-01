package azeroth.config;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class JsoupConnector {

  public Document fetchPage(String url) {
    try {
        return Jsoup.connect(url).get();
    } catch (IOException e) {
        throw new RuntimeException("Failed to fetch page: " + url, e);
    }
  }

}


// public class JsoupConnector {

//   private static final String USER_AGENT =
//       "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/124.0.0.0 Safari/537.36";

//   public Document fetchPage(String url) {
//     try {
//         return Jsoup.connect(url)
//             .userAgent(USER_AGENT)
//             .header("Accept-Language", "en-US,en;q=0.9")
//             .header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8")
//             .referrer("https://www.google.com")
//             .timeout(10_000)
//             .get();
//     } catch (IOException e) {
//         throw new RuntimeException("Failed to fetch page: " + url, e);
//     }
//   }

// }