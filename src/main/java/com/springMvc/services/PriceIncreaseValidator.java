package com.springMvc.services;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Created by obouras on 06/08/2014.
 */
public class PriceIncreaseValidator implements Validator {
    private int DEFAULT_MIN_PERCENTAGE = 0;
    private int DEFAULT_MAX_PERCENTAGE = 50;
    private int minPercentage = DEFAULT_MIN_PERCENTAGE;
    private int maxPercentage = DEFAULT_MAX_PERCENTAGE;

    /** Logger for this class and subclasses */
    protected final Log logger = LogFactory.getLog(getClass());

    public boolean supports(Class clazz) {
        return PriceIncrease.class.equals(clazz);
    }

    public void validate(Object obj, Errors errors) {
        PriceIncrease priceIncrease=(PriceIncrease) obj;
        if (priceIncrease == null) {
            errors.rejectValue("percentage", "error.not-specified", null, "Value required.");
        }
        else{
            logger.info("Validating with " + priceIncrease + ": " + priceIncrease.getPercentage());
            if (priceIncrease.getPercentage() > maxPercentage) {
                errors.rejectValue("percentage", "error.too-high",
                        new Object[] {new Integer(maxPercentage)}, "Value too high.");
            }
            if (priceIncrease.getPercentage() <= minPercentage) {
                errors.rejectValue("percentage", "error.too-low",
                        new Object[] {new Integer(minPercentage)}, "Value too low.");
            }
        }
    }

    public int getMinPercentage() {
        return minPercentage;
    }

    public void setMinPercentage(int minPercentage) {
        this.minPercentage = minPercentage;
    }

    public int getMaxPercentage() {
        return maxPercentage;
    }

    public void setMaxPercentage(int maxPercentage) {
        this.maxPercentage = maxPercentage;
    }
}
