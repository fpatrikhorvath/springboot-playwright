package com.playwright.framework.context;


import com.playwright.framework.playwright.model.ContextUser;
import io.cucumber.spring.ScenarioScope;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
@ScenarioScope
public class ScenarioCxt {
    private final HashMap<String, Object>      cxtObjects = new HashMap<>();
    private final HashMap<String, ContextUser> cxtUsers   = new HashMap<>();

    public ScenarioCxt() {
    }

    public void storeContextObject(final String key, final Object object) {
        cxtObjects.put(key, object);
    }

    public Object getContextObject(final String key) {
        return cxtObjects.get(key);
    }

    public void storeCxtUser(final String key, final ContextUser user) {
        cxtUsers.put(key, user);
    }

    public ContextUser getCxtUser(final String key) {
        return cxtUsers.get(key);
    }
}
