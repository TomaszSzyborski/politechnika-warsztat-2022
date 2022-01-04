package com.warsztat.base;

import java.io.InputStream;
import java.util.Properties;

import lombok.Getter;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
public class PropertySupplier {

    private final String url;
    private final Boolean remoteRun;
    private final String gridUrl;

    @SneakyThrows
    public PropertySupplier() {
        Properties properties = new Properties();
        InputStream propertiesStream =
            this.getClass().getClassLoader().getResourceAsStream("configuration.properties");
        properties.load(propertiesStream);
        url = properties.getProperty("url");
        remoteRun = Boolean.parseBoolean(properties.getProperty("remote.run"));
        gridUrl = properties.getProperty("grid.url");
    }
}
