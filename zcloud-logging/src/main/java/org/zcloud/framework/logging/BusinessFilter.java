package org.zcloud.framework.logging;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.filter.Filter;
import ch.qos.logback.core.spi.FilterReply;
import org.zcloud.framework.logging.event.BusinessType;

import java.util.Map;

public class BusinessFilter extends Filter<ILoggingEvent> {
    public final static String MDC_BUSINESS = "business";
    private BusinessType businessType;

    public void setBusinessType(BusinessType businessType) {
        this.businessType = businessType;
    }

    @Override
    public FilterReply decide(ILoggingEvent event) {
        Map<String, String> mdc = event.getMDCPropertyMap();
        String val = mdc.get(MDC_BUSINESS);
        if (existBusiness(mdc) && matchBusiness(Integer.parseInt(val)))
            return FilterReply.ACCEPT;
        return FilterReply.DENY;
    }

    private boolean matchBusiness(int val) {
        return businessType.getValue() == val;
    }

    private boolean existBusiness(Map<String, String> mdc) {
        return mdc.containsKey(MDC_BUSINESS);
    }
}
