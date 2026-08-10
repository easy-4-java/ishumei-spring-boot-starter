package com.ishumei.spring.boot;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ishumei.spring.boot.model.*;
import okhttp3.OkHttpClient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for Shumei anti-fraud starter components.
 *
 * @author <a href="https://github.com/loong10k">Loong Wan</a>
 * @since 1.0.0
 */
public class ShumeiAntiFraudTest {

    ObjectMapper objectMapper = new ObjectMapper();
    OkHttpClient okhttp3Client = new OkHttpClient.Builder().build();
    ShumeiAntiFraudProperties properties = new ShumeiAntiFraudProperties();

    @BeforeEach
    public void setup() {
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        properties.setAccessKey("testKey");
        properties.setAppId("testApp");
        properties.setChannelTxt("testChannelTxt");
        properties.setChannelImg("testChannelImg");
        properties.setChannelAudio("testChannelAudio");
        properties.setChannelVideo("testChannelVideo");
        properties.setType("SOCIAL");
    }

    // --- Template tests ---

    @Test
    public void templateCreation() {
        ShumeiAntiFraudTemplate template = new ShumeiAntiFraudTemplate(properties, objectMapper, okhttp3Client);
        assertThat(template.getProperties()).isSameAs(properties);
        assertThat(template.getObjectMapper()).isSameAs(objectMapper);
        assertThat(template.getOkhttp3Client()).isSameAs(okhttp3Client);
    }

    @Test
    public void templateOpsForText() {
        ShumeiAntiFraudTemplate template = new ShumeiAntiFraudTemplate(properties, objectMapper, okhttp3Client);
        assertThat(template.opsForText()).isNotNull();
        assertThat(template.opsForText().getTemplate()).isSameAs(template);
    }

    @Test
    public void templateOpsForImage() {
        ShumeiAntiFraudTemplate template = new ShumeiAntiFraudTemplate(properties, objectMapper, okhttp3Client);
        assertThat(template.opsForImage()).isNotNull();
        assertThat(template.opsForImage().getTemplate()).isSameAs(template);
    }

    @Test
    public void templateOpsForVideo() {
        ShumeiAntiFraudTemplate template = new ShumeiAntiFraudTemplate(properties, objectMapper, okhttp3Client);
        assertThat(template.opsForVideo()).isNotNull();
        assertThat(template.opsForVideo().getTemplate()).isSameAs(template);
    }

    // --- Properties tests ---

    @Test
    public void propertiesGettersAndSetters() {
        ShumeiAntiFraudProperties props = new ShumeiAntiFraudProperties();
        props.setAppId("appId");
        props.setAccessKey("accessKey");
        props.setType("SOCIAL");
        props.setChannelTxt("chTxt");
        props.setChannelImg("chImg");
        props.setChannelAudio("chAudio");
        props.setChannelVideo("chVideo");
        props.setAntiFraudTxtUrl("http://txt");
        props.setAntiFraudImgUrl("http://img");
        props.setAntiFraudImgsUrl("http://imgs");
        props.setAntiFraudAudioUrl("http://audio");
        props.setAntiFraudAudioStreamUrl("http://audiostream");
        props.setAntiFraudVideoUrl("http://video");
        props.setAntiFraudVideoStreamUrl("http://videostream");

        assertThat(props.getAppId()).isEqualTo("appId");
        assertThat(props.getAccessKey()).isEqualTo("accessKey");
        assertThat(props.getType()).isEqualTo("SOCIAL");
        assertThat(props.getChannelTxt()).isEqualTo("chTxt");
        assertThat(props.getChannelImg()).isEqualTo("chImg");
        assertThat(props.getChannelAudio()).isEqualTo("chAudio");
        assertThat(props.getChannelVideo()).isEqualTo("chVideo");
        assertThat(props.getAntiFraudTxtUrl()).isEqualTo("http://txt");
        assertThat(props.getAntiFraudImgUrl()).isEqualTo("http://img");
        assertThat(props.getAntiFraudImgsUrl()).isEqualTo("http://imgs");
        assertThat(props.getAntiFraudAudioUrl()).isEqualTo("http://audio");
        assertThat(props.getAntiFraudAudioStreamUrl()).isEqualTo("http://audiostream");
        assertThat(props.getAntiFraudVideoUrl()).isEqualTo("http://video");
        assertThat(props.getAntiFraudVideoStreamUrl()).isEqualTo("http://videostream");
    }

    @Test
    public void propertiesDefaultUrls() {
        ShumeiAntiFraudProperties props = new ShumeiAntiFraudProperties();
        assertThat(props.getAntiFraudTxtUrl()).contains("api-text-bj");
        assertThat(props.getAntiFraudImgUrl()).contains("api-img-bj");
        assertThat(props.getAntiFraudImgsUrl()).contains("api-img-bj");
        assertThat(props.getAntiFraudAudioUrl()).contains("api-audio-bj");
        assertThat(props.getAntiFraudAudioStreamUrl()).contains("api-audiostream-bj");
        assertThat(props.getAntiFraudVideoUrl()).contains("api-video-bj");
        assertThat(props.getAntiFraudVideoStreamUrl()).contains("api-videostream-bj");
    }

    // --- OkHttp3Properties tests ---

    @Test
    public void okHttp3PropertiesGettersAndSetters() {
        ShumeiOkHttp3Properties props = new ShumeiOkHttp3Properties();
        props.setFollowSslRedirects(true);
        props.setFollowRedirects(true);
        props.setRetryOnConnectionFailure(true);
        props.setCallTimeout(5000);
        props.setConnectTimeout(3000);
        props.setReadTimeout(3000);
        props.setWriteTimeout(3000);
        props.setPingInterval(1000);
        props.setMaxIdleConnections(100);

        assertThat(props.isFollowSslRedirects()).isTrue();
        assertThat(props.isFollowRedirects()).isTrue();
        assertThat(props.isRetryOnConnectionFailure()).isTrue();
        assertThat(props.getCallTimeout()).isEqualTo(5000);
        assertThat(props.getConnectTimeout()).isEqualTo(3000);
        assertThat(props.getReadTimeout()).isEqualTo(3000);
        assertThat(props.getWriteTimeout()).isEqualTo(3000);
        assertThat(props.getPingInterval()).isEqualTo(1000);
        assertThat(props.getMaxIdleConnections()).isEqualTo(100);
    }

    @Test
    public void okHttp3PropertiesDefaults() {
        ShumeiOkHttp3Properties props = new ShumeiOkHttp3Properties();
        assertThat(props.getConnectTimeout()).isEqualTo(10);
        assertThat(props.getReadTimeout()).isEqualTo(10);
        assertThat(props.getWriteTimeout()).isEqualTo(10);
        assertThat(props.getPingInterval()).isEqualTo(0);
        assertThat(props.getMaxIdleConnections()).isEqualTo(200);
        assertThat(props.getKeepAliveDuration()).isNotNull();
    }

    // --- Text operations tests ---

    @Test
    public void textOperationsAntiFraudWithNickname() {
        ShumeiAntiFraudTemplate template = new ShumeiAntiFraudTemplate(properties, objectMapper, okhttp3Client);
        ShumeiAntiFraudTextOperations ops = template.opsForText();
        AntiFraudResponse response = ops.antiFraud("SOCIAL", "token1", "nickname");
        assertThat(response).isNotNull();
    }

    @Test
    public void textOperationsAntiFraudWithText() {
        ShumeiAntiFraudTemplate template = new ShumeiAntiFraudTemplate(properties, objectMapper, okhttp3Client);
        ShumeiAntiFraudTextOperations ops = template.opsForText();
        AntiFraudResponse response = ops.antiFraud("SOCIAL", "token1", "nickname", "text to check");
        assertThat(response).isNotNull();
    }

    // --- Image operations tests ---

    @Test
    public void imageOperationsAntiFraudWithString() {
        ShumeiAntiFraudTemplate template = new ShumeiAntiFraudTemplate(properties, objectMapper, okhttp3Client);
        ShumeiAntiFraudImageOperations ops = template.opsForImage();
        AntiFraudImageResponse response = ops.antiFraud("POLITICS_PORN_AD", "token1", "http://example.com/img.jpg");
        assertThat(response).isNotNull();
    }

    @Test
    public void imageOperationsAntiFraudTest() {
        ShumeiAntiFraudTemplate template = new ShumeiAntiFraudTemplate(properties, objectMapper, okhttp3Client);
        ShumeiAntiFraudImageOperations ops = template.opsForImage();
        AntiFraudImageResponse response = ops.antiFraudTest("POLITICS_PORN_AD", "token1", "http://example.com/img.jpg");
        assertThat(response).isNotNull();
    }

    @Test
    public void imageOperationsAntiFraudBatch() {
        ShumeiAntiFraudTemplate template = new ShumeiAntiFraudTemplate(properties, objectMapper, okhttp3Client);
        ShumeiAntiFraudImageOperations ops = template.opsForImage();
        java.util.List<String> imgs = java.util.Arrays.asList("http://example.com/img1.jpg", "http://example.com/img2.jpg");
        BatchAntiFraudImageResponse response = ops.antiFraud("POLITICS_PORN_AD", "token1", imgs);
        assertThat(response).isNotNull();
    }

    @Test
    public void imageOperationsAntiFrauds() {
        ShumeiAntiFraudTemplate template = new ShumeiAntiFraudTemplate(properties, objectMapper, okhttp3Client);
        ShumeiAntiFraudImageOperations ops = template.opsForImage();
        AntiFraudImageRequestItem item = new AntiFraudImageRequestItem();
        item.setImg("http://example.com/img.jpg");
        item.setTokenId("token1");
        java.util.List<AntiFraudImageRequestItem> items = java.util.Collections.singletonList(item);
        BatchAntiFraudImageResponse response = ops.antiFrauds("POLITICS_PORN_AD", "token1", items);
        assertThat(response).isNotNull();
    }

    // --- Video operations tests ---

    @Test
    public void videoOperationsAntiFraud() throws Exception {
        ShumeiAntiFraudTemplate template = new ShumeiAntiFraudTemplate(properties, objectMapper, okhttp3Client);
        ShumeiAntiFraudVideoOperations ops = template.opsForVideo();
        AntiFraudVideoResponse response = ops.antiFraud("SOCIAL", "token1", (java.io.File) null);
        assertThat(response).isNotNull();
    }

    // --- readValue tests ---

    @Test
    public void readValueWithNull() {
        ShumeiAntiFraudTemplate template = new ShumeiAntiFraudTemplate(properties, objectMapper, okhttp3Client);
        ShumeiAntiFraudTextOperations ops = template.opsForText();
        AntiFraudResponse result = ops.readValue(null, AntiFraudResponse.class);
        assertThat(result).isNotNull();
    }

    @Test
    public void readValueWithInvalidJson() {
        ShumeiAntiFraudTemplate template = new ShumeiAntiFraudTemplate(properties, objectMapper, okhttp3Client);
        ShumeiAntiFraudTextOperations ops = template.opsForText();
        AntiFraudResponse result = ops.readValue("invalid json", AntiFraudResponse.class);
        assertThat(result).isNotNull();
    }

    @Test
    public void readValueWithValidJson() {
        ShumeiAntiFraudTemplate template = new ShumeiAntiFraudTemplate(properties, objectMapper, okhttp3Client);
        ShumeiAntiFraudTextOperations ops = template.opsForText();
        AntiFraudResponse result = ops.readValue("{\"code\":\"1100\"}", AntiFraudResponse.class);
        assertThat(result).isNotNull();
        assertThat(result.getCode()).isEqualTo("1100");
    }

    // --- Model tests ---

    @Test
    public void antiFraudRequestGettersAndSetters() {
        AntiFraudRequest req = new AntiFraudRequest();
        req.setAppId("app1");
        req.setAccessKey("key1");
        req.setType("SOCIAL");
        assertThat(req.getAppId()).isEqualTo("app1");
        assertThat(req.getAccessKey()).isEqualTo("key1");
        assertThat(req.getType()).isEqualTo("SOCIAL");
    }

    @Test
    public void antiFraudRequestDataGettersAndSetters() {
        AntiFraudRequestData data = new AntiFraudRequestData();
        data.setTokenId("tok1");
        data.setChannel("ch1");
        data.setIp("1.2.3.4");
        data.setPhone("123456");
        data.setDeviceId("dev1");
        data.setReceiveTokenId("rtok1");
        data.setLevel("1");
        data.setRegisterTime("2020-01-01");
        data.setFriendNum("100");
        data.setFansNum("200");
        data.setRole("ADMIN");
        data.setTopic("topic1");
        data.setIsPremiumUser(1);

        assertThat(data.getTokenId()).isEqualTo("tok1");
        assertThat(data.getChannel()).isEqualTo("ch1");
        assertThat(data.getIp()).isEqualTo("1.2.3.4");
        assertThat(data.getPhone()).isEqualTo("123456");
        assertThat(data.getDeviceId()).isEqualTo("dev1");
        assertThat(data.getReceiveTokenId()).isEqualTo("rtok1");
        assertThat(data.getLevel()).isEqualTo("1");
        assertThat(data.getRegisterTime()).isEqualTo("2020-01-01");
        assertThat(data.getFriendNum()).isEqualTo("100");
        assertThat(data.getFansNum()).isEqualTo("200");
        assertThat(data.getRole()).isEqualTo("ADMIN");
        assertThat(data.getTopic()).isEqualTo("topic1");
        assertThat(data.getIsPremiumUser()).isEqualTo(1);
    }

    @Test
    public void antiFraudTextRequestDataGettersAndSetters() {
        AntiFraudTextRequestData data = new AntiFraudTextRequestData();
        data.setText("hello");
        data.setGender(1);
        data.setNickname("nick");
        data.setRoom("room1");
        data.setIsTokenSeperate(1);
        data.setTokenId("tok1");
        data.setChannel("ch1");

        assertThat(data.getText()).isEqualTo("hello");
        assertThat(data.getGender()).isEqualTo(1);
        assertThat(data.getNickname()).isEqualTo("nick");
        assertThat(data.getRoom()).isEqualTo("room1");
        assertThat(data.getIsTokenSeperate()).isEqualTo(1);
        assertThat(data.getTokenId()).isEqualTo("tok1");
        assertThat(data.getChannel()).isEqualTo("ch1");
    }

    @Test
    public void antiFraudTextRequestGettersAndSetters() {
        AntiFraudTextRequest req = new AntiFraudTextRequest();
        AntiFraudTextRequestData data = new AntiFraudTextRequestData();
        data.setText("text");
        req.setData(data);
        req.setAppId("app1");
        req.setAccessKey("key1");
        req.setType("SOCIAL");

        assertThat(req.getData()).isSameAs(data);
        assertThat(req.getAppId()).isEqualTo("app1");
        assertThat(req.getAccessKey()).isEqualTo("key1");
        assertThat(req.getType()).isEqualTo("SOCIAL");
    }

    @Test
    public void antiFraudImageRequestGettersAndSetters() {
        AntiFraudImageRequest req = new AntiFraudImageRequest();
        AntiFraudImageRequestData data = new AntiFraudImageRequestData();
        data.setImg("base64data");
        req.setData(data);
        req.setAppId("app1");
        req.setAccessKey("key1");
        req.setType("POLITICS");

        assertThat(req.getData()).isSameAs(data);
        assertThat(req.getAppId()).isEqualTo("app1");
        assertThat(req.getAccessKey()).isEqualTo("key1");
        assertThat(req.getType()).isEqualTo("POLITICS");
    }

    @Test
    public void antiFraudImageRequestDataGettersAndSetters() {
        AntiFraudImageRequestData data = new AntiFraudImageRequestData();
        data.setImg("base64data");
        data.setImgs(java.util.Collections.emptyList());
        data.setChannel("ch1");
        data.setTokenId("tok1");
        data.setIp("1.2.3.4");
        data.setBtId("bt1");
        data.setSex(1);
        data.setAge(25);
        data.setImei("imei1");
        data.setMac("mac1");
        data.setIdfv("idfv1");
        data.setIdfa("idfa1");
        data.setMaxFrame(10);
        data.setInterval(2);

        assertThat(data.getImg()).isEqualTo("base64data");
        assertThat(data.getImgs()).isEmpty();
        assertThat(data.getChannel()).isEqualTo("ch1");
        assertThat(data.getTokenId()).isEqualTo("tok1");
        assertThat(data.getIp()).isEqualTo("1.2.3.4");
        assertThat(data.getBtId()).isEqualTo("bt1");
        assertThat(data.getSex()).isEqualTo(1);
        assertThat(data.getAge()).isEqualTo(25);
        assertThat(data.getImei()).isEqualTo("imei1");
        assertThat(data.getMac()).isEqualTo("mac1");
        assertThat(data.getIdfv()).isEqualTo("idfv1");
        assertThat(data.getIdfa()).isEqualTo("idfa1");
        assertThat(data.getMaxFrame()).isEqualTo(10);
        assertThat(data.getInterval()).isEqualTo(2);
    }

    @Test
    public void antiFraudImageRequestItemGettersAndSetters() {
        AntiFraudImageRequestItem item = new AntiFraudImageRequestItem();
        item.setBtId("bt1");
        item.setImg("img1");
        item.setTokenId("tok1");

        assertThat(item.getBtId()).isEqualTo("bt1");
        assertThat(item.getImg()).isEqualTo("img1");
        assertThat(item.getTokenId()).isEqualTo("tok1");
    }

    @Test
    public void antiFraudResponseGettersAndSetters() {
        AntiFraudResponse res = new AntiFraudResponse();
        res.setCode("1100");
        res.setMessage("success");
        res.setRequestId("req1");
        res.setScore(50);
        res.setRiskLevel("LOW");
        res.setStatus(1);
        res.setDetail("{\"riskType\":1}");

        assertThat(res.getCode()).isEqualTo("1100");
        assertThat(res.getMessage()).isEqualTo("success");
        assertThat(res.getRequestId()).isEqualTo("req1");
        assertThat(res.getScore()).isEqualTo(50);
        assertThat(res.getRiskLevel()).isEqualTo("LOW");
        assertThat(res.getStatus()).isEqualTo(1);
        assertThat(res.getDetail()).isEqualTo("{\"riskType\":1}");
    }

    @Test
    public void antiFraudDetailGettersAndSetters() {
        AntiFraudDetail detail = new AntiFraudDetail();
        detail.setRiskType(1);
        detail.setModel("model1");
        detail.setDescription("desc");
        detail.setDescriptionV2("desc2");

        assertThat(detail.getRiskType()).isEqualTo(1);
        assertThat(detail.getModel()).isEqualTo("model1");
        assertThat(detail.getDescription()).isEqualTo("desc");
        assertThat(detail.getDescriptionV2()).isEqualTo("desc2");
    }

    @Test
    public void antiFraudImageResponseGettersAndSetters() {
        AntiFraudImageResponse res = new AntiFraudImageResponse();
        res.setCode("1100");
        res.setMessage("success");
        res.setRequestId("req1");
        res.setScore(50);
        res.setRiskLevel("LOW");
        res.setStatus(1);
        res.setTaskId("task1");
        res.setDetail(new AntiFraudImageDetail());

        assertThat(res.getCode()).isEqualTo("1100");
        assertThat(res.getMessage()).isEqualTo("success");
        assertThat(res.getRequestId()).isEqualTo("req1");
        assertThat(res.getScore()).isEqualTo(50);
        assertThat(res.getRiskLevel()).isEqualTo("LOW");
        assertThat(res.getStatus()).isEqualTo(1);
        assertThat(res.getTaskId()).isEqualTo("task1");
        assertThat(res.getDetail()).isNotNull();
    }

    @Test
    public void antiFraudImageDetailGettersAndSetters() {
        AntiFraudImageDetail detail = new AntiFraudImageDetail();
        detail.setRiskType(1);
        detail.setModel("model1");
        detail.setDescription("desc");
        detail.setDescriptionV2("desc2");
        detail.setText("text");
        detail.setPornLabel("porn");
        detail.setPornRate(0.1f);
        detail.setSexyRate(0.2f);
        detail.setNormalRate(0.7f);
        detail.setPolityName("polity");
        detail.setPolityRate(0.05f);
        detail.setViolenceLabel("none");
        detail.setRebelRate(0.01f);
        detail.setFlagRate(0.01f);
        detail.setArmyRate(0.01f);
        detail.setTerrorismRate(0.01f);
        detail.setWeaponRate(0.01f);
        detail.setBloodRate(0.01f);
        detail.setGameWeaponRate(0.01f);
        detail.setChinamapRate(0.01f);
        detail.setTankRate(0.01f);
        detail.setCandleRate(0.01f);
        detail.setUniformRate(0.01f);
        detail.setNonViolenceRate(0.01f);
        detail.setHits(java.util.Collections.singletonList(new AntiFraudImageDetailHits()));
        detail.setOriginalText("orig");
        detail.setSexyRiskTokenId(1);
        detail.setRiskSource(1);

        assertThat(detail.getRiskType()).isEqualTo(1);
        assertThat(detail.getModel()).isEqualTo("model1");
        assertThat(detail.getPornRate()).isEqualTo(0.1f);
        assertThat(detail.getHits()).hasSize(1);
        assertThat(detail.getOriginalText()).isEqualTo("orig");
    }

    @Test
    public void antiFraudImageDetailHitsGettersAndSetters() {
        AntiFraudImageDetailHits hits = new AntiFraudImageDetailHits();
        hits.setRiskType(1);
        hits.setScore(80);
        hits.setDescription("desc");
        hits.setDescriptionV2("desc2");
        hits.setModel("model1");
        hits.setRiskLevel("HIGH");

        assertThat(hits.getRiskType()).isEqualTo(1);
        assertThat(hits.getScore()).isEqualTo(80);
        assertThat(hits.getDescription()).isEqualTo("desc");
        assertThat(hits.getModel()).isEqualTo("model1");
        assertThat(hits.getRiskLevel()).isEqualTo("HIGH");
    }

    @Test
    public void batchAntiFraudImageResponseGettersAndSetters() {
        BatchAntiFraudImageResponse res = new BatchAntiFraudImageResponse();
        res.setCode("1100");
        res.setMessage("success");
        res.setRequestId("req1");
        res.setImgs(java.util.Collections.singletonList(new BatchAntiFraudImageItem()));
        res.setStatistics(java.util.Arrays.asList(1, 2, 3, 4));

        assertThat(res.getCode()).isEqualTo("1100");
        assertThat(res.getMessage()).isEqualTo("success");
        assertThat(res.getRequestId()).isEqualTo("req1");
        assertThat(res.getImgs()).hasSize(1);
        assertThat(res.getStatistics()).hasSize(4);
    }

    @Test
    public void batchAntiFraudImageDetailGettersAndSetters() {
        BatchAntiFraudImageDetail detail = new BatchAntiFraudImageDetail();
        detail.setRiskType(1);
        detail.setModel("model1");
        detail.setDescription("desc");
        detail.setDescriptionV2("desc2");
        detail.setText("text");
        detail.setPornLabel("porn");
        detail.setPornRate(0.1f);
        detail.setSexyRate(0.2f);
        detail.setNormalRate(0.7f);
        detail.setHits(java.util.Collections.singletonList(new BatchAntiFraudImageDetailHits()));
        detail.setOriginalText("orig");

        assertThat(detail.getRiskType()).isEqualTo(1);
        assertThat(detail.getModel()).isEqualTo("model1");
        assertThat(detail.getPornRate()).isEqualTo(0.1f);
        assertThat(detail.getHits()).hasSize(1);
    }

    @Test
    public void batchAntiFraudImageDetailHitsGettersAndSetters() {
        BatchAntiFraudImageDetailHits hits = new BatchAntiFraudImageDetailHits();
        hits.setRiskType(1);
        hits.setScore(80);
        hits.setDescription("desc");
        hits.setDescriptionV2("desc2");
        hits.setModel("model1");
        hits.setRiskLevel("HIGH");

        assertThat(hits.getRiskType()).isEqualTo(1);
        assertThat(hits.getScore()).isEqualTo(80);
        assertThat(hits.getModel()).isEqualTo("model1");
    }

    @Test
    public void batchAntiFraudItemGettersAndSetters() {
        BatchAntiFraudImageItem item = new BatchAntiFraudImageItem();
        item.setBtId("bt1");
        item.setCode("1100");
        item.setMessage("success");
        item.setRequestId("req1");
        item.setRiskLevel("LOW");
        item.setScore(50);
        item.setDetail(new BatchAntiFraudImageDetail());

        assertThat(item.getBtId()).isEqualTo("bt1");
        assertThat(item.getCode()).isEqualTo("1100");
        assertThat(item.getMessage()).isEqualTo("success");
        assertThat(item.getRequestId()).isEqualTo("req1");
        assertThat(item.getRiskLevel()).isEqualTo("LOW");
        assertThat(item.getScore()).isEqualTo(50);
        assertThat(item.getDetail()).isNotNull();
    }

    @Test
    public void antiFraudVideoRequestGettersAndSetters() {
        AntiFraudVideoRequest req = new AntiFraudVideoRequest();
        req.setImgType("POLITICS");
        req.setAudioType("NONE");
        req.setSubtitleType("NONE");
        req.setBtId("bt1");
        AntiFraudVideoRequestData data = new AntiFraudVideoRequestData();
        data.setUrl("http://example.com/video.mp4");
        req.setData(data);
        req.setAppId("app1");
        req.setAccessKey("key1");

        assertThat(req.getImgType()).isEqualTo("POLITICS");
        assertThat(req.getAudioType()).isEqualTo("NONE");
        assertThat(req.getSubtitleType()).isEqualTo("NONE");
        assertThat(req.getBtId()).isEqualTo("bt1");
        assertThat(req.getData()).isSameAs(data);
        assertThat(req.getAppId()).isEqualTo("app1");
        assertThat(req.getAccessKey()).isEqualTo("key1");
    }

    @Test
    public void antiFraudVideoRequestDataGettersAndSetters() {
        AntiFraudVideoRequestData data = new AntiFraudVideoRequestData();
        data.setUrl("http://example.com/video.mp4");
        assertThat(data.getUrl()).isEqualTo("http://example.com/video.mp4");
    }

    @Test
    public void antiFraudVideoResponseGettersAndSetters() {
        AntiFraudVideoResponse res = new AntiFraudVideoResponse();
        res.setCode("1100");
        res.setMessage("success");
        res.setRequestId("req1");

        assertThat(res.getCode()).isEqualTo("1100");
        assertThat(res.getMessage()).isEqualTo("success");
        assertThat(res.getRequestId()).isEqualTo("req1");
    }

    @Test
    public void antiFraudTextWordPostitionsDetailGettersAndSetters() {
        AntiFraudTextWordPostitionsDetail detail = new AntiFraudTextWordPostitionsDetail();
        detail.setPosition("5");
        detail.setWord("bad");

        assertThat(detail.getPosition()).isEqualTo("5");
        assertThat(detail.getWord()).isEqualTo("bad");
    }

    // --- Custom method tests ---

    @Test
    public void antiFraudResponseIsSuccess() {
        AntiFraudResponse res = new AntiFraudResponse();
        res.setCode("1100");
        res.setStatus(0);
        res.setRiskLevel("PASS");
        assertThat(res.isSuccess()).isTrue();
        assertThat(res.isPass()).isTrue();
        assertThat(res.isReview()).isFalse();
        assertThat(res.isReject()).isFalse();
    }

    @Test
    public void antiFraudResponseIsNotSuccess() {
        AntiFraudResponse res = new AntiFraudResponse();
        res.setCode("1000");
        res.setStatus(0);
        assertThat(res.isSuccess()).isFalse();
    }

    @Test
    public void antiFraudResponseIsReview() {
        AntiFraudResponse res = new AntiFraudResponse();
        res.setCode("1100");
        res.setStatus(0);
        res.setRiskLevel("REVIEW");
        assertThat(res.isSuccess()).isTrue();
        assertThat(res.isReview()).isTrue();
    }

    @Test
    public void antiFraudResponseIsReject() {
        AntiFraudResponse res = new AntiFraudResponse();
        res.setCode("1100");
        res.setStatus(0);
        res.setRiskLevel("REJECT");
        assertThat(res.isSuccess()).isTrue();
        assertThat(res.isReject()).isTrue();
    }

    @Test
    public void antiFraudImageResponseIsSuccess() {
        AntiFraudImageResponse res = new AntiFraudImageResponse();
        res.setCode("1100");
        res.setStatus(0);
        res.setRiskLevel("PASS");
        assertThat(res.isSuccess()).isTrue();
        assertThat(res.isPass()).isTrue();
        assertThat(res.isReview()).isFalse();
        assertThat(res.isReject()).isFalse();
    }

    @Test
    public void antiFraudImageResponseIsNotSuccess() {
        AntiFraudImageResponse res = new AntiFraudImageResponse();
        res.setCode("1000");
        res.setStatus(0);
        assertThat(res.isSuccess()).isFalse();
    }

    @Test
    public void antiFraudImageResponseNullCode() {
        AntiFraudImageResponse res = new AntiFraudImageResponse();
        res.setStatus(0);
        assertThat(res.isSuccess()).isFalse();
    }

    @Test
    public void antiFraudImageResponseIsReview() {
        AntiFraudImageResponse res = new AntiFraudImageResponse();
        res.setCode("1100");
        res.setStatus(0);
        res.setRiskLevel("REVIEW");
        assertThat(res.isReview()).isTrue();
    }

    @Test
    public void antiFraudImageResponseIsReject() {
        AntiFraudImageResponse res = new AntiFraudImageResponse();
        res.setCode("1100");
        res.setStatus(0);
        res.setRiskLevel("REJECT");
        assertThat(res.isReject()).isTrue();
    }

    @Test
    public void batchAntiFraudImageResponseIsSuccess() {
        BatchAntiFraudImageResponse res = new BatchAntiFraudImageResponse();
        res.setCode("1100");
        assertThat(res.isSuccess()).isTrue();
    }

    @Test
    public void batchAntiFraudImageResponseIsNotSuccess() {
        BatchAntiFraudImageResponse res = new BatchAntiFraudImageResponse();
        res.setCode("1000");
        assertThat(res.isSuccess()).isFalse();
    }

    @Test
    public void batchAntiFraudImageResponseNullCode() {
        BatchAntiFraudImageResponse res = new BatchAntiFraudImageResponse();
        assertThat(res.isSuccess()).isFalse();
    }

    @Test
    public void batchAntiFraudImageItemIsPass() {
        BatchAntiFraudImageItem item = new BatchAntiFraudImageItem();
        item.setCode("1100");
        item.setRiskLevel("PASS");
        assertThat(item.isPass()).isTrue();
        assertThat(item.isReview()).isFalse();
        assertThat(item.isReject()).isFalse();
    }

    @Test
    public void batchAntiFraudImageItemIsReview() {
        BatchAntiFraudImageItem item = new BatchAntiFraudImageItem();
        item.setCode("1100");
        item.setRiskLevel("REVIEW");
        assertThat(item.isReview()).isTrue();
    }

    @Test
    public void batchAntiFraudImageItemIsReject() {
        BatchAntiFraudImageItem item = new BatchAntiFraudImageItem();
        item.setCode("1100");
        item.setRiskLevel("REJECT");
        assertThat(item.isReject()).isTrue();
    }

    @Test
    public void batchAntiFraudImageItemIsNotPass() {
        BatchAntiFraudImageItem item = new BatchAntiFraudImageItem();
        item.setCode("1000");
        item.setRiskLevel("PASS");
        assertThat(item.isPass()).isFalse();
    }
}
