


package com.teachy.coins.gateapi.api;

import com.teachy.coins.gateapi.ApiCallback;
import com.teachy.coins.gateapi.ApiClient;
import com.teachy.coins.gateapi.ApiException;
import com.teachy.coins.gateapi.ApiResponse;
import com.teachy.coins.gateapi.Configuration;
import com.teachy.coins.gateapi.Pair;

import com.google.gson.reflect.TypeToken;


import com.teachy.coins.gateapi.models.Contract;
import com.teachy.coins.gateapi.models.FundingRateRecord;
import com.teachy.coins.gateapi.models.FuturesAccount;
import com.teachy.coins.gateapi.models.FuturesAccountBook;
import com.teachy.coins.gateapi.models.FuturesCandlestick;
import com.teachy.coins.gateapi.models.FuturesLiquidate;
import com.teachy.coins.gateapi.models.FuturesOrder;
import com.teachy.coins.gateapi.models.FuturesOrderBook;
import com.teachy.coins.gateapi.models.FuturesPriceTriggeredOrder;
import com.teachy.coins.gateapi.models.FuturesTicker;
import com.teachy.coins.gateapi.models.FuturesTrade;
import com.teachy.coins.gateapi.models.InsuranceRecord;
import com.teachy.coins.gateapi.models.MyFuturesTrade;
import com.teachy.coins.gateapi.models.Position;
import com.teachy.coins.gateapi.models.PositionClose;
import com.teachy.coins.gateapi.models.TriggerOrderResponse;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FuturesApi {
    private ApiClient localVarApiClient;

    public FuturesApi() {
        this(Configuration.getDefaultApiClient());
    }

    public FuturesApi(ApiClient apiClient) {
        this.localVarApiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return localVarApiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.localVarApiClient = apiClient;
    }

    /**
     * Build call for listFuturesContracts
     * @param settle Settle currency (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> List retrieved </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call listFuturesContractsCall(String settle, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/futures/{settle}/contracts"
            .replaceAll("\\{" + "settle" + "\\}", localVarApiClient.escapeString(settle));

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
    private okhttp3.Call listFuturesContractsValidateBeforeCall(String settle, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'settle' is set
        if (settle == null) {
            throw new ApiException("Missing the required parameter 'settle' when calling listFuturesContracts(Async)");
        }

        okhttp3.Call localVarCall = listFuturesContractsCall(settle, _callback);
        return localVarCall;
    }

    /**
     * List all futures contracts
     * 
     * @param settle Settle currency (required)
     * @return List&lt;Contract&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> List retrieved </td><td>  -  </td></tr>
     </table>
     */
    public List<Contract> listFuturesContracts(String settle) throws ApiException {
        ApiResponse<List<Contract>> localVarResp = listFuturesContractsWithHttpInfo(settle);
        return localVarResp.getData();
    }

    /**
     * List all futures contracts
     * 
     * @param settle Settle currency (required)
     * @return ApiResponse&lt;List&lt;Contract&gt;&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> List retrieved </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<List<Contract>> listFuturesContractsWithHttpInfo(String settle) throws ApiException {
        okhttp3.Call localVarCall = listFuturesContractsValidateBeforeCall(settle, null);
        Type localVarReturnType = new TypeToken<List<Contract>>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * List all futures contracts (asynchronously)
     * 
     * @param settle Settle currency (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> List retrieved </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call listFuturesContractsAsync(String settle, final ApiCallback<List<Contract>> _callback) throws ApiException {
        okhttp3.Call localVarCall = listFuturesContractsValidateBeforeCall(settle, _callback);
        Type localVarReturnType = new TypeToken<List<Contract>>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    /**
     * Build call for getFuturesContract
     * @param settle Settle currency (required)
     * @param contract Futures contract (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Contract information </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call getFuturesContractCall(String settle, String contract, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/futures/{settle}/contracts/{contract}"
            .replaceAll("\\{" + "settle" + "\\}", localVarApiClient.escapeString(settle))
            .replaceAll("\\{" + "contract" + "\\}", localVarApiClient.escapeString(contract));

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
    private okhttp3.Call getFuturesContractValidateBeforeCall(String settle, String contract, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'settle' is set
        if (settle == null) {
            throw new ApiException("Missing the required parameter 'settle' when calling getFuturesContract(Async)");
        }

        // verify the required parameter 'contract' is set
        if (contract == null) {
            throw new ApiException("Missing the required parameter 'contract' when calling getFuturesContract(Async)");
        }

        okhttp3.Call localVarCall = getFuturesContractCall(settle, contract, _callback);
        return localVarCall;
    }

    /**
     * Get a single contract
     * 
     * @param settle Settle currency (required)
     * @param contract Futures contract (required)
     * @return Contract
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Contract information </td><td>  -  </td></tr>
     </table>
     */
    public Contract getFuturesContract(String settle, String contract) throws ApiException {
        ApiResponse<Contract> localVarResp = getFuturesContractWithHttpInfo(settle, contract);
        return localVarResp.getData();
    }

    /**
     * Get a single contract
     * 
     * @param settle Settle currency (required)
     * @param contract Futures contract (required)
     * @return ApiResponse&lt;Contract&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Contract information </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<Contract> getFuturesContractWithHttpInfo(String settle, String contract) throws ApiException {
        okhttp3.Call localVarCall = getFuturesContractValidateBeforeCall(settle, contract, null);
        Type localVarReturnType = new TypeToken<Contract>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Get a single contract (asynchronously)
     * 
     * @param settle Settle currency (required)
     * @param contract Futures contract (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Contract information </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call getFuturesContractAsync(String settle, String contract, final ApiCallback<Contract> _callback) throws ApiException {
        okhttp3.Call localVarCall = getFuturesContractValidateBeforeCall(settle, contract, _callback);
        Type localVarReturnType = new TypeToken<Contract>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    private okhttp3.Call listFuturesOrderBookCall(String settle, String contract, String interval, Integer limit, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/futures/{settle}/order_book"
            .replaceAll("\\{" + "settle" + "\\}", localVarApiClient.escapeString(settle));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (contract != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("contract", contract));
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
    private okhttp3.Call listFuturesOrderBookValidateBeforeCall(String settle, String contract, String interval, Integer limit, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'settle' is set
        if (settle == null) {
            throw new ApiException("Missing the required parameter 'settle' when calling listFuturesOrderBook(Async)");
        }

        // verify the required parameter 'contract' is set
        if (contract == null) {
            throw new ApiException("Missing the required parameter 'contract' when calling listFuturesOrderBook(Async)");
        }

        okhttp3.Call localVarCall = listFuturesOrderBookCall(settle, contract, interval, limit, _callback);
        return localVarCall;
    }


    private ApiResponse<FuturesOrderBook> listFuturesOrderBookWithHttpInfo(String settle, String contract, String interval, Integer limit) throws ApiException {
        okhttp3.Call localVarCall = listFuturesOrderBookValidateBeforeCall(settle, contract, interval, limit, null);
        Type localVarReturnType = new TypeToken<FuturesOrderBook>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call listFuturesOrderBookAsync(String settle, String contract, String interval, Integer limit, final ApiCallback<FuturesOrderBook> _callback) throws ApiException {
        okhttp3.Call localVarCall = listFuturesOrderBookValidateBeforeCall(settle, contract, interval, limit, _callback);
        Type localVarReturnType = new TypeToken<FuturesOrderBook>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class APIlistFuturesOrderBookRequest {
        private final String settle;
        private final String contract;
        private String interval;
        private Integer limit;

        private APIlistFuturesOrderBookRequest(String settle, String contract) {
            this.settle = settle;
            this.contract = contract;
        }

        /**
         * Set interval
         * @param interval Order depth. 0 means no aggregation is applied. default to 0 (optional, default to 0)
         * @return APIlistFuturesOrderBookRequest
         */
        public APIlistFuturesOrderBookRequest interval(String interval) {
            this.interval = interval;
            return this;
        }

        /**
         * Set limit
         * @param limit Maximum number of order depth data in asks or bids (optional, default to 10)
         * @return APIlistFuturesOrderBookRequest
         */
        public APIlistFuturesOrderBookRequest limit(Integer limit) {
            this.limit = limit;
            return this;
        }

        /**
         * Build call for listFuturesOrderBook
         * @param _callback ApiCallback API callback
         * @return Call to execute
         * @throws ApiException If fail to serialize the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> Order book retrieved </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call buildCall(final ApiCallback _callback) throws ApiException {
            return listFuturesOrderBookCall(settle, contract, interval, limit, _callback);
        }

        /**
         * Execute listFuturesOrderBook request
         * @return FuturesOrderBook
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> Order book retrieved </td><td>  -  </td></tr>
         </table>
         */
        public FuturesOrderBook execute() throws ApiException {
            ApiResponse<FuturesOrderBook> localVarResp = listFuturesOrderBookWithHttpInfo(settle, contract, interval, limit);
            return localVarResp.getData();
        }

        /**
         * Execute listFuturesOrderBook request with HTTP info returned
         * @return ApiResponse&lt;FuturesOrderBook&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> Order book retrieved </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<FuturesOrderBook> executeWithHttpInfo() throws ApiException {
            return listFuturesOrderBookWithHttpInfo(settle, contract, interval, limit);
        }

        /**
         * Execute listFuturesOrderBook request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> Order book retrieved </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<FuturesOrderBook> _callback) throws ApiException {
            return listFuturesOrderBookAsync(settle, contract, interval, limit, _callback);
        }
    }

    /**
     * Futures order book
     * Bids will be sorted by price from high to low, while asks sorted reversely
     * @param settle Settle currency (required)
     * @param contract Futures contract (required)
     * @return APIlistFuturesOrderBookRequest
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Order book retrieved </td><td>  -  </td></tr>
     </table>
     */
    public APIlistFuturesOrderBookRequest listFuturesOrderBook(String settle, String contract) {
        return new APIlistFuturesOrderBookRequest(settle, contract);
    }

    private okhttp3.Call listFuturesTradesCall(String settle, String contract, Integer limit, String lastId, Long from, Long to, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/futures/{settle}/trades"
            .replaceAll("\\{" + "settle" + "\\}", localVarApiClient.escapeString(settle));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (contract != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("contract", contract));
        }

        if (limit != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("limit", limit));
        }

        if (lastId != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("last_id", lastId));
        }

        if (from != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("from", from));
        }

        if (to != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("to", to));
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
    private okhttp3.Call listFuturesTradesValidateBeforeCall(String settle, String contract, Integer limit, String lastId, Long from, Long to, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'settle' is set
        if (settle == null) {
            throw new ApiException("Missing the required parameter 'settle' when calling listFuturesTrades(Async)");
        }

        // verify the required parameter 'contract' is set
        if (contract == null) {
            throw new ApiException("Missing the required parameter 'contract' when calling listFuturesTrades(Async)");
        }

        okhttp3.Call localVarCall = listFuturesTradesCall(settle, contract, limit, lastId, from, to, _callback);
        return localVarCall;
    }


    private ApiResponse<List<FuturesTrade>> listFuturesTradesWithHttpInfo(String settle, String contract, Integer limit, String lastId, Long from, Long to) throws ApiException {
        okhttp3.Call localVarCall = listFuturesTradesValidateBeforeCall(settle, contract, limit, lastId, from, to, null);
        Type localVarReturnType = new TypeToken<List<FuturesTrade>>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call listFuturesTradesAsync(String settle, String contract, Integer limit, String lastId, Long from, Long to, final ApiCallback<List<FuturesTrade>> _callback) throws ApiException {
        okhttp3.Call localVarCall = listFuturesTradesValidateBeforeCall(settle, contract, limit, lastId, from, to, _callback);
        Type localVarReturnType = new TypeToken<List<FuturesTrade>>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class APIlistFuturesTradesRequest {
        private final String settle;
        private final String contract;
        private Integer limit;
        private String lastId;
        private Long from;
        private Long to;

        private APIlistFuturesTradesRequest(String settle, String contract) {
            this.settle = settle;
            this.contract = contract;
        }

        /**
         * Set limit
         * @param limit Maximum number of records returned in one list (optional, default to 100)
         * @return APIlistFuturesTradesRequest
         */
        public APIlistFuturesTradesRequest limit(Integer limit) {
            this.limit = limit;
            return this;
        }

        /**
         * Set lastId
         * @param lastId Specify list staring point using the id of last record in previous list-query results  This parameter is deprecated. Use &#x60;from&#x60; and &#x60;to&#x60; instead to limit time range (optional)
         * @return APIlistFuturesTradesRequest
         */
        public APIlistFuturesTradesRequest lastId(String lastId) {
            this.lastId = lastId;
            return this;
        }

        /**
         * Set from
         * @param from Specify starting time in Unix seconds. If not specified, &#x60;to&#x60; and &#x60;limit&#x60; will be used to limit response items. If items between &#x60;from&#x60; and &#x60;to&#x60; are more than &#x60;limit&#x60;, only &#x60;limit&#x60; number will be returned.  (optional)
         * @return APIlistFuturesTradesRequest
         */
        public APIlistFuturesTradesRequest from(Long from) {
            this.from = from;
            return this;
        }

        /**
         * Set to
         * @param to Specify end time in Unix seconds, default to current time (optional)
         * @return APIlistFuturesTradesRequest
         */
        public APIlistFuturesTradesRequest to(Long to) {
            this.to = to;
            return this;
        }

        /**
         * Build call for listFuturesTrades
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
            return listFuturesTradesCall(settle, contract, limit, lastId, from, to, _callback);
        }

        /**
         * Execute listFuturesTrades request
         * @return List&lt;FuturesTrade&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> List retrieved </td><td>  -  </td></tr>
         </table>
         */
        public List<FuturesTrade> execute() throws ApiException {
            ApiResponse<List<FuturesTrade>> localVarResp = listFuturesTradesWithHttpInfo(settle, contract, limit, lastId, from, to);
            return localVarResp.getData();
        }

        /**
         * Execute listFuturesTrades request with HTTP info returned
         * @return ApiResponse&lt;List&lt;FuturesTrade&gt;&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> List retrieved </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<List<FuturesTrade>> executeWithHttpInfo() throws ApiException {
            return listFuturesTradesWithHttpInfo(settle, contract, limit, lastId, from, to);
        }

        /**
         * Execute listFuturesTrades request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> List retrieved </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<List<FuturesTrade>> _callback) throws ApiException {
            return listFuturesTradesAsync(settle, contract, limit, lastId, from, to, _callback);
        }
    }

    /**
     * Futures trading history
     * 
     * @param settle Settle currency (required)
     * @param contract Futures contract (required)
     * @return APIlistFuturesTradesRequest
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> List retrieved </td><td>  -  </td></tr>
     </table>
     */
    public APIlistFuturesTradesRequest listFuturesTrades(String settle, String contract) {
        return new APIlistFuturesTradesRequest(settle, contract);
    }

    private okhttp3.Call listFuturesCandlesticksCall(String settle, String contract, Long from, Long to, Integer limit, String interval, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/futures/{settle}/candlesticks"
            .replaceAll("\\{" + "settle" + "\\}", localVarApiClient.escapeString(settle));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (contract != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("contract", contract));
        }

        if (from != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("from", from));
        }

        if (to != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("to", to));
        }

        if (limit != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("limit", limit));
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
    private okhttp3.Call listFuturesCandlesticksValidateBeforeCall(String settle, String contract, Long from, Long to, Integer limit, String interval, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'settle' is set
        if (settle == null) {
            throw new ApiException("Missing the required parameter 'settle' when calling listFuturesCandlesticks(Async)");
        }

        // verify the required parameter 'contract' is set
        if (contract == null) {
            throw new ApiException("Missing the required parameter 'contract' when calling listFuturesCandlesticks(Async)");
        }

        okhttp3.Call localVarCall = listFuturesCandlesticksCall(settle, contract, from, to, limit, interval, _callback);
        return localVarCall;
    }


    private ApiResponse<List<FuturesCandlestick>> listFuturesCandlesticksWithHttpInfo(String settle, String contract, Long from, Long to, Integer limit, String interval) throws ApiException {
        okhttp3.Call localVarCall = listFuturesCandlesticksValidateBeforeCall(settle, contract, from, to, limit, interval, null);
        Type localVarReturnType = new TypeToken<List<FuturesCandlestick>>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call listFuturesCandlesticksAsync(String settle, String contract, Long from, Long to, Integer limit, String interval, final ApiCallback<List<FuturesCandlestick>> _callback) throws ApiException {
        okhttp3.Call localVarCall = listFuturesCandlesticksValidateBeforeCall(settle, contract, from, to, limit, interval, _callback);
        Type localVarReturnType = new TypeToken<List<FuturesCandlestick>>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class APIlistFuturesCandlesticksRequest {
        private final String settle;
        private final String contract;
        private Long from;
        private Long to;
        private Integer limit;
        private String interval;

        private APIlistFuturesCandlesticksRequest(String settle, String contract) {
            this.settle = settle;
            this.contract = contract;
        }

        /**
         * Set from
         * @param from Start time of candlesticks, formatted in Unix timestamp in seconds. Default to&#x60;to - 100 * interval&#x60; if not specified (optional)
         * @return APIlistFuturesCandlesticksRequest
         */
        public APIlistFuturesCandlesticksRequest from(Long from) {
            this.from = from;
            return this;
        }

        /**
         * Set to
         * @param to End time of candlesticks, formatted in Unix timestamp in seconds. Default to current time (optional)
         * @return APIlistFuturesCandlesticksRequest
         */
        public APIlistFuturesCandlesticksRequest to(Long to) {
            this.to = to;
            return this;
        }

        /**
         * Set limit
         * @param limit Maximum recent data points returned. &#x60;limit&#x60; is conflicted with &#x60;from&#x60; and &#x60;to&#x60;. If either &#x60;from&#x60; or &#x60;to&#x60; is specified, request will be rejected. (optional, default to 100)
         * @return APIlistFuturesCandlesticksRequest
         */
        public APIlistFuturesCandlesticksRequest limit(Integer limit) {
            this.limit = limit;
            return this;
        }

        /**
         * Set interval
         * @param interval Interval time between data points (optional, default to 5m)
         * @return APIlistFuturesCandlesticksRequest
         */
        public APIlistFuturesCandlesticksRequest interval(String interval) {
            this.interval = interval;
            return this;
        }

        /**
         * Build call for listFuturesCandlesticks
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
            return listFuturesCandlesticksCall(settle, contract, from, to, limit, interval, _callback);
        }

        /**
         * Execute listFuturesCandlesticks request
         * @return List&lt;FuturesCandlestick&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> Successfully retrieved </td><td>  -  </td></tr>
         </table>
         */
        public List<FuturesCandlestick> execute() throws ApiException {
            ApiResponse<List<FuturesCandlestick>> localVarResp = listFuturesCandlesticksWithHttpInfo(settle, contract, from, to, limit, interval);
            return localVarResp.getData();
        }

        /**
         * Execute listFuturesCandlesticks request with HTTP info returned
         * @return ApiResponse&lt;List&lt;FuturesCandlestick&gt;&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> Successfully retrieved </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<List<FuturesCandlestick>> executeWithHttpInfo() throws ApiException {
            return listFuturesCandlesticksWithHttpInfo(settle, contract, from, to, limit, interval);
        }

        /**
         * Execute listFuturesCandlesticks request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> Successfully retrieved </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<List<FuturesCandlestick>> _callback) throws ApiException {
            return listFuturesCandlesticksAsync(settle, contract, from, to, limit, interval, _callback);
        }
    }

    /**
     * Get futures candlesticks
     * Return specified contract candlesticks. If prefix &#x60;contract&#x60; with &#x60;mark_&#x60;, the contract&#39;s mark price candlesticks are returned; if prefix with &#x60;index_&#x60;, index price candlesticks will be returned.  Maximum of 2000 points are returned in one query. Be sure not to exceed the limit when specifying &#x60;from&#x60;, &#x60;to&#x60; and &#x60;interval&#x60;
     * @param settle Settle currency (required)
     * @param contract Futures contract (required)
     * @return APIlistFuturesCandlesticksRequest
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Successfully retrieved </td><td>  -  </td></tr>
     </table>
     */
    public APIlistFuturesCandlesticksRequest listFuturesCandlesticks(String settle, String contract) {
        return new APIlistFuturesCandlesticksRequest(settle, contract);
    }

    private okhttp3.Call listFuturesTickersCall(String settle, String contract, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/futures/{settle}/tickers"
            .replaceAll("\\{" + "settle" + "\\}", localVarApiClient.escapeString(settle));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (contract != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("contract", contract));
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
    private okhttp3.Call listFuturesTickersValidateBeforeCall(String settle, String contract, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'settle' is set
        if (settle == null) {
            throw new ApiException("Missing the required parameter 'settle' when calling listFuturesTickers(Async)");
        }

        okhttp3.Call localVarCall = listFuturesTickersCall(settle, contract, _callback);
        return localVarCall;
    }


    private ApiResponse<List<FuturesTicker>> listFuturesTickersWithHttpInfo(String settle, String contract) throws ApiException {
        okhttp3.Call localVarCall = listFuturesTickersValidateBeforeCall(settle, contract, null);
        Type localVarReturnType = new TypeToken<List<FuturesTicker>>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call listFuturesTickersAsync(String settle, String contract, final ApiCallback<List<FuturesTicker>> _callback) throws ApiException {
        okhttp3.Call localVarCall = listFuturesTickersValidateBeforeCall(settle, contract, _callback);
        Type localVarReturnType = new TypeToken<List<FuturesTicker>>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class APIlistFuturesTickersRequest {
        private final String settle;
        private String contract;

        private APIlistFuturesTickersRequest(String settle) {
            this.settle = settle;
        }

        /**
         * Set contract
         * @param contract Futures contract, return related data only if specified (optional)
         * @return APIlistFuturesTickersRequest
         */
        public APIlistFuturesTickersRequest contract(String contract) {
            this.contract = contract;
            return this;
        }

        /**
         * Build call for listFuturesTickers
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
            return listFuturesTickersCall(settle, contract, _callback);
        }

        /**
         * Execute listFuturesTickers request
         * @return List&lt;FuturesTicker&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> Successfully retrieved </td><td>  -  </td></tr>
         </table>
         */
        public List<FuturesTicker> execute() throws ApiException {
            ApiResponse<List<FuturesTicker>> localVarResp = listFuturesTickersWithHttpInfo(settle, contract);
            return localVarResp.getData();
        }

        /**
         * Execute listFuturesTickers request with HTTP info returned
         * @return ApiResponse&lt;List&lt;FuturesTicker&gt;&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> Successfully retrieved </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<List<FuturesTicker>> executeWithHttpInfo() throws ApiException {
            return listFuturesTickersWithHttpInfo(settle, contract);
        }

        /**
         * Execute listFuturesTickers request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> Successfully retrieved </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<List<FuturesTicker>> _callback) throws ApiException {
            return listFuturesTickersAsync(settle, contract, _callback);
        }
    }

    /**
     * List futures tickers
     * 
     * @param settle Settle currency (required)
     * @return APIlistFuturesTickersRequest
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Successfully retrieved </td><td>  -  </td></tr>
     </table>
     */
    public APIlistFuturesTickersRequest listFuturesTickers(String settle) {
        return new APIlistFuturesTickersRequest(settle);
    }

    private okhttp3.Call listFuturesFundingRateHistoryCall(String settle, String contract, Integer limit, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/futures/{settle}/funding_rate"
            .replaceAll("\\{" + "settle" + "\\}", localVarApiClient.escapeString(settle));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (contract != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("contract", contract));
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
    private okhttp3.Call listFuturesFundingRateHistoryValidateBeforeCall(String settle, String contract, Integer limit, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'settle' is set
        if (settle == null) {
            throw new ApiException("Missing the required parameter 'settle' when calling listFuturesFundingRateHistory(Async)");
        }

        // verify the required parameter 'contract' is set
        if (contract == null) {
            throw new ApiException("Missing the required parameter 'contract' when calling listFuturesFundingRateHistory(Async)");
        }

        okhttp3.Call localVarCall = listFuturesFundingRateHistoryCall(settle, contract, limit, _callback);
        return localVarCall;
    }


    private ApiResponse<List<FundingRateRecord>> listFuturesFundingRateHistoryWithHttpInfo(String settle, String contract, Integer limit) throws ApiException {
        okhttp3.Call localVarCall = listFuturesFundingRateHistoryValidateBeforeCall(settle, contract, limit, null);
        Type localVarReturnType = new TypeToken<List<FundingRateRecord>>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call listFuturesFundingRateHistoryAsync(String settle, String contract, Integer limit, final ApiCallback<List<FundingRateRecord>> _callback) throws ApiException {
        okhttp3.Call localVarCall = listFuturesFundingRateHistoryValidateBeforeCall(settle, contract, limit, _callback);
        Type localVarReturnType = new TypeToken<List<FundingRateRecord>>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class APIlistFuturesFundingRateHistoryRequest {
        private final String settle;
        private final String contract;
        private Integer limit;

        private APIlistFuturesFundingRateHistoryRequest(String settle, String contract) {
            this.settle = settle;
            this.contract = contract;
        }

        /**
         * Set limit
         * @param limit Maximum number of records returned in one list (optional, default to 100)
         * @return APIlistFuturesFundingRateHistoryRequest
         */
        public APIlistFuturesFundingRateHistoryRequest limit(Integer limit) {
            this.limit = limit;
            return this;
        }

        /**
         * Build call for listFuturesFundingRateHistory
         * @param _callback ApiCallback API callback
         * @return Call to execute
         * @throws ApiException If fail to serialize the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> History retrieved </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call buildCall(final ApiCallback _callback) throws ApiException {
            return listFuturesFundingRateHistoryCall(settle, contract, limit, _callback);
        }

        /**
         * Execute listFuturesFundingRateHistory request
         * @return List&lt;FundingRateRecord&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> History retrieved </td><td>  -  </td></tr>
         </table>
         */
        public List<FundingRateRecord> execute() throws ApiException {
            ApiResponse<List<FundingRateRecord>> localVarResp = listFuturesFundingRateHistoryWithHttpInfo(settle, contract, limit);
            return localVarResp.getData();
        }

        /**
         * Execute listFuturesFundingRateHistory request with HTTP info returned
         * @return ApiResponse&lt;List&lt;FundingRateRecord&gt;&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> History retrieved </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<List<FundingRateRecord>> executeWithHttpInfo() throws ApiException {
            return listFuturesFundingRateHistoryWithHttpInfo(settle, contract, limit);
        }

        /**
         * Execute listFuturesFundingRateHistory request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> History retrieved </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<List<FundingRateRecord>> _callback) throws ApiException {
            return listFuturesFundingRateHistoryAsync(settle, contract, limit, _callback);
        }
    }

    /**
     * Funding rate history
     * 
     * @param settle Settle currency (required)
     * @param contract Futures contract (required)
     * @return APIlistFuturesFundingRateHistoryRequest
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> History retrieved </td><td>  -  </td></tr>
     </table>
     */
    public APIlistFuturesFundingRateHistoryRequest listFuturesFundingRateHistory(String settle, String contract) {
        return new APIlistFuturesFundingRateHistoryRequest(settle, contract);
    }

    private okhttp3.Call listFuturesInsuranceLedgerCall(String settle, Integer limit, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/futures/{settle}/insurance"
            .replaceAll("\\{" + "settle" + "\\}", localVarApiClient.escapeString(settle));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
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
    private okhttp3.Call listFuturesInsuranceLedgerValidateBeforeCall(String settle, Integer limit, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'settle' is set
        if (settle == null) {
            throw new ApiException("Missing the required parameter 'settle' when calling listFuturesInsuranceLedger(Async)");
        }

        okhttp3.Call localVarCall = listFuturesInsuranceLedgerCall(settle, limit, _callback);
        return localVarCall;
    }


    private ApiResponse<List<InsuranceRecord>> listFuturesInsuranceLedgerWithHttpInfo(String settle, Integer limit) throws ApiException {
        okhttp3.Call localVarCall = listFuturesInsuranceLedgerValidateBeforeCall(settle, limit, null);
        Type localVarReturnType = new TypeToken<List<InsuranceRecord>>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call listFuturesInsuranceLedgerAsync(String settle, Integer limit, final ApiCallback<List<InsuranceRecord>> _callback) throws ApiException {
        okhttp3.Call localVarCall = listFuturesInsuranceLedgerValidateBeforeCall(settle, limit, _callback);
        Type localVarReturnType = new TypeToken<List<InsuranceRecord>>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class APIlistFuturesInsuranceLedgerRequest {
        private final String settle;
        private Integer limit;

        private APIlistFuturesInsuranceLedgerRequest(String settle) {
            this.settle = settle;
        }

        /**
         * Set limit
         * @param limit Maximum number of records returned in one list (optional, default to 100)
         * @return APIlistFuturesInsuranceLedgerRequest
         */
        public APIlistFuturesInsuranceLedgerRequest limit(Integer limit) {
            this.limit = limit;
            return this;
        }

        /**
         * Build call for listFuturesInsuranceLedger
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
            return listFuturesInsuranceLedgerCall(settle, limit, _callback);
        }

        /**
         * Execute listFuturesInsuranceLedger request
         * @return List&lt;InsuranceRecord&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> Successfully retrieved </td><td>  -  </td></tr>
         </table>
         */
        public List<InsuranceRecord> execute() throws ApiException {
            ApiResponse<List<InsuranceRecord>> localVarResp = listFuturesInsuranceLedgerWithHttpInfo(settle, limit);
            return localVarResp.getData();
        }

        /**
         * Execute listFuturesInsuranceLedger request with HTTP info returned
         * @return ApiResponse&lt;List&lt;InsuranceRecord&gt;&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> Successfully retrieved </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<List<InsuranceRecord>> executeWithHttpInfo() throws ApiException {
            return listFuturesInsuranceLedgerWithHttpInfo(settle, limit);
        }

        /**
         * Execute listFuturesInsuranceLedger request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> Successfully retrieved </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<List<InsuranceRecord>> _callback) throws ApiException {
            return listFuturesInsuranceLedgerAsync(settle, limit, _callback);
        }
    }

    /**
     * Futures insurance balance history
     * 
     * @param settle Settle currency (required)
     * @return APIlistFuturesInsuranceLedgerRequest
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Successfully retrieved </td><td>  -  </td></tr>
     </table>
     */
    public APIlistFuturesInsuranceLedgerRequest listFuturesInsuranceLedger(String settle) {
        return new APIlistFuturesInsuranceLedgerRequest(settle);
    }

    /**
     * Build call for listFuturesAccounts
     * @param settle Settle currency (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> List retrieved </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call listFuturesAccountsCall(String settle, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/futures/{settle}/accounts"
            .replaceAll("\\{" + "settle" + "\\}", localVarApiClient.escapeString(settle));

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

        String[] localVarAuthNames = new String[] { "apiv4" };
        return localVarApiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call listFuturesAccountsValidateBeforeCall(String settle, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'settle' is set
        if (settle == null) {
            throw new ApiException("Missing the required parameter 'settle' when calling listFuturesAccounts(Async)");
        }

        okhttp3.Call localVarCall = listFuturesAccountsCall(settle, _callback);
        return localVarCall;
    }

    /**
     * Query futures account
     * 
     * @param settle Settle currency (required)
     * @return FuturesAccount
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> List retrieved </td><td>  -  </td></tr>
     </table>
     */
    public FuturesAccount listFuturesAccounts(String settle) throws ApiException {
        ApiResponse<FuturesAccount> localVarResp = listFuturesAccountsWithHttpInfo(settle);
        return localVarResp.getData();
    }

    /**
     * Query futures account
     * 
     * @param settle Settle currency (required)
     * @return ApiResponse&lt;FuturesAccount&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> List retrieved </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<FuturesAccount> listFuturesAccountsWithHttpInfo(String settle) throws ApiException {
        okhttp3.Call localVarCall = listFuturesAccountsValidateBeforeCall(settle, null);
        Type localVarReturnType = new TypeToken<FuturesAccount>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Query futures account (asynchronously)
     * 
     * @param settle Settle currency (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> List retrieved </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call listFuturesAccountsAsync(String settle, final ApiCallback<FuturesAccount> _callback) throws ApiException {
        okhttp3.Call localVarCall = listFuturesAccountsValidateBeforeCall(settle, _callback);
        Type localVarReturnType = new TypeToken<FuturesAccount>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    private okhttp3.Call listFuturesAccountBookCall(String settle, Integer limit, Long from, Long to, String type, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/futures/{settle}/account_book"
            .replaceAll("\\{" + "settle" + "\\}", localVarApiClient.escapeString(settle));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (limit != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("limit", limit));
        }

        if (from != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("from", from));
        }

        if (to != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("to", to));
        }

        if (type != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("type", type));
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
    private okhttp3.Call listFuturesAccountBookValidateBeforeCall(String settle, Integer limit, Long from, Long to, String type, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'settle' is set
        if (settle == null) {
            throw new ApiException("Missing the required parameter 'settle' when calling listFuturesAccountBook(Async)");
        }

        okhttp3.Call localVarCall = listFuturesAccountBookCall(settle, limit, from, to, type, _callback);
        return localVarCall;
    }


    private ApiResponse<List<FuturesAccountBook>> listFuturesAccountBookWithHttpInfo(String settle, Integer limit, Long from, Long to, String type) throws ApiException {
        okhttp3.Call localVarCall = listFuturesAccountBookValidateBeforeCall(settle, limit, from, to, type, null);
        Type localVarReturnType = new TypeToken<List<FuturesAccountBook>>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call listFuturesAccountBookAsync(String settle, Integer limit, Long from, Long to, String type, final ApiCallback<List<FuturesAccountBook>> _callback) throws ApiException {
        okhttp3.Call localVarCall = listFuturesAccountBookValidateBeforeCall(settle, limit, from, to, type, _callback);
        Type localVarReturnType = new TypeToken<List<FuturesAccountBook>>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class APIlistFuturesAccountBookRequest {
        private final String settle;
        private Integer limit;
        private Long from;
        private Long to;
        private String type;

        private APIlistFuturesAccountBookRequest(String settle) {
            this.settle = settle;
        }

        /**
         * Set limit
         * @param limit Maximum number of records returned in one list (optional, default to 100)
         * @return APIlistFuturesAccountBookRequest
         */
        public APIlistFuturesAccountBookRequest limit(Integer limit) {
            this.limit = limit;
            return this;
        }

        /**
         * Set from
         * @param from Start timestamp (optional)
         * @return APIlistFuturesAccountBookRequest
         */
        public APIlistFuturesAccountBookRequest from(Long from) {
            this.from = from;
            return this;
        }

        /**
         * Set to
         * @param to End timestamp (optional)
         * @return APIlistFuturesAccountBookRequest
         */
        public APIlistFuturesAccountBookRequest to(Long to) {
            this.to = to;
            return this;
        }

        /**
         * Set type
         * @param type Changing Type: - dnw: Deposit &amp; Withdraw - pnl: Profit &amp; Loss by reducing position - fee: Trading fee - refr: Referrer rebate - fund: Funding - point_dnw: POINT Deposit &amp; Withdraw - point_fee: POINT Trading fee - point_refr: POINT Referrer rebate (optional)
         * @return APIlistFuturesAccountBookRequest
         */
        public APIlistFuturesAccountBookRequest type(String type) {
            this.type = type;
            return this;
        }

        /**
         * Build call for listFuturesAccountBook
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
            return listFuturesAccountBookCall(settle, limit, from, to, type, _callback);
        }

        /**
         * Execute listFuturesAccountBook request
         * @return List&lt;FuturesAccountBook&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> List retrieved </td><td>  -  </td></tr>
         </table>
         */
        public List<FuturesAccountBook> execute() throws ApiException {
            ApiResponse<List<FuturesAccountBook>> localVarResp = listFuturesAccountBookWithHttpInfo(settle, limit, from, to, type);
            return localVarResp.getData();
        }

        /**
         * Execute listFuturesAccountBook request with HTTP info returned
         * @return ApiResponse&lt;List&lt;FuturesAccountBook&gt;&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> List retrieved </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<List<FuturesAccountBook>> executeWithHttpInfo() throws ApiException {
            return listFuturesAccountBookWithHttpInfo(settle, limit, from, to, type);
        }

        /**
         * Execute listFuturesAccountBook request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> List retrieved </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<List<FuturesAccountBook>> _callback) throws ApiException {
            return listFuturesAccountBookAsync(settle, limit, from, to, type, _callback);
        }
    }

    /**
     * Query account book
     * 
     * @param settle Settle currency (required)
     * @return APIlistFuturesAccountBookRequest
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> List retrieved </td><td>  -  </td></tr>
     </table>
     */
    public APIlistFuturesAccountBookRequest listFuturesAccountBook(String settle) {
        return new APIlistFuturesAccountBookRequest(settle);
    }

    /**
     * Build call for listPositions
     * @param settle Settle currency (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> List retrieved </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call listPositionsCall(String settle, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/futures/{settle}/positions"
            .replaceAll("\\{" + "settle" + "\\}", localVarApiClient.escapeString(settle));

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

        String[] localVarAuthNames = new String[] { "apiv4" };
        return localVarApiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call listPositionsValidateBeforeCall(String settle, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'settle' is set
        if (settle == null) {
            throw new ApiException("Missing the required parameter 'settle' when calling listPositions(Async)");
        }

        okhttp3.Call localVarCall = listPositionsCall(settle, _callback);
        return localVarCall;
    }

    /**
     * List all positions of a user
     * 
     * @param settle Settle currency (required)
     * @return List&lt;Position&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> List retrieved </td><td>  -  </td></tr>
     </table>
     */
    public List<Position> listPositions(String settle) throws ApiException {
        ApiResponse<List<Position>> localVarResp = listPositionsWithHttpInfo(settle);
        return localVarResp.getData();
    }

    /**
     * List all positions of a user
     * 
     * @param settle Settle currency (required)
     * @return ApiResponse&lt;List&lt;Position&gt;&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> List retrieved </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<List<Position>> listPositionsWithHttpInfo(String settle) throws ApiException {
        okhttp3.Call localVarCall = listPositionsValidateBeforeCall(settle, null);
        Type localVarReturnType = new TypeToken<List<Position>>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * List all positions of a user (asynchronously)
     * 
     * @param settle Settle currency (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> List retrieved </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call listPositionsAsync(String settle, final ApiCallback<List<Position>> _callback) throws ApiException {
        okhttp3.Call localVarCall = listPositionsValidateBeforeCall(settle, _callback);
        Type localVarReturnType = new TypeToken<List<Position>>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    /**
     * Build call for getPosition
     * @param settle Settle currency (required)
     * @param contract Futures contract (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Position information </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call getPositionCall(String settle, String contract, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/futures/{settle}/positions/{contract}"
            .replaceAll("\\{" + "settle" + "\\}", localVarApiClient.escapeString(settle))
            .replaceAll("\\{" + "contract" + "\\}", localVarApiClient.escapeString(contract));

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

        String[] localVarAuthNames = new String[] { "apiv4" };
        return localVarApiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call getPositionValidateBeforeCall(String settle, String contract, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'settle' is set
        if (settle == null) {
            throw new ApiException("Missing the required parameter 'settle' when calling getPosition(Async)");
        }

        // verify the required parameter 'contract' is set
        if (contract == null) {
            throw new ApiException("Missing the required parameter 'contract' when calling getPosition(Async)");
        }

        okhttp3.Call localVarCall = getPositionCall(settle, contract, _callback);
        return localVarCall;
    }

    /**
     * Get single position
     * 
     * @param settle Settle currency (required)
     * @param contract Futures contract (required)
     * @return Position
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Position information </td><td>  -  </td></tr>
     </table>
     */
    public Position getPosition(String settle, String contract) throws ApiException {
        ApiResponse<Position> localVarResp = getPositionWithHttpInfo(settle, contract);
        return localVarResp.getData();
    }

    /**
     * Get single position
     * 
     * @param settle Settle currency (required)
     * @param contract Futures contract (required)
     * @return ApiResponse&lt;Position&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Position information </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<Position> getPositionWithHttpInfo(String settle, String contract) throws ApiException {
        okhttp3.Call localVarCall = getPositionValidateBeforeCall(settle, contract, null);
        Type localVarReturnType = new TypeToken<Position>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Get single position (asynchronously)
     * 
     * @param settle Settle currency (required)
     * @param contract Futures contract (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Position information </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call getPositionAsync(String settle, String contract, final ApiCallback<Position> _callback) throws ApiException {
        okhttp3.Call localVarCall = getPositionValidateBeforeCall(settle, contract, _callback);
        Type localVarReturnType = new TypeToken<Position>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    /**
     * Build call for updatePositionMargin
     * @param settle Settle currency (required)
     * @param contract Futures contract (required)
     * @param change Margin change. Use positive number to increase margin, negative number otherwise. (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Position information </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call updatePositionMarginCall(String settle, String contract, String change, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/futures/{settle}/positions/{contract}/margin"
            .replaceAll("\\{" + "settle" + "\\}", localVarApiClient.escapeString(settle))
            .replaceAll("\\{" + "contract" + "\\}", localVarApiClient.escapeString(contract));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (change != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("change", change));
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
        return localVarApiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call updatePositionMarginValidateBeforeCall(String settle, String contract, String change, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'settle' is set
        if (settle == null) {
            throw new ApiException("Missing the required parameter 'settle' when calling updatePositionMargin(Async)");
        }

        // verify the required parameter 'contract' is set
        if (contract == null) {
            throw new ApiException("Missing the required parameter 'contract' when calling updatePositionMargin(Async)");
        }

        // verify the required parameter 'change' is set
        if (change == null) {
            throw new ApiException("Missing the required parameter 'change' when calling updatePositionMargin(Async)");
        }

        okhttp3.Call localVarCall = updatePositionMarginCall(settle, contract, change, _callback);
        return localVarCall;
    }

    /**
     * Update position margin
     * 
     * @param settle Settle currency (required)
     * @param contract Futures contract (required)
     * @param change Margin change. Use positive number to increase margin, negative number otherwise. (required)
     * @return Position
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Position information </td><td>  -  </td></tr>
     </table>
     */
    public Position updatePositionMargin(String settle, String contract, String change) throws ApiException {
        ApiResponse<Position> localVarResp = updatePositionMarginWithHttpInfo(settle, contract, change);
        return localVarResp.getData();
    }

    /**
     * Update position margin
     * 
     * @param settle Settle currency (required)
     * @param contract Futures contract (required)
     * @param change Margin change. Use positive number to increase margin, negative number otherwise. (required)
     * @return ApiResponse&lt;Position&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Position information </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<Position> updatePositionMarginWithHttpInfo(String settle, String contract, String change) throws ApiException {
        okhttp3.Call localVarCall = updatePositionMarginValidateBeforeCall(settle, contract, change, null);
        Type localVarReturnType = new TypeToken<Position>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Update position margin (asynchronously)
     * 
     * @param settle Settle currency (required)
     * @param contract Futures contract (required)
     * @param change Margin change. Use positive number to increase margin, negative number otherwise. (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Position information </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call updatePositionMarginAsync(String settle, String contract, String change, final ApiCallback<Position> _callback) throws ApiException {
        okhttp3.Call localVarCall = updatePositionMarginValidateBeforeCall(settle, contract, change, _callback);
        Type localVarReturnType = new TypeToken<Position>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    /**
     * Build call for updatePositionLeverage
     * @param settle Settle currency (required)
     * @param contract Futures contract (required)
     * @param leverage New position leverage (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Position information </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call updatePositionLeverageCall(String settle, String contract, String leverage, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/futures/{settle}/positions/{contract}/leverage"
            .replaceAll("\\{" + "settle" + "\\}", localVarApiClient.escapeString(settle))
            .replaceAll("\\{" + "contract" + "\\}", localVarApiClient.escapeString(contract));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (leverage != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("leverage", leverage));
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
        return localVarApiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call updatePositionLeverageValidateBeforeCall(String settle, String contract, String leverage, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'settle' is set
        if (settle == null) {
            throw new ApiException("Missing the required parameter 'settle' when calling updatePositionLeverage(Async)");
        }

        // verify the required parameter 'contract' is set
        if (contract == null) {
            throw new ApiException("Missing the required parameter 'contract' when calling updatePositionLeverage(Async)");
        }

        // verify the required parameter 'leverage' is set
        if (leverage == null) {
            throw new ApiException("Missing the required parameter 'leverage' when calling updatePositionLeverage(Async)");
        }

        okhttp3.Call localVarCall = updatePositionLeverageCall(settle, contract, leverage, _callback);
        return localVarCall;
    }

    /**
     * Update position leverage
     * 
     * @param settle Settle currency (required)
     * @param contract Futures contract (required)
     * @param leverage New position leverage (required)
     * @return Position
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Position information </td><td>  -  </td></tr>
     </table>
     */
    public Position updatePositionLeverage(String settle, String contract, String leverage) throws ApiException {
        ApiResponse<Position> localVarResp = updatePositionLeverageWithHttpInfo(settle, contract, leverage);
        return localVarResp.getData();
    }

    /**
     * Update position leverage
     * 
     * @param settle Settle currency (required)
     * @param contract Futures contract (required)
     * @param leverage New position leverage (required)
     * @return ApiResponse&lt;Position&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Position information </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<Position> updatePositionLeverageWithHttpInfo(String settle, String contract, String leverage) throws ApiException {
        okhttp3.Call localVarCall = updatePositionLeverageValidateBeforeCall(settle, contract, leverage, null);
        Type localVarReturnType = new TypeToken<Position>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Update position leverage (asynchronously)
     * 
     * @param settle Settle currency (required)
     * @param contract Futures contract (required)
     * @param leverage New position leverage (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Position information </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call updatePositionLeverageAsync(String settle, String contract, String leverage, final ApiCallback<Position> _callback) throws ApiException {
        okhttp3.Call localVarCall = updatePositionLeverageValidateBeforeCall(settle, contract, leverage, _callback);
        Type localVarReturnType = new TypeToken<Position>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    /**
     * Build call for updatePositionRiskLimit
     * @param settle Settle currency (required)
     * @param contract Futures contract (required)
     * @param riskLimit New position risk limit (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Position information </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call updatePositionRiskLimitCall(String settle, String contract, String riskLimit, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/futures/{settle}/positions/{contract}/risk_limit"
            .replaceAll("\\{" + "settle" + "\\}", localVarApiClient.escapeString(settle))
            .replaceAll("\\{" + "contract" + "\\}", localVarApiClient.escapeString(contract));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (riskLimit != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("risk_limit", riskLimit));
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
        return localVarApiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call updatePositionRiskLimitValidateBeforeCall(String settle, String contract, String riskLimit, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'settle' is set
        if (settle == null) {
            throw new ApiException("Missing the required parameter 'settle' when calling updatePositionRiskLimit(Async)");
        }

        // verify the required parameter 'contract' is set
        if (contract == null) {
            throw new ApiException("Missing the required parameter 'contract' when calling updatePositionRiskLimit(Async)");
        }

        // verify the required parameter 'riskLimit' is set
        if (riskLimit == null) {
            throw new ApiException("Missing the required parameter 'riskLimit' when calling updatePositionRiskLimit(Async)");
        }

        okhttp3.Call localVarCall = updatePositionRiskLimitCall(settle, contract, riskLimit, _callback);
        return localVarCall;
    }

    /**
     * Update position risk limit
     * 
     * @param settle Settle currency (required)
     * @param contract Futures contract (required)
     * @param riskLimit New position risk limit (required)
     * @return Position
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Position information </td><td>  -  </td></tr>
     </table>
     */
    public Position updatePositionRiskLimit(String settle, String contract, String riskLimit) throws ApiException {
        ApiResponse<Position> localVarResp = updatePositionRiskLimitWithHttpInfo(settle, contract, riskLimit);
        return localVarResp.getData();
    }

    /**
     * Update position risk limit
     * 
     * @param settle Settle currency (required)
     * @param contract Futures contract (required)
     * @param riskLimit New position risk limit (required)
     * @return ApiResponse&lt;Position&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Position information </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<Position> updatePositionRiskLimitWithHttpInfo(String settle, String contract, String riskLimit) throws ApiException {
        okhttp3.Call localVarCall = updatePositionRiskLimitValidateBeforeCall(settle, contract, riskLimit, null);
        Type localVarReturnType = new TypeToken<Position>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Update position risk limit (asynchronously)
     * 
     * @param settle Settle currency (required)
     * @param contract Futures contract (required)
     * @param riskLimit New position risk limit (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Position information </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call updatePositionRiskLimitAsync(String settle, String contract, String riskLimit, final ApiCallback<Position> _callback) throws ApiException {
        okhttp3.Call localVarCall = updatePositionRiskLimitValidateBeforeCall(settle, contract, riskLimit, _callback);
        Type localVarReturnType = new TypeToken<Position>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    private okhttp3.Call listFuturesOrdersCall(String settle, String contract, String status, Integer limit, Integer offset, String lastId, Integer countTotal, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/futures/{settle}/orders"
            .replaceAll("\\{" + "settle" + "\\}", localVarApiClient.escapeString(settle));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (contract != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("contract", contract));
        }

        if (status != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("status", status));
        }

        if (limit != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("limit", limit));
        }

        if (offset != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("offset", offset));
        }

        if (lastId != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("last_id", lastId));
        }

        if (countTotal != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("count_total", countTotal));
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
    private okhttp3.Call listFuturesOrdersValidateBeforeCall(String settle, String contract, String status, Integer limit, Integer offset, String lastId, Integer countTotal, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'settle' is set
        if (settle == null) {
            throw new ApiException("Missing the required parameter 'settle' when calling listFuturesOrders(Async)");
        }

        // verify the required parameter 'contract' is set
        if (contract == null) {
            throw new ApiException("Missing the required parameter 'contract' when calling listFuturesOrders(Async)");
        }

        // verify the required parameter 'status' is set
        if (status == null) {
            throw new ApiException("Missing the required parameter 'status' when calling listFuturesOrders(Async)");
        }

        okhttp3.Call localVarCall = listFuturesOrdersCall(settle, contract, status, limit, offset, lastId, countTotal, _callback);
        return localVarCall;
    }


    private ApiResponse<List<FuturesOrder>> listFuturesOrdersWithHttpInfo(String settle, String contract, String status, Integer limit, Integer offset, String lastId, Integer countTotal) throws ApiException {
        okhttp3.Call localVarCall = listFuturesOrdersValidateBeforeCall(settle, contract, status, limit, offset, lastId, countTotal, null);
        Type localVarReturnType = new TypeToken<List<FuturesOrder>>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call listFuturesOrdersAsync(String settle, String contract, String status, Integer limit, Integer offset, String lastId, Integer countTotal, final ApiCallback<List<FuturesOrder>> _callback) throws ApiException {
        okhttp3.Call localVarCall = listFuturesOrdersValidateBeforeCall(settle, contract, status, limit, offset, lastId, countTotal, _callback);
        Type localVarReturnType = new TypeToken<List<FuturesOrder>>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class APIlistFuturesOrdersRequest {
        private final String settle;
        private final String contract;
        private final String status;
        private Integer limit;
        private Integer offset;
        private String lastId;
        private Integer countTotal;

        private APIlistFuturesOrdersRequest(String settle, String contract, String status) {
            this.settle = settle;
            this.contract = contract;
            this.status = status;
        }

        /**
         * Set limit
         * @param limit Maximum number of records returned in one list (optional, default to 100)
         * @return APIlistFuturesOrdersRequest
         */
        public APIlistFuturesOrdersRequest limit(Integer limit) {
            this.limit = limit;
            return this;
        }

        /**
         * Set offset
         * @param offset List offset, starting from 0 (optional, default to 0)
         * @return APIlistFuturesOrdersRequest
         */
        public APIlistFuturesOrdersRequest offset(Integer offset) {
            this.offset = offset;
            return this;
        }

        /**
         * Set lastId
         * @param lastId Specify list staring point using the &#x60;id&#x60; of last record in previous list-query results (optional)
         * @return APIlistFuturesOrdersRequest
         */
        public APIlistFuturesOrdersRequest lastId(String lastId) {
            this.lastId = lastId;
            return this;
        }

        /**
         * Set countTotal
         * @param countTotal Whether to return total number matched. Default to 0(no return) (optional, default to 0)
         * @return APIlistFuturesOrdersRequest
         */
        public APIlistFuturesOrdersRequest countTotal(Integer countTotal) {
            this.countTotal = countTotal;
            return this;
        }

        /**
         * Build call for listFuturesOrders
         * @param _callback ApiCallback API callback
         * @return Call to execute
         * @throws ApiException If fail to serialize the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> List retrieved </td><td>  * X-Pagination-Limit - Request limit specified <br>  * X-Pagination-Offset - Request offset specified <br>  * X-Pagination-Total - Total number matched. Only returned on &#x60;count_total&#x60; set to 1 <br>  </td></tr>
         </table>
         */
        public okhttp3.Call buildCall(final ApiCallback _callback) throws ApiException {
            return listFuturesOrdersCall(settle, contract, status, limit, offset, lastId, countTotal, _callback);
        }

        /**
         * Execute listFuturesOrders request
         * @return List&lt;FuturesOrder&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> List retrieved </td><td>  * X-Pagination-Limit - Request limit specified <br>  * X-Pagination-Offset - Request offset specified <br>  * X-Pagination-Total - Total number matched. Only returned on &#x60;count_total&#x60; set to 1 <br>  </td></tr>
         </table>
         */
        public List<FuturesOrder> execute() throws ApiException {
            ApiResponse<List<FuturesOrder>> localVarResp = listFuturesOrdersWithHttpInfo(settle, contract, status, limit, offset, lastId, countTotal);
            return localVarResp.getData();
        }

        /**
         * Execute listFuturesOrders request with HTTP info returned
         * @return ApiResponse&lt;List&lt;FuturesOrder&gt;&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> List retrieved </td><td>  * X-Pagination-Limit - Request limit specified <br>  * X-Pagination-Offset - Request offset specified <br>  * X-Pagination-Total - Total number matched. Only returned on &#x60;count_total&#x60; set to 1 <br>  </td></tr>
         </table>
         */
        public ApiResponse<List<FuturesOrder>> executeWithHttpInfo() throws ApiException {
            return listFuturesOrdersWithHttpInfo(settle, contract, status, limit, offset, lastId, countTotal);
        }

        /**
         * Execute listFuturesOrders request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> List retrieved </td><td>  * X-Pagination-Limit - Request limit specified <br>  * X-Pagination-Offset - Request offset specified <br>  * X-Pagination-Total - Total number matched. Only returned on &#x60;count_total&#x60; set to 1 <br>  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<List<FuturesOrder>> _callback) throws ApiException {
            return listFuturesOrdersAsync(settle, contract, status, limit, offset, lastId, countTotal, _callback);
        }
    }

    /**
     * List futures orders
     * Zero-fill order cannot be retrieved 60 seconds after cancellation
     * @param settle Settle currency (required)
     * @param contract Futures contract (required)
     * @param status List orders based on status (required)
     * @return APIlistFuturesOrdersRequest
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> List retrieved </td><td>  * X-Pagination-Limit - Request limit specified <br>  * X-Pagination-Offset - Request offset specified <br>  * X-Pagination-Total - Total number matched. Only returned on &#x60;count_total&#x60; set to 1 <br>  </td></tr>
     </table>
     */
    public APIlistFuturesOrdersRequest listFuturesOrders(String settle, String contract, String status) {
        return new APIlistFuturesOrdersRequest(settle, contract, status);
    }

    /**
     * Build call for createFuturesOrder
     * @param settle Settle currency (required)
     * @param futuresOrder  (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 201 </td><td> Order details </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call createFuturesOrderCall(String settle, FuturesOrder futuresOrder, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = futuresOrder;

        // create path and map variables
        String localVarPath = "/futures/{settle}/orders"
            .replaceAll("\\{" + "settle" + "\\}", localVarApiClient.escapeString(settle));

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
    private okhttp3.Call createFuturesOrderValidateBeforeCall(String settle, FuturesOrder futuresOrder, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'settle' is set
        if (settle == null) {
            throw new ApiException("Missing the required parameter 'settle' when calling createFuturesOrder(Async)");
        }

        // verify the required parameter 'futuresOrder' is set
        if (futuresOrder == null) {
            throw new ApiException("Missing the required parameter 'futuresOrder' when calling createFuturesOrder(Async)");
        }

        okhttp3.Call localVarCall = createFuturesOrderCall(settle, futuresOrder, _callback);
        return localVarCall;
    }

    /**
     * Create a futures order
     * Zero-fill order cannot be retrieved 60 seconds after cancellation
     * @param settle Settle currency (required)
     * @param futuresOrder  (required)
     * @return FuturesOrder
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 201 </td><td> Order details </td><td>  -  </td></tr>
     </table>
     */
    public FuturesOrder createFuturesOrder(String settle, FuturesOrder futuresOrder) throws ApiException {
        ApiResponse<FuturesOrder> localVarResp = createFuturesOrderWithHttpInfo(settle, futuresOrder);
        return localVarResp.getData();
    }

    /**
     * Create a futures order
     * Zero-fill order cannot be retrieved 60 seconds after cancellation
     * @param settle Settle currency (required)
     * @param futuresOrder  (required)
     * @return ApiResponse&lt;FuturesOrder&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 201 </td><td> Order details </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<FuturesOrder> createFuturesOrderWithHttpInfo(String settle, FuturesOrder futuresOrder) throws ApiException {
        okhttp3.Call localVarCall = createFuturesOrderValidateBeforeCall(settle, futuresOrder, null);
        Type localVarReturnType = new TypeToken<FuturesOrder>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Create a futures order (asynchronously)
     * Zero-fill order cannot be retrieved 60 seconds after cancellation
     * @param settle Settle currency (required)
     * @param futuresOrder  (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 201 </td><td> Order details </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call createFuturesOrderAsync(String settle, FuturesOrder futuresOrder, final ApiCallback<FuturesOrder> _callback) throws ApiException {
        okhttp3.Call localVarCall = createFuturesOrderValidateBeforeCall(settle, futuresOrder, _callback);
        Type localVarReturnType = new TypeToken<FuturesOrder>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    /**
     * Build call for cancelFuturesOrders
     * @param settle Settle currency (required)
     * @param contract Futures contract (required)
     * @param side All bids or asks. Both included in not specified (optional)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> All orders matched cancelled </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call cancelFuturesOrdersCall(String settle, String contract, String side, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/futures/{settle}/orders"
            .replaceAll("\\{" + "settle" + "\\}", localVarApiClient.escapeString(settle));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (contract != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("contract", contract));
        }

        if (side != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("side", side));
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
    private okhttp3.Call cancelFuturesOrdersValidateBeforeCall(String settle, String contract, String side, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'settle' is set
        if (settle == null) {
            throw new ApiException("Missing the required parameter 'settle' when calling cancelFuturesOrders(Async)");
        }

        // verify the required parameter 'contract' is set
        if (contract == null) {
            throw new ApiException("Missing the required parameter 'contract' when calling cancelFuturesOrders(Async)");
        }

        okhttp3.Call localVarCall = cancelFuturesOrdersCall(settle, contract, side, _callback);
        return localVarCall;
    }

    /**
     * Cancel all &#x60;open&#x60; orders matched
     * Zero-fill order cannot be retrieved 60 seconds after cancellation
     * @param settle Settle currency (required)
     * @param contract Futures contract (required)
     * @param side All bids or asks. Both included in not specified (optional)
     * @return List&lt;FuturesOrder&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> All orders matched cancelled </td><td>  -  </td></tr>
     </table>
     */
    public List<FuturesOrder> cancelFuturesOrders(String settle, String contract, String side) throws ApiException {
        ApiResponse<List<FuturesOrder>> localVarResp = cancelFuturesOrdersWithHttpInfo(settle, contract, side);
        return localVarResp.getData();
    }

    /**
     * Cancel all &#x60;open&#x60; orders matched
     * Zero-fill order cannot be retrieved 60 seconds after cancellation
     * @param settle Settle currency (required)
     * @param contract Futures contract (required)
     * @param side All bids or asks. Both included in not specified (optional)
     * @return ApiResponse&lt;List&lt;FuturesOrder&gt;&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> All orders matched cancelled </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<List<FuturesOrder>> cancelFuturesOrdersWithHttpInfo(String settle, String contract, String side) throws ApiException {
        okhttp3.Call localVarCall = cancelFuturesOrdersValidateBeforeCall(settle, contract, side, null);
        Type localVarReturnType = new TypeToken<List<FuturesOrder>>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Cancel all &#x60;open&#x60; orders matched (asynchronously)
     * Zero-fill order cannot be retrieved 60 seconds after cancellation
     * @param settle Settle currency (required)
     * @param contract Futures contract (required)
     * @param side All bids or asks. Both included in not specified (optional)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> All orders matched cancelled </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call cancelFuturesOrdersAsync(String settle, String contract, String side, final ApiCallback<List<FuturesOrder>> _callback) throws ApiException {
        okhttp3.Call localVarCall = cancelFuturesOrdersValidateBeforeCall(settle, contract, side, _callback);
        Type localVarReturnType = new TypeToken<List<FuturesOrder>>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    /**
     * Build call for getFuturesOrder
     * @param settle Settle currency (required)
     * @param orderId ID returned on order successfully being created (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Order details </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call getFuturesOrderCall(String settle, String orderId, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/futures/{settle}/orders/{order_id}"
            .replaceAll("\\{" + "settle" + "\\}", localVarApiClient.escapeString(settle))
            .replaceAll("\\{" + "order_id" + "\\}", localVarApiClient.escapeString(orderId));

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

        String[] localVarAuthNames = new String[] { "apiv4" };
        return localVarApiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call getFuturesOrderValidateBeforeCall(String settle, String orderId, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'settle' is set
        if (settle == null) {
            throw new ApiException("Missing the required parameter 'settle' when calling getFuturesOrder(Async)");
        }

        // verify the required parameter 'orderId' is set
        if (orderId == null) {
            throw new ApiException("Missing the required parameter 'orderId' when calling getFuturesOrder(Async)");
        }

        okhttp3.Call localVarCall = getFuturesOrderCall(settle, orderId, _callback);
        return localVarCall;
    }

    /**
     * Get a single order
     * Zero-fill order cannot be retrieved 60 seconds after cancellation
     * @param settle Settle currency (required)
     * @param orderId ID returned on order successfully being created (required)
     * @return FuturesOrder
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Order details </td><td>  -  </td></tr>
     </table>
     */
    public FuturesOrder getFuturesOrder(String settle, String orderId) throws ApiException {
        ApiResponse<FuturesOrder> localVarResp = getFuturesOrderWithHttpInfo(settle, orderId);
        return localVarResp.getData();
    }

    /**
     * Get a single order
     * Zero-fill order cannot be retrieved 60 seconds after cancellation
     * @param settle Settle currency (required)
     * @param orderId ID returned on order successfully being created (required)
     * @return ApiResponse&lt;FuturesOrder&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Order details </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<FuturesOrder> getFuturesOrderWithHttpInfo(String settle, String orderId) throws ApiException {
        okhttp3.Call localVarCall = getFuturesOrderValidateBeforeCall(settle, orderId, null);
        Type localVarReturnType = new TypeToken<FuturesOrder>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Get a single order (asynchronously)
     * Zero-fill order cannot be retrieved 60 seconds after cancellation
     * @param settle Settle currency (required)
     * @param orderId ID returned on order successfully being created (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Order details </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call getFuturesOrderAsync(String settle, String orderId, final ApiCallback<FuturesOrder> _callback) throws ApiException {
        okhttp3.Call localVarCall = getFuturesOrderValidateBeforeCall(settle, orderId, _callback);
        Type localVarReturnType = new TypeToken<FuturesOrder>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    /**
     * Build call for cancelFuturesOrder
     * @param settle Settle currency (required)
     * @param orderId ID returned on order successfully being created (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Order details </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call cancelFuturesOrderCall(String settle, String orderId, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/futures/{settle}/orders/{order_id}"
            .replaceAll("\\{" + "settle" + "\\}", localVarApiClient.escapeString(settle))
            .replaceAll("\\{" + "order_id" + "\\}", localVarApiClient.escapeString(orderId));

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

        String[] localVarAuthNames = new String[] { "apiv4" };
        return localVarApiClient.buildCall(localVarPath, "DELETE", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call cancelFuturesOrderValidateBeforeCall(String settle, String orderId, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'settle' is set
        if (settle == null) {
            throw new ApiException("Missing the required parameter 'settle' when calling cancelFuturesOrder(Async)");
        }

        // verify the required parameter 'orderId' is set
        if (orderId == null) {
            throw new ApiException("Missing the required parameter 'orderId' when calling cancelFuturesOrder(Async)");
        }

        okhttp3.Call localVarCall = cancelFuturesOrderCall(settle, orderId, _callback);
        return localVarCall;
    }

    /**
     * Cancel a single order
     * 
     * @param settle Settle currency (required)
     * @param orderId ID returned on order successfully being created (required)
     * @return FuturesOrder
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Order details </td><td>  -  </td></tr>
     </table>
     */
    public FuturesOrder cancelFuturesOrder(String settle, String orderId) throws ApiException {
        ApiResponse<FuturesOrder> localVarResp = cancelFuturesOrderWithHttpInfo(settle, orderId);
        return localVarResp.getData();
    }

    /**
     * Cancel a single order
     * 
     * @param settle Settle currency (required)
     * @param orderId ID returned on order successfully being created (required)
     * @return ApiResponse&lt;FuturesOrder&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Order details </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<FuturesOrder> cancelFuturesOrderWithHttpInfo(String settle, String orderId) throws ApiException {
        okhttp3.Call localVarCall = cancelFuturesOrderValidateBeforeCall(settle, orderId, null);
        Type localVarReturnType = new TypeToken<FuturesOrder>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Cancel a single order (asynchronously)
     * 
     * @param settle Settle currency (required)
     * @param orderId ID returned on order successfully being created (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Order details </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call cancelFuturesOrderAsync(String settle, String orderId, final ApiCallback<FuturesOrder> _callback) throws ApiException {
        okhttp3.Call localVarCall = cancelFuturesOrderValidateBeforeCall(settle, orderId, _callback);
        Type localVarReturnType = new TypeToken<FuturesOrder>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    private okhttp3.Call getMyTradesCall(String settle, String contract, Long order, Integer limit, Integer offset, String lastId, Integer countTotal, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/futures/{settle}/my_trades"
            .replaceAll("\\{" + "settle" + "\\}", localVarApiClient.escapeString(settle));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (contract != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("contract", contract));
        }

        if (order != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("order", order));
        }

        if (limit != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("limit", limit));
        }

        if (offset != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("offset", offset));
        }

        if (lastId != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("last_id", lastId));
        }

        if (countTotal != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("count_total", countTotal));
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
    private okhttp3.Call getMyTradesValidateBeforeCall(String settle, String contract, Long order, Integer limit, Integer offset, String lastId, Integer countTotal, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'settle' is set
        if (settle == null) {
            throw new ApiException("Missing the required parameter 'settle' when calling getMyTrades(Async)");
        }

        okhttp3.Call localVarCall = getMyTradesCall(settle, contract, order, limit, offset, lastId, countTotal, _callback);
        return localVarCall;
    }


    private ApiResponse<List<MyFuturesTrade>> getMyTradesWithHttpInfo(String settle, String contract, Long order, Integer limit, Integer offset, String lastId, Integer countTotal) throws ApiException {
        okhttp3.Call localVarCall = getMyTradesValidateBeforeCall(settle, contract, order, limit, offset, lastId, countTotal, null);
        Type localVarReturnType = new TypeToken<List<MyFuturesTrade>>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call getMyTradesAsync(String settle, String contract, Long order, Integer limit, Integer offset, String lastId, Integer countTotal, final ApiCallback<List<MyFuturesTrade>> _callback) throws ApiException {
        okhttp3.Call localVarCall = getMyTradesValidateBeforeCall(settle, contract, order, limit, offset, lastId, countTotal, _callback);
        Type localVarReturnType = new TypeToken<List<MyFuturesTrade>>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class APIgetMyTradesRequest {
        private final String settle;
        private String contract;
        private Long order;
        private Integer limit;
        private Integer offset;
        private String lastId;
        private Integer countTotal;

        private APIgetMyTradesRequest(String settle) {
            this.settle = settle;
        }

        /**
         * Set contract
         * @param contract Futures contract, return related data only if specified (optional)
         * @return APIgetMyTradesRequest
         */
        public APIgetMyTradesRequest contract(String contract) {
            this.contract = contract;
            return this;
        }

        /**
         * Set order
         * @param order Futures order ID, return related data only if specified (optional)
         * @return APIgetMyTradesRequest
         */
        public APIgetMyTradesRequest order(Long order) {
            this.order = order;
            return this;
        }

        /**
         * Set limit
         * @param limit Maximum number of records returned in one list (optional, default to 100)
         * @return APIgetMyTradesRequest
         */
        public APIgetMyTradesRequest limit(Integer limit) {
            this.limit = limit;
            return this;
        }

        /**
         * Set offset
         * @param offset List offset, starting from 0 (optional, default to 0)
         * @return APIgetMyTradesRequest
         */
        public APIgetMyTradesRequest offset(Integer offset) {
            this.offset = offset;
            return this;
        }

        /**
         * Set lastId
         * @param lastId Specify list staring point using the &#x60;id&#x60; of last record in previous list-query results (optional)
         * @return APIgetMyTradesRequest
         */
        public APIgetMyTradesRequest lastId(String lastId) {
            this.lastId = lastId;
            return this;
        }

        /**
         * Set countTotal
         * @param countTotal Whether to return total number matched. Default to 0(no return) (optional, default to 0)
         * @return APIgetMyTradesRequest
         */
        public APIgetMyTradesRequest countTotal(Integer countTotal) {
            this.countTotal = countTotal;
            return this;
        }

        /**
         * Build call for getMyTrades
         * @param _callback ApiCallback API callback
         * @return Call to execute
         * @throws ApiException If fail to serialize the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> List retrieved </td><td>  * X-Pagination-Limit - Request limit specified <br>  * X-Pagination-Offset - Request offset specified <br>  * X-Pagination-Total - Total number matched. Only returned on &#x60;count_total&#x60; set to 1 <br>  </td></tr>
         </table>
         */
        public okhttp3.Call buildCall(final ApiCallback _callback) throws ApiException {
            return getMyTradesCall(settle, contract, order, limit, offset, lastId, countTotal, _callback);
        }

        /**
         * Execute getMyTrades request
         * @return List&lt;MyFuturesTrade&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> List retrieved </td><td>  * X-Pagination-Limit - Request limit specified <br>  * X-Pagination-Offset - Request offset specified <br>  * X-Pagination-Total - Total number matched. Only returned on &#x60;count_total&#x60; set to 1 <br>  </td></tr>
         </table>
         */
        public List<MyFuturesTrade> execute() throws ApiException {
            ApiResponse<List<MyFuturesTrade>> localVarResp = getMyTradesWithHttpInfo(settle, contract, order, limit, offset, lastId, countTotal);
            return localVarResp.getData();
        }

        /**
         * Execute getMyTrades request with HTTP info returned
         * @return ApiResponse&lt;List&lt;MyFuturesTrade&gt;&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> List retrieved </td><td>  * X-Pagination-Limit - Request limit specified <br>  * X-Pagination-Offset - Request offset specified <br>  * X-Pagination-Total - Total number matched. Only returned on &#x60;count_total&#x60; set to 1 <br>  </td></tr>
         </table>
         */
        public ApiResponse<List<MyFuturesTrade>> executeWithHttpInfo() throws ApiException {
            return getMyTradesWithHttpInfo(settle, contract, order, limit, offset, lastId, countTotal);
        }

        /**
         * Execute getMyTrades request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> List retrieved </td><td>  * X-Pagination-Limit - Request limit specified <br>  * X-Pagination-Offset - Request offset specified <br>  * X-Pagination-Total - Total number matched. Only returned on &#x60;count_total&#x60; set to 1 <br>  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<List<MyFuturesTrade>> _callback) throws ApiException {
            return getMyTradesAsync(settle, contract, order, limit, offset, lastId, countTotal, _callback);
        }
    }

    /**
     * List personal trading history
     * 
     * @param settle Settle currency (required)
     * @return APIgetMyTradesRequest
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> List retrieved </td><td>  * X-Pagination-Limit - Request limit specified <br>  * X-Pagination-Offset - Request offset specified <br>  * X-Pagination-Total - Total number matched. Only returned on &#x60;count_total&#x60; set to 1 <br>  </td></tr>
     </table>
     */
    public APIgetMyTradesRequest getMyTrades(String settle) {
        return new APIgetMyTradesRequest(settle);
    }

    private okhttp3.Call listPositionCloseCall(String settle, String contract, Integer limit, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/futures/{settle}/position_close"
            .replaceAll("\\{" + "settle" + "\\}", localVarApiClient.escapeString(settle));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (contract != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("contract", contract));
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
    private okhttp3.Call listPositionCloseValidateBeforeCall(String settle, String contract, Integer limit, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'settle' is set
        if (settle == null) {
            throw new ApiException("Missing the required parameter 'settle' when calling listPositionClose(Async)");
        }

        okhttp3.Call localVarCall = listPositionCloseCall(settle, contract, limit, _callback);
        return localVarCall;
    }


    private ApiResponse<List<PositionClose>> listPositionCloseWithHttpInfo(String settle, String contract, Integer limit) throws ApiException {
        okhttp3.Call localVarCall = listPositionCloseValidateBeforeCall(settle, contract, limit, null);
        Type localVarReturnType = new TypeToken<List<PositionClose>>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call listPositionCloseAsync(String settle, String contract, Integer limit, final ApiCallback<List<PositionClose>> _callback) throws ApiException {
        okhttp3.Call localVarCall = listPositionCloseValidateBeforeCall(settle, contract, limit, _callback);
        Type localVarReturnType = new TypeToken<List<PositionClose>>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class APIlistPositionCloseRequest {
        private final String settle;
        private String contract;
        private Integer limit;

        private APIlistPositionCloseRequest(String settle) {
            this.settle = settle;
        }

        /**
         * Set contract
         * @param contract Futures contract, return related data only if specified (optional)
         * @return APIlistPositionCloseRequest
         */
        public APIlistPositionCloseRequest contract(String contract) {
            this.contract = contract;
            return this;
        }

        /**
         * Set limit
         * @param limit Maximum number of records returned in one list (optional, default to 100)
         * @return APIlistPositionCloseRequest
         */
        public APIlistPositionCloseRequest limit(Integer limit) {
            this.limit = limit;
            return this;
        }

        /**
         * Build call for listPositionClose
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
            return listPositionCloseCall(settle, contract, limit, _callback);
        }

        /**
         * Execute listPositionClose request
         * @return List&lt;PositionClose&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> List retrieved </td><td>  -  </td></tr>
         </table>
         */
        public List<PositionClose> execute() throws ApiException {
            ApiResponse<List<PositionClose>> localVarResp = listPositionCloseWithHttpInfo(settle, contract, limit);
            return localVarResp.getData();
        }

        /**
         * Execute listPositionClose request with HTTP info returned
         * @return ApiResponse&lt;List&lt;PositionClose&gt;&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> List retrieved </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<List<PositionClose>> executeWithHttpInfo() throws ApiException {
            return listPositionCloseWithHttpInfo(settle, contract, limit);
        }

        /**
         * Execute listPositionClose request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> List retrieved </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<List<PositionClose>> _callback) throws ApiException {
            return listPositionCloseAsync(settle, contract, limit, _callback);
        }
    }

    /**
     * List position close history
     * 
     * @param settle Settle currency (required)
     * @return APIlistPositionCloseRequest
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> List retrieved </td><td>  -  </td></tr>
     </table>
     */
    public APIlistPositionCloseRequest listPositionClose(String settle) {
        return new APIlistPositionCloseRequest(settle);
    }

    private okhttp3.Call listLiquidatesCall(String settle, String contract, Integer limit, Integer at, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/futures/{settle}/liquidates"
            .replaceAll("\\{" + "settle" + "\\}", localVarApiClient.escapeString(settle));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (contract != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("contract", contract));
        }

        if (limit != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("limit", limit));
        }

        if (at != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("at", at));
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
    private okhttp3.Call listLiquidatesValidateBeforeCall(String settle, String contract, Integer limit, Integer at, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'settle' is set
        if (settle == null) {
            throw new ApiException("Missing the required parameter 'settle' when calling listLiquidates(Async)");
        }

        okhttp3.Call localVarCall = listLiquidatesCall(settle, contract, limit, at, _callback);
        return localVarCall;
    }


    private ApiResponse<List<FuturesLiquidate>> listLiquidatesWithHttpInfo(String settle, String contract, Integer limit, Integer at) throws ApiException {
        okhttp3.Call localVarCall = listLiquidatesValidateBeforeCall(settle, contract, limit, at, null);
        Type localVarReturnType = new TypeToken<List<FuturesLiquidate>>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call listLiquidatesAsync(String settle, String contract, Integer limit, Integer at, final ApiCallback<List<FuturesLiquidate>> _callback) throws ApiException {
        okhttp3.Call localVarCall = listLiquidatesValidateBeforeCall(settle, contract, limit, at, _callback);
        Type localVarReturnType = new TypeToken<List<FuturesLiquidate>>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class APIlistLiquidatesRequest {
        private final String settle;
        private String contract;
        private Integer limit;
        private Integer at;

        private APIlistLiquidatesRequest(String settle) {
            this.settle = settle;
        }

        /**
         * Set contract
         * @param contract Futures contract, return related data only if specified (optional)
         * @return APIlistLiquidatesRequest
         */
        public APIlistLiquidatesRequest contract(String contract) {
            this.contract = contract;
            return this;
        }

        /**
         * Set limit
         * @param limit Maximum number of records returned in one list (optional, default to 100)
         * @return APIlistLiquidatesRequest
         */
        public APIlistLiquidatesRequest limit(Integer limit) {
            this.limit = limit;
            return this;
        }

        /**
         * Set at
         * @param at Specify a liquidation timestamp (optional, default to 0)
         * @return APIlistLiquidatesRequest
         */
        public APIlistLiquidatesRequest at(Integer at) {
            this.at = at;
            return this;
        }

        /**
         * Build call for listLiquidates
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
            return listLiquidatesCall(settle, contract, limit, at, _callback);
        }

        /**
         * Execute listLiquidates request
         * @return List&lt;FuturesLiquidate&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> List retrieved </td><td>  -  </td></tr>
         </table>
         */
        public List<FuturesLiquidate> execute() throws ApiException {
            ApiResponse<List<FuturesLiquidate>> localVarResp = listLiquidatesWithHttpInfo(settle, contract, limit, at);
            return localVarResp.getData();
        }

        /**
         * Execute listLiquidates request with HTTP info returned
         * @return ApiResponse&lt;List&lt;FuturesLiquidate&gt;&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> List retrieved </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<List<FuturesLiquidate>> executeWithHttpInfo() throws ApiException {
            return listLiquidatesWithHttpInfo(settle, contract, limit, at);
        }

        /**
         * Execute listLiquidates request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> List retrieved </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<List<FuturesLiquidate>> _callback) throws ApiException {
            return listLiquidatesAsync(settle, contract, limit, at, _callback);
        }
    }

    /**
     * List liquidation history
     * 
     * @param settle Settle currency (required)
     * @return APIlistLiquidatesRequest
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> List retrieved </td><td>  -  </td></tr>
     </table>
     */
    public APIlistLiquidatesRequest listLiquidates(String settle) {
        return new APIlistLiquidatesRequest(settle);
    }

    private okhttp3.Call listPriceTriggeredOrdersCall(String settle, String status, String contract, Integer limit, Integer offset, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/futures/{settle}/price_orders"
            .replaceAll("\\{" + "settle" + "\\}", localVarApiClient.escapeString(settle));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (status != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("status", status));
        }

        if (contract != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("contract", contract));
        }

        if (limit != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("limit", limit));
        }

        if (offset != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("offset", offset));
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
    private okhttp3.Call listPriceTriggeredOrdersValidateBeforeCall(String settle, String status, String contract, Integer limit, Integer offset, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'settle' is set
        if (settle == null) {
            throw new ApiException("Missing the required parameter 'settle' when calling listPriceTriggeredOrders(Async)");
        }

        // verify the required parameter 'status' is set
        if (status == null) {
            throw new ApiException("Missing the required parameter 'status' when calling listPriceTriggeredOrders(Async)");
        }

        okhttp3.Call localVarCall = listPriceTriggeredOrdersCall(settle, status, contract, limit, offset, _callback);
        return localVarCall;
    }


    private ApiResponse<List<FuturesPriceTriggeredOrder>> listPriceTriggeredOrdersWithHttpInfo(String settle, String status, String contract, Integer limit, Integer offset) throws ApiException {
        okhttp3.Call localVarCall = listPriceTriggeredOrdersValidateBeforeCall(settle, status, contract, limit, offset, null);
        Type localVarReturnType = new TypeToken<List<FuturesPriceTriggeredOrder>>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call listPriceTriggeredOrdersAsync(String settle, String status, String contract, Integer limit, Integer offset, final ApiCallback<List<FuturesPriceTriggeredOrder>> _callback) throws ApiException {
        okhttp3.Call localVarCall = listPriceTriggeredOrdersValidateBeforeCall(settle, status, contract, limit, offset, _callback);
        Type localVarReturnType = new TypeToken<List<FuturesPriceTriggeredOrder>>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class APIlistPriceTriggeredOrdersRequest {
        private final String settle;
        private final String status;
        private String contract;
        private Integer limit;
        private Integer offset;

        private APIlistPriceTriggeredOrdersRequest(String settle, String status) {
            this.settle = settle;
            this.status = status;
        }

        /**
         * Set contract
         * @param contract Futures contract, return related data only if specified (optional)
         * @return APIlistPriceTriggeredOrdersRequest
         */
        public APIlistPriceTriggeredOrdersRequest contract(String contract) {
            this.contract = contract;
            return this;
        }

        /**
         * Set limit
         * @param limit Maximum number of records returned in one list (optional, default to 100)
         * @return APIlistPriceTriggeredOrdersRequest
         */
        public APIlistPriceTriggeredOrdersRequest limit(Integer limit) {
            this.limit = limit;
            return this;
        }

        /**
         * Set offset
         * @param offset List offset, starting from 0 (optional, default to 0)
         * @return APIlistPriceTriggeredOrdersRequest
         */
        public APIlistPriceTriggeredOrdersRequest offset(Integer offset) {
            this.offset = offset;
            return this;
        }

        /**
         * Build call for listPriceTriggeredOrders
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
            return listPriceTriggeredOrdersCall(settle, status, contract, limit, offset, _callback);
        }

        /**
         * Execute listPriceTriggeredOrders request
         * @return List&lt;FuturesPriceTriggeredOrder&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> List retrieved </td><td>  -  </td></tr>
         </table>
         */
        public List<FuturesPriceTriggeredOrder> execute() throws ApiException {
            ApiResponse<List<FuturesPriceTriggeredOrder>> localVarResp = listPriceTriggeredOrdersWithHttpInfo(settle, status, contract, limit, offset);
            return localVarResp.getData();
        }

        /**
         * Execute listPriceTriggeredOrders request with HTTP info returned
         * @return ApiResponse&lt;List&lt;FuturesPriceTriggeredOrder&gt;&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> List retrieved </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<List<FuturesPriceTriggeredOrder>> executeWithHttpInfo() throws ApiException {
            return listPriceTriggeredOrdersWithHttpInfo(settle, status, contract, limit, offset);
        }

        /**
         * Execute listPriceTriggeredOrders request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> List retrieved </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<List<FuturesPriceTriggeredOrder>> _callback) throws ApiException {
            return listPriceTriggeredOrdersAsync(settle, status, contract, limit, offset, _callback);
        }
    }

    /**
     * List all auto orders
     * 
     * @param settle Settle currency (required)
     * @param status List orders based on status (required)
     * @return APIlistPriceTriggeredOrdersRequest
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> List retrieved </td><td>  -  </td></tr>
     </table>
     */
    public APIlistPriceTriggeredOrdersRequest listPriceTriggeredOrders(String settle, String status) {
        return new APIlistPriceTriggeredOrdersRequest(settle, status);
    }

    /**
     * Build call for createPriceTriggeredOrder
     * @param settle Settle currency (required)
     * @param futuresPriceTriggeredOrder  (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 201 </td><td> Order created </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call createPriceTriggeredOrderCall(String settle, FuturesPriceTriggeredOrder futuresPriceTriggeredOrder, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = futuresPriceTriggeredOrder;

        // create path and map variables
        String localVarPath = "/futures/{settle}/price_orders"
            .replaceAll("\\{" + "settle" + "\\}", localVarApiClient.escapeString(settle));

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
    private okhttp3.Call createPriceTriggeredOrderValidateBeforeCall(String settle, FuturesPriceTriggeredOrder futuresPriceTriggeredOrder, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'settle' is set
        if (settle == null) {
            throw new ApiException("Missing the required parameter 'settle' when calling createPriceTriggeredOrder(Async)");
        }

        // verify the required parameter 'futuresPriceTriggeredOrder' is set
        if (futuresPriceTriggeredOrder == null) {
            throw new ApiException("Missing the required parameter 'futuresPriceTriggeredOrder' when calling createPriceTriggeredOrder(Async)");
        }

        okhttp3.Call localVarCall = createPriceTriggeredOrderCall(settle, futuresPriceTriggeredOrder, _callback);
        return localVarCall;
    }

    /**
     * Create a price-triggered order
     * 
     * @param settle Settle currency (required)
     * @param futuresPriceTriggeredOrder  (required)
     * @return TriggerOrderResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 201 </td><td> Order created </td><td>  -  </td></tr>
     </table>
     */
    public TriggerOrderResponse createPriceTriggeredOrder(String settle, FuturesPriceTriggeredOrder futuresPriceTriggeredOrder) throws ApiException {
        ApiResponse<TriggerOrderResponse> localVarResp = createPriceTriggeredOrderWithHttpInfo(settle, futuresPriceTriggeredOrder);
        return localVarResp.getData();
    }

    /**
     * Create a price-triggered order
     * 
     * @param settle Settle currency (required)
     * @param futuresPriceTriggeredOrder  (required)
     * @return ApiResponse&lt;TriggerOrderResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 201 </td><td> Order created </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<TriggerOrderResponse> createPriceTriggeredOrderWithHttpInfo(String settle, FuturesPriceTriggeredOrder futuresPriceTriggeredOrder) throws ApiException {
        okhttp3.Call localVarCall = createPriceTriggeredOrderValidateBeforeCall(settle, futuresPriceTriggeredOrder, null);
        Type localVarReturnType = new TypeToken<TriggerOrderResponse>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Create a price-triggered order (asynchronously)
     * 
     * @param settle Settle currency (required)
     * @param futuresPriceTriggeredOrder  (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 201 </td><td> Order created </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call createPriceTriggeredOrderAsync(String settle, FuturesPriceTriggeredOrder futuresPriceTriggeredOrder, final ApiCallback<TriggerOrderResponse> _callback) throws ApiException {
        okhttp3.Call localVarCall = createPriceTriggeredOrderValidateBeforeCall(settle, futuresPriceTriggeredOrder, _callback);
        Type localVarReturnType = new TypeToken<TriggerOrderResponse>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    /**
     * Build call for cancelPriceTriggeredOrderList
     * @param settle Settle currency (required)
     * @param contract Futures contract (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Batch cancellation request accepted. Query order status by listing orders </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call cancelPriceTriggeredOrderListCall(String settle, String contract, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/futures/{settle}/price_orders"
            .replaceAll("\\{" + "settle" + "\\}", localVarApiClient.escapeString(settle));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (contract != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("contract", contract));
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
    private okhttp3.Call cancelPriceTriggeredOrderListValidateBeforeCall(String settle, String contract, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'settle' is set
        if (settle == null) {
            throw new ApiException("Missing the required parameter 'settle' when calling cancelPriceTriggeredOrderList(Async)");
        }

        // verify the required parameter 'contract' is set
        if (contract == null) {
            throw new ApiException("Missing the required parameter 'contract' when calling cancelPriceTriggeredOrderList(Async)");
        }

        okhttp3.Call localVarCall = cancelPriceTriggeredOrderListCall(settle, contract, _callback);
        return localVarCall;
    }

    /**
     * Cancel all open orders
     * 
     * @param settle Settle currency (required)
     * @param contract Futures contract (required)
     * @return List&lt;FuturesPriceTriggeredOrder&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Batch cancellation request accepted. Query order status by listing orders </td><td>  -  </td></tr>
     </table>
     */
    public List<FuturesPriceTriggeredOrder> cancelPriceTriggeredOrderList(String settle, String contract) throws ApiException {
        ApiResponse<List<FuturesPriceTriggeredOrder>> localVarResp = cancelPriceTriggeredOrderListWithHttpInfo(settle, contract);
        return localVarResp.getData();
    }

    /**
     * Cancel all open orders
     * 
     * @param settle Settle currency (required)
     * @param contract Futures contract (required)
     * @return ApiResponse&lt;List&lt;FuturesPriceTriggeredOrder&gt;&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Batch cancellation request accepted. Query order status by listing orders </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<List<FuturesPriceTriggeredOrder>> cancelPriceTriggeredOrderListWithHttpInfo(String settle, String contract) throws ApiException {
        okhttp3.Call localVarCall = cancelPriceTriggeredOrderListValidateBeforeCall(settle, contract, null);
        Type localVarReturnType = new TypeToken<List<FuturesPriceTriggeredOrder>>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Cancel all open orders (asynchronously)
     * 
     * @param settle Settle currency (required)
     * @param contract Futures contract (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Batch cancellation request accepted. Query order status by listing orders </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call cancelPriceTriggeredOrderListAsync(String settle, String contract, final ApiCallback<List<FuturesPriceTriggeredOrder>> _callback) throws ApiException {
        okhttp3.Call localVarCall = cancelPriceTriggeredOrderListValidateBeforeCall(settle, contract, _callback);
        Type localVarReturnType = new TypeToken<List<FuturesPriceTriggeredOrder>>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    /**
     * Build call for getPriceTriggeredOrder
     * @param settle Settle currency (required)
     * @param orderId ID returned on order successfully being created (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Auto order detail </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call getPriceTriggeredOrderCall(String settle, String orderId, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/futures/{settle}/price_orders/{order_id}"
            .replaceAll("\\{" + "settle" + "\\}", localVarApiClient.escapeString(settle))
            .replaceAll("\\{" + "order_id" + "\\}", localVarApiClient.escapeString(orderId));

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

        String[] localVarAuthNames = new String[] { "apiv4" };
        return localVarApiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call getPriceTriggeredOrderValidateBeforeCall(String settle, String orderId, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'settle' is set
        if (settle == null) {
            throw new ApiException("Missing the required parameter 'settle' when calling getPriceTriggeredOrder(Async)");
        }

        // verify the required parameter 'orderId' is set
        if (orderId == null) {
            throw new ApiException("Missing the required parameter 'orderId' when calling getPriceTriggeredOrder(Async)");
        }

        okhttp3.Call localVarCall = getPriceTriggeredOrderCall(settle, orderId, _callback);
        return localVarCall;
    }

    /**
     * Get a single order
     * 
     * @param settle Settle currency (required)
     * @param orderId ID returned on order successfully being created (required)
     * @return FuturesPriceTriggeredOrder
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Auto order detail </td><td>  -  </td></tr>
     </table>
     */
    public FuturesPriceTriggeredOrder getPriceTriggeredOrder(String settle, String orderId) throws ApiException {
        ApiResponse<FuturesPriceTriggeredOrder> localVarResp = getPriceTriggeredOrderWithHttpInfo(settle, orderId);
        return localVarResp.getData();
    }

    /**
     * Get a single order
     * 
     * @param settle Settle currency (required)
     * @param orderId ID returned on order successfully being created (required)
     * @return ApiResponse&lt;FuturesPriceTriggeredOrder&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Auto order detail </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<FuturesPriceTriggeredOrder> getPriceTriggeredOrderWithHttpInfo(String settle, String orderId) throws ApiException {
        okhttp3.Call localVarCall = getPriceTriggeredOrderValidateBeforeCall(settle, orderId, null);
        Type localVarReturnType = new TypeToken<FuturesPriceTriggeredOrder>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Get a single order (asynchronously)
     * 
     * @param settle Settle currency (required)
     * @param orderId ID returned on order successfully being created (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Auto order detail </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call getPriceTriggeredOrderAsync(String settle, String orderId, final ApiCallback<FuturesPriceTriggeredOrder> _callback) throws ApiException {
        okhttp3.Call localVarCall = getPriceTriggeredOrderValidateBeforeCall(settle, orderId, _callback);
        Type localVarReturnType = new TypeToken<FuturesPriceTriggeredOrder>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    /**
     * Build call for cancelPriceTriggeredOrder
     * @param settle Settle currency (required)
     * @param orderId ID returned on order successfully being created (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Auto order detail </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call cancelPriceTriggeredOrderCall(String settle, String orderId, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/futures/{settle}/price_orders/{order_id}"
            .replaceAll("\\{" + "settle" + "\\}", localVarApiClient.escapeString(settle))
            .replaceAll("\\{" + "order_id" + "\\}", localVarApiClient.escapeString(orderId));

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

        String[] localVarAuthNames = new String[] { "apiv4" };
        return localVarApiClient.buildCall(localVarPath, "DELETE", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call cancelPriceTriggeredOrderValidateBeforeCall(String settle, String orderId, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'settle' is set
        if (settle == null) {
            throw new ApiException("Missing the required parameter 'settle' when calling cancelPriceTriggeredOrder(Async)");
        }

        // verify the required parameter 'orderId' is set
        if (orderId == null) {
            throw new ApiException("Missing the required parameter 'orderId' when calling cancelPriceTriggeredOrder(Async)");
        }

        okhttp3.Call localVarCall = cancelPriceTriggeredOrderCall(settle, orderId, _callback);
        return localVarCall;
    }

    /**
     * Cancel a single order
     * 
     * @param settle Settle currency (required)
     * @param orderId ID returned on order successfully being created (required)
     * @return FuturesPriceTriggeredOrder
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Auto order detail </td><td>  -  </td></tr>
     </table>
     */
    public FuturesPriceTriggeredOrder cancelPriceTriggeredOrder(String settle, String orderId) throws ApiException {
        ApiResponse<FuturesPriceTriggeredOrder> localVarResp = cancelPriceTriggeredOrderWithHttpInfo(settle, orderId);
        return localVarResp.getData();
    }

    /**
     * Cancel a single order
     * 
     * @param settle Settle currency (required)
     * @param orderId ID returned on order successfully being created (required)
     * @return ApiResponse&lt;FuturesPriceTriggeredOrder&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Auto order detail </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<FuturesPriceTriggeredOrder> cancelPriceTriggeredOrderWithHttpInfo(String settle, String orderId) throws ApiException {
        okhttp3.Call localVarCall = cancelPriceTriggeredOrderValidateBeforeCall(settle, orderId, null);
        Type localVarReturnType = new TypeToken<FuturesPriceTriggeredOrder>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Cancel a single order (asynchronously)
     * 
     * @param settle Settle currency (required)
     * @param orderId ID returned on order successfully being created (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Auto order detail </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call cancelPriceTriggeredOrderAsync(String settle, String orderId, final ApiCallback<FuturesPriceTriggeredOrder> _callback) throws ApiException {
        okhttp3.Call localVarCall = cancelPriceTriggeredOrderValidateBeforeCall(settle, orderId, _callback);
        Type localVarReturnType = new TypeToken<FuturesPriceTriggeredOrder>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

}
