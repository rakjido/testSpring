package com.rooftophero.service;


import org.springframework.stereotype.Service;

import com.rooftophero.utils.AES256;
import com.rooftophero.vo.WebVo;

@Service
public class WebService {

	public WebVo encryptWeb(WebVo vo) {
		vo.setContents(AES256.encrypt(vo.getContents(), vo.getPassword()));
		vo.setPassword(null);
		return vo;
	}

	public WebVo decryptWeb(WebVo vo) {
		vo.setContents(AES256.decrypt(vo.getContents(), vo.getPassword()));
		vo.setPassword(null);
		return vo;
	}

}
