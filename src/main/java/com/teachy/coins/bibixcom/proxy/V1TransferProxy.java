package com.teachy.coins.bibixcom.proxy;

import com.teachy.coins.bibixcom.BiBoxHttpClientConfig;
import com.teachy.coins.bibixcom.common.UrlConstants;
import com.teachy.coins.bibixcom.utils.HttpClientHelper;
import com.teachy.coins.bibixcom.utils.V1ParamsUtils;
import com.teachy.coins.bibixcom.vo.TransferInListParams;
import com.teachy.coins.bibixcom.vo.TransferOutListParams;
import com.teachy.coins.bibixcom.vo.TransferOutParams;

import java.io.IOException;

public class V1TransferProxy extends BaseProxy
{

    public V1TransferProxy(BiBoxHttpClientConfig config, HttpClientHelper helper)
    {
        super.config = config;
        super.helper = helper;
    }

    @Override
    public String getUrl()
    {
        return config.getHost().concat(UrlConstants.V1_TRANSFER);
    }

    public String transferAssets(Integer select) throws IOException
    {
        return postSign(V1ParamsUtils.createTransferAssetsCmd(select));
    }

    public String transferMainAssets(Integer select) throws IOException
    {
        return postSign(V1ParamsUtils.createTransferMainAssetsCmd(select));
    }

    public String transferCreditAssets(Integer select) throws IOException
    {
        return postSign(V1ParamsUtils.createTransferCreditAssetsCmd(select));
    }


    public String transferTransferIn(String symbol) throws IOException
    {
        return postSign(V1ParamsUtils.createTransferTransferInCmd(symbol));
    }

    public String transferTransferOut(TransferOutParams params) throws IOException
    {
        return postSign(V1ParamsUtils.createTransferTransferOutCmd(params));
    }

    public String transferTransferInList(TransferInListParams params) throws IOException
    {
        return postSign(V1ParamsUtils.createTransferTransferInListCmd(params));
    }

    public String transferTransferOutList(TransferOutListParams params) throws IOException
    {
        return postSign(V1ParamsUtils.createTransferTransferOutListCmd(params));
    }

    public String transferCoinConfig(String symbol) throws IOException
    {
        return postSign(V1ParamsUtils.createTransferTransferCoinConfigCmd(symbol));
    }

    public String transferWithdrawInfo(Long id) throws IOException
    {
        return postSign(V1ParamsUtils.createTransferTransferWithdrawInfoCmd(id));
    }

}
