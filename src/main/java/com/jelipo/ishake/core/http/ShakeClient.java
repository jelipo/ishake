package com.jelipo.ishake.core.http;

import com.jelipo.ishake.core.common.Pair;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.Collection;

public class ShakeClient {

    private final HttpClient httpClient;

    private final URI uri;

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

    /**
     * 使用Java自带的HttpClient发送Request请求
     *
     * @param httpMethod    Http方法
     * @param timeout       超时时间(秒)
     * @param httpBodyBytes Http请求的Body，可以为null
     * @return 返回Http请求的Response，body为byte[]
     */
    public HttpResponse<byte[]> request(
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
        // 添加Header
        if (headers != null && headers.size() != 0) {
            headers.forEach(headerPair -> builder.setHeader(headerPair.left(), headerPair.right()));
        }
        // 使用HttpClient发送Request
        return this.httpClient.send(builder.build(), HttpResponse.BodyHandlers.ofByteArray());
    }

}
