


package com.teachy.coins.gateapi.api;

import com.teachy.coins.gateapi.ApiCallback;
import com.teachy.coins.gateapi.ApiClient;
import com.teachy.coins.gateapi.ApiException;
import com.teachy.coins.gateapi.ApiResponse;
import com.teachy.coins.gateapi.Configuration;
import com.teachy.coins.gateapi.Pair;

import com.google.gson.reflect.TypeToken;


import com.teachy.coins.gateapi.models.FundingAccount;
import com.teachy.coins.gateapi.models.FundingBookItem;
import com.teachy.coins.gateapi.models.Loan;
import com.teachy.coins.gateapi.models.LoanPatch;
import com.teachy.coins.gateapi.models.LoanRecord;
import com.teachy.coins.gateapi.models.MarginAccount;
import com.teachy.coins.gateapi.models.MarginAccountBook;
import com.teachy.coins.gateapi.models.MarginCurrencyPair;
import com.teachy.coins.gateapi.models.RepayRequest;
import com.teachy.coins.gateapi.models.Repayment;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MarginApi {
    private ApiClient localVarApiClient;

    public MarginApi() {
        this(Configuration.getDefaultApiClient());
    }

    public MarginApi(ApiClient apiClient) {
        this.localVarApiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return localVarApiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.localVarApiClient = apiClient;
    }

    /**
     * Build call for listMarginCurrencyPairs
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> List retrieved </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call listMarginCurrencyPairsCall(final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/margin/currency_pairs";

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
    private okhttp3.Call listMarginCurrencyPairsValidateBeforeCall(final ApiCallback _callback) throws ApiException {
        okhttp3.Call localVarCall = listMarginCurrencyPairsCall(_callback);
        return localVarCall;
    }

    /**
     * List all supported currency pairs supported in margin trading
     * 
     * @return List&lt;MarginCurrencyPair&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> List retrieved </td><td>  -  </td></tr>
     </table>
     */
    public List<MarginCurrencyPair> listMarginCurrencyPairs() throws ApiException {
        ApiResponse<List<MarginCurrencyPair>> localVarResp = listMarginCurrencyPairsWithHttpInfo();
        return localVarResp.getData();
    }

    /**
     * List all supported currency pairs supported in margin trading
     * 
     * @return ApiResponse&lt;List&lt;MarginCurrencyPair&gt;&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> List retrieved </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<List<MarginCurrencyPair>> listMarginCurrencyPairsWithHttpInfo() throws ApiException {
        okhttp3.Call localVarCall = listMarginCurrencyPairsValidateBeforeCall(null);
        Type localVarReturnType = new TypeToken<List<MarginCurrencyPair>>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * List all supported currency pairs supported in margin trading (asynchronously)
     * 
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> List retrieved </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call listMarginCurrencyPairsAsync(final ApiCallback<List<MarginCurrencyPair>> _callback) throws ApiException {
        okhttp3.Call localVarCall = listMarginCurrencyPairsValidateBeforeCall(_callback);
        Type localVarReturnType = new TypeToken<List<MarginCurrencyPair>>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    /**
     * Build call for listFundingBook
     * @param currency Retrieved specified currency related data (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Order book retrieved </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call listFundingBookCall(String currency, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/margin/funding_book";

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

        String[] localVarAuthNames = new String[] {  };
        return localVarApiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call listFundingBookValidateBeforeCall(String currency, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'currency' is set
        if (currency == null) {
            throw new ApiException("Missing the required parameter 'currency' when calling listFundingBook(Async)");
        }

        okhttp3.Call localVarCall = listFundingBookCall(currency, _callback);
        return localVarCall;
    }

    /**
     * Order book of lending loans
     * 
     * @param currency Retrieved specified currency related data (required)
     * @return List&lt;FundingBookItem&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Order book retrieved </td><td>  -  </td></tr>
     </table>
     */
    public List<FundingBookItem> listFundingBook(String currency) throws ApiException {
        ApiResponse<List<FundingBookItem>> localVarResp = listFundingBookWithHttpInfo(currency);
        return localVarResp.getData();
    }

    /**
     * Order book of lending loans
     * 
     * @param currency Retrieved specified currency related data (required)
     * @return ApiResponse&lt;List&lt;FundingBookItem&gt;&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Order book retrieved </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<List<FundingBookItem>> listFundingBookWithHttpInfo(String currency) throws ApiException {
        okhttp3.Call localVarCall = listFundingBookValidateBeforeCall(currency, null);
        Type localVarReturnType = new TypeToken<List<FundingBookItem>>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Order book of lending loans (asynchronously)
     * 
     * @param currency Retrieved specified currency related data (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Order book retrieved </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call listFundingBookAsync(String currency, final ApiCallback<List<FundingBookItem>> _callback) throws ApiException {
        okhttp3.Call localVarCall = listFundingBookValidateBeforeCall(currency, _callback);
        Type localVarReturnType = new TypeToken<List<FundingBookItem>>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    private okhttp3.Call listMarginAccountsCall(String currencyPair, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/margin/accounts";

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
    private okhttp3.Call listMarginAccountsValidateBeforeCall(String currencyPair, final ApiCallback _callback) throws ApiException {
        okhttp3.Call localVarCall = listMarginAccountsCall(currencyPair, _callback);
        return localVarCall;
    }


    private ApiResponse<List<MarginAccount>> listMarginAccountsWithHttpInfo(String currencyPair) throws ApiException {
        okhttp3.Call localVarCall = listMarginAccountsValidateBeforeCall(currencyPair, null);
        Type localVarReturnType = new TypeToken<List<MarginAccount>>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call listMarginAccountsAsync(String currencyPair, final ApiCallback<List<MarginAccount>> _callback) throws ApiException {
        okhttp3.Call localVarCall = listMarginAccountsValidateBeforeCall(currencyPair, _callback);
        Type localVarReturnType = new TypeToken<List<MarginAccount>>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class APIlistMarginAccountsRequest {
        private String currencyPair;

        private APIlistMarginAccountsRequest() {
        }

        /**
         * Set currencyPair
         * @param currencyPair Currency pair (optional)
         * @return APIlistMarginAccountsRequest
         */
        public APIlistMarginAccountsRequest currencyPair(String currencyPair) {
            this.currencyPair = currencyPair;
            return this;
        }

        /**
         * Build call for listMarginAccounts
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
            return listMarginAccountsCall(currencyPair, _callback);
        }

        /**
         * Execute listMarginAccounts request
         * @return List&lt;MarginAccount&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> List retrieved </td><td>  -  </td></tr>
         </table>
         */
        public List<MarginAccount> execute() throws ApiException {
            ApiResponse<List<MarginAccount>> localVarResp = listMarginAccountsWithHttpInfo(currencyPair);
            return localVarResp.getData();
        }

        /**
         * Execute listMarginAccounts request with HTTP info returned
         * @return ApiResponse&lt;List&lt;MarginAccount&gt;&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> List retrieved </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<List<MarginAccount>> executeWithHttpInfo() throws ApiException {
            return listMarginAccountsWithHttpInfo(currencyPair);
        }

        /**
         * Execute listMarginAccounts request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> List retrieved </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<List<MarginAccount>> _callback) throws ApiException {
            return listMarginAccountsAsync(currencyPair, _callback);
        }
    }

    /**
     * Margin account list
     * 
     * @return APIlistMarginAccountsRequest
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> List retrieved </td><td>  -  </td></tr>
     </table>
     */
    public APIlistMarginAccountsRequest listMarginAccounts() {
        return new APIlistMarginAccountsRequest();
    }

    private okhttp3.Call listMarginAccountBookCall(String currency, String currencyPair, Long from, Long to, Integer page, Integer limit, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/margin/account_book";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (currency != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("currency", currency));
        }

        if (currencyPair != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("currency_pair", currencyPair));
        }

        if (from != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("from", from));
        }

        if (to != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("to", to));
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
    private okhttp3.Call listMarginAccountBookValidateBeforeCall(String currency, String currencyPair, Long from, Long to, Integer page, Integer limit, final ApiCallback _callback) throws ApiException {
        okhttp3.Call localVarCall = listMarginAccountBookCall(currency, currencyPair, from, to, page, limit, _callback);
        return localVarCall;
    }


    private ApiResponse<List<MarginAccountBook>> listMarginAccountBookWithHttpInfo(String currency, String currencyPair, Long from, Long to, Integer page, Integer limit) throws ApiException {
        okhttp3.Call localVarCall = listMarginAccountBookValidateBeforeCall(currency, currencyPair, from, to, page, limit, null);
        Type localVarReturnType = new TypeToken<List<MarginAccountBook>>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call listMarginAccountBookAsync(String currency, String currencyPair, Long from, Long to, Integer page, Integer limit, final ApiCallback<List<MarginAccountBook>> _callback) throws ApiException {
        okhttp3.Call localVarCall = listMarginAccountBookValidateBeforeCall(currency, currencyPair, from, to, page, limit, _callback);
        Type localVarReturnType = new TypeToken<List<MarginAccountBook>>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class APIlistMarginAccountBookRequest {
        private String currency;
        private String currencyPair;
        private Long from;
        private Long to;
        private Integer page;
        private Integer limit;

        private APIlistMarginAccountBookRequest() {
        }

        /**
         * Set currency
         * @param currency List records related to specified currency only. If specified, &#x60;currency_pair&#x60; is also required. (optional)
         * @return APIlistMarginAccountBookRequest
         */
        public APIlistMarginAccountBookRequest currency(String currency) {
            this.currency = currency;
            return this;
        }

        /**
         * Set currencyPair
         * @param currencyPair List records related to specified currency pair. Used in combination with &#x60;currency&#x60;. Ignored if &#x60;currency&#x60; is not provided (optional)
         * @return APIlistMarginAccountBookRequest
         */
        public APIlistMarginAccountBookRequest currencyPair(String currencyPair) {
            this.currencyPair = currencyPair;
            return this;
        }

        /**
         * Set from
         * @param from Time range beginning, default to 7 days before current time (optional)
         * @return APIlistMarginAccountBookRequest
         */
        public APIlistMarginAccountBookRequest from(Long from) {
            this.from = from;
            return this;
        }

        /**
         * Set to
         * @param to Time range ending, default to current time (optional)
         * @return APIlistMarginAccountBookRequest
         */
        public APIlistMarginAccountBookRequest to(Long to) {
            this.to = to;
            return this;
        }

        /**
         * Set page
         * @param page Page number (optional, default to 1)
         * @return APIlistMarginAccountBookRequest
         */
        public APIlistMarginAccountBookRequest page(Integer page) {
            this.page = page;
            return this;
        }

        /**
         * Set limit
         * @param limit Maximum number of records returned in one list (optional, default to 100)
         * @return APIlistMarginAccountBookRequest
         */
        public APIlistMarginAccountBookRequest limit(Integer limit) {
            this.limit = limit;
            return this;
        }

        /**
         * Build call for listMarginAccountBook
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
            return listMarginAccountBookCall(currency, currencyPair, from, to, page, limit, _callback);
        }

        /**
         * Execute listMarginAccountBook request
         * @return List&lt;MarginAccountBook&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> List retrieved </td><td>  -  </td></tr>
         </table>
         */
        public List<MarginAccountBook> execute() throws ApiException {
            ApiResponse<List<MarginAccountBook>> localVarResp = listMarginAccountBookWithHttpInfo(currency, currencyPair, from, to, page, limit);
            return localVarResp.getData();
        }

        /**
         * Execute listMarginAccountBook request with HTTP info returned
         * @return ApiResponse&lt;List&lt;MarginAccountBook&gt;&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> List retrieved </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<List<MarginAccountBook>> executeWithHttpInfo() throws ApiException {
            return listMarginAccountBookWithHttpInfo(currency, currencyPair, from, to, page, limit);
        }

        /**
         * Execute listMarginAccountBook request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> List retrieved </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<List<MarginAccountBook>> _callback) throws ApiException {
            return listMarginAccountBookAsync(currency, currencyPair, from, to, page, limit, _callback);
        }
    }

    /**
     * List margin account balance change history
     * Only transferring from or to margin account are provided for now. Time range allows 30 days at most
     * @return APIlistMarginAccountBookRequest
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> List retrieved </td><td>  -  </td></tr>
     </table>
     */
    public APIlistMarginAccountBookRequest listMarginAccountBook() {
        return new APIlistMarginAccountBookRequest();
    }

    private okhttp3.Call listFundingAccountsCall(String currency, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/margin/funding_accounts";

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
    private okhttp3.Call listFundingAccountsValidateBeforeCall(String currency, final ApiCallback _callback) throws ApiException {
        okhttp3.Call localVarCall = listFundingAccountsCall(currency, _callback);
        return localVarCall;
    }


    private ApiResponse<List<FundingAccount>> listFundingAccountsWithHttpInfo(String currency) throws ApiException {
        okhttp3.Call localVarCall = listFundingAccountsValidateBeforeCall(currency, null);
        Type localVarReturnType = new TypeToken<List<FundingAccount>>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call listFundingAccountsAsync(String currency, final ApiCallback<List<FundingAccount>> _callback) throws ApiException {
        okhttp3.Call localVarCall = listFundingAccountsValidateBeforeCall(currency, _callback);
        Type localVarReturnType = new TypeToken<List<FundingAccount>>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class APIlistFundingAccountsRequest {
        private String currency;

        private APIlistFundingAccountsRequest() {
        }

        /**
         * Set currency
         * @param currency Retrieved specified currency related data (optional)
         * @return APIlistFundingAccountsRequest
         */
        public APIlistFundingAccountsRequest currency(String currency) {
            this.currency = currency;
            return this;
        }

        /**
         * Build call for listFundingAccounts
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
            return listFundingAccountsCall(currency, _callback);
        }

        /**
         * Execute listFundingAccounts request
         * @return List&lt;FundingAccount&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> List retrieved </td><td>  -  </td></tr>
         </table>
         */
        public List<FundingAccount> execute() throws ApiException {
            ApiResponse<List<FundingAccount>> localVarResp = listFundingAccountsWithHttpInfo(currency);
            return localVarResp.getData();
        }

        /**
         * Execute listFundingAccounts request with HTTP info returned
         * @return ApiResponse&lt;List&lt;FundingAccount&gt;&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> List retrieved </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<List<FundingAccount>> executeWithHttpInfo() throws ApiException {
            return listFundingAccountsWithHttpInfo(currency);
        }

        /**
         * Execute listFundingAccounts request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> List retrieved </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<List<FundingAccount>> _callback) throws ApiException {
            return listFundingAccountsAsync(currency, _callback);
        }
    }

    /**
     * Funding account list
     * 
     * @return APIlistFundingAccountsRequest
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> List retrieved </td><td>  -  </td></tr>
     </table>
     */
    public APIlistFundingAccountsRequest listFundingAccounts() {
        return new APIlistFundingAccountsRequest();
    }

    private okhttp3.Call listLoansCall(String status, String side, String currency, String currencyPair, String sortBy, Boolean reverseSort, Integer page, Integer limit, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/margin/loans";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (status != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("status", status));
        }

        if (side != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("side", side));
        }

        if (currency != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("currency", currency));
        }

        if (currencyPair != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("currency_pair", currencyPair));
        }

        if (sortBy != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("sort_by", sortBy));
        }

        if (reverseSort != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("reverse_sort", reverseSort));
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
    private okhttp3.Call listLoansValidateBeforeCall(String status, String side, String currency, String currencyPair, String sortBy, Boolean reverseSort, Integer page, Integer limit, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'status' is set
        if (status == null) {
            throw new ApiException("Missing the required parameter 'status' when calling listLoans(Async)");
        }

        // verify the required parameter 'side' is set
        if (side == null) {
            throw new ApiException("Missing the required parameter 'side' when calling listLoans(Async)");
        }

        okhttp3.Call localVarCall = listLoansCall(status, side, currency, currencyPair, sortBy, reverseSort, page, limit, _callback);
        return localVarCall;
    }


    private ApiResponse<List<Loan>> listLoansWithHttpInfo(String status, String side, String currency, String currencyPair, String sortBy, Boolean reverseSort, Integer page, Integer limit) throws ApiException {
        okhttp3.Call localVarCall = listLoansValidateBeforeCall(status, side, currency, currencyPair, sortBy, reverseSort, page, limit, null);
        Type localVarReturnType = new TypeToken<List<Loan>>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call listLoansAsync(String status, String side, String currency, String currencyPair, String sortBy, Boolean reverseSort, Integer page, Integer limit, final ApiCallback<List<Loan>> _callback) throws ApiException {
        okhttp3.Call localVarCall = listLoansValidateBeforeCall(status, side, currency, currencyPair, sortBy, reverseSort, page, limit, _callback);
        Type localVarReturnType = new TypeToken<List<Loan>>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class APIlistLoansRequest {
        private final String status;
        private final String side;
        private String currency;
        private String currencyPair;
        private String sortBy;
        private Boolean reverseSort;
        private Integer page;
        private Integer limit;

        private APIlistLoansRequest(String status, String side) {
            this.status = status;
            this.side = side;
        }

        /**
         * Set currency
         * @param currency Retrieved specified currency related data (optional)
         * @return APIlistLoansRequest
         */
        public APIlistLoansRequest currency(String currency) {
            this.currency = currency;
            return this;
        }

        /**
         * Set currencyPair
         * @param currencyPair Currency pair (optional)
         * @return APIlistLoansRequest
         */
        public APIlistLoansRequest currencyPair(String currencyPair) {
            this.currencyPair = currencyPair;
            return this;
        }

        /**
         * Set sortBy
         * @param sortBy Specify which field is used to sort. &#x60;create_time&#x60; or &#x60;rate&#x60; is supported. Default to &#x60;create_time&#x60; (optional)
         * @return APIlistLoansRequest
         */
        public APIlistLoansRequest sortBy(String sortBy) {
            this.sortBy = sortBy;
            return this;
        }

        /**
         * Set reverseSort
         * @param reverseSort Whether to sort in descending order. Default to &#x60;true&#x60; (optional)
         * @return APIlistLoansRequest
         */
        public APIlistLoansRequest reverseSort(Boolean reverseSort) {
            this.reverseSort = reverseSort;
            return this;
        }

        /**
         * Set page
         * @param page Page number (optional, default to 1)
         * @return APIlistLoansRequest
         */
        public APIlistLoansRequest page(Integer page) {
            this.page = page;
            return this;
        }

        /**
         * Set limit
         * @param limit Maximum number of records returned in one list (optional, default to 100)
         * @return APIlistLoansRequest
         */
        public APIlistLoansRequest limit(Integer limit) {
            this.limit = limit;
            return this;
        }

        /**
         * Build call for listLoans
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
            return listLoansCall(status, side, currency, currencyPair, sortBy, reverseSort, page, limit, _callback);
        }

        /**
         * Execute listLoans request
         * @return List&lt;Loan&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> List retrieved </td><td>  -  </td></tr>
         </table>
         */
        public List<Loan> execute() throws ApiException {
            ApiResponse<List<Loan>> localVarResp = listLoansWithHttpInfo(status, side, currency, currencyPair, sortBy, reverseSort, page, limit);
            return localVarResp.getData();
        }

        /**
         * Execute listLoans request with HTTP info returned
         * @return ApiResponse&lt;List&lt;Loan&gt;&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> List retrieved </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<List<Loan>> executeWithHttpInfo() throws ApiException {
            return listLoansWithHttpInfo(status, side, currency, currencyPair, sortBy, reverseSort, page, limit);
        }

        /**
         * Execute listLoans request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> List retrieved </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<List<Loan>> _callback) throws ApiException {
            return listLoansAsync(status, side, currency, currencyPair, sortBy, reverseSort, page, limit, _callback);
        }
    }

    /**
     * List all loans
     * 
     * @param status Loan status (required)
     * @param side Lend or borrow (required)
     * @return APIlistLoansRequest
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> List retrieved </td><td>  -  </td></tr>
     </table>
     */
    public APIlistLoansRequest listLoans(String status, String side) {
        return new APIlistLoansRequest(status, side);
    }

    /**
     * Build call for createLoan
     * @param loan  (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 201 </td><td> Loan created </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call createLoanCall(Loan loan, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = loan;

        // create path and map variables
        String localVarPath = "/margin/loans";

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
    private okhttp3.Call createLoanValidateBeforeCall(Loan loan, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'loan' is set
        if (loan == null) {
            throw new ApiException("Missing the required parameter 'loan' when calling createLoan(Async)");
        }

        okhttp3.Call localVarCall = createLoanCall(loan, _callback);
        return localVarCall;
    }

    /**
     * Lend or borrow
     * 
     * @param loan  (required)
     * @return Loan
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 201 </td><td> Loan created </td><td>  -  </td></tr>
     </table>
     */
    public Loan createLoan(Loan loan) throws ApiException {
        ApiResponse<Loan> localVarResp = createLoanWithHttpInfo(loan);
        return localVarResp.getData();
    }

    /**
     * Lend or borrow
     * 
     * @param loan  (required)
     * @return ApiResponse&lt;Loan&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 201 </td><td> Loan created </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<Loan> createLoanWithHttpInfo(Loan loan) throws ApiException {
        okhttp3.Call localVarCall = createLoanValidateBeforeCall(loan, null);
        Type localVarReturnType = new TypeToken<Loan>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Lend or borrow (asynchronously)
     * 
     * @param loan  (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 201 </td><td> Loan created </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call createLoanAsync(Loan loan, final ApiCallback<Loan> _callback) throws ApiException {
        okhttp3.Call localVarCall = createLoanValidateBeforeCall(loan, _callback);
        Type localVarReturnType = new TypeToken<Loan>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    /**
     * Build call for mergeLoans
     * @param currency Retrieved specified currency related data (required)
     * @param ids Lending loan ID list separated by &#x60;,&#x60;. Maximum of 20 IDs are allowed in one request (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 201 </td><td> Loans merged </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call mergeLoansCall(String currency, String ids, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/margin/merged_loans";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (currency != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("currency", currency));
        }

        if (ids != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("ids", ids));
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
    private okhttp3.Call mergeLoansValidateBeforeCall(String currency, String ids, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'currency' is set
        if (currency == null) {
            throw new ApiException("Missing the required parameter 'currency' when calling mergeLoans(Async)");
        }

        // verify the required parameter 'ids' is set
        if (ids == null) {
            throw new ApiException("Missing the required parameter 'ids' when calling mergeLoans(Async)");
        }

        okhttp3.Call localVarCall = mergeLoansCall(currency, ids, _callback);
        return localVarCall;
    }

    /**
     * Merge multiple lending loans
     * 
     * @param currency Retrieved specified currency related data (required)
     * @param ids Lending loan ID list separated by &#x60;,&#x60;. Maximum of 20 IDs are allowed in one request (required)
     * @return Loan
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 201 </td><td> Loans merged </td><td>  -  </td></tr>
     </table>
     */
    public Loan mergeLoans(String currency, String ids) throws ApiException {
        ApiResponse<Loan> localVarResp = mergeLoansWithHttpInfo(currency, ids);
        return localVarResp.getData();
    }

    /**
     * Merge multiple lending loans
     * 
     * @param currency Retrieved specified currency related data (required)
     * @param ids Lending loan ID list separated by &#x60;,&#x60;. Maximum of 20 IDs are allowed in one request (required)
     * @return ApiResponse&lt;Loan&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 201 </td><td> Loans merged </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<Loan> mergeLoansWithHttpInfo(String currency, String ids) throws ApiException {
        okhttp3.Call localVarCall = mergeLoansValidateBeforeCall(currency, ids, null);
        Type localVarReturnType = new TypeToken<Loan>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Merge multiple lending loans (asynchronously)
     * 
     * @param currency Retrieved specified currency related data (required)
     * @param ids Lending loan ID list separated by &#x60;,&#x60;. Maximum of 20 IDs are allowed in one request (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 201 </td><td> Loans merged </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call mergeLoansAsync(String currency, String ids, final ApiCallback<Loan> _callback) throws ApiException {
        okhttp3.Call localVarCall = mergeLoansValidateBeforeCall(currency, ids, _callback);
        Type localVarReturnType = new TypeToken<Loan>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    /**
     * Build call for getLoan
     * @param loanId Loan ID (required)
     * @param side Lend or borrow (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> List retrieved </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call getLoanCall(String loanId, String side, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/margin/loans/{loan_id}"
            .replaceAll("\\{" + "loan_id" + "\\}", localVarApiClient.escapeString(loanId));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
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
        return localVarApiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call getLoanValidateBeforeCall(String loanId, String side, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'loanId' is set
        if (loanId == null) {
            throw new ApiException("Missing the required parameter 'loanId' when calling getLoan(Async)");
        }

        // verify the required parameter 'side' is set
        if (side == null) {
            throw new ApiException("Missing the required parameter 'side' when calling getLoan(Async)");
        }

        okhttp3.Call localVarCall = getLoanCall(loanId, side, _callback);
        return localVarCall;
    }

    /**
     * Retrieve one single loan detail
     * 
     * @param loanId Loan ID (required)
     * @param side Lend or borrow (required)
     * @return Loan
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> List retrieved </td><td>  -  </td></tr>
     </table>
     */
    public Loan getLoan(String loanId, String side) throws ApiException {
        ApiResponse<Loan> localVarResp = getLoanWithHttpInfo(loanId, side);
        return localVarResp.getData();
    }

    /**
     * Retrieve one single loan detail
     * 
     * @param loanId Loan ID (required)
     * @param side Lend or borrow (required)
     * @return ApiResponse&lt;Loan&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> List retrieved </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<Loan> getLoanWithHttpInfo(String loanId, String side) throws ApiException {
        okhttp3.Call localVarCall = getLoanValidateBeforeCall(loanId, side, null);
        Type localVarReturnType = new TypeToken<Loan>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Retrieve one single loan detail (asynchronously)
     * 
     * @param loanId Loan ID (required)
     * @param side Lend or borrow (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> List retrieved </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call getLoanAsync(String loanId, String side, final ApiCallback<Loan> _callback) throws ApiException {
        okhttp3.Call localVarCall = getLoanValidateBeforeCall(loanId, side, _callback);
        Type localVarReturnType = new TypeToken<Loan>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    /**
     * Build call for cancelLoan
     * @param loanId Loan ID (required)
     * @param currency Retrieved specified currency related data (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Order cancelled </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call cancelLoanCall(String loanId, String currency, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/margin/loans/{loan_id}"
            .replaceAll("\\{" + "loan_id" + "\\}", localVarApiClient.escapeString(loanId));

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
        return localVarApiClient.buildCall(localVarPath, "DELETE", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call cancelLoanValidateBeforeCall(String loanId, String currency, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'loanId' is set
        if (loanId == null) {
            throw new ApiException("Missing the required parameter 'loanId' when calling cancelLoan(Async)");
        }

        // verify the required parameter 'currency' is set
        if (currency == null) {
            throw new ApiException("Missing the required parameter 'currency' when calling cancelLoan(Async)");
        }

        okhttp3.Call localVarCall = cancelLoanCall(loanId, currency, _callback);
        return localVarCall;
    }

    /**
     * Cancel lending loan
     * Only lending loans can be cancelled
     * @param loanId Loan ID (required)
     * @param currency Retrieved specified currency related data (required)
     * @return Loan
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Order cancelled </td><td>  -  </td></tr>
     </table>
     */
    public Loan cancelLoan(String loanId, String currency) throws ApiException {
        ApiResponse<Loan> localVarResp = cancelLoanWithHttpInfo(loanId, currency);
        return localVarResp.getData();
    }

    /**
     * Cancel lending loan
     * Only lending loans can be cancelled
     * @param loanId Loan ID (required)
     * @param currency Retrieved specified currency related data (required)
     * @return ApiResponse&lt;Loan&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Order cancelled </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<Loan> cancelLoanWithHttpInfo(String loanId, String currency) throws ApiException {
        okhttp3.Call localVarCall = cancelLoanValidateBeforeCall(loanId, currency, null);
        Type localVarReturnType = new TypeToken<Loan>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Cancel lending loan (asynchronously)
     * Only lending loans can be cancelled
     * @param loanId Loan ID (required)
     * @param currency Retrieved specified currency related data (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Order cancelled </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call cancelLoanAsync(String loanId, String currency, final ApiCallback<Loan> _callback) throws ApiException {
        okhttp3.Call localVarCall = cancelLoanValidateBeforeCall(loanId, currency, _callback);
        Type localVarReturnType = new TypeToken<Loan>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    /**
     * Build call for updateLoan
     * @param loanId Loan ID (required)
     * @param loanPatch  (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Updated </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call updateLoanCall(String loanId, LoanPatch loanPatch, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = loanPatch;

        // create path and map variables
        String localVarPath = "/margin/loans/{loan_id}"
            .replaceAll("\\{" + "loan_id" + "\\}", localVarApiClient.escapeString(loanId));

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
        return localVarApiClient.buildCall(localVarPath, "PATCH", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call updateLoanValidateBeforeCall(String loanId, LoanPatch loanPatch, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'loanId' is set
        if (loanId == null) {
            throw new ApiException("Missing the required parameter 'loanId' when calling updateLoan(Async)");
        }

        // verify the required parameter 'loanPatch' is set
        if (loanPatch == null) {
            throw new ApiException("Missing the required parameter 'loanPatch' when calling updateLoan(Async)");
        }

        okhttp3.Call localVarCall = updateLoanCall(loanId, loanPatch, _callback);
        return localVarCall;
    }

    /**
     * Modify a loan
     * Only &#x60;auto_renew&#x60; modification is supported currently
     * @param loanId Loan ID (required)
     * @param loanPatch  (required)
     * @return Loan
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Updated </td><td>  -  </td></tr>
     </table>
     */
    public Loan updateLoan(String loanId, LoanPatch loanPatch) throws ApiException {
        ApiResponse<Loan> localVarResp = updateLoanWithHttpInfo(loanId, loanPatch);
        return localVarResp.getData();
    }

    /**
     * Modify a loan
     * Only &#x60;auto_renew&#x60; modification is supported currently
     * @param loanId Loan ID (required)
     * @param loanPatch  (required)
     * @return ApiResponse&lt;Loan&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Updated </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<Loan> updateLoanWithHttpInfo(String loanId, LoanPatch loanPatch) throws ApiException {
        okhttp3.Call localVarCall = updateLoanValidateBeforeCall(loanId, loanPatch, null);
        Type localVarReturnType = new TypeToken<Loan>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Modify a loan (asynchronously)
     * Only &#x60;auto_renew&#x60; modification is supported currently
     * @param loanId Loan ID (required)
     * @param loanPatch  (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Updated </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call updateLoanAsync(String loanId, LoanPatch loanPatch, final ApiCallback<Loan> _callback) throws ApiException {
        okhttp3.Call localVarCall = updateLoanValidateBeforeCall(loanId, loanPatch, _callback);
        Type localVarReturnType = new TypeToken<Loan>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    /**
     * Build call for listLoanRepayments
     * @param loanId Loan ID (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> List retrieved </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call listLoanRepaymentsCall(String loanId, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/margin/loans/{loan_id}/repayment"
            .replaceAll("\\{" + "loan_id" + "\\}", localVarApiClient.escapeString(loanId));

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
    private okhttp3.Call listLoanRepaymentsValidateBeforeCall(String loanId, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'loanId' is set
        if (loanId == null) {
            throw new ApiException("Missing the required parameter 'loanId' when calling listLoanRepayments(Async)");
        }

        okhttp3.Call localVarCall = listLoanRepaymentsCall(loanId, _callback);
        return localVarCall;
    }

    /**
     * List loan repayment records
     * 
     * @param loanId Loan ID (required)
     * @return List&lt;Repayment&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> List retrieved </td><td>  -  </td></tr>
     </table>
     */
    public List<Repayment> listLoanRepayments(String loanId) throws ApiException {
        ApiResponse<List<Repayment>> localVarResp = listLoanRepaymentsWithHttpInfo(loanId);
        return localVarResp.getData();
    }

    /**
     * List loan repayment records
     * 
     * @param loanId Loan ID (required)
     * @return ApiResponse&lt;List&lt;Repayment&gt;&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> List retrieved </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<List<Repayment>> listLoanRepaymentsWithHttpInfo(String loanId) throws ApiException {
        okhttp3.Call localVarCall = listLoanRepaymentsValidateBeforeCall(loanId, null);
        Type localVarReturnType = new TypeToken<List<Repayment>>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * List loan repayment records (asynchronously)
     * 
     * @param loanId Loan ID (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> List retrieved </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call listLoanRepaymentsAsync(String loanId, final ApiCallback<List<Repayment>> _callback) throws ApiException {
        okhttp3.Call localVarCall = listLoanRepaymentsValidateBeforeCall(loanId, _callback);
        Type localVarReturnType = new TypeToken<List<Repayment>>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    /**
     * Build call for repayLoan
     * @param loanId Loan ID (required)
     * @param repayRequest  (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Loan repaid </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call repayLoanCall(String loanId, RepayRequest repayRequest, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = repayRequest;

        // create path and map variables
        String localVarPath = "/margin/loans/{loan_id}/repayment"
            .replaceAll("\\{" + "loan_id" + "\\}", localVarApiClient.escapeString(loanId));

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
    private okhttp3.Call repayLoanValidateBeforeCall(String loanId, RepayRequest repayRequest, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'loanId' is set
        if (loanId == null) {
            throw new ApiException("Missing the required parameter 'loanId' when calling repayLoan(Async)");
        }

        // verify the required parameter 'repayRequest' is set
        if (repayRequest == null) {
            throw new ApiException("Missing the required parameter 'repayRequest' when calling repayLoan(Async)");
        }

        okhttp3.Call localVarCall = repayLoanCall(loanId, repayRequest, _callback);
        return localVarCall;
    }

    /**
     * Repay a loan
     * 
     * @param loanId Loan ID (required)
     * @param repayRequest  (required)
     * @return Loan
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Loan repaid </td><td>  -  </td></tr>
     </table>
     */
    public Loan repayLoan(String loanId, RepayRequest repayRequest) throws ApiException {
        ApiResponse<Loan> localVarResp = repayLoanWithHttpInfo(loanId, repayRequest);
        return localVarResp.getData();
    }

    /**
     * Repay a loan
     * 
     * @param loanId Loan ID (required)
     * @param repayRequest  (required)
     * @return ApiResponse&lt;Loan&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Loan repaid </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<Loan> repayLoanWithHttpInfo(String loanId, RepayRequest repayRequest) throws ApiException {
        okhttp3.Call localVarCall = repayLoanValidateBeforeCall(loanId, repayRequest, null);
        Type localVarReturnType = new TypeToken<Loan>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Repay a loan (asynchronously)
     * 
     * @param loanId Loan ID (required)
     * @param repayRequest  (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Loan repaid </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call repayLoanAsync(String loanId, RepayRequest repayRequest, final ApiCallback<Loan> _callback) throws ApiException {
        okhttp3.Call localVarCall = repayLoanValidateBeforeCall(loanId, repayRequest, _callback);
        Type localVarReturnType = new TypeToken<Loan>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    private okhttp3.Call listLoanRecordsCall(String loanId, String status, Integer page, Integer limit, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/margin/loan_records";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (loanId != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("loan_id", loanId));
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
    private okhttp3.Call listLoanRecordsValidateBeforeCall(String loanId, String status, Integer page, Integer limit, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'loanId' is set
        if (loanId == null) {
            throw new ApiException("Missing the required parameter 'loanId' when calling listLoanRecords(Async)");
        }

        okhttp3.Call localVarCall = listLoanRecordsCall(loanId, status, page, limit, _callback);
        return localVarCall;
    }


    private ApiResponse<List<LoanRecord>> listLoanRecordsWithHttpInfo(String loanId, String status, Integer page, Integer limit) throws ApiException {
        okhttp3.Call localVarCall = listLoanRecordsValidateBeforeCall(loanId, status, page, limit, null);
        Type localVarReturnType = new TypeToken<List<LoanRecord>>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call listLoanRecordsAsync(String loanId, String status, Integer page, Integer limit, final ApiCallback<List<LoanRecord>> _callback) throws ApiException {
        okhttp3.Call localVarCall = listLoanRecordsValidateBeforeCall(loanId, status, page, limit, _callback);
        Type localVarReturnType = new TypeToken<List<LoanRecord>>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class APIlistLoanRecordsRequest {
        private final String loanId;
        private String status;
        private Integer page;
        private Integer limit;

        private APIlistLoanRecordsRequest(String loanId) {
            this.loanId = loanId;
        }

        /**
         * Set status
         * @param status Loan record status (optional)
         * @return APIlistLoanRecordsRequest
         */
        public APIlistLoanRecordsRequest status(String status) {
            this.status = status;
            return this;
        }

        /**
         * Set page
         * @param page Page number (optional, default to 1)
         * @return APIlistLoanRecordsRequest
         */
        public APIlistLoanRecordsRequest page(Integer page) {
            this.page = page;
            return this;
        }

        /**
         * Set limit
         * @param limit Maximum number of records returned in one list (optional, default to 100)
         * @return APIlistLoanRecordsRequest
         */
        public APIlistLoanRecordsRequest limit(Integer limit) {
            this.limit = limit;
            return this;
        }

        /**
         * Build call for listLoanRecords
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
            return listLoanRecordsCall(loanId, status, page, limit, _callback);
        }

        /**
         * Execute listLoanRecords request
         * @return List&lt;LoanRecord&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> List retrieved </td><td>  -  </td></tr>
         </table>
         */
        public List<LoanRecord> execute() throws ApiException {
            ApiResponse<List<LoanRecord>> localVarResp = listLoanRecordsWithHttpInfo(loanId, status, page, limit);
            return localVarResp.getData();
        }

        /**
         * Execute listLoanRecords request with HTTP info returned
         * @return ApiResponse&lt;List&lt;LoanRecord&gt;&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> List retrieved </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<List<LoanRecord>> executeWithHttpInfo() throws ApiException {
            return listLoanRecordsWithHttpInfo(loanId, status, page, limit);
        }

        /**
         * Execute listLoanRecords request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> List retrieved </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<List<LoanRecord>> _callback) throws ApiException {
            return listLoanRecordsAsync(loanId, status, page, limit, _callback);
        }
    }

    /**
     * List repayment records of specified loan
     * 
     * @param loanId Loan ID (required)
     * @return APIlistLoanRecordsRequest
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> List retrieved </td><td>  -  </td></tr>
     </table>
     */
    public APIlistLoanRecordsRequest listLoanRecords(String loanId) {
        return new APIlistLoanRecordsRequest(loanId);
    }

    /**
     * Build call for getLoanRecord
     * @param loanRecordId Loan record ID (required)
     * @param loanId Loan ID (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Detail retrieved </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call getLoanRecordCall(String loanRecordId, String loanId, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/margin/loan_records/{loan_record_id}"
            .replaceAll("\\{" + "loan_record_id" + "\\}", localVarApiClient.escapeString(loanRecordId));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (loanId != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("loan_id", loanId));
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
    private okhttp3.Call getLoanRecordValidateBeforeCall(String loanRecordId, String loanId, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'loanRecordId' is set
        if (loanRecordId == null) {
            throw new ApiException("Missing the required parameter 'loanRecordId' when calling getLoanRecord(Async)");
        }

        // verify the required parameter 'loanId' is set
        if (loanId == null) {
            throw new ApiException("Missing the required parameter 'loanId' when calling getLoanRecord(Async)");
        }

        okhttp3.Call localVarCall = getLoanRecordCall(loanRecordId, loanId, _callback);
        return localVarCall;
    }

    /**
     * Get one single loan record
     * 
     * @param loanRecordId Loan record ID (required)
     * @param loanId Loan ID (required)
     * @return LoanRecord
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Detail retrieved </td><td>  -  </td></tr>
     </table>
     */
    public LoanRecord getLoanRecord(String loanRecordId, String loanId) throws ApiException {
        ApiResponse<LoanRecord> localVarResp = getLoanRecordWithHttpInfo(loanRecordId, loanId);
        return localVarResp.getData();
    }

    /**
     * Get one single loan record
     * 
     * @param loanRecordId Loan record ID (required)
     * @param loanId Loan ID (required)
     * @return ApiResponse&lt;LoanRecord&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Detail retrieved </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<LoanRecord> getLoanRecordWithHttpInfo(String loanRecordId, String loanId) throws ApiException {
        okhttp3.Call localVarCall = getLoanRecordValidateBeforeCall(loanRecordId, loanId, null);
        Type localVarReturnType = new TypeToken<LoanRecord>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Get one single loan record (asynchronously)
     * 
     * @param loanRecordId Loan record ID (required)
     * @param loanId Loan ID (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Detail retrieved </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call getLoanRecordAsync(String loanRecordId, String loanId, final ApiCallback<LoanRecord> _callback) throws ApiException {
        okhttp3.Call localVarCall = getLoanRecordValidateBeforeCall(loanRecordId, loanId, _callback);
        Type localVarReturnType = new TypeToken<LoanRecord>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    /**
     * Build call for updateLoanRecord
     * @param loanRecordId Loan record ID (required)
     * @param loanPatch  (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Loan record updated </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call updateLoanRecordCall(String loanRecordId, LoanPatch loanPatch, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = loanPatch;

        // create path and map variables
        String localVarPath = "/margin/loan_records/{loan_record_id}"
            .replaceAll("\\{" + "loan_record_id" + "\\}", localVarApiClient.escapeString(loanRecordId));

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
        return localVarApiClient.buildCall(localVarPath, "PATCH", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call updateLoanRecordValidateBeforeCall(String loanRecordId, LoanPatch loanPatch, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'loanRecordId' is set
        if (loanRecordId == null) {
            throw new ApiException("Missing the required parameter 'loanRecordId' when calling updateLoanRecord(Async)");
        }

        // verify the required parameter 'loanPatch' is set
        if (loanPatch == null) {
            throw new ApiException("Missing the required parameter 'loanPatch' when calling updateLoanRecord(Async)");
        }

        okhttp3.Call localVarCall = updateLoanRecordCall(loanRecordId, loanPatch, _callback);
        return localVarCall;
    }

    /**
     * Modify a loan record
     * Only &#x60;auto_renew&#x60; modification is supported currently
     * @param loanRecordId Loan record ID (required)
     * @param loanPatch  (required)
     * @return LoanRecord
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Loan record updated </td><td>  -  </td></tr>
     </table>
     */
    public LoanRecord updateLoanRecord(String loanRecordId, LoanPatch loanPatch) throws ApiException {
        ApiResponse<LoanRecord> localVarResp = updateLoanRecordWithHttpInfo(loanRecordId, loanPatch);
        return localVarResp.getData();
    }

    /**
     * Modify a loan record
     * Only &#x60;auto_renew&#x60; modification is supported currently
     * @param loanRecordId Loan record ID (required)
     * @param loanPatch  (required)
     * @return ApiResponse&lt;LoanRecord&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Loan record updated </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<LoanRecord> updateLoanRecordWithHttpInfo(String loanRecordId, LoanPatch loanPatch) throws ApiException {
        okhttp3.Call localVarCall = updateLoanRecordValidateBeforeCall(loanRecordId, loanPatch, null);
        Type localVarReturnType = new TypeToken<LoanRecord>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Modify a loan record (asynchronously)
     * Only &#x60;auto_renew&#x60; modification is supported currently
     * @param loanRecordId Loan record ID (required)
     * @param loanPatch  (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Loan record updated </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call updateLoanRecordAsync(String loanRecordId, LoanPatch loanPatch, final ApiCallback<LoanRecord> _callback) throws ApiException {
        okhttp3.Call localVarCall = updateLoanRecordValidateBeforeCall(loanRecordId, loanPatch, _callback);
        Type localVarReturnType = new TypeToken<LoanRecord>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

}
