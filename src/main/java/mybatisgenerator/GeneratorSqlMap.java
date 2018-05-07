package mybatisgenerator;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;

/**
 * 参照写出MyBatis逆向工程
 * @author Zy
 *
 */
public class GeneratorSqlMap {

	//statr
	public static void main(String[] args) throws Exception {
		GeneratorSqlMap gs = new GeneratorSqlMap();
		gs.generator();
	}
	
	//逆向工程方法体
	public void generator() throws Exception{
		List<String> warnings = new ArrayList<String>();
		boolean overwrite = true;
		//
		File configFile = new File("./src/main/resources/generatorConfig.xml");
		ConfigurationParser cp = new ConfigurationParser(warnings);
		Configuration config = cp.parseConfiguration(configFile);
		DefaultShellCallback dsc = new DefaultShellCallback(overwrite);
		MyBatisGenerator mybg = new MyBatisGenerator(config, dsc, warnings);
		System.out.println("...");
		mybg.generate(null);
	}
}
