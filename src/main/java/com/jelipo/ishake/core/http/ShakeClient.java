package com.jelipo.ishake.core.http;

import com.jelipo.ishake.core.common.HttpMethod;
import com.jelipo.ishake.core.common.Pair;

import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.Collection;

public class ShakeClient {

    private HttpClient httpClient;

    private URI uri;

    public ShakeClient(HttpClient httpClient, String uri) {
        this.httpClient = httpClient;
        this.uri = URI.create(uri);
    }

    /**
     * 快速创建一个默认的Client客户端
     */
    public static ShakeClient defaultClient(String uri) {
        var httpClient = HttpClient.newBuilder()
                .followRedirects(HttpClient.Redirect.NORMAL)
                .connectTimeout(Duration.ofSeconds(5))
                .build();
        return new ShakeClient(httpClient, uri);
    }

    public void request(
            HttpMethod httpMethod,
            long timeout,
            Collection<Pair> headers,
            byte[] httpBodyBytes
    ) throws IOException, InterruptedException {
        // 构建HttpRequest
        var bodyPublisher = httpBodyBytes == null ?
                HttpRequest.BodyPublishers.noBody() : HttpRequest.BodyPublishers.ofByteArray(httpBodyBytes);
        var builder = HttpRequest.newBuilder(this.uri)
                .timeout(Duration.ofSeconds(timeout))
                .method(httpMethod.name(), bodyPublisher);
        headers.forEach(headerPair -> builder.setHeader(headerPair.left(), headerPair.right()));
        // 使用HttpClient发送Request
        var response = this.httpClient.send(builder.build(), HttpResponse.BodyHandlers.ofByteArray());
    }

}
