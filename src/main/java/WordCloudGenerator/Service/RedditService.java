package WordCloudGenerator.Service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RedditService {

    @Value("${reddit.api.url}")
    private String redditApiUrl;

    public List<Map<String, String>> fetchPostsFromReddit() {
        RestTemplate restTemplate = new RestTemplate();
        Map<String, Object> response = restTemplate.getForObject(redditApiUrl, Map.class);

        List<Map<String, String>> posts = new ArrayList<>();

        List<Map<String, Object>> children = (List<Map<String, Object>>) ((Map<String, Object>) response.get("data")).get("children");

        for (Map<String, Object> child : children) {
            Map<String, Object> postData = (Map<String, Object>) child.get("data");

            Map<String, String> post = new HashMap<>();
            post.put("id", (String) postData.get("id"));   // Fetch Post ID
            post.put("title", (String) postData.get("title")); // Fetch Title only

            posts.add(post);
        }

        // Log the fetched posts
        System.out.println("Fetched posts: " + posts);

        return posts;
    }
}


//{
//  "data": {
//    "children": [
//      {
//        "data": {
//          "id": "t3_1g6imbc",
//          "title": "Building Roguerrants: Insights into 2.5D Roguelike Development with Squeak"
//        }
//      },
//      {
//        "data": {
//          "id": "t3_1g6h3kr",
//          "title": "Tauri2.0 has been released! Not just on the desktop"
//        }
//      },
//      {
//        "data": {
//          "id": "t3_1g6g5im",
//          "title": "Swagger UI Generation from Existing Express Code"
//        }
//      }
//    ]
//  }
//}

