package org.example;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.concurrent.locks.ReentrantLock;

public class Downloader {

    final String apiUrl = "https://api.github.com/repos";
    final String repoData = "GNS3/gns3-registry";
    final String path = "appliances";
    final String downloadDir = "downloads";
    private ReentrantLock mu = new ReentrantLock();

    public static class GithubFileReponse {
        public String name;
        public String path;
        public String sha;
        public int size;
        public String url;
        public String html_url;
        public String git_url;
        public String download_url;
        public String type;
        public String self;
        public String git;
        public String html;
        public Links links;

        public GithubFileReponse(String name, String path, String sha, int size, String url, String html_url,
                String git_url, String download_url, String type, String self, String git, String html, Links links) {
            this.name = name;
            this.path = path;
            this.sha = sha;
            this.size = size;
            this.url = url;
            this.html_url = html_url;
            this.git_url = git_url;
            this.download_url = download_url;
            this.type = type;
            this.self = self;
            this.git = git;
            this.html = html;
            this.links = links;
        }
    }

    public static class Links {
        public String self;
        public String git;
        public String html;

        public Links(String self, String git, String html) {
            this.self = self;
            this.git = git;
            this.html = html;
        }
    }

    public static class FileDat {
        public String name;
        public byte[] data;

        public FileDat(String name, byte[] data) {
            this.name = name;
            this.data = data;
        }
    }

    public GithubFileReponse[] GetFiles(String apiUrl, String repoData, String path)
            throws IOException, URISyntaxException {
        var uri = URI.create(apiUrl + "/" + repoData + "/contents/" + path).toURL();
        System.out.println(uri);
        var content = MakeRequest(uri);
        Downloader.GithubFileReponse[] files = new Gson().fromJson(content.toString(),
                Downloader.GithubFileReponse[].class);
        return files;

    }

    public StringBuffer MakeRequest(URL url) throws IOException {
        HttpURLConnection conn = null;
        conn = (HttpURLConnection) url.openConnection();
        conn.setConnectTimeout(5000);
        conn.setReadTimeout(5000);
        conn.setRequestMethod("GET");
        conn.connect();
        int status = conn.getResponseCode();

        if (status > 299 || status < 200) {
            throw new RuntimeException("Error making request: " + status);
        }
        var in = new BufferedReader(new InputStreamReader(conn.getInputStream()));

        String inputLine;
        var content = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }

        in.close();

        return content;
    }

    public FileDat[] GetFileData(GithubFileReponse[] inputFiles) {
        for (var file : inputFiles) {

        }
    }

}
