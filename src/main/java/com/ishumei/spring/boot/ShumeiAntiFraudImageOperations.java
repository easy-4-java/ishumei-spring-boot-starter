/*
 * Copyright (c) 2018, hiwepy (https://github.com/easy-4-java).
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.ishumei.spring.boot;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.util.DigestUtils;
import org.springframework.util.FileCopyUtils;

import com.ishumei.spring.boot.model.AntiFraudImageRequest;
import com.ishumei.spring.boot.model.AntiFraudImageRequestData;
import com.ishumei.spring.boot.model.AntiFraudImageRequestItem;
import com.ishumei.spring.boot.model.AntiFraudImageResponse;
import com.ishumei.spring.boot.model.BatchAntiFraudImageResponse;

import lombok.extern.slf4j.Slf4j;

/**
 * Image moderation operations for the Shumei (数美) anti-fraud service.
 * <p>See <a href="https://www.ishumei.com/help/documents.html?id=21210">the image API reference</a>.</p>
 *
 * @author [@Loong Wan](https://github.com/loong10k)
 * @since 1.0.0
 */
@Slf4j
public class ShumeiAntiFraudImageOperations extends ShumeiAntiFraudOperations {

	/**
	 * Creates image-moderation operations bound to the given template.
	 * @param timTemplate the template used to execute Shumei requests
	 */
	public ShumeiAntiFraudImageOperations(ShumeiAntiFraudTemplate timTemplate) {
		super(timTemplate);
	}

	/**
	 * 1. Image moderation from a {@link File}. The file is Base64-encoded before submission.
	 * <p>API: <a href="https://www.ishumei.com/help/documents.html?id=21210">image moderation</a>.</p>
	 * @param type platform business type (uppercase): ZHIBO, ECOM, GAME, NEWS, FORUM, SOCIAL
	 * @param tokenId unique client user id (for behaviour analysis); pass a distinct value per user
	 * @param img the image to check. Supports jpg, jpeg, jp2, png, webp, gif, bmp, tiff, tif, dib,
	 *            ppm, pgm, pbm, hdr, pic. Recommended at least 256x256 pixels.
	 * @return the moderation response
	 * @throws IOException when reading the file fails
	 * @throws UnsupportedEncodingException when the file cannot be Base64-encoded
	 */
	public AntiFraudImageResponse antiFraud(String type, String tokenId, File img) throws UnsupportedEncodingException, IOException {
		String imgBase64 = new String(Base64.getEncoder().encode(FileCopyUtils.copyToByteArray(img)), "ISO-8859-1");
        return this.antiFraud(type, tokenId, imgBase64);
	}

	/**
	 * 2. Image moderation from an {@link InputStream}. The stream is Base64-encoded before submission.
	 * <p>API: <a href="https://www.ishumei.com/help/documents.html?id=21210">image moderation</a>.</p>
	 * @param type platform business type (uppercase): ZHIBO, ECOM, GAME, NEWS, FORUM, SOCIAL
	 * @param tokenId unique client user id (for behaviour analysis); pass a distinct value per user
	 * @param img the image to check. Supports jpg, jpeg, jp2, png, webp, gif, bmp, tiff, tif, dib,
	 *            ppm, pgm, pbm, hdr, pic. Recommended at least 256x256 pixels.
	 * @return the moderation response
	 * @throws IOException when reading the stream fails
	 * @throws UnsupportedEncodingException when the stream cannot be Base64-encoded
	 */
	public AntiFraudImageResponse antiFraud(String type, String tokenId, InputStream img) throws UnsupportedEncodingException, IOException {
		String imgBase64 = new String(Base64.getEncoder().encode(FileCopyUtils.copyToByteArray(img)), "ISO-8859-1");
        return this.antiFraud(type, tokenId, imgBase64);
	}

	/**
	 * 3. Image moderation from a Base64-encoded string or image URL.
	 * <p>API: <a href="https://www.ishumei.com/help/documents.html?id=21210">image moderation</a>.</p>
	 * @param type platform business type (uppercase): ZHIBO, ECOM, GAME, NEWS, FORUM, SOCIAL
	 * @param tokenId unique client user id (for behaviour analysis); pass a distinct value per user
	 * @param img the image to check: a Base64-encoded string or a URL. Supports jpg, jpeg, jp2, png,
	 *            webp, gif, bmp, tiff, tif, dib, ppm, pgm, pbm, hdr, pic. Recommended at least 256x256 pixels.
	 * @return the moderation response
	 */
	public AntiFraudImageResponse antiFraud(String type, String tokenId, String img) {

		AntiFraudImageRequest payload = new AntiFraudImageRequest();
		payload.setAccessKey(getTemplate().getProperties().getAccessKey());
		payload.setAppId(getTemplate().getProperties().getAppId());
		payload.setType(type);

		AntiFraudImageRequestData data = new AntiFraudImageRequestData();
		data.setChannel(getTemplate().getProperties().getChannelImg());
		data.setTokenId(tokenId);
		data.setImg(img);

		payload.setData(data);
		AntiFraudImageResponse res = requestInvoke(getTemplate().getProperties().getAntiFraudImgUrl(), payload, AntiFraudImageResponse.class);
		return res;
	}


	/**
	 * 3b. Image moderation test entry point (same payload as {@link #antiFraud(String, String, String)}).
	 * <p>API: <a href="https://www.ishumei.com/help/documents.html?id=21210">image moderation</a>.</p>
	 * @param type platform business type (uppercase): ZHIBO, ECOM, GAME, NEWS, FORUM, SOCIAL
	 * @param tokenId unique client user id (for behaviour analysis); pass a distinct value per user
	 * @param img the image to check: a Base64-encoded string or a URL. Supports jpg, jpeg, jp2, png,
	 *            webp, gif, bmp, tiff, tif, dib, ppm, pgm, pbm, hdr, pic. Recommended at least 256x256 pixels.
	 * @return the moderation response
	 */
	public AntiFraudImageResponse antiFraudTest(String type, String tokenId, String img) {

		AntiFraudImageRequest payload = new AntiFraudImageRequest();
		payload.setAccessKey(getTemplate().getProperties().getAccessKey());
		payload.setAppId(getTemplate().getProperties().getAppId());
		payload.setType(type);

		AntiFraudImageRequestData data = new AntiFraudImageRequestData();
		data.setChannel(getTemplate().getProperties().getChannelImg());
		data.setTokenId(tokenId);
		data.setImg(img);

		payload.setData(data);

		AntiFraudImageResponse res = requestInvoke(getTemplate().getProperties().getAntiFraudImgUrl(), payload, AntiFraudImageResponse.class);
		return res;
	}

	/**
	 * 4. Batch image moderation. Each image gets a derived btId (md5 of the image content).
	 * <p>API: <a href="https://www.ishumei.com/help/documents.html?id=21210">image moderation</a>.</p>
	 * @param type recognition types joined by underscore, e.g. {@code AD_PORN_POLITICS}.
	 *             {@code DEFAULT} = POLITICS_PORN_AD. {@code POLITICS} = {@code PERSON} + {@code VIOLENCE}.
	 *             Others: {@code PORN}, {@code OCR}, {@code AD}, {@code LOGO}, {@code BEHAVIOR}.
	 * @param tokenId unique client user id (for behaviour analysis); pass a distinct value per user
	 * @param imgs the images to check: Base64-encoded strings or URLs. Supports jpg, jpeg, jp2, png,
	 *             webp, gif, bmp, tiff, tif, dib, ppm, pgm, pbm, hdr, pic. Recommended at least 256x256 pixels.
	 * @return the batch moderation response
	 */
	public BatchAntiFraudImageResponse antiFraud(String type, String tokenId, List<String> imgs) {

		AntiFraudImageRequest payload = new AntiFraudImageRequest();
		payload.setAccessKey(getTemplate().getProperties().getAccessKey());
		payload.setAppId(getTemplate().getProperties().getAppId());
		payload.setType(type);

		AntiFraudImageRequestData data = new AntiFraudImageRequestData();
		data.setChannel(getTemplate().getProperties().getChannelImg());
		data.setTokenId(tokenId);
		data.setImgs(imgs.stream().map(img -> {
			AntiFraudImageRequestItem item = new AntiFraudImageRequestItem();
			item.setBtId(DigestUtils.md5DigestAsHex(img.getBytes()));
			item.setImg(img);
			item.setTokenId(tokenId);
			return item;
		}).collect(Collectors.toList()));

		payload.setData(data);

		BatchAntiFraudImageResponse res = requestInvoke(getTemplate().getProperties().getAntiFraudImgsUrl(), payload, BatchAntiFraudImageResponse.class);

		return res;
	}


	/**
	 * 5. Batch image moderation with per-image request items (each carries its own user id).
	 * <p>API: <a href="https://www.ishumei.com/help/documents.html?id=21210">image moderation</a>.</p>
	 * @param type recognition types joined by underscore, e.g. {@code AD_PORN_POLITICS}.
	 *             {@code DEFAULT} = POLITICS_PORN_AD. {@code POLITICS} = {@code PERSON} + {@code VIOLENCE}.
	 *             Others: {@code PORN}, {@code OCR}, {@code AD}, {@code LOGO}, {@code BEHAVIOR}.
	 * @param tokenId unique client user id (for behaviour analysis); pass a distinct value per user
	 * @param imgs the per-image request items (Base64-encoded strings or URLs). Supports jpg, jpeg,
	 *             jp2, png, webp, gif, bmp, tiff, tif, dib, ppm, pgm, pbm, hdr, pic. Recommended 256x256+ pixels.
	 * @return the batch moderation response
	 */
	public BatchAntiFraudImageResponse antiFrauds(String type, String tokenId, List<AntiFraudImageRequestItem> imgs) {

		AntiFraudImageRequest payload = new AntiFraudImageRequest();
		payload.setAccessKey(getTemplate().getProperties().getAccessKey());
		payload.setAppId(getTemplate().getProperties().getAppId());
		payload.setType(type);

		AntiFraudImageRequestData data = new AntiFraudImageRequestData();
		data.setChannel(getTemplate().getProperties().getChannelImg());
		data.setTokenId(tokenId);
		data.setImgs(imgs);
		payload.setData(data);

		BatchAntiFraudImageResponse res = requestInvoke(getTemplate().getProperties().getAntiFraudImgsUrl(), payload, BatchAntiFraudImageResponse.class);

		return res;
	}

}
