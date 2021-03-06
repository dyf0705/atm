package com.github.herowzz.atm.generator;

import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.herowzz.atm.model.Config;

/**
 * Properties构造器
 * @author wangzz
 */
public class PropertiesBuilder {

	private static Logger logger = LoggerFactory.getLogger(PropertiesBuilder.class);

	/**
	 * 加载config.properties配置文件
	 */
	public static void buildConfig() {
		Properties properties = new Properties();
		InputStream inputStream = Object.class.getResourceAsStream("/config.properties");
		try {
			properties.load(inputStream);
			Config.Product = properties.get("product").toString();
			Config.Url = properties.get("url").toString();
			Config.Version = properties.get("version").toString();
			Config.OutputPath = properties.get("outputPath").toString();
			logger.error("加载配置:" + Config.show());
		} catch (Exception e) {
			logger.error("加载config.properties异常!", e);
			System.exit(1);
		}
	}

}
