


package com.teachy.coins.gateapi.api;

import com.google.common.reflect.TypeToken;
import com.teachy.coins.gateapi.ApiCallback;
import com.teachy.coins.gateapi.ApiClient;
import com.teachy.coins.gateapi.ApiException;
import com.teachy.coins.gateapi.ApiResponse;
import com.teachy.coins.gateapi.Configuration;
import com.teachy.coins.gateapi.Pair;


import com.teachy.coins.gateapi.models.BatchOrder;
import com.teachy.coins.gateapi.models.CancelOrder;
import com.teachy.coins.gateapi.models.CancelOrderResult;
import com.teachy.coins.gateapi.models.CurrencyPair;
import com.teachy.coins.gateapi.models.OpenOrders;
import com.teachy.coins.gateapi.models.Order;
import com.teachy.coins.gateapi.models.OrderBook;
import com.teachy.coins.gateapi.models.SpotAccount;
import com.teachy.coins.gateapi.models.Ticker;
import com.teachy.coins.gateapi.models.Trade;
import com.teachy.coins.gateapi.models.TradeFee;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SpotApi {
    private ApiClient localVarApiClient;

    public SpotApi() {
        this(Configuration.getDefaultApiClient());
    }

    public SpotApi(ApiClient apiClient) {
        this.localVarApiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return localVarApiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.localVarApiClient = apiClient;
    }

    /**
     * Build call for listCurrencyPairs
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> All currency pairs retrieved </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call listCurrencyPairsCall(final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/spot/currency_pairs";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();
        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        String[] localVarAuthNames = new String[] {  };
        return localVarApiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call listCurrencyPairsValidateBeforeCall(final ApiCallback _callback) throws ApiException {
        okhttp3.Call localVarCall = listCurrencyPairsCall(_callback);
        return localVarCall;
    }

    /**
     * List all currency pairs supported
     * 
     * @return List&lt;CurrencyPair&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> All currency pairs retrieved </td><td>  -  </td></tr>
     </table>
     */
    public List<CurrencyPair> listCurrencyPairs() throws ApiException {
        ApiResponse<List<CurrencyPair>> localVarResp = listCurrencyPairsWithHttpInfo();
        return localVarResp.getData();
    }

    /**
     * List all currency pairs supported
     * 
     * @return ApiResponse&lt;List&lt;CurrencyPair&gt;&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> All currency pairs retrieved </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<List<CurrencyPair>> listCurrencyPairsWithHttpInfo() throws ApiException {
        okhttp3.Call localVarCall = listCurrencyPairsValidateBeforeCall(null);
        Type localVarReturnType = new com.google.common.reflect.TypeToken<List<CurrencyPair>>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * List all currency pairs supported (asynchronously)
     * 
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> All currency pairs retrieved </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call listCurrencyPairsAsync(final ApiCallback<List<CurrencyPair>> _callback) throws ApiException {
        okhttp3.Call localVarCall = listCurrencyPairsValidateBeforeCall(_callback);
        Type localVarReturnType = new com.google.common.reflect.TypeToken<List<CurrencyPair>>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    /**
     * Build call for getCurrencyPair
     * @param currencyPair Currency pair (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Successfully retrieved </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call getCurrencyPairCall(String currencyPair, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/spot/currency_pairs/{currency_pair}"
            .replaceAll("\\{" + "currency_pair" + "\\}", localVarApiClient.escapeString(currencyPair));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();
        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        String[] localVarAuthNames = new String[] {  };
        return localVarApiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call getCurrencyPairValidateBeforeCall(String currencyPair, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'currencyPair' is set
        if (currencyPair == null) {
            throw new ApiException("Missing the required parameter 'currencyPair' when calling getCurrencyPair(Async)");
        }

        okhttp3.Call localVarCall = getCurrencyPairCall(currencyPair, _callback);
        return localVarCall;
    }

    /**
     * Get detail of one single order
     * 
     * @param currencyPair Currency pair (required)
     * @return CurrencyPair
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Successfully retrieved </td><td>  -  </td></tr>
     </table>
     */
    public CurrencyPair getCurrencyPair(String currencyPair) throws ApiException {
        ApiResponse<CurrencyPair> localVarResp = getCurrencyPairWithHttpInfo(currencyPair);
        return localVarResp.getData();
    }

    /**
     * Get detail of one single order
     * 
     * @param currencyPair Currency pair (required)
     * @return ApiResponse&lt;CurrencyPair&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Successfully retrieved </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<CurrencyPair> getCurrencyPairWithHttpInfo(String currencyPair) throws ApiException {
        okhttp3.Call localVarCall = getCurrencyPairValidateBeforeCall(currencyPair, null);
        Type localVarReturnType = new com.google.common.reflect.TypeToken<CurrencyPair>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Get detail of one single order (asynchronously)
     * 
     * @param currencyPair Currency pair (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Successfully retrieved </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call getCurrencyPairAsync(String currencyPair, final ApiCallback<CurrencyPair> _callback) throws ApiException {
        okhttp3.Call localVarCall = getCurrencyPairValidateBeforeCall(currencyPair, _callback);
        Type localVarReturnType = new com.google.common.reflect.TypeToken<CurrencyPair>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    private okhttp3.Call listTickersCall(String currencyPair, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/spot/tickers";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (currencyPair != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("currency_pair", currencyPair));
        }

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();
        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        String[] localVarAuthNames = new String[] {  };
        return localVarApiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call listTickersValidateBeforeCall(String currencyPair, final ApiCallback _callback) throws ApiException {
        okhttp3.Call localVarCall = listTickersCall(currencyPair, _callback);
        return localVarCall;
    }


    private ApiResponse<List<Ticker>> listTickersWithHttpInfo(String currencyPair) throws ApiException {
        okhttp3.Call localVarCall = listTickersValidateBeforeCall(currencyPair, null);
        Type localVarReturnType = new com.google.common.reflect.TypeToken<List<Ticker>>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call listTickersAsync(String currencyPair, final ApiCallback<List<Ticker>> _callback) throws ApiException {
        okhttp3.Call localVarCall = listTickersValidateBeforeCall(currencyPair, _callback);
        Type localVarReturnType = new com.google.common.reflect.TypeToken<List<Ticker>>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class APIlistTickersRequest {
        private String currencyPair;

        private APIlistTickersRequest() {
        }

        /**
         * Set currencyPair
         * @param currencyPair Currency pair (optional)
         * @return APIlistTickersRequest
         */
        public APIlistTickersRequest currencyPair(String currencyPair) {
            this.currencyPair = currencyPair;
            return this;
        }

        /**
         * Build call for listTickers
         * @param _callback ApiCallback API callback
         * @return Call to execute
         * @throws ApiException If fail to serialize the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> Successfully retrieved </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call buildCall(final ApiCallback _callback) throws ApiException {
            return listTickersCall(currencyPair, _callback);
        }

        /**
         * Execute listTickers request
         * @return List&lt;Ticker&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> Successfully retrieved </td><td>  -  </td></tr>
         </table>
         */
        public List<Ticker> execute() throws ApiException {
            ApiResponse<List<Ticker>> localVarResp = listTickersWithHttpInfo(currencyPair);
            return localVarResp.getData();
        }

        /**
         * Execute listTickers request with HTTP info returned
         * @return ApiResponse&lt;List&lt;Ticker&gt;&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> Successfully retrieved </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<List<Ticker>> executeWithHttpInfo() throws ApiException {
            return listTickersWithHttpInfo(currencyPair);
        }

        /**
         * Execute listTickers request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> Successfully retrieved </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<List<Ticker>> _callback) throws ApiException {
            return listTickersAsync(currencyPair, _callback);
        }
    }

    /**
     * Retrieve ticker information
     * Return only related data if &#x60;currency_pair&#x60; is specified; otherwise return all of them
     * @return APIlistTickersRequest
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Successfully retrieved </td><td>  -  </td></tr>
     </table>
     */
    public APIlistTickersRequest listTickers() {
        return new APIlistTickersRequest();
    }

    private okhttp3.Call listOrderBookCall(String currencyPair, String interval, Integer limit, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/spot/order_book";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (currencyPair != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("currency_pair", currencyPair));
        }

        if (interval != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("interval", interval));
        }

        if (limit != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("limit", limit));
        }

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();
        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        String[] localVarAuthNames = new String[] {  };
        return localVarApiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call listOrderBookValidateBeforeCall(String currencyPair, String interval, Integer limit, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'currencyPair' is set
        if (currencyPair == null) {
            throw new ApiException("Missing the required parameter 'currencyPair' when calling listOrderBook(Async)");
        }

        okhttp3.Call localVarCall = listOrderBookCall(currencyPair, interval, limit, _callback);
        return localVarCall;
    }


    private ApiResponse<OrderBook> listOrderBookWithHttpInfo(String currencyPair, String interval, Integer limit) throws ApiException {
        okhttp3.Call localVarCall = listOrderBookValidateBeforeCall(currencyPair, interval, limit, null);
        Type localVarReturnType = new com.google.common.reflect.TypeToken<OrderBook>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call listOrderBookAsync(String currencyPair, String interval, Integer limit, final ApiCallback<OrderBook> _callback) throws ApiException {
        okhttp3.Call localVarCall = listOrderBookValidateBeforeCall(currencyPair, interval, limit, _callback);
        Type localVarReturnType = new com.google.common.reflect.TypeToken<OrderBook>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class APIlistOrderBookRequest {
        private final String currencyPair;
        private String interval;
        private Integer limit;

        private APIlistOrderBookRequest(String currencyPair) {
            this.currencyPair = currencyPair;
        }

        /**
         * Set interval
         * @param interval Order depth. 0 means no aggregation is applied. default to 0 (optional, default to &quot;0&quot;)
         * @return APIlistOrderBookRequest
         */
        public APIlistOrderBookRequest interval(String interval) {
            this.interval = interval;
            return this;
        }

        /**
         * Set limit
         * @param limit Maximum number of order depth data in asks or bids (optional, default to 10)
         * @return APIlistOrderBookRequest
         */
        public APIlistOrderBookRequest limit(Integer limit) {
            this.limit = limit;
            return this;
        }

        /**
         * Build call for listOrderBook
         * @param _callback ApiCallback API callback
         * @return Call to execute
         * @throws ApiException If fail to serialize the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> Successfully retrieved </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call buildCall(final ApiCallback _callback) throws ApiException {
            return listOrderBookCall(currencyPair, interval, limit, _callback);
        }

        /**
         * Execute listOrderBook request
         * @return OrderBook
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> Successfully retrieved </td><td>  -  </td></tr>
         </table>
         */
        public OrderBook execute() throws ApiException {
            ApiResponse<OrderBook> localVarResp = listOrderBookWithHttpInfo(currencyPair, interval, limit);
            return localVarResp.getData();
        }

        /**
         * Execute listOrderBook request with HTTP info returned
         * @return ApiResponse&lt;OrderBook&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> Successfully retrieved </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<OrderBook> executeWithHttpInfo() throws ApiException {
            return listOrderBookWithHttpInfo(currencyPair, interval, limit);
        }

        /**
         * Execute listOrderBook request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> Successfully retrieved </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<OrderBook> _callback) throws ApiException {
            return listOrderBookAsync(currencyPair, interval, limit, _callback);
        }
    }

    /**
     * Retrieve order book
     * Order book will be sorted by price from high to low on bids; reversed on asks
     * @param currencyPair Currency pair (required)
     * @return APIlistOrderBookRequest
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Successfully retrieved </td><td>  -  </td></tr>
     </table>
     */
    public APIlistOrderBookRequest listOrderBook(String currencyPair) {
        return new APIlistOrderBookRequest(currencyPair);
    }

    private okhttp3.Call listTradesCall(String currencyPair, Integer limit, String lastId, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/spot/trades";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (currencyPair != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("currency_pair", currencyPair));
        }

        if (limit != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("limit", limit));
        }

        if (lastId != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("last_id", lastId));
        }

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();
        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        String[] localVarAuthNames = new String[] {  };
        return localVarApiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call listTradesValidateBeforeCall(String currencyPair, Integer limit, String lastId, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'currencyPair' is set
        if (currencyPair == null) {
            throw new ApiException("Missing the required parameter 'currencyPair' when calling listTrades(Async)");
        }

        okhttp3.Call localVarCall = listTradesCall(currencyPair, limit, lastId, _callback);
        return localVarCall;
    }


    private ApiResponse<List<Trade>> listTradesWithHttpInfo(String currencyPair, Integer limit, String lastId) throws ApiException {
        okhttp3.Call localVarCall = listTradesValidateBeforeCall(currencyPair, limit, lastId, null);
        Type localVarReturnType = new com.google.common.reflect.TypeToken<List<Trade>>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call listTradesAsync(String currencyPair, Integer limit, String lastId, final ApiCallback<List<Trade>> _callback) throws ApiException {
        okhttp3.Call localVarCall = listTradesValidateBeforeCall(currencyPair, limit, lastId, _callback);
        Type localVarReturnType = new com.google.common.reflect.TypeToken<List<Trade>>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class APIlistTradesRequest {
        private final String currencyPair;
        private Integer limit;
        private String lastId;

        private APIlistTradesRequest(String currencyPair) {
            this.currencyPair = currencyPair;
        }

        /**
         * Set limit
         * @param limit Maximum number of records returned in one list (optional, default to 100)
         * @return APIlistTradesRequest
         */
        public APIlistTradesRequest limit(Integer limit) {
            this.limit = limit;
            return this;
        }

        /**
         * Set lastId
         * @param lastId Specify list staring point using the &#x60;id&#x60; of last record in previous list-query results (optional)
         * @return APIlistTradesRequest
         */
        public APIlistTradesRequest lastId(String lastId) {
            this.lastId = lastId;
            return this;
        }

        /**
         * Build call for listTrades
         * @param _callback ApiCallback API callback
         * @return Call to execute
         * @throws ApiException If fail to serialize the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> List retrieved </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call buildCall(final ApiCallback _callback) throws ApiException {
            return listTradesCall(currencyPair, limit, lastId, _callback);
        }

        /**
         * Execute listTrades request
         * @return List&lt;Trade&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> List retrieved </td><td>  -  </td></tr>
         </table>
         */
        public List<Trade> execute() throws ApiException {
            ApiResponse<List<Trade>> localVarResp = listTradesWithHttpInfo(currencyPair, limit, lastId);
            return localVarResp.getData();
        }

        /**
         * Execute listTrades request with HTTP info returned
         * @return ApiResponse&lt;List&lt;Trade&gt;&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> List retrieved </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<List<Trade>> executeWithHttpInfo() throws ApiException {
            return listTradesWithHttpInfo(currencyPair, limit, lastId);
        }

        /**
         * Execute listTrades request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> List retrieved </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<List<Trade>> _callback) throws ApiException {
            return listTradesAsync(currencyPair, limit, lastId, _callback);
        }
    }

    /**
     * Retrieve market trades
     * 
     * @param currencyPair Currency pair (required)
     * @return APIlistTradesRequest
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> List retrieved </td><td>  -  </td></tr>
     </table>
     */
    public APIlistTradesRequest listTrades(String currencyPair) {
        return new APIlistTradesRequest(currencyPair);
    }

    private okhttp3.Call listCandlesticksCall(String currencyPair, Integer limit, Long from, Long to, String interval, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/spot/candlesticks";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (currencyPair != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("currency_pair", currencyPair));
        }

        if (limit != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("limit", limit));
        }

        if (from != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("from", from));
        }

        if (to != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("to", to));
        }

        if (interval != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("interval", interval));
        }

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();
        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        String[] localVarAuthNames = new String[] {  };
        return localVarApiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call listCandlesticksValidateBeforeCall(String currencyPair, Integer limit, Long from, Long to, String interval, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'currencyPair' is set
        if (currencyPair == null) {
            throw new ApiException("Missing the required parameter 'currencyPair' when calling listCandlesticks(Async)");
        }

        okhttp3.Call localVarCall = listCandlesticksCall(currencyPair, limit, from, to, interval, _callback);
        return localVarCall;
    }


    private ApiResponse<List<List<String>>> listCandlesticksWithHttpInfo(String currencyPair, Integer limit, Long from, Long to, String interval) throws ApiException {
        okhttp3.Call localVarCall = listCandlesticksValidateBeforeCall(currencyPair, limit, from, to, interval, null);
        Type localVarReturnType = new com.google.common.reflect.TypeToken<List<List<String>>>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call listCandlesticksAsync(String currencyPair, Integer limit, Long from, Long to, String interval, final ApiCallback<List<List<String>>> _callback) throws ApiException {
        okhttp3.Call localVarCall = listCandlesticksValidateBeforeCall(currencyPair, limit, from, to, interval, _callback);
        Type localVarReturnType = new com.google.common.reflect.TypeToken<List<List<String>>>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class APIlistCandlesticksRequest {
        private final String currencyPair;
        private Integer limit;
        private Long from;
        private Long to;
        private String interval;

        private APIlistCandlesticksRequest(String currencyPair) {
            this.currencyPair = currencyPair;
        }

        /**
         * Set limit
         * @param limit Maximum recent data points returned. &#x60;limit&#x60; is conflicted with &#x60;from&#x60; and &#x60;to&#x60;. If either &#x60;from&#x60; or &#x60;to&#x60; is specified, request will be rejected. (optional, default to 100)
         * @return APIlistCandlesticksRequest
         */
        public APIlistCandlesticksRequest limit(Integer limit) {
            this.limit = limit;
            return this;
        }

        /**
         * Set from
         * @param from Start time of candlesticks, formatted in Unix timestamp in seconds. Default to&#x60;to - 100 * interval&#x60; if not specified (optional)
         * @return APIlistCandlesticksRequest
         */
        public APIlistCandlesticksRequest from(Long from) {
            this.from = from;
            return this;
        }

        /**
         * Set to
         * @param to End time of candlesticks, formatted in Unix timestamp in seconds. Default to current time (optional)
         * @return APIlistCandlesticksRequest
         */
        public APIlistCandlesticksRequest to(Long to) {
            this.to = to;
            return this;
        }

        /**
         * Set interval
         * @param interval Interval time between data points (optional, default to 30m)
         * @return APIlistCandlesticksRequest
         */
        public APIlistCandlesticksRequest interval(String interval) {
            this.interval = interval;
            return this;
        }

        /**
         * Build call for listCandlesticks
         * @param _callback ApiCallback API callback
         * @return Call to execute
         * @throws ApiException If fail to serialize the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> Successfully retrieved </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call buildCall(final ApiCallback _callback) throws ApiException {
            return listCandlesticksCall(currencyPair, limit, from, to, interval, _callback);
        }

        /**
         * Execute listCandlesticks request
         * @return List&lt;List&lt;String&gt;&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> Successfully retrieved </td><td>  -  </td></tr>
         </table>
         */
        public List<List<String>> execute() throws ApiException {
            ApiResponse<List<List<String>>> localVarResp = listCandlesticksWithHttpInfo(currencyPair, limit, from, to, interval);
            return localVarResp.getData();
        }

        /**
         * Execute listCandlesticks request with HTTP info returned
         * @return ApiResponse&lt;List&lt;List&lt;String&gt;&gt;&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> Successfully retrieved </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<List<List<String>>> executeWithHttpInfo() throws ApiException {
            return listCandlesticksWithHttpInfo(currencyPair, limit, from, to, interval);
        }

        /**
         * Execute listCandlesticks request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> Successfully retrieved </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<List<List<String>>> _callback) throws ApiException {
            return listCandlesticksAsync(currencyPair, limit, from, to, interval, _callback);
        }
    }

    /**
     * Market candlesticks
     * Maximum of 1000 points are returned in one query. Be sure not to exceed the limit when specifying &#x60;from&#x60;, &#x60;to&#x60; and &#x60;interval&#x60;
     * @param currencyPair Currency pair (required)
     * @return APIlistCandlesticksRequest
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Successfully retrieved </td><td>  -  </td></tr>
     </table>
     */
    public APIlistCandlesticksRequest listCandlesticks(String currencyPair) {
        return new APIlistCandlesticksRequest(currencyPair);
    }

    private okhttp3.Call getFeeCall(String currencyPair, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/spot/fee";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (currencyPair != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("currency_pair", currencyPair));
        }

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();
        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        String[] localVarAuthNames = new String[] { "apiv4" };
        return localVarApiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call getFeeValidateBeforeCall(String currencyPair, final ApiCallback _callback) throws ApiException {
        okhttp3.Call localVarCall = getFeeCall(currencyPair, _callback);
        return localVarCall;
    }


    private ApiResponse<TradeFee> getFeeWithHttpInfo(String currencyPair) throws ApiException {
        okhttp3.Call localVarCall = getFeeValidateBeforeCall(currencyPair, null);
        Type localVarReturnType = new com.google.common.reflect.TypeToken<TradeFee>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call getFeeAsync(String currencyPair, final ApiCallback<TradeFee> _callback) throws ApiException {
        okhttp3.Call localVarCall = getFeeValidateBeforeCall(currencyPair, _callback);
        Type localVarReturnType = new com.google.common.reflect.TypeToken<TradeFee>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class APIgetFeeRequest {
        private String currencyPair;

        private APIgetFeeRequest() {
        }

        /**
         * Set currencyPair
         * @param currencyPair Specify a currency pair to retrieve precise fee rate  This field is optional. In most cases, the fee rate is identical among all currency pairs (optional)
         * @return APIgetFeeRequest
         */
        public APIgetFeeRequest currencyPair(String currencyPair) {
            this.currencyPair = currencyPair;
            return this;
        }

        /**
         * Build call for getFee
         * @param _callback ApiCallback API callback
         * @return Call to execute
         * @throws ApiException If fail to serialize the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> Successfully retrieved </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call buildCall(final ApiCallback _callback) throws ApiException {
            return getFeeCall(currencyPair, _callback);
        }

        /**
         * Execute getFee request
         * @return TradeFee
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> Successfully retrieved </td><td>  -  </td></tr>
         </table>
         */
        public TradeFee execute() throws ApiException {
            ApiResponse<TradeFee> localVarResp = getFeeWithHttpInfo(currencyPair);
            return localVarResp.getData();
        }

        /**
         * Execute getFee request with HTTP info returned
         * @return ApiResponse&lt;TradeFee&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> Successfully retrieved </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<TradeFee> executeWithHttpInfo() throws ApiException {
            return getFeeWithHttpInfo(currencyPair);
        }

        /**
         * Execute getFee request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> Successfully retrieved </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<TradeFee> _callback) throws ApiException {
            return getFeeAsync(currencyPair, _callback);
        }
    }

    /**
     * Query user trading fee rates
     * 
     * @return APIgetFeeRequest
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Successfully retrieved </td><td>  -  </td></tr>
     </table>
     */
    public APIgetFeeRequest getFee() {
        return new APIgetFeeRequest();
    }

    private okhttp3.Call listSpotAccountsCall(String currency, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/spot/accounts";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (currency != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("currency", currency));
        }

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();
        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        String[] localVarAuthNames = new String[] { "apiv4" };
        return localVarApiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call listSpotAccountsValidateBeforeCall(String currency, final ApiCallback _callback) throws ApiException {
        okhttp3.Call localVarCall = listSpotAccountsCall(currency, _callback);
        return localVarCall;
    }


    private ApiResponse<List<SpotAccount>> listSpotAccountsWithHttpInfo(String currency) throws ApiException {
        okhttp3.Call localVarCall = listSpotAccountsValidateBeforeCall(currency, null);
        Type localVarReturnType = new com.google.common.reflect.TypeToken<List<SpotAccount>>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call listSpotAccountsAsync(String currency, final ApiCallback<List<SpotAccount>> _callback) throws ApiException {
        okhttp3.Call localVarCall = listSpotAccountsValidateBeforeCall(currency, _callback);
        Type localVarReturnType = new com.google.common.reflect.TypeToken<List<SpotAccount>>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class APIlistSpotAccountsRequest {
        private String currency;

        private APIlistSpotAccountsRequest() {
        }

        /**
         * Set currency
         * @param currency Retrieved specified currency related data (optional)
         * @return APIlistSpotAccountsRequest
         */
        public APIlistSpotAccountsRequest currency(String currency) {
            this.currency = currency;
            return this;
        }

        /**
         * Build call for listSpotAccounts
         * @param _callback ApiCallback API callback
         * @return Call to execute
         * @throws ApiException If fail to serialize the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> List retrieved </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call buildCall(final ApiCallback _callback) throws ApiException {
            return listSpotAccountsCall(currency, _callback);
        }

        /**
         * Execute listSpotAccounts request
         * @return List&lt;SpotAccount&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> List retrieved </td><td>  -  </td></tr>
         </table>
         */
        public List<SpotAccount> execute() throws ApiException {
            ApiResponse<List<SpotAccount>> localVarResp = listSpotAccountsWithHttpInfo(currency);
            return localVarResp.getData();
        }

        /**
         * Execute listSpotAccounts request with HTTP info returned
         * @return ApiResponse&lt;List&lt;SpotAccount&gt;&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> List retrieved </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<List<SpotAccount>> executeWithHttpInfo() throws ApiException {
            return listSpotAccountsWithHttpInfo(currency);
        }

        /**
         * Execute listSpotAccounts request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> List retrieved </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<List<SpotAccount>> _callback) throws ApiException {
            return listSpotAccountsAsync(currency, _callback);
        }
    }

    /**
     * List spot accounts
     * 
     * @return APIlistSpotAccountsRequest
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> List retrieved </td><td>  -  </td></tr>
     </table>
     */
    public APIlistSpotAccountsRequest listSpotAccounts() {
        return new APIlistSpotAccountsRequest();
    }

    /**
     * Build call for createBatchOrders
     * @param order  (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Request is completed </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call createBatchOrdersCall(List<Order> order, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = order;

        // create path and map variables
        String localVarPath = "/spot/batch_orders";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();
        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        String[] localVarAuthNames = new String[] { "apiv4" };
        return localVarApiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call createBatchOrdersValidateBeforeCall(List<Order> order, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'order' is set
        if (order == null) {
            throw new ApiException("Missing the required parameter 'order' when calling createBatchOrders(Async)");
        }

        okhttp3.Call localVarCall = createBatchOrdersCall(order, _callback);
        return localVarCall;
    }

    /**
     * Create a batch of orders
     * Batch orders requirements:  1. custom order field &#x60;text&#x60; is required 2. At most 4 currency pairs, maximum 5 orders each, are allowed in one request 3. No mixture of spot orders and margin orders, i.e. &#x60;account&#x60; must be identical for all orders 
     * @param order  (required)
     * @return List&lt;BatchOrder&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Request is completed </td><td>  -  </td></tr>
     </table>
     */
    public List<BatchOrder> createBatchOrders(List<Order> order) throws ApiException {
        ApiResponse<List<BatchOrder>> localVarResp = createBatchOrdersWithHttpInfo(order);
        return localVarResp.getData();
    }

    /**
     * Create a batch of orders
     * Batch orders requirements:  1. custom order field &#x60;text&#x60; is required 2. At most 4 currency pairs, maximum 5 orders each, are allowed in one request 3. No mixture of spot orders and margin orders, i.e. &#x60;account&#x60; must be identical for all orders 
     * @param order  (required)
     * @return ApiResponse&lt;List&lt;BatchOrder&gt;&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Request is completed </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<List<BatchOrder>> createBatchOrdersWithHttpInfo(List<Order> order) throws ApiException {
        okhttp3.Call localVarCall = createBatchOrdersValidateBeforeCall(order, null);
        Type localVarReturnType = new com.google.common.reflect.TypeToken<List<BatchOrder>>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Create a batch of orders (asynchronously)
     * Batch orders requirements:  1. custom order field &#x60;text&#x60; is required 2. At most 4 currency pairs, maximum 5 orders each, are allowed in one request 3. No mixture of spot orders and margin orders, i.e. &#x60;account&#x60; must be identical for all orders 
     * @param order  (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Request is completed </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call createBatchOrdersAsync(List<Order> order, final ApiCallback<List<BatchOrder>> _callback) throws ApiException {
        okhttp3.Call localVarCall = createBatchOrdersValidateBeforeCall(order, _callback);
        Type localVarReturnType = new com.google.common.reflect.TypeToken<List<BatchOrder>>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    private okhttp3.Call listAllOpenOrdersCall(Integer page, Integer limit, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/spot/open_orders";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (page != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("page", page));
        }

        if (limit != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("limit", limit));
        }

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();
        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        String[] localVarAuthNames = new String[] { "apiv4" };
        return localVarApiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call listAllOpenOrdersValidateBeforeCall(Integer page, Integer limit, final ApiCallback _callback) throws ApiException {
        okhttp3.Call localVarCall = listAllOpenOrdersCall(page, limit, _callback);
        return localVarCall;
    }


    private ApiResponse<List<OpenOrders>> listAllOpenOrdersWithHttpInfo(Integer page, Integer limit) throws ApiException {
        okhttp3.Call localVarCall = listAllOpenOrdersValidateBeforeCall(page, limit, null);
        Type localVarReturnType = new com.google.common.reflect.TypeToken<List<OpenOrders>>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call listAllOpenOrdersAsync(Integer page, Integer limit, final ApiCallback<List<OpenOrders>> _callback) throws ApiException {
        okhttp3.Call localVarCall = listAllOpenOrdersValidateBeforeCall(page, limit, _callback);
        Type localVarReturnType = new com.google.common.reflect.TypeToken<List<OpenOrders>>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class APIlistAllOpenOrdersRequest {
        private Integer page;
        private Integer limit;

        private APIlistAllOpenOrdersRequest() {
        }

        /**
         * Set page
         * @param page Page number (optional, default to 1)
         * @return APIlistAllOpenOrdersRequest
         */
        public APIlistAllOpenOrdersRequest page(Integer page) {
            this.page = page;
            return this;
        }

        /**
         * Set limit
         * @param limit Maximum number of records returned in one page in each currency pair (optional, default to 100)
         * @return APIlistAllOpenOrdersRequest
         */
        public APIlistAllOpenOrdersRequest limit(Integer limit) {
            this.limit = limit;
            return this;
        }

        /**
         * Build call for listAllOpenOrders
         * @param _callback ApiCallback API callback
         * @return Call to execute
         * @throws ApiException If fail to serialize the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> List retrieved </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call buildCall(final ApiCallback _callback) throws ApiException {
            return listAllOpenOrdersCall(page, limit, _callback);
        }

        /**
         * Execute listAllOpenOrders request
         * @return List&lt;OpenOrders&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> List retrieved </td><td>  -  </td></tr>
         </table>
         */
        public List<OpenOrders> execute() throws ApiException {
            ApiResponse<List<OpenOrders>> localVarResp = listAllOpenOrdersWithHttpInfo(page, limit);
            return localVarResp.getData();
        }

        /**
         * Execute listAllOpenOrders request with HTTP info returned
         * @return ApiResponse&lt;List&lt;OpenOrders&gt;&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> List retrieved </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<List<OpenOrders>> executeWithHttpInfo() throws ApiException {
            return listAllOpenOrdersWithHttpInfo(page, limit);
        }

        /**
         * Execute listAllOpenOrders request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> List retrieved </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<List<OpenOrders>> _callback) throws ApiException {
            return listAllOpenOrdersAsync(page, limit, _callback);
        }
    }

    /**
     * List all open orders
     * List open orders in all currency pairs.  Note that pagination parameters affect record number in each currency pair&#39;s open order list. No pagination is applied to the number of currency pairs returned. All currency pairs with open orders will be returned
     * @return APIlistAllOpenOrdersRequest
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> List retrieved </td><td>  -  </td></tr>
     </table>
     */
    public APIlistAllOpenOrdersRequest listAllOpenOrders() {
        return new APIlistAllOpenOrdersRequest();
    }

    private okhttp3.Call listOrdersCall(String currencyPair, String status, Integer page, Integer limit, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/spot/orders";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (currencyPair != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("currency_pair", currencyPair));
        }

        if (status != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("status", status));
        }

        if (page != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("page", page));
        }

        if (limit != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("limit", limit));
        }

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();
        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        String[] localVarAuthNames = new String[] { "apiv4" };
        return localVarApiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call listOrdersValidateBeforeCall(String currencyPair, String status, Integer page, Integer limit, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'currencyPair' is set
        if (currencyPair == null) {
            throw new ApiException("Missing the required parameter 'currencyPair' when calling listOrders(Async)");
        }

        // verify the required parameter 'status' is set
        if (status == null) {
            throw new ApiException("Missing the required parameter 'status' when calling listOrders(Async)");
        }

        okhttp3.Call localVarCall = listOrdersCall(currencyPair, status, page, limit, _callback);
        return localVarCall;
    }


    private ApiResponse<List<Order>> listOrdersWithHttpInfo(String currencyPair, String status, Integer page, Integer limit) throws ApiException {
        okhttp3.Call localVarCall = listOrdersValidateBeforeCall(currencyPair, status, page, limit, null);
        Type localVarReturnType = new com.google.common.reflect.TypeToken<List<Order>>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call listOrdersAsync(String currencyPair, String status, Integer page, Integer limit, final ApiCallback<List<Order>> _callback) throws ApiException {
        okhttp3.Call localVarCall = listOrdersValidateBeforeCall(currencyPair, status, page, limit, _callback);
        Type localVarReturnType = new com.google.common.reflect.TypeToken<List<Order>>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class APIlistOrdersRequest {
        private final String currencyPair;
        private final String status;
        private Integer page;
        private Integer limit;

        private APIlistOrdersRequest(String currencyPair, String status) {
            this.currencyPair = currencyPair;
            this.status = status;
        }

        /**
         * Set page
         * @param page Page number (optional, default to 1)
         * @return APIlistOrdersRequest
         */
        public APIlistOrdersRequest page(Integer page) {
            this.page = page;
            return this;
        }

        /**
         * Set limit
         * @param limit Maximum number of records returned. If &#x60;status&#x60; is &#x60;open&#x60;, maximum of &#x60;limit&#x60; is 100 (optional, default to 100)
         * @return APIlistOrdersRequest
         */
        public APIlistOrdersRequest limit(Integer limit) {
            this.limit = limit;
            return this;
        }

        /**
         * Build call for listOrders
         * @param _callback ApiCallback API callback
         * @return Call to execute
         * @throws ApiException If fail to serialize the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> List retrieved </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call buildCall(final ApiCallback _callback) throws ApiException {
            return listOrdersCall(currencyPair, status, page, limit, _callback);
        }

        /**
         * Execute listOrders request
         * @return List&lt;Order&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> List retrieved </td><td>  -  </td></tr>
         </table>
         */
        public List<Order> execute() throws ApiException {
            ApiResponse<List<Order>> localVarResp = listOrdersWithHttpInfo(currencyPair, status, page, limit);
            return localVarResp.getData();
        }

        /**
         * Execute listOrders request with HTTP info returned
         * @return ApiResponse&lt;List&lt;Order&gt;&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> List retrieved </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<List<Order>> executeWithHttpInfo() throws ApiException {
            return listOrdersWithHttpInfo(currencyPair, status, page, limit);
        }

        /**
         * Execute listOrders request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> List retrieved </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<List<Order>> _callback) throws ApiException {
            return listOrdersAsync(currencyPair, status, page, limit, _callback);
        }
    }

    /**
     * List orders
     * 
     * @param currencyPair Currency pair (required)
     * @param status List orders based on status  &#x60;open&#x60; - order is waiting to be filled &#x60;finished&#x60; - order has been filled or cancelled  (required)
     * @return APIlistOrdersRequest
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> List retrieved </td><td>  -  </td></tr>
     </table>
     */
    public APIlistOrdersRequest listOrders(String currencyPair, String status) {
        return new APIlistOrdersRequest(currencyPair, status);
    }

    /**
     * Build call for createOrder
     * @param order  (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 201 </td><td> Order created. </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call createOrderCall(Order order, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = order;

        // create path and map variables
        String localVarPath = "/spot/orders";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();
        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        String[] localVarAuthNames = new String[] { "apiv4" };
        return localVarApiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call createOrderValidateBeforeCall(Order order, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'order' is set
        if (order == null) {
            throw new ApiException("Missing the required parameter 'order' when calling createOrder(Async)");
        }

        okhttp3.Call localVarCall = createOrderCall(order, _callback);
        return localVarCall;
    }

    /**
     * Create an order
     * 
     * @param order  (required)
     * @return Order
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 201 </td><td> Order created. </td><td>  -  </td></tr>
     </table>
     */
    public Order createOrder(Order order) throws ApiException {
        ApiResponse<Order> localVarResp = createOrderWithHttpInfo(order);
        return localVarResp.getData();
    }

    /**
     * Create an order
     * 
     * @param order  (required)
     * @return ApiResponse&lt;Order&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 201 </td><td> Order created. </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<Order> createOrderWithHttpInfo(Order order) throws ApiException {
        okhttp3.Call localVarCall = createOrderValidateBeforeCall(order, null);
        Type localVarReturnType = new com.google.common.reflect.TypeToken<Order>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Create an order (asynchronously)
     * 
     * @param order  (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 201 </td><td> Order created. </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call createOrderAsync(Order order, final ApiCallback<Order> _callback) throws ApiException {
        okhttp3.Call localVarCall = createOrderValidateBeforeCall(order, _callback);
        Type localVarReturnType = new com.google.common.reflect.TypeToken<Order>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    /**
     * Build call for cancelOrders
     * @param currencyPair Currency pair (required)
     * @param side All bids or asks. Both included in not specified (optional)
     * @param account Specify account type. Default to all account types being included (optional)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Batch cancellation request accepted. Query order status by listing orders </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call cancelOrdersCall(String currencyPair, String side, String account, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/spot/orders";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (currencyPair != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("currency_pair", currencyPair));
        }

        if (side != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("side", side));
        }

        if (account != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("account", account));
        }

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();
        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        String[] localVarAuthNames = new String[] { "apiv4" };
        return localVarApiClient.buildCall(localVarPath, "DELETE", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call cancelOrdersValidateBeforeCall(String currencyPair, String side, String account, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'currencyPair' is set
        if (currencyPair == null) {
            throw new ApiException("Missing the required parameter 'currencyPair' when calling cancelOrders(Async)");
        }

        okhttp3.Call localVarCall = cancelOrdersCall(currencyPair, side, account, _callback);
        return localVarCall;
    }

    /**
     * Cancel all &#x60;open&#x60; orders in specified currency pair
     * 
     * @param currencyPair Currency pair (required)
     * @param side All bids or asks. Both included in not specified (optional)
     * @param account Specify account type. Default to all account types being included (optional)
     * @return List&lt;Order&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Batch cancellation request accepted. Query order status by listing orders </td><td>  -  </td></tr>
     </table>
     */
    public List<Order> cancelOrders(String currencyPair, String side, String account) throws ApiException {
        ApiResponse<List<Order>> localVarResp = cancelOrdersWithHttpInfo(currencyPair, side, account);
        return localVarResp.getData();
    }

    /**
     * Cancel all &#x60;open&#x60; orders in specified currency pair
     * 
     * @param currencyPair Currency pair (required)
     * @param side All bids or asks. Both included in not specified (optional)
     * @param account Specify account type. Default to all account types being included (optional)
     * @return ApiResponse&lt;List&lt;Order&gt;&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Batch cancellation request accepted. Query order status by listing orders </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<List<Order>> cancelOrdersWithHttpInfo(String currencyPair, String side, String account) throws ApiException {
        okhttp3.Call localVarCall = cancelOrdersValidateBeforeCall(currencyPair, side, account, null);
        Type localVarReturnType = new com.google.common.reflect.TypeToken<List<Order>>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Cancel all &#x60;open&#x60; orders in specified currency pair (asynchronously)
     * 
     * @param currencyPair Currency pair (required)
     * @param side All bids or asks. Both included in not specified (optional)
     * @param account Specify account type. Default to all account types being included (optional)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Batch cancellation request accepted. Query order status by listing orders </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call cancelOrdersAsync(String currencyPair, String side, String account, final ApiCallback<List<Order>> _callback) throws ApiException {
        okhttp3.Call localVarCall = cancelOrdersValidateBeforeCall(currencyPair, side, account, _callback);
        Type localVarReturnType = new com.google.common.reflect.TypeToken<List<Order>>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    /**
     * Build call for cancelBatchOrders
     * @param cancelOrder  (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Batch cancellation completed </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call cancelBatchOrdersCall(List<CancelOrder> cancelOrder, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = cancelOrder;

        // create path and map variables
        String localVarPath = "/spot/cancel_batch_orders";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();
        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        String[] localVarAuthNames = new String[] { "apiv4" };
        return localVarApiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call cancelBatchOrdersValidateBeforeCall(List<CancelOrder> cancelOrder, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'cancelOrder' is set
        if (cancelOrder == null) {
            throw new ApiException("Missing the required parameter 'cancelOrder' when calling cancelBatchOrders(Async)");
        }

        okhttp3.Call localVarCall = cancelBatchOrdersCall(cancelOrder, _callback);
        return localVarCall;
    }

    /**
     * Cancel a batch of orders with an ID list
     * Multiple currency pairs can be specified, but maximum 20 orders are allowed per request
     * @param cancelOrder  (required)
     * @return List&lt;CancelOrderResult&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Batch cancellation completed </td><td>  -  </td></tr>
     </table>
     */
    public List<CancelOrderResult> cancelBatchOrders(List<CancelOrder> cancelOrder) throws ApiException {
        ApiResponse<List<CancelOrderResult>> localVarResp = cancelBatchOrdersWithHttpInfo(cancelOrder);
        return localVarResp.getData();
    }

    /**
     * Cancel a batch of orders with an ID list
     * Multiple currency pairs can be specified, but maximum 20 orders are allowed per request
     * @param cancelOrder  (required)
     * @return ApiResponse&lt;List&lt;CancelOrderResult&gt;&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Batch cancellation completed </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<List<CancelOrderResult>> cancelBatchOrdersWithHttpInfo(List<CancelOrder> cancelOrder) throws ApiException {
        okhttp3.Call localVarCall = cancelBatchOrdersValidateBeforeCall(cancelOrder, null);
        Type localVarReturnType = new com.google.common.reflect.TypeToken<List<CancelOrderResult>>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Cancel a batch of orders with an ID list (asynchronously)
     * Multiple currency pairs can be specified, but maximum 20 orders are allowed per request
     * @param cancelOrder  (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Batch cancellation completed </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call cancelBatchOrdersAsync(List<CancelOrder> cancelOrder, final ApiCallback<List<CancelOrderResult>> _callback) throws ApiException {
        okhttp3.Call localVarCall = cancelBatchOrdersValidateBeforeCall(cancelOrder, _callback);
        Type localVarReturnType = new com.google.common.reflect.TypeToken<List<CancelOrderResult>>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    /**
     * Build call for getOrder
     * @param orderId ID returned on order successfully being created (required)
     * @param currencyPair Currency pair (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Detail retrieved </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call getOrderCall(String orderId, String currencyPair, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/spot/orders/{order_id}"
            .replaceAll("\\{" + "order_id" + "\\}", localVarApiClient.escapeString(orderId));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (currencyPair != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("currency_pair", currencyPair));
        }

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();
        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        String[] localVarAuthNames = new String[] { "apiv4" };
        return localVarApiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call getOrderValidateBeforeCall(String orderId, String currencyPair, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'orderId' is set
        if (orderId == null) {
            throw new ApiException("Missing the required parameter 'orderId' when calling getOrder(Async)");
        }

        // verify the required parameter 'currencyPair' is set
        if (currencyPair == null) {
            throw new ApiException("Missing the required parameter 'currencyPair' when calling getOrder(Async)");
        }

        okhttp3.Call localVarCall = getOrderCall(orderId, currencyPair, _callback);
        return localVarCall;
    }

    /**
     * Get a single order
     * 
     * @param orderId ID returned on order successfully being created (required)
     * @param currencyPair Currency pair (required)
     * @return Order
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Detail retrieved </td><td>  -  </td></tr>
     </table>
     */
    public Order getOrder(String orderId, String currencyPair) throws ApiException {
        ApiResponse<Order> localVarResp = getOrderWithHttpInfo(orderId, currencyPair);
        return localVarResp.getData();
    }

    /**
     * Get a single order
     * 
     * @param orderId ID returned on order successfully being created (required)
     * @param currencyPair Currency pair (required)
     * @return ApiResponse&lt;Order&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Detail retrieved </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<Order> getOrderWithHttpInfo(String orderId, String currencyPair) throws ApiException {
        okhttp3.Call localVarCall = getOrderValidateBeforeCall(orderId, currencyPair, null);
        Type localVarReturnType = new com.google.common.reflect.TypeToken<Order>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Get a single order (asynchronously)
     * 
     * @param orderId ID returned on order successfully being created (required)
     * @param currencyPair Currency pair (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Detail retrieved </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call getOrderAsync(String orderId, String currencyPair, final ApiCallback<Order> _callback) throws ApiException {
        okhttp3.Call localVarCall = getOrderValidateBeforeCall(orderId, currencyPair, _callback);
        Type localVarReturnType = new com.google.common.reflect.TypeToken<Order>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    /**
     * Build call for cancelOrder
     * @param orderId ID returned on order successfully being created (required)
     * @param currencyPair Currency pair (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Order cancelled </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call cancelOrderCall(String orderId, String currencyPair, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/spot/orders/{order_id}"
            .replaceAll("\\{" + "order_id" + "\\}", localVarApiClient.escapeString(orderId));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (currencyPair != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("currency_pair", currencyPair));
        }

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();
        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        String[] localVarAuthNames = new String[] { "apiv4" };
        return localVarApiClient.buildCall(localVarPath, "DELETE", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call cancelOrderValidateBeforeCall(String orderId, String currencyPair, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'orderId' is set
        if (orderId == null) {
            throw new ApiException("Missing the required parameter 'orderId' when calling cancelOrder(Async)");
        }

        // verify the required parameter 'currencyPair' is set
        if (currencyPair == null) {
            throw new ApiException("Missing the required parameter 'currencyPair' when calling cancelOrder(Async)");
        }

        okhttp3.Call localVarCall = cancelOrderCall(orderId, currencyPair, _callback);
        return localVarCall;
    }

    /**
     * Cancel a single order
     * 
     * @param orderId ID returned on order successfully being created (required)
     * @param currencyPair Currency pair (required)
     * @return Order
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Order cancelled </td><td>  -  </td></tr>
     </table>
     */
    public Order cancelOrder(String orderId, String currencyPair) throws ApiException {
        ApiResponse<Order> localVarResp = cancelOrderWithHttpInfo(orderId, currencyPair);
        return localVarResp.getData();
    }

    /**
     * Cancel a single order
     * 
     * @param orderId ID returned on order successfully being created (required)
     * @param currencyPair Currency pair (required)
     * @return ApiResponse&lt;Order&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Order cancelled </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<Order> cancelOrderWithHttpInfo(String orderId, String currencyPair) throws ApiException {
        okhttp3.Call localVarCall = cancelOrderValidateBeforeCall(orderId, currencyPair, null);
        Type localVarReturnType = new com.google.common.reflect.TypeToken<Order>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Cancel a single order (asynchronously)
     * 
     * @param orderId ID returned on order successfully being created (required)
     * @param currencyPair Currency pair (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Order cancelled </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call cancelOrderAsync(String orderId, String currencyPair, final ApiCallback<Order> _callback) throws ApiException {
        okhttp3.Call localVarCall = cancelOrderValidateBeforeCall(orderId, currencyPair, _callback);
        Type localVarReturnType = new com.google.common.reflect.TypeToken<Order>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    private okhttp3.Call listMyTradesCall(String currencyPair, Integer limit, Integer page, String orderId, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/spot/my_trades";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (currencyPair != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("currency_pair", currencyPair));
        }

        if (limit != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("limit", limit));
        }

        if (page != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("page", page));
        }

        if (orderId != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("order_id", orderId));
        }

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();
        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        String[] localVarAuthNames = new String[] { "apiv4" };
        return localVarApiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call listMyTradesValidateBeforeCall(String currencyPair, Integer limit, Integer page, String orderId, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'currencyPair' is set
        if (currencyPair == null) {
            throw new ApiException("Missing the required parameter 'currencyPair' when calling listMyTrades(Async)");
        }

        okhttp3.Call localVarCall = listMyTradesCall(currencyPair, limit, page, orderId, _callback);
        return localVarCall;
    }


    private ApiResponse<List<Trade>> listMyTradesWithHttpInfo(String currencyPair, Integer limit, Integer page, String orderId) throws ApiException {
        okhttp3.Call localVarCall = listMyTradesValidateBeforeCall(currencyPair, limit, page, orderId, null);
        Type localVarReturnType = new com.google.common.reflect.TypeToken<List<Trade>>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call listMyTradesAsync(String currencyPair, Integer limit, Integer page, String orderId, final ApiCallback<List<Trade>> _callback) throws ApiException {
        okhttp3.Call localVarCall = listMyTradesValidateBeforeCall(currencyPair, limit, page, orderId, _callback);
        Type localVarReturnType = new TypeToken<List<Trade>>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class APIlistMyTradesRequest {
        private final String currencyPair;
        private Integer limit;
        private Integer page;
        private String orderId;

        private APIlistMyTradesRequest(String currencyPair) {
            this.currencyPair = currencyPair;
        }

        /**
         * Set limit
         * @param limit Maximum number of records returned in one list (optional, default to 100)
         * @return APIlistMyTradesRequest
         */
        public APIlistMyTradesRequest limit(Integer limit) {
            this.limit = limit;
            return this;
        }

        /**
         * Set page
         * @param page Page number (optional, default to 1)
         * @return APIlistMyTradesRequest
         */
        public APIlistMyTradesRequest page(Integer page) {
            this.page = page;
            return this;
        }

        /**
         * Set orderId
         * @param orderId List all trades of specified order (optional)
         * @return APIlistMyTradesRequest
         */
        public APIlistMyTradesRequest orderId(String orderId) {
            this.orderId = orderId;
            return this;
        }

        /**
         * Build call for listMyTrades
         * @param _callback ApiCallback API callback
         * @return Call to execute
         * @throws ApiException If fail to serialize the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> List retrieved </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call buildCall(final ApiCallback _callback) throws ApiException {
            return listMyTradesCall(currencyPair, limit, page, orderId, _callback);
        }

        /**
         * Execute listMyTrades request
         * @return List&lt;Trade&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> List retrieved </td><td>  -  </td></tr>
         </table>
         */
        public List<Trade> execute() throws ApiException {
            ApiResponse<List<Trade>> localVarResp = listMyTradesWithHttpInfo(currencyPair, limit, page, orderId);
            return localVarResp.getData();
        }

        /**
         * Execute listMyTrades request with HTTP info returned
         * @return ApiResponse&lt;List&lt;Trade&gt;&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> List retrieved </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<List<Trade>> executeWithHttpInfo() throws ApiException {
            return listMyTradesWithHttpInfo(currencyPair, limit, page, orderId);
        }

        /**
         * Execute listMyTrades request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> List retrieved </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<List<Trade>> _callback) throws ApiException {
            return listMyTradesAsync(currencyPair, limit, page, orderId, _callback);
        }
    }

    /**
     * List personal trading history
     * 
     * @param currencyPair Currency pair (required)
     * @return APIlistMyTradesRequest
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> List retrieved </td><td>  -  </td></tr>
     </table>
     */
    public APIlistMyTradesRequest listMyTrades(String currencyPair) {
        return new APIlistMyTradesRequest(currencyPair);
    }

}
