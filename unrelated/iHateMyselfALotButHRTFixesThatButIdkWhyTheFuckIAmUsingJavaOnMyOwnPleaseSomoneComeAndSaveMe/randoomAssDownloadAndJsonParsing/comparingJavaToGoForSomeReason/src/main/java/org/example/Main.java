package org.example;

import java.io.IOException;
import java.net.URISyntaxException;

public class Main {
    static void main() {
        var downloader = new Downloader();
        Downloader.GithubFileReponse[] files = null;
        try {
            files = downloader.GetFiles(downloader.apiUrl, downloader.repoData, downloader.path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
        for (var file : files) {
            System.out.println(file.name);
        }
    }
}
