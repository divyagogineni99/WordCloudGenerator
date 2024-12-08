# Word Cloud Generator

This project is a Word Cloud Generator that utilizes Reddit posts as input data. The project consists of two main functionalities, organized into separate branches for better modularity:

1. **Java Code**: Uploads Reddit posts to an S3 bucket.
2. **Python Code**: Fetches a CSV file from the S3 bucket and generates a word cloud.

---

## Features

### Java Functionality
- Retrieves Reddit posts using the Reddit API.
- Converts the posts into a CSV format.
- Uploads the CSV file to an Amazon S3 bucket.

### Python Functionality
- Downloads the CSV file from the S3 bucket.
- Processes the data to generate a word cloud visualization.
- Displays the word cloud for analysis.

---

## Technologies Used

### Backend
- **Java**: RESTful API development using Spring Boot.
- **AWS S3**: Cloud storage for handling CSV files.

### Frontend
- **Python**: Data processing and word cloud generation using libraries such as `matplotlib`, `wordcloud`, and `boto3`.

### Tools
- Maven (Java Dependency Management)
- Git for version control
- Docker (containerization)

---

## Setup Instructions

### Prerequisites
- Java 8 or higher
- Python 3.7 or higher
- Maven
- AWS account with S3 bucket access
- Reddit API credentials (client ID, secret, and token)

### Steps to Run the Java Code
1. Clone the repository: git clone https://github.com/divyagogineni99/WordCloudGenerator.git
  
2. Switch to the Java branch: git checkout java-s3-uploader
   
4. Add your AWS access key, secret access key and bucket_name in applications.properties file

5. Build the project: ./mvnw clean install

6. Run the application: java -jar target/wordcloudgenerator.jar

### Steps to Run the Python Code

1. Go to Google Colab: Click File > Upload Notebook and upload your .ipynb file.

3. Install Dependencies : !pip install boto3 wordcloud matplotlib

4. Update the AWS access key , secret key and bucket_name in the respective section of the notebook: aws_access_key_id = "your_access_key" , aws_secret_access_key = "your_secret_key"

5. Click Runtime > Run All or execute cells individually to generate the word cloud.
