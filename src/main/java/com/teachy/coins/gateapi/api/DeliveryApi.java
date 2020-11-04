


package com.teachy.coins.gateapi.api;

import com.google.common.reflect.TypeToken;
import com.teachy.coins.gateapi.ApiCallback;
import com.teachy.coins.gateapi.ApiClient;
import com.teachy.coins.gateapi.ApiException;
import com.teachy.coins.gateapi.ApiResponse;
import com.teachy.coins.gateapi.Configuration;
import com.teachy.coins.gateapi.Pair;


import java.math.BigDecimal;
import com.teachy.coins.gateapi.models.DeliveryContract;
import com.teachy.coins.gateapi.models.DeliverySettlement;
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

public class DeliveryApi {
    private ApiClient localVarApiClient;

    public DeliveryApi() {
        this(Configuration.getDefaultApiClient());
    }

    public DeliveryApi(ApiClient apiClient) {
        this.localVarApiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return localVarApiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.localVarApiClient = apiClient;
    }

    /**
     * Build call for listDeliveryContracts
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
    public okhttp3.Call listDeliveryContractsCall(String settle, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/delivery/{settle}/contracts"
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
    private okhttp3.Call listDeliveryContractsValidateBeforeCall(String settle, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'settle' is set
        if (settle == null) {
            throw new ApiException("Missing the required parameter 'settle' when calling listDeliveryContracts(Async)");
        }

        okhttp3.Call localVarCall = listDeliveryContractsCall(settle, _callback);
        return localVarCall;
    }

    /**
     * List all futures contracts
     * 
     * @param settle Settle currency (required)
     * @return List&lt;DeliveryContract&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> List retrieved </td><td>  -  </td></tr>
     </table>
     */
    public List<DeliveryContract> listDeliveryContracts(String settle) throws ApiException {
        ApiResponse<List<DeliveryContract>> localVarResp = listDeliveryContractsWithHttpInfo(settle);
        return localVarResp.getData();
    }

    /**
     * List all futures contracts
     * 
     * @param settle Settle currency (required)
     * @return ApiResponse&lt;List&lt;DeliveryContract&gt;&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> List retrieved </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<List<DeliveryContract>> listDeliveryContractsWithHttpInfo(String settle) throws ApiException {
        okhttp3.Call localVarCall = listDeliveryContractsValidateBeforeCall(settle, null);
        Type localVarReturnType = new com.google.common.reflect.TypeToken<List<DeliveryContract>>(){}.getType();
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
    public okhttp3.Call listDeliveryContractsAsync(String settle, final ApiCallback<List<DeliveryContract>> _callback) throws ApiException {
        okhttp3.Call localVarCall = listDeliveryContractsValidateBeforeCall(settle, _callback);
        Type localVarReturnType = new com.google.common.reflect.TypeToken<List<DeliveryContract>>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    /**
     * Build call for getDeliveryContract
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
    public okhttp3.Call getDeliveryContractCall(String settle, String contract, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/delivery/{settle}/contracts/{contract}"
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
    private okhttp3.Call getDeliveryContractValidateBeforeCall(String settle, String contract, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'settle' is set
        if (settle == null) {
            throw new ApiException("Missing the required parameter 'settle' when calling getDeliveryContract(Async)");
        }

        // verify the required parameter 'contract' is set
        if (contract == null) {
            throw new ApiException("Missing the required parameter 'contract' when calling getDeliveryContract(Async)");
        }

        okhttp3.Call localVarCall = getDeliveryContractCall(settle, contract, _callback);
        return localVarCall;
    }

    /**
     * Get a single contract
     * 
     * @param settle Settle currency (required)
     * @param contract Futures contract (required)
     * @return DeliveryContract
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Contract information </td><td>  -  </td></tr>
     </table>
     */
    public DeliveryContract getDeliveryContract(String settle, String contract) throws ApiException {
        ApiResponse<DeliveryContract> localVarResp = getDeliveryContractWithHttpInfo(settle, contract);
        return localVarResp.getData();
    }

    /**
     * Get a single contract
     * 
     * @param settle Settle currency (required)
     * @param contract Futures contract (required)
     * @return ApiResponse&lt;DeliveryContract&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Contract information </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<DeliveryContract> getDeliveryContractWithHttpInfo(String settle, String contract) throws ApiException {
        okhttp3.Call localVarCall = getDeliveryContractValidateBeforeCall(settle, contract, null);
        Type localVarReturnType = new com.google.common.reflect.TypeToken<DeliveryContract>(){}.getType();
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
    public okhttp3.Call getDeliveryContractAsync(String settle, String contract, final ApiCallback<DeliveryContract> _callback) throws ApiException {
        okhttp3.Call localVarCall = getDeliveryContractValidateBeforeCall(settle, contract, _callback);
        Type localVarReturnType = new com.google.common.reflect.TypeToken<DeliveryContract>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    private okhttp3.Call listDeliveryOrderBookCall(String settle, String contract, String interval, Integer limit, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/delivery/{settle}/order_book"
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
    private okhttp3.Call listDeliveryOrderBookValidateBeforeCall(String settle, String contract, String interval, Integer limit, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'settle' is set
        if (settle == null) {
            throw new ApiException("Missing the required parameter 'settle' when calling listDeliveryOrderBook(Async)");
        }

        // verify the required parameter 'contract' is set
        if (contract == null) {
            throw new ApiException("Missing the required parameter 'contract' when calling listDeliveryOrderBook(Async)");
        }

        okhttp3.Call localVarCall = listDeliveryOrderBookCall(settle, contract, interval, limit, _callback);
        return localVarCall;
    }


    private ApiResponse<FuturesOrderBook> listDeliveryOrderBookWithHttpInfo(String settle, String contract, String interval, Integer limit) throws ApiException {
        okhttp3.Call localVarCall = listDeliveryOrderBookValidateBeforeCall(settle, contract, interval, limit, null);
        Type localVarReturnType = new com.google.common.reflect.TypeToken<FuturesOrderBook>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call listDeliveryOrderBookAsync(String settle, String contract, String interval, Integer limit, final ApiCallback<FuturesOrderBook> _callback) throws ApiException {
        okhttp3.Call localVarCall = listDeliveryOrderBookValidateBeforeCall(settle, contract, interval, limit, _callback);
        Type localVarReturnType = new com.google.common.reflect.TypeToken<FuturesOrderBook>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class APIlistDeliveryOrderBookRequest {
        private final String settle;
        private final String contract;
        private String interval;
        private Integer limit;

        private APIlistDeliveryOrderBookRequest(String settle, String contract) {
            this.settle = settle;
            this.contract = contract;
        }

        /**
         * Set interval
         * @param interval Order depth. 0 means no aggregation is applied. default to 0 (optional, default to 0)
         * @return APIlistDeliveryOrderBookRequest
         */
        public APIlistDeliveryOrderBookRequest interval(String interval) {
            this.interval = interval;
            return this;
        }

        /**
         * Set limit
         * @param limit Maximum number of order depth data in asks or bids (optional, default to 10)
         * @return APIlistDeliveryOrderBookRequest
         */
        public APIlistDeliveryOrderBookRequest limit(Integer limit) {
            this.limit = limit;
            return this;
        }

        /**
         * Build call for listDeliveryOrderBook
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
            return listDeliveryOrderBookCall(settle, contract, interval, limit, _callback);
        }

        /**
         * Execute listDeliveryOrderBook request
         * @return FuturesOrderBook
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> Order book retrieved </td><td>  -  </td></tr>
         </table>
         */
        public FuturesOrderBook execute() throws ApiException {
            ApiResponse<FuturesOrderBook> localVarResp = listDeliveryOrderBookWithHttpInfo(settle, contract, interval, limit);
            return localVarResp.getData();
        }

        /**
         * Execute listDeliveryOrderBook request with HTTP info returned
         * @return ApiResponse&lt;FuturesOrderBook&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> Order book retrieved </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<FuturesOrderBook> executeWithHttpInfo() throws ApiException {
            return listDeliveryOrderBookWithHttpInfo(settle, contract, interval, limit);
        }

        /**
         * Execute listDeliveryOrderBook request (asynchronously)
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
            return listDeliveryOrderBookAsync(settle, contract, interval, limit, _callback);
        }
    }

    /**
     * Futures order book
     * Bids will be sorted by price from high to low, while asks sorted reversely
     * @param settle Settle currency (required)
     * @param contract Futures contract (required)
     * @return APIlistDeliveryOrderBookRequest
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Order book retrieved </td><td>  -  </td></tr>
     </table>
     */
    public APIlistDeliveryOrderBookRequest listDeliveryOrderBook(String settle, String contract) {
        return new APIlistDeliveryOrderBookRequest(settle, contract);
    }

    private okhttp3.Call listDeliveryTradesCall(String settle, String contract, Integer limit, String lastId, BigDecimal from, BigDecimal to, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/delivery/{settle}/trades"
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
    private okhttp3.Call listDeliveryTradesValidateBeforeCall(String settle, String contract, Integer limit, String lastId, BigDecimal from, BigDecimal to, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'settle' is set
        if (settle == null) {
            throw new ApiException("Missing the required parameter 'settle' when calling listDeliveryTrades(Async)");
        }

        // verify the required parameter 'contract' is set
        if (contract == null) {
            throw new ApiException("Missing the required parameter 'contract' when calling listDeliveryTrades(Async)");
        }

        okhttp3.Call localVarCall = listDeliveryTradesCall(settle, contract, limit, lastId, from, to, _callback);
        return localVarCall;
    }


    private ApiResponse<List<FuturesTrade>> listDeliveryTradesWithHttpInfo(String settle, String contract, Integer limit, String lastId, BigDecimal from, BigDecimal to) throws ApiException {
        okhttp3.Call localVarCall = listDeliveryTradesValidateBeforeCall(settle, contract, limit, lastId, from, to, null);
        Type localVarReturnType = new com.google.common.reflect.TypeToken<List<FuturesTrade>>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call listDeliveryTradesAsync(String settle, String contract, Integer limit, String lastId, BigDecimal from, BigDecimal to, final ApiCallback<List<FuturesTrade>> _callback) throws ApiException {
        okhttp3.Call localVarCall = listDeliveryTradesValidateBeforeCall(settle, contract, limit, lastId, from, to, _callback);
        Type localVarReturnType = new com.google.common.reflect.TypeToken<List<FuturesTrade>>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class APIlistDeliveryTradesRequest {
        private final String settle;
        private final String contract;
        private Integer limit;
        private String lastId;
        private BigDecimal from;
        private BigDecimal to;

        private APIlistDeliveryTradesRequest(String settle, String contract) {
            this.settle = settle;
            this.contract = contract;
        }

        /**
         * Set limit
         * @param limit Maximum number of records returned in one list (optional, default to 100)
         * @return APIlistDeliveryTradesRequest
         */
        public APIlistDeliveryTradesRequest limit(Integer limit) {
            this.limit = limit;
            return this;
        }

        /**
         * Set lastId
         * @param lastId Specify list staring point using the id of last record in previous list-query results  This parameter is deprecated. Use &#x60;from&#x60; and &#x60;to&#x60; instead to limit time range (optional)
         * @return APIlistDeliveryTradesRequest
         */
        public APIlistDeliveryTradesRequest lastId(String lastId) {
            this.lastId = lastId;
            return this;
        }

        /**
         * Set from
         * @param from Specify starting time in Unix seconds. If not specified, &#x60;to&#x60; and &#x60;limit&#x60; will be used to limit response items. If items between &#x60;from&#x60; and &#x60;to&#x60; are more than &#x60;limit&#x60;, only &#x60;limit&#x60; number will be returned.  (optional)
         * @return APIlistDeliveryTradesRequest
         */
        public APIlistDeliveryTradesRequest from(BigDecimal from) {
            this.from = from;
            return this;
        }

        /**
         * Set to
         * @param to Specify end time in Unix seconds, default to current time (optional)
         * @return APIlistDeliveryTradesRequest
         */
        public APIlistDeliveryTradesRequest to(BigDecimal to) {
            this.to = to;
            return this;
        }

        /**
         * Build call for listDeliveryTrades
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
            return listDeliveryTradesCall(settle, contract, limit, lastId, from, to, _callback);
        }

        /**
         * Execute listDeliveryTrades request
         * @return List&lt;FuturesTrade&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> List retrieved </td><td>  -  </td></tr>
         </table>
         */
        public List<FuturesTrade> execute() throws ApiException {
            ApiResponse<List<FuturesTrade>> localVarResp = listDeliveryTradesWithHttpInfo(settle, contract, limit, lastId, from, to);
            return localVarResp.getData();
        }

        /**
         * Execute listDeliveryTrades request with HTTP info returned
         * @return ApiResponse&lt;List&lt;FuturesTrade&gt;&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> List retrieved </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<List<FuturesTrade>> executeWithHttpInfo() throws ApiException {
            return listDeliveryTradesWithHttpInfo(settle, contract, limit, lastId, from, to);
        }

        /**
         * Execute listDeliveryTrades request (asynchronously)
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
            return listDeliveryTradesAsync(settle, contract, limit, lastId, from, to, _callback);
        }
    }

    /**
     * Futures trading history
     * 
     * @param settle Settle currency (required)
     * @param contract Futures contract (required)
     * @return APIlistDeliveryTradesRequest
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> List retrieved </td><td>  -  </td></tr>
     </table>
     */
    public APIlistDeliveryTradesRequest listDeliveryTrades(String settle, String contract) {
        return new APIlistDeliveryTradesRequest(settle, contract);
    }

    private okhttp3.Call listDeliveryCandlesticksCall(String settle, String contract, BigDecimal from, BigDecimal to, Integer limit, String interval, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/delivery/{settle}/candlesticks"
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
    private okhttp3.Call listDeliveryCandlesticksValidateBeforeCall(String settle, String contract, BigDecimal from, BigDecimal to, Integer limit, String interval, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'settle' is set
        if (settle == null) {
            throw new ApiException("Missing the required parameter 'settle' when calling listDeliveryCandlesticks(Async)");
        }

        // verify the required parameter 'contract' is set
        if (contract == null) {
            throw new ApiException("Missing the required parameter 'contract' when calling listDeliveryCandlesticks(Async)");
        }

        okhttp3.Call localVarCall = listDeliveryCandlesticksCall(settle, contract, from, to, limit, interval, _callback);
        return localVarCall;
    }


    private ApiResponse<List<FuturesCandlestick>> listDeliveryCandlesticksWithHttpInfo(String settle, String contract, BigDecimal from, BigDecimal to, Integer limit, String interval) throws ApiException {
        okhttp3.Call localVarCall = listDeliveryCandlesticksValidateBeforeCall(settle, contract, from, to, limit, interval, null);
        Type localVarReturnType = new com.google.common.reflect.TypeToken<List<FuturesCandlestick>>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call listDeliveryCandlesticksAsync(String settle, String contract, BigDecimal from, BigDecimal to, Integer limit, String interval, final ApiCallback<List<FuturesCandlestick>> _callback) throws ApiException {
        okhttp3.Call localVarCall = listDeliveryCandlesticksValidateBeforeCall(settle, contract, from, to, limit, interval, _callback);
        Type localVarReturnType = new com.google.common.reflect.TypeToken<List<FuturesCandlestick>>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class APIlistDeliveryCandlesticksRequest {
        private final String settle;
        private final String contract;
        private BigDecimal from;
        private BigDecimal to;
        private Integer limit;
        private String interval;

        private APIlistDeliveryCandlesticksRequest(String settle, String contract) {
            this.settle = settle;
            this.contract = contract;
        }

        /**
         * Set from
         * @param from Start time of candlesticks, formatted in Unix timestamp in seconds. Default to&#x60;to - 100 * interval&#x60; if not specified (optional)
         * @return APIlistDeliveryCandlesticksRequest
         */
        public APIlistDeliveryCandlesticksRequest from(BigDecimal from) {
            this.from = from;
            return this;
        }

        /**
         * Set to
         * @param to End time of candlesticks, formatted in Unix timestamp in seconds. Default to current time (optional)
         * @return APIlistDeliveryCandlesticksRequest
         */
        public APIlistDeliveryCandlesticksRequest to(BigDecimal to) {
            this.to = to;
            return this;
        }

        /**
         * Set limit
         * @param limit Maximum recent data points returned. &#x60;limit&#x60; is conflicted with &#x60;from&#x60; and &#x60;to&#x60;. If either &#x60;from&#x60; or &#x60;to&#x60; is specified, request will be rejected. (optional, default to 100)
         * @return APIlistDeliveryCandlesticksRequest
         */
        public APIlistDeliveryCandlesticksRequest limit(Integer limit) {
            this.limit = limit;
            return this;
        }

        /**
         * Set interval
         * @param interval Interval time between data points (optional, default to 5m)
         * @return APIlistDeliveryCandlesticksRequest
         */
        public APIlistDeliveryCandlesticksRequest interval(String interval) {
            this.interval = interval;
            return this;
        }

        /**
         * Build call for listDeliveryCandlesticks
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
            return listDeliveryCandlesticksCall(settle, contract, from, to, limit, interval, _callback);
        }

        /**
         * Execute listDeliveryCandlesticks request
         * @return List&lt;FuturesCandlestick&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> Successfully retrieved </td><td>  -  </td></tr>
         </table>
         */
        public List<FuturesCandlestick> execute() throws ApiException {
            ApiResponse<List<FuturesCandlestick>> localVarResp = listDeliveryCandlesticksWithHttpInfo(settle, contract, from, to, limit, interval);
            return localVarResp.getData();
        }

        /**
         * Execute listDeliveryCandlesticks request with HTTP info returned
         * @return ApiResponse&lt;List&lt;FuturesCandlestick&gt;&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> Successfully retrieved </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<List<FuturesCandlestick>> executeWithHttpInfo() throws ApiException {
            return listDeliveryCandlesticksWithHttpInfo(settle, contract, from, to, limit, interval);
        }

        /**
         * Execute listDeliveryCandlesticks request (asynchronously)
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
            return listDeliveryCandlesticksAsync(settle, contract, from, to, limit, interval, _callback);
        }
    }

    /**
     * Get futures candlesticks
     * Return specified contract candlesticks. If prefix &#x60;contract&#x60; with &#x60;mark_&#x60;, the contract&#39;s mark price candlesticks are returned; if prefix with &#x60;index_&#x60;, index price candlesticks will be returned.  Maximum of 2000 points are returned in one query. Be sure not to exceed the limit when specifying &#x60;from&#x60;, &#x60;to&#x60; and &#x60;interval&#x60;
     * @param settle Settle currency (required)
     * @param contract Futures contract (required)
     * @return APIlistDeliveryCandlesticksRequest
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Successfully retrieved </td><td>  -  </td></tr>
     </table>
     */
    public APIlistDeliveryCandlesticksRequest listDeliveryCandlesticks(String settle, String contract) {
        return new APIlistDeliveryCandlesticksRequest(settle, contract);
    }

    private okhttp3.Call listDeliveryTickersCall(String settle, String contract, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/delivery/{settle}/tickers"
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
    private okhttp3.Call listDeliveryTickersValidateBeforeCall(String settle, String contract, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'settle' is set
        if (settle == null) {
            throw new ApiException("Missing the required parameter 'settle' when calling listDeliveryTickers(Async)");
        }

        okhttp3.Call localVarCall = listDeliveryTickersCall(settle, contract, _callback);
        return localVarCall;
    }


    private ApiResponse<List<FuturesTicker>> listDeliveryTickersWithHttpInfo(String settle, String contract) throws ApiException {
        okhttp3.Call localVarCall = listDeliveryTickersValidateBeforeCall(settle, contract, null);
        Type localVarReturnType = new com.google.common.reflect.TypeToken<List<FuturesTicker>>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call listDeliveryTickersAsync(String settle, String contract, final ApiCallback<List<FuturesTicker>> _callback) throws ApiException {
        okhttp3.Call localVarCall = listDeliveryTickersValidateBeforeCall(settle, contract, _callback);
        Type localVarReturnType = new com.google.common.reflect.TypeToken<List<FuturesTicker>>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class APIlistDeliveryTickersRequest {
        private final String settle;
        private String contract;

        private APIlistDeliveryTickersRequest(String settle) {
            this.settle = settle;
        }

        /**
         * Set contract
         * @param contract Futures contract (optional)
         * @return APIlistDeliveryTickersRequest
         */
        public APIlistDeliveryTickersRequest contract(String contract) {
            this.contract = contract;
            return this;
        }

        /**
         * Build call for listDeliveryTickers
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
            return listDeliveryTickersCall(settle, contract, _callback);
        }

        /**
         * Execute listDeliveryTickers request
         * @return List&lt;FuturesTicker&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> Successfully retrieved </td><td>  -  </td></tr>
         </table>
         */
        public List<FuturesTicker> execute() throws ApiException {
            ApiResponse<List<FuturesTicker>> localVarResp = listDeliveryTickersWithHttpInfo(settle, contract);
            return localVarResp.getData();
        }

        /**
         * Execute listDeliveryTickers request with HTTP info returned
         * @return ApiResponse&lt;List&lt;FuturesTicker&gt;&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> Successfully retrieved </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<List<FuturesTicker>> executeWithHttpInfo() throws ApiException {
            return listDeliveryTickersWithHttpInfo(settle, contract);
        }

        /**
         * Execute listDeliveryTickers request (asynchronously)
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
            return listDeliveryTickersAsync(settle, contract, _callback);
        }
    }

    /**
     * List futures tickers
     * 
     * @param settle Settle currency (required)
     * @return APIlistDeliveryTickersRequest
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Successfully retrieved </td><td>  -  </td></tr>
     </table>
     */
    public APIlistDeliveryTickersRequest listDeliveryTickers(String settle) {
        return new APIlistDeliveryTickersRequest(settle);
    }

    private okhttp3.Call listDeliveryInsuranceLedgerCall(String settle, Integer limit, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/delivery/{settle}/insurance"
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
    private okhttp3.Call listDeliveryInsuranceLedgerValidateBeforeCall(String settle, Integer limit, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'settle' is set
        if (settle == null) {
            throw new ApiException("Missing the required parameter 'settle' when calling listDeliveryInsuranceLedger(Async)");
        }

        okhttp3.Call localVarCall = listDeliveryInsuranceLedgerCall(settle, limit, _callback);
        return localVarCall;
    }


    private ApiResponse<List<InsuranceRecord>> listDeliveryInsuranceLedgerWithHttpInfo(String settle, Integer limit) throws ApiException {
        okhttp3.Call localVarCall = listDeliveryInsuranceLedgerValidateBeforeCall(settle, limit, null);
        Type localVarReturnType = new com.google.common.reflect.TypeToken<List<InsuranceRecord>>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call listDeliveryInsuranceLedgerAsync(String settle, Integer limit, final ApiCallback<List<InsuranceRecord>> _callback) throws ApiException {
        okhttp3.Call localVarCall = listDeliveryInsuranceLedgerValidateBeforeCall(settle, limit, _callback);
        Type localVarReturnType = new com.google.common.reflect.TypeToken<List<InsuranceRecord>>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class APIlistDeliveryInsuranceLedgerRequest {
        private final String settle;
        private Integer limit;

        private APIlistDeliveryInsuranceLedgerRequest(String settle) {
            this.settle = settle;
        }

        /**
         * Set limit
         * @param limit Maximum number of records returned in one list (optional, default to 100)
         * @return APIlistDeliveryInsuranceLedgerRequest
         */
        public APIlistDeliveryInsuranceLedgerRequest limit(Integer limit) {
            this.limit = limit;
            return this;
        }

        /**
         * Build call for listDeliveryInsuranceLedger
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
            return listDeliveryInsuranceLedgerCall(settle, limit, _callback);
        }

        /**
         * Execute listDeliveryInsuranceLedger request
         * @return List&lt;InsuranceRecord&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> Successfully retrieved </td><td>  -  </td></tr>
         </table>
         */
        public List<InsuranceRecord> execute() throws ApiException {
            ApiResponse<List<InsuranceRecord>> localVarResp = listDeliveryInsuranceLedgerWithHttpInfo(settle, limit);
            return localVarResp.getData();
        }

        /**
         * Execute listDeliveryInsuranceLedger request with HTTP info returned
         * @return ApiResponse&lt;List&lt;InsuranceRecord&gt;&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> Successfully retrieved </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<List<InsuranceRecord>> executeWithHttpInfo() throws ApiException {
            return listDeliveryInsuranceLedgerWithHttpInfo(settle, limit);
        }

        /**
         * Execute listDeliveryInsuranceLedger request (asynchronously)
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
            return listDeliveryInsuranceLedgerAsync(settle, limit, _callback);
        }
    }

    /**
     * Futures insurance balance history
     * 
     * @param settle Settle currency (required)
     * @return APIlistDeliveryInsuranceLedgerRequest
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Successfully retrieved </td><td>  -  </td></tr>
     </table>
     */
    public APIlistDeliveryInsuranceLedgerRequest listDeliveryInsuranceLedger(String settle) {
        return new APIlistDeliveryInsuranceLedgerRequest(settle);
    }

    /**
     * Build call for listDeliveryAccounts
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
    public okhttp3.Call listDeliveryAccountsCall(String settle, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/delivery/{settle}/accounts"
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
    private okhttp3.Call listDeliveryAccountsValidateBeforeCall(String settle, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'settle' is set
        if (settle == null) {
            throw new ApiException("Missing the required parameter 'settle' when calling listDeliveryAccounts(Async)");
        }

        okhttp3.Call localVarCall = listDeliveryAccountsCall(settle, _callback);
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
    public FuturesAccount listDeliveryAccounts(String settle) throws ApiException {
        ApiResponse<FuturesAccount> localVarResp = listDeliveryAccountsWithHttpInfo(settle);
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
    public ApiResponse<FuturesAccount> listDeliveryAccountsWithHttpInfo(String settle) throws ApiException {
        okhttp3.Call localVarCall = listDeliveryAccountsValidateBeforeCall(settle, null);
        Type localVarReturnType = new com.google.common.reflect.TypeToken<FuturesAccount>(){}.getType();
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
    public okhttp3.Call listDeliveryAccountsAsync(String settle, final ApiCallback<FuturesAccount> _callback) throws ApiException {
        okhttp3.Call localVarCall = listDeliveryAccountsValidateBeforeCall(settle, _callback);
        Type localVarReturnType = new com.google.common.reflect.TypeToken<FuturesAccount>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    private okhttp3.Call listDeliveryAccountBookCall(String settle, Integer limit, Long from, Long to, String type, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/delivery/{settle}/account_book"
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
    private okhttp3.Call listDeliveryAccountBookValidateBeforeCall(String settle, Integer limit, Long from, Long to, String type, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'settle' is set
        if (settle == null) {
            throw new ApiException("Missing the required parameter 'settle' when calling listDeliveryAccountBook(Async)");
        }

        okhttp3.Call localVarCall = listDeliveryAccountBookCall(settle, limit, from, to, type, _callback);
        return localVarCall;
    }


    private ApiResponse<List<FuturesAccountBook>> listDeliveryAccountBookWithHttpInfo(String settle, Integer limit, Long from, Long to, String type) throws ApiException {
        okhttp3.Call localVarCall = listDeliveryAccountBookValidateBeforeCall(settle, limit, from, to, type, null);
        Type localVarReturnType = new com.google.common.reflect.TypeToken<List<FuturesAccountBook>>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call listDeliveryAccountBookAsync(String settle, Integer limit, Long from, Long to, String type, final ApiCallback<List<FuturesAccountBook>> _callback) throws ApiException {
        okhttp3.Call localVarCall = listDeliveryAccountBookValidateBeforeCall(settle, limit, from, to, type, _callback);
        Type localVarReturnType = new com.google.common.reflect.TypeToken<List<FuturesAccountBook>>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class APIlistDeliveryAccountBookRequest {
        private final String settle;
        private Integer limit;
        private Long from;
        private Long to;
        private String type;

        private APIlistDeliveryAccountBookRequest(String settle) {
            this.settle = settle;
        }

        /**
         * Set limit
         * @param limit Maximum number of records returned in one list (optional, default to 100)
         * @return APIlistDeliveryAccountBookRequest
         */
        public APIlistDeliveryAccountBookRequest limit(Integer limit) {
            this.limit = limit;
            return this;
        }

        /**
         * Set from
         * @param from Start timestamp (optional)
         * @return APIlistDeliveryAccountBookRequest
         */
        public APIlistDeliveryAccountBookRequest from(Long from) {
            this.from = from;
            return this;
        }

        /**
         * Set to
         * @param to End timestamp (optional)
         * @return APIlistDeliveryAccountBookRequest
         */
        public APIlistDeliveryAccountBookRequest to(Long to) {
            this.to = to;
            return this;
        }

        /**
         * Set type
         * @param type Changing Type: - dnw: Deposit &amp; Withdraw - pnl: Profit &amp; Loss by reducing position - fee: Trading fee - refr: Referrer rebate - fund: Funding - point_dnw: POINT Deposit &amp; Withdraw - point_fee: POINT Trading fee - point_refr: POINT Referrer rebate (optional)
         * @return APIlistDeliveryAccountBookRequest
         */
        public APIlistDeliveryAccountBookRequest type(String type) {
            this.type = type;
            return this;
        }

        /**
         * Build call for listDeliveryAccountBook
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
            return listDeliveryAccountBookCall(settle, limit, from, to, type, _callback);
        }

        /**
         * Execute listDeliveryAccountBook request
         * @return List&lt;FuturesAccountBook&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> List retrieved </td><td>  -  </td></tr>
         </table>
         */
        public List<FuturesAccountBook> execute() throws ApiException {
            ApiResponse<List<FuturesAccountBook>> localVarResp = listDeliveryAccountBookWithHttpInfo(settle, limit, from, to, type);
            return localVarResp.getData();
        }

        /**
         * Execute listDeliveryAccountBook request with HTTP info returned
         * @return ApiResponse&lt;List&lt;FuturesAccountBook&gt;&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> List retrieved </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<List<FuturesAccountBook>> executeWithHttpInfo() throws ApiException {
            return listDeliveryAccountBookWithHttpInfo(settle, limit, from, to, type);
        }

        /**
         * Execute listDeliveryAccountBook request (asynchronously)
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
            return listDeliveryAccountBookAsync(settle, limit, from, to, type, _callback);
        }
    }

    /**
     * Query account book
     * 
     * @param settle Settle currency (required)
     * @return APIlistDeliveryAccountBookRequest
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> List retrieved </td><td>  -  </td></tr>
     </table>
     */
    public APIlistDeliveryAccountBookRequest listDeliveryAccountBook(String settle) {
        return new APIlistDeliveryAccountBookRequest(settle);
    }

    /**
     * Build call for listDeliveryPositions
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
    public okhttp3.Call listDeliveryPositionsCall(String settle, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/delivery/{settle}/positions"
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
    private okhttp3.Call listDeliveryPositionsValidateBeforeCall(String settle, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'settle' is set
        if (settle == null) {
            throw new ApiException("Missing the required parameter 'settle' when calling listDeliveryPositions(Async)");
        }

        okhttp3.Call localVarCall = listDeliveryPositionsCall(settle, _callback);
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
    public List<Position> listDeliveryPositions(String settle) throws ApiException {
        ApiResponse<List<Position>> localVarResp = listDeliveryPositionsWithHttpInfo(settle);
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
    public ApiResponse<List<Position>> listDeliveryPositionsWithHttpInfo(String settle) throws ApiException {
        okhttp3.Call localVarCall = listDeliveryPositionsValidateBeforeCall(settle, null);
        Type localVarReturnType = new com.google.common.reflect.TypeToken<List<Position>>(){}.getType();
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
    public okhttp3.Call listDeliveryPositionsAsync(String settle, final ApiCallback<List<Position>> _callback) throws ApiException {
        okhttp3.Call localVarCall = listDeliveryPositionsValidateBeforeCall(settle, _callback);
        Type localVarReturnType = new com.google.common.reflect.TypeToken<List<Position>>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    /**
     * Build call for getDeliveryPosition
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
    public okhttp3.Call getDeliveryPositionCall(String settle, String contract, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/delivery/{settle}/positions/{contract}"
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
    private okhttp3.Call getDeliveryPositionValidateBeforeCall(String settle, String contract, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'settle' is set
        if (settle == null) {
            throw new ApiException("Missing the required parameter 'settle' when calling getDeliveryPosition(Async)");
        }

        // verify the required parameter 'contract' is set
        if (contract == null) {
            throw new ApiException("Missing the required parameter 'contract' when calling getDeliveryPosition(Async)");
        }

        okhttp3.Call localVarCall = getDeliveryPositionCall(settle, contract, _callback);
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
    public Position getDeliveryPosition(String settle, String contract) throws ApiException {
        ApiResponse<Position> localVarResp = getDeliveryPositionWithHttpInfo(settle, contract);
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
    public ApiResponse<Position> getDeliveryPositionWithHttpInfo(String settle, String contract) throws ApiException {
        okhttp3.Call localVarCall = getDeliveryPositionValidateBeforeCall(settle, contract, null);
        Type localVarReturnType = new com.google.common.reflect.TypeToken<Position>(){}.getType();
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
    public okhttp3.Call getDeliveryPositionAsync(String settle, String contract, final ApiCallback<Position> _callback) throws ApiException {
        okhttp3.Call localVarCall = getDeliveryPositionValidateBeforeCall(settle, contract, _callback);
        Type localVarReturnType = new com.google.common.reflect.TypeToken<Position>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    /**
     * Build call for updateDeliveryPositionMargin
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
    public okhttp3.Call updateDeliveryPositionMarginCall(String settle, String contract, String change, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/delivery/{settle}/positions/{contract}/margin"
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
    private okhttp3.Call updateDeliveryPositionMarginValidateBeforeCall(String settle, String contract, String change, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'settle' is set
        if (settle == null) {
            throw new ApiException("Missing the required parameter 'settle' when calling updateDeliveryPositionMargin(Async)");
        }

        // verify the required parameter 'contract' is set
        if (contract == null) {
            throw new ApiException("Missing the required parameter 'contract' when calling updateDeliveryPositionMargin(Async)");
        }

        // verify the required parameter 'change' is set
        if (change == null) {
            throw new ApiException("Missing the required parameter 'change' when calling updateDeliveryPositionMargin(Async)");
        }

        okhttp3.Call localVarCall = updateDeliveryPositionMarginCall(settle, contract, change, _callback);
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
    public Position updateDeliveryPositionMargin(String settle, String contract, String change) throws ApiException {
        ApiResponse<Position> localVarResp = updateDeliveryPositionMarginWithHttpInfo(settle, contract, change);
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
    public ApiResponse<Position> updateDeliveryPositionMarginWithHttpInfo(String settle, String contract, String change) throws ApiException {
        okhttp3.Call localVarCall = updateDeliveryPositionMarginValidateBeforeCall(settle, contract, change, null);
        Type localVarReturnType = new com.google.common.reflect.TypeToken<Position>(){}.getType();
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
    public okhttp3.Call updateDeliveryPositionMarginAsync(String settle, String contract, String change, final ApiCallback<Position> _callback) throws ApiException {
        okhttp3.Call localVarCall = updateDeliveryPositionMarginValidateBeforeCall(settle, contract, change, _callback);
        Type localVarReturnType = new com.google.common.reflect.TypeToken<Position>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    /**
     * Build call for updateDeliveryPositionLeverage
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
    public okhttp3.Call updateDeliveryPositionLeverageCall(String settle, String contract, String leverage, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/delivery/{settle}/positions/{contract}/leverage"
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
    private okhttp3.Call updateDeliveryPositionLeverageValidateBeforeCall(String settle, String contract, String leverage, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'settle' is set
        if (settle == null) {
            throw new ApiException("Missing the required parameter 'settle' when calling updateDeliveryPositionLeverage(Async)");
        }

        // verify the required parameter 'contract' is set
        if (contract == null) {
            throw new ApiException("Missing the required parameter 'contract' when calling updateDeliveryPositionLeverage(Async)");
        }

        // verify the required parameter 'leverage' is set
        if (leverage == null) {
            throw new ApiException("Missing the required parameter 'leverage' when calling updateDeliveryPositionLeverage(Async)");
        }

        okhttp3.Call localVarCall = updateDeliveryPositionLeverageCall(settle, contract, leverage, _callback);
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
    public Position updateDeliveryPositionLeverage(String settle, String contract, String leverage) throws ApiException {
        ApiResponse<Position> localVarResp = updateDeliveryPositionLeverageWithHttpInfo(settle, contract, leverage);
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
    public ApiResponse<Position> updateDeliveryPositionLeverageWithHttpInfo(String settle, String contract, String leverage) throws ApiException {
        okhttp3.Call localVarCall = updateDeliveryPositionLeverageValidateBeforeCall(settle, contract, leverage, null);
        Type localVarReturnType = new com.google.common.reflect.TypeToken<Position>(){}.getType();
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
    public okhttp3.Call updateDeliveryPositionLeverageAsync(String settle, String contract, String leverage, final ApiCallback<Position> _callback) throws ApiException {
        okhttp3.Call localVarCall = updateDeliveryPositionLeverageValidateBeforeCall(settle, contract, leverage, _callback);
        Type localVarReturnType = new com.google.common.reflect.TypeToken<Position>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    /**
     * Build call for updateDeliveryPositionRiskLimit
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
    public okhttp3.Call updateDeliveryPositionRiskLimitCall(String settle, String contract, String riskLimit, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/delivery/{settle}/positions/{contract}/risk_limit"
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
    private okhttp3.Call updateDeliveryPositionRiskLimitValidateBeforeCall(String settle, String contract, String riskLimit, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'settle' is set
        if (settle == null) {
            throw new ApiException("Missing the required parameter 'settle' when calling updateDeliveryPositionRiskLimit(Async)");
        }

        // verify the required parameter 'contract' is set
        if (contract == null) {
            throw new ApiException("Missing the required parameter 'contract' when calling updateDeliveryPositionRiskLimit(Async)");
        }

        // verify the required parameter 'riskLimit' is set
        if (riskLimit == null) {
            throw new ApiException("Missing the required parameter 'riskLimit' when calling updateDeliveryPositionRiskLimit(Async)");
        }

        okhttp3.Call localVarCall = updateDeliveryPositionRiskLimitCall(settle, contract, riskLimit, _callback);
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
    public Position updateDeliveryPositionRiskLimit(String settle, String contract, String riskLimit) throws ApiException {
        ApiResponse<Position> localVarResp = updateDeliveryPositionRiskLimitWithHttpInfo(settle, contract, riskLimit);
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
    public ApiResponse<Position> updateDeliveryPositionRiskLimitWithHttpInfo(String settle, String contract, String riskLimit) throws ApiException {
        okhttp3.Call localVarCall = updateDeliveryPositionRiskLimitValidateBeforeCall(settle, contract, riskLimit, null);
        Type localVarReturnType = new com.google.common.reflect.TypeToken<Position>(){}.getType();
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
    public okhttp3.Call updateDeliveryPositionRiskLimitAsync(String settle, String contract, String riskLimit, final ApiCallback<Position> _callback) throws ApiException {
        okhttp3.Call localVarCall = updateDeliveryPositionRiskLimitValidateBeforeCall(settle, contract, riskLimit, _callback);
        Type localVarReturnType = new com.google.common.reflect.TypeToken<Position>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    private okhttp3.Call listDeliveryOrdersCall(String settle, String status, String contract, Integer limit, Integer offset, String lastId, Integer countTotal, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/delivery/{settle}/orders"
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
    private okhttp3.Call listDeliveryOrdersValidateBeforeCall(String settle, String status, String contract, Integer limit, Integer offset, String lastId, Integer countTotal, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'settle' is set
        if (settle == null) {
            throw new ApiException("Missing the required parameter 'settle' when calling listDeliveryOrders(Async)");
        }

        // verify the required parameter 'status' is set
        if (status == null) {
            throw new ApiException("Missing the required parameter 'status' when calling listDeliveryOrders(Async)");
        }

        okhttp3.Call localVarCall = listDeliveryOrdersCall(settle, status, contract, limit, offset, lastId, countTotal, _callback);
        return localVarCall;
    }


    private ApiResponse<List<FuturesOrder>> listDeliveryOrdersWithHttpInfo(String settle, String status, String contract, Integer limit, Integer offset, String lastId, Integer countTotal) throws ApiException {
        okhttp3.Call localVarCall = listDeliveryOrdersValidateBeforeCall(settle, status, contract, limit, offset, lastId, countTotal, null);
        Type localVarReturnType = new com.google.common.reflect.TypeToken<List<FuturesOrder>>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call listDeliveryOrdersAsync(String settle, String status, String contract, Integer limit, Integer offset, String lastId, Integer countTotal, final ApiCallback<List<FuturesOrder>> _callback) throws ApiException {
        okhttp3.Call localVarCall = listDeliveryOrdersValidateBeforeCall(settle, status, contract, limit, offset, lastId, countTotal, _callback);
        Type localVarReturnType = new com.google.common.reflect.TypeToken<List<FuturesOrder>>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class APIlistDeliveryOrdersRequest {
        private final String settle;
        private final String status;
        private String contract;
        private Integer limit;
        private Integer offset;
        private String lastId;
        private Integer countTotal;

        private APIlistDeliveryOrdersRequest(String settle, String status) {
            this.settle = settle;
            this.status = status;
        }

        /**
         * Set contract
         * @param contract Futures contract (optional)
         * @return APIlistDeliveryOrdersRequest
         */
        public APIlistDeliveryOrdersRequest contract(String contract) {
            this.contract = contract;
            return this;
        }

        /**
         * Set limit
         * @param limit Maximum number of records returned in one list (optional, default to 100)
         * @return APIlistDeliveryOrdersRequest
         */
        public APIlistDeliveryOrdersRequest limit(Integer limit) {
            this.limit = limit;
            return this;
        }

        /**
         * Set offset
         * @param offset List offset, starting from 0 (optional, default to 0)
         * @return APIlistDeliveryOrdersRequest
         */
        public APIlistDeliveryOrdersRequest offset(Integer offset) {
            this.offset = offset;
            return this;
        }

        /**
         * Set lastId
         * @param lastId Specify list staring point using the &#x60;id&#x60; of last record in previous list-query results (optional)
         * @return APIlistDeliveryOrdersRequest
         */
        public APIlistDeliveryOrdersRequest lastId(String lastId) {
            this.lastId = lastId;
            return this;
        }

        /**
         * Set countTotal
         * @param countTotal Whether to return total number matched. Default to 0(no return) (optional, default to 0)
         * @return APIlistDeliveryOrdersRequest
         */
        public APIlistDeliveryOrdersRequest countTotal(Integer countTotal) {
            this.countTotal = countTotal;
            return this;
        }

        /**
         * Build call for listDeliveryOrders
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
            return listDeliveryOrdersCall(settle, status, contract, limit, offset, lastId, countTotal, _callback);
        }

        /**
         * Execute listDeliveryOrders request
         * @return List&lt;FuturesOrder&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> List retrieved </td><td>  * X-Pagination-Limit - Request limit specified <br>  * X-Pagination-Offset - Request offset specified <br>  * X-Pagination-Total - Total number matched. Only returned on &#x60;count_total&#x60; set to 1 <br>  </td></tr>
         </table>
         */
        public List<FuturesOrder> execute() throws ApiException {
            ApiResponse<List<FuturesOrder>> localVarResp = listDeliveryOrdersWithHttpInfo(settle, status, contract, limit, offset, lastId, countTotal);
            return localVarResp.getData();
        }

        /**
         * Execute listDeliveryOrders request with HTTP info returned
         * @return ApiResponse&lt;List&lt;FuturesOrder&gt;&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> List retrieved </td><td>  * X-Pagination-Limit - Request limit specified <br>  * X-Pagination-Offset - Request offset specified <br>  * X-Pagination-Total - Total number matched. Only returned on &#x60;count_total&#x60; set to 1 <br>  </td></tr>
         </table>
         */
        public ApiResponse<List<FuturesOrder>> executeWithHttpInfo() throws ApiException {
            return listDeliveryOrdersWithHttpInfo(settle, status, contract, limit, offset, lastId, countTotal);
        }

        /**
         * Execute listDeliveryOrders request (asynchronously)
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
            return listDeliveryOrdersAsync(settle, status, contract, limit, offset, lastId, countTotal, _callback);
        }
    }

    /**
     * List futures orders
     * Zero-fill order cannot be retrieved 60 seconds after cancellation
     * @param settle Settle currency (required)
     * @param status List orders based on status (required)
     * @return APIlistDeliveryOrdersRequest
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> List retrieved </td><td>  * X-Pagination-Limit - Request limit specified <br>  * X-Pagination-Offset - Request offset specified <br>  * X-Pagination-Total - Total number matched. Only returned on &#x60;count_total&#x60; set to 1 <br>  </td></tr>
     </table>
     */
    public APIlistDeliveryOrdersRequest listDeliveryOrders(String settle, String status) {
        return new APIlistDeliveryOrdersRequest(settle, status);
    }

    /**
     * Build call for createDeliveryOrder
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
    public okhttp3.Call createDeliveryOrderCall(String settle, FuturesOrder futuresOrder, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = futuresOrder;

        // create path and map variables
        String localVarPath = "/delivery/{settle}/orders"
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
    private okhttp3.Call createDeliveryOrderValidateBeforeCall(String settle, FuturesOrder futuresOrder, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'settle' is set
        if (settle == null) {
            throw new ApiException("Missing the required parameter 'settle' when calling createDeliveryOrder(Async)");
        }

        // verify the required parameter 'futuresOrder' is set
        if (futuresOrder == null) {
            throw new ApiException("Missing the required parameter 'futuresOrder' when calling createDeliveryOrder(Async)");
        }

        okhttp3.Call localVarCall = createDeliveryOrderCall(settle, futuresOrder, _callback);
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
    public FuturesOrder createDeliveryOrder(String settle, FuturesOrder futuresOrder) throws ApiException {
        ApiResponse<FuturesOrder> localVarResp = createDeliveryOrderWithHttpInfo(settle, futuresOrder);
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
    public ApiResponse<FuturesOrder> createDeliveryOrderWithHttpInfo(String settle, FuturesOrder futuresOrder) throws ApiException {
        okhttp3.Call localVarCall = createDeliveryOrderValidateBeforeCall(settle, futuresOrder, null);
        Type localVarReturnType = new com.google.common.reflect.TypeToken<FuturesOrder>(){}.getType();
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
    public okhttp3.Call createDeliveryOrderAsync(String settle, FuturesOrder futuresOrder, final ApiCallback<FuturesOrder> _callback) throws ApiException {
        okhttp3.Call localVarCall = createDeliveryOrderValidateBeforeCall(settle, futuresOrder, _callback);
        Type localVarReturnType = new com.google.common.reflect.TypeToken<FuturesOrder>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    /**
     * Build call for cancelDeliveryOrders
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
    public okhttp3.Call cancelDeliveryOrdersCall(String settle, String contract, String side, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/delivery/{settle}/orders"
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
    private okhttp3.Call cancelDeliveryOrdersValidateBeforeCall(String settle, String contract, String side, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'settle' is set
        if (settle == null) {
            throw new ApiException("Missing the required parameter 'settle' when calling cancelDeliveryOrders(Async)");
        }

        // verify the required parameter 'contract' is set
        if (contract == null) {
            throw new ApiException("Missing the required parameter 'contract' when calling cancelDeliveryOrders(Async)");
        }

        okhttp3.Call localVarCall = cancelDeliveryOrdersCall(settle, contract, side, _callback);
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
    public List<FuturesOrder> cancelDeliveryOrders(String settle, String contract, String side) throws ApiException {
        ApiResponse<List<FuturesOrder>> localVarResp = cancelDeliveryOrdersWithHttpInfo(settle, contract, side);
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
    public ApiResponse<List<FuturesOrder>> cancelDeliveryOrdersWithHttpInfo(String settle, String contract, String side) throws ApiException {
        okhttp3.Call localVarCall = cancelDeliveryOrdersValidateBeforeCall(settle, contract, side, null);
        Type localVarReturnType = new com.google.common.reflect.TypeToken<List<FuturesOrder>>(){}.getType();
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
    public okhttp3.Call cancelDeliveryOrdersAsync(String settle, String contract, String side, final ApiCallback<List<FuturesOrder>> _callback) throws ApiException {
        okhttp3.Call localVarCall = cancelDeliveryOrdersValidateBeforeCall(settle, contract, side, _callback);
        Type localVarReturnType = new com.google.common.reflect.TypeToken<List<FuturesOrder>>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    /**
     * Build call for getDeliveryOrder
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
    public okhttp3.Call getDeliveryOrderCall(String settle, String orderId, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/delivery/{settle}/orders/{order_id}"
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
    private okhttp3.Call getDeliveryOrderValidateBeforeCall(String settle, String orderId, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'settle' is set
        if (settle == null) {
            throw new ApiException("Missing the required parameter 'settle' when calling getDeliveryOrder(Async)");
        }

        // verify the required parameter 'orderId' is set
        if (orderId == null) {
            throw new ApiException("Missing the required parameter 'orderId' when calling getDeliveryOrder(Async)");
        }

        okhttp3.Call localVarCall = getDeliveryOrderCall(settle, orderId, _callback);
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
    public FuturesOrder getDeliveryOrder(String settle, String orderId) throws ApiException {
        ApiResponse<FuturesOrder> localVarResp = getDeliveryOrderWithHttpInfo(settle, orderId);
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
    public ApiResponse<FuturesOrder> getDeliveryOrderWithHttpInfo(String settle, String orderId) throws ApiException {
        okhttp3.Call localVarCall = getDeliveryOrderValidateBeforeCall(settle, orderId, null);
        Type localVarReturnType = new com.google.common.reflect.TypeToken<FuturesOrder>(){}.getType();
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
    public okhttp3.Call getDeliveryOrderAsync(String settle, String orderId, final ApiCallback<FuturesOrder> _callback) throws ApiException {
        okhttp3.Call localVarCall = getDeliveryOrderValidateBeforeCall(settle, orderId, _callback);
        Type localVarReturnType = new com.google.common.reflect.TypeToken<FuturesOrder>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    /**
     * Build call for cancelDeliveryOrder
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
    public okhttp3.Call cancelDeliveryOrderCall(String settle, String orderId, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/delivery/{settle}/orders/{order_id}"
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
    private okhttp3.Call cancelDeliveryOrderValidateBeforeCall(String settle, String orderId, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'settle' is set
        if (settle == null) {
            throw new ApiException("Missing the required parameter 'settle' when calling cancelDeliveryOrder(Async)");
        }

        // verify the required parameter 'orderId' is set
        if (orderId == null) {
            throw new ApiException("Missing the required parameter 'orderId' when calling cancelDeliveryOrder(Async)");
        }

        okhttp3.Call localVarCall = cancelDeliveryOrderCall(settle, orderId, _callback);
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
    public FuturesOrder cancelDeliveryOrder(String settle, String orderId) throws ApiException {
        ApiResponse<FuturesOrder> localVarResp = cancelDeliveryOrderWithHttpInfo(settle, orderId);
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
    public ApiResponse<FuturesOrder> cancelDeliveryOrderWithHttpInfo(String settle, String orderId) throws ApiException {
        okhttp3.Call localVarCall = cancelDeliveryOrderValidateBeforeCall(settle, orderId, null);
        Type localVarReturnType = new com.google.common.reflect.TypeToken<FuturesOrder>(){}.getType();
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
    public okhttp3.Call cancelDeliveryOrderAsync(String settle, String orderId, final ApiCallback<FuturesOrder> _callback) throws ApiException {
        okhttp3.Call localVarCall = cancelDeliveryOrderValidateBeforeCall(settle, orderId, _callback);
        Type localVarReturnType = new com.google.common.reflect.TypeToken<FuturesOrder>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    private okhttp3.Call getMyDeliveryTradesCall(String settle, String contract, Long order, Integer limit, Integer offset, String lastId, Integer countTotal, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/delivery/{settle}/my_trades"
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
    private okhttp3.Call getMyDeliveryTradesValidateBeforeCall(String settle, String contract, Long order, Integer limit, Integer offset, String lastId, Integer countTotal, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'settle' is set
        if (settle == null) {
            throw new ApiException("Missing the required parameter 'settle' when calling getMyDeliveryTrades(Async)");
        }

        okhttp3.Call localVarCall = getMyDeliveryTradesCall(settle, contract, order, limit, offset, lastId, countTotal, _callback);
        return localVarCall;
    }


    private ApiResponse<List<MyFuturesTrade>> getMyDeliveryTradesWithHttpInfo(String settle, String contract, Long order, Integer limit, Integer offset, String lastId, Integer countTotal) throws ApiException {
        okhttp3.Call localVarCall = getMyDeliveryTradesValidateBeforeCall(settle, contract, order, limit, offset, lastId, countTotal, null);
        Type localVarReturnType = new com.google.common.reflect.TypeToken<List<MyFuturesTrade>>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call getMyDeliveryTradesAsync(String settle, String contract, Long order, Integer limit, Integer offset, String lastId, Integer countTotal, final ApiCallback<List<MyFuturesTrade>> _callback) throws ApiException {
        okhttp3.Call localVarCall = getMyDeliveryTradesValidateBeforeCall(settle, contract, order, limit, offset, lastId, countTotal, _callback);
        Type localVarReturnType = new com.google.common.reflect.TypeToken<List<MyFuturesTrade>>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class APIgetMyDeliveryTradesRequest {
        private final String settle;
        private String contract;
        private Long order;
        private Integer limit;
        private Integer offset;
        private String lastId;
        private Integer countTotal;

        private APIgetMyDeliveryTradesRequest(String settle) {
            this.settle = settle;
        }

        /**
         * Set contract
         * @param contract Futures contract (optional)
         * @return APIgetMyDeliveryTradesRequest
         */
        public APIgetMyDeliveryTradesRequest contract(String contract) {
            this.contract = contract;
            return this;
        }

        /**
         * Set order
         * @param order Futures order ID, return related data only if specified (optional)
         * @return APIgetMyDeliveryTradesRequest
         */
        public APIgetMyDeliveryTradesRequest order(Long order) {
            this.order = order;
            return this;
        }

        /**
         * Set limit
         * @param limit Maximum number of records returned in one list (optional, default to 100)
         * @return APIgetMyDeliveryTradesRequest
         */
        public APIgetMyDeliveryTradesRequest limit(Integer limit) {
            this.limit = limit;
            return this;
        }

        /**
         * Set offset
         * @param offset List offset, starting from 0 (optional, default to 0)
         * @return APIgetMyDeliveryTradesRequest
         */
        public APIgetMyDeliveryTradesRequest offset(Integer offset) {
            this.offset = offset;
            return this;
        }

        /**
         * Set lastId
         * @param lastId Specify list staring point using the &#x60;id&#x60; of last record in previous list-query results (optional)
         * @return APIgetMyDeliveryTradesRequest
         */
        public APIgetMyDeliveryTradesRequest lastId(String lastId) {
            this.lastId = lastId;
            return this;
        }

        /**
         * Set countTotal
         * @param countTotal Whether to return total number matched. Default to 0(no return) (optional, default to 0)
         * @return APIgetMyDeliveryTradesRequest
         */
        public APIgetMyDeliveryTradesRequest countTotal(Integer countTotal) {
            this.countTotal = countTotal;
            return this;
        }

        /**
         * Build call for getMyDeliveryTrades
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
            return getMyDeliveryTradesCall(settle, contract, order, limit, offset, lastId, countTotal, _callback);
        }

        /**
         * Execute getMyDeliveryTrades request
         * @return List&lt;MyFuturesTrade&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> List retrieved </td><td>  * X-Pagination-Limit - Request limit specified <br>  * X-Pagination-Offset - Request offset specified <br>  * X-Pagination-Total - Total number matched. Only returned on &#x60;count_total&#x60; set to 1 <br>  </td></tr>
         </table>
         */
        public List<MyFuturesTrade> execute() throws ApiException {
            ApiResponse<List<MyFuturesTrade>> localVarResp = getMyDeliveryTradesWithHttpInfo(settle, contract, order, limit, offset, lastId, countTotal);
            return localVarResp.getData();
        }

        /**
         * Execute getMyDeliveryTrades request with HTTP info returned
         * @return ApiResponse&lt;List&lt;MyFuturesTrade&gt;&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> List retrieved </td><td>  * X-Pagination-Limit - Request limit specified <br>  * X-Pagination-Offset - Request offset specified <br>  * X-Pagination-Total - Total number matched. Only returned on &#x60;count_total&#x60; set to 1 <br>  </td></tr>
         </table>
         */
        public ApiResponse<List<MyFuturesTrade>> executeWithHttpInfo() throws ApiException {
            return getMyDeliveryTradesWithHttpInfo(settle, contract, order, limit, offset, lastId, countTotal);
        }

        /**
         * Execute getMyDeliveryTrades request (asynchronously)
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
            return getMyDeliveryTradesAsync(settle, contract, order, limit, offset, lastId, countTotal, _callback);
        }
    }

    /**
     * List personal trading history
     * 
     * @param settle Settle currency (required)
     * @return APIgetMyDeliveryTradesRequest
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> List retrieved </td><td>  * X-Pagination-Limit - Request limit specified <br>  * X-Pagination-Offset - Request offset specified <br>  * X-Pagination-Total - Total number matched. Only returned on &#x60;count_total&#x60; set to 1 <br>  </td></tr>
     </table>
     */
    public APIgetMyDeliveryTradesRequest getMyDeliveryTrades(String settle) {
        return new APIgetMyDeliveryTradesRequest(settle);
    }

    private okhttp3.Call listDeliveryPositionCloseCall(String settle, String contract, Integer limit, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/delivery/{settle}/position_close"
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
    private okhttp3.Call listDeliveryPositionCloseValidateBeforeCall(String settle, String contract, Integer limit, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'settle' is set
        if (settle == null) {
            throw new ApiException("Missing the required parameter 'settle' when calling listDeliveryPositionClose(Async)");
        }

        okhttp3.Call localVarCall = listDeliveryPositionCloseCall(settle, contract, limit, _callback);
        return localVarCall;
    }


    private ApiResponse<List<PositionClose>> listDeliveryPositionCloseWithHttpInfo(String settle, String contract, Integer limit) throws ApiException {
        okhttp3.Call localVarCall = listDeliveryPositionCloseValidateBeforeCall(settle, contract, limit, null);
        Type localVarReturnType = new com.google.common.reflect.TypeToken<List<PositionClose>>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call listDeliveryPositionCloseAsync(String settle, String contract, Integer limit, final ApiCallback<List<PositionClose>> _callback) throws ApiException {
        okhttp3.Call localVarCall = listDeliveryPositionCloseValidateBeforeCall(settle, contract, limit, _callback);
        Type localVarReturnType = new com.google.common.reflect.TypeToken<List<PositionClose>>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class APIlistDeliveryPositionCloseRequest {
        private final String settle;
        private String contract;
        private Integer limit;

        private APIlistDeliveryPositionCloseRequest(String settle) {
            this.settle = settle;
        }

        /**
         * Set contract
         * @param contract Futures contract (optional)
         * @return APIlistDeliveryPositionCloseRequest
         */
        public APIlistDeliveryPositionCloseRequest contract(String contract) {
            this.contract = contract;
            return this;
        }

        /**
         * Set limit
         * @param limit Maximum number of records returned in one list (optional, default to 100)
         * @return APIlistDeliveryPositionCloseRequest
         */
        public APIlistDeliveryPositionCloseRequest limit(Integer limit) {
            this.limit = limit;
            return this;
        }

        /**
         * Build call for listDeliveryPositionClose
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
            return listDeliveryPositionCloseCall(settle, contract, limit, _callback);
        }

        /**
         * Execute listDeliveryPositionClose request
         * @return List&lt;PositionClose&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> List retrieved </td><td>  -  </td></tr>
         </table>
         */
        public List<PositionClose> execute() throws ApiException {
            ApiResponse<List<PositionClose>> localVarResp = listDeliveryPositionCloseWithHttpInfo(settle, contract, limit);
            return localVarResp.getData();
        }

        /**
         * Execute listDeliveryPositionClose request with HTTP info returned
         * @return ApiResponse&lt;List&lt;PositionClose&gt;&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> List retrieved </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<List<PositionClose>> executeWithHttpInfo() throws ApiException {
            return listDeliveryPositionCloseWithHttpInfo(settle, contract, limit);
        }

        /**
         * Execute listDeliveryPositionClose request (asynchronously)
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
            return listDeliveryPositionCloseAsync(settle, contract, limit, _callback);
        }
    }

    /**
     * List position close history
     * 
     * @param settle Settle currency (required)
     * @return APIlistDeliveryPositionCloseRequest
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> List retrieved </td><td>  -  </td></tr>
     </table>
     */
    public APIlistDeliveryPositionCloseRequest listDeliveryPositionClose(String settle) {
        return new APIlistDeliveryPositionCloseRequest(settle);
    }

    private okhttp3.Call listDeliveryLiquidatesCall(String settle, String contract, Integer limit, Integer at, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/delivery/{settle}/liquidates"
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
    private okhttp3.Call listDeliveryLiquidatesValidateBeforeCall(String settle, String contract, Integer limit, Integer at, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'settle' is set
        if (settle == null) {
            throw new ApiException("Missing the required parameter 'settle' when calling listDeliveryLiquidates(Async)");
        }

        okhttp3.Call localVarCall = listDeliveryLiquidatesCall(settle, contract, limit, at, _callback);
        return localVarCall;
    }


    private ApiResponse<List<FuturesLiquidate>> listDeliveryLiquidatesWithHttpInfo(String settle, String contract, Integer limit, Integer at) throws ApiException {
        okhttp3.Call localVarCall = listDeliveryLiquidatesValidateBeforeCall(settle, contract, limit, at, null);
        Type localVarReturnType = new com.google.common.reflect.TypeToken<List<FuturesLiquidate>>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call listDeliveryLiquidatesAsync(String settle, String contract, Integer limit, Integer at, final ApiCallback<List<FuturesLiquidate>> _callback) throws ApiException {
        okhttp3.Call localVarCall = listDeliveryLiquidatesValidateBeforeCall(settle, contract, limit, at, _callback);
        Type localVarReturnType = new com.google.common.reflect.TypeToken<List<FuturesLiquidate>>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class APIlistDeliveryLiquidatesRequest {
        private final String settle;
        private String contract;
        private Integer limit;
        private Integer at;

        private APIlistDeliveryLiquidatesRequest(String settle) {
            this.settle = settle;
        }

        /**
         * Set contract
         * @param contract Futures contract (optional)
         * @return APIlistDeliveryLiquidatesRequest
         */
        public APIlistDeliveryLiquidatesRequest contract(String contract) {
            this.contract = contract;
            return this;
        }

        /**
         * Set limit
         * @param limit Maximum number of records returned in one list (optional, default to 100)
         * @return APIlistDeliveryLiquidatesRequest
         */
        public APIlistDeliveryLiquidatesRequest limit(Integer limit) {
            this.limit = limit;
            return this;
        }

        /**
         * Set at
         * @param at Specify a liquidation timestamp (optional, default to 0)
         * @return APIlistDeliveryLiquidatesRequest
         */
        public APIlistDeliveryLiquidatesRequest at(Integer at) {
            this.at = at;
            return this;
        }

        /**
         * Build call for listDeliveryLiquidates
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
            return listDeliveryLiquidatesCall(settle, contract, limit, at, _callback);
        }

        /**
         * Execute listDeliveryLiquidates request
         * @return List&lt;FuturesLiquidate&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> List retrieved </td><td>  -  </td></tr>
         </table>
         */
        public List<FuturesLiquidate> execute() throws ApiException {
            ApiResponse<List<FuturesLiquidate>> localVarResp = listDeliveryLiquidatesWithHttpInfo(settle, contract, limit, at);
            return localVarResp.getData();
        }

        /**
         * Execute listDeliveryLiquidates request with HTTP info returned
         * @return ApiResponse&lt;List&lt;FuturesLiquidate&gt;&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> List retrieved </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<List<FuturesLiquidate>> executeWithHttpInfo() throws ApiException {
            return listDeliveryLiquidatesWithHttpInfo(settle, contract, limit, at);
        }

        /**
         * Execute listDeliveryLiquidates request (asynchronously)
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
            return listDeliveryLiquidatesAsync(settle, contract, limit, at, _callback);
        }
    }

    /**
     * List liquidation history
     * 
     * @param settle Settle currency (required)
     * @return APIlistDeliveryLiquidatesRequest
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> List retrieved </td><td>  -  </td></tr>
     </table>
     */
    public APIlistDeliveryLiquidatesRequest listDeliveryLiquidates(String settle) {
        return new APIlistDeliveryLiquidatesRequest(settle);
    }

    private okhttp3.Call listDeliverySettlementsCall(String settle, String contract, Integer limit, Integer at, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/delivery/{settle}/settlements"
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
    private okhttp3.Call listDeliverySettlementsValidateBeforeCall(String settle, String contract, Integer limit, Integer at, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'settle' is set
        if (settle == null) {
            throw new ApiException("Missing the required parameter 'settle' when calling listDeliverySettlements(Async)");
        }

        okhttp3.Call localVarCall = listDeliverySettlementsCall(settle, contract, limit, at, _callback);
        return localVarCall;
    }


    private ApiResponse<List<DeliverySettlement>> listDeliverySettlementsWithHttpInfo(String settle, String contract, Integer limit, Integer at) throws ApiException {
        okhttp3.Call localVarCall = listDeliverySettlementsValidateBeforeCall(settle, contract, limit, at, null);
        Type localVarReturnType = new com.google.common.reflect.TypeToken<List<DeliverySettlement>>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call listDeliverySettlementsAsync(String settle, String contract, Integer limit, Integer at, final ApiCallback<List<DeliverySettlement>> _callback) throws ApiException {
        okhttp3.Call localVarCall = listDeliverySettlementsValidateBeforeCall(settle, contract, limit, at, _callback);
        Type localVarReturnType = new com.google.common.reflect.TypeToken<List<DeliverySettlement>>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class APIlistDeliverySettlementsRequest {
        private final String settle;
        private String contract;
        private Integer limit;
        private Integer at;

        private APIlistDeliverySettlementsRequest(String settle) {
            this.settle = settle;
        }

        /**
         * Set contract
         * @param contract Futures contract (optional)
         * @return APIlistDeliverySettlementsRequest
         */
        public APIlistDeliverySettlementsRequest contract(String contract) {
            this.contract = contract;
            return this;
        }

        /**
         * Set limit
         * @param limit Maximum number of records returned in one list (optional, default to 100)
         * @return APIlistDeliverySettlementsRequest
         */
        public APIlistDeliverySettlementsRequest limit(Integer limit) {
            this.limit = limit;
            return this;
        }

        /**
         * Set at
         * @param at Specify a settlement timestamp (optional, default to 0)
         * @return APIlistDeliverySettlementsRequest
         */
        public APIlistDeliverySettlementsRequest at(Integer at) {
            this.at = at;
            return this;
        }

        /**
         * Build call for listDeliverySettlements
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
            return listDeliverySettlementsCall(settle, contract, limit, at, _callback);
        }

        /**
         * Execute listDeliverySettlements request
         * @return List&lt;DeliverySettlement&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> List retrieved </td><td>  -  </td></tr>
         </table>
         */
        public List<DeliverySettlement> execute() throws ApiException {
            ApiResponse<List<DeliverySettlement>> localVarResp = listDeliverySettlementsWithHttpInfo(settle, contract, limit, at);
            return localVarResp.getData();
        }

        /**
         * Execute listDeliverySettlements request with HTTP info returned
         * @return ApiResponse&lt;List&lt;DeliverySettlement&gt;&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> List retrieved </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<List<DeliverySettlement>> executeWithHttpInfo() throws ApiException {
            return listDeliverySettlementsWithHttpInfo(settle, contract, limit, at);
        }

        /**
         * Execute listDeliverySettlements request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> List retrieved </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<List<DeliverySettlement>> _callback) throws ApiException {
            return listDeliverySettlementsAsync(settle, contract, limit, at, _callback);
        }
    }

    /**
     * List settlement history
     * 
     * @param settle Settle currency (required)
     * @return APIlistDeliverySettlementsRequest
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> List retrieved </td><td>  -  </td></tr>
     </table>
     */
    public APIlistDeliverySettlementsRequest listDeliverySettlements(String settle) {
        return new APIlistDeliverySettlementsRequest(settle);
    }

    private okhttp3.Call listPriceTriggeredDeliveryOrdersCall(String settle, String status, String contract, Integer limit, Integer offset, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/delivery/{settle}/price_orders"
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
    private okhttp3.Call listPriceTriggeredDeliveryOrdersValidateBeforeCall(String settle, String status, String contract, Integer limit, Integer offset, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'settle' is set
        if (settle == null) {
            throw new ApiException("Missing the required parameter 'settle' when calling listPriceTriggeredDeliveryOrders(Async)");
        }

        // verify the required parameter 'status' is set
        if (status == null) {
            throw new ApiException("Missing the required parameter 'status' when calling listPriceTriggeredDeliveryOrders(Async)");
        }

        okhttp3.Call localVarCall = listPriceTriggeredDeliveryOrdersCall(settle, status, contract, limit, offset, _callback);
        return localVarCall;
    }


    private ApiResponse<List<FuturesPriceTriggeredOrder>> listPriceTriggeredDeliveryOrdersWithHttpInfo(String settle, String status, String contract, Integer limit, Integer offset) throws ApiException {
        okhttp3.Call localVarCall = listPriceTriggeredDeliveryOrdersValidateBeforeCall(settle, status, contract, limit, offset, null);
        Type localVarReturnType = new com.google.common.reflect.TypeToken<List<FuturesPriceTriggeredOrder>>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call listPriceTriggeredDeliveryOrdersAsync(String settle, String status, String contract, Integer limit, Integer offset, final ApiCallback<List<FuturesPriceTriggeredOrder>> _callback) throws ApiException {
        okhttp3.Call localVarCall = listPriceTriggeredDeliveryOrdersValidateBeforeCall(settle, status, contract, limit, offset, _callback);
        Type localVarReturnType = new com.google.common.reflect.TypeToken<List<FuturesPriceTriggeredOrder>>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class APIlistPriceTriggeredDeliveryOrdersRequest {
        private final String settle;
        private final String status;
        private String contract;
        private Integer limit;
        private Integer offset;

        private APIlistPriceTriggeredDeliveryOrdersRequest(String settle, String status) {
            this.settle = settle;
            this.status = status;
        }

        /**
         * Set contract
         * @param contract Futures contract, return related data only if specified (optional)
         * @return APIlistPriceTriggeredDeliveryOrdersRequest
         */
        public APIlistPriceTriggeredDeliveryOrdersRequest contract(String contract) {
            this.contract = contract;
            return this;
        }

        /**
         * Set limit
         * @param limit Maximum number of records returned in one list (optional, default to 100)
         * @return APIlistPriceTriggeredDeliveryOrdersRequest
         */
        public APIlistPriceTriggeredDeliveryOrdersRequest limit(Integer limit) {
            this.limit = limit;
            return this;
        }

        /**
         * Set offset
         * @param offset List offset, starting from 0 (optional, default to 0)
         * @return APIlistPriceTriggeredDeliveryOrdersRequest
         */
        public APIlistPriceTriggeredDeliveryOrdersRequest offset(Integer offset) {
            this.offset = offset;
            return this;
        }

        /**
         * Build call for listPriceTriggeredDeliveryOrders
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
            return listPriceTriggeredDeliveryOrdersCall(settle, status, contract, limit, offset, _callback);
        }

        /**
         * Execute listPriceTriggeredDeliveryOrders request
         * @return List&lt;FuturesPriceTriggeredOrder&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> List retrieved </td><td>  -  </td></tr>
         </table>
         */
        public List<FuturesPriceTriggeredOrder> execute() throws ApiException {
            ApiResponse<List<FuturesPriceTriggeredOrder>> localVarResp = listPriceTriggeredDeliveryOrdersWithHttpInfo(settle, status, contract, limit, offset);
            return localVarResp.getData();
        }

        /**
         * Execute listPriceTriggeredDeliveryOrders request with HTTP info returned
         * @return ApiResponse&lt;List&lt;FuturesPriceTriggeredOrder&gt;&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> List retrieved </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<List<FuturesPriceTriggeredOrder>> executeWithHttpInfo() throws ApiException {
            return listPriceTriggeredDeliveryOrdersWithHttpInfo(settle, status, contract, limit, offset);
        }

        /**
         * Execute listPriceTriggeredDeliveryOrders request (asynchronously)
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
            return listPriceTriggeredDeliveryOrdersAsync(settle, status, contract, limit, offset, _callback);
        }
    }

    /**
     * List all auto orders
     * 
     * @param settle Settle currency (required)
     * @param status List orders based on status (required)
     * @return APIlistPriceTriggeredDeliveryOrdersRequest
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> List retrieved </td><td>  -  </td></tr>
     </table>
     */
    public APIlistPriceTriggeredDeliveryOrdersRequest listPriceTriggeredDeliveryOrders(String settle, String status) {
        return new APIlistPriceTriggeredDeliveryOrdersRequest(settle, status);
    }

    /**
     * Build call for createPriceTriggeredDeliveryOrder
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
    public okhttp3.Call createPriceTriggeredDeliveryOrderCall(String settle, FuturesPriceTriggeredOrder futuresPriceTriggeredOrder, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = futuresPriceTriggeredOrder;

        // create path and map variables
        String localVarPath = "/delivery/{settle}/price_orders"
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
    private okhttp3.Call createPriceTriggeredDeliveryOrderValidateBeforeCall(String settle, FuturesPriceTriggeredOrder futuresPriceTriggeredOrder, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'settle' is set
        if (settle == null) {
            throw new ApiException("Missing the required parameter 'settle' when calling createPriceTriggeredDeliveryOrder(Async)");
        }

        // verify the required parameter 'futuresPriceTriggeredOrder' is set
        if (futuresPriceTriggeredOrder == null) {
            throw new ApiException("Missing the required parameter 'futuresPriceTriggeredOrder' when calling createPriceTriggeredDeliveryOrder(Async)");
        }

        okhttp3.Call localVarCall = createPriceTriggeredDeliveryOrderCall(settle, futuresPriceTriggeredOrder, _callback);
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
    public TriggerOrderResponse createPriceTriggeredDeliveryOrder(String settle, FuturesPriceTriggeredOrder futuresPriceTriggeredOrder) throws ApiException {
        ApiResponse<TriggerOrderResponse> localVarResp = createPriceTriggeredDeliveryOrderWithHttpInfo(settle, futuresPriceTriggeredOrder);
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
    public ApiResponse<TriggerOrderResponse> createPriceTriggeredDeliveryOrderWithHttpInfo(String settle, FuturesPriceTriggeredOrder futuresPriceTriggeredOrder) throws ApiException {
        okhttp3.Call localVarCall = createPriceTriggeredDeliveryOrderValidateBeforeCall(settle, futuresPriceTriggeredOrder, null);
        Type localVarReturnType = new com.google.common.reflect.TypeToken<TriggerOrderResponse>(){}.getType();
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
    public okhttp3.Call createPriceTriggeredDeliveryOrderAsync(String settle, FuturesPriceTriggeredOrder futuresPriceTriggeredOrder, final ApiCallback<TriggerOrderResponse> _callback) throws ApiException {
        okhttp3.Call localVarCall = createPriceTriggeredDeliveryOrderValidateBeforeCall(settle, futuresPriceTriggeredOrder, _callback);
        Type localVarReturnType = new com.google.common.reflect.TypeToken<TriggerOrderResponse>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    /**
     * Build call for cancelPriceTriggeredDeliveryOrderList
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
    public okhttp3.Call cancelPriceTriggeredDeliveryOrderListCall(String settle, String contract, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/delivery/{settle}/price_orders"
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
    private okhttp3.Call cancelPriceTriggeredDeliveryOrderListValidateBeforeCall(String settle, String contract, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'settle' is set
        if (settle == null) {
            throw new ApiException("Missing the required parameter 'settle' when calling cancelPriceTriggeredDeliveryOrderList(Async)");
        }

        // verify the required parameter 'contract' is set
        if (contract == null) {
            throw new ApiException("Missing the required parameter 'contract' when calling cancelPriceTriggeredDeliveryOrderList(Async)");
        }

        okhttp3.Call localVarCall = cancelPriceTriggeredDeliveryOrderListCall(settle, contract, _callback);
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
    public List<FuturesPriceTriggeredOrder> cancelPriceTriggeredDeliveryOrderList(String settle, String contract) throws ApiException {
        ApiResponse<List<FuturesPriceTriggeredOrder>> localVarResp = cancelPriceTriggeredDeliveryOrderListWithHttpInfo(settle, contract);
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
    public ApiResponse<List<FuturesPriceTriggeredOrder>> cancelPriceTriggeredDeliveryOrderListWithHttpInfo(String settle, String contract) throws ApiException {
        okhttp3.Call localVarCall = cancelPriceTriggeredDeliveryOrderListValidateBeforeCall(settle, contract, null);
        Type localVarReturnType = new com.google.common.reflect.TypeToken<List<FuturesPriceTriggeredOrder>>(){}.getType();
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
    public okhttp3.Call cancelPriceTriggeredDeliveryOrderListAsync(String settle, String contract, final ApiCallback<List<FuturesPriceTriggeredOrder>> _callback) throws ApiException {
        okhttp3.Call localVarCall = cancelPriceTriggeredDeliveryOrderListValidateBeforeCall(settle, contract, _callback);
        Type localVarReturnType = new com.google.common.reflect.TypeToken<List<FuturesPriceTriggeredOrder>>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    /**
     * Build call for getPriceTriggeredDeliveryOrder
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
    public okhttp3.Call getPriceTriggeredDeliveryOrderCall(String settle, String orderId, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/delivery/{settle}/price_orders/{order_id}"
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
    private okhttp3.Call getPriceTriggeredDeliveryOrderValidateBeforeCall(String settle, String orderId, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'settle' is set
        if (settle == null) {
            throw new ApiException("Missing the required parameter 'settle' when calling getPriceTriggeredDeliveryOrder(Async)");
        }

        // verify the required parameter 'orderId' is set
        if (orderId == null) {
            throw new ApiException("Missing the required parameter 'orderId' when calling getPriceTriggeredDeliveryOrder(Async)");
        }

        okhttp3.Call localVarCall = getPriceTriggeredDeliveryOrderCall(settle, orderId, _callback);
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
    public FuturesPriceTriggeredOrder getPriceTriggeredDeliveryOrder(String settle, String orderId) throws ApiException {
        ApiResponse<FuturesPriceTriggeredOrder> localVarResp = getPriceTriggeredDeliveryOrderWithHttpInfo(settle, orderId);
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
    public ApiResponse<FuturesPriceTriggeredOrder> getPriceTriggeredDeliveryOrderWithHttpInfo(String settle, String orderId) throws ApiException {
        okhttp3.Call localVarCall = getPriceTriggeredDeliveryOrderValidateBeforeCall(settle, orderId, null);
        Type localVarReturnType = new com.google.common.reflect.TypeToken<FuturesPriceTriggeredOrder>(){}.getType();
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
    public okhttp3.Call getPriceTriggeredDeliveryOrderAsync(String settle, String orderId, final ApiCallback<FuturesPriceTriggeredOrder> _callback) throws ApiException {
        okhttp3.Call localVarCall = getPriceTriggeredDeliveryOrderValidateBeforeCall(settle, orderId, _callback);
        Type localVarReturnType = new com.google.common.reflect.TypeToken<FuturesPriceTriggeredOrder>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    /**
     * Build call for cancelPriceTriggeredDeliveryOrder
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
    public okhttp3.Call cancelPriceTriggeredDeliveryOrderCall(String settle, String orderId, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/delivery/{settle}/price_orders/{order_id}"
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
    private okhttp3.Call cancelPriceTriggeredDeliveryOrderValidateBeforeCall(String settle, String orderId, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'settle' is set
        if (settle == null) {
            throw new ApiException("Missing the required parameter 'settle' when calling cancelPriceTriggeredDeliveryOrder(Async)");
        }

        // verify the required parameter 'orderId' is set
        if (orderId == null) {
            throw new ApiException("Missing the required parameter 'orderId' when calling cancelPriceTriggeredDeliveryOrder(Async)");
        }

        okhttp3.Call localVarCall = cancelPriceTriggeredDeliveryOrderCall(settle, orderId, _callback);
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
    public FuturesPriceTriggeredOrder cancelPriceTriggeredDeliveryOrder(String settle, String orderId) throws ApiException {
        ApiResponse<FuturesPriceTriggeredOrder> localVarResp = cancelPriceTriggeredDeliveryOrderWithHttpInfo(settle, orderId);
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
    public ApiResponse<FuturesPriceTriggeredOrder> cancelPriceTriggeredDeliveryOrderWithHttpInfo(String settle, String orderId) throws ApiException {
        okhttp3.Call localVarCall = cancelPriceTriggeredDeliveryOrderValidateBeforeCall(settle, orderId, null);
        Type localVarReturnType = new com.google.common.reflect.TypeToken<FuturesPriceTriggeredOrder>(){}.getType();
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
    public okhttp3.Call cancelPriceTriggeredDeliveryOrderAsync(String settle, String orderId, final ApiCallback<FuturesPriceTriggeredOrder> _callback) throws ApiException {
        okhttp3.Call localVarCall = cancelPriceTriggeredDeliveryOrderValidateBeforeCall(settle, orderId, _callback);
        Type localVarReturnType = new TypeToken<FuturesPriceTriggeredOrder>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

}
