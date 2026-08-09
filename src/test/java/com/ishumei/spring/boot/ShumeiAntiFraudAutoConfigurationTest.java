package com.ishumei.spring.boot;

import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.AutoConfigurations;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for {@link ShumeiAntiFraudAutoConfiguration}.
 *
 * @author [@Loong Wan](https://github.com/loong10k)
 * @since 1.0.0
 */
public class ShumeiAntiFraudAutoConfigurationTest {

    private final ApplicationContextRunner contextRunner = new ApplicationContextRunner()
            .withConfiguration(AutoConfigurations.of(ShumeiAntiFraudAutoConfiguration.class));

    @Test
    public void templateBeanCreated() {
        this.contextRunner
                .withPropertyValues(
                        "shumei.anti-fraud.access-key=testKey",
                        "shumei.anti-fraud.app-id=testApp"
                )
                .run(context -> {
                    assertThat(context).hasSingleBean(ShumeiAntiFraudTemplate.class);
                    assertThat(context).hasSingleBean(ShumeiAntiFraudProperties.class);
                    ShumeiAntiFraudProperties props = context.getBean(ShumeiAntiFraudProperties.class);
                    assertThat(props.getAccessKey()).isEqualTo("testKey");
                    assertThat(props.getAppId()).isEqualTo("testApp");
                });
    }

    @Test
    public void templateBeanWithCustomProperties() {
        this.contextRunner
                .withPropertyValues(
                        "shumei.anti-fraud.access-key=myKey",
                        "shumei.anti-fraud.app-id=myApp",
                        "shumei.anti-fraud.type=ECOM",
                        "shumei.anti-fraud.channel-txt=myChTxt",
                        "shumei.anti-fraud.channel-img=myChImg"
                )
                .run(context -> {
                    assertThat(context).hasSingleBean(ShumeiAntiFraudTemplate.class);
                    ShumeiAntiFraudProperties props = context.getBean(ShumeiAntiFraudProperties.class);
                    assertThat(props.getAccessKey()).isEqualTo("myKey");
                    assertThat(props.getAppId()).isEqualTo("myApp");
                    assertThat(props.getType()).isEqualTo("ECOM");
                    assertThat(props.getChannelTxt()).isEqualTo("myChTxt");
                    assertThat(props.getChannelImg()).isEqualTo("myChImg");
                });
    }
}
