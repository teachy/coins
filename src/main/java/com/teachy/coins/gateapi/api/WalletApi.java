


package com.teachy.coins.gateapi.api;

import com.teachy.coins.gateapi.ApiCallback;
import com.teachy.coins.gateapi.ApiClient;
import com.teachy.coins.gateapi.ApiException;
import com.teachy.coins.gateapi.ApiResponse;
import com.teachy.coins.gateapi.Configuration;
import com.teachy.coins.gateapi.Pair;

import com.google.gson.reflect.TypeToken;


import com.teachy.coins.gateapi.models.DepositAddress;
import com.teachy.coins.gateapi.models.LedgerRecord;
import com.teachy.coins.gateapi.models.SubAccountTransfer;
import com.teachy.coins.gateapi.models.Transfer;
import com.teachy.coins.gateapi.models.WithdrawStatus;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WalletApi {
    private ApiClient localVarApiClient;

    public WalletApi() {
        this(Configuration.getDefaultApiClient());
    }

    public WalletApi(ApiClient apiClient) {
        this.localVarApiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return localVarApiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.localVarApiClient = apiClient;
    }

    /**
     * Build call for getDepositAddress
     * @param currency Currency name (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Address successfully generated </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call getDepositAddressCall(String currency, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/wallet/deposit_address";

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
    private okhttp3.Call getDepositAddressValidateBeforeCall(String currency, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'currency' is set
        if (currency == null) {
            throw new ApiException("Missing the required parameter 'currency' when calling getDepositAddress(Async)");
        }

        okhttp3.Call localVarCall = getDepositAddressCall(currency, _callback);
        return localVarCall;
    }

    /**
     * Generate currency deposit address
     * 
     * @param currency Currency name (required)
     * @return DepositAddress
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Address successfully generated </td><td>  -  </td></tr>
     </table>
     */
    public DepositAddress getDepositAddress(String currency) throws ApiException {
        ApiResponse<DepositAddress> localVarResp = getDepositAddressWithHttpInfo(currency);
        return localVarResp.getData();
    }

    /**
     * Generate currency deposit address
     * 
     * @param currency Currency name (required)
     * @return ApiResponse&lt;DepositAddress&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Address successfully generated </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<DepositAddress> getDepositAddressWithHttpInfo(String currency) throws ApiException {
        okhttp3.Call localVarCall = getDepositAddressValidateBeforeCall(currency, null);
        Type localVarReturnType = new TypeToken<DepositAddress>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Generate currency deposit address (asynchronously)
     * 
     * @param currency Currency name (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Address successfully generated </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call getDepositAddressAsync(String currency, final ApiCallback<DepositAddress> _callback) throws ApiException {
        okhttp3.Call localVarCall = getDepositAddressValidateBeforeCall(currency, _callback);
        Type localVarReturnType = new TypeToken<DepositAddress>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    private okhttp3.Call listWithdrawalsCall(String currency, Long from, Long to, Integer limit, Integer offset, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/wallet/withdrawals";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (currency != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("currency", currency));
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
    private okhttp3.Call listWithdrawalsValidateBeforeCall(String currency, Long from, Long to, Integer limit, Integer offset, final ApiCallback _callback) throws ApiException {
        okhttp3.Call localVarCall = listWithdrawalsCall(currency, from, to, limit, offset, _callback);
        return localVarCall;
    }


    private ApiResponse<List<LedgerRecord>> listWithdrawalsWithHttpInfo(String currency, Long from, Long to, Integer limit, Integer offset) throws ApiException {
        okhttp3.Call localVarCall = listWithdrawalsValidateBeforeCall(currency, from, to, limit, offset, null);
        Type localVarReturnType = new TypeToken<List<LedgerRecord>>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call listWithdrawalsAsync(String currency, Long from, Long to, Integer limit, Integer offset, final ApiCallback<List<LedgerRecord>> _callback) throws ApiException {
        okhttp3.Call localVarCall = listWithdrawalsValidateBeforeCall(currency, from, to, limit, offset, _callback);
        Type localVarReturnType = new TypeToken<List<LedgerRecord>>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class APIlistWithdrawalsRequest {
        private String currency;
        private Long from;
        private Long to;
        private Integer limit;
        private Integer offset;

        private APIlistWithdrawalsRequest() {
        }

        /**
         * Set currency
         * @param currency Filter by currency. Return all currency records if not specified (optional)
         * @return APIlistWithdrawalsRequest
         */
        public APIlistWithdrawalsRequest currency(String currency) {
            this.currency = currency;
            return this;
        }

        /**
         * Set from
         * @param from Time range beginning, default to 7 days before current time (optional)
         * @return APIlistWithdrawalsRequest
         */
        public APIlistWithdrawalsRequest from(Long from) {
            this.from = from;
            return this;
        }

        /**
         * Set to
         * @param to Time range ending, default to current time (optional)
         * @return APIlistWithdrawalsRequest
         */
        public APIlistWithdrawalsRequest to(Long to) {
            this.to = to;
            return this;
        }

        /**
         * Set limit
         * @param limit Maximum number of records returned in one list (optional, default to 100)
         * @return APIlistWithdrawalsRequest
         */
        public APIlistWithdrawalsRequest limit(Integer limit) {
            this.limit = limit;
            return this;
        }

        /**
         * Set offset
         * @param offset List offset, starting from 0 (optional, default to 0)
         * @return APIlistWithdrawalsRequest
         */
        public APIlistWithdrawalsRequest offset(Integer offset) {
            this.offset = offset;
            return this;
        }

        /**
         * Build call for listWithdrawals
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
            return listWithdrawalsCall(currency, from, to, limit, offset, _callback);
        }

        /**
         * Execute listWithdrawals request
         * @return List&lt;LedgerRecord&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> List retrieved </td><td>  -  </td></tr>
         </table>
         */
        public List<LedgerRecord> execute() throws ApiException {
            ApiResponse<List<LedgerRecord>> localVarResp = listWithdrawalsWithHttpInfo(currency, from, to, limit, offset);
            return localVarResp.getData();
        }

        /**
         * Execute listWithdrawals request with HTTP info returned
         * @return ApiResponse&lt;List&lt;LedgerRecord&gt;&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> List retrieved </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<List<LedgerRecord>> executeWithHttpInfo() throws ApiException {
            return listWithdrawalsWithHttpInfo(currency, from, to, limit, offset);
        }

        /**
         * Execute listWithdrawals request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> List retrieved </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<List<LedgerRecord>> _callback) throws ApiException {
            return listWithdrawalsAsync(currency, from, to, limit, offset, _callback);
        }
    }

    /**
     * Retrieve withdrawal records
     * Record time range cannot exceed 30 days
     * @return APIlistWithdrawalsRequest
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> List retrieved </td><td>  -  </td></tr>
     </table>
     */
    public APIlistWithdrawalsRequest listWithdrawals() {
        return new APIlistWithdrawalsRequest();
    }

    private okhttp3.Call listDepositsCall(String currency, Long from, Long to, Integer limit, Integer offset, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/wallet/deposits";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (currency != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("currency", currency));
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
    private okhttp3.Call listDepositsValidateBeforeCall(String currency, Long from, Long to, Integer limit, Integer offset, final ApiCallback _callback) throws ApiException {
        okhttp3.Call localVarCall = listDepositsCall(currency, from, to, limit, offset, _callback);
        return localVarCall;
    }


    private ApiResponse<List<LedgerRecord>> listDepositsWithHttpInfo(String currency, Long from, Long to, Integer limit, Integer offset) throws ApiException {
        okhttp3.Call localVarCall = listDepositsValidateBeforeCall(currency, from, to, limit, offset, null);
        Type localVarReturnType = new TypeToken<List<LedgerRecord>>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call listDepositsAsync(String currency, Long from, Long to, Integer limit, Integer offset, final ApiCallback<List<LedgerRecord>> _callback) throws ApiException {
        okhttp3.Call localVarCall = listDepositsValidateBeforeCall(currency, from, to, limit, offset, _callback);
        Type localVarReturnType = new TypeToken<List<LedgerRecord>>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class APIlistDepositsRequest {
        private String currency;
        private Long from;
        private Long to;
        private Integer limit;
        private Integer offset;

        private APIlistDepositsRequest() {
        }

        /**
         * Set currency
         * @param currency Filter by currency. Return all currency records if not specified (optional)
         * @return APIlistDepositsRequest
         */
        public APIlistDepositsRequest currency(String currency) {
            this.currency = currency;
            return this;
        }

        /**
         * Set from
         * @param from Time range beginning, default to 7 days before current time (optional)
         * @return APIlistDepositsRequest
         */
        public APIlistDepositsRequest from(Long from) {
            this.from = from;
            return this;
        }

        /**
         * Set to
         * @param to Time range ending, default to current time (optional)
         * @return APIlistDepositsRequest
         */
        public APIlistDepositsRequest to(Long to) {
            this.to = to;
            return this;
        }

        /**
         * Set limit
         * @param limit Maximum number of records returned in one list (optional, default to 100)
         * @return APIlistDepositsRequest
         */
        public APIlistDepositsRequest limit(Integer limit) {
            this.limit = limit;
            return this;
        }

        /**
         * Set offset
         * @param offset List offset, starting from 0 (optional, default to 0)
         * @return APIlistDepositsRequest
         */
        public APIlistDepositsRequest offset(Integer offset) {
            this.offset = offset;
            return this;
        }

        /**
         * Build call for listDeposits
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
            return listDepositsCall(currency, from, to, limit, offset, _callback);
        }

        /**
         * Execute listDeposits request
         * @return List&lt;LedgerRecord&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> List retrieved </td><td>  -  </td></tr>
         </table>
         */
        public List<LedgerRecord> execute() throws ApiException {
            ApiResponse<List<LedgerRecord>> localVarResp = listDepositsWithHttpInfo(currency, from, to, limit, offset);
            return localVarResp.getData();
        }

        /**
         * Execute listDeposits request with HTTP info returned
         * @return ApiResponse&lt;List&lt;LedgerRecord&gt;&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> List retrieved </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<List<LedgerRecord>> executeWithHttpInfo() throws ApiException {
            return listDepositsWithHttpInfo(currency, from, to, limit, offset);
        }

        /**
         * Execute listDeposits request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> List retrieved </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<List<LedgerRecord>> _callback) throws ApiException {
            return listDepositsAsync(currency, from, to, limit, offset, _callback);
        }
    }

    /**
     * Retrieve deposit records
     * Record time range cannot exceed 30 days
     * @return APIlistDepositsRequest
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> List retrieved </td><td>  -  </td></tr>
     </table>
     */
    public APIlistDepositsRequest listDeposits() {
        return new APIlistDepositsRequest();
    }

    /**
     * Build call for transfer
     * @param transfer  (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 204 </td><td> Balance transferred </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call transferCall(Transfer transfer, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = transfer;

        // create path and map variables
        String localVarPath = "/wallet/transfers";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();
        final String[] localVarAccepts = {
            
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
    private okhttp3.Call transferValidateBeforeCall(Transfer transfer, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'transfer' is set
        if (transfer == null) {
            throw new ApiException("Missing the required parameter 'transfer' when calling transfer(Async)");
        }

        okhttp3.Call localVarCall = transferCall(transfer, _callback);
        return localVarCall;
    }

    /**
     * Transfer between trading accounts
     * Transfer between different accounts. Currently support transfers between the following:  1. spot - margin 2. spot - futures(perpetual) 3. spot - delivery
     * @param transfer  (required)
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 204 </td><td> Balance transferred </td><td>  -  </td></tr>
     </table>
     */
    public void transfer(Transfer transfer) throws ApiException {
        transferWithHttpInfo(transfer);
    }

    /**
     * Transfer between trading accounts
     * Transfer between different accounts. Currently support transfers between the following:  1. spot - margin 2. spot - futures(perpetual) 3. spot - delivery
     * @param transfer  (required)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 204 </td><td> Balance transferred </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<Void> transferWithHttpInfo(Transfer transfer) throws ApiException {
        okhttp3.Call localVarCall = transferValidateBeforeCall(transfer, null);
        return localVarApiClient.execute(localVarCall);
    }

    /**
     * Transfer between trading accounts (asynchronously)
     * Transfer between different accounts. Currently support transfers between the following:  1. spot - margin 2. spot - futures(perpetual) 3. spot - delivery
     * @param transfer  (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 204 </td><td> Balance transferred </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call transferAsync(Transfer transfer, final ApiCallback<Void> _callback) throws ApiException {
        okhttp3.Call localVarCall = transferValidateBeforeCall(transfer, _callback);
        localVarApiClient.executeAsync(localVarCall, _callback);
        return localVarCall;
    }

    private okhttp3.Call listSubAccountTransfersCall(String subUid, Long from, Long to, Integer limit, Integer offset, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/wallet/sub_account_transfers";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (subUid != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("sub_uid", subUid));
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
    private okhttp3.Call listSubAccountTransfersValidateBeforeCall(String subUid, Long from, Long to, Integer limit, Integer offset, final ApiCallback _callback) throws ApiException {
        okhttp3.Call localVarCall = listSubAccountTransfersCall(subUid, from, to, limit, offset, _callback);
        return localVarCall;
    }


    private ApiResponse<List<SubAccountTransfer>> listSubAccountTransfersWithHttpInfo(String subUid, Long from, Long to, Integer limit, Integer offset) throws ApiException {
        okhttp3.Call localVarCall = listSubAccountTransfersValidateBeforeCall(subUid, from, to, limit, offset, null);
        Type localVarReturnType = new TypeToken<List<SubAccountTransfer>>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call listSubAccountTransfersAsync(String subUid, Long from, Long to, Integer limit, Integer offset, final ApiCallback<List<SubAccountTransfer>> _callback) throws ApiException {
        okhttp3.Call localVarCall = listSubAccountTransfersValidateBeforeCall(subUid, from, to, limit, offset, _callback);
        Type localVarReturnType = new TypeToken<List<SubAccountTransfer>>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class APIlistSubAccountTransfersRequest {
        private String subUid;
        private Long from;
        private Long to;
        private Integer limit;
        private Integer offset;

        private APIlistSubAccountTransfersRequest() {
        }

        /**
         * Set subUid
         * @param subUid Sub account user ID. Return records related to all sub accounts if not specified (optional)
         * @return APIlistSubAccountTransfersRequest
         */
        public APIlistSubAccountTransfersRequest subUid(String subUid) {
            this.subUid = subUid;
            return this;
        }

        /**
         * Set from
         * @param from Time range beginning, default to 7 days before current time (optional)
         * @return APIlistSubAccountTransfersRequest
         */
        public APIlistSubAccountTransfersRequest from(Long from) {
            this.from = from;
            return this;
        }

        /**
         * Set to
         * @param to Time range ending, default to current time (optional)
         * @return APIlistSubAccountTransfersRequest
         */
        public APIlistSubAccountTransfersRequest to(Long to) {
            this.to = to;
            return this;
        }

        /**
         * Set limit
         * @param limit Maximum number of records returned in one list (optional, default to 100)
         * @return APIlistSubAccountTransfersRequest
         */
        public APIlistSubAccountTransfersRequest limit(Integer limit) {
            this.limit = limit;
            return this;
        }

        /**
         * Set offset
         * @param offset List offset, starting from 0 (optional, default to 0)
         * @return APIlistSubAccountTransfersRequest
         */
        public APIlistSubAccountTransfersRequest offset(Integer offset) {
            this.offset = offset;
            return this;
        }

        /**
         * Build call for listSubAccountTransfers
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
            return listSubAccountTransfersCall(subUid, from, to, limit, offset, _callback);
        }

        /**
         * Execute listSubAccountTransfers request
         * @return List&lt;SubAccountTransfer&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> List retrieved </td><td>  -  </td></tr>
         </table>
         */
        public List<SubAccountTransfer> execute() throws ApiException {
            ApiResponse<List<SubAccountTransfer>> localVarResp = listSubAccountTransfersWithHttpInfo(subUid, from, to, limit, offset);
            return localVarResp.getData();
        }

        /**
         * Execute listSubAccountTransfers request with HTTP info returned
         * @return ApiResponse&lt;List&lt;SubAccountTransfer&gt;&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> List retrieved </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<List<SubAccountTransfer>> executeWithHttpInfo() throws ApiException {
            return listSubAccountTransfersWithHttpInfo(subUid, from, to, limit, offset);
        }

        /**
         * Execute listSubAccountTransfers request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> List retrieved </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<List<SubAccountTransfer>> _callback) throws ApiException {
            return listSubAccountTransfersAsync(subUid, from, to, limit, offset, _callback);
        }
    }

    /**
     * Transfer records between main and sub accounts
     * Record time range cannot exceed 30 days  &gt; Note: only records after 2020-04-10 can be retrieved
     * @return APIlistSubAccountTransfersRequest
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> List retrieved </td><td>  -  </td></tr>
     </table>
     */
    public APIlistSubAccountTransfersRequest listSubAccountTransfers() {
        return new APIlistSubAccountTransfersRequest();
    }

    /**
     * Build call for transferWithSubAccount
     * @param subAccountTransfer  (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 204 </td><td> Balance transferred </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call transferWithSubAccountCall(SubAccountTransfer subAccountTransfer, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = subAccountTransfer;

        // create path and map variables
        String localVarPath = "/wallet/sub_account_transfers";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();
        final String[] localVarAccepts = {
            
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
    private okhttp3.Call transferWithSubAccountValidateBeforeCall(SubAccountTransfer subAccountTransfer, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'subAccountTransfer' is set
        if (subAccountTransfer == null) {
            throw new ApiException("Missing the required parameter 'subAccountTransfer' when calling transferWithSubAccount(Async)");
        }

        okhttp3.Call localVarCall = transferWithSubAccountCall(subAccountTransfer, _callback);
        return localVarCall;
    }

    /**
     * Transfer between main and sub accounts
     * 
     * @param subAccountTransfer  (required)
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 204 </td><td> Balance transferred </td><td>  -  </td></tr>
     </table>
     */
    public void transferWithSubAccount(SubAccountTransfer subAccountTransfer) throws ApiException {
        transferWithSubAccountWithHttpInfo(subAccountTransfer);
    }

    /**
     * Transfer between main and sub accounts
     * 
     * @param subAccountTransfer  (required)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 204 </td><td> Balance transferred </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<Void> transferWithSubAccountWithHttpInfo(SubAccountTransfer subAccountTransfer) throws ApiException {
        okhttp3.Call localVarCall = transferWithSubAccountValidateBeforeCall(subAccountTransfer, null);
        return localVarApiClient.execute(localVarCall);
    }

    /**
     * Transfer between main and sub accounts (asynchronously)
     * 
     * @param subAccountTransfer  (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 204 </td><td> Balance transferred </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call transferWithSubAccountAsync(SubAccountTransfer subAccountTransfer, final ApiCallback<Void> _callback) throws ApiException {
        okhttp3.Call localVarCall = transferWithSubAccountValidateBeforeCall(subAccountTransfer, _callback);
        localVarApiClient.executeAsync(localVarCall, _callback);
        return localVarCall;
    }

    private okhttp3.Call listWithdrawStatusCall(String currency, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/wallet/withdraw_status";

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
    private okhttp3.Call listWithdrawStatusValidateBeforeCall(String currency, final ApiCallback _callback) throws ApiException {
        okhttp3.Call localVarCall = listWithdrawStatusCall(currency, _callback);
        return localVarCall;
    }


    private ApiResponse<List<WithdrawStatus>> listWithdrawStatusWithHttpInfo(String currency) throws ApiException {
        okhttp3.Call localVarCall = listWithdrawStatusValidateBeforeCall(currency, null);
        Type localVarReturnType = new TypeToken<List<WithdrawStatus>>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call listWithdrawStatusAsync(String currency, final ApiCallback<List<WithdrawStatus>> _callback) throws ApiException {
        okhttp3.Call localVarCall = listWithdrawStatusValidateBeforeCall(currency, _callback);
        Type localVarReturnType = new TypeToken<List<WithdrawStatus>>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class APIlistWithdrawStatusRequest {
        private String currency;

        private APIlistWithdrawStatusRequest() {
        }

        /**
         * Set currency
         * @param currency Retrieved specified currency related data (optional)
         * @return APIlistWithdrawStatusRequest
         */
        public APIlistWithdrawStatusRequest currency(String currency) {
            this.currency = currency;
            return this;
        }

        /**
         * Build call for listWithdrawStatus
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
            return listWithdrawStatusCall(currency, _callback);
        }

        /**
         * Execute listWithdrawStatus request
         * @return List&lt;WithdrawStatus&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> List retrieved </td><td>  -  </td></tr>
         </table>
         */
        public List<WithdrawStatus> execute() throws ApiException {
            ApiResponse<List<WithdrawStatus>> localVarResp = listWithdrawStatusWithHttpInfo(currency);
            return localVarResp.getData();
        }

        /**
         * Execute listWithdrawStatus request with HTTP info returned
         * @return ApiResponse&lt;List&lt;WithdrawStatus&gt;&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> List retrieved </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<List<WithdrawStatus>> executeWithHttpInfo() throws ApiException {
            return listWithdrawStatusWithHttpInfo(currency);
        }

        /**
         * Execute listWithdrawStatus request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> List retrieved </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<List<WithdrawStatus>> _callback) throws ApiException {
            return listWithdrawStatusAsync(currency, _callback);
        }
    }

    /**
     * Retrieve withdrawal status
     * 
     * @return APIlistWithdrawStatusRequest
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> List retrieved </td><td>  -  </td></tr>
     </table>
     */
    public APIlistWithdrawStatusRequest listWithdrawStatus() {
        return new APIlistWithdrawStatusRequest();
    }

}
