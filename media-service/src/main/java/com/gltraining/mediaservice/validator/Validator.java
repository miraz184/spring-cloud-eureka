package com.gltraining.mediaservice.validator;

import com.gltraining.mediaservice.exception.InvalidArgumentException;
import org.springframework.stereotype.Component;

@Component
public class Validator {
    public Boolean widthResolutionValidator(Integer resolution) throws InvalidArgumentException {
        if(resolution==480 || resolution==640 || resolution==1080){
            return true;
        }
        throw new InvalidArgumentException("width resolution must be 480 or 680 or 1080");
    }

    public Boolean heightResolutionValidator(Integer resolution) throws InvalidArgumentException {
        if(resolution==620 || resolution==760 || resolution==1400){
            return true;
        }
        throw new InvalidArgumentException("height resolution must be 620 or 760 or 1480");
    }
}
