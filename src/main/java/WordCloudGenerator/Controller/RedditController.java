package WordCloudGenerator.Controller;

import WordCloudGenerator.Service.CsvService;
import WordCloudGenerator.Service.RedditService;
import WordCloudGenerator.Service.S3Service;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/reddit")
public class RedditController {

    private final RedditService redditService;
    private final CsvService csvService;
    private final S3Service s3Service;

    // Constructor injection
    public RedditController(RedditService redditService, CsvService csvService, S3Service s3Service) {
        this.redditService = redditService;
        this.csvService = csvService;
        this.s3Service = s3Service;
    }

    @GetMapping("/posts")
    public ResponseEntity<String> fetchRedditPosts() {
        try {
            var posts = redditService.fetchPostsFromReddit();
            csvService.savePostsToCsv(posts);
            s3Service.uploadFileToS3("reddit_posts.csv");
            return ResponseEntity.ok("Reddit posts saved and uploaded to S3 successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error occurred: " + e.getMessage());
        }
    }
}
