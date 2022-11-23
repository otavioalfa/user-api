package br.com.user.registration.config;

import com.google.common.collect.Lists;
import org.springframework.boot.env.PropertySourceLoader;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;
import java.util.PropertyResourceBundle;

public class ConfigPropertiesUTF8 implements PropertySourceLoader {

    @Override
    public String[] getFileExtensions() {
        return new String[] { "properties" };
    }

    @Override
    public List<PropertySource<?>> load(String name, Resource resource) throws IOException {
        Properties properties = new Properties();
        PropertyResourceBundle bundle = new PropertyResourceBundle(
                new InputStreamReader(resource.getInputStream(), "UTF-8"));
        Enumeration<String> keys = bundle.getKeys();
        while (keys.hasMoreElements()) {
            String key = keys.nextElement();
            properties.setProperty(key, bundle.getString(key));
        }
        if (!properties.isEmpty()) {
            return Lists.newArrayList(new PropertiesPropertySource(name, properties));
        }
        return null;
    }

}
