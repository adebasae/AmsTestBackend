package com.ams.test.utilsGeneral.Response.Pojo;

import java.io.Serializable;

public class BaseResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    protected boolean hasError;
    protected String description ;
    protected BasePojo pojo;

    public BaseResponse() {

    }

    public BaseResponse(BasePojo pojo) {

        super();
        this.pojo = pojo;
    }

    public boolean isHasError() {
        return hasError;
    }

    public void setHasError(boolean hasError) {
        this.hasError = hasError;
    }

    public String getDescription () {
        return description;
    }

    public void setDescription (String descriptionError) {
        this.description = descriptionError;
    }

    public BasePojo getPojo() {
        return pojo;
    }

    public void setPojo(BasePojo pojo) {
        this.pojo = pojo;
    }
}
