package WordCloudGenerator.Service;


import com.opencsv.CSVWriter;
import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Service
public class CsvService {

    public void savePostsToCsv(List<Map<String, String>> posts) throws IOException {
        try (CSVWriter writer = new CSVWriter(new FileWriter("reddit_posts.csv"))) {
            writer.writeNext(new String[]{"Post ID", "Title"});  // Header only for ID and Title

            for (Map<String, String> post : posts) {
                String postId = post.get("id");
                String title = post.get("title");

                // Log the posts being written to the CSV
                System.out.println("Writing post to CSV: " + postId + " - " + title);

                writer.writeNext(new String[]{postId, title});
            }
        }
    }
}




//    public void savePostsToCsv(List<Map<String, String>> posts) throws IOException {
//        /*
//        public void savePostsToCsv(List<Map<String, String>> posts) throws IOException {
//        try (CSVWriter writer = new CSVWriter(new FileWriter("reddit_posts.csv"))) {
//            writer.writeNext(new String[] { "Post ID", "Title", "Content" });
//            for (Map<String, String> post : posts) {
//                writer.writeNext(new String[] {
//                        post.get("id"),
//                        post.get("title"),
//                        post.get("selftext")
//                });
//            }
//        }
//    }
//         */
//        // Create a FileWriter to write to "reddit_posts.csv"
//        FileWriter fileWriter = new FileWriter("reddit_posts.csv");
//
//        // Create a CSVWriter to handle CSV formatting
//        CSVWriter csvWriter = new CSVWriter(fileWriter);
//
//        // Write the header row for the CSV file
//        String[] header = { "Post ID", "Title", "Content" };
//        csvWriter.writeNext(header);
//
//        // Loop through each post in the list
//        for (Map<String, String> post : posts) {
//            // Extract post details
//            String postId = post.get("id");
//            String title = post.get("title");
//            String content = post.get("selftext");
//
//            // Write the post details as a new row in the CSV file
//            String[] row = { postId, title, content };
//            csvWriter.writeNext(row);
//        }
//    //System.out.println(posts);
//        // Close the CSVWriter to save changes and free resources
//        csvWriter.close();
//
//
//    }



