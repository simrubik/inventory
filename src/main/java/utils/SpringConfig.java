package utils;

import java.util.Collections;
import java.util.List;
import java.util.Locale;

import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@Import(DatabaseConfig.class)
@ComponentScan(basePackages = { "storage", "service", "controller", "dto", "serviceAggregation", "annotation" })
@EnableTransactionManagement
@EnableWebMvc
public class SpringConfig extends WebMvcConfigurerAdapter {

	@Autowired
	DatabaseConfig databaseConfig;

	@Bean
	public HibernateJpaVendorAdapter jpaVendorAdapter() {
		HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
		jpaVendorAdapter.setDatabase(Database.POSTGRESQL);
		jpaVendorAdapter.setShowSql(true);
		jpaVendorAdapter.setGenerateDdl(false);
		jpaVendorAdapter.setDatabasePlatform("org.hibernate.dialect.PostgreSQLDialect");
		return jpaVendorAdapter;
	}

	@Bean
	public EntityManagerFactory entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
		emf.setDataSource(databaseConfig.dataSource());
		emf.setJpaVendorAdapter(jpaVendorAdapter());
		emf.setPackagesToScan("model");
		return emf.getObject();
	}

	@Bean
	public PlatformTransactionManager transactionManager() {
		JpaTransactionManager txManager = new JpaTransactionManager();
		txManager.setEntityManagerFactory(entityManagerFactory());
		return txManager;
	}

	@Bean
	public ViewResolver getViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}

	// equivalents for <mvc:resources/> tags
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}

	@Bean
	public MappingJackson2HttpMessageConverter jsonMessageConverter() {
		MappingJackson2HttpMessageConverter jsonMessageConverter = new MappingJackson2HttpMessageConverter();
		return jsonMessageConverter;
	}

	@Bean
	public RequestMappingHandlerAdapter requestMappingHandlerAdapter() {
		RequestMappingHandlerAdapter requestMappingAdapter = new RequestMappingHandlerAdapter();
		List<HttpMessageConverter<?>> list = Collections.emptyList();
		list.add(jsonMessageConverter());
		requestMappingAdapter.setMessageConverters(list);
		return requestMappingAdapter;
	}

	@Bean
	public ReloadableResourceBundleMessageSource messageSource() {
		ReloadableResourceBundleMessageSource reloadableResourceBundleMessageSource = new ReloadableResourceBundleMessageSource();
		reloadableResourceBundleMessageSource.setBasename("classpath:properties/messages");
		reloadableResourceBundleMessageSource.setDefaultEncoding("UTF-8");
		return reloadableResourceBundleMessageSource;
	}

	@Bean
	public LocaleResolver localeResolver() {
		SessionLocaleResolver resolver = new SessionLocaleResolver();
		resolver.setDefaultLocale(new Locale("en"));
		return resolver;
	}

	@Bean
	public LocaleChangeInterceptor localeChangeInterceptor() {
		LocaleChangeInterceptor localInterceptor = new LocaleChangeInterceptor();
		localInterceptor.setParamName("language");
		return localInterceptor;
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(localeChangeInterceptor());
	}
}
