


package com.teachy.coins.gateapi.auth;

import com.teachy.coins.gateapi.Pair;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.Buffer;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;

public class GateApiV4Auth implements Authentication, Interceptor {

    private String apiKey;
    private String apiSecret;
    private final String apiV4 = "x-gate-api-v4";

    public GateApiV4Auth(String apiKey, String apiSecret) {
        this.apiKey = apiKey;
        this.apiSecret = apiSecret;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setKeyPair(String apiKey, String apiSecret) {
        this.apiKey = apiKey;
        this.apiSecret = apiSecret;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public void setApiSecret(String apiSecret) {
        this.apiSecret = apiSecret;
    }

    private String bodyToString(RequestBody body) {
        if (body == null) {
            return "";
        }
        try {
            Buffer buffer = new Buffer();
            body.writeTo(buffer);
            return buffer.readUtf8();
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

    @Override
    public void applyToParams(List<Pair> queryParams, Map<String, String> headerParams, Map<String, String> cookieParams) {
        // only mark that the request needs apiv4 authentication, real authentication happens in the interceptor
        headerParams.put(this.apiV4, "true");
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();

        if (!"true".equals(request.header(this.apiV4))) {
            return chain.proceed(request);
        }

        String ts = String.valueOf(System.currentTimeMillis() / 1000);
        String bodyString = this.bodyToString(request.body());
        String queryString = (request.url().query() == null) ? "" : request.url().query();
        String signatureString = String.format("%s\n%s\n%s\n%s\n%s", request.method(), request.url().encodedPath(), queryString,
                                               DigestUtils.sha512Hex(bodyString), ts);

        String signature;
        try {
            Mac hmacSha512 = Mac.getInstance("HmacSHA512");
            SecretKeySpec spec = new SecretKeySpec(this.apiSecret.getBytes(), "HmacSHA512");
            hmacSha512.init(spec);
            signature = Hex.encodeHexString(hmacSha512.doFinal(signatureString.getBytes()));

            Request newRequest = request.newBuilder()
                                        .removeHeader(this.apiV4)
                                        .addHeader("KEY", this.apiKey)
                                        .addHeader("SIGN", signature)
                                        .addHeader("Timestamp", ts).build();
            return chain.proceed(newRequest);
        } catch (InvalidKeyException | NoSuchAlgorithmException e) {
            e.printStackTrace();
            return chain.proceed(request);
        }
    }
}
