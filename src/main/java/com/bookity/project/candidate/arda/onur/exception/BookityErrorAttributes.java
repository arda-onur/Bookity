package com.bookity.project.candidate.arda.onur.exception;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@Component
public class BookityErrorAttributes extends DefaultErrorAttributes {
    private final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private final String apiVersion;

    public BookityErrorAttributes(@Value("${api-version}") String apiVersion) {
        this.apiVersion = apiVersion;
    }

    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, ErrorAttributeOptions options) {
        Map<String, Object> errorAttributes = super.getErrorAttributes(webRequest,
            options.including(ErrorAttributeOptions.Include.MESSAGE));

        removeTrace(errorAttributes);
        rectifyTimestampFormat(errorAttributes);
        addVersion(errorAttributes, this.apiVersion);

        return errorAttributes;
    }

    private void addVersion(Map<String, Object> errorAttributes, String apiVersion) {
        errorAttributes.put("api-version", apiVersion);
    }

    private void rectifyTimestampFormat(Map<String, Object> errorAttributes) {
        errorAttributes.put("timestamp", dateFormat.format((Date) errorAttributes.get("timestamp")));
    }

    private void removeTrace(Map<String, Object> errorAttributes) {
        errorAttributes.remove("trace");
    }
}
