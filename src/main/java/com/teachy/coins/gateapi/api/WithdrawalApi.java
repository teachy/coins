


package com.teachy.coins.gateapi.api;

import com.teachy.coins.gateapi.ApiCallback;
import com.teachy.coins.gateapi.ApiClient;
import com.teachy.coins.gateapi.ApiException;
import com.teachy.coins.gateapi.ApiResponse;
import com.teachy.coins.gateapi.Configuration;
import com.teachy.coins.gateapi.Pair;

import com.google.gson.reflect.TypeToken;


import com.teachy.coins.gateapi.models.LedgerRecord;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WithdrawalApi {
    private ApiClient localVarApiClient;

    public WithdrawalApi() {
        this(Configuration.getDefaultApiClient());
    }

    public WithdrawalApi(ApiClient apiClient) {
        this.localVarApiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return localVarApiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.localVarApiClient = apiClient;
    }

    /**
     * Build call for withdraw
     * @param ledgerRecord  (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 202 </td><td> Withdraw request is accepted. Refer to withdrawal records for status </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call withdrawCall(LedgerRecord ledgerRecord, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = ledgerRecord;

        // create path and map variables
        String localVarPath = "/withdrawals";

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
    private okhttp3.Call withdrawValidateBeforeCall(LedgerRecord ledgerRecord, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'ledgerRecord' is set
        if (ledgerRecord == null) {
            throw new ApiException("Missing the required parameter 'ledgerRecord' when calling withdraw(Async)");
        }

        okhttp3.Call localVarCall = withdrawCall(ledgerRecord, _callback);
        return localVarCall;
    }

    /**
     * Withdraw
     * 
     * @param ledgerRecord  (required)
     * @return LedgerRecord
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 202 </td><td> Withdraw request is accepted. Refer to withdrawal records for status </td><td>  -  </td></tr>
     </table>
     */
    public LedgerRecord withdraw(LedgerRecord ledgerRecord) throws ApiException {
        ApiResponse<LedgerRecord> localVarResp = withdrawWithHttpInfo(ledgerRecord);
        return localVarResp.getData();
    }

    /**
     * Withdraw
     * 
     * @param ledgerRecord  (required)
     * @return ApiResponse&lt;LedgerRecord&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 202 </td><td> Withdraw request is accepted. Refer to withdrawal records for status </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<LedgerRecord> withdrawWithHttpInfo(LedgerRecord ledgerRecord) throws ApiException {
        okhttp3.Call localVarCall = withdrawValidateBeforeCall(ledgerRecord, null);
        Type localVarReturnType = new TypeToken<LedgerRecord>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Withdraw (asynchronously)
     * 
     * @param ledgerRecord  (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 202 </td><td> Withdraw request is accepted. Refer to withdrawal records for status </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call withdrawAsync(LedgerRecord ledgerRecord, final ApiCallback<LedgerRecord> _callback) throws ApiException {
        okhttp3.Call localVarCall = withdrawValidateBeforeCall(ledgerRecord, _callback);
        Type localVarReturnType = new TypeToken<LedgerRecord>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

}
