package com.company.score.autoconfigure;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
@Conditional(ScoreAutoConfigureCondition.class)
@EnableConfigurationProperties(ScoreProperties.class)
public class NameScoreAutoConfiguration {

    private static final Logger LOG = LoggerFactory
        .getLogger(NameScoreAutoConfiguration.class);

    private ScoreProperties scoreProps;

    @Autowired
    public void setScoreProps(ScoreProperties scoreProps) {
	this.scoreProps = scoreProps;
    }

    @Bean
    @ConditionalOnMissingBean
    public Score scoreService() {
	LOG.info("Auto Configuring Score Service...");
	ScoreService scoreService = new ScoreService();
	scoreService.setFilePath(this.scoreProps.getFilePath());
	scoreService.setDelimeter(this.scoreProps.getDelimiter());
	scoreService.setParallel(this.scoreProps.isParallel());
	return scoreService;
    }

}
