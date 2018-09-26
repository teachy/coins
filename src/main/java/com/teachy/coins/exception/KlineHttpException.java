package com.teachy.coins.exception;

import javax.xml.ws.http.HTTPException;

public class KlineHttpException extends HTTPException{
	public KlineHttpException(int statusCode){
		super(statusCode);
	}

}
