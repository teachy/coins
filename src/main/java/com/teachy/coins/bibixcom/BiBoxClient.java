package com.teachy.coins.bibixcom;

import java.net.URISyntaxException;

public interface BiBoxClient
{
    static BiBoxHttpClient ofDefaults()
    {
        return new BiBoxHttpClient(BiBoxHttpClientConfig.ofDefaults());
    }

    static BiBoxHttpClient of(BiBoxHttpClientConfig config)
    {
        return new BiBoxHttpClient(config);
    }

    static BiBoxWebSocketClient ofDefaultsWebSocket() throws URISyntaxException
    {
        return new BiBoxWebSocketClient(BiBoxWebSocketConfig.ofDefaults());
    }

    static BiBoxWebSocketClient ofWebSocket(BiBoxWebSocketConfig config) throws URISyntaxException
    {
        return new BiBoxWebSocketClient(BiBoxWebSocketConfig.from(config).build());
    }
}
