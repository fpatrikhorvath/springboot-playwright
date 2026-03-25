package com.playwright.framework.playwright;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class PageObjectFactory {

    private final ApplicationContext context;

    public PageObjectFactory(final ApplicationContext context) {
        this.context = context;
    }

    public <T> T getPage(final Class<T> pageClass) {
        return context.getBean(pageClass);
    }
}